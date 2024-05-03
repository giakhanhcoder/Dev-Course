package com.develop.devcourse.domain.mentor.service;

import com.develop.devcourse.domain.mentor.dto.request.MentorRequest;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;

public interface MentorService {
    MessageResponse registerToMentor(MentorRequest mentorRequest);

}
