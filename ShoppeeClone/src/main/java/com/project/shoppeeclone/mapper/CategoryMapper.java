package com.project.shoppeeclone.mapper;

import com.project.shoppeeclone.dto.category.CategoryRequest;
import com.project.shoppeeclone.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryEntity getEntityFromRequest(CategoryRequest categoryRequest);
}
