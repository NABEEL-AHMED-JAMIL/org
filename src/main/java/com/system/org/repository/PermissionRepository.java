package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {


    Optional<Permission> findPermissionByPermissionNameAndActiveStatus(String permissionName, ActiveStatus activeStatus);

    Optional<Permission> findPermissionByPermissionUuidAndActiveStatus(String permissionUuid, ActiveStatus activeStatus);

    Optional<Permission> findPermissionByPermissionUuid(String permissionUuid);

    List<Permission> findAllPermissionByActiveStatus(ActiveStatus activeStatus);
}
