package com.system.org.repository;

import com.system.org.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    Optional<RolePermission> findRolePermissionByRolePermissionUuid(String rolePermissionUuid);
}
