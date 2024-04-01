package com.project.shoppeeclone.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_shop")
@Builder
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private OffsetDateTime createdAt;
    private Long productCount;
    private Long followCount;
    private double rating;
    private Long userId;
}
