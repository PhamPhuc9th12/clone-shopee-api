package com.project.shoppeeclone.service.service_implement;

import com.project.shoppeeclone.common.Common;
import com.project.shoppeeclone.dto.category.CategoryRequest;
import com.project.shoppeeclone.entity.CategoryEntity;
import com.project.shoppeeclone.mapper.CategoryMapper;
import com.project.shoppeeclone.repository.CategoryRepository;
import com.project.shoppeeclone.repository.ShopRepository;
import com.project.shoppeeclone.service.service_interface.CategoryService;
import com.project.shoppeeclone.token.TokenHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void createCategory(String accessToken, Long shopId, List<CategoryRequest> categoryRequests) {
        Long userId = TokenHelper.getUserIdFromToken(accessToken);
        if(Boolean.FALSE.equals(shopRepository.existsByUserIdAndId(userId,shopId))){

            throw new RuntimeException(Common.SHOP_IS_NOT_EXIST);
        }
        List<CategoryEntity> categoryEntities = categoryRequests.stream()
                .map(categoryMapper::getEntityFromRequest)
                .collect(Collectors.toList());
        for(CategoryEntity categoryEntity:categoryEntities){
            categoryEntity.setShopId(shopId);
        }
        categoryRepository.saveAll(categoryEntities);
    }
}
