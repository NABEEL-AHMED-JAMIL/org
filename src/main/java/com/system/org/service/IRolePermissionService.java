package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.RolePermissionDto;
import com.system.org.dto.search.RolePermissionSearch;

public interface IRolePermissionService {

    public Response createRolePermission(RolePermissionDto rolePermissionDto);

    public Response updateRolePermission(RolePermissionDto rolePermissionDto);

    public Response findAllRolePermission();

    public Response findAllRolePermissionSearch(RolePermissionSearch rolePermissionSearch);

    public Response findRolePermissionByRolePermissionUuid(String rolePermissionUuid);

    public Response deleteRolePermissionByRolePermissionUuid(String rolePermissionUuid);
}
