package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.ModulesLookupDto;
import com.system.org.dto.search.ModuleSearch;


public interface IModuleLookupService {

    public Response createModulesLookup(ModulesLookupDto modulesLookupDto);

    public Response updateModulesLookup(ModulesLookupDto modulesLookupDto);

    public Response findAllModulesLookup();

    public Response findAllModulesLookupBySearch(ModuleSearch moduleSearch);

    public Response findModulesLookupByModulesLookupUuid(String modulesLookupUuid);

    public Response deleteModulesLookupByModulesLookupUuid(String modulesLookupUuid);

}
