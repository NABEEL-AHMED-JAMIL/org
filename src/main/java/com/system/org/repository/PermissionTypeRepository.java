package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.PermissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionTypeRepository extends JpaRepository<PermissionType, Long> {

    Optional<PermissionType> findPermissionTypeByPermissionTypeNameAndActiveStatus(String permissionTypeName, ActiveStatus activeStatus);

    Optional<PermissionType> findPermissionTypeByPermissionTypeUuidAndActiveStatus(String permissionTypeUuid, ActiveStatus activeStatus);

    Optional<PermissionType> findPermissionTypeByPermissionTypeUuid(String permissionTypeUuid);

    List<PermissionType> findAllByActiveStatus(ActiveStatus activeStatus);

}
