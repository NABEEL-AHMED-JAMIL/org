package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntEnvType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntEnvTypeRepository extends JpaRepository<IntEnvType, Long> {

    Optional<IntEnvType> findByIntEnvTypeNameAndActiveStatus(String intEnvTypeName, ActiveStatus activeStatus);

    Optional<IntEnvType> findByIntEnvTypeUuidAndActiveStatus(String intEnvTypeUuid, ActiveStatus activeStatus);

    Optional<IntEnvType> findByIntEnvTypeUuid(String intEnvTypeUuid);

    List<IntEnvType> findAllByActiveStatus(ActiveStatus activeStatus);
}
