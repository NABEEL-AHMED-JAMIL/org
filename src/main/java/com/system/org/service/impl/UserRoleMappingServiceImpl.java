package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.UserRoleMappingDto;
import com.system.org.dto.search.UserRoleMappingSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.UserRoleMapping;
import com.system.org.repository.UserRoleMappingRepository;
import com.system.org.service.IUserRoleMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("singleton")
public class UserRoleMappingServiceImpl implements IUserRoleMappingService {

    private Logger logger = LoggerFactory.getLogger(UserRoleMappingServiceImpl.class);

    @Autowired
    private UserRoleMappingRepository userRoleMappingRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createUserRoleMapping(UserRoleMappingDto userRoleMappingDto) {
        if (userRoleMappingDto.getUserId() == null) {
            return new Response("Error", "UserRoleMapping UserId not be null");
        } else if (userRoleMappingDto.getRoleId() == null) {
            return new Response("Error", "UserRoleMapping RoleId not be null");
        }
        UserRoleMapping userRoleMapping = new UserRoleMapping();
        userRoleMapping.setRoleId(userRoleMappingDto.getRoleId());
        userRoleMapping.setUserId(userRoleMappingDto.getUserId());
        userRoleMapping.setActiveStatus(ActiveStatus.Y);
        userRoleMapping = this.userRoleMappingRepository.saveAndFlush(userRoleMapping);
        return new Response("Success", "UserRoleMapping save successfully", userRoleMapping);
    }

    @Override
    public Response updateUserRoleMapping(UserRoleMappingDto userRoleMappingDto) {
        if (userRoleMappingDto.getId() == null) {
            return new Response("Error", "UserRoleMapping Id not be null");
        } else if (userRoleMappingDto.getUserId() == null) {
            return new Response("Error", "UserRoleMapping UserId not be null");
        } else if (userRoleMappingDto.getRoleId() == null) {
            return new Response("Error", "UserRoleMapping RoleId not be null");
        }
        Optional<UserRoleMapping> userRoleMapping = this.userRoleMappingRepository.findById(userRoleMappingDto.getId());
        if (!userRoleMapping.isPresent()) {
            return new Response("Success", "UserRoleMapping not find", userRoleMappingDto.getId());
        }
        UserRoleMapping userRoleMapping1 = userRoleMapping.get();
        if (userRoleMappingDto.getRoleId() != null) {
            userRoleMapping1.setRoleId(userRoleMappingDto.getRoleId());
        }
        if (userRoleMappingDto.getUserId() != null) {
            userRoleMapping1.setUserId(userRoleMappingDto.getUserId());
        }
        userRoleMapping1.setActiveStatus(userRoleMappingDto.getActiveStatus());
        userRoleMapping1 = this.userRoleMappingRepository.saveAndFlush(userRoleMapping1);
        return new Response("Success", "UserRoleMapping update successfully", userRoleMapping1);
    }

    @Override
    public Response findAllUserRoleMapping() {
        return new Response("Success", "UserRoleMapping find successfully",
                this.userRoleMappingRepository.findAll());
    }

    @Override
    public Response findAllUserRoleMappingSearch(UserRoleMappingSearch userRoleMappingSearch) {
        return this.utilService.findAllUserRoleMappingSearch(userRoleMappingSearch);
    }

    @Override
    public Response findUserRoleMappingById(Long id) {
        Optional<UserRoleMapping> userRoleMapping = this.userRoleMappingRepository.findById(id);
        if (userRoleMapping.isPresent()) {
            return new Response("Success", "UserRoleMapping find successfully", userRoleMapping.get());
        } else {
            return new Response("Success", "UserRoleMapping not find");
        }
    }

    @Override
    public Response deleteUserRoleMappingById(Long id) {
        Optional<UserRoleMapping> userRoleMapping = this.userRoleMappingRepository.findById(id);
        userRoleMapping.get().setActiveStatus(ActiveStatus.N);
        this.userRoleMappingRepository.saveAndFlush(userRoleMapping.get());
        return new Response("Success", "Delete successfully");
    }
}
