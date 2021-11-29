package com.system.org.service.impl;

import java.util.Optional;
import java.util.UUID;

import com.system.org.dto.search.OrganizationModuleLinkSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationModuleDto;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.OrganizationModule;
import com.system.org.repository.OrganizationModuleRepository;
import com.system.org.service.IOrganizationModuleService;


@Service
@Scope("singleton")
public class OrganizationModuleServiceImpl implements IOrganizationModuleService {

    private Logger logger = LoggerFactory.getLogger(OrganizationModuleServiceImpl.class);

    @Autowired
    private OrganizationModuleRepository organizationModuleRepository;
    @Autowired
    private UtilServiceImpl utilService;


    @Override
    public Response linkModuleToOrganization(OrganizationModuleDto organizationModuleDto) {
        logger.info(organizationModuleDto.toString());
        if (organizationModuleDto.getOrganizationUuid() == null) {
            return new Response("Error", "OrganizationSearch Uuid not be null");
        } else if (organizationModuleDto.getModuleLookupUuid() == null) {
            return new Response("Error", "ModulesLookup name not be null");
        }
        OrganizationModule organizationModule = new OrganizationModule();
        organizationModule.setOrganizationModuleUuid(UUID.randomUUID().toString());
        organizationModule.setOrganizationUuid(organizationModuleDto.getOrganizationUuid());
        organizationModule.setModuleLookupUuid(organizationModuleDto.getModuleLookupUuid());
        organizationModule.setCreatedBy(organizationModuleDto.getCreatedBy());
        organizationModule.setActiveStatus(ActiveStatus.Y);
        organizationModule = this.organizationModuleRepository.saveAndFlush(organizationModule);
        return new Response("Success", "OrganizationSearch Module save successfully", organizationModule);
    }

    @Override
    public Response upDateLinkModuleToOrganization(OrganizationModuleDto organizationModuleDto) {
        if (organizationModuleDto.getOrganizationModuleUuid() == null) {
            return new Response("Error", "OrganizationSearch Uuid not be null");
        } else if (organizationModuleDto.getModuleLookupUuid() == null) {
            return new Response("Error", "ModulesLookup name not be null");
        }
        OrganizationModule organizationModule = this.organizationModuleRepository.findByOrganizationModuleUuid(
            organizationModuleDto.getOrganizationModuleUuid()).get();
        organizationModule.setOrganizationModuleUuid(organizationModuleDto.getOrganizationModuleUuid());
        organizationModule.setOrganizationUuid(organizationModuleDto.getOrganizationUuid());
        organizationModule.setModuleLookupUuid(organizationModuleDto.getModuleLookupUuid());
        organizationModule.setUpdatedBy(organizationModuleDto.getUpdatedBy());
        organizationModule.setActiveStatus(organizationModuleDto.getActiveStatus());
        organizationModule = this.organizationModuleRepository.saveAndFlush(organizationModule);
        return new Response("Success", "OrganizationSearch Module save successfully", organizationModule);
    }

    @Override
    public Response findAllOrganizationModule() {
        return new Response("Success", "OrganizationSearch Module fetch successfully",
            this.organizationModuleRepository.findAll());
    }

    @Override
    public Response findAllOrganizationModuleLinkSearch(OrganizationModuleLinkSearch organizationModuleLinkSearch) {
        return this.utilService.findAllOrganizationModuleLinkSearch(organizationModuleLinkSearch);
    }

    @Override
    public Response findOrganizationModuleByOrganizationModuleUuid(String organizationModuleUuid) {
        return new Response("Success", "OrganizationSearch Module fetch successfully",
            this.organizationModuleRepository.findByOrganizationModuleUuid(organizationModuleUuid));
    }

    @Override
    public Response deleteOrganizationModuleByOrganizationModuleUuid(String organizationModuleUuid) {
        Optional<OrganizationModule> organizationModule = this.organizationModuleRepository.findByOrganizationModuleUuid(organizationModuleUuid);
        organizationModule.get().setActiveStatus(ActiveStatus.N);
        this.organizationModuleRepository.saveAndFlush(organizationModule.get());
        return new Response("Success", "Delete successfully");
    }
}
