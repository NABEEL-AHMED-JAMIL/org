package com.system.org.repository;

import com.system.org.model.IntParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntParamsRepository extends JpaRepository<IntParams, Long> {

    Optional<IntParams> findByIntParamsUuid(String intParamsUuid);
}
