package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntEnvTypeDto;
import com.system.org.dto.search.IntEnvTypeSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntEnvType;
import com.system.org.repository.IntEnvTypeRepository;
import com.system.org.service.IIntEnvTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class IntEnvTypeServiceImpl implements IIntEnvTypeService {

    private Logger logger = LoggerFactory.getLogger(IntEnvTypeServiceImpl.class);

    @Autowired
    private IntEnvTypeRepository intEnvTypeRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntEnvType(IntEnvTypeDto intEnvTypeDto) {
        if (intEnvTypeDto.getIntEnvTypeName() == null) {
            return new Response("Error", "IntEnvTypeName not be null");
        } else if (this.intEnvTypeRepository.findByIntEnvTypeNameAndActiveStatus(intEnvTypeDto.getIntEnvTypeName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "IntEnvTypeName already exist with the same name");
        }
        IntEnvType intEnvType = new IntEnvType();
        intEnvType.setIntEnvTypeUuid(UUID.randomUUID().toString());
        intEnvType.setIntEnvTypeName(intEnvTypeDto.getIntEnvTypeName());
        intEnvType.setIntEnvTypeDescription(intEnvTypeDto.getIntEnvTypeDescription());
        intEnvType.setIntEnvTypeShortDescription(intEnvTypeDto.getIntEnvTypeShortDescription());
        intEnvType.setCreatedBy(intEnvTypeDto.getCreatedBy());
        intEnvType.setActiveStatus(ActiveStatus.Y);
        intEnvType = this.intEnvTypeRepository.saveAndFlush(intEnvType);
        return new Response("Success", "IntEnvType save successfully", intEnvType);
    }

    @Override
    public Response updateIntEnvType(IntEnvTypeDto intEnvTypeDto) {
        if (intEnvTypeDto.getIntEnvTypeUuid() == null) {
            return new Response("Error", "IntAppUuId not be null");
        }
        Optional<IntEnvType> intEnvType = this.intEnvTypeRepository.findByIntEnvTypeUuid(intEnvTypeDto.getIntEnvTypeUuid());
        if (!intEnvType.isPresent()) {
            return new Response("Error", "IntEnvType not found with the with given id " + intEnvTypeDto.getIntEnvTypeUuid());
        }
        IntEnvType intEnvType1 = intEnvType.get();
        if (intEnvTypeDto.getIntEnvTypeName() != null) {
            intEnvType1.setIntEnvTypeName(intEnvTypeDto.getIntEnvTypeName());
        }
        if (intEnvTypeDto.getIntEnvTypeDescription() != null) {
            intEnvType1.setIntEnvTypeDescription(intEnvTypeDto.getIntEnvTypeDescription());
        }
        if (intEnvTypeDto.getIntEnvTypeShortDescription() != null) {
            intEnvType1.setIntEnvTypeShortDescription(intEnvTypeDto.getIntEnvTypeShortDescription());
        }
        intEnvType1.setActiveStatus(intEnvTypeDto.getActiveStatus());
        intEnvType1.setCreatedBy(intEnvTypeDto.getCreatedBy());

        intEnvType1 = this.intEnvTypeRepository.saveAndFlush(intEnvType1);
        return new Response("Success", "IntEnvType save successfully", intEnvType1);
    }

    @Override
    public Response findAllIntEnvType() {
        return new Response("Success",
                "IntEnvType find successfully", this.intEnvTypeRepository.findAll());
    }

    @Override
    public Response findAllIntEnvTypeSearch(IntEnvTypeSearch intEnvTypeSearch) {
        return this.utilService.findAllIntEnvTypeSearch(intEnvTypeSearch);
    }

    @Override
    public Response findIntEnvTypeByIntEnvTypeUuid(String intEnvTypeUuid) {
        Optional<IntEnvType> intEnvType = this.intEnvTypeRepository.findByIntEnvTypeUuid(intEnvTypeUuid);
        if (intEnvType.isPresent()) {
            return new Response("Success", "IntEnvType find successfully", intEnvType.get());
        } else {
            return new Response("Error", "IntEnvType not find");
        }
    }

    @Override
    public Response deleteIntEnvTypeByIntEnvTypeUuid(String intEnvTypeUuid) {
        Optional<IntEnvType> intEnvType = this.intEnvTypeRepository.findByIntEnvTypeUuid(intEnvTypeUuid);
        intEnvType.get().setActiveStatus(ActiveStatus.N);
        this.intEnvTypeRepository.save(intEnvType.get());
        return new Response("Success", "IntEnvType delete successfully");
    }
}
