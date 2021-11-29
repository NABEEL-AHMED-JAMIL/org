package com.system.org.service.impl;

import java.util.Optional;
import java.util.UUID;

import com.system.org.dto.search.ModuleSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.system.org.controller.Response;
import com.system.org.dto.ModulesLookupDto;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.ModulesLookup;
import com.system.org.repository.ModulesLookupRepository;
import com.system.org.service.IModuleLookupService;

@Service
@Scope("singleton")
public class ModuleLookupServiceImpl implements IModuleLookupService {

    private Logger logger = LoggerFactory.getLogger(ModuleLookupServiceImpl.class);

    @Autowired
    private QueryServices queryServices;
    @Autowired
    private ModulesLookupRepository modulesLookupRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createModulesLookup(ModulesLookupDto modulesLookupDto) {
        if (modulesLookupDto.getModulesLookupNumber() == null) {
            return new Response("Error", "ModulesLookup number not be null");
        } else if (modulesLookupDto.getModulesLookupName() == null) {
            return new Response("Error", "ModulesLookup name not be null");
        } else if (this.modulesLookupRepository.findByModulesLookupNameAndActiveStatus(modulesLookupDto.
                getModulesLookupName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "ModulesLookup already exist with the same name");
        }
        ModulesLookup modulesLookup = new ModulesLookup();
        modulesLookup.setModulesLookupUuid(UUID.randomUUID().toString());
        modulesLookup.setModulesLookupNumber(modulesLookupDto.getModulesLookupNumber());
        modulesLookup.setModulesLookupShortDescription(modulesLookupDto.getModulesLookupShortDescription());
        modulesLookup.setModulesLookupName(modulesLookupDto.getModulesLookupName());
        modulesLookup.setModulesLookupDescription(modulesLookupDto.getModulesLookupDescription());
        modulesLookup.setCreatedBy(modulesLookupDto.getCreatedBy());
        modulesLookup.setActiveStatus(ActiveStatus.Y);
        modulesLookup = this.modulesLookupRepository.saveAndFlush(modulesLookup);
        return new Response("Success", "ModulesLookup save successfully", modulesLookup);
    }

    @Override
    public Response updateModulesLookup(ModulesLookupDto modulesLookupDto) {
        if (modulesLookupDto.getModulesLookupNumber() == null) {
            return new Response("Error", "ModulesLookup number not be null");
        } else if (modulesLookupDto.getModulesLookupName() == null) {
            return new Response("Error", "ModulesLookup name not be null");
        }
        Optional<ModulesLookup> modulesLookup = this.modulesLookupRepository.findByModulesLookupUuid(modulesLookupDto.getModulesLookupUuid());
        if (!modulesLookup.isPresent()) {
            return new Response("Error", "ModulesLookup not found with the with given id " + modulesLookupDto.getModulesLookupUuid());
        }
        ModulesLookup modulesLookup1 = modulesLookup.get();
        if (modulesLookupDto.getModulesLookupUuid() != null) {
            modulesLookup1.setModulesLookupUuid(modulesLookupDto.getModulesLookupUuid());
        }
        if (modulesLookupDto.getModulesLookupName() != null) {
            modulesLookup1.setModulesLookupName(modulesLookupDto.getModulesLookupName());
        }
        if (modulesLookupDto.getModulesLookupShortDescription() != null) {
            modulesLookup1.setModulesLookupShortDescription(modulesLookupDto.getModulesLookupShortDescription());
        }
        if (modulesLookupDto.getModulesLookupNumber() != null) {
            modulesLookup1.setModulesLookupNumber(modulesLookupDto.getModulesLookupNumber());
        }
        if (modulesLookupDto.getModulesLookupDescription() != null) {
            modulesLookup1.setModulesLookupDescription(modulesLookupDto.getModulesLookupDescription());
        }
        if (modulesLookupDto.getUpdatedBy() != null) {
            modulesLookup1.setUpdatedBy(modulesLookupDto.getUpdatedBy());
        }
        if (modulesLookupDto.getActiveStatus() != null) {
            modulesLookup1.setActiveStatus(modulesLookupDto.getActiveStatus());
        }
        modulesLookup1 = this.modulesLookupRepository.saveAndFlush(modulesLookup1);
        return new Response("Success", "ModulesLookup update successfully", modulesLookup1);
    }

    @Override
    public Response findAllModulesLookup() {
        return new Response("Success", "ModulesLookup find successfully",
            this.modulesLookupRepository.findAll());
    }

    @Override
    public Response findAllModulesLookupBySearch(ModuleSearch moduleSearch) {
        return this.utilService.findAllModulesLookupBySearch(moduleSearch);
    }

    @Override
    public Response findModulesLookupByModulesLookupUuid(String modulesLookupUuid) {
        Optional<ModulesLookup> organization = this.modulesLookupRepository.findByModulesLookupUuid(modulesLookupUuid);
        if (organization.isPresent()) {
            return new Response("Success", "ModulesLookup find successfully", organization.get());
        } else {
            return new Response("Error", "ModulesLookup not find");
        }
    }

    @Override
    public Response deleteModulesLookupByModulesLookupUuid(String modulesLookupUuid) {
        Optional<ModulesLookup> modulesLookup = this.modulesLookupRepository.findByModulesLookupUuid(modulesLookupUuid);
//        String query = "select count(*) from modules_lookup\n" +
//            "inner join organization_module on organization_module.modules_lookup_uuid = modules_lookup.modules_lookup_uuid\n" +
//            "where modules_lookup.modules_lookup_uuid = '"+modulesLookup.get().getModulesLookupUuid()+"' and organization_module.active_status='Y';";
//        if (Long.valueOf(this.queryServices.executeQueryForSingleResult(query).toString()) > 0) {
//            return new Response("Error", "ModulesLookup attache with organization");
//        }
        modulesLookup.get().setActiveStatus(ActiveStatus.N);
        this.modulesLookupRepository.save(modulesLookup.get());
        return new Response("Success", "ModulesLookup delete successfully");
    }
}
