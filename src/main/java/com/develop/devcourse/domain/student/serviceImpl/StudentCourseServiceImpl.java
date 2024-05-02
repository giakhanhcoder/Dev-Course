package com.develop.devcourse.domain.student.serviceImpl;

import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import com.develop.devcourse.domain.student.dto.response.StudentCourseResponse;
import com.develop.devcourse.domain.student.model.StudentCourse;
import com.develop.devcourse.domain.student.repository.StudentCourseRepository;
import com.develop.devcourse.domain.student.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentCourseServiceImpl implements StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentCourseResponse> getStudentCourse() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<StudentCourse> courses = studentCourseRepository.findAllByStudentId(userDetails.getId());
        return courses.stream().map(
                studentCourse -> StudentCourseResponse.builder()
                        .courseId(studentCourse.getCourse().getCourseId())
                        .courseDes(studentCourse.getCourse().getCourseDes())
                        .courseName(studentCourse.getCourse().getCourseName())
                        .coursePrice(studentCourse.getCourse().getCoursePrice())
                        .duration(studentCourse.getCourse().getDuration())
                        .imageCourseUrl(studentCourse.getCourse().getImageCourseUrl())
                        .isActive(studentCourse.getCourse().isActive())
                        .categoryName(studentCourse.getCourse().getCategory().getCategoryName())
                        .courseTitle(studentCourse.getCourse().getCourseTitle())
                        .courseRate(studentCourse.getCourseScore())
                        .courseFeedback(studentCourse.getCourseFeedback())
                        .registerDate(studentCourse.getRegisterDate())
                        .build()
        ).collect(Collectors.toList());
    }
}
