package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationDto;
import com.system.org.dto.search.OrganizationSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.OrganizationServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/organization.json")
public class OrganizationRestController {

    private Logger logger = LoggerFactory.getLogger(OrganizationRestController.class);

    @Autowired
    private OrganizationServiceImpl organizationService;

    /**
     * This method use to create the organization
     * @param organizationDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/createOrganization
     * {
     * 	"organizationName": "org3",
     *     "organizationShortDescription": "org1",
     *     "organizationDescription": "org1",
     *     "createdDts": "2021-02-01T10:58:57",
     *     "createdBy": 1
     * }
     * {
     *     "status": "Success",
     *     "message": "OrganizationSearch save successfully",
     *     "data": {
     *         "createdDts": "2021-04-04T08:32:50.567+00:00",
     *         "createdBy": 1,
     *         "activeStatus": "Y",
     *         "organisationId": 1002,
     *         "organizationUuid": "2661ceef-2d93-4b32-aeae-e16dd4ed6c1c",
     *         "organizationName": "org3",
     *         "organizationShortDescription": "org1",
     *         "organizationDescription": "org1"
     *     }
     * }
     * */
    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public ResponseEntity<?> createOrganization(@RequestBody OrganizationDto organizationDto) {
        logger.info("##### createOrganization Start");
        try {
            return new ResponseEntity<>(this.organizationService.createOrganization(organizationDto), HttpStatus.OK);
        } catch (Exception ex) {
        	ex.printStackTrace();
            logger.error("An error occurred while createOrganization ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to update the organization
     * @param organizationDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/updateOrganization
     * {
     *    "createdDts": "2021-04-04T08:32:50.567+00:00",
     *    "createdBy": 1,
     *    "activeStatus": "Y",
     *    "organisationId": 1002,
     *    "organizationUuid": "2661ceef-2d93-4b32-aeae-e16dd4ed6c1c",
     *    "organizationName": "159753699",
     *    "organizationShortDescription": "159753699",
     *    "organizationDescription": "159753699"
     * }
     * {
     *     "status": "Success",
     *     "message": "OrganizationSearch update successfully",
     *     "data": {
     *         "createdDts": "2021-04-04T08:32:50.567+00:00",
     *         "createdBy": 1,
     *         "activeStatus": "Y",
     *         "updatedDts": "2021-04-04T08:42:00.956+00:00",
     *         "organisationId": 1002,
     *         "organizationUuid": "2661ceef-2d93-4b32-aeae-e16dd4ed6c1c",
     *         "organizationName": "159753699",
     *         "organizationShortDescription": "159753699",
     *         "organizationDescription": "159753699"
     *     }
     * }
     * */
    @RequestMapping(value = "/updateOrganization", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOrganization(@RequestBody OrganizationDto organizationDto) {
        logger.info("##### updateOrganization Start");
        try {
            return new ResponseEntity<>(this.organizationService.updateOrganization(organizationDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateOrganization ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch all organization
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/findAllOrganization
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
    @RequestMapping(value = "/findAllOrganization", method = RequestMethod.GET)
    public ResponseEntity<?> findAllOrganization() {
        logger.info("##### findAllOrganization Start");
        try {
            return new ResponseEntity<>(this.organizationService.findAllOrganization(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllOrganization ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findOrganizationBySearch", method = RequestMethod.POST)
    public ResponseEntity<?> findOrganizationBySearch(@RequestBody OrganizationSearch organizationSearch) {
        logger.info("##### findOrganizationBySearch Start");
        try {
            return new ResponseEntity<>(this.organizationService.findOrganizationBySearch(organizationSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findOrganizationBySearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to find the target organization
     * @param organizationUuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/findOrganizationById?organizationUuid=1000
     * {
     *     "status": "Success",
     *     "message": "OrganizationSearch find successfully",
     *     "data": {
     *         "createdDts": "2021-04-04T08:31:52.723+00:00",
     *         "createdBy": 1,
     *         "activeStatus": "Y",
     *         "organisationId": 1000,
     *         "organizationUuid": "ca8e117d-c7d0-4615-be17-d81e8f792b24",
     *         "organizationName": "org1",
     *         "organizationShortDescription": "org1",
     *         "organizationDescription": "org1"
     *     }
     * }
     * */
    @RequestMapping(value = "/findOrganizationByOrganizationUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findOrganizationByOrganizationUuid(@RequestParam String organizationUuid) {
        logger.info("##### findOrganizationByOrganizationUuid Start");
        try {
            return new ResponseEntity<>(this.organizationService.findOrganizationByOrganizationUuid(organizationUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findOrganizationByOrganizationUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to delete the organization by id
     * @param organizationUuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/deleteOrganizationById?organisationId=11
     * {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deleteOrganizationByOrganizationUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrganizationById(@RequestParam String organizationUuid) {
        logger.info("##### deleteOrganizationByOrganizationUuid Start");
        try {
            return new ResponseEntity<>(this.organizationService.deleteOrganizationByOrganizationUuid(organizationUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteOrganizationByOrganizationUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
