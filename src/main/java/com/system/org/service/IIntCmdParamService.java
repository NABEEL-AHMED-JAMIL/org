package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdParamDto;
import com.system.org.dto.search.IntCmdParamSearch;

public interface IIntCmdParamService {

    public Response createIntCmdParam(IntCmdParamDto intCmdParamDto);

    public Response updateIntCmdParam(IntCmdParamDto intCmdParamDto);

    public Response findAllIntCmdParam();

    public Response findAllIntCmdParamSearch(IntCmdParamSearch intCmdParamSearch);

    public Response findIntCmdParamByIntCmdParamUuid(String intCmdParamUuid);

    public Response deleteIntCmdParamByIntCmdParamUuid(String intCmdParamUuid);
}
