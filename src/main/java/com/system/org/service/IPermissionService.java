package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionDto;
import com.system.org.dto.search.PermissionSearch;

public interface IPermissionService {

    public Response createPermission(PermissionDto permissionDto);

    public Response updatePermission(PermissionDto permissionDto);

    public Response findAllPermission();

    public Response findAllPermissionSearch(PermissionSearch permissionSearch);

    public Response findPermissionByPermissionUuid(String permissionUuid);

    public Response deletePermissionByPermissionUuid(String permissionUuid);

}
