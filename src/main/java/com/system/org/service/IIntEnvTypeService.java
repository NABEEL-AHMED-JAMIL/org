package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntEnvTypeDto;
import com.system.org.dto.search.IntEnvTypeSearch;

public interface IIntEnvTypeService {

    public Response createIntEnvType(IntEnvTypeDto intEnvTypeDto);

    public Response updateIntEnvType(IntEnvTypeDto intEnvTypeDto);

    public Response findAllIntEnvType();

    public Response findAllIntEnvTypeSearch(IntEnvTypeSearch intEnvTypeSearch);

    public Response findIntEnvTypeByIntEnvTypeUuid(String intEnvTypeUuid);

    public Response deleteIntEnvTypeByIntEnvTypeUuid(String intEnvTypeUuid);
}
