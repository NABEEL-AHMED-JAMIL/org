package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.UserOrganizationMappingDto;
import com.system.org.dto.search.UserOrganizationMappingSearch;

public interface IUserOrganizationMappingService {

    public Response createUserOrganizationMapping(UserOrganizationMappingDto userOrganizationMappingDto);

    public Response updateUserOrganizationMapping(UserOrganizationMappingDto userOrganizationMappingDto);

    public Response findAllUserOrganizationMapping();

    public Response findAllUserOrganizationMappingSearch(UserOrganizationMappingSearch userOrganizationMappingSearch);

    public Response findUserOrganizationMappingById(Long id);

    public Response deleteUserOrganizationMappingTypeById(Long id);

}
