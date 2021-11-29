package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.RolePermissionDto;
import com.system.org.dto.search.RolePermissionSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.RolePermissionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/rolePermission.json")
public class RolePermissionRestController {

    private Logger logger = LoggerFactory.getLogger(RolePermissionRestController.class);

    @Autowired
    private RolePermissionServiceImpl rolePermissionService;

    @RequestMapping(value = "/createRolePermission", method = RequestMethod.POST)
    public ResponseEntity<?> createRolePermission(@RequestBody RolePermissionDto rolePermissionDto) {
        logger.info("##### createRolePermission Start");
        try {
            return new ResponseEntity<>(this.rolePermissionService.createRolePermission(rolePermissionDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createRolePermission ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateRolePermission", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRolePermission(@RequestBody RolePermissionDto rolePermissionDto) {
        logger.info("##### updateRolePermission Start");
        try {
            return new ResponseEntity<>(this.rolePermissionService.updateRolePermission(rolePermissionDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateRolePermission ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllRolePermission", method = RequestMethod.GET)
    public ResponseEntity<?> findAllRolePermission() {
        logger.info("##### findAllRolePermission Start");
        try {
            return new ResponseEntity<>(this.rolePermissionService.findAllRolePermission(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllRolePermission ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllRolePermissionSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllRolePermissionSearch(@RequestBody RolePermissionSearch rolePermissionSearch) {
        logger.info("##### findAllRolePermissionSearch Start");
        try {
            return new ResponseEntity<>(this.rolePermissionService.findAllRolePermissionSearch(rolePermissionSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllRolePermissionSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findRolePermissionByRolePermissionUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findRolePermissionByRolePermissionUuid(@RequestParam String rolePermissionUuid) {
        logger.info("##### findRolePermissionByRolePermissionUuid Start");
        try {
            return new ResponseEntity<>(this.rolePermissionService.findRolePermissionByRolePermissionUuid(rolePermissionUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findRolePermissionByRolePermissionUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteRolePermissionByRolePermissionUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRolePermissionByRolePermissionUuid(@RequestParam String rolePermissionUuid) {
        logger.info("##### deleteRolePermissionByRolePermissionUuid Start");
        try {
            return new ResponseEntity<>(this.rolePermissionService.deleteRolePermissionByRolePermissionUuid(rolePermissionUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteRolePermissionByRolePermissionUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
