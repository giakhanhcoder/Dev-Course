package com.develop.devcourse.domain.student.servicesImpl;

import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
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
}
