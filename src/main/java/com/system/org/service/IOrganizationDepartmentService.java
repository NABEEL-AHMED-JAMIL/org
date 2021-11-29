package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationDepartmentDto;
import com.system.org.dto.search.OrganizationDepartmentSearch;

public interface IOrganizationDepartmentService {

    public Response createOrganizationDepartment(OrganizationDepartmentDto organizationDepartmentDto);

    public Response updateOrganizationDepartment(OrganizationDepartmentDto organizationDepartmentDto);

    public Response findAllOrganizationDepartment();

    public Response findAllOrganizationDepartmentSearch(OrganizationDepartmentSearch organizationDepartmentSearch);

    public Response findOrganizationDepartmentByOrganizationDepartmentUuid(String organizationDepartmentUuid);

    public Response deleteOrganizationDepartmentByOrganizationDepartmentUuid(String organizationDepartmentUuid);
}
