package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.UserRoleMappingDto;
import com.system.org.dto.search.UserRoleMappingSearch;


public interface IUserRoleMappingService {

    public Response createUserRoleMapping(UserRoleMappingDto userRoleMappingDto);

    public Response updateUserRoleMapping(UserRoleMappingDto userRoleMappingDto);

    public Response findAllUserRoleMapping();

    public Response findAllUserRoleMappingSearch(UserRoleMappingSearch userRoleMappingSearch);

    public Response findUserRoleMappingById(Long id);

    public Response deleteUserRoleMappingById(Long id);
}
