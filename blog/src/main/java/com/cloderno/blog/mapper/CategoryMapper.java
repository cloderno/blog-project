package com.cloderno.blog.mapper;

import com.cloderno.blog.domain.PostStatus;
import com.cloderno.blog.domain.dto.CategoryDTO;
import com.cloderno.blog.domain.entity.Category;
import com.cloderno.blog.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE) // ignore to not throw an exception
public interface CategoryMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDTO toDto(Category category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if(null == posts) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
