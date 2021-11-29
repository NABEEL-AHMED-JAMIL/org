package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntLogLevelTypeDto;
import com.system.org.dto.search.IntLogLevelTypeSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntLogLevelType;
import com.system.org.repository.IntLogLevelTypeRepository;
import com.system.org.service.IIntLogLevelTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntLogLevelTypeServiceImpl implements IIntLogLevelTypeService {

    private Logger logger = LoggerFactory.getLogger(IntLogLevelTypeServiceImpl.class);

    @Autowired
    private IntLogLevelTypeRepository intLogLevelTypeRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntLogLevelType(IntLogLevelTypeDto intLogLevelTypeDto) {
        if (intLogLevelTypeDto.getIntLogLevelTypeName() == null) {
            return new Response("Error", "IntLogLevelType not be null");
        } else if (this.intLogLevelTypeRepository.findByIntLogLevelTypeNameAndActiveStatus(
                intLogLevelTypeDto.getIntLogLevelTypeName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "IntLogLevelType already exist with the same name");
        }
        IntLogLevelType intLogLevelType = new IntLogLevelType();
        intLogLevelType.setIntLogLevelTypeUuid(UUID.randomUUID().toString());
        intLogLevelType.setIntLogLevelTypeDescription(intLogLevelTypeDto.getIntLogLevelTypeDescription());
        intLogLevelType.setIntLogLevelTypeName(intLogLevelTypeDto.getIntLogLevelTypeName());
        intLogLevelType.setIntLogLevelTypeShortDescription(intLogLevelTypeDto.getIntLogLevelTypeShortDescription());
        intLogLevelType.setCreatedBy(intLogLevelTypeDto.getCreatedBy());
        intLogLevelType.setActiveStatus(ActiveStatus.Y);
        this.intLogLevelTypeRepository.save(intLogLevelType);
        return new Response("Success", "IntLogLevelType save successfully", intLogLevelType);
    }

    @Override
    public Response updateIntLogLevelType(IntLogLevelTypeDto intLogLevelTypeDto) {
        if (intLogLevelTypeDto.getIntLogLevelTypeUuid() == null) {
            return new Response("Error", "IntLogLevelTypeUuid id not be null");
        }
        Optional<IntLogLevelType> intLogLevelType = this.intLogLevelTypeRepository.findByIntLogLevelTypeUuid(intLogLevelTypeDto.getIntLogLevelTypeUuid());
        if (!intLogLevelType.isPresent()) {
            return new Response("Error", "IntLogLevelTypeUuid not found with the with given id " + intLogLevelTypeDto.getIntLogLevelTypeUuid());
        }
        IntLogLevelType intLogLevelType1 = intLogLevelType.get();
        if (intLogLevelTypeDto.getIntLogLevelTypeDescription() != null) {
            intLogLevelType1.setIntLogLevelTypeDescription(intLogLevelTypeDto.getIntLogLevelTypeDescription());
        }
        if (intLogLevelTypeDto.getIntLogLevelTypeName() != null) {
            intLogLevelType1.setIntLogLevelTypeName(intLogLevelTypeDto.getIntLogLevelTypeName());
        }
        if (intLogLevelTypeDto.getIntLogLevelTypeShortDescription() != null) {
            intLogLevelType1.setIntLogLevelTypeShortDescription(intLogLevelTypeDto.getIntLogLevelTypeShortDescription());
        }
        intLogLevelType1.setUpdatedBy(intLogLevelTypeDto.getUpdatedBy());
        intLogLevelType1.setActiveStatus(intLogLevelTypeDto.getActiveStatus());
        this.intLogLevelTypeRepository.save(intLogLevelType1);
        return new Response("Success", "IntLogLevelType save successfully", intLogLevelType1);
    }

    @Override
    public Response findAllIntLogLevelType() {
        return new Response("Success", "IntLogLevelType find successfully",
            this.intLogLevelTypeRepository.findAll());
    }

    @Override
    public Response findAllIntLogLevelTypeSearch(IntLogLevelTypeSearch intLogLevelTypeSearch) {
        return this.utilService.findAllIntLogLevelTypeSearch(intLogLevelTypeSearch);
    }

    @Override
    public Response findIntLogLevelTypeByIntLogLevelTypeUuid(String intLogLevelTypeUuid) {
        Optional<IntLogLevelType> intLogLevelType = this.intLogLevelTypeRepository.findByIntLogLevelTypeUuid(intLogLevelTypeUuid);
        if (intLogLevelType.isPresent()) {
            return new Response("Success", "IntLogLevelType find successfully", intLogLevelType.get());
        } else {
            return new Response("Error", "IntLogLevelType not find");
        }
    }

    @Override
    public Response deleteIntLogLevelTypeByIntLogLevelTypeUuid(String intLogLevelTypeUuid) {
        Optional<IntLogLevelType> intLogLevelType = this.intLogLevelTypeRepository.findByIntLogLevelTypeUuid(intLogLevelTypeUuid);
        intLogLevelType.get().setActiveStatus(ActiveStatus.N);
        this.intLogLevelTypeRepository.save(intLogLevelType.get());
        return new Response("Success", "IntLogLevelType delete successfully");
    }
}
