package com.cloderno.blog.repository;

import com.cloderno.blog.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    // skipping n+1 problem by left join fetch
    @Query("SELECT category from Category category LEFT JOIN FETCH category.posts")
    List<Category> findAllWithPostCount();
}
