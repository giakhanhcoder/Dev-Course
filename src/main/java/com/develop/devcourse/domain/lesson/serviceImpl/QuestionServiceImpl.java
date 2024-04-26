package com.develop.devcourse.domain.lesson.serviceImpl;

import com.develop.devcourse.domain.lesson.dto.request.QuestionRequest;
import com.develop.devcourse.domain.lesson.dto.response.QuestionResponse;
import com.develop.devcourse.domain.lesson.exception.LessonException;
import com.develop.devcourse.domain.lesson.model.Question;
import com.develop.devcourse.domain.lesson.repository.QuestionRepository;
import com.develop.devcourse.domain.lesson.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    public final QuestionRepository questionRepository;
    public final ModelMapper modelMapper;
    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<QuestionResponse> findAllQuestions() {
//        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return findAll().stream()
                .map(question -> {
                    QuestionResponse response = modelMapper.map(question,QuestionResponse.class);
                    response.setLessonId(question.getLesson().getLessonId());
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public QuestionResponse findById(Long id) throws LessonException {
        Question question = questionRepository.findById(id).orElseThrow(()-> LessonException.notFound("Could not find with ID!"));
        return modelMapper.map(question, QuestionResponse.class);
    }

    @Override
    public Question save(QuestionRequest questionRequest) throws LessonException {
        Question question = modelMapper.map(questionRequest, Question.class);
        return questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) throws LessonException{
        questionRepository.deleteById(id);
    }

    @Override
    public List<QuestionResponse> findAllByLessonLessonId(Long lessonId) {
        return questionRepository.findAllByLessonLessonId(lessonId).stream()
                .map(question -> {
                    QuestionResponse response = modelMapper.map(question,QuestionResponse.class);
                    response.setLessonId(question.getLesson().getLessonId());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
