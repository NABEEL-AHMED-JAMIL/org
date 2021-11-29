package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.UserRoleDto;
import com.system.org.dto.search.UserRoleSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.UserRoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/userRole.json")
public class UserRoleRestController {

    private Logger logger = LoggerFactory.getLogger(UserRoleRestController.class);

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @RequestMapping(value = "/createUserRole", method = RequestMethod.POST)
    public ResponseEntity<?> createUserRole(@RequestBody UserRoleDto userRoleDto) {
        logger.info("##### createUserRole Start");
        try {
            logger.info(userRoleDto.toString());
            return new ResponseEntity<>(this.userRoleService.createUserRole(userRoleDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createUserRole ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUserRole", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserRole(@RequestBody UserRoleDto userRoleDto) {
        logger.info("##### updateUserRole Start");
        try {
            logger.info(userRoleDto.toString());
            return new ResponseEntity<>(this.userRoleService.updateUserRole(userRoleDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateUserRole ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserRole", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserRole() {
        logger.info("##### findAllUserRole Start");
        try {
            return new ResponseEntity<>(this.userRoleService.findAllUserRole(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserRole ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserRoleSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllUserRoleSearch(@RequestBody UserRoleSearch userRoleSearch) {
        logger.info("##### findAllUserRoleSearch Start");
        try {
            return new ResponseEntity<>(this.userRoleService.findAllUserRoleSearch(userRoleSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserRoleSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserRoleByUserRoleUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findUserRoleByUserRoleUuid(@RequestParam String userRoleUuid) {
        logger.info("##### findUserRoleByUserRoleUuid Start");
        try {
            return new ResponseEntity<>(this.userRoleService.findUserRoleByUserRoleUuid(userRoleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findUserRoleByUserRoleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserRoleByUserRoleUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserRoleByUserRoleUuid(@RequestParam String userRoleUuid) {
        logger.info("##### deleteUserRoleByUserRoleUuid Start");
        try {
            return new ResponseEntity<>(this.userRoleService.deleteUserRoleByUserRoleUuid(userRoleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteUserRoleByUserRoleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
