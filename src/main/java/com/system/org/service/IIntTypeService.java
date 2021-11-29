package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntTypeDto;
import com.system.org.dto.search.IntTypeSearch;

public interface IIntTypeService {

    public Response createIntType(IntTypeDto intTypeDto);

    public Response updateIntType(IntTypeDto intTypeDto);

    public Response findAllIntType();

    public Response findAllIntTypeSearch(IntTypeSearch intTypeSearch);

    public Response findIntTypeByIntTypeUuid(String intTypeUuid);

    public Response deleteIntTypeByIntTypeUuid(String intTypeUuid);
}
