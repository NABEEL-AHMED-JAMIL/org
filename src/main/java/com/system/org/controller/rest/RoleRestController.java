package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.RoleDto;
import com.system.org.dto.search.RoleSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.RoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/role.json")
public class RoleRestController {

    private Logger logger = LoggerFactory.getLogger(RoleRestController.class);

    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping(value = "/createRole", method = RequestMethod.POST)
    public ResponseEntity<?> createRole(@RequestBody RoleDto roleDto) {
        logger.info("##### createRole Start");
        try {
            return new ResponseEntity<>(this.roleService.createRole(roleDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createRole ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateRole", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@RequestBody RoleDto roleDto) {
        logger.info("##### updateRole Start");
        try {
            return new ResponseEntity<>(this.roleService.updateRole(roleDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateRole ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllRole", method = RequestMethod.GET)
    public ResponseEntity<?> findAllRole() {
        logger.info("##### findAllRole Start");
        try {
            return new ResponseEntity<>(this.roleService.findAllRole(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllRole ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllRoleSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllRoleSearch(@RequestBody RoleSearch roleSearch) {
        logger.info("##### findAllRoleSearch Start");
        try {
            return new ResponseEntity<>(this.roleService.findAllRoleSearch(roleSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllRoleSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findRoleByRoleUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findRoleByRoleUuid(@RequestParam String roleUuid) {
        logger.info("##### findRoleByRoleUuid Start");
        try {
            return new ResponseEntity<>(this.roleService.findRoleByRoleUuid(roleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findRoleByRoleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteRoleByRoleUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRoleByRoleUuid(@RequestParam String roleUuid) {
        logger.info("##### deleteRoleByRoleUuid Start");
        try {
            return new ResponseEntity<>(this.roleService.deleteRoleByRoleUuid(roleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteRoleByRoleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
