package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntTransDto;
import com.system.org.dto.search.IntTransSearch;

public interface IIntTransService {

    public Response createIntTrans(IntTransDto intTransDto);

    public Response updateIntTrans(IntTransDto intTransDto);

    public Response findAllIntTrans();

    public Response findAllIntTransSearch(IntTransSearch intTransSearch);

    public Response findIntTransByIntTransUuid(String intTransUuid);

    public Response deleteIntTransByIntTransUuid(String intTransUuid);

}
