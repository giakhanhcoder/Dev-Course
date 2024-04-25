package com.develop.devcourse.domain.course.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryRequest {
    private Long categoryId;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;
}
