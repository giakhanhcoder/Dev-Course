package com.develop.devcourse.controller.mentorC;

import com.develop.devcourse.domain.mentor.dto.request.MentorRequest;
import com.develop.devcourse.domain.mentor.dto.response.MentorResponse;
import com.develop.devcourse.domain.mentor.service.MentorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor")
public class MentorWebController {

    private final MentorService mentorService;

    @PutMapping("/profile")
    public ResponseEntity<MentorResponse> updateProfileMentor(@Valid @RequestBody MentorRequest mentorRequest){
        return ResponseEntity.ok(mentorService.updateProfileMentor(mentorRequest));
    }

    @GetMapping("/profile")
    public ResponseEntity<MentorResponse> showMentorProfile(){
        return ResponseEntity.ok(mentorService.showMentorProfile());
    }

}
