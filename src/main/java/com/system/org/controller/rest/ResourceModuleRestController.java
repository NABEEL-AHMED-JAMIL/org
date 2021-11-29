package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.ResourceModuleDto;
import com.system.org.dto.search.ResourceModuleSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.ResourceModuleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/resourceModule.json")
public class ResourceModuleRestController {

    private Logger logger = LoggerFactory.getLogger(ResourceModuleRestController.class);

    @Autowired
    private ResourceModuleServiceImpl resourceModuleService;

    /**
     * This method use to create the resource
     * @param resourceModuleDto
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceModule.json/createResourceModule
     * {
     * 	"resourceUuid": "20b171ae-8125-11eb-bedd-00e04c68025a",
     * 	"moduleUuid": "4f3ecd1d-8050-11eb-bedd-00e04c68025a",
     * 	"createdBy": "ec9eddee-32dd-11eb-8551-f84a89d27f07"
     * }
     * {
     *     "status": "Success",
     *     "message": "ResourceModule save successfully",
     *     "data": {
     *         "createdDts": "2021-04-10T09:10:44.454+00:00",
     *         "createdBy": "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "activeStatus": "Y",
     *         "resourceModuleId": 6,
     *         "resourceModuleUuid": "4773a7a6-487f-494d-b3cc-1968f34a1300",
     *         "resourceUuid": "20b171ae-8125-11eb-bedd-00e04c68025a",
     *         "moduleUuid": "4f3ecd1d-8050-11eb-bedd-00e04c68025a"
     *     }
     * }
     * */
    @RequestMapping(value = "/createResourceModule", method = RequestMethod.POST)
    public ResponseEntity<?> createResourceModule(@RequestBody ResourceModuleDto resourceModuleDto) {
        logger.info("##### createResourceModule Start");
        logger.info(resourceModuleDto.toString());
        try {
            return new ResponseEntity<>(this.resourceModuleService.createResourceModule(resourceModuleDto), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while createResourceModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * */
    @RequestMapping(value = "/updateResourceModule", method = RequestMethod.PUT)
    public ResponseEntity<?> updateResourceModule(@RequestBody ResourceModuleDto resourceModuleDto) {
        logger.info("##### updateResourceModule Start");
        try {
            return new ResponseEntity<>(this.resourceModuleService.updateResourceModule(resourceModuleDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateResourceModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the resource
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceModule.json/findAllResourceModule
     * {
     *     "status": "Success",
     *     "message": "ResourceModule find successfully",
     *     "data": [
     *         {
     *             "createdDts": "2021-04-10T08:32:53.000+00:00",
     *             "createdBy": "dsfs",
     *             "activeStatus": "Y",
     *             "resourceModuleId": 1,
     *             "resourceModuleUuid": "0d6004d2-eea1-4dec-8731-1eb8d4f96edb",
     *             "resourceUuid": "sdf",
     *             "moduleUuid": "sdf"
     *         }
     *     ]
     * }
     * */
    @RequestMapping(value = "/findAllResourceModule", method = RequestMethod.GET)
    public ResponseEntity<?> findAllResourceModule() {
        logger.info("##### findAllResourceModule Start");
        try {
            return new ResponseEntity<>(this.resourceModuleService.findAllResourceModule(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllResourceModule ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findResourceModuleSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findResourceModuleSearch(@RequestBody ResourceModuleSearch resourceModuleSearch) {
        logger.info("##### findResourceModuleSearch Start");
        try {
            return new ResponseEntity<>(this.resourceModuleService.findResourceModuleSearch(resourceModuleSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findResourceModuleSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the resource by id
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceModule.json/findResourceModuleById?resourceModuleId=4
     * {
     *     "status": "Success",
     *     "message": "ResourceModule find successfully",
     *     "data": {
     *         "createdDts": "2021-04-10T09:05:38.000+00:00",
     *         "createdBy": "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "activeStatus": "Y",
     *         "resourceModuleId": 4,
     *         "resourceModuleUuid": "0917aaf4-acc2-4ad0-b9f0-f639312164e3",
     *         "resourceUuid": "163bc636-f112-453f-b48c-b2f90dd41737",
     *         "moduleUuid": "d4764345-ea98-4ce3-a79d-e7d0855cc4c5"
     *     }
     * }
     * */
    @RequestMapping(value = "/findResourceModuleByResourceModuleUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findResourceModuleByResourceModuleUuid(@RequestParam String resourceModuleUuid) {
        logger.info("##### findResourceModuleByResourceModuleUuid Start");
        try {
            return new ResponseEntity<>(this.resourceModuleService.findResourceModuleByResourceModuleUuid(resourceModuleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findResourceModuleByResourceModuleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to delete the resource by id
     * @return ResponseEntity<?>
     * http://localhost:9095/api/resourceModule.json/deleteResourceModuleById?resourceModuleId=4
     * {
     *     "status": "Success",
     *     "message": "Delete successfully"
     * }
     * */
    @RequestMapping(value = "/deleteResourceModuleByResourceModuleUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteResourceModuleByResourceModuleUuid(@RequestParam String resourceModuleUuid) {
        logger.info("##### deleteResourceModuleByResourceModuleUuid Start");
        try {
            return new ResponseEntity<>(this.resourceModuleService.deleteResourceModuleByResourceModuleUuid(resourceModuleUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteResourceModuleByResourceModuleUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
