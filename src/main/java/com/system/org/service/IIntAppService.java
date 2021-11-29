package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntAppDto;
import com.system.org.dto.search.IntAppSearch;

public interface IIntAppService {

    public Response createIntApp(IntAppDto intAppDto);

    public Response updateIntApp(IntAppDto intAppDto);

    public Response findAllIntApp();

    public Response findAllIntAppSearch(IntAppSearch intAppSearch);

    public Response findIntAppByIntAppUuId(String intAppUuId);

    public Response deleteIntAppByIntAppUuId(String intAppUuId);
}
