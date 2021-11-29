package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.UserGroupMappingDto;
import com.system.org.dto.search.UserGroupMappingSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.UserGroupMappingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/userGroupMapping.json")
public class UserGroupMappingRestController {

    private Logger logger = LoggerFactory.getLogger(UserGroupMappingRestController.class);

    @Autowired
    private UserGroupMappingServiceImpl userGroupMappingService;

    @RequestMapping(value = "/createUserGroupMapping", method = RequestMethod.POST)
    public ResponseEntity<?> createUserGroupMapping(@RequestBody UserGroupMappingDto userGroupMappingDto) {
        logger.info("##### createUserGroupMapping Start");
        try {
            return new ResponseEntity<>(this.userGroupMappingService.createUserGroupMapping(userGroupMappingDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createUserGroupMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUserGroupMapping", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserGroupMapping(@RequestBody UserGroupMappingDto userGroupMappingDto) {
        logger.info("##### updateUserGroupMapping Start");
        try {
            return new ResponseEntity<>(this.userGroupMappingService.updateUserGroupMapping(userGroupMappingDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateUserGroupMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserGroupMapping", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserGroupMapping() {
        logger.info("##### findAllUserGroupMapping Start");
        try {
            return new ResponseEntity<>(this.userGroupMappingService.findAllUserGroupMapping(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserGroupMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findAllUserGroupMappingSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllUserGroupMappingSearch(@RequestBody UserGroupMappingSearch userGroupMappingSearch) {
        logger.info("##### findAllUserGroupMappingSearch Start");
        try {
            return new ResponseEntity<>(this.userGroupMappingService.findAllUserGroupMappingSearch(userGroupMappingSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserGroupMappingSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findUserGroupMappingById", method = RequestMethod.GET)
    public ResponseEntity<?> findUserGroupMappingById(@RequestParam Long id) {
        logger.info("##### findUserGroupMappingById Start");
        try {
            return new ResponseEntity<>(this.userGroupMappingService.findUserGroupMappingById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findUserGroupMappingById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserGroupMappingTypeById", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserGroupMappingTypeById(@RequestParam Long id) {
        logger.info("##### deleteUserGroupMappingTypeById Start");
        try {
            return new ResponseEntity<>(this.userGroupMappingService.deleteUserGroupMappingTypeById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteUserGroupMappingTypeById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
