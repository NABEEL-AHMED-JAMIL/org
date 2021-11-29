package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceDto;
import com.system.org.dto.search.ResourceSearch;

public interface IResourceService {

    public Response createResource(ResourceDto resourceDto);

    public Response updateResource(ResourceDto resourceDto);

    public Response findAllResource();

    public Response findAllResourceSearch(ResourceSearch resourceSearch);

    public Response findResourceByResourceUuid(String resourceUuid);

    public Response deleteResourceByResourceUuid(String resourceUuid);
}
