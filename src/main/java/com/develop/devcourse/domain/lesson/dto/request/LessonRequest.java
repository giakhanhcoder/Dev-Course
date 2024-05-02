package com.develop.devcourse.domain.lesson.dto.request;

import com.develop.devcourse.domain.course.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {
    private Long lessonId;
    private String lessonTitle;
    private MultipartFile lessonPDF;
    private Course course;
}
