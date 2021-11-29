package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.RolePermissionDto;
import com.system.org.dto.search.RolePermissionSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.RolePermission;
import com.system.org.repository.RolePermissionRepository;
import com.system.org.service.IRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@Scope("singleton")
public class RolePermissionServiceImpl implements IRolePermissionService {

    private Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createRolePermission(RolePermissionDto rolePermissionDto) {
        if (rolePermissionDto.getRoleId() == null) {
            return new Response("Error", "RoleId not be null");
        } else if (rolePermissionDto.getPermissionId() == null) {
            return new Response("Error", "PermissionId not be null");
        }
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRolePermissionUuid(UUID.randomUUID().toString());
        rolePermission.setRoleId(rolePermissionDto.getRoleId());
        rolePermission.setPermissionId(rolePermissionDto.getPermissionId());
        rolePermission.setRolePermissionAuthorizationUserId(rolePermissionDto.getRolePermissionAuthorizationUserId());
        rolePermission.setRolePermissionAvailableIndicator(rolePermissionDto.getRolePermissionAvailableIndicator());
        rolePermission.setRolePermissionExpirationDate(rolePermissionDto.getRolePermissionExpirationDate());
        rolePermission.setCreatedBy(rolePermissionDto.getCreatedBy());
        rolePermission.setActiveStatus(ActiveStatus.Y);
        rolePermission = this.rolePermissionRepository.saveAndFlush(rolePermission);
        return new Response("Success", "RolePermission save successfully", rolePermission);
    }

    @Override
    public Response updateRolePermission(RolePermissionDto rolePermissionDto) {
        if (rolePermissionDto.getRolePermissionUuid() == null) {
            return new Response("Error", "RolePermissionUuid not be null");
        } else if (rolePermissionDto.getRoleId() == null) {
            return new Response("Error", "RoleId not be null");
        } else if (rolePermissionDto.getPermissionId() == null) {
            return new Response("Error", "PermissionId not be null");
        }
        Optional<RolePermission> rolePermission = this.rolePermissionRepository.findRolePermissionByRolePermissionUuid(rolePermissionDto.getRolePermissionUuid());
        if (!rolePermission.isPresent()) {
            return new Response("Error", "RolePermission not found with the with given id " + rolePermissionDto.getRolePermissionUuid());
        }
        RolePermission rolePermission1 = rolePermission.get();
        if (rolePermissionDto.getRolePermissionUuid() != null) {
            rolePermission1.setRolePermissionUuid(rolePermissionDto.getRolePermissionUuid());
        }
        if (rolePermissionDto.getRoleId() != null) {
            rolePermission1.setRoleId(rolePermissionDto.getRoleId());
        }
        if (rolePermissionDto.getPermissionId() != null) {
            rolePermission1.setPermissionId(rolePermissionDto.getPermissionId());
        }
        if (rolePermissionDto.getRolePermissionAuthorizationUserId() != null) {
            rolePermission1.setRolePermissionAuthorizationUserId(rolePermissionDto.getRolePermissionAuthorizationUserId());
        }
        if (rolePermissionDto.getRolePermissionAvailableIndicator() != null) {
            rolePermission1.setRolePermissionAvailableIndicator(rolePermissionDto.getRolePermissionAvailableIndicator());
        }
        if (rolePermissionDto.getRolePermissionExpirationDate() != null) {
            rolePermission1.setRolePermissionExpirationDate(rolePermissionDto.getRolePermissionExpirationDate());
        }
        if (rolePermissionDto.getUpdatedBy() != null) {
            rolePermission1.setUpdatedBy(rolePermissionDto.getUpdatedBy());
        }
        rolePermission1.setActiveStatus(rolePermissionDto.getActiveStatus());
        rolePermission1 = this.rolePermissionRepository.saveAndFlush(rolePermission1);
        return new Response("Success", "RolePermission save successfully", rolePermission1);
    }

    @Override
    public Response findAllRolePermission() {
        return new Response("Success", "RolePermission find successfully",
            this.rolePermissionRepository.findAll());
    }

    @Override
    public Response findAllRolePermissionSearch(RolePermissionSearch rolePermissionSearch) {
        return this.utilService.findAllRolePermissionSearch(rolePermissionSearch);
    }

    @Override
    public Response findRolePermissionByRolePermissionUuid(String rolePermissionUuid) {
        Optional<RolePermission> organization = this.rolePermissionRepository.findRolePermissionByRolePermissionUuid(rolePermissionUuid);
        if (organization.isPresent()) {
            return new Response("Success", "RolePermission find successfully", organization.get());
        } else {
            return new Response("Error", "RolePermission not find");
        }
    }

    @Override
    public Response deleteRolePermissionByRolePermissionUuid(String rolePermissionUuid) {
        Optional<RolePermission> organization = this.rolePermissionRepository.findRolePermissionByRolePermissionUuid(rolePermissionUuid);
        organization.get().setActiveStatus(ActiveStatus.N);
        this.rolePermissionRepository.save(organization.get());
        return new Response("Success", "RolePermission delete successfully");
    }
}
