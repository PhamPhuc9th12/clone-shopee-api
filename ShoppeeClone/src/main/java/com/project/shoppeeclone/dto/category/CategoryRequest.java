package com.project.shoppeeclone.dto.category;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequest {
    private String name;
    private String description;
}
