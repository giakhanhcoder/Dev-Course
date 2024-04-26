package com.develop.devcourse.controller.permitAll;


import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.response.CategoryResponse;
import com.develop.devcourse.domain.course.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<PageResponseDto<CategoryResponse>> getAllCategories(Pageable pageable){
        return ResponseEntity.ok(categoryService.findAllCategory(pageable));
        // option 2
        // return new ResponseEntity<>(categoryService.findAllCategory(pageable), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponse>> getAllCategoriesByNameOrDescription(@RequestParam("query") String keyword){
            return ResponseEntity.ok(categoryService.getAllCategoryByNameOrDescription(keyword));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.findCategoryById(categoryId));
    }
}
