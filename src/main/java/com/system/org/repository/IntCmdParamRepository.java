package com.system.org.repository;

import com.system.org.model.IntCmdParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntCmdParamRepository extends JpaRepository<IntCmdParam, Long> {

    Optional<IntCmdParam> findByIntCmdParamUuid(String intCmdParamUuid);
}
