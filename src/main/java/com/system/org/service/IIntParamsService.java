package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntParamsDto;
import com.system.org.dto.search.IntParamsSearch;

public interface IIntParamsService {

    public Response createIntParams(IntParamsDto intParamsDto);

    public Response updateIntParams(IntParamsDto intParamsDto);

    public Response findAllIntParams();

    public Response findAllIntParamsSearch(IntParamsSearch intParamsSearch);

    public Response findIntParamsByIntParamsUuid(String intParamsUuid);

    public Response deleteIntParamsByIntParamsUuid(String intParamsUuid);
}
