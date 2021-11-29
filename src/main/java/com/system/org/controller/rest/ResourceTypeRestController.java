package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceTypeDto;
import com.system.org.dto.search.ResourceTypeSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.ResourceTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/resourceType.json")
public class ResourceTypeRestController {

    private Logger logger = LoggerFactory.getLogger(ResourceTypeRestController.class);

    @Autowired
    private ResourceTypeServiceImpl resourceTypeService;

    /**
     * This method use to create the resource type
     * @param resourceTypeDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceType.json/createResourceType
     * {
     * 	"resourceTypeName": "ABC",
     * 	"resourceTypeDesc": "EFG"
     * }
     * {
     *     "status": "Success",
     *     "message": "Resource save successfully",
     *     "data": {
     *         "resourceTypeId": 5,
     *         "resourceTypeUuid": "d14dbc35-77d6-4261-ac33-258fcca47dd2",
     *         "resourceTypeName": "ABC",
     *         "resourceTypeDesc": "EFG",
     *         "activeStatus": "Y"
     *     }
     * }
     * */
    @RequestMapping(value = "/createResourceType", method = RequestMethod.POST)
    public ResponseEntity<?> createResourceType(@RequestBody ResourceTypeDto resourceTypeDto) {
        logger.info("##### createResourceType Start");
        try {
            return new ResponseEntity<>(this.resourceTypeService.createResourceType(resourceTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createResourceType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to update the resource type
     * @param resourceTypeDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceType.json/updateResourceType
     * {
     * 	"resourceTypeId": 6,
     * 	"resourceTypeUuid": "15b165b6-b6f5-4098-a537-8620bdcfd8d4",
     * 	"resourceTypeName": "BADSD",
     * 	"resourceTypeDesc": "EFG",
     * 	"activeStatus": "Y"
     * }
     * {
     *     "status": "Success",
     *     "message": "Resource update successfully",
     *     "data": {
     *         "resourceTypeId": 6,
     *         "resourceTypeUuid": "15b165b6-b6f5-4098-a537-8620bdcfd8d4",
     *         "resourceTypeName": "BADSD",
     *         "resourceTypeDesc": "EFG",
     *         "activeStatus": "Y"
     *     }
     * }
     * */
    @RequestMapping(value = "/updateResourceType", method = RequestMethod.PUT)
    public ResponseEntity<?> updateResourceType(@RequestBody ResourceTypeDto resourceTypeDto) {
        logger.info("##### updateResourceType Start");
        try {
            return new ResponseEntity<>(this.resourceTypeService.updateResourceType(resourceTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateResourceType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch all the resource type
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceType.json/findAllResourceType
     * {
     *     "status": "Success",
     *     "message": "ResourceType find successfully",
     *     "data": [
     *         {
     *             "resourceTypeId": 3,
     *             "resourceTypeUuid": "8c8d3843-148e-45f4-928b-5b9d2afa5449",
     *             "resourceTypeName": "dfas",
     *             "resourceTypeDesc": "sdfas",
     *             "activeStatus": "Y"
     *         }
     *     ]
     * }
     * */
    @RequestMapping(value = "/findAllResourceType", method = RequestMethod.GET)
    public ResponseEntity<?> findAllResourceType() {
        logger.info("##### findAllResourceType Start");
        try {
            return new ResponseEntity<>(this.resourceTypeService.findAllResourceType(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllResourceType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllResourceTypeSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllResourceTypeSearch(@RequestBody ResourceTypeSearch resourceTypeSearch) {
        logger.info("##### findAllResourceTypeSearch Start");
        try {
            return new ResponseEntity<>(this.resourceTypeService.findAllResourceTypeSearch(resourceTypeSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllResourceTypeSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the resource type by id
     * techvista
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceType.json/findResourceTypeById?resourceTypeId=4
     * {
     *     "status": "Success",
     *     "message": "ResourceType find successfully",
     *     "data": {
     *         "resourceTypeId": 4,
     *         "resourceTypeUuid": "0388b5cb-f7bd-4c5f-933a-fb159f26cd95",
     *         "resourceTypeName": "dfsdfsdfas",
     *         "resourceTypeDesc": "dsdfsdf",
     *         "activeStatus": "Y"
     *     }
     * }
     * */
    @RequestMapping(value = "/findResourceTypeByResourceTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findResourceTypeByResourceTypeUuid(@RequestParam String resourceTypeUuid) {
        logger.info("##### findResourceTypeByResourceTypeUuid Start");
        try {
            return new ResponseEntity<>(this.resourceTypeService.findResourceTypeByResourceTypeUuid(resourceTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findResourceTypeByResourceTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to delete resource type
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceType.json/deleteResourceTypeById?resourceTypeId=4
     * {
     *     "status": "Success",
     *     "message": "Delete successfully",
     * }
     * */
    @RequestMapping(value = "/deleteResourceTypeByResourceTypeUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteResourceTypeByResourceTypeUuid(@RequestParam String resourceTypeUuid) {
        logger.info("##### deleteResourceTypeByResourceTypeUuid Start");
        try {
            return new ResponseEntity<>(this.resourceTypeService.deleteResourceTypeByResourceTypeUuid(resourceTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteResourceTypeById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
