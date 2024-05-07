package com.develop.devcourse.domain.course.serviceImpl;

import com.develop.devcourse.domain.course.dto.request.SectionRequest;
import com.develop.devcourse.domain.course.dto.response.SectionResponse;
import com.develop.devcourse.domain.course.exeption.CourseException;
import com.develop.devcourse.domain.course.model.Course;
import com.develop.devcourse.domain.course.model.Section;
import com.develop.devcourse.domain.course.repository.CourseRepository;
import com.develop.devcourse.domain.course.repository.SectionRepository;
import com.develop.devcourse.domain.course.service.SectionService;
import com.develop.devcourse.domain.mentor.exeption.MentorException;
import com.develop.devcourse.domain.mentor.model.Mentor;
import com.develop.devcourse.domain.mentor.repository.MentorRepository;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final MentorRepository mentorRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<SectionResponse> findAllSectionByCourseId(String courseId) {
//        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
//        if (mentor == null) {
//            throw new MentorException("You must register to be mentor to find your section course");
//        }
//        Course course = courseRepository.findByMentorAndCourseId(mentor, courseId);
//        if (course == null) {
//            throw new MentorException("You can not view all section from that course because it belong to another mentor");
//        }
        Mentor mentor = checkExistRoleMentor();
        Course course = checkExistCourse(mentor, courseId);

        List<Section> sectionList = sectionRepository.findByCourseCourseId(course.getCourseId());
        if (sectionList == null) {
            throw new CourseException("Not found any section in this course");
        }
        List<SectionResponse> sectionResponses = sectionList.stream().map(section -> {
                    SectionResponse sectionResponse = modelMapper.map(section, SectionResponse.class);
                    sectionResponse.setCourseId(section.getCourse().getCourseId());
                    return sectionResponse;
                })
                .collect(Collectors.toList());
        return sectionResponses;
    }

    @Override
    public MessageResponse postSectionToCourseId(List<SectionRequest> sectionRequests, String courseId) {
//        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
//        if (mentor == null) {
//            throw new MentorException("You must register to be mentor to find your section course");
//        }
//        Course course = courseRepository.findByMentorAndCourseId(mentor, courseId);
//        if (course == null) {
//            throw new MentorException("You can not view all section from that course because it belong to another mentor");
//        }
        Mentor mentor = checkExistRoleMentor();
        Course course = checkExistCourse(mentor, courseId);

        List<Section> sectionList = sectionRequests.stream().map(sectionRequest -> {
            Section section = modelMapper.map(sectionRequest, Section.class);
            section.setCourse(course);
            return section;
        }).collect(Collectors.toList());

        sectionRepository.saveAll(sectionList);
        return MessageResponse.builder()
                .message("Post section into course successfully")
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Transactional
    @Override
    public MessageResponse updateSectionByCourseAndSectionId(SectionRequest sectionRequest, Long sectionId, String courseId) {
        Mentor mentor = checkExistRoleMentor();
        Course course = checkExistCourse(mentor, courseId);
        Section section = checkExistSection(sectionId, course);
        section.setSectionName(sectionRequest.getSectionName());
        sectionRepository.save(section);
        return MessageResponse.builder()
                .message("Update section in course successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }
    @Transactional
    @Override
    public MessageResponse deleteSectionByCourseAndSectionId(Long sectionId, String courseId) {
        Mentor mentor = checkExistRoleMentor();
        Course course = checkExistCourse(mentor, courseId);
        Section section = checkExistSection(sectionId, course);
        sectionRepository.delete(section);
        return MessageResponse.builder()
                .message("Delete section in course successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }
    @Transactional
    @Override
    public MessageResponse deleteAllSectionByCourseId(String courseId) {
        Mentor mentor = checkExistRoleMentor();
        Course course = checkExistCourse(mentor, courseId);
        sectionRepository.deleteAllByCourse(course);
        return MessageResponse.builder()
                .message("Delete all section in course successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }


    private Mentor checkExistRoleMentor() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        if (mentor == null) {
            throw new MentorException("You must register to be mentor to find your section course");
        }
        return mentor;
    }

    private Course checkExistCourse(Mentor mentor, String courseId) {
        Course course = courseRepository.findByMentorAndCourseId(mentor, courseId);
        if (course == null) {
            throw new CourseException("You can not view all section from that course because it belong to another mentor");
        }
        return course;
    }

    private Section checkExistSection(Long sectionId, Course course) {
        Section section = sectionRepository.findByCourseAndSectionId(course, sectionId);
        if (section == null) {
            throw new CourseException("You can not view section in course from another mentor");
        }
        return section;
    }
}
