package com.cloderno.blog.service.impl;

import com.cloderno.blog.domain.entity.Category;
import com.cloderno.blog.repository.CategoryRepository;
import com.cloderno.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public List<Category> listCategories() {
        return repository.findAllWithPostCount();
    }
}
