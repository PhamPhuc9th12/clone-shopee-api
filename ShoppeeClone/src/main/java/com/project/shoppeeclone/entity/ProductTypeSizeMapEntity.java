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
@Table(name = "tbl_product_type_size_map")
public class ProductTypeSizeMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    private Long quantity;
    private Boolean is_sale;
    private Long sale_percent;
    private Long sale_cost;
    private OffsetDateTime sale_start_time;
    private OffsetDateTime sale_end_time;
    private Long product_type_id;
    private Long size_id;
}
