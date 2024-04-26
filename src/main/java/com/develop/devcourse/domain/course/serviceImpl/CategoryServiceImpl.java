package com.develop.devcourse.domain.course.serviceImpl;


import com.develop.devcourse.common.util.PageResponseDto;
import com.develop.devcourse.domain.course.dto.response.CategoryResponse;
import com.develop.devcourse.domain.course.exeption.CourseException;
import com.develop.devcourse.domain.course.model.Category;
import com.develop.devcourse.domain.course.repository.CategoryRepository;
import com.develop.devcourse.domain.course.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public PageResponseDto<CategoryResponse> findAllCategory(Pageable pageable) {
        Page<Category> page = categoryRepository.findAll(pageable);

        List<CategoryResponse> data = page
                .getContent().stream()
                .map(category -> modelMapper.map(category, CategoryResponse.class))
                .toList();

        PageResponseDto<CategoryResponse> pageResponseDto = new PageResponseDto<>();
        pageResponseDto.setData(data);
        pageResponseDto.setTotalPage(page.getTotalPages());
        pageResponseDto.setSize(page.getSize());
        pageResponseDto.setPageNumber(page.getNumber());
        pageResponseDto.setSort(page.getSort().toString());

        return pageResponseDto;

    }

    @Override
    public List<CategoryResponse> getAllCategoryByNameOrDescription(String keyword) {
        List<Category> categories = categoryRepository.findAllByCategoryNameContainingOrDescriptionContaining(keyword, keyword);

        if (categories.isEmpty()) {
            throw CourseException.notFound("No categories found matching the search criteria");
        } else {
            return categories.stream().map(category -> modelMapper.map(category, CategoryResponse.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public CategoryResponse findCategoryById(Long categoryId) {
        Category category = categoryRepository.findByCategoryId(categoryId);
        if (category == null) {
            throw CourseException.notFound("Could not found that category with the Id");
        } else {
            return modelMapper.map(category, CategoryResponse.class);
        }

    }
}
