package com.project.shoppeeclone.repository;

import com.project.shoppeeclone.entity.AddressEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    Page<AddressEntity> findAllByUserId(Long userId, Pageable pageable);
    List<AddressEntity> findAllByUserId(Long userId);
}
