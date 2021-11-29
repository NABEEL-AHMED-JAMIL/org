package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.UserOrganizationMappingDto;
import com.system.org.dto.search.UserOrganizationMappingSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.UserOrganizationMapping;
import com.system.org.repository.UserOrganizationMappingRepository;
import com.system.org.service.IUserOrganizationMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("singleton")
public class UserOrganizationMappingServiceImpl implements IUserOrganizationMappingService {

    private Logger logger = LoggerFactory.getLogger(UserOrganizationMappingServiceImpl.class);

    @Autowired
    private UserOrganizationMappingRepository userOrganizationMappingRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createUserOrganizationMapping(UserOrganizationMappingDto userOrganizationMappingDto) {
        if (userOrganizationMappingDto.getUserId() == null) {
            return new Response("Error", "UserOrganizationMapping UserId not be null");
        } else if (userOrganizationMappingDto.getOrgId() == null) {
            return new Response("Error", "UserOrganizationMapping OrgId not be null");
        }
        UserOrganizationMapping userOrganizationMapping = new UserOrganizationMapping();
        userOrganizationMapping.setUserId(userOrganizationMappingDto.getUserId());
        userOrganizationMapping.setOrgId(userOrganizationMappingDto.getOrgId());
        userOrganizationMapping.setActiveStatus(ActiveStatus.Y);
        userOrganizationMapping = this.userOrganizationMappingRepository.saveAndFlush(userOrganizationMapping);
        return new Response("Success", "UserOrganizationMapping save successfully", userOrganizationMapping);
    }

    @Override
    public Response updateUserOrganizationMapping(UserOrganizationMappingDto userOrganizationMappingDto) {
        if (userOrganizationMappingDto.getId() == null) {
            return new Response("Error", "UserOrganizationMapping Id not be null");
        } else if (userOrganizationMappingDto.getUserId() == null) {
            return new Response("Error", "UserOrganizationMapping UserId not be null");
        } else if (userOrganizationMappingDto.getOrgId() == null) {
            return new Response("Error", "UserOrganizationMapping OrgId not be null");
        }
        Optional<UserOrganizationMapping> userOrganizationMapping = this.userOrganizationMappingRepository.findById(userOrganizationMappingDto.getId());
        if (!userOrganizationMapping.isPresent()) {
            return new Response("Success", "UserOrganizationMapping not find", userOrganizationMappingDto.getId());
        }
        UserOrganizationMapping userOrganizationMapping1 = userOrganizationMapping.get();
        if (userOrganizationMappingDto.getUserId() != null) {
            userOrganizationMapping1.setUserId(userOrganizationMappingDto.getUserId());
        }
        if (userOrganizationMappingDto.getOrgId() != null) {
            userOrganizationMapping1.setOrgId(userOrganizationMappingDto.getOrgId());
        }
        userOrganizationMapping1.setActiveStatus(userOrganizationMappingDto.getActiveStatus());
        userOrganizationMapping1 = this.userOrganizationMappingRepository.saveAndFlush(userOrganizationMapping1);
        return new Response("Success", "UserOrganizationMapping save successfully", userOrganizationMapping1);
    }

    @Override
    public Response findAllUserOrganizationMapping() {
        return new Response("Success", "UserOrganizationMapping find successfully",
                this.userOrganizationMappingRepository.findAll());
    }

    @Override
    public Response findAllUserOrganizationMappingSearch(UserOrganizationMappingSearch userOrganizationMappingSearch) {
        return this.utilService.findAllUserOrganizationMappingSearch(userOrganizationMappingSearch);
    }

    @Override
    public Response findUserOrganizationMappingById(Long id) {
        Optional<UserOrganizationMapping> userOrganizationMapping = this.userOrganizationMappingRepository.findById(id);
        if (userOrganizationMapping.isPresent()) {
            return new Response("Success", "UserOrganizationMapping find successfully", userOrganizationMapping.get());
        } else {
            return new Response("Success", "UserOrganizationMapping not find");
        }
    }

    @Override
    public Response deleteUserOrganizationMappingTypeById(Long id) {
        Optional<UserOrganizationMapping> userOrganizationMapping = this.userOrganizationMappingRepository.findById(id);
        userOrganizationMapping.get().setActiveStatus(ActiveStatus.N);
        this.userOrganizationMappingRepository.saveAndFlush(userOrganizationMapping.get());
        return new Response("Success", "Delete successfully");
    }
}
