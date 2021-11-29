package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntAppDto;
import com.system.org.dto.search.IntAppSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntApp;
import com.system.org.repository.IntAppRepository;
import com.system.org.service.IIntAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntAppServiceImpl implements IIntAppService {

    private Logger logger = LoggerFactory.getLogger(IntAppServiceImpl.class);

    @Autowired
    private IntAppRepository intAppRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntApp(IntAppDto intAppDto) {
        if (intAppDto.getIntAppName() == null) {
            return new Response("Error", "IntAppName not be null");
        } else if (this.intAppRepository.findByIntAppNameAndActiveStatus(intAppDto.getIntAppName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "IntAppName already exist with the same name");
        }
        IntApp intApp = new IntApp();
        intApp.setIntAppUuId(UUID.randomUUID().toString());
        intApp.setIntAppName(intAppDto.getIntAppName());
        intApp.setIntAppDesc(intAppDto.getIntAppDesc());
        intApp.setIntAppOrgId(intAppDto.getIntAppOrgId());
        intApp.setIntAppOrgUUId(intAppDto.getIntAppOrgUUId());
        intApp.setIntAppShortDesc(intAppDto.getIntAppShortDesc());
        intApp.setCreatedBy(intAppDto.getCreatedBy());
        intApp.setActiveStatus(ActiveStatus.Y);
        this.intAppRepository.saveAndFlush(intApp);
        return new Response("Success", "IntApp save successfully", intApp);
    }

    @Override
    public Response updateIntApp(IntAppDto intAppDto) {
        if (intAppDto.getIntAppUuId() == null) {
            return new Response("Error", "IntAppUuId id not be null");
        }
        Optional<IntApp> intApp = this.intAppRepository.findByIntAppUuId(intAppDto.getIntAppUuId());
        if (!intApp.isPresent()) {
            return new Response("Error", "IntAppUuId not found with the with given id " + intAppDto.getIntAppUuId());
        }
        IntApp intApp1 = intApp.get();
        if (intAppDto.getIntAppName() != null) {
            intApp1.setIntAppName(intAppDto.getIntAppName());
        }
        if (intAppDto.getIntAppDesc() != null) {
            intApp1.setIntAppDesc(intAppDto.getIntAppDesc());
        }
        if (intAppDto.getIntAppOrgId() != null) {
            intApp1.setIntAppOrgId(intAppDto.getIntAppOrgId());
        }
        if (intAppDto.getIntAppOrgUUId() != null) {
            intApp1.setIntAppOrgUUId(intAppDto.getIntAppOrgUUId());
        }
        if (intAppDto.getIntAppShortDesc() != null) {
            intApp1.setIntAppShortDesc(intAppDto.getIntAppShortDesc());
        }
        intApp1.setUpdatedBy(intAppDto.getUpdatedBy());
        intApp1.setActiveStatus(intAppDto.getActiveStatus());
        intApp1 = this.intAppRepository.saveAndFlush(intApp1);
        return new Response("Success", "IntApp update successfully", intApp1);
    }

    @Override
    public Response findAllIntApp() {
        return new Response("Success",
            "IntApp find successfully", this.intAppRepository.findAll());
    }

    @Override
    public Response findAllIntAppSearch(IntAppSearch intAppSearch) {
        return this.utilService.findAllIntAppSearch(intAppSearch);
    }

    @Override
    public Response findIntAppByIntAppUuId(String intAppUuId) {
        Optional<IntApp> intApp = this.intAppRepository.findByIntAppUuId(intAppUuId);
        if (intApp.isPresent()) {
            return new Response("Success", "IntApp find successfully", intApp.get());
        } else {
            return new Response("Error", "IntApp not find");
        }
    }

    @Override
    public Response deleteIntAppByIntAppUuId(String intAppUuId) {
        Optional<IntApp> intApp = this.intAppRepository.findByIntAppUuId(intAppUuId);
        intApp.get().setActiveStatus(ActiveStatus.N);
        this.intAppRepository.save(intApp.get());
        return new Response("Success", "IntApp delete successfully");
    }
}
