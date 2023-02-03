package com.hiberus.monolith.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarmentRepository extends JpaRepository<GarmentEntity, Long> {
    void deleteById(String id);
    GarmentEntity findById(String id);
}
