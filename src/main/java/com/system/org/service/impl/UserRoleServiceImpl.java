package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.UserRoleDto;
import com.system.org.dto.search.UserRoleSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.UserRole;
import com.system.org.repository.UserRoleRepository;
import com.system.org.service.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class UserRoleServiceImpl implements IUserRoleService {

    private Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createUserRole(UserRoleDto userRoleDto) {
        if (userRoleDto.getPermissionId() == null) {
            return new Response("Error", "PermissionId not be null");
        } else if (userRoleDto.getUserId() == null) {
            return new Response("Error", "UserId not be null");
        }
        UserRole userRole = new UserRole();
        userRole.setUserRoleUuid(UUID.randomUUID().toString());
        userRole.setPermissionId(userRoleDto.getPermissionId());
        userRole.setUserId(userRoleDto.getUserId());
        userRole.setUserRoleAuthorizationUserId(userRoleDto.getUserRoleAuthorizationUserId());
        userRole.setUserRoleAvailableIndicator(userRoleDto.getUserRoleAvailableIndicator());
        userRole.setUserRoleExpirationDate(userRoleDto.getUserRoleExpirationDate());
        userRole.setCreatedBy(userRoleDto.getCreatedBy());
        userRole.setActiveStatus(ActiveStatus.Y);
        userRole = this.userRoleRepository.saveAndFlush(userRole);
        return new Response("Success", "UserRole find successfully", userRole);
    }

    @Override
    public Response updateUserRole(UserRoleDto userRoleDto) {
        if (userRoleDto.getUserRoleUuid() == null) {
            return new Response("Error", "UserRoleUuid not be null");
        } else if (userRoleDto.getPermissionId() == null) {
            return new Response("Error", "PermissionId not be null");
        } else if (userRoleDto.getUserId() == null) {
            return new Response("Error", "UserId not be null");
        }
        Optional<UserRole> userRole = this.userRoleRepository.findUserRoleByUserRoleUuid(userRoleDto.getUserRoleUuid());
        if (!userRole.isPresent()) {
            return new Response("Error", "UserRole not found with the with given id " + userRoleDto.getUserRoleUuid());
        }
        UserRole userRole1 = userRole.get();
        if (userRoleDto.getUserRoleUuid() != null) {
            userRole1.setUserRoleUuid(userRoleDto.getUserRoleUuid());
        }
        if (userRoleDto.getPermissionId() != null) {
            userRole1.setPermissionId(userRoleDto.getPermissionId());
        }
        if (userRoleDto.getUserId() != null) {
            userRole1.setUserId(userRoleDto.getUserId());
        }
        if (userRoleDto.getUserRoleAuthorizationUserId() != null) {
            userRole1.setUserRoleAuthorizationUserId(userRoleDto.getUserRoleAuthorizationUserId());
        }
        if (userRoleDto.getUserRoleAvailableIndicator() != null) {
            userRole1.setUserRoleAvailableIndicator(userRoleDto.getUserRoleAvailableIndicator());
        }
        if (userRoleDto.getUserRoleExpirationDate() != null) {
            userRole1.setUserRoleExpirationDate(userRoleDto.getUserRoleExpirationDate());
        }
        if (userRoleDto.getUpdatedBy() != null) {
            userRole1.setCreatedBy(userRoleDto.getCreatedBy());
        }
        userRole1.setActiveStatus(userRoleDto.getActiveStatus());
        userRole1 = this.userRoleRepository.saveAndFlush(userRole1);
        return new Response("Success", "UserRole find successfully", userRole1);
    }

    @Override
    public Response findAllUserRole() {
        return new Response("Success", "UserRole find successfully", this.userRoleRepository.findAll());
    }

    @Override
    public Response findAllUserRoleSearch(UserRoleSearch userRoleSearch) {
        return this.utilService.findAllUserRoleSearch(userRoleSearch);
    }

    @Override
    public Response findUserRoleByUserRoleUuid(String userRoleUuid) {
        Optional<UserRole> userRole = this.userRoleRepository.findUserRoleByUserRoleUuid(userRoleUuid);
        if (userRole.isPresent()) {
            return new Response("Success", "UserRole find successfully", userRole.get());
        } else {
            return new Response("Success", "UserRole not find");
        }
    }

    @Override
    public Response deleteUserRoleByUserRoleUuid(String userRoleUuid) {
        Optional<UserRole> userRole = this.userRoleRepository.findUserRoleByUserRoleUuid(userRoleUuid);
        userRole.get().setActiveStatus(ActiveStatus.N);
        this.userRoleRepository.saveAndFlush(userRole.get());
        return new Response("Success", "Delete successfully");
    }
}
