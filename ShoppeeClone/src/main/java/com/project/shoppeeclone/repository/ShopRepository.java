package com.project.shoppeeclone.repository;

import com.project.shoppeeclone.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    ShopEntity getByName(String shopName);

    Boolean existsByUserIdAndId(Long userId, Long Id);
}
