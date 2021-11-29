package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntLogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntLogTypeRepository extends JpaRepository<IntLogType, Long> {

    Optional<IntLogType> findByIntLogTypeNameAndActiveStatus(String intLogTypeName, ActiveStatus activeStatus);

    Optional<IntLogType> findByIntLogTypeUuidAndActiveStatus(String intLogTypeUuid, ActiveStatus activeStatus);

    Optional<IntLogType> findByIntLogTypeUuid(String intLogTypeUuid);

    List<IntLogType> findAllByActiveStatus(ActiveStatus activeStatus);
}
