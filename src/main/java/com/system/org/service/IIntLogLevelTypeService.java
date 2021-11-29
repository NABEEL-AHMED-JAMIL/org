package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntLogLevelTypeDto;
import com.system.org.dto.search.IntLogLevelTypeSearch;

public interface IIntLogLevelTypeService {

    public Response createIntLogLevelType(IntLogLevelTypeDto intLogLevelTypeDto);

    public Response updateIntLogLevelType(IntLogLevelTypeDto intLogLevelTypeDto);

    public Response findAllIntLogLevelType();

    public Response findAllIntLogLevelTypeSearch(IntLogLevelTypeSearch intLogLevelTypeSearch);

    public Response findIntLogLevelTypeByIntLogLevelTypeUuid(String intLogLevelTypeUuid);

    public Response deleteIntLogLevelTypeByIntLogLevelTypeUuid(String intLogLevelTypeUuid);
}
