package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntTypeDto;
import com.system.org.dto.search.IntTypeSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntCmdParam;
import com.system.org.model.IntType;
import com.system.org.repository.IntTypeRepository;
import com.system.org.service.IIntTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntTypeServiceImpl implements IIntTypeService {

    private Logger logger = LoggerFactory.getLogger(IntTypeServiceImpl.class);

    @Autowired
    private IntTypeRepository intTypeRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntType(IntTypeDto intTypeDto) {
        IntType intType = new IntType();
        intType.setIntTypeUuid(UUID.randomUUID().toString());
        intType.setIntTypeName(intTypeDto.getIntTypeName());
        intType.setIntTypeShortDescription(intTypeDto.getIntTypeShortDescription());
        intType.setIntTypeDescription(intTypeDto.getIntTypeDescription());
        intType.setCreatedBy(intTypeDto.getCreatedBy());
        intType.setActiveStatus(ActiveStatus.Y);
        intType = this.intTypeRepository.saveAndFlush(intType);
        return new Response("Success", "IntType save successfully", intType);
    }

    @Override
    public Response updateIntType(IntTypeDto intTypeDto) {
        if (intTypeDto.getIntTypeUuid() == null) {
            return new Response("Error", "IntType id not be null");
        }
        Optional<IntType> intType = this.intTypeRepository.findByIntTypeUuid(intTypeDto.getIntTypeUuid());
        if (!intType.isPresent()) {
            return new Response("Error", "IntType not found with the with given id " + intTypeDto.getIntTypeUuid());
        }
        IntType intType1 = intType.get();
        if (intTypeDto.getIntTypeName() != null) {
            intType1.setIntTypeName(intTypeDto.getIntTypeName());
        }
        if (intTypeDto.getIntTypeShortDescription() != null) {
            intType1.setIntTypeShortDescription(intTypeDto.getIntTypeShortDescription());
        }
        if (intTypeDto.getIntTypeDescription() != null) {
            intType1.setIntTypeDescription(intTypeDto.getIntTypeDescription());
        }
        if (intTypeDto.getUpdatedBy() != null) {
            intType1.setUpdatedBy(intTypeDto.getUpdatedBy());
        }
        if (intTypeDto.getActiveStatus() != null) {
            intType1.setActiveStatus(intTypeDto.getActiveStatus());
        }
        intType1 = this.intTypeRepository.saveAndFlush(intType1);
        return new Response("Success", "IntType save successfully", intType1);
    }

    @Override
    public Response findAllIntType() {
        return new Response("Success", "IntType find successfully", this.intTypeRepository.findAll());
    }

    @Override
    public Response findAllIntTypeSearch(IntTypeSearch intTypeSearch) {
        return this.utilService.findAllIntTypeSearch(intTypeSearch);
    }

    @Override
    public Response findIntTypeByIntTypeUuid(String intTypeUuid) {
        Optional<IntType> intType = this.intTypeRepository.findByIntTypeUuid(intTypeUuid);
        if (intType.isPresent()) {
            return new Response("Success", "IntType find successfully", intType.get());
        } else {
            return new Response("Error", "IntType not find");
        }
    }

    @Override
    public Response deleteIntTypeByIntTypeUuid(String intTypeUuid) {
        Optional<IntType> intType = this.intTypeRepository.findByIntTypeUuid(intTypeUuid);
        intType.get().setActiveStatus(ActiveStatus.N);
        this.intTypeRepository.save(intType.get());
        return new Response("Success", "IntType delete successfully");
    }
}
