package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationModuleDto;
import com.system.org.dto.search.OrganizationModuleLinkSearch;


public interface IOrganizationModuleService {

    public Response linkModuleToOrganization(OrganizationModuleDto organizationModuleDto);

    public Response upDateLinkModuleToOrganization(OrganizationModuleDto organizationModuleDto);

    public Response findAllOrganizationModule();

    public Response findAllOrganizationModuleLinkSearch(OrganizationModuleLinkSearch organizationModuleLinkSearch);

    public Response findOrganizationModuleByOrganizationModuleUuid(String organizationModuleUuid);

    public Response deleteOrganizationModuleByOrganizationModuleUuid(String organizationModuleUuid);

}
