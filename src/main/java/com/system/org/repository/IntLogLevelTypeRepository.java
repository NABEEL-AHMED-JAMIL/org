package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntLogLevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntLogLevelTypeRepository extends JpaRepository<IntLogLevelType, Long> {

    Optional<IntLogLevelType> findByIntLogLevelTypeNameAndActiveStatus(String intLogLevelTypeName, ActiveStatus activeStatus);

    Optional<IntLogLevelType> findByIntLogLevelTypeUuidAndActiveStatus(String intLogLevelTypeUuid, ActiveStatus activeStatus);

    Optional<IntLogLevelType> findByIntLogLevelTypeUuid(String intLogLevelTypeUuid);

    List<IntLogLevelType> findAllByActiveStatus(ActiveStatus activeStatus);
}
