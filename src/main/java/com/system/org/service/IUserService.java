package com.system.org.service;

import com.system.org.controller.Response;
import com.system.org.dto.UserDto;
import com.system.org.dto.search.UserSearch;

public interface IUserService {

    public Response createUser(UserDto userDto);

    public Response updateUser(UserDto userDto);

    public Response findAllUser();

    public Response findAllUserSearch(UserSearch userSearch);

    public Response findUserByUserUuid(String userUuid);

    public Response deleteUserByUserUuid(String userUuid);
}
