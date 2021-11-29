package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.PermissionResourceModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionResourceModuleRepository extends JpaRepository<PermissionResourceModule, Long> {

    Optional<PermissionResourceModule> findPermissionResourceModuleByPermissionResourceModuleNameAndActiveStatus(String permissionResourceModuleName, ActiveStatus activeStatus);

    Optional<PermissionResourceModule> findPermissionResourceModuleByPermissionResourceModuleUuidAndActiveStatus(String permissionResourceModuleUuid, ActiveStatus activeStatus);

    Optional<PermissionResourceModule> findPermissionResourceModuleByPermissionResourceModuleUuid(String permissionResourceModuleUuid);

    List<PermissionResourceModule> findAllPermissionResourceModuleByActiveStatus(ActiveStatus activeStatus);
}
