package com.cloderno.blog.controller;

import com.cloderno.blog.domain.dto.CategoryDTO;
import com.cloderno.blog.domain.entity.Category;
import com.cloderno.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        List<Category> categories = categoryService.listCategories();
        return categories
    }
}
