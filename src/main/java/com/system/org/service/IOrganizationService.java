package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationDto;
import com.system.org.dto.search.OrganizationSearch;

public interface IOrganizationService {

    public Response createOrganization(OrganizationDto organizationDto);

    public Response updateOrganization(OrganizationDto organizationDto);

    public Response findAllOrganization();

    public Response findOrganizationBySearch(OrganizationSearch organizationSearch);

    public Response findOrganizationByOrganizationUuid(String organizationUuid);

    public Response deleteOrganizationByOrganizationUuid(String organizationUuid);

}
