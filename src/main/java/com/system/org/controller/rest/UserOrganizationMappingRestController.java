package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.UserOrganizationMappingDto;
import com.system.org.dto.search.UserOrganizationMappingSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.UserOrganizationMappingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/userOrganizationMapping.json")
public class UserOrganizationMappingRestController {

    private Logger logger = LoggerFactory.getLogger(GroupRestController.class);

    @Autowired
    private UserOrganizationMappingServiceImpl userOrganizationMappingService;

    @RequestMapping(value = "/createUserOrganizationMapping", method = RequestMethod.POST)
    public ResponseEntity<?> createUserOrganizationMapping(@RequestBody UserOrganizationMappingDto organizationMappingDto) {
        logger.info("##### createUserOrganizationMapping Start");
        try {
            return new ResponseEntity<>(this.userOrganizationMappingService.createUserOrganizationMapping(organizationMappingDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createUserOrganizationMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUserOrganizationMapping", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUserOrganizationMapping(@RequestBody UserOrganizationMappingDto organizationMappingDto) {
        logger.info("##### updateUserOrganizationMapping Start");
        try {
            return new ResponseEntity<>(this.userOrganizationMappingService.updateUserOrganizationMapping(organizationMappingDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateUserOrganizationMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserOrganizationMapping", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserOrganizationMapping() {
        logger.info("##### findAllUserOrganizationMapping Start");
        try {
            return new ResponseEntity<>(this.userOrganizationMappingService.findAllUserOrganizationMapping(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserOrganizationMapping ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUserOrganizationMappingSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllUserOrganizationMappingSearch(@RequestBody UserOrganizationMappingSearch userOrganizationMappingSearch) {
        logger.info("##### findAllUserOrganizationMappingSearch Start");
        try {
            return new ResponseEntity<>(this.userOrganizationMappingService.findAllUserOrganizationMappingSearch(userOrganizationMappingSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUserOrganizationMappingSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findUserOrganizationMappingById", method = RequestMethod.GET)
    public ResponseEntity<?> findUserOrganizationMappingById(@RequestParam Long id) {
        logger.info("##### findUserOrganizationMappingById Start");
        try {
            return new ResponseEntity<>(this.userOrganizationMappingService.findUserOrganizationMappingById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findUserOrganizationMappingById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserOrganizationMappingTypeById", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserOrganizationMappingTypeById(@RequestParam Long id) {
        logger.info("##### deleteUserOrganizationMappingTypeById Start");
        try {
            return new ResponseEntity<>(this.userOrganizationMappingService.deleteUserOrganizationMappingTypeById(id), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteUserOrganizationMappingTypeById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
