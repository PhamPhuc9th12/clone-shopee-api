package com.project.shoppeeclone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String district;
    private String county;
    private String commune;
    @Column(name = "address_detail")
    private String addressDetail;
    @Column(name = "name_receive")
    private String nameReceive;
    private String phone;
    private String type;
    private Long userId;
    @Column(name = "is_default")
    private Boolean isDefault;

}
