package com.develop.devcourse.domain.course.repository;

import com.develop.devcourse.domain.course.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByCategoryNameContainingOrDescriptionContaining(String categoryName, String description);

    Category findByCategoryId(Long categoryId);
}
