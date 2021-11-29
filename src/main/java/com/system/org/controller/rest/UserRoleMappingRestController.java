package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.UserRoleMappingDto;
import com.system.org.dto.search.UserRoleMappingSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.UserRoleMappingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/userRoleMapping.json")
public class UserRoleMappingRestController {

    private Logger logger = LoggerFactory.getLogger(GroupRestController.class);

    @Autowired
    private UserRoleMappingServiceImpl userRoleMappingService;

    @RequestMapping(value = "/createUserRoleMapping", method = RequestMethod.POST)
    public ResponseEntity<?> createUserRoleMapping(@RequestBody UserRoleMappingDto userRoleMappingDto) {
        logger.info("##### createUserRoleMapping Start");
        try {
            return new ResponseEntity<>(this.userRoleMappingService.createUserRoleMapping(userRoleMappingDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createUserRoleMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUserRoleMapping", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserRoleMapping(@RequestBody UserRoleMappingDto userRoleMappingDto) {
        logger.info("##### updateUserRoleMapping Start");
        try {
            return new ResponseEntity<>(this.userRoleMappingService.updateUserRoleMapping(userRoleMappingDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateUserRoleMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserRoleMapping", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserRoleMapping() {
        logger.info("##### findAllUserRoleMapping Start");
        try {
            return new ResponseEntity<>(this.userRoleMappingService.findAllUserRoleMapping(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserRoleMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserRoleMappingSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllUserRoleMappingSearch(@RequestBody UserRoleMappingSearch userRoleMappingSearch) {
        logger.info("##### findAllUserRoleMappingSearch Start");
        try {
            return new ResponseEntity<>(this.userRoleMappingService.findAllUserRoleMappingSearch(userRoleMappingSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserRoleMappingSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserRoleMappingById", method = RequestMethod.GET)
    public ResponseEntity<?> findUserRoleMappingById(@RequestParam Long id) {
        logger.info("##### findUserRoleMappingById Start");
        try {
            return new ResponseEntity<>(this.userRoleMappingService.findUserRoleMappingById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findUserRoleMappingById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserRoleMappingById", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserRoleMappingById(@RequestParam Long id) {
        logger.info("##### deleteUserRoleMappingById Start");
        try {
            return new ResponseEntity<>(this.userRoleMappingService.deleteUserRoleMappingById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteUserRoleMappingById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
