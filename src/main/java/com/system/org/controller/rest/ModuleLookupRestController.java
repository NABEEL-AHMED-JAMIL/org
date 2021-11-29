package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.ModulesLookupDto;
import com.system.org.dto.search.ModuleSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.ModuleLookupServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/moduleLookup.json")
public class ModuleLookupRestController {

    private Logger logger = LoggerFactory.getLogger(ModuleLookupRestController.class);

    @Autowired
    private ModuleLookupServiceImpl moduleLookupService;

    /**
     * This method use to create the module
     * @param modulesLookupDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/moduleLookup.json/createModulesLookup
     * {
     * 	"modulesLookupNumber": "15887",
     * 	"modulesLookupShortDescription": "awe-98555",
     * 	"modulesLookupName": "15981755",
     * 	"modulesLookupDescription": "awe-98555",
     * 	"createdDts": "2021-04-04T08:32:50.567+00:00",
     * 	"createdBy": 1
     * }
     * {
     *     "status": "Success",
     *     "message": "ModulesLookup save successfully",
     *     "data": {
     *         "createdDts": "2021-04-04T09:07:07.653+00:00",
     *         "createdBy": 1,
     *         "activeStatus": "Y",
     *         "modulesLookupId": 1007,
     *         "modulesLookupUuid": "8a8c67b1-d7bc-4677-a179-b18e43c078eb",
     *         "modulesLookupNumber": "15887",
     *         "modulesLookupShortDescription": "awe-98555",
     *         "modulesLookupName": "15981755",
     *         "modulesLookupDescription": "awe-98555"
     *     }
     * }
     * */
    @RequestMapping(value = "/createModulesLookup", method = RequestMethod.POST)
    public ResponseEntity<?> createModulesLookup(@RequestBody ModulesLookupDto modulesLookupDto) {
        logger.info("##### createModulesLookup Start");
        try {
            return new ResponseEntity<>(this.moduleLookupService.createModulesLookup(modulesLookupDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createModulesLookup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to update modules
     * @param modulesLookupDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/moduleLookup.json/updateModulesLookup
     * {
     * 	"updatedBy": 1,
     *     "activeStatus": "Y",
     *     "modulesLookupId": 1008,
     *     "modulesLookupUuid": "d9f954c3-d979-47ad-8173-805849b26a72",
     *     "modulesLookupNumber": "15887111",
     *     "modulesLookupShortDescription": "awe-985551111",
     *     "modulesLookupName": "15981711511115",
     *     "modulesLookupDescription": "awe-98551111115"
     * }
     * {
     *     "status": "Success",
     *     "message": "ModulesLookup update successfully",
     *     "data": {
     *         "createdDts": "2021-04-04T09:23:41.608+00:00",
     *         "createdBy": 1,
     *         "activeStatus": "Y",
     *         "updatedDts": "2021-04-04T09:26:58.029+00:00",
     *         "updatedBy": 1,
     *         "modulesLookupId": 1008,
     *         "modulesLookupUuid": "d9f954c3-d979-47ad-8173-805849b26a72",
     *         "modulesLookupNumber": "15887111",
     *         "modulesLookupShortDescription": "awe-985551111",
     *         "modulesLookupName": "15981711511115",
     *         "modulesLookupDescription": "awe-98551111115"
     *     }
     * }
     * */
    @RequestMapping(value = "/updateModulesLookup", method = RequestMethod.PUT)
    public ResponseEntity<?> updateModulesLookup(@RequestBody ModulesLookupDto modulesLookupDto) {
        logger.info("##### updateModulesLookup Start");
        try {
            return new ResponseEntity<>(this.moduleLookupService.updateModulesLookup(modulesLookupDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateModulesLookup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use fetch the all modules
     * @return ResponseEntity<?>
     * http://localhost:9095/api/moduleLookup.json/findAllModulesLookup
     * {
     *     "status": "Success",
     *     "message": "ModulesLookup find successfully",
     *     "data": [
     *         {
     *             "createdDts": "2021-04-04T09:02:02.550+00:00",
     *             "createdBy": 1,
     *             "activeStatus": "Y",
     *             "modulesLookupId": 1000,
     *             "modulesLookupUuid": "857cd957-9d8d-4730-8b4d-763d0f600a74",
     *             "modulesLookupNumber": "15887",
     *             "modulesLookupShortDescription": "awe-98555",
     *             "modulesLookupName": "1598755",
     *             "modulesLookupDescription": "awe-98555"
     *         }
     *     ]
     * }
     * */
    @RequestMapping(value = "/findAllModulesLookup", method = RequestMethod.GET)
    public ResponseEntity<?> findAllModulesLookup() {
        logger.info("##### findAllModule Start");
        try {
            return new ResponseEntity<>(this.moduleLookupService.findAllModulesLookup(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllModulesLookup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllModulesLookupBySearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllModulesLookupBySearch(@RequestBody ModuleSearch moduleSearch) {
        logger.info("##### findAllModule Start");
        try {
            return new ResponseEntity<>(this.moduleLookupService.findAllModulesLookupBySearch(moduleSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllModulesLookup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fine the modules by id
     * @return ResponseEntity<?>
     * http://localhost:9095/api/moduleLookup.json/findModulesLookupByModulesLookupId?modulesLookupId=1000
     *{
     *     "status": "Success",
     *     "message": "ModulesLookup find successfully",
     *     "data": {
     *         "createdDts": "2021-04-04T09:02:02.550+00:00",
     *         "createdBy": 1,
     *         "activeStatus": "Y",
     *         "modulesLookupId": 1000,
     *         "modulesLookupUuid": "857cd957-9d8d-4730-8b4d-763d0f600a74",
     *         "modulesLookupNumber": "15887",
     *         "modulesLookupShortDescription": "awe-98555",
     *         "modulesLookupName": "1598755",
     *         "modulesLookupDescription": "awe-98555"
     *     }
     * }
     * */
    @RequestMapping(value = "/findModulesLookupByModulesLookupUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findModulesLookupByModulesLookupUuid(@RequestParam String modulesLookupUuid) {
        logger.info("##### findModulesLookupByModulesLookupUuid Start");
        try {
            return new ResponseEntity<>(this.moduleLookupService.findModulesLookupByModulesLookupUuid(modulesLookupUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findModulesLookupByModulesLookupUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fine the modules by id
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/deleteModulesLookupById?modulesLookupId=1
     * {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deleteModulesLookupByModulesLookupUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteModulesLookupByModulesLookupUuid(@RequestParam String modulesLookupUuid) {
        logger.info("##### deleteModulesLookupByModulesLookupUuid Start");
        try {
            return new ResponseEntity<>(this.moduleLookupService.deleteModulesLookupByModulesLookupUuid(modulesLookupUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteModulesLookupById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
