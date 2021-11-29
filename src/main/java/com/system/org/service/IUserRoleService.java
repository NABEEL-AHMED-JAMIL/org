package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.UserRoleDto;
import com.system.org.dto.search.UserRoleSearch;

public interface IUserRoleService {

    public Response createUserRole(UserRoleDto userRoleDto);

    public Response updateUserRole(UserRoleDto userRoleDto);

    public Response findAllUserRole();

    public Response findAllUserRoleSearch(UserRoleSearch userRoleSearch);

    public Response findUserRoleByUserRoleUuid(String userRoleUuid);

    public Response deleteUserRoleByUserRoleUuid(String userRoleUuid);
}
