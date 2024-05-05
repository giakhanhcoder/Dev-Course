package com.develop.devcourse.domain.student.serviceImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.lesson.model.AssignmentScore;
import com.develop.devcourse.domain.lesson.model.AssignmentScoreId;
import com.develop.devcourse.domain.lesson.model.Lesson;
import com.develop.devcourse.domain.lesson.repository.AssignmentScoreRepository;
import com.develop.devcourse.domain.lesson.repository.LessonRepository;
import com.develop.devcourse.domain.lesson.repository.QuestionRepository;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import com.develop.devcourse.domain.student.exception.StudentException;
import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.model.StudentAnswer;
import com.develop.devcourse.domain.student.model.StudentAnswerId;
import com.develop.devcourse.domain.student.repository.StudentAnswerRepository;
import com.develop.devcourse.domain.student.repository.StudentRepository;
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
    private final AssignmentScoreRepository assignmentScoreRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    @Override
    public void save(List<AnswerRequest> answerRequests) throws StudentException {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentRepository.findById(userDetails.getId()).orElseThrow();
        List<StudentAnswer> studentAnswers = answerRequests.stream().map(answerRequest -> {
                    StudentAnswer studentAnswer = modelMapper.map(answerRequest, StudentAnswer.class);
                    StudentAnswerId studentAnswerId = new StudentAnswerId();
                    studentAnswer.setStudentAnswerId(studentAnswerId);
                    studentAnswer.getStudentAnswerId().setUserId(userDetails.getId());
                    studentAnswer.getStudentAnswerId().setQuestionId(answerRequest.getQuestionId());
                    studentAnswer.setStudent(student);
                    studentAnswer.setQuestion(questionRepository.findById(answerRequest.getQuestionId()).orElseThrow());
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
        Student student = studentRepository.findById(userDetails.getId()).orElseThrow();
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();
        AssignmentScore assignmentScore = new AssignmentScore();
        AssignmentScoreId assignmentScoreId = new AssignmentScoreId();
        assignmentScoreId.setUserId(userDetails.getId());
        assignmentScoreId.setLessonId(lessonId);
        assignmentScore.setAssignmentScoreId(assignmentScoreId);
        assignmentScore.setScore(score);
        assignmentScore.setLesson(lesson);
        assignmentScore.setStudent(student);
        assignmentScoreRepository.save(assignmentScore);
        return score;
    }
}
