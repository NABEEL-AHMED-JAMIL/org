package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.UserGroupMappingDto;
import com.system.org.dto.search.UserGroupMappingSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.UserGroupMapping;
import com.system.org.repository.UserGroupMappingRepository;
import com.system.org.service.IUserGroupMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("singleton")
public class UserGroupMappingServiceImpl implements IUserGroupMappingService {

    private Logger logger = LoggerFactory.getLogger(UserGroupMappingServiceImpl.class);

    @Autowired
    private UserGroupMappingRepository userGroupMappingRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createUserGroupMapping(UserGroupMappingDto userGroupMappingDto) {
        if (userGroupMappingDto.getUserId() == null) {
            return new Response("Error", "UserOrganizationMapping UserId not be null");
        } else if (userGroupMappingDto.getGroupId() == null) {
            return new Response("Error", "UserOrganizationMapping GroupId not be null");
        }
        UserGroupMapping userGroupMapping = new UserGroupMapping();
        userGroupMapping.setUserId(userGroupMappingDto.getUserId());
        userGroupMapping.setGroupId(userGroupMappingDto.getGroupId());
        userGroupMapping.setActiveStatus(ActiveStatus.Y);
        userGroupMapping = this.userGroupMappingRepository.saveAndFlush(userGroupMapping);
        return new Response("Success", "UserOrganizationMapping save successfully", userGroupMapping);
    }

    @Override
    public Response updateUserGroupMapping(UserGroupMappingDto userGroupMappingDto) {
        if (userGroupMappingDto.getId() == null) {
            return new Response("Error", "UserOrganizationMapping Id not be null");
        } else if (userGroupMappingDto.getUserId() == null) {
            return new Response("Error", "UserOrganizationMapping UserId not be null");
        } else if (userGroupMappingDto.getGroupId() == null) {
            return new Response("Error", "UserOrganizationMapping GroupId not be null");
        }
        Optional<UserGroupMapping> userGroupMapping = this.userGroupMappingRepository.findById(userGroupMappingDto.getId());
        if (!userGroupMapping.isPresent()) {
            return new Response("Success", "UserOrganizationMapping not find", userGroupMappingDto.getId());
        }
        UserGroupMapping userGroupMapping1 = userGroupMapping.get();
        if (userGroupMappingDto.getUserId() != null) {
            userGroupMapping1.setUserId(userGroupMappingDto.getUserId());
        }
        if (userGroupMappingDto.getGroupId() != null) {
            userGroupMapping1.setGroupId(userGroupMappingDto.getGroupId());
        }
        userGroupMapping1.setActiveStatus(userGroupMappingDto.getActiveStatus());
        userGroupMapping1 = this.userGroupMappingRepository.saveAndFlush(userGroupMapping1);
        return new Response("Success", "UserOrganizationMapping save successfully", userGroupMapping1);
    }

    @Override
    public Response findAllUserGroupMapping() {
        return new Response("Success", "UserGroupMapping find successfully",
            this.userGroupMappingRepository.findAll());
    }

    @Override
    public Response findAllUserGroupMappingSearch(UserGroupMappingSearch userGroupMappingSearch) {
        return this.utilService.findAllUserGroupMappingSearch(userGroupMappingSearch);
    }

    @Override
    public Response findUserGroupMappingById(Long id) {
        Optional<UserGroupMapping> userGroupMapping = this.userGroupMappingRepository.findById(id);
        if (userGroupMapping.isPresent()) {
            return new Response("Success", "UserGroupMapping find successfully", userGroupMapping.get());
        } else {
            return new Response("Success", "UserGroupMapping not find");
        }
    }

    @Override
    public Response deleteUserGroupMappingTypeById(Long id) {
        Optional<UserGroupMapping> userGroupMapping = this.userGroupMappingRepository.findById(id);
        userGroupMapping.get().setActiveStatus(ActiveStatus.N);
        this.userGroupMappingRepository.saveAndFlush(userGroupMapping.get());
        return new Response("Success", "Delete successfully");
    }
}
