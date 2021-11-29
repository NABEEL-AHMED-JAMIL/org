package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationDepartmentDto;
import com.system.org.dto.search.OrganizationDepartmentSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.OrganizationDepartment;
import com.system.org.repository.OrganizationDepartmentRepository;
import com.system.org.service.IOrganizationDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class OrganizationDepartmentServiceImpl implements IOrganizationDepartmentService {

    private Logger logger = LoggerFactory.getLogger(OrganizationDepartmentServiceImpl.class);

    @Autowired
    private OrganizationDepartmentRepository organizationDepartmentRepository;
    @Autowired
    private UtilServiceImpl utilService;


    @Override
    public Response createOrganizationDepartment(OrganizationDepartmentDto organizationDepartmentDto) {
        OrganizationDepartment organizationDepartment = new OrganizationDepartment();
        organizationDepartment.setOrganizationDepartmentUuid(UUID.randomUUID().toString());
        organizationDepartment.setOrganizationUuid(organizationDepartmentDto.getOrganizationUuid());
        organizationDepartment.setDepartmentLookupUuid(organizationDepartmentDto.getDepartmentLookupUuid());
        organizationDepartment.setCreatedBy(organizationDepartmentDto.getCreatedBy());
        organizationDepartment.setActiveStatus(ActiveStatus.Y);
        this.organizationDepartmentRepository.saveAndFlush(organizationDepartment);
        return new Response("Success", "OrganizationDepartment save successfully", organizationDepartment);
    }

    @Override
    public Response updateOrganizationDepartment(OrganizationDepartmentDto organizationDepartmentDto) {
        Optional<OrganizationDepartment> organizationDepartment = this.organizationDepartmentRepository.findByOrganizationDepartmentUuid(
                organizationDepartmentDto.getOrganizationDepartmentUuid());
        if (!organizationDepartment.isPresent()) {
            return new Response("Success", "OrganizationDepartment find successfully", organizationDepartment.get());
        }
        OrganizationDepartment organizationDepartment1 = organizationDepartment.get();
        organizationDepartment1.setOrganizationUuid(organizationDepartmentDto.getOrganizationUuid());
        organizationDepartment1.setDepartmentLookupUuid(organizationDepartmentDto.getDepartmentLookupUuid());
        organizationDepartment1.setUpdatedBy(organizationDepartmentDto.getUpdatedBy());
        organizationDepartment1.setActiveStatus(organizationDepartmentDto.getActiveStatus());
        this.organizationDepartmentRepository.saveAndFlush(organizationDepartment1);
        return new Response("Success", "OrganizationDepartment save successfully", organizationDepartment1);
    }

    @Override
    public Response findAllOrganizationDepartment() {
        return new Response("Success",
            "OrganizationDepartment find successfully", this.organizationDepartmentRepository.findAll());
    }

    @Override
    public Response findAllOrganizationDepartmentSearch(OrganizationDepartmentSearch organizationDepartmentSearch) {
        return this.utilService.findAllOrganizationDepartmentSearch(organizationDepartmentSearch);
    }

    @Override
    public Response findOrganizationDepartmentByOrganizationDepartmentUuid(String organizationDepartmentUuid) {
        Optional<OrganizationDepartment> organizationDepartment = this.organizationDepartmentRepository.findByOrganizationDepartmentUuid(organizationDepartmentUuid);
        if (organizationDepartment.isPresent()) {
            return new Response("Success", "OrganizationDepartment find successfully", organizationDepartment.get());
        } else {
            return new Response("Error", "OrganizationDepartment not find");
        }
    }

    @Override
    public Response deleteOrganizationDepartmentByOrganizationDepartmentUuid(String organizationDepartmentUuid) {
        Optional<OrganizationDepartment> organizationDepartment = this.organizationDepartmentRepository.findByOrganizationDepartmentUuid(organizationDepartmentUuid);
        organizationDepartment.get().setActiveStatus(ActiveStatus.N);
        this.organizationDepartmentRepository.saveAndFlush(organizationDepartment.get());
        return new Response("Success", "OrganizationDepartment delete successfully");
    }
}
