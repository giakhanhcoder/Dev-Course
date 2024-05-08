package com.develop.devcourse.domain.course.serviceImpl;

import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.request.CourseRequest;
import com.develop.devcourse.domain.course.dto.response.CourseResponse;
import com.develop.devcourse.domain.course.exception.CourseException;
import com.develop.devcourse.domain.course.model.Category;
import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.course.repository.CategoryRepository;
import com.develop.devcourse.domain.course.repository.CourseRepository;
import com.develop.devcourse.domain.course.service.CourseService;
import com.develop.devcourse.domain.mentor.exeption.MentorException;
import com.develop.devcourse.domain.mentor.model.Mentor;
import com.develop.devcourse.domain.mentor.repository.MentorRepository;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final MentorRepository mentorRepository;

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

    @Override
    public MessageResponse postCourse(CourseRequest courseRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = categoryRepository.findByCategoryId(courseRequest.getCategoryId());
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        if (category == null) {
            throw new CourseException("Not found that category");
        }
        if (mentor == null) {
            throw new MentorException("You are not a mentor. Please register to be mentor");
        }
        Course course = modelMapper.map(courseRequest, Course.class);
        course.setCategory(category);
        course.setMentor(mentor);
        courseRepository.save(course);
        return MessageResponse.builder()
                .message("Post course successfully")
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public MessageResponse updateCourse(CourseRequest courseRequest, String courseId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = categoryRepository.findByCategoryId(courseRequest.getCategoryId());
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        Course course = courseRepository.findByCourseId(courseId);
        if (category == null) {
            throw new CourseException("Not found that category");
        }
        if (mentor == null) {
            throw new MentorException("You are not a mentor. Please register to be mentor");
        }
        if (course == null) {
            throw new CourseException("Not found that course");
        }
        if(!course.getMentor().getMentorId().equalsIgnoreCase(mentor.getMentorId())){
            throw new MentorException("You cannot update another mentor's course");

        }
        course.setCourseDes(courseRequest.getCourseDes());
        course.setCourseName(courseRequest.getCourseName());
        course.setCoursePrice(courseRequest.getCoursePrice());
        course.setCourseTitle(courseRequest.getCourseTitle());
        course.setActive(courseRequest.isActive());
        course.setImageCourseUrl(courseRequest.getImageCourseUrl());
        course.setDuration(courseRequest.getDuration());
        course.setCategory(category);
        course.setMentor(mentor);
        courseRepository.save(course);
        return MessageResponse.builder()
                .message("Update course successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public MessageResponse deleteCourseById(String courseId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        Course course = courseRepository.findByCourseId(courseId);
        if (mentor == null) {
            throw new MentorException("You are not a mentor. Please register to be mentor");
        }
        if(!course.getMentor().getMentorId().equalsIgnoreCase(mentor.getMentorId())){
            throw new MentorException("You cannot delete another mentor's course");
        }
        courseRepository.delete(course);
        return MessageResponse.builder()
                .message("Delete course successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public List<CourseResponse> findAllByMentorId() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        if(mentor == null){
            throw new MentorException("You are not a mentor. Please register to be mentor");
        }
        List<Course> courses = courseRepository.findAllByMentor(mentor);
        if(courses.isEmpty()){
            throw new MentorException("You don't have any courses. Please post some course to view");
        }
        List<CourseResponse> courseResponses = courses.stream().map(course -> {
            CourseResponse response = modelMapper.map(course, CourseResponse.class);
            response.setCategoryName(course.getCategory().getCategoryName());
            response.setUserId(mentor.getMentorId());
            return response;
        }).toList();
        return courseResponses;
    }

}
