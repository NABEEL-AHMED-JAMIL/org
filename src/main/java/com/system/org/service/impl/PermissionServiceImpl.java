package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionDto;
import com.system.org.dto.search.PermissionSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.Permission;
import com.system.org.repository.PermissionRepository;
import com.system.org.service.IPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class PermissionServiceImpl implements IPermissionService {

    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createPermission(PermissionDto permissionDto) {
        if (permissionDto.getPermissionName() == null) {
            return new Response("Error", "Permission Name not be null");
        } else if (this.permissionRepository.findPermissionByPermissionNameAndActiveStatus(
                permissionDto.getPermissionName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "Permission Name already exist");
        }
        Permission permission = new Permission();
        permission.setPermissionUuid(UUID.randomUUID().toString());
        permission.setPermissionName(permissionDto.getPermissionName());
        permission.setPermissionDesc(permissionDto.getPermissionDesc());
        permission.setPermissionResourceId(permissionDto.getPermissionResourceId());
        permission.setPermissionResourceUuid(permissionDto.getPermissionResourceUuid());
        permission.setPermissionAvailableIndicator(permissionDto.getPermissionAvailableIndicator());
        permission.setPermissionCreate(permissionDto.getPermissionCreate());
        permission.setPermissionCreatePermissionTypeId(permissionDto.getPermissionCreatePermissionTypeId());
        permission.setPermissionDelete(permissionDto.getPermissionDelete());
        permission.setPermissionDeletePermissionTypeId(permissionDto.getPermissionDeletePermissionTypeId());
        permission.setPermissionUpdate(permissionDto.getPermissionUpdate());
        permission.setPermissionUpdatePermissionTypeId(permissionDto.getPermissionUpdatePermissionTypeId());
        permission.setPermissionRead(permissionDto.getPermissionRead());
        permission.setPermissionReadPermissionTypeId(permissionDto.getPermissionReadPermissionTypeId());
        permission.setPermissionSoftDelete(permissionDto.getPermissionSoftDelete());
        permission.setPermissionSoftDeletePermissionTypeId(permissionDto.getPermissionSoftDeletePermissionTypeId());
        permission.setPermissionOperaterId(permissionDto.getPermissionOperaterId());
        permission.setPermissionAuthorizeUserId(permissionDto.getPermissionAuthorizeUserId());
        permission.setCratedBy(permissionDto.getCratedBy());
        permission.setActiveStatus(ActiveStatus.Y);
        permission = this.permissionRepository.saveAndFlush(permission);
        return new Response("Success", "Permission save successfully", permission);
    }

    @Override
    public Response updatePermission(PermissionDto permissionDto) {
        if (permissionDto.getPermissionUuid() == null) {
            return new Response("Error", "Permission Id not be null");
        } if (permissionDto.getPermissionName() == null) {
            return new Response("Error", "Permission Name not be null");
        }
        Optional<Permission> permission = this.permissionRepository.findPermissionByPermissionUuid(permissionDto.getPermissionUuid());
        if (!permission.isPresent()) {
            return new Response("Error", "Permission not found with the with given id " + permissionDto.getPermissionUuid());
        }
        Permission permission1 = permission.get();
        if (permissionDto.getPermissionUuid() != null) {
            permission1.setPermissionUuid(permissionDto.getPermissionUuid());
        }
        if (permissionDto.getPermissionName() != null) {
            permission1.setPermissionName(permissionDto.getPermissionName());
        }
        if (permissionDto.getPermissionDesc() != null) {
            permission1.setPermissionDesc(permissionDto.getPermissionDesc());
        }
        if (permissionDto.getPermissionResourceId() != null) {
            permission1.setPermissionResourceId(permissionDto.getPermissionResourceId());
        }
        if (permissionDto.getPermissionResourceUuid() != null) {
            permission1.setPermissionResourceUuid(permissionDto.getPermissionResourceUuid());
        }
        if (permissionDto.getPermissionAvailableIndicator() != null) {
            permission1.setPermissionAvailableIndicator(permissionDto.getPermissionAvailableIndicator());
        }
        if (permissionDto.getPermissionCreate() != null) {
            permission1.setPermissionCreate(permissionDto.getPermissionCreate());
        }
        if (permissionDto.getPermissionCreatePermissionTypeId() != null) {
            permission1.setPermissionCreatePermissionTypeId(permissionDto.getPermissionCreatePermissionTypeId());
        }
        if (permissionDto.getPermissionDelete() != null) {
            permission1.setPermissionDelete(permissionDto.getPermissionDelete());
        }
        if (permissionDto.getPermissionDeletePermissionTypeId() != null) {
            permission1.setPermissionDeletePermissionTypeId(permissionDto.getPermissionDeletePermissionTypeId());
        }
        if (permissionDto.getPermissionUpdate() != null) {
            permission1.setPermissionUpdate(permissionDto.getPermissionUpdate());
        }
        if (permissionDto.getPermissionUpdatePermissionTypeId() != null) {
            permission1.setPermissionUpdatePermissionTypeId(permissionDto.getPermissionUpdatePermissionTypeId());
        }
        if (permissionDto.getPermissionRead() != null) {
            permission1.setPermissionRead(permissionDto.getPermissionRead());
        }
        if (permissionDto.getPermissionReadPermissionTypeId() != null) {
            permission1.setPermissionReadPermissionTypeId(permissionDto.getPermissionReadPermissionTypeId());
        }
        if (permissionDto.getPermissionSoftDelete() != null) {
            permission1.setPermissionSoftDelete(permissionDto.getPermissionSoftDelete());
        }
        if (permissionDto.getPermissionSoftDeletePermissionTypeId() != null) {
            permission1.setPermissionSoftDeletePermissionTypeId(permissionDto.getPermissionSoftDeletePermissionTypeId());
        }
        if (permissionDto.getPermissionOperaterId() != null) {
            permission1.setPermissionOperaterId(permissionDto.getPermissionOperaterId());
        }
        if (permissionDto.getPermissionAuthorizeUserId() != null) {
            permission1.setPermissionAuthorizeUserId(permissionDto.getPermissionAuthorizeUserId());
        }
        if (permissionDto.getUpdatedBy() != null) {
            permission1.setUpdatedBy(permissionDto.getUpdatedBy());
        }
        if (permissionDto.getActiveStatus() != null) {
            permission1.setActiveStatus(permissionDto.getActiveStatus());
        }
        permission1 = this.permissionRepository.saveAndFlush(permission1);
        return new Response("Success", "Permission update successfully", permission1);
    }

    @Override
    public Response findAllPermission() {
        return new Response("Success", "Permission find successfully",
            this.permissionRepository.findAll());
    }

    @Override
    public Response findAllPermissionSearch(PermissionSearch permissionSearch) {
        return this.utilService.findAllPermissionSearch(permissionSearch);
    }

    @Override
    public Response findPermissionByPermissionUuid(String permissionUuid) {
        Optional<Permission> permission = this.permissionRepository.findPermissionByPermissionUuid(permissionUuid);
        if (permission.isPresent()) {
            return new Response("Success", "Permission find successfully", permission.get());
        } else {
            return new Response("Error", "Permission not find");
        }
    }

    @Override
    public Response deletePermissionByPermissionUuid(String permissionUuid) {
        Optional<Permission> permission = this.permissionRepository.findPermissionByPermissionUuid(permissionUuid);
        permission.get().setActiveStatus(ActiveStatus.N);
        this.permissionRepository.saveAndFlush(permission.get());
        return new Response("Success", "Delete successfully");
    }
}
