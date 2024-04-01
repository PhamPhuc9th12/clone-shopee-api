package com.project.shoppeeclone.service.service_interface;

import com.project.shoppeeclone.dto.category.CategoryRequest;

import java.util.List;

public interface CategoryService {
    void createCategory(String accessToken, Long shopId, List<CategoryRequest> categoryRequests);
}
