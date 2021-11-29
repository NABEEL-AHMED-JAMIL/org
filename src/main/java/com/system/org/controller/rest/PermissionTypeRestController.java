package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionTypeDto;
import com.system.org.dto.search.PermissionTypeSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.PermissionTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/permissionType.json")
public class PermissionTypeRestController {

    private Logger logger = LoggerFactory.getLogger(PermissionTypeRestController.class);

    @Autowired
    private PermissionTypeServiceImpl permissionTypeService;

    /**
     * This method use to create Permission
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permissionType.json/createPermissionType
     * {
     * 	"permissionTypeName": "159852",
     * 	"permissionTypeShortDescription": "159852",
     * 	"permissionTypeDescription": "159852",
     * 	"createdBy": "159852"
     * }
     * {
     *     "status": "Success",
     *     "message": "PermissionType save successfully",
     *     "data": {
     *         "permissionTypeId": 13,
     *         "permissionTypeUuid": "dd732e3b-f551-422d-81de-af4083490044",
     *         "permissionTypeName": "159852",
     *         "permissionTypeShortDescription": "159852",
     *         "permissionTypeDescription": "159852",
     *         "createdDts": "2021-04-12T19:33:44.381+00:00",
     *         "createdBy": "159852",
     *         "activeStatus": "Y"
     *     }
     * }
     * **/
    @RequestMapping(value = "/createPermissionType", method = RequestMethod.POST)
    public ResponseEntity<?> createPermissionType(@RequestBody PermissionTypeDto prePermissionTypeDto) {
        logger.info("##### createPermissionType Start");
        try {
            return new ResponseEntity<>(this.permissionTypeService.createPermissionType(prePermissionTypeDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createPermissionType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to create Permission
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permissionType.json/updatePermissionType
     * {
     *  "permissionTypeId": 13,
     * 	"permissionTypeName": "159852a",
     * 	"permissionTypeShortDescription": "159852",
     * 	"permissionTypeDescription": "159852",
     * 	"createdBy": "159852"
     * }
     * {
     *     "status": "Success",
     *     "message": "PermissionType save successfully",
     *     "data": {
     *         "permissionTypeId": 13,
     *         "permissionTypeUuid": "dd732e3b-f551-422d-81de-af4083490044",
     *         "permissionTypeName": "159852a",
     *         "permissionTypeShortDescription": "159852",
     *         "permissionTypeDescription": "159852",
     *         "createdDts": "2021-04-12T19:33:44.381+00:00",
     *         "createdBy": "159852",
     *         "activeStatus": "Y"
     *     }
     * }
     * **/
    @RequestMapping(value = "/updatePermissionType", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePermissionType(@RequestBody PermissionTypeDto prePermissionTypeDto) {
        logger.info("##### updatePermissionType Start");
        try {
            return new ResponseEntity<>(this.permissionTypeService.updatePermissionType(prePermissionTypeDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updatePermissionType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch all PermissionType
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permissionType.json/findAllPermissionType
     * {
     *     "status": "Success",
     *     "message": "Organizations find successfully",
     *     "data": [
     *         {
     *             "createdDts": "2021-04-04T08:32:50.567+00:00",
     *             "createdBy": 1,
     *             "activeStatus": "Y",
     *             "updatedDts": "2021-04-04T08:42:00.956+00:00",
     *             "organisationId": 1002,
     *             "organizationUuid": "2661ceef-2d93-4b32-aeae-e16dd4ed6c1c",
     *             "organizationName": "159753699",
     *             "organizationShortDescription": "159753699",
     *             "organizationDescription": "159753699"
     *         }
     *     ]
     * }
     * */
    @RequestMapping(value = "/findAllPermissionType", method = RequestMethod.GET)
    public ResponseEntity<?> findAllPermissionType() {
        logger.info("##### findAllPermissionType Start");
        try {
            return new ResponseEntity<>(this.permissionTypeService.findAllPermissionType(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllPermissionType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllPermissionTypeSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllPermissionTypeSearch(@RequestBody PermissionTypeSearch permissionTypeSearch) {
        logger.info("##### findAllPermissionTypeSearch Start");
        try {
            return new ResponseEntity<>(this.permissionTypeService.findAllPermissionTypeSearch(permissionTypeSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllPermissionTypeSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch all PermissionType
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permissionType.json/findPermissionTypeByPermissionTypeId?permissionTypeId=10
     * {
     *     "status": "Error",
     *     "message": "PermissionTyp not find"
     * }
     * */
    @RequestMapping(value = "/findPermissionTypeByPermissionTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findPermissionTypeByPermissionTypeUuid(@RequestParam String permissionTypeUuid) {
        logger.info("##### findPermissionTypeByPermissionTypeUuid Start");
        try {
            return new ResponseEntity<>(this.permissionTypeService.findPermissionTypeByPermissionTypeUuid(permissionTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findPermissionTypeByPermissionTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to delete PermissionType
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permissionType.json/deletePermissionTypeById?permissionTypeId=10
     * {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deletePermissionTypeByPermissionTypeUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePermissionTypeByPermissionTypeUuid(@RequestParam String permissionTypeUuid) {
        logger.info("##### deletePermissionTypeByPermissionTypeUuid Start");
        try {
            return new ResponseEntity<>(this.permissionTypeService.deletePermissionTypeByPermissionTypeUuid(permissionTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deletePermissionTypeById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
