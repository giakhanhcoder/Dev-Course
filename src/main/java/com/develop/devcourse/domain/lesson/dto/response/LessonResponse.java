package com.develop.devcourse.domain.lesson.dto.response;

import com.develop.devcourse.domain.lesson.model.Lesson;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonResponse {
    private Long sectionId;
    private String sectionName;
    private List<Lesson> data;
}
