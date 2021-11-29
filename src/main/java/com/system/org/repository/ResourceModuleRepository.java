package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.ResourceModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceModuleRepository extends JpaRepository<ResourceModule, Long> {

    Optional<ResourceModule> findByResourceModuleUuidAndActiveStatus(String resourceModuleUuid, ActiveStatus activeStatus);

    Optional<ResourceModule> findByResourceModuleUuid(String resourceModuleUuid);

    List<ResourceModule> findAllByActiveStatus(ActiveStatus activeStatus);
}
