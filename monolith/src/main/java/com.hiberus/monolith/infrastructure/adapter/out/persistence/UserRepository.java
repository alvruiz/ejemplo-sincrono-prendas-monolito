package com.hiberus.monolith.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    void deleteByDni(String id);
    UserEntity findByDni(String id);
}
