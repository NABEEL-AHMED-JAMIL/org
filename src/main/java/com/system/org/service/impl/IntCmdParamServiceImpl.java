package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdParamDto;
import com.system.org.dto.search.IntCmdParamSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntCmdParam;
import com.system.org.repository.IntCmdParamRepository;
import com.system.org.service.IIntCmdParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntCmdParamServiceImpl implements IIntCmdParamService {

    private Logger logger = LoggerFactory.getLogger(IntCmdParamServiceImpl.class);

    @Autowired
    private IntCmdParamRepository intCmdParamRepository;

    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntCmdParam(IntCmdParamDto intCmdParamDto) {
        IntCmdParam intCmdParam = new IntCmdParam();
        intCmdParam.setIntCmdParamUuid(UUID.randomUUID().toString());
        intCmdParam.setIntCmdParamIntCmdUuid(intCmdParamDto.getIntCmdParamIntCmdUuid());
        intCmdParam.setIntCmdParamIntCmdId(intCmdParamDto.getIntCmdParamIntCmdId());
        intCmdParam.setIntCmdParamName(intCmdParamDto.getIntCmdParamName());
        intCmdParam.setIntCmdParamDefaultvalue(intCmdParamDto.getIntCmdParamDefaultvalue());
        intCmdParam.setIntCmdParamDescription(intCmdParamDto.getIntCmdParamDescription());
        intCmdParam.setIntCmdParamShortdescription(intCmdParamDto.getIntCmdParamShortdescription());
        intCmdParam.setIntCmdParamPosition(intCmdParamDto.getIntCmdParamPosition());
        intCmdParam.setCreatedBy(intCmdParamDto.getCreatedBy());
        intCmdParam.setActiveStatus(ActiveStatus.Y);
        intCmdParam = this.intCmdParamRepository.saveAndFlush(intCmdParam);
        return new Response("Success", "IntCmdParam save successfully", intCmdParam);
    }

    @Override
    public Response updateIntCmdParam(IntCmdParamDto intCmdParamDto) {
        if (intCmdParamDto.getIntCmdParamUuid() == null) {
            return new Response("Error", "IntCmdParam id not be null");
        }
        Optional<IntCmdParam> intCmdParam = this.intCmdParamRepository.findByIntCmdParamUuid(intCmdParamDto.getIntCmdParamUuid());
        if (!intCmdParam.isPresent()) {
            return new Response("Error", "IntCmdParam not found with the with given id " + intCmdParamDto.getIntCmdParamUuid());
        }
        IntCmdParam intCmdParam1 = intCmdParam.get();
        if (intCmdParamDto.getIntCmdParamIntCmdUuid() != null) {
            intCmdParam1.setIntCmdParamIntCmdUuid(intCmdParamDto.getIntCmdParamIntCmdUuid());
        }
        if (intCmdParamDto.getIntCmdParamIntCmdId() != null) {
            intCmdParam1.setIntCmdParamIntCmdId(intCmdParamDto.getIntCmdParamIntCmdId());
        }
        if (intCmdParamDto.getIntCmdParamName() != null) {
            intCmdParam1.setIntCmdParamName(intCmdParamDto.getIntCmdParamName());
        }
        if (intCmdParamDto.getIntCmdParamDefaultvalue() != null) {
            intCmdParam1.setIntCmdParamDefaultvalue(intCmdParamDto.getIntCmdParamDefaultvalue());
        }
        if (intCmdParamDto.getIntCmdParamDescription() != null) {
            intCmdParam1.setIntCmdParamDescription(intCmdParamDto.getIntCmdParamDescription());
        }
        if (intCmdParamDto.getIntCmdParamShortdescription() != null) {
            intCmdParam1.setIntCmdParamShortdescription(intCmdParamDto.getIntCmdParamShortdescription());
        }
        if (intCmdParamDto.getIntCmdParamPosition() != null) {
            intCmdParam1.setIntCmdParamPosition(intCmdParamDto.getIntCmdParamPosition());
        }
        intCmdParam1.setUpdatedBy(intCmdParamDto.getUpdatedBy());
        if (intCmdParamDto.getActiveStatus() != null) {
            intCmdParam1.setActiveStatus(intCmdParamDto.getActiveStatus());
        }
        intCmdParam1 = this.intCmdParamRepository.saveAndFlush(intCmdParam1);
        return new Response("Success", "IntCmdParam save successfully", intCmdParam1);
    }

    @Override
    public Response findAllIntCmdParam() {
        return new Response("Success", "IntCmdParam find successfully", this.intCmdParamRepository.findAll());
    }

    @Override
    public Response findAllIntCmdParamSearch(IntCmdParamSearch intCmdParamSearch) {
        return this.utilService.findAllIntCmdParamSearch(intCmdParamSearch);
    }

    @Override
    public Response findIntCmdParamByIntCmdParamUuid(String intCmdParamUuid) {
        Optional<IntCmdParam> intCmdParam = this.intCmdParamRepository.findByIntCmdParamUuid(intCmdParamUuid);
        if (intCmdParam.isPresent()) {
            return new Response("Success", "IntCmdParam find successfully", intCmdParam.get());
        } else {
            return new Response("Error", "IntCmdParam not find");
        }
    }

    @Override
    public Response deleteIntCmdParamByIntCmdParamUuid(String intCmdParamUuid) {
        Optional<IntCmdParam> intCmdParam = this.intCmdParamRepository.findByIntCmdParamUuid(intCmdParamUuid);
        intCmdParam.get().setActiveStatus(ActiveStatus.N);
        this.intCmdParamRepository.save(intCmdParam.get());
        return new Response("Success", "IntCmdParam delete successfully");
    }
}
