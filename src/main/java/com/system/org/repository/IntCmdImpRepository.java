package com.system.org.repository;

import com.system.org.model.IntCmdImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntCmdImpRepository extends JpaRepository<IntCmdImp, Long> {

    Optional<IntCmdImp> findByIntCmdImpUuid(String intCmdImpUuid);
}
