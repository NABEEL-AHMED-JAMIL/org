package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceTypeRepository extends JpaRepository<ResourceType, Long> {

    List<ResourceType> findAllByActiveStatus(ActiveStatus activeStatus);

    Optional<ResourceType> findByResourceTypeNameAndActiveStatus(String resourceTypeName, ActiveStatus activeStatus);

    Optional<ResourceType> findByResourceTypeUuidAndActiveStatus(String resourceTypeUuid, ActiveStatus activeStatus);

    Optional<ResourceType> findByResourceTypeUuid(String resourceTypeUuid);
}
