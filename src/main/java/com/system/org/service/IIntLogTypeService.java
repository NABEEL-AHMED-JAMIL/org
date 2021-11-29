package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.IntLogTypeDto;
import com.system.org.dto.search.IntLogTypeSearch;


public interface IIntLogTypeService {
    
    public Response createIntLogType(IntLogTypeDto intLogTypeDto);
    
    public Response updateIntLogType(IntLogTypeDto intLogTypeDto);
        
    public Response findAllIntLogType();
    
    public Response findAllIntLogTypSearch(IntLogTypeSearch intLogTypeSearch);

    public Response findIntLogTypByIntLogTypeUuid(String intLogTypeUuid);
    
    public Response deleteIntLogTypByIntLogTypeUuid(String intLogTypeUuid);

}
