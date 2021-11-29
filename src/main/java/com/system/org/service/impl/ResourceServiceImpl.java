package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceDto;
import com.system.org.dto.search.ResourceSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.Resource;
import com.system.org.repository.ResourceRepository;
import com.system.org.service.IResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class ResourceServiceImpl implements IResourceService {

    private Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createResource(ResourceDto resourceDto) {
        if (resourceDto.getResourceName() == null) {
            return new Response("Error", "Resource Name not be null");
        } else if (this.resourceRepository.findByResourceNameAndActiveStatus(resourceDto.
                getResourceName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "Resource Name already exist with the same name");
        }
        Resource resource = new Resource();
        resource.setResourceUuid(UUID.randomUUID().toString());
        resource.setResourceName(resourceDto.getResourceName());
        resource.setResourceDesc(resourceDto.getResourceDesc());
        resource.setResourceType(resourceDto.getResourceType());
        resource.setResourceTypeDesc(resourceDto.getResourceTypeDesc());
        resource.setResourceVersionNumber(resourceDto.getResourceVersionNumber());
        resource.setResourceAvailableIndicator(resourceDto.getResourceAvailableIndicator());
        resource.setResourceParentId(resourceDto.getResourceParentId());
        resource.setResourceAuthUserId(resourceDto.getResourceAuthUserId());
        resource.setResourceResourceTypeUuid(resourceDto.getResourceAuthUserId());
        resource.setActiveStatus(ActiveStatus.Y);
        resource.setCreatedBy(resourceDto.getCreatedBy());
        resource = this.resourceRepository.saveAndFlush(resource);
        return new Response("Success", "Resource save successfully", resource);
    }

    @Override
    public Response updateResource(ResourceDto resourceDto) {
        if (resourceDto.getResourceUuid() == null) {
            return new Response("Error", "Resource Id not be null");
        } if (resourceDto.getResourceName() == null) {
            return new Response("Error", "Resource Name not be null");
        }
        Optional<Resource> resource = this.resourceRepository.findByResourceUuid(resourceDto.getResourceUuid());
        if (!resource.isPresent()) {
            return new Response("Error", "Resource not found with the with given id " + resourceDto.getResourceUuid());
        }
        Resource resource1 = resource.get();
        if (resourceDto.getResourceUuid() != null) {
            resource1.setResourceUuid(UUID.randomUUID().toString());
        }
        if (resourceDto.getResourceName() != null) {
            resource1.setResourceName(resourceDto.getResourceName());
        }
        if (resourceDto.getResourceDesc() != null) {
            resource1.setResourceDesc(resourceDto.getResourceDesc());
        }
        if (resourceDto.getResourceType() != null) {
            resource1.setResourceType(resourceDto.getResourceType());
        }
        if (resourceDto.getResourceTypeDesc() != null) {
            resource1.setResourceTypeDesc(resourceDto.getResourceTypeDesc());
        }
        if (resourceDto.getResourceVersionNumber() != null) {
            resource1.setResourceVersionNumber(resourceDto.getResourceVersionNumber());
        }
        if (resourceDto.getResourceAvailableIndicator() != null) {
            resource1.setResourceAvailableIndicator(resourceDto.getResourceAvailableIndicator());
        }
        if (resourceDto.getResourceParentId() != null) {
            resource1.setResourceParentId(resourceDto.getResourceParentId());
        }
        if (resourceDto.getResourceAuthUserId() != null) {
            resource1.setResourceAuthUserId(resourceDto.getResourceAuthUserId());
        }
        if (resourceDto.getResourceAuthUserId() != null) {
            resource1.setResourceResourceTypeUuid(resourceDto.getResourceAuthUserId());
        }
        if (resourceDto.getUpdatedBy() != null) {
            resource1.setUpdatedBy(resourceDto.getUpdatedBy());
        }
        if (resourceDto.getActiveStatus() != null) {
            resource1.setActiveStatus(resourceDto.getActiveStatus());
        }
        resource1 = this.resourceRepository.saveAndFlush(resource1);
        return new Response("Success", "Resource update successfully", resource1);
    }

    @Override
    public Response findAllResource() {
        return new Response("Success", "Resource find successfully",
                this.resourceRepository.findAll());
    }

    @Override
    public Response findAllResourceSearch(ResourceSearch resourceSearch) {
        return this.utilService.findAllResourceSearch(resourceSearch);
    }

    @Override
    public Response findResourceByResourceUuid(String resourceUuid) {
        Optional<Resource> resource = this.resourceRepository.findByResourceUuid(resourceUuid);
        if (resource.isPresent()) {
            return new Response("Success", "Resource find successfully", resource.get());
        } else {
            return new Response("Error", "Resource not find");
        }
    }

    @Override
    public Response deleteResourceByResourceUuid(String resourceUuid) {
        Optional<Resource> resource = this.resourceRepository.findByResourceUuid(resourceUuid);
        resource.get().setActiveStatus(ActiveStatus.N);
        this.resourceRepository.saveAndFlush(resource.get());
        return new Response("Success", "Delete successfully");
    }
}
