package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceTypeDto;
import com.system.org.dto.search.ResourceTypeSearch;

public interface IResourceTypeService {

    public Response createResourceType(ResourceTypeDto resourceTypeDto);

    public Response updateResourceType(ResourceTypeDto resourceTypeDto);

    public Response findAllResourceType();

    public Response findAllResourceTypeSearch(ResourceTypeSearch resourceTypeSearch);

    public Response findResourceTypeByResourceTypeUuid(String resourceTypeUuid);

    public Response deleteResourceTypeByResourceTypeUuid(String resourceTypeUuid);
}
