package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.search.*;
import com.system.org.enums.ActiveStatus;

public interface IUtilService {

    public Response getAllActiveUserUUID(ActiveStatus activeStatus);

    public Response getAllOrganizationUUID(ActiveStatus activeStatus);

    public Response getAllModuleLookupUUID(ActiveStatus activeStatus);

    public Response getAllResourceUUID(ActiveStatus activeStatus);

    public Response getAllPermissionUUID(ActiveStatus activeStatus);

    public Response getAllRoleUUID(ActiveStatus activeStatus);

    public Response getAllGroupUUID(ActiveStatus activeStatus);

    public Response getAllOrgUUID(ActiveStatus activeStatus);

    public Response getAllOrgID(ActiveStatus activeStatus);

    public Response getAllPermissionTypeUUID(ActiveStatus activeStatus);

    public Response getAllPermissionTypeUUID2(ActiveStatus activeStatus);

    public Response getAllResourceId(ActiveStatus activeStatus);

    public Response getAllResourceTypeId(ActiveStatus activeStatus);

    public Response getAllIntTypeId(ActiveStatus activeStatus);

    public Response getAllIntTypeUuid(ActiveStatus activeStatus);

    public Response getAllIntCmdParamId(ActiveStatus activeStatus);

    public Response getAllIntCmdParamUuid(ActiveStatus activeStatus);

    public Response getAllIntCmdId(ActiveStatus activeStatus);

    public Response getAllIntCmdUuid(ActiveStatus activeStatus);

    public Response findAllGroupSearch(GroupSearch groupSearch);

    public Response findAllIntCmdImpSearch(IntCmdImpSearch intCmdImpSearch);

    public Response findAllIntCmdParamSearch(IntCmdParamSearch intCmdParamSearch);

    public Response findAllIntCmdSearch(IntCmdSearch intCmdSearch);

    public Response findAllIntParamsSearch(IntParamsSearch intParamsSearch);

    public Response findAllIntTypeSearch(IntTypeSearch intTypeSearch);

    public Response findAllModulesLookupBySearch(ModuleSearch moduleSearch);

    public Response findAllOrganizationModuleLinkSearch(OrganizationModuleLinkSearch organizationModuleLinkSearch);

    public Response findOrganizationBySearch(OrganizationSearch organizationSearch);

    public Response findAllPermissionResourceModuleSearch(PermissionResourceModuleSearch permissionResourceModuleSearch);

    public Response findAllPermissionSearch(PermissionSearch permissionSearch);

    public Response findAllPermissionTypeSearch(PermissionTypeSearch permissionTypeSearch);

    public Response findResourceModuleSearch(ResourceModuleSearch resourceModuleSearch);

    public Response findAllResourceSearch(ResourceSearch resourceSearch);

    public Response findAllResourceTypeSearch(ResourceTypeSearch resourceTypeSearch);

    public Response findAllRolePermissionSearch(RolePermissionSearch rolePermissionSearch);

    public Response findAllRoleSearch(RoleSearch roleSearch);

    public Response findAllUserGroupMappingSearch(UserGroupMappingSearch userGroupMappingSearch);

    public Response findAllUserOrganizationMappingSearch(UserOrganizationMappingSearch userOrganizationMappingSearch);

    public Response findAllUserRoleMappingSearch(UserRoleMappingSearch userRoleMappingSearch);

    public Response findAllUserRoleSearch(UserRoleSearch userRoleSearch);

    public Response findAllUserSearch(UserSearch userSearch);

    public Response findAllIntAppSearch(IntAppSearch intAppSearch);

    public Response findAllIntEnvTypeSearch(IntEnvTypeSearch intEnvTypeSearch);

    public Response findAllIntLogLevelTypeSearch(IntLogLevelTypeSearch intLogLevelTypeSearch);

    public Response findAllIntLogTypSearch(IntLogTypeSearch intLogTypeSearch);

    public Response findAllOrganizationDepartmentSearch(OrganizationDepartmentSearch organizationDepartmentSearch);

    public Response findAllIntTransSearch(IntTransSearch intTransSearch);

    public Response findAllLoginUserRole(String username);

}
