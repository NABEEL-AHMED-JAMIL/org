package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionResourceModuleDto;
import com.system.org.dto.search.PermissionResourceModuleSearch;

public interface IPermissionResourceModuleService {

    public Response createPermissionResourceModule(PermissionResourceModuleDto permissionResourceModuleDto);

    public Response updatePermissionResourceModule(PermissionResourceModuleDto permissionResourceModuleDto);

    public Response findAllPermissionResourceModule();

    public Response findAllPermissionResourceModuleSearch(PermissionResourceModuleSearch permissionResourceModuleSearch);

    public Response findPermissionResourceModuleByPermissionResourceModuleUuid(String permissionResourceModuleUuid);

    public Response deletePermissionResourceModuleByPermissionResourceModuleUuid(String permissionResourceModuleUuid);
}
