package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.GroupDto;
import com.system.org.dto.search.GroupSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.Group;
import com.system.org.repository.GroupRepository;
import com.system.org.service.IGroupService;
import com.system.org.service.IUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class GroupServiceImpl implements IGroupService {

    private Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createGroup(GroupDto groupDto) {
        if (groupDto.getGroupName() == null) {
            return new Response("Error", "Group name not be null");
        } else if (this.groupRepository.findByGroupNameAndActiveStatus(groupDto.getGroupName(), ActiveStatus.Y).isPresent()) {
            return new Response("Error", "Group already exist with the same name");
        }
        Group group = new Group();
        group.setGroupUuid(UUID.randomUUID().toString());
        group.setGroupName(groupDto.getGroupName());
        group.setGroupShortName(groupDto.getGroupShortName());
        group.setGroupDesc(groupDto.getGroupDesc());
        group.setCreatedBy(groupDto.getCreatedBy());
        group.setActiveStatus(ActiveStatus.Y);
        group = this.groupRepository.saveAndFlush(group);
        return new Response("Success", "Group save successfully", group);
    }

    @Override
    public Response updateGroup(GroupDto groupDto) {
        if (groupDto.getGroupUuid() == null) {
            return new Response("Error", "Group uuid not be null");
        } else if (groupDto.getGroupName() == null) {
            return new Response("Error", "Group name not be null");
        }
        Optional<Group> group = this.groupRepository.findByGroupUuid(groupDto.getGroupUuid());
        if (!group.isPresent()) {
            return new Response("Error", "Group not found with the with given id " + groupDto.getGroupUuid());
        }
        Group group1 = group.get();
        if (groupDto.getGroupUuid() != null) {
            group1.setGroupUuid(groupDto.getGroupUuid());
        }
        if (groupDto.getGroupName() != null) {
            group1.setGroupName(groupDto.getGroupName());
        }
        if (groupDto.getGroupShortName() != null) {
            group1.setGroupShortName(groupDto.getGroupShortName());
        }
        if (groupDto.getGroupDesc() != null) {
            group1.setGroupDesc(groupDto.getGroupDesc());
        }
        if (groupDto.getUpdatedBy() != null) {
            group1.setUpdatedBy(groupDto.getUpdatedBy());
        }
        if (groupDto.getActiveStatus() != null) {
            group1.setActiveStatus(groupDto.getActiveStatus());
        }
        group1 = this.groupRepository.saveAndFlush(group1);
        return new Response("Success", "Group save successfully", group1);
    }

    @Override
    public Response findAllGroup() {
        return new Response("Success", "Group find successfully",
            this.groupRepository.findAllGroup());
    }

    @Override
    public Response findAllGroupWithActiveStatus() {
        return new Response("Success", "Group find successfully",
                this.groupRepository.findAllByActiveStatus(ActiveStatus.Y));
    }

    @Override
    public Response findAllGroupSearch(GroupSearch groupSearch) {
        return this.utilService.findAllGroupSearch(groupSearch);
    }

    @Override
    public Response findGroupByGroupUuid(String groupUuid) {
        Optional<Group> group = this.groupRepository.findByGroupUuid(groupUuid);
        if (group.isPresent()) {
            return new Response("Success", "Group find successfully", group.get());
        } else {
            return new Response("Error", "Group not find");
        }
    }

    @Override
    public Response deleteGroupByGroupUuid(String groupUuid) {
        Optional<Group> group = this.groupRepository.findByGroupUuid(groupUuid);
        group.get().setActiveStatus(ActiveStatus.N);
        this.groupRepository.save(group.get());
        return new Response("Success", "group delete successfully");
    }
}
