package com.develop.devcourse.domain.lesson.serviceImpl;

import com.develop.devcourse.domain.course.model.Section;
import com.develop.devcourse.domain.course.repository.SectionRepository;
import com.develop.devcourse.domain.lesson.dto.request.LessonRequest;
import com.develop.devcourse.domain.lesson.dto.response.LessonResponse;
import com.develop.devcourse.domain.lesson.exception.LessonException;
import com.develop.devcourse.domain.lesson.model.Lesson;
import com.develop.devcourse.domain.lesson.repository.LessonRepository;
import com.develop.devcourse.domain.lesson.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final SectionRepository sectionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(Long lessonId) throws LessonException {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> LessonException.notFound("Could not found Id!"));
    }

    @Override
    public Lesson save(LessonRequest lessonRequest) {
        return null;
    }

    @Override
    public void deleteById(Long lessonId) {

    }

    @Override
    public List<LessonResponse> getAllLessonByCourseId(String courseId) {
        List<Section> sectionList = sectionRepository.findByCourseCourseId(courseId);

        return sectionList.stream().map(
                section -> {
                    Long sectionId = section.getSectionId();
                    String sectionName = section.getSectionName();
                    List<Lesson> lessonList = lessonRepository.findBySectionId(sectionId);
                    return LessonResponse.builder()
                            .sectionId(sectionId)
                            .sectionName(sectionName)
                            .data(lessonList).
                            build();
                }
        ).toList();
    }
}
