package com.develop.devcourse.domain.course.service;

import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.response.CategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CategoryService {
     PageResponseDto<CategoryResponse> findAllCategory(Pageable pageable);

     List<CategoryResponse> getAllCategoryByNameOrDescription(String keyword);

     CategoryResponse findCategoryById(Long categoryId);

}
