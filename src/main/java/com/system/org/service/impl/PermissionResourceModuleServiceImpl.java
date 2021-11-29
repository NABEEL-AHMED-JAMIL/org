package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionResourceModuleDto;
import com.system.org.dto.search.PermissionResourceModuleSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.Permission;
import com.system.org.model.PermissionResourceModule;
import com.system.org.repository.PermissionResourceModuleRepository;
import com.system.org.service.IPermissionResourceModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class PermissionResourceModuleServiceImpl implements IPermissionResourceModuleService {

    private Logger logger = LoggerFactory.getLogger(PermissionResourceModuleServiceImpl.class);

    @Autowired
    private PermissionResourceModuleRepository permissionResourceModuleRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createPermissionResourceModule(PermissionResourceModuleDto permissionResourceModuleDto) {
        if (permissionResourceModuleDto.getPermissionResourceModuleName() == null) {
            return new Response("Error", "Permission Resource Module Name not be null");
        } else if (this.permissionResourceModuleRepository.findPermissionResourceModuleByPermissionResourceModuleNameAndActiveStatus(
                permissionResourceModuleDto.getPermissionResourceModuleName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "Permission Resource Module Name already exist");
        }
        PermissionResourceModule permissionResourceModule = new PermissionResourceModule();
        permissionResourceModule.setPermissionResourceModuleUuid(UUID.randomUUID().toString());
        permissionResourceModule.setPermissionResourceModuleName(permissionResourceModuleDto.getPermissionResourceModuleName());
        permissionResourceModule.setPermissionResourceModuleDesc(permissionResourceModuleDto.getPermissionResourceModuleDesc());
        permissionResourceModule.setPermissionResourceModuleResourceId(permissionResourceModuleDto.getPermissionResourceModuleResourceId());
        permissionResourceModule.setPermissionResourceModuleResourceUuid(permissionResourceModuleDto.getPermissionResourceModuleResourceUuid());
        permissionResourceModule.setPermissionResourceModuleAvailableIndicator(permissionResourceModuleDto.getPermissionResourceModuleAvailableIndicator());
        permissionResourceModule.setPermissionResourceModuleCreate(permissionResourceModuleDto.getPermissionResourceModuleCreate());
        permissionResourceModule.setPermissionResourceModuleCreatePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleCreatePermissionTypeId());
        permissionResourceModule.setPermissionResourceModuleDelete(permissionResourceModuleDto.getPermissionResourceModuleDelete());
        permissionResourceModule.setPermissionResourceModuleDeletePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleDeletePermissionTypeId());
        permissionResourceModule.setPermissionResourceModuleUpdate(permissionResourceModuleDto.getPermissionResourceModuleUpdate());
        permissionResourceModule.setPermissionResourceModuleUpdatePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleUpdatePermissionTypeId());
        permissionResourceModule.setPermissionResourceModuleRead(permissionResourceModuleDto.getPermissionResourceModuleRead());
        permissionResourceModule.setPermissionResourceModuleReadPermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleReadPermissionTypeId());
        permissionResourceModule.setPermissionResourceModuleSoftDelete(permissionResourceModuleDto.getPermissionResourceModuleSoftDelete());
        permissionResourceModule.setPermissionResourceModuleSoftDeletePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleSoftDeletePermissionTypeId());
        permissionResourceModule.setPermissionResourceModuleOperaterId(permissionResourceModuleDto.getPermissionResourceModuleOperaterId());
        permissionResourceModule.setPermissionResourceModuleAuthorizeUserId(permissionResourceModuleDto.getPermissionResourceModuleAuthorizeUserId());
        permissionResourceModule.setCratedBy(permissionResourceModuleDto.getCratedBy());
        permissionResourceModule.setActiveStatus(ActiveStatus.Y);
        permissionResourceModule = this.permissionResourceModuleRepository.saveAndFlush(permissionResourceModule);
        return new Response("Success", "Permission Resource Module save successfully", permissionResourceModule);
    }

    @Override
    public Response updatePermissionResourceModule(PermissionResourceModuleDto permissionResourceModuleDto) {
        if (permissionResourceModuleDto.getPermissionResourceModuleUuid() == null) {
            return new Response("Error", "Permission Resource Module Id not be null");
        } if (permissionResourceModuleDto.getPermissionResourceModuleName() == null) {
            return new Response("Error", "Permission Resource Module Name not be null");
        }
        Optional<PermissionResourceModule> permissionResourceModule = this.permissionResourceModuleRepository
            .findPermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleDto.getPermissionResourceModuleUuid());
        if (!permissionResourceModule.isPresent()) {
            return new Response("Error", "Permission Resource Module not found with the with given id " +
                    permissionResourceModuleDto.getPermissionResourceModuleUuid());
        }
        PermissionResourceModule permissionResourceModule1 = permissionResourceModule.get();
        if (permissionResourceModuleDto.getPermissionResourceModuleUuid() != null) {
            permissionResourceModule1.setPermissionResourceModuleUuid(permissionResourceModuleDto.getPermissionResourceModuleUuid());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleName() != null) {
            permissionResourceModule1.setPermissionResourceModuleName(permissionResourceModuleDto.getPermissionResourceModuleName());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleDesc() != null) {
            permissionResourceModule1.setPermissionResourceModuleDesc(permissionResourceModuleDto.getPermissionResourceModuleDesc());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleResourceId() != null) {
            permissionResourceModule1.setPermissionResourceModuleResourceId(permissionResourceModuleDto.getPermissionResourceModuleResourceId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleResourceUuid() != null) {
            permissionResourceModule1.setPermissionResourceModuleResourceUuid(permissionResourceModuleDto.getPermissionResourceModuleResourceUuid());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleAvailableIndicator() != null) {
            permissionResourceModule1.setPermissionResourceModuleAvailableIndicator(permissionResourceModuleDto.getPermissionResourceModuleAvailableIndicator());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleCreate() != null) {
            permissionResourceModule1.setPermissionResourceModuleCreate(permissionResourceModuleDto.getPermissionResourceModuleCreate());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleCreatePermissionTypeId() != null) {
            permissionResourceModule1.setPermissionResourceModuleCreatePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleCreatePermissionTypeId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleDelete() != null) {
            permissionResourceModule1.setPermissionResourceModuleDelete(permissionResourceModuleDto.getPermissionResourceModuleDelete());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleDeletePermissionTypeId() != null) {
            permissionResourceModule1.setPermissionResourceModuleDeletePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleDeletePermissionTypeId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleUpdate() != null) {
            permissionResourceModule1.setPermissionResourceModuleUpdate(permissionResourceModuleDto.getPermissionResourceModuleUpdate());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleUpdatePermissionTypeId() != null) {
            permissionResourceModule1.setPermissionResourceModuleUpdatePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleUpdatePermissionTypeId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleRead() != null) {
            permissionResourceModule1.setPermissionResourceModuleRead(permissionResourceModuleDto.getPermissionResourceModuleRead());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleReadPermissionTypeId() != null) {
            permissionResourceModule1.setPermissionResourceModuleReadPermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleReadPermissionTypeId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleSoftDelete() != null) {
            permissionResourceModule1.setPermissionResourceModuleSoftDelete(permissionResourceModuleDto.getPermissionResourceModuleSoftDelete());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleSoftDeletePermissionTypeId() != null) {
            permissionResourceModule1.setPermissionResourceModuleSoftDeletePermissionTypeId(permissionResourceModuleDto.getPermissionResourceModuleSoftDeletePermissionTypeId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleOperaterId() != null) {
            permissionResourceModule1.setPermissionResourceModuleOperaterId(permissionResourceModuleDto.getPermissionResourceModuleOperaterId());
        }
        if (permissionResourceModuleDto.getPermissionResourceModuleOperaterId() != null) {
            permissionResourceModule1.setPermissionResourceModuleAuthorizeUserId(permissionResourceModuleDto.getPermissionResourceModuleOperaterId());
        }
        if (permissionResourceModuleDto.getUpdatedBy() != null) {
            permissionResourceModule1.setUpdatedBy(permissionResourceModuleDto.getUpdatedBy());
        }
        if (permissionResourceModuleDto.getActiveStatus() != null) {
            permissionResourceModule1.setActiveStatus(permissionResourceModuleDto.getActiveStatus());
        }
        permissionResourceModule1 = this.permissionResourceModuleRepository.saveAndFlush(permissionResourceModule1);
        return new Response("Success", "Permission Resource Module update successfully", permissionResourceModule1);
    }

    @Override
    public Response findAllPermissionResourceModule() {
        return new Response("Success", "Permission Resource Module find successfully",
            this.permissionResourceModuleRepository.findAll());
    }

    @Override
    public Response findAllPermissionResourceModuleSearch(PermissionResourceModuleSearch permissionResourceModuleSearch) {
        return this.utilService.findAllPermissionResourceModuleSearch(permissionResourceModuleSearch);
    }

    @Override
    public Response findPermissionResourceModuleByPermissionResourceModuleUuid(String permissionResourceModuleUuid) {
        Optional<PermissionResourceModule> permissionResourceModule = this.permissionResourceModuleRepository.
                findPermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleUuid);
        if (permissionResourceModule.isPresent()) {
            return new Response("Success", "Permission Resource Module find successfully", permissionResourceModule.get());
        } else {
            return new Response("Error", "Permission Resource Module not find");
        }
    }

    @Override
    public Response deletePermissionResourceModuleByPermissionResourceModuleUuid(String permissionResourceModuleUuid) {
        Optional<PermissionResourceModule> permissionResourceModule = this.permissionResourceModuleRepository.
                findPermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleUuid);
        permissionResourceModule.get().setActiveStatus(ActiveStatus.N);
        this.permissionResourceModuleRepository.saveAndFlush(permissionResourceModule.get());
        return new Response("Success", "Delete successfully");
    }
}
