package com.cloderno.blog.service.impl;

import com.cloderno.blog.domain.entity.Category;
import com.cloderno.blog.repository.CategoryRepository;
import com.cloderno.blog.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public List<Category> listCategories() {
        return repository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        String categoryName = category.getName();
        if(repository.existsByNameIgnoreCase(categoryName)) {
            throw new IllegalArgumentException("Category already exists with name: " + categoryName);
        }
        return repository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Category not found");
        }

        repository.deleteById(id);
    }
}
