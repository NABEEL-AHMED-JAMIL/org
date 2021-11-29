package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.OrganizationModuleDto;
import com.system.org.dto.search.OrganizationModuleLinkSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.OrganizationModuleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/organization_module.json")
public class OrganizationModuleRestController {

    private Logger logger = LoggerFactory.getLogger(OrganizationModuleRestController.class);

    @Autowired
    private OrganizationModuleServiceImpl organizationModuleService;

    /**
     * This method use to link the org-modules
     * @param organizationModuleDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization_module.json/linkModuleToOrganization
     * {
     * 	"organizationUuid": "0971bbb1-68b8-400b-866a-7137ad467bb2",
     *  "moduleLookupUuid": "5a08786b-5c47-4f1d-b963-cb5d790069b8",
     *  "createdBy": "sdfadf-sdfs"
     * }
     * {
     *     "status": "Success",
     *     "message": "OrganizationSearch Module save successfully",
     *     "data": {
     *         "createdDts": "2021-04-05T10:22:23.448+00:00",
     *         "createdBy": "sdfadf-sdfs",
     *         "activeStatus": "Y",
     *         "organizationModuleId": 1,
     *         "organizationModuleUuid": "6447affc-fc45-4b24-bc34-cce8c70a3263",
     *         "organizationUuid": "0971bbb1-68b8-400b-866a-7137ad467bb2",
     *         "moduleLookupUuid": "5a08786b-5c47-4f1d-b963-cb5d790069b8"
     *     }
     * }
     * */
    @RequestMapping(value = "/linkModuleToOrganization", method = RequestMethod.PUT)
    public ResponseEntity<?> linkModuleToOrganization(@RequestBody OrganizationModuleDto organizationModuleDto) {
        logger.info("##### linkModuleToOrganization Start");
        try {
            return new ResponseEntity<>(this.organizationModuleService.linkModuleToOrganization(organizationModuleDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while linkModuleToOrganization ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to link the org-modules
     * @param organizationModuleDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization_module.json/upDateLinkModuleToOrganization
     * {
     * 	"organizationUuid": "0971bbb1-68b8-400b-866a-7137ad467bb2",
     *  "moduleLookupUuid": "5a08786b-5c47-4f1d-b963-cb5d790069b8",
     *  "createdBy": "sdfadf-sdfs"
     * }
     * {
     *     "status": "Success",
     *     "message": "OrganizationSearch Module save successfully",
     *     "data": {
     *         "createdDts": "2021-04-05T10:22:23.448+00:00",
     *         "createdBy": "sdfadf-sdfs",
     *         "activeStatus": "Y",
     *         "organizationModuleId": 1,
     *         "organizationModuleUuid": "6447affc-fc45-4b24-bc34-cce8c70a3263",
     *         "organizationUuid": "0971bbb1-68b8-400b-866a-7137ad467bb2",
     *         "moduleLookupUuid": "5a08786b-5c47-4f1d-b963-cb5d790069b8"
     *     }
     * }
     * */
    @RequestMapping(value = "/upDateLinkModuleToOrganization", method = RequestMethod.PUT)
    public ResponseEntity<?> upDateLinkModuleToOrganization(@RequestBody OrganizationModuleDto organizationModuleDto) {
        logger.info("##### upDateLinkModuleToOrganization Start");
        try {
            return new ResponseEntity<>(this.organizationModuleService.upDateLinkModuleToOrganization(organizationModuleDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while upDateLinkModuleToOrganization ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the link-org-module
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization_module.json/findAllOrganizationModule
     * {
     *     "status": "Success",
     *     "message": "OrganizationSearch Module fetch successfully",
     *     "data": [
     *         {
     *             "organizationDescription": "sfalksdfjalk",
     *             "organisationId": 2,
     *             "organizationShortDescription": "dslkfjalk ",
     *             "organizationUuid": "0971bbb1-68b8-400b-866a-7137ad467bb2",
     *             "organizationName": "NAbfadsfjlk",
     *             "modulesLookupName": "1",
     *             "modulesLookupDescription": "54564564",
     *             "modulesLookupId": 1,
     *             "modulesLookupUuid": "5a08786b-5c47-4f1d-b963-cb5d790069b8",
     *             "modulesLookupNumber": "1",
     *             "modulesLookupShortDescription": "5645465"
     *         }
     *     ]
     * }
     * */
    @RequestMapping(value = "/findAllOrganizationModule", method = RequestMethod.GET)
    public ResponseEntity<?> findAllOrganizationModule() {
        logger.info("##### findAllOrganizationModule Start");
        try {
            return new ResponseEntity<>(this.organizationModuleService.findAllOrganizationModule(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllOrganizationModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllOrganizationModuleLinkSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllOrganizationModuleLinkSearch(OrganizationModuleLinkSearch organizationModuleLinkSearch) {
        logger.info("##### findAllOrganizationModuleLinkSearch Start");
        try {
            return new ResponseEntity<>(this.organizationModuleService.findAllOrganizationModuleLinkSearch(organizationModuleLinkSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllOrganizationModuleLinkSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to find the target organization
     * @param organizationModuleUuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization.json/findOrganizationModuleById?organizationModuleId=1000
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
    @RequestMapping(value = "/findOrganizationModuleByOrganizationModuleUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findOrganizationModuleByOrganizationModuleUuid(@RequestParam String organizationModuleUuid) {
        logger.info("##### findOrganizationModuleByOrganizationModuleUuid Start");
        try {
            return new ResponseEntity<>(this.organizationModuleService.findOrganizationModuleByOrganizationModuleUuid(organizationModuleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findOrganizationModuleByOrganizationModuleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to delete the organization module by id
     * @param organizationModuleId
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization_module.json/deleteOrganizationModuleById?organizationModuleId=13
     * {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deleteOrganizationModuleByOrganizationModuleUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrganizationModuleByOrganizationModuleUuid(@RequestParam String organizationModuleUuid) {
        logger.info("##### deleteOrganizationModuleByOrganizationModuleUuid Start");
        try {
            return new ResponseEntity<>(this.organizationModuleService.deleteOrganizationModuleByOrganizationModuleUuid(organizationModuleUuid),
                HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteOrganizationModuleById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
