package com.develop.devcourse.domain.student.servicesImpl;

import com.develop.devcourse.domain.lesson.dto.request.AnswerRequest;
import com.develop.devcourse.domain.student.exception.StuentException;
import com.develop.devcourse.domain.student.model.StudentAnswer;
import com.develop.devcourse.domain.student.repository.StudentAnswerRepository;
import com.develop.devcourse.domain.student.service.StudentAnswerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentAnswerServiceImpl implements StudentAnswerService {
    private final ModelMapper modelMapper;
    private final StudentAnswerRepository studentAnswerRepository;
    @Override
    public List<StudentAnswer> save(List<AnswerRequest> answerRequests) throws StuentException {
        List<StudentAnswer> studentAnswers = answerRequests.stream()
                .map(answerRequest -> modelMapper.map(answerRequest,StudentAnswer.class))
                .map(studentAnswerRepository::save)
                .toList();
        return studentAnswers;
    }
}
