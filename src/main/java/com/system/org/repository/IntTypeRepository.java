package com.system.org.repository;

import com.system.org.model.IntType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntTypeRepository extends JpaRepository<IntType, Long> {

    Optional<IntType> findByIntTypeUuid(String intTypeUuid);
}
