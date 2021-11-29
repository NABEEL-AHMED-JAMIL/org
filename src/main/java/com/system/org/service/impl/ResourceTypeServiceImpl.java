package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceTypeDto;
import com.system.org.dto.search.ResourceTypeSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.ResourceType;
import com.system.org.repository.ResourceTypeRepository;
import com.system.org.service.IResourceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class ResourceTypeServiceImpl implements IResourceTypeService {

    private Logger logger = LoggerFactory.getLogger(ResourceTypeServiceImpl.class);

    @Autowired
    private ResourceTypeRepository resourceTypeRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createResourceType(ResourceTypeDto resourceTypeDto) {
        if (resourceTypeDto.getResourceTypeName() == null) {
            return new Response("Error", "ResourceType Name not be null");
        } else if (this.resourceTypeRepository.findByResourceTypeNameAndActiveStatus(resourceTypeDto.
                getResourceTypeName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "ResourceType Name already exist with the same name");
        }
        ResourceType resourceType = new ResourceType();
        resourceType.setResourceTypeUuid(UUID.randomUUID().toString());
        resourceType.setResourceTypeName(resourceTypeDto.getResourceTypeName());
        resourceType.setResourceTypeDesc(resourceTypeDto.getResourceTypeDesc());
        resourceType.setCreatedBy(resourceTypeDto.getCreatedBy());
        resourceType.setActiveStatus(ActiveStatus.Y);
        resourceType = this.resourceTypeRepository.saveAndFlush(resourceType);
        return new Response("Success", "Resource save successfully", resourceType);

    }

    @Override
    public Response updateResourceType(ResourceTypeDto resourceTypeDto) {
        if (resourceTypeDto.getResourceTypeUuid() == null) {
            return new Response("Error", "ResourceType Id not be null");
        } if (resourceTypeDto.getResourceTypeName() == null) {
            return new Response("Error", "ResourceType Name not be null");
        }
        Optional<ResourceType> resourceType = this.resourceTypeRepository.findByResourceTypeUuid(resourceTypeDto
                .getResourceTypeUuid());
        if (!resourceType.isPresent()) {
            return new Response("Error", "ResourceType not found with the with given id " + resourceTypeDto.getResourceTypeUuid());
        }
        ResourceType resourceType1 = resourceType.get();
        if (resourceTypeDto.getResourceTypeUuid() != null) {
            resourceType1.setResourceTypeUuid(resourceTypeDto.getResourceTypeUuid());
        }
        if (resourceTypeDto.getResourceTypeName() != null) {
            resourceType1.setResourceTypeName(resourceTypeDto.getResourceTypeName());
        }
        if (resourceTypeDto.getResourceTypeDesc() != null) {
            resourceType1.setResourceTypeDesc(resourceTypeDto.getResourceTypeDesc());
        }
        if (resourceTypeDto.getUpdatedBy() != null) {
            resourceType1.setUpdatedBy(resourceTypeDto.getUpdatedBy());
        }
        if (resourceTypeDto.getActiveStatus() != null) {
            resourceType1.setActiveStatus(resourceTypeDto.getActiveStatus());
        }
        resourceType1 = this.resourceTypeRepository.saveAndFlush(resourceType1);
        return new Response("Success", "Resource update successfully", resourceType1);

    }

    @Override
    public Response findAllResourceType() {
        return new Response("Success", "ResourceType find successfully",
            this.resourceTypeRepository.findAll());
    }

    @Override
    public Response findAllResourceTypeSearch(ResourceTypeSearch resourceTypeSearch) {
        return this.utilService.findAllResourceTypeSearch(resourceTypeSearch);
    }

    @Override
    public Response findResourceTypeByResourceTypeUuid(String resourceTypeUuid) {
        Optional<ResourceType> resourceType = this.resourceTypeRepository.findByResourceTypeUuid(resourceTypeUuid);
        if (resourceType.isPresent()) {
            return new Response("Success", "ResourceType find successfully", resourceType.get());
        } else {
            return new Response("Success", "ResourceType not find");
        }
    }

    @Override
    public Response deleteResourceTypeByResourceTypeUuid(String resourceTypeUuid) {
        Optional<ResourceType> resourceType = this.resourceTypeRepository.findByResourceTypeUuid(resourceTypeUuid);
        resourceType.get().setActiveStatus(ActiveStatus.N);
        this.resourceTypeRepository.saveAndFlush(resourceType.get());
        return new Response("Success", "Delete successfully");
    }
}
