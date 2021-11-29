package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceModuleDto;
import com.system.org.dto.search.ResourceModuleSearch;

public interface IResourceModuleService {

    public Response createResourceModule(ResourceModuleDto resourceModuleDto);

    public Response updateResourceModule(ResourceModuleDto resourceModuleDto);

    public Response findAllResourceModule();

    public Response findResourceModuleSearch(ResourceModuleSearch resourceModuleSearch);

    public Response findResourceModuleByResourceModuleUuid(String resourceModuleUuid);

    public Response deleteResourceModuleByResourceModuleUuid(String resourceModuleUuid);
}
