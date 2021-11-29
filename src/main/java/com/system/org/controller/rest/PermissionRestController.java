package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.PermissionDto;
import com.system.org.dto.search.PermissionSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.PermissionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/permission.json")
public class PermissionRestController {

    private Logger logger = LoggerFactory.getLogger(PermissionRestController.class);

    @Autowired
    private PermissionServiceImpl permissionService;

    /***
     * This method use to create the permission
     * @param permissionDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permission.json/createPermission
     * {
     * 	"permissionName": "USER_VIEW1",
     * 	"permissionAvailableIndicator": "N",
     * 	"permissionCreate": "N",
     * 	"permissionDelete": "N",
     * 	"permissionUpdate": "N",
     * 	"permissionRead": "Y",
     * 	"permissionSoftDelete": "N",
     * 	"createdDts": "2020-11-30T08:05:48.000+00:00",
     * 	"cratedBy": "adfadafda",
     * 	"activeStatus": "Y",
     * 	"updatedDts": "2020-11-30T08:06:04.000+00:00"
     * }
     * {
     *     "status": "Success",
     *     "message": "Permission save successfully",
     *     "data": {
     *         "permissionId": 9,
     *         "permissionUuid": "f442242f-b646-482b-88b7-477e8ec7711a",
     *         "permissionName": "USER_VIEW1",
     *         "permissionAvailableIndicator": "N",
     *         "permissionCreate": "N",
     *         "permissionDelete": "N",
     *         "permissionUpdate": "N",
     *         "permissionRead": "Y",
     *         "permissionSoftDelete": "N",
     *         "createdDts": "2021-04-12T19:08:09.583+00:00",
     *         "cratedBy": "adfadafda",
     *         "activeStatus": "Y"
     *     }
     * }
     * */
    @RequestMapping(value = "/createPermission", method = RequestMethod.POST)
    public ResponseEntity<?> createPermission(@RequestBody PermissionDto permissionDto) {
        logger.info("##### createPermission Start");
        try {
            return new ResponseEntity<>(this.permissionService.createPermission(permissionDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createPermission ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /***
     * This method use to update the permission
     * @param permissionDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permission.json/updatePermission
     * {
     *         "permissionId": 9,
     *         "permissionUuid": "f442242f-b646-482b-88b7-477e8ec7711a",
     *         "permissionName": "USER_VIEW_Test",
     *         "permissionAvailableIndicator": "N",
     *         "permissionCreate": "N",
     *         "permissionDelete": "N",
     *         "permissionUpdate": "N",
     *         "permissionRead": "Y",
     *         "permissionSoftDelete": "N",
     *         "createdDts": "2021-04-12T19:08:09.583+00:00",
     *         "cratedBy": "adfadafda",
     *         "activeStatus": "Y"
     * }
     * {
     *     "status": "Success",
     *     "message": "Permission update successfully",
     *     "data": {
     *         "permissionId": 9,
     *         "permissionUuid": "f442242f-b646-482b-88b7-477e8ec7711a",
     *         "permissionName": "USER_VIEW_Test",
     *         "permissionAvailableIndicator": "N",
     *         "permissionCreate": "N",
     *         "permissionDelete": "N",
     *         "permissionUpdate": "N",
     *         "permissionRead": "Y",
     *         "permissionSoftDelete": "N",
     *         "createdDts": "2021-04-12T19:08:10.000+00:00",
     *         "cratedBy": "adfadafda",
     *         "activeStatus": "Y",
     *         "updatedDts": "2021-04-12T19:10:28.830+00:00"
     *     }
     * }
     * */
    @RequestMapping(value = "/updatePermission", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePermission(@RequestBody PermissionDto permissionDto) {
        logger.info("##### updatePermission Start");
        try {
            return new ResponseEntity<>(this.permissionService.updatePermission(permissionDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updatePermission ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch all permission
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permission.json/findAllPermission
     * {
     *     "status": "Success",
     *     "message": "Permission find successfully",
     *     "data": [
     *         {
     *             "permissionId": 1,
     *             "permissionUuid": "1",
     *             "permissionName": "USER_VIEW",
     *             "permissionAvailableIndicator": "N",
     *             "permissionCreate": "N",
     *             "permissionDelete": "N",
     *             "permissionUpdate": "N",
     *             "permissionRead": "Y",
     *             "permissionSoftDelete": "N",
     *             "createdDts": "2020-11-30T08:05:48.000+00:00",
     *             "activeStatus": "Y",
     *             "updatedDts": "2020-11-30T08:06:04.000+00:00"
     *         }
     * 	]
     * }
     * */
    @RequestMapping(value = "/findAllPermission", method = RequestMethod.GET)
    public ResponseEntity<?> findAllPermission() {
        logger.info("##### findAllPermission Start");
        try {
            return new ResponseEntity<>(this.permissionService.findAllPermission(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllPermission ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllPermissionSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllPermissionSearch(@RequestBody PermissionSearch permissionSearch) {
        logger.info("##### findAllPermissionSearch Start");
        try {
            return new ResponseEntity<>(this.permissionService.findAllPermissionSearch(permissionSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllPermissionSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch permission by id
     * @return ResponseEntity<?>
     * http://localhost:9095/api/permission.json/findPermissionByPermissionId?permissionId=9
     * {
     *     "status": "Success",
     *     "message": "Permission find successfully",
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
    @RequestMapping(value = "/findPermissionByPermissionUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findPermissionByPermissionUuid(@RequestParam String permissionUuid) {
        logger.info("##### findPermissionByPermissionUuid Start");
        try {
            return new ResponseEntity<>(this.permissionService.findPermissionByPermissionUuid(permissionUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findPermissionByPermissionUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch permission by id
     * @return ResponseEntity<?>
     *  http://localhost:9095/api/permission.json/deletePermissionById?permissionId=9
     *  {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deletePermissionByPermissionUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePermissionByPermissionUuid(@RequestParam String permissionUuid) {
        logger.info("##### deletePermissionByPermissionUuid Start");
        try {
            return new ResponseEntity<>(this.permissionService.deletePermissionByPermissionUuid(permissionUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deletePermissionById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
