package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findAllByActiveStatus(ActiveStatus activeStatus);

    Optional<Resource> findByResourceUuidAndActiveStatus(String resourceUuid, ActiveStatus activeStatus);

    Optional<Resource> findByResourceUuid(String resourceUuid);

    Optional<Resource> findByResourceNameAndActiveStatus(String resourceName, ActiveStatus activeStatus);


}
