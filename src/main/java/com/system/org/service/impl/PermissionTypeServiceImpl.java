package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionTypeDto;
import com.system.org.dto.search.PermissionTypeSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.PermissionType;
import com.system.org.repository.PermissionTypeRepository;
import com.system.org.service.IPermissionTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class PermissionTypeServiceImpl implements IPermissionTypeService {

    private Logger logger = LoggerFactory.getLogger(PermissionTypeServiceImpl.class);

    @Autowired
    private PermissionTypeRepository permissionTypeRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createPermissionType(PermissionTypeDto permissionTypeDto) {
        if (permissionTypeDto.getPermissionTypeName() == null) {
            return new Response("Error", "PermissionType Name not be null");
        } else if (this.permissionTypeRepository.findPermissionTypeByPermissionTypeNameAndActiveStatus(
            permissionTypeDto.getPermissionTypeName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "PermissionType Name already exist");
        }
        PermissionType permissionType = new PermissionType();
        permissionType.setPermissionTypeUuid(UUID.randomUUID().toString());
        permissionType.setPermissionTypeName(permissionTypeDto.getPermissionTypeName());
        permissionType.setPermissionTypeShortDescription(permissionTypeDto.getPermissionTypeShortDescription());
        permissionType.setPermissionTypeDescription(permissionTypeDto.getPermissionTypeDescription());
        permissionType.setCreatedBy(permissionTypeDto.getCreatedBy());
        permissionType.setActiveStatus(ActiveStatus.Y);
        permissionType = this.permissionTypeRepository.saveAndFlush(permissionType);
        return new Response("Success", "PermissionType save successfully", permissionType);
    }

    @Override
    public Response updatePermissionType(PermissionTypeDto permissionTypeDto) {
        if (permissionTypeDto.getPermissionTypeUuid() == null) {
            return new Response("Error", "PermissionTyp Id not be null");
        } if (permissionTypeDto.getPermissionTypeName() == null) {
            return new Response("Error", "PermissionTyp Name not be null");
        }
        Optional<PermissionType> permissionType = this.permissionTypeRepository.findPermissionTypeByPermissionTypeUuid(
            permissionTypeDto.getPermissionTypeUuid());
        if (!permissionType.isPresent()) {
            return new Response("Error", "PermissionTyp not found with the with given id " + permissionTypeDto.getPermissionTypeUuid());
        }
        PermissionType permissionType1 = permissionType.get();
        if (permissionType1.getPermissionTypeUuid() != null) {
            permissionType1.setPermissionTypeUuid(permissionType1.getPermissionTypeUuid());
        }
        if (permissionTypeDto.getPermissionTypeName() != null) {
            permissionType1.setPermissionTypeName(permissionTypeDto.getPermissionTypeName());
        }
        if (permissionTypeDto.getPermissionTypeShortDescription() != null) {
            permissionType1.setPermissionTypeShortDescription(permissionTypeDto.getPermissionTypeShortDescription());
        }
        if (permissionTypeDto.getPermissionTypeDescription() != null) {
            permissionType1.setPermissionTypeDescription(permissionTypeDto.getPermissionTypeDescription());
        }
        if (permissionTypeDto.getUpdatedBy() != null) {
            permissionType1.setUpdatedBy(permissionTypeDto.getUpdatedBy());
        }
        if (permissionTypeDto.getActiveStatus() != null) {
            permissionType1.setActiveStatus(permissionTypeDto.getActiveStatus());
        }
        permissionType1 = this.permissionTypeRepository.saveAndFlush(permissionType1);
        return new Response("Success", "PermissionTyp update successfully", permissionType1);
    }

    @Override
    public Response findAllPermissionType() {
        return new Response("Success", "PermissionTyp find successfully",
            this.permissionTypeRepository.findAll());
    }

    @Override
    public Response findAllPermissionTypeSearch(PermissionTypeSearch permissionTypeSearch) {
        return this.utilService.findAllPermissionTypeSearch(permissionTypeSearch);
    }

    @Override
    public Response findPermissionTypeByPermissionTypeUuid(String permissionTypeUuid) {
        Optional<PermissionType> permissionType = this.permissionTypeRepository.findPermissionTypeByPermissionTypeUuid(permissionTypeUuid);
        if (permissionType.isPresent()) {
            return new Response("Success", "PermissionTyp find successfully", permissionType.get());
        } else {
            return new Response("Error", "PermissionTyp not find");
        }
    }

    @Override
    public Response deletePermissionTypeByPermissionTypeUuid(String permissionTypeUuid) {
        Optional<PermissionType> permissionType = this.permissionTypeRepository.findPermissionTypeByPermissionTypeUuid(permissionTypeUuid);
        permissionType.get().setActiveStatus(ActiveStatus.N);
        this.permissionTypeRepository.saveAndFlush(permissionType.get());
        return new Response("Success", "Delete successfully");

    }
}
