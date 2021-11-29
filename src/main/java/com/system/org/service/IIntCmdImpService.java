package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdImpDto;
import com.system.org.dto.search.IntCmdImpSearch;


public interface IIntCmdImpService {

    public Response createIntCmdImp(IntCmdImpDto intCmdImpDto);

    public Response updateIntCmdImp(IntCmdImpDto intCmdImpDto);

    public Response findAllIntCmdImp();

    public Response findAllIntCmdImpSearch(IntCmdImpSearch intCmdImpSearch);

    public Response findIntCmdImpByIntCmdImpUuid(String intCmdImpUuid);

    public Response deleteIntCmdImpByIntCmdImpUuid(String intCmdImpUuid);
}
