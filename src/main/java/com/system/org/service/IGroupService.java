package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.GroupDto;
import com.system.org.dto.search.GroupSearch;


public interface IGroupService {

    public Response createGroup(GroupDto groupDto);

    public Response updateGroup(GroupDto groupDto);

    public Response findAllGroup();

    public Response findAllGroupWithActiveStatus();

    public Response findAllGroupSearch(GroupSearch groupSearch);

    public Response findGroupByGroupUuid(String groupUuid);

    public Response deleteGroupByGroupUuid(String groupUuid);
}
