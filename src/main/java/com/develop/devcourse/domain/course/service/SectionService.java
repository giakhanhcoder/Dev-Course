package com.develop.devcourse.domain.course.service;

import com.develop.devcourse.domain.course.dto.request.SectionRequest;
import com.develop.devcourse.domain.course.dto.response.SectionResponse;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;

import java.util.List;

public interface SectionService{
    List<SectionResponse> findAllSectionByCourseId(String courseId);

    MessageResponse postSectionToCourseId(List<SectionRequest> sectionRequests, String courseId);

}
