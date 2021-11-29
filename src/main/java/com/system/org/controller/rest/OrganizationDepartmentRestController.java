package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationDepartmentDto;
import com.system.org.dto.search.OrganizationDepartmentSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.OrganizationDepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/organizationDepartment.json")
public class OrganizationDepartmentRestController {

    private Logger logger = LoggerFactory.getLogger(OrganizationDepartmentRestController.class);

    @Autowired
    private OrganizationDepartmentServiceImpl organizationDepartmentService;

    @RequestMapping(value = "/createOrganizationDepartment", method = RequestMethod.POST)
    public ResponseEntity<?> createOrganizationDepartment(@RequestBody OrganizationDepartmentDto organizationDepartmentDto) {
        logger.info("##### createOrganizationDepartment Start");
        try {
            logger.info(organizationDepartmentDto.toString());
            return new ResponseEntity<>(this.organizationDepartmentService.createOrganizationDepartment(organizationDepartmentDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createOrganizationDepartment ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateOrganizationDepartment", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOrganizationDepartment(@RequestBody OrganizationDepartmentDto organizationDepartmentDto) {
        logger.info("##### updateIntTrans Start");
        try {
            logger.info(organizationDepartmentDto.toString());
            return new ResponseEntity<>(this.organizationDepartmentService.updateOrganizationDepartment(organizationDepartmentDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateOrganizationDepartment ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllOrganizationDepartment", method = RequestMethod.GET)
    public ResponseEntity<?> findAllOrganizationDepartment() {
        logger.info("##### findAllOrganizationDepartment Start");
        try {
            return new ResponseEntity<>(this.organizationDepartmentService.findAllOrganizationDepartment(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllOrganizationDepartment ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllOrganizationDepartmentSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllOrganizationDepartmentSearch(@RequestBody OrganizationDepartmentSearch organizationDepartmentSearch) {
        logger.info("##### findAllOrganizationDepartmentSearch Start");
        try {
            return new ResponseEntity<>(this.organizationDepartmentService.findAllOrganizationDepartmentSearch(organizationDepartmentSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllOrganizationDepartmentSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findOrganizationDepartmentByOrganizationDepartmentUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findOrganizationDepartmentByOrganizationDepartmentUuid(@RequestParam String organizationDepartmentUuid) {
        logger.info("##### findOrganizationDepartmentByOrganizationDepartmentUuid Start");
        try {
            return new ResponseEntity<>(this.organizationDepartmentService.findOrganizationDepartmentByOrganizationDepartmentUuid(organizationDepartmentUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findOrganizationDepartmentByOrganizationDepartmentUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteOrganizationDepartmentByOrganizationDepartmentUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrganizationDepartmentByOrganizationDepartmentUuid(@RequestParam String organizationDepartmentUuid) {
        logger.info("##### deleteOrganizationDepartmentByOrganizationDepartmentUuid Start");
        try {
            return new ResponseEntity<>(this.organizationDepartmentService.deleteOrganizationDepartmentByOrganizationDepartmentUuid(organizationDepartmentUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteOrganizationDepartmentByOrganizationDepartmentUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
