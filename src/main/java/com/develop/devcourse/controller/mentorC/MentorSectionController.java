package com.develop.devcourse.controller.mentorC;

import com.develop.devcourse.domain.course.dto.request.SectionRequest;
import com.develop.devcourse.domain.course.dto.response.SectionResponse;
import com.develop.devcourse.domain.course.service.SectionService;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor/section")
public class MentorSectionController {

    private final SectionService sectionService;

    @GetMapping("{courseId}")
    public ResponseEntity<List<SectionResponse>> findAllSectionByCourseId(@PathVariable String courseId){
        return ResponseEntity.ok(sectionService.findAllSectionByCourseId(courseId));
    }

    @PostMapping("{courseId}")
    public ResponseEntity<MessageResponse> postSectionIntoCourseByCourseId(@PathVariable String courseId,
                                                                           @Valid @RequestBody List<SectionRequest> sectionRequest){
        return ResponseEntity.ok(sectionService.postSectionToCourseId(sectionRequest, courseId));
    }

    @PutMapping("{sectionId}/{courseId}")
    public ResponseEntity<MessageResponse> updateSectionByCourseAndSectionId(@PathVariable(value = "sectionId") Long sectionId,
                                                                             @PathVariable(value = "courseId") String courseId,
                                                                             @Valid @RequestBody SectionRequest sectionRequest){
        return ResponseEntity.ok(sectionService.updateSectionByCourseAndSectionId(sectionRequest, sectionId, courseId));
    }

    @DeleteMapping("{sectionId}/{courseId}")
    public ResponseEntity<MessageResponse> deleteSectionByCourseAndSectionId(@PathVariable(value = "sectionId") Long sectionId,
                                                                             @PathVariable(value = "courseId") String courseId){
        return ResponseEntity.ok(sectionService.deleteSectionByCourseAndSectionId(sectionId, courseId));
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity<MessageResponse> deleteAllSectionByCourseId(@PathVariable(value = "courseId") String courseId){
        return ResponseEntity.ok(sectionService.deleteAllSectionByCourseId(courseId));
    }
}
