package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntAppRepository extends JpaRepository<IntApp, Long> {

    Optional<IntApp> findByIntAppNameAndActiveStatus(String intAppName, ActiveStatus activeStatus);

    Optional<IntApp> findByIntAppUuIdAndActiveStatus(String intAppUuId, ActiveStatus activeStatus);

    Optional<IntApp> findByIntAppUuId(String intAppUuId);

    List<IntApp> findAllByActiveStatus(ActiveStatus activeStatus);
}
