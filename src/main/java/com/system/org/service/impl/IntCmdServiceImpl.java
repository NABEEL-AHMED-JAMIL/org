package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdDto;
import com.system.org.dto.search.IntCmdSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntCmd;
import com.system.org.repository.IntCmdRepository;
import com.system.org.service.IIntCmdService;
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
public class IntCmdServiceImpl implements IIntCmdService {

    private Logger logger = LoggerFactory.getLogger(IntCmdServiceImpl.class);

    @Autowired
    private IntCmdRepository intCmdRepository;

    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createIntCmd(IntCmdDto intCmdDto) {
        IntCmd intCmd = new IntCmd();
        intCmd.setIntCmdUuid(UUID.randomUUID().toString());
        intCmd.setIntCmdIntTypeId(intCmdDto.getIntCmdIntTypeId());
        intCmd.setIntCmdIntTypeUuid(intCmdDto.getIntCmdIntTypeUuid());
        intCmd.setIntCmdCmd(intCmdDto.getIntCmdCmd());
        intCmd.setIntCmdCmdUserfriendlyname(intCmdDto.getIntCmdCmdUserfriendlyname());
        intCmd.setIntCmdBlog(intCmdDto.getIntCmdBlog());
        intCmd.setIntCmdZebraId(intCmdDto.getIntCmdZebraId());
        intCmd.setIntCmdZebraUuid(intCmdDto.getIntCmdZebraUuid());
        intCmd.setCreatedBy(intCmdDto.getCreatedBy());
        intCmd.setActiveStatus(ActiveStatus.Y);
        intCmd = this.intCmdRepository.saveAndFlush(intCmd);
        return new Response("Success", "IntCmd save successfully", intCmd);
    }

    @Override
    public Response updateIntCmd(IntCmdDto intCmdDto) {
        if (intCmdDto.getIntCmdUuid() == null) {
            return new Response("Error", "IntCmd id not be null");
        }
        Optional<IntCmd> intCmd = this.intCmdRepository.findByIntCmdUuid(intCmdDto.getIntCmdUuid());
        if (!intCmd.isPresent()) {
            return new Response("Error", "IntCmd not found with the with given id " + intCmdDto.getIntCmdUuid());
        }
        IntCmd intCmd1 = intCmd.get();
        if (intCmdDto.getIntCmdIntTypeId() != null) {
            intCmd1.setIntCmdIntTypeId(intCmdDto.getIntCmdIntTypeId());
        }
        if (intCmdDto.getIntCmdIntTypeUuid() != null) {
            intCmd1.setIntCmdIntTypeUuid(intCmdDto.getIntCmdIntTypeUuid());
        }
        if (intCmdDto.getIntCmdCmd() != null) {
            intCmd1.setIntCmdCmd(intCmdDto.getIntCmdCmd());
        }
        if (intCmdDto.getIntCmdCmdUserfriendlyname() != null) {
            intCmd1.setIntCmdCmdUserfriendlyname(intCmdDto.getIntCmdCmdUserfriendlyname());
        }
        if (intCmdDto.getIntCmdBlog() != null) {
            intCmd1.setIntCmdBlog(intCmdDto.getIntCmdBlog());
        }
        if (intCmdDto.getIntCmdZebraId() != null) {
            intCmd1.setIntCmdZebraId(intCmdDto.getIntCmdZebraId());
        }
        if (intCmdDto.getIntCmdZebraUuid() != null) {
            intCmd1.setIntCmdZebraUuid(intCmdDto.getIntCmdZebraUuid());
        }
        intCmd1.setUpdatedBy(intCmdDto.getUpdatedBy());
        if (intCmdDto.getActiveStatus() != null) {
            intCmd1.setActiveStatus(intCmdDto.getActiveStatus());
        }
        intCmd1 = this.intCmdRepository.saveAndFlush(intCmd1);
        return new Response("Success", "IntCmd save successfully", intCmd1);
    }

    @Override
    public Response findAllIntCmd() {
        return new Response("Success", "IntCmd find successfully", this.intCmdRepository.findAll());
    }

    @Override
    public Response findAllIntCmdSearch(IntCmdSearch intCmdSearch) {
        return this.utilService.findAllIntCmdSearch(intCmdSearch);
    }

    @Override
    public Response findIntCmdByIntCmdUuid(String intCmdUuid) {
        Optional<IntCmd> intCmd = this.intCmdRepository.findByIntCmdUuid(intCmdUuid);
        if (intCmd.isPresent()) {
            return new Response("Success", "IntCmd find successfully", intCmd.get());
        } else {
            return new Response("Error", "IntCmd not find");
        }
    }

    @Override
    public Response deleteIntCmdByIntCmdUuid(String intCmdUuid) {
        Optional<IntCmd> intCmd = this.intCmdRepository.findByIntCmdUuid(intCmdUuid);
        intCmd.get().setActiveStatus(ActiveStatus.N);
        this.intCmdRepository.save(intCmd.get());
        return new Response("Success", "IntType delete successfully");
    }
}
