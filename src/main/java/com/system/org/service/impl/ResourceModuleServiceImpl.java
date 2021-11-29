package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceModuleDto;
import com.system.org.dto.search.ResourceModuleSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.ResourceModule;
import com.system.org.repository.ResourceModuleRepository;
import com.system.org.service.IResourceModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class ResourceModuleServiceImpl implements IResourceModuleService {

    private Logger logger = LoggerFactory.getLogger(ResourceModuleServiceImpl.class);

    @Autowired
    private ResourceModuleRepository resourceModuleRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createResourceModule(ResourceModuleDto resourceModuleDto) {
        if (resourceModuleDto.getResourceUuid() == null) {
            return new Response("Error", "Resource Uuid not be null");
        } else if (resourceModuleDto.getModuleUuid() == null) {
            return new Response("Error", "Module Uuid name not be null");
        }
        ResourceModule resourceModule = new ResourceModule();
        resourceModule.setResourceModuleUuid(UUID.randomUUID().toString());
        resourceModule.setResourceUuid(resourceModuleDto.getResourceUuid());
        resourceModule.setModuleUuid(resourceModuleDto.getModuleUuid());
        resourceModule.setActiveStatus(ActiveStatus.Y);
        resourceModule.setCreatedBy(resourceModuleDto.getCreatedBy());
        resourceModule = this.resourceModuleRepository.saveAndFlush(resourceModule);
        return new Response("Success", "ResourceModule save successfully", resourceModule);
    }

    @Override
    public Response updateResourceModule(ResourceModuleDto resourceModuleDto) {
        if (resourceModuleDto.getResourceUuid() == null) {
            return new Response("Error", "Resource Uuid not be null");
        } else if (resourceModuleDto.getModuleUuid() == null) {
            return new Response("Error", "Module Uuid name not be null");
        }
        Optional<ResourceModule> resourceModule = this.resourceModuleRepository.findByResourceModuleUuid(resourceModuleDto.getResourceModuleUuid());
        if (!resourceModule.isPresent()) {
            return new Response("Error", "ResourceModule not found with the with given id " + resourceModuleDto.getResourceModuleUuid());
        }
        ResourceModule resourceModule1 = resourceModule.get();
        if (resourceModuleDto.getResourceModuleUuid() != null) {
            resourceModule1.setResourceModuleUuid(resourceModuleDto.getResourceModuleUuid());
        }
        if (resourceModuleDto.getResourceUuid() != null) {
            resourceModule1.setResourceUuid(resourceModuleDto.getResourceUuid());
        }
        if (resourceModuleDto.getModuleUuid() != null) {
            resourceModule1.setModuleUuid(resourceModuleDto.getModuleUuid());
        }
        if (resourceModuleDto.getActiveStatus() != null) {
            resourceModule1.setActiveStatus(resourceModuleDto.getActiveStatus());
        }
        if (resourceModuleDto.getUpdatedBy() != null) {
            resourceModule1.setUpdatedBy(resourceModuleDto.getUpdatedBy());
        }
        resourceModule1 = this.resourceModuleRepository.saveAndFlush(resourceModule1);
        return new Response("Success", "ResourceModule update successfully", resourceModule1);
    }

    @Override
    public Response findAllResourceModule() {
        return new Response("Success", "ResourceModule find successfully",
            this.resourceModuleRepository.findAll());
    }

    @Override
    public Response findResourceModuleSearch(ResourceModuleSearch resourceModuleSearch) {
        return this.utilService.findResourceModuleSearch(resourceModuleSearch);
    }

    @Override
    public Response findResourceModuleByResourceModuleUuid(String resourceModuleUuid) {
        Optional<ResourceModule> resourceModule = this.resourceModuleRepository.findByResourceModuleUuid(resourceModuleUuid);
        if (resourceModule.isPresent()) {
            return new Response("Success", "ResourceModule find successfully", resourceModule.get());
        } else {
            return new Response("Error", "ResourceModule not find");
        }
    }

    @Override
    public Response deleteResourceModuleByResourceModuleUuid(String resourceModuleUuid) {
        Optional<ResourceModule> resourceModule = this.resourceModuleRepository.findByResourceModuleUuid(resourceModuleUuid);
        resourceModule.get().setActiveStatus(ActiveStatus.N);
        this.resourceModuleRepository.saveAndFlush(resourceModule.get());
        return new Response("Success", "Delete successfully");
    }
}
