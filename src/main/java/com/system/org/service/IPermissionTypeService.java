package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionTypeDto;
import com.system.org.dto.search.PermissionTypeSearch;

public interface IPermissionTypeService {

    public Response createPermissionType(PermissionTypeDto permissionTypeDto);

    public Response updatePermissionType(PermissionTypeDto permissionTypeDto);

    public Response findAllPermissionType();

    public Response findAllPermissionTypeSearch(PermissionTypeSearch permissionTypeSearch);

    public Response findPermissionTypeByPermissionTypeUuid(String permissionTypeUuid);

    public Response deletePermissionTypeByPermissionTypeUuid(String permissionTypeUuid);
}
