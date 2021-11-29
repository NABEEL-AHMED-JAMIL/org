package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.RoleDto;
import com.system.org.dto.search.RoleSearch;


public interface IRoleService {

    public Response createRole(RoleDto roleDto);

    public Response updateRole(RoleDto roleDto);

    public Response findAllRole();

    public Response findAllRoleSearch(RoleSearch roleSearch);

    public Response findRoleByRoleUuid(String roleUuid);

    public Response deleteRoleByRoleUuid(String roleUuid);
}
