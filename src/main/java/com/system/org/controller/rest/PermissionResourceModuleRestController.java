package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionResourceModuleDto;
import com.system.org.dto.search.PermissionResourceModuleSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.PermissionResourceModuleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/permissionResourceModule.json")
public class PermissionResourceModuleRestController {

    private Logger logger = LoggerFactory.getLogger(PermissionResourceModuleRestController.class);

    @Autowired
    private PermissionResourceModuleServiceImpl permissionResourceModuleService;


    @RequestMapping(value = "/createPermissionResourceModule", method = RequestMethod.POST)
    public ResponseEntity<?> createPermissionResourceModule(@RequestBody PermissionResourceModuleDto permissionResourceModuleDto) {
        logger.info("##### createPermissionResourceModule Start");
        try {
            logger.info(permissionResourceModuleDto.toString());
            return new ResponseEntity<>(this.permissionResourceModuleService.createPermissionResourceModule(permissionResourceModuleDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createPermissionResourceModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updatePermissionResourceModule", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePermissionResourceModule(@RequestBody PermissionResourceModuleDto permissionResourceModuleDto) {
        logger.info("##### updatePermissionResourceModule Start");
        try {
            return new ResponseEntity<>(this.permissionResourceModuleService.updatePermissionResourceModule(permissionResourceModuleDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updatePermissionResourceModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllPermissionResourceModule", method = RequestMethod.GET)
    public ResponseEntity<?> findAllPermissionResourceModule() {
        logger.info("##### findAllPermissionResourceModule Start");
        try {
            return new ResponseEntity<>(this.permissionResourceModuleService.findAllPermissionResourceModule(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllPermissionResourceModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findAllPermissionResourceModuleSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllPermissionResourceModuleSearch(@RequestBody PermissionResourceModuleSearch permissionResourceModuleSearch) {
        logger.info("##### findAllPermissionResourceModuleSearch Start");
        try {
            return new ResponseEntity<>(this.permissionResourceModuleService.findAllPermissionResourceModuleSearch(permissionResourceModuleSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllPermissionResourceModuleSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findPermissionResourceModuleByPermissionResourceModuleUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findPermissionResourceModuleByPermissionResourceModuleUuid(@RequestParam String permissionResourceModuleUuid) {
        logger.info("##### findPermissionResourceModuleByPermissionResourceModuleUuid Start");
        try {
            return new ResponseEntity<>(this.permissionResourceModuleService.findPermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findPermissionResourceModuleByPermissionResourceModuleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deletePermissionResourceModuleByPermissionResourceModuleUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePermissionResourceModuleByPermissionResourceModuleUuid(@RequestParam String permissionResourceModuleUuid) {
        logger.info("##### deletePermissionResourceModuleByPermissionResourceModuleUuid Start");
        try {
            return new ResponseEntity<>(this.permissionResourceModuleService.deletePermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deletePermissionResourceModuleByPermissionResourceModuleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
