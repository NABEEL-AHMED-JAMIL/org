package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.UserGroupMappingDto;
import com.system.org.dto.search.UserGroupMappingSearch;

public interface IUserGroupMappingService {

    public Response createUserGroupMapping(UserGroupMappingDto userGroupMappingDto);

    public Response updateUserGroupMapping(UserGroupMappingDto userGroupMappingDto);

    public Response findAllUserGroupMapping();

    public Response findAllUserGroupMappingSearch(UserGroupMappingSearch userGroupMappingSearch);

    public Response findUserGroupMappingById(Long id);

    public Response deleteUserGroupMappingTypeById(Long id);
}
