package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationDto;
import com.system.org.dto.search.OrganizationSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.Organization;
import com.system.org.repository.OrganizationRepository;
import com.system.org.service.IOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class OrganizationServiceImpl implements IOrganizationService {

    private Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Autowired
    private QueryServices queryServices;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createOrganization(OrganizationDto organizationDto) {
        if (organizationDto.getOrganizationName() == null) {
            return new Response("Error", "OrganizationSearch Name not be null");
        } else if (this.organizationRepository.findByOrganizationNameAndActiveStatus(organizationDto.
            getOrganizationName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "OrganizationSearch already exist with the same name");
        }
        Organization organization = new Organization();
        organization.setOrganizationUuid(UUID.randomUUID().toString());
        organization.setOrganizationName(organizationDto.getOrganizationName());
        organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
        organization.setOrganizationShortDescription(organizationDto.getOrganizationShortDescription());
        organization.setCreatedBy(organizationDto.getCreatedBy());
        organization.setActiveStatus(ActiveStatus.Y);
        organization = this.organizationRepository.saveAndFlush(organization);
        return new Response("Success", "OrganizationSearch save successfully", organization);
    }

    @Override
    public Response updateOrganization(OrganizationDto organizationDto) {
        if (organizationDto.getOrganizationUuid() == null) {
            return new Response("Error", "OrganizationSearch Id not be null");
        } if (organizationDto.getOrganizationName() == null) {
            return new Response("Error", "OrganizationSearch Name not be null");
        }
        Optional<Organization> organization = this.organizationRepository.findByOrganizationUuid(organizationDto
            .getOrganizationUuid());
        if (!organization.isPresent()) {
            return new Response("Error", "OrganizationSearch not found with the with given id " + organizationDto.getOrganizationUuid());
        }
        Organization organization1 = organization.get();
        if (organizationDto.getOrganizationUuid() != null) {
            organization1.setOrganizationUuid(organizationDto.getOrganizationUuid());
        }
        if (organizationDto.getOrganizationName() != null) {
            organization1.setOrganizationName(organizationDto.getOrganizationName());
        }
        if (organizationDto.getOrganizationDescription() != null) {
            organization1.setOrganizationDescription(organizationDto.getOrganizationDescription());
        }
        if (organizationDto.getOrganizationShortDescription() != null) {
            organization1.setOrganizationShortDescription(organizationDto.getOrganizationShortDescription());
        }
        if (organizationDto.getUpdatedBy() != null) {
            organization1.setUpdatedBy(organizationDto.getUpdatedBy());
        }
        if (organizationDto.getActiveStatus() != null) {
            organization1.setActiveStatus(organizationDto.getActiveStatus());
        }
        organization1 = this.organizationRepository.saveAndFlush(organization1);
        return new Response("Success", "OrganizationSearch update successfully", organization1);
    }

    @Override
    public Response findAllOrganization() {
        return new Response("Success", "Organizations find successfully",
                this.organizationRepository.findAll());
    }

    @Override
    public Response findOrganizationBySearch(OrganizationSearch organizationSearch) {
        return this.utilService.findOrganizationBySearch(organizationSearch);
    }

    @Override
    public Response findOrganizationByOrganizationUuid(String organizationUuid) {
        Optional<Organization> organization = this.organizationRepository.findByOrganizationUuid(organizationUuid);
        if (organization.isPresent()) {
            return new Response("Success", "OrganizationSearch find successfully", organization.get());
        } else {
            return new Response("Error", "OrganizationSearch not find");
        }
    }

    @Override
    public Response deleteOrganizationByOrganizationUuid(String organizationUuid) {
        Optional<Organization> organization = this.organizationRepository.findByOrganizationUuid(organizationUuid);
//        String query = "select count(*) from organization\n" +
//                "inner join organization_module on organization_module.organization_uuid = organization.organization_uuid\n" +
//                "where organization.organization_uuid = '"+organization.get().getOrganizationUuid()+"' and organization_module.active_status='Y';";
//        if (Long.valueOf(this.queryServices.executeQueryForSingleResult(query).toString()) > 0) {
//            return new Response("Error", "OrganizationSearch attache with module");
//        }
        organization.get().setActiveStatus(ActiveStatus.N);
        this.organizationRepository.saveAndFlush(organization.get());
        return new Response("Success", "Delete successfully");
    }
}
