package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.UserDto;
import com.system.org.dto.search.UserSearch;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.User;
import com.system.org.repository.UserRepository;
import com.system.org.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Scope("singleton")
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public Response createUser(UserDto userDto) {
        User user = new User();
        user.setUserUuid(UUID.randomUUID().toString());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserMiddleName(userDto.getUserMiddleName());
        user.setUserLastName(userDto.getUserLastName());
        user.setAddress(userDto.getAddress());
        user.setUserActivatedDate(getTimestamp(userDto.getUserActivatedDate()));
        user.setUserAuthUserId(userDto.getUserAuthUserId());
        user.setUserContactnumber(userDto.getUserContactnumber());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserExpirationDate(getTimestamp(userDto.getUserExpirationDate()));
        user.setUserGroupid(userDto.getUserGroupid());
        user.setUserjobId(userDto.getUserjobId());
        user.setUserLastactivityDate(getTimestamp(userDto.getUserLastactivityDate()));
        user.setUserOrgId(userDto.getUserOrgId());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRoleId(userDto.getUserRoleId());
        user.setCreatedBy(userDto.getCreatedBy());
        user.setUserUserId(userDto.getUserUserId());
        user.setActiveStatus(ActiveStatus.Y);
        user = this.userRepository.saveAndFlush(user);
        return new Response("Success", "User save successfully", user);
    }

    @Override
    public Response updateUser(UserDto userDto) {
        if (userDto.getUserUuid() == null) {
            return new Response("Error", "UserUuid not be null");
        }
        Optional<User> user = this.userRepository.findUserByUserUuid(userDto.getUserUuid());
        User user1 = user.get();
        if (userDto.getUserUuid() != null) {
            user1.setUserUuid(userDto.getUserUuid());
        }
        if (userDto.getUserFirstName() != null) {
            user1.setUserFirstName(userDto.getUserFirstName());
        }
        if (userDto.getUserMiddleName() != null) {
            user1.setUserMiddleName(userDto.getUserMiddleName());
        }
        if (userDto.getUserLastName() != null) {
            user1.setUserLastName(userDto.getUserLastName());
        }
        if (userDto.getAddress() != null) {
            user1.setAddress(userDto.getAddress());
        }
        if (userDto.getUserActivatedDate()  != null) {
            //user1.setUserActivatedDate(userDto.getUserActivatedDate());
        }
        if (userDto.getUserAuthUserId() != null) {
            user1.setUserAuthUserId(userDto.getUserAuthUserId());
        }
        if (userDto.getUserContactnumber() != null) {
            user1.setUserContactnumber(userDto.getUserContactnumber());
        }
        if (userDto.getUserEmail() != null) {
            user1.setUserEmail(userDto.getUserEmail());
        }
        if (userDto.getUserExpirationDate() != null) {
            //user1.setUserExpirationDate(userDto.getUserExpirationDate());
        }
        if (userDto.getUserGroupid() != null) {
            user1.setUserGroupid(userDto.getUserGroupid());
        }
        if (userDto.getUserjobId() != null) {
            user1.setUserjobId(userDto.getUserjobId());
        }
        if (userDto.getUserLastactivityDate() != null) {
            //user1.setUserLastactivityDate(userDto.getUserLastactivityDate());
        }
        if (userDto.getUserOrgId() != null) {
            user1.setUserOrgId(userDto.getUserOrgId());
        }
        if (userDto.getUserPassword() != null) {
            user1.setUserPassword(userDto.getUserPassword());
        }
        if (userDto.getUserRoleId() != null) {
            user1.setUserRoleId(userDto.getUserRoleId());
        }
        if (userDto.getUserUserId() != null) {
            user1.setUserUserId(userDto.getUserUserId());
        }
        if (userDto.getUpdatedBy() != null) {
            user1.setUpdatedBy(userDto.getUpdatedBy());
        }
        user1.setActiveStatus(userDto.getActiveStatus());
        user1 = this.userRepository.saveAndFlush(user1);
        return new Response("Success", "User save successfully", user1);
    }

    @Override
    public Response findAllUser() {
        return new Response("Success", "User find successfully", this.userRepository.findAll());
    }

    @Override
    public Response findAllUserSearch(UserSearch userSearch) {
        return this.utilService.findAllUserSearch(userSearch);
    }

    @Override
    public Response findUserByUserUuid(String userUuid) {
        Optional<User> user = this.userRepository.findUserByUserUuid(userUuid);
        if (user.isPresent()) {
            return new Response("Success", "User find successfully", user.get());
        } else {
            return new Response("Success", "User not find");
        }
    }

    @Override
    public Response deleteUserByUserUuid(String userUuid) {
        Optional<User> user = this.userRepository.findUserByUserUuid(userUuid);
        user.get().setActiveStatus(ActiveStatus.N);
        this.userRepository.saveAndFlush(user.get());
        return new Response("Success", "Delete successfully");
    }

    private Timestamp getTimestamp(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            return new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception ex) {
            return null;
        }
    }
}
