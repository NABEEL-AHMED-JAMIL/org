package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdDto;
import com.system.org.dto.search.IntCmdSearch;

public interface IIntCmdService {

    public Response createIntCmd(IntCmdDto intCmdDto);

    public Response updateIntCmd(IntCmdDto intCmdDto);

    public Response findAllIntCmd();

    public Response findAllIntCmdSearch(IntCmdSearch intCmdSearch);

    public Response findIntCmdByIntCmdUuid(String intCmdUuid);

    public Response deleteIntCmdByIntCmdUuid(String intCmdUuid);
}
