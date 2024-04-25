package com.develop.devcourse.controller.permitall;


import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.response.CategoryResponse;
import com.develop.devcourse.domain.course.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<PageResponseDto<CategoryResponse>> getAllCategories(Pageable pageable){
        return ResponseEntity.ok(categoryService.findAllCategory(pageable));
//        return new ResponseEntity<>(categoryService.findAllCategory(pageable), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponse>> getAllCategoriesByNameOrDescription(@RequestParam("query") String keyword){
            return ResponseEntity.ok(categoryService.getAllCategoryByNameOrDescription(keyword));
    }
}
