package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntLogTypeDto;
import com.system.org.dto.search.IntLogTypeSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntLogType;
import com.system.org.repository.IntLogTypeRepository;
import com.system.org.service.IIntLogTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntLogTypeServiceImpl implements IIntLogTypeService {

    private Logger logger = LoggerFactory.getLogger(IntLogTypeServiceImpl.class);

    @Autowired
    private IntLogTypeRepository intLogTypeRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntLogType(IntLogTypeDto intLogTypeDto) {
        if (intLogTypeDto.getIntLogTypeName() == null) {
            return new Response("Error", "IntLogTypeName not be null");
        } else if (this.intLogTypeRepository.findByIntLogTypeNameAndActiveStatus(
                intLogTypeDto.getIntLogTypeName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "IntLogTypeName already exist with the same name");
        }
        IntLogType intLogType = new IntLogType();
        intLogType.setIntLogTypeUuid(UUID.randomUUID().toString());
        intLogType.setIntLogTypeName(intLogTypeDto.getIntLogTypeName());
        intLogType.setIntLogTypeDescription(intLogTypeDto.getIntLogTypeDescription());
        intLogType.setIntLogTypeShortDescription(intLogTypeDto.getIntLogTypeShortDescription());
        intLogType.setCreatedBy(intLogTypeDto.getCreatedBy());
        intLogType.setActiveStatus(ActiveStatus.Y);
        this.intLogTypeRepository.saveAndFlush(intLogType);
        return new Response("Success", "IntLogTypeName save successfully", intLogType);
    }

    @Override
    public Response updateIntLogType(IntLogTypeDto intLogTypeDto) {
        if (intLogTypeDto.getIntLogTypeUuid() == null) {
            return new Response("Error", "IntLogTypeUuid not be null");
        }
        Optional<IntLogType> intLogType = this.intLogTypeRepository.findByIntLogTypeUuid(intLogTypeDto.getIntLogTypeUuid());
        if (!intLogType.isPresent()) {
            return new Response("Error", "IntLogTypeUuid not found with the with given id " + intLogTypeDto.getIntLogTypeUuid());
        }
        IntLogType intLogType1 = intLogType.get();
        if (intLogTypeDto.getIntLogTypeName() != null) {
            intLogType1.setIntLogTypeName(intLogTypeDto.getIntLogTypeName());
        }
        if (intLogTypeDto.getIntLogTypeDescription() != null) {
            intLogType1.setIntLogTypeDescription(intLogTypeDto.getIntLogTypeDescription());
        }
        if (intLogTypeDto.getIntLogTypeShortDescription() != null) {
            intLogType1.setIntLogTypeShortDescription(intLogTypeDto.getIntLogTypeShortDescription());
        }
        if (intLogTypeDto.getUpdatedBy() != null) {
            intLogType1.setUpdatedBy(intLogTypeDto.getUpdatedBy());
        }
        intLogType1.setActiveStatus(intLogTypeDto.getActiveStatus());
        this.intLogTypeRepository.saveAndFlush(intLogType1);
        return new Response("Success", "IntLogTypeName save successfully", intLogType1);
    }

    @Override
    public Response findAllIntLogType() {
        return new Response("Success",
            "IntLogType find successfully", this.intLogTypeRepository.findAll());
    }

    @Override
    public Response findAllIntLogTypSearch(IntLogTypeSearch intLogTypeSearch) {
        return this.utilService.findAllIntLogTypSearch(intLogTypeSearch);
    }

    @Override
    public Response findIntLogTypByIntLogTypeUuid(String intLogTypeUuid) {
        Optional<IntLogType> intLogType = this.intLogTypeRepository.findByIntLogTypeUuid(intLogTypeUuid);
        if (intLogType.isPresent()) {
            return new Response("Success", "IntLogType find successfully", intLogType.get());
        } else {
            return new Response("Error", "IntLogType not find");
        }
    }

    @Override
    public Response deleteIntLogTypByIntLogTypeUuid(String intLogTypeUuid) {
        Optional<IntLogType> intLogType = this.intLogTypeRepository.findByIntLogTypeUuid(intLogTypeUuid);
        intLogType.get().setActiveStatus(ActiveStatus.N);
        this.intLogTypeRepository.save(intLogType.get());
        return new Response("Success", "IntLogType delete successfully");
    }
}
