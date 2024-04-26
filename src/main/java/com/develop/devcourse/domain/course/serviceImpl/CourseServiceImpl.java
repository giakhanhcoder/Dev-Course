package com.develop.devcourse.domain.course.serviceImpl;

import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.course.exeption.CourseException;
import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.course.repository.CourseRepository;
import com.develop.devcourse.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;

    @Override
    public PageResponseDto<CourseResponse> findAllCourse(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);

        List<CourseResponse> data = page
                .getContent().stream()
                .map(course -> {
                    CourseResponse response = modelMapper.map(course, CourseResponse.class);
                    response.setCategoryName(course.getCategory().getCategoryName());
                    return response;
                })
                .collect(Collectors.toList());


        PageResponseDto<CourseResponse> pageResponseDto = new PageResponseDto<>();
        pageResponseDto.setData(data);
        pageResponseDto.setTotalPage(page.getTotalPages());
        pageResponseDto.setSize(page.getSize());
        pageResponseDto.setPageNumber(page.getNumber());
        pageResponseDto.setSort(page.getSort().toString());


        return pageResponseDto;
    }

    @Override
    public List<CourseResponse> findAllByCourseNameOrDescription(String keyword) {
        List<Course> courses = courseRepository.findAllByCourseNameContainingOrCourseDesContaining(keyword, keyword);
        if (courses.isEmpty()) {
            throw new CourseException("Not found course with name or description");
        } else {
            return courses.stream().map(course -> {
                        CourseResponse response = modelMapper.map(course, CourseResponse.class);
                        response.setCategoryName(course.getCategory().getCategoryName());
                        return response;
                    })
                    .collect(Collectors.toList());
        }
    }

    @Override
    public CourseResponse findCourseById(String courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        if (course == null) {
            throw new CourseException("Not found course with that id");
        } else {
            CourseResponse courseResponse = modelMapper.map(course, CourseResponse.class);
            courseResponse.setCategoryName(course.getCategory().getCategoryName());
            return courseResponse;
        }
    }
}
