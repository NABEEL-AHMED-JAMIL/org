package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceDto;
import com.system.org.dto.search.ResourceSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.ResourceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/resource.json")
public class ResourceRestController {

    private Logger logger = LoggerFactory.getLogger(ResourceRestController.class);

    @Autowired
    private ResourceServiceImpl resourceService;

    /**
     * This method use to create the resource
     * @param resourceDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resource.json/createResource
     * {
     * 	"resourceName": "1233455",
     * 	"resourceType": "safdafdafa",
     * 	"resourceDesc": "safdafdafa",
     * 	"resourceTypeDesc": "safdafdafa",
     * 	"resourceVersionNumber": "safdafdafa",
     * 	"resourceAvailableIndicator": "safdafdafa",
     * 	"resourceParentId": "safdafdafa",
     * 	"resourceAuthUserId": "safdafdafa",
     * 	"createdBy": "0597302e-44fb-11eb-a086-3df61ba5e799"
     * }
     * {
     *     "status": "Success",
     *     "message": "Resource save successfully",
     *     "data": {
     *         "createdDts": "2021-04-09T17:30:04.563+00:00",
     *         "createdBy": "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "activeStatus": "Y",
     *         "resourceId": 9,
     *         "resourceUuid": "2801e661-3ec5-4845-bf87-0678be1ba9a2",
     *         "resourceName": "1233455",
     *         "resourceType": "safdafdafa",
     *         "resourceDesc": "safdafdafa",
     *         "resourceTypeDesc": "safdafdafa",
     *         "resourceVersionNumber": "safdafdafa",
     *         "resourceAvailableIndicator": "safdafdafa",
     *         "resourceParentId": "safdafdafa",
     *         "resourceAuthUserId": "safdafdafa"
     *     }
     * }
     * */
    @RequestMapping(value = "/createResource", method = RequestMethod.POST)
    public ResponseEntity<?> createResource(@RequestBody ResourceDto resourceDto) {
        logger.info("##### createResource Start");
        try {
            return new ResponseEntity<>(this.resourceService.createResource(resourceDto), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createResource ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to create the resource
     * @param resourceDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resource.json/updateResource
     *  {
     *  	"updatedBy": "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *  	"resourceId": 9,
     *  	"resourceUuid": "2801e661-3ec5-4845-bf87-0678be1ba9a2",
     *  	"resourceName": "123345589-88",
     *  	"resourceType": "123345589-88",
     *  	"resourceDesc": "123345589-88",
     *  	"resourceTypeDesc": "123345589-88",
     *  	"resourceVersionNumber": "123345589-88",
     *  	"resourceAvailableIndicator": "123345589-88",
     *  	"resourceParentId": "123345589-88",
     *  	"resourceAuthUserId": "123345589-88"
     *  }
     *  {
     *     "status": "Success",
     *     "message": "Resource update successfully",
     *     "data": {
     *         "createdDts": "2021-04-09T17:30:05.000+00:00",
     *         "createdBy": "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "activeStatus": "Y",
     *         "updatedDts": "2021-04-10T08:56:36.608+00:00",
     *         "updatedBy": "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "resourceId": 9,
     *         "resourceUuid": "fea08f9b-1ec1-4c71-a924-a4c90629e550",
     *         "resourceName": "123345589-88",
     *         "resourceType": "123345589-88",
     *         "resourceDesc": "123345589-88",
     *         "resourceTypeDesc": "123345589-88",
     *         "resourceVersionNumber": "123345589-88",
     *         "resourceAvailableIndicator": "123345589-88",
     *         "resourceParentId": "123345589-88",
     *         "resourceAuthUserId": "123345589-88"
     *     }
     * }
     * */
    @RequestMapping(value = "/updateResource", method = RequestMethod.PUT)
    public ResponseEntity<?> updateResource(@RequestBody ResourceDto resourceDto) {
        logger.info("##### updateResource Start");
        try {
            logger.info(resourceDto.toString());
            return new ResponseEntity<>(this.resourceService.updateResource(resourceDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateOrganization ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch all resource
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resource.json/findAllResource
     * {
     *     "status": "Success",
     *     "message": "Resource find successfully",
     *     "data": [
     *         {
     *             "createdDts": "2021-03-09T12:11:13.000+00:00",
     *             "activeStatus": "Y",
     *             "updatedDts": "2021-03-09T12:31:49.000+00:00",
     *             "resourceId": 1,
     *             "resourceUuid": "20b1v1ae-8125-11eb-bedd-00e04456025a",
     *             "resourceName": "resource1",
     *             "resourceType": "auto",
     *             "resourceDesc": "resource desc",
     *             "resourceTypeDesc": "resource desc",
     *             "resourceVersionNumber": "1",
     *             "resourceAvailableIndicator": "Y"
     *         }
     *     ]
     * }
     * */
    @RequestMapping(value = "/findAllResource", method = RequestMethod.GET)
    public ResponseEntity<?> findAllResource() {
        logger.info("##### findAllResource Start");
        try {
            return new ResponseEntity<>(this.resourceService.findAllResource(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllResource ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllResourceSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllResourceSearch(ResourceSearch resourceSearch) {
        logger.info("##### findAllResourceSearch Start");
        try {
            return new ResponseEntity<>(this.resourceService.findAllResourceSearch(resourceSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllResourceSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the resource by id
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resource.json/findResourceById?resourceId=9
     * {
     *     "status": "Success",
     *     "message": "Resource find successfully",
     *     "data": {
     *         "createdDts": "2021-04-09T17:30:05.000+00:00",
     *         "createdBy": "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "activeStatus": "Y",
     *         "resourceId": 9,
     *         "resourceUuid": "2801e661-3ec5-4845-bf87-0678be1ba9a2",
     *         "resourceName": "1233455",
     *         "resourceType": "safdafdafa",
     *         "resourceDesc": "safdafdafa",
     *         "resourceTypeDesc": "safdafdafa",
     *         "resourceVersionNumber": "safdafdafa",
     *         "resourceAvailableIndicator": "safdafdafa",
     *         "resourceParentId": "safdafdafa",
     *         "resourceAuthUserId": "safdafdafa"
     *     }
     * }
     * */
    @RequestMapping(value = "/findResourceByResourceUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findResourceByResourceUuid(@RequestParam String resourceUuid) {
        logger.info("##### findResourceByResourceUuid Start");
        try {
            return new ResponseEntity<>(this.resourceService.findResourceByResourceUuid(resourceUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findResourceById ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to delete the organization module by id
     * @param resourceUuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/organization_module.json/deleteResourceById?resourceId=13
     * {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deleteResourceByResourceUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteResourceByResourceUuid(@RequestParam String resourceUuid) {
        logger.info("##### deleteResourceByResourceUuid Start");
        try {
            return new ResponseEntity<>(this.resourceService.deleteResourceByResourceUuid(resourceUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteResourceByResourceUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
