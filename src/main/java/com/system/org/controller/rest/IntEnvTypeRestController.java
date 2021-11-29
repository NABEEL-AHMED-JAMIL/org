package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntEnvTypeDto;
import com.system.org.dto.search.IntEnvTypeSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntEnvTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intEnvType.json")
public class IntEnvTypeRestController {

    private Logger logger = LoggerFactory.getLogger(IntEnvTypeRestController.class);

    @Autowired
    private IntEnvTypeServiceImpl intEnvTypeService;

    @RequestMapping(value = "/createIntEnvType", method = RequestMethod.POST)
    public ResponseEntity<?> createIntEnvType(@RequestBody IntEnvTypeDto intEnvTypeDto) {
        logger.info("##### createIntEnvType Start");
        try {
            logger.info(intEnvTypeDto.toString());
            return new ResponseEntity<>(this.intEnvTypeService.createIntEnvType(intEnvTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntEnvType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntEnvType", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntEnvType(@RequestBody IntEnvTypeDto intEnvTypeDto) {
        logger.info("##### updateIntEnvType Start");
        try {
            logger.info(intEnvTypeDto.toString());
            return new ResponseEntity<>(this.intEnvTypeService.updateIntEnvType(intEnvTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntEnvType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntEnvType", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntEnvType() {
        logger.info("##### findAllIntEnvType Start");
        try {
            return new ResponseEntity<>(this.intEnvTypeService.findAllIntEnvType(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntEnvType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntEnvTypeSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntEnvTypeSearch(@RequestBody IntEnvTypeSearch intEnvTypeSearch) {
        logger.info("##### findAllIntEnvTypeSearch Start");
        try {
            return new ResponseEntity<>(this.intEnvTypeService.findAllIntEnvTypeSearch(intEnvTypeSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntEnvTypeSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntEnvTypeByIntEnvTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntEnvTypeByIntEnvTypeUuid(@RequestParam String intEnvTypeUuid) {
        logger.info("##### findIntEnvTypeByIntEnvTypeUuid Start");
        try {
            return new ResponseEntity<>(this.intEnvTypeService.findIntEnvTypeByIntEnvTypeUuid(intEnvTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntEnvTypeByIntEnvTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntEnvTypeByIntEnvTypeUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntEnvTypeByIntEnvTypeUuid(@RequestParam String intEnvTypeUuid) {
        logger.info("##### deleteIntEnvTypeByIntEnvTypeUuid Start");
        try {
            return new ResponseEntity<>(this.intEnvTypeService.deleteIntEnvTypeByIntEnvTypeUuid(intEnvTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntEnvTypeByIntEnvTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
