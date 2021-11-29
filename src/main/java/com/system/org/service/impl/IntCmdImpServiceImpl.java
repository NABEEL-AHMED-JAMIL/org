package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdImpDto;
import com.system.org.dto.search.IntCmdImpSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntCmdImp;
import com.system.org.repository.IntCmdImpRepository;
import com.system.org.service.IIntCmdImpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntCmdImpServiceImpl implements IIntCmdImpService {

    private Logger logger = LoggerFactory.getLogger(IntCmdImpServiceImpl.class);

    @Autowired
    private IntCmdImpRepository impRepository;

    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntCmdImp(IntCmdImpDto intCmdImpDto) {
        IntCmdImp intCmdImp = new IntCmdImp();
        intCmdImp.setIntCmdImpUuid(UUID.randomUUID().toString());
        intCmdImp.setIntCmdImpIntCmdId(intCmdImpDto.getIntCmdImpIntCmdId());
        intCmdImp.setIntCmdImpIntCmdUuid(intCmdImpDto.getIntCmdImpIntCmdUuid());
        intCmdImp.setIntCmdImpIntCmdParamId(intCmdImpDto.getIntCmdImpIntCmdParamId());
        intCmdImp.setIntCmdImpIntCmdParamUuid(intCmdImpDto.getIntCmdImpIntCmdParamUuid());
        intCmdImp.setIntCmdImpIntCmdParamValue(intCmdImpDto.getIntCmdImpIntCmdParamValue());
        intCmdImp.setIntCmdImpUserUuid(intCmdImpDto.getIntCmdImpUserUuid());
        intCmdImp.setCreatedBy(intCmdImpDto.getCreatedBy());
        intCmdImp.setActiveStatus(ActiveStatus.Y);
        intCmdImp = this.impRepository.saveAndFlush(intCmdImp);
        return new Response("Success", "IntCmdImp save successfully", intCmdImp);
    }

    @Override
    public Response updateIntCmdImp(IntCmdImpDto intCmdImpDto) {
        if (intCmdImpDto.getIntCmdImpUuid() == null) {
            return new Response("Error", "IntCmdImp id not be null");
        }
        Optional<IntCmdImp> intCmdImp = this.impRepository.findByIntCmdImpUuid(intCmdImpDto.getIntCmdImpUuid());
        if (!intCmdImp.isPresent()) {
            return new Response("Error", "IntCmdImp not found with the with given id " + intCmdImpDto.getIntCmdImpUuid());
        }
        IntCmdImp intCmdImp1 = intCmdImp.get();
        if (intCmdImpDto.getIntCmdImpIntCmdId() != null) {
            intCmdImp1.setIntCmdImpIntCmdId(intCmdImpDto.getIntCmdImpIntCmdId());
        }
        if (intCmdImpDto.getIntCmdImpIntCmdUuid() != null) {
            intCmdImp1.setIntCmdImpIntCmdUuid(intCmdImpDto.getIntCmdImpIntCmdUuid());
        }
        if (intCmdImpDto.getIntCmdImpIntCmdParamId() != null) {
            intCmdImp1.setIntCmdImpIntCmdParamId(intCmdImpDto.getIntCmdImpIntCmdParamId());
        }
        if (intCmdImpDto.getIntCmdImpIntCmdParamUuid() != null) {
            intCmdImp1.setIntCmdImpIntCmdParamUuid(intCmdImpDto.getIntCmdImpIntCmdParamUuid());
        }
        if (intCmdImpDto.getIntCmdImpIntCmdParamValue() != null) {
            intCmdImp1.setIntCmdImpIntCmdParamValue(intCmdImpDto.getIntCmdImpIntCmdParamValue());
        }
        if (intCmdImpDto.getIntCmdImpUserUuid() != null) {
            intCmdImp1.setIntCmdImpUserUuid(intCmdImpDto.getIntCmdImpUserUuid());
        }
        if (intCmdImpDto.getUpdatedBy() != null) {
            intCmdImp1.setUpdatedBy(intCmdImpDto.getUpdatedBy());
        }
        if (intCmdImpDto.getActiveStatus() != null) {
            intCmdImp1.setActiveStatus(intCmdImpDto.getActiveStatus());
        }
        intCmdImp1 = this.impRepository.saveAndFlush(intCmdImp1);
        return new Response("Success", "IntCmdImp update successfully", intCmdImp1);
    }

    @Override
    public Response findAllIntCmdImp() {
        return new Response("Success", "IntCmdImp find successfully", this.impRepository.findAll());
    }

    @Override
    public Response findAllIntCmdImpSearch(IntCmdImpSearch intCmdImpSearch) {
        return this.utilService.findAllIntCmdImpSearch(intCmdImpSearch);
    }

    @Override
    public Response findIntCmdImpByIntCmdImpUuid(String intCmdImpUuid) {
        Optional<IntCmdImp> intCmdImp = this.impRepository.findByIntCmdImpUuid(intCmdImpUuid);
        if (intCmdImp.isPresent()) {
            return new Response("Success", "IntCmdImp find successfully", intCmdImp.get());
        } else {
            return new Response("Error", "IntCmdImp not find");
        }
    }

    @Override
    public Response deleteIntCmdImpByIntCmdImpUuid(String intCmdImpUuid) {
        Optional<IntCmdImp> intCmdImp = this.impRepository.findByIntCmdImpUuid(intCmdImpUuid);
        intCmdImp.get().setActiveStatus(ActiveStatus.N);
        this.impRepository.save(intCmdImp.get());
        return new Response("Success", "IntCmdImp delete successfully");
    }
}
