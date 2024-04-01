package com.project.shoppeeclone.controller;

import com.project.shoppeeclone.dto.category.CategoryRequest;
import com.project.shoppeeclone.service.service_interface.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@AllArgsConstructor
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "create category for shop")
    @PostMapping("create")
    public void createCategory(@RequestHeader("Authorization") String accessToken,
                               @RequestParam Long shopId,
                               @RequestBody List<CategoryRequest> categoryRequests){
        categoryService.createCategory(accessToken, shopId, categoryRequests);
    }
}
