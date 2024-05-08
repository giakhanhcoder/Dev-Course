package com.develop.devcourse.controller.admin;

import com.develop.devcourse.domain.course.dto.request.CategoryRequest;
import com.develop.devcourse.domain.course.dto.response.CategoryResponse;
import com.develop.devcourse.domain.course.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/category")
public class AdminCategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> addNewOrUpdateCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryService.addNewCategory(categoryRequest), HttpStatus.CREATED);
    }
}
