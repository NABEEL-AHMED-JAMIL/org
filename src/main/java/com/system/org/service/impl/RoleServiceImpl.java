package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.RoleDto;
import com.system.org.dto.search.RoleSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.Role;
import com.system.org.repository.RoleRepository;
import com.system.org.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class RoleServiceImpl implements IRoleService {

    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createRole(RoleDto roleDto) {
        if (roleDto.getRoleName() == null) {
            return new Response("Error", "RoleName not be null");
        } else if (roleDto.getRoleType() == null) {
            return new Response("Error", "RoleType not be null");
        }
        Role role = new Role();
        role.setRoleUuid(UUID.randomUUID().toString());
        role.setRoleName(roleDto.getRoleName());
        role.setRoleType(roleDto.getRoleType());
        role.setRoleLabel(roleDto.getRoleLabel());
        role.setRoleIndicator(roleDto.getRoleIndicator());
        role.setRoleAuthUserId(roleDto.getRoleAuthUserId());
        role.setRoleComments(roleDto.getRoleComments());
        role.setRoleGroup(roleDto.getRoleGroup());
        role.setCreatedBy(roleDto.getCreatedBy());
        role.setActiveStatus(ActiveStatus.Y);
        role = this.roleRepository.saveAndFlush(role);
        return new Response("Success", "Role save successfully", role);
    }

    @Override
    public Response updateRole(RoleDto roleDto) {
        if (roleDto.getRoleUuid() == null) {
            return new Response("Error", "RoleUuid not be null");
        } else if (roleDto.getRoleName() == null) {
            return new Response("Error", "RoleName not be null");
        } else if (roleDto.getRoleType() == null) {
            return new Response("Error", "RoleType not be null");
        }
        Optional<Role> role = this.roleRepository.findRoleByRoleUuid(roleDto.getRoleUuid());
        if (!role.isPresent()) {
            return new Response("Error", "Role not found with the with given id " + roleDto.getRoleUuid());
        }
        Role role1 = role.get();
        if (roleDto.getRoleUuid() != null) {
            role1.setRoleUuid(roleDto.getRoleUuid());
        }
        if (roleDto.getRoleName() != null) {
            role1.setRoleName(roleDto.getRoleName());
        }
        if (roleDto.getRoleType() != null) {
            role1.setRoleType(roleDto.getRoleType());
        }
        if (roleDto.getRoleLabel() != null) {
            role1.setRoleLabel(roleDto.getRoleLabel());
        }
        if (roleDto.getRoleIndicator() != null) {
            role1.setRoleIndicator(roleDto.getRoleIndicator());
        }
        if (roleDto.getRoleAuthUserId() != null) {
            role1.setRoleAuthUserId(roleDto.getRoleAuthUserId());
        }
        if (roleDto.getRoleComments() != null) {
            role1.setRoleComments(roleDto.getRoleComments());
        }
        if (roleDto.getRoleGroup() != null) {
            role1.setRoleGroup(roleDto.getRoleGroup());
        }
        if (roleDto.getUpdatedBy() != null) {
            role1.setUpdatedBy(roleDto.getUpdatedBy());
        }
        role1.setActiveStatus(roleDto.getActiveStatus());
        role1 = this.roleRepository.saveAndFlush(role1);
        return new Response("Success", "Role save successfully", role1);
    }

    @Override
    public Response findAllRole() {
        return new Response("Success", "Role find successfully", this.roleRepository.findAll());
    }

    @Override
    public Response findAllRoleSearch(RoleSearch roleSearch) {
        return this.utilService.findAllRoleSearch(roleSearch);
    }

    @Override
    public Response findRoleByRoleUuid(String roleUuid) {
        Optional<Role> role = this.roleRepository.findRoleByRoleUuid(roleUuid);
        if (role.isPresent()) {
            return new Response("Success", "Role find successfully", role.get());
        } else {
            return new Response("Error", "Role not find");
        }
    }

    @Override
    public Response deleteRoleByRoleUuid(String roleUuid) {
        Optional<Role> role = this.roleRepository.findRoleByRoleUuid(roleUuid);
        role.get().setActiveStatus(ActiveStatus.N);
        this.roleRepository.save(role.get());
        return new Response("Success", "Role delete successfully");
    }
}
