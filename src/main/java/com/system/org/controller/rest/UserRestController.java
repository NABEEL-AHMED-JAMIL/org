package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.UserDto;
import com.system.org.dto.search.UserSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/user.json")
public class UserRestController {

    private Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        logger.info("##### createUser Start");
        try {
            logger.info(userDto.toString());
            return new ResponseEntity<>(this.userService.createUser(userDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createUser ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        logger.info("##### updateUser Start");
        try {
            logger.info(userDto.toString());
            return new ResponseEntity<>(this.userService.updateUser(userDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateUser ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUser() {
        logger.info("##### findAllUser Start");
        try {
            return new ResponseEntity<>(this.userService.findAllUser(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUser ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserSearch", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserSearch(@RequestBody UserSearch userSearch) {
        logger.info("##### findAllUserSearch Start");
        try {
            return new ResponseEntity<>(this.userService.findAllUserSearch(userSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserByUserUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByUserUuid(@RequestParam String userUuid) {
        logger.info("##### findRoleByRoleUuid Start");
        try {
            return new ResponseEntity<>(this.userService.findUserByUserUuid(userUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findUserByUserUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserByUserUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserByUserUuid(@RequestParam String userUuid) {
        logger.info("##### deleteUserByUserUuid Start");
        try {
            return new ResponseEntity<>(this.userService.deleteUserByUserUuid(userUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteUserByUserUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
