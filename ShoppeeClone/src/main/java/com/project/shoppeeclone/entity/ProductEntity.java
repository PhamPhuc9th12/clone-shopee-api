package com.project.shoppeeclone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="tbl_product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String images;
    private Boolean isFreeShip;
    private Long shipCost;
    private String resource;
    private Boolean isReturn;
    private OffsetDateTime timeReturn;
    private Long likeCount;
    private Long commentCount;
    private Long cateId;
    private Long shopId ;
}
