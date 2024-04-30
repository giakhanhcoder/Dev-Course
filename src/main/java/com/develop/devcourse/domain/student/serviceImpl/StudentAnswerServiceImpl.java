package com.develop.devcourse.domain.student.serviceImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.lesson.repository.QuestionRepository;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import com.develop.devcourse.domain.student.exception.StudentException;
import com.develop.devcourse.domain.student.model.StudentAnswer;
import com.develop.devcourse.domain.student.model.StudentAnswerId;
import com.develop.devcourse.domain.student.repository.StudentAnswerRepository;
import com.develop.devcourse.domain.student.service.StudentAnswerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentAnswerServiceImpl implements StudentAnswerService {
    private final ModelMapper modelMapper;
    private final StudentAnswerRepository studentAnswerRepository;
    private final QuestionRepository questionRepository;

    @Override
    public void save(List<AnswerRequest> answerRequests) throws StudentException {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<StudentAnswer> studentAnswers = answerRequests.stream().map(answerRequest -> {
                    StudentAnswer studentAnswer = modelMapper.map(answerRequest, StudentAnswer.class);
                    StudentAnswerId studentAnswerId = new StudentAnswerId();
                    studentAnswer.setStudentAnswerId(studentAnswerId);
                    studentAnswer.getStudentAnswerId().setUserId(userDetails.getId());
                    studentAnswer.getStudentAnswerId().setQuestionId(answerRequest.getQuestionId());
                    return studentAnswer;
                })
                .toList();

        studentAnswerRepository.saveAll(studentAnswers);
    }

    @Override
    public List<String> getStudentAnswerByLessonId(Long lessonId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> studentAnswer = studentAnswerRepository.getStudentAnswerByLessonId(lessonId, userDetails.getId());
        if (studentAnswer.isEmpty()){
            throw DomainException.notFound("Not found answer");
        }else{
            return studentAnswer;
        }
    }

    @Override
    public double calculateScoreOfLesson(Long lessonId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> studentAnswer = studentAnswerRepository.getStudentAnswerByLessonId(lessonId, userDetails.getId());
        List<String> answerOfLesson = questionRepository.getCorrectAnswerByLessonId(lessonId);
        if (studentAnswer.isEmpty()){
            throw DomainException.notFound("You need to do the test to see your score");
        }
        double calculateScore = 0;
        int total = questionRepository.countQuestionByLessonId(lessonId);
        for (int i = 0; i < total; i++){
            if(studentAnswer.get(i).equalsIgnoreCase(answerOfLesson.get(i))){
                calculateScore++;
            }
        }
        double score = (calculateScore / total) * 10;
        return score;
    }
}
