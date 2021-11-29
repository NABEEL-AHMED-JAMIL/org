package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntParamsDto;
import com.system.org.dto.search.IntParamsSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntCmd;
import com.system.org.model.IntCmdParam;
import com.system.org.model.IntParams;
import com.system.org.repository.IntParamsRepository;
import com.system.org.service.IIntParamsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntParamsServiceImpl implements IIntParamsService {

    private Logger logger = LoggerFactory.getLogger(IntParamsServiceImpl.class);

    @Autowired
    private IntParamsRepository intParamsRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntParams(IntParamsDto intParamsDto) {
        IntParams intParams = new IntParams();
        intParams.setIntParamsUuid(UUID.randomUUID().toString());
        intParams.setIntParamsName(intParamsDto.getIntParamsName());
        intParams.setIntParamsValue(intParamsDto.getIntParamsValue());
        intParams.setIntParamsTypeId(intParamsDto.getIntParamsTypeId());
        intParams.setIntParamsTypeuuId(intParamsDto.getIntParamsTypeuuId());
        intParams.setIntParamsLabel(intParamsDto.getIntParamsLabel());
        intParams.setIntParamsParamTypeId(intParamsDto.getIntParamsParamTypeId());
        intParams.setIntParamsParamTypeuuid(intParamsDto.getIntParamsParamTypeuuid());
        intParams.setCreatedBy(intParamsDto.getCreatedBy());
        intParams.setActiveStatus(ActiveStatus.Y);
        intParams = this.intParamsRepository.saveAndFlush(intParams);
        return new Response("Success", "IntParams save successfully", intParams);
    }

    @Override
    public Response updateIntParams(IntParamsDto intParamsDto) {
        if (intParamsDto.getIntParamsUuid() == null) {
            return new Response("Error", "IntParams id not be null");
        }
        Optional<IntParams> intParams = this.intParamsRepository.findByIntParamsUuid(intParamsDto.getIntParamsUuid());
        if (!intParams.isPresent()) {
            return new Response("Error", "IntParams not found with the with given id " + intParamsDto.getIntParamsUuid());
        }
        IntParams intParams1 = intParams.get();
        if (intParamsDto.getIntParamsName() != null) {
            intParams1.setIntParamsName(intParamsDto.getIntParamsName());
        }
        if (intParamsDto.getIntParamsValue() != null) {
            intParams1.setIntParamsValue(intParamsDto.getIntParamsValue());
        }
        if (intParamsDto.getIntParamsTypeId() != null) {
            intParams1.setIntParamsTypeId(intParamsDto.getIntParamsTypeId());
        }
        if (intParamsDto.getIntParamsTypeuuId() != null) {
            intParams1.setIntParamsTypeuuId(intParamsDto.getIntParamsTypeuuId());
        }
        if (intParamsDto.getIntParamsLabel() != null) {
            intParams1.setIntParamsLabel(intParamsDto.getIntParamsLabel());
        }
        if (intParamsDto.getIntParamsParamTypeId() != null) {
            intParams1.setIntParamsParamTypeId(intParamsDto.getIntParamsParamTypeId());
        }
        if (intParamsDto.getIntParamsParamTypeuuid() != null) {
            intParams1.setIntParamsParamTypeuuid(intParamsDto.getIntParamsParamTypeuuid());
        }
        intParams1.setUpdatedBy(intParamsDto.getUpdatedBy());
        if (intParamsDto.getActiveStatus() != null) {
            intParams1.setActiveStatus(intParamsDto.getActiveStatus());
        }
        intParams1 = this.intParamsRepository.saveAndFlush(intParams1);
        return new Response("Success", "IntParams save successfully", intParams1);
    }

    @Override
    public Response findAllIntParams() {
        return new Response("Success", "IntParams find successfully", this.intParamsRepository.findAll());
    }

    @Override
    public Response findAllIntParamsSearch(IntParamsSearch intParamsSearch) {
        return this.utilService.findAllIntParamsSearch(intParamsSearch);
    }

    @Override
    public Response findIntParamsByIntParamsUuid(String intParamsUuid) {
        Optional<IntParams> intParams = this.intParamsRepository.findByIntParamsUuid(intParamsUuid);
        if (intParams.isPresent()) {
            return new Response("Success", "IntParams find successfully", intParams.get());
        } else {
            return new Response("Error", "IntParams not find");
        }
    }

    @Override
    public Response deleteIntParamsByIntParamsUuid(String intParamsUuid) {
        Optional<IntParams> intParams = this.intParamsRepository.findByIntParamsUuid(intParamsUuid);
        intParams.get().setActiveStatus(ActiveStatus.N);
        this.intParamsRepository.save(intParams.get());
        return new Response("Success", "IntParams delete successfully");
    }
}
