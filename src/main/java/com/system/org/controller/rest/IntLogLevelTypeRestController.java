package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntLogLevelTypeDto;
import com.system.org.dto.search.IntLogLevelTypeSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntLogLevelTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intLogLevelType.json")
public class IntLogLevelTypeRestController {

    private Logger logger = LoggerFactory.getLogger(IntLogLevelTypeRestController.class);

    @Autowired
    private IntLogLevelTypeServiceImpl logLevelTypeService;

    @RequestMapping(value = "/createIntLogLevelType", method = RequestMethod.POST)
    public ResponseEntity<?> createIntLogLevelType(@RequestBody IntLogLevelTypeDto intLogLevelTypeDto) {
        logger.info("##### createIntLogLevelType Start");
        try {
            logger.info(intLogLevelTypeDto.toString());
            return new ResponseEntity<>(this.logLevelTypeService.createIntLogLevelType(intLogLevelTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntLogLevelType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntLogLevelType", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntLogLevelType(@RequestBody IntLogLevelTypeDto intLogLevelTypeDto) {
        logger.info("##### updateIntLogLevelType Start");
        try {
            logger.info(intLogLevelTypeDto.toString());
            return new ResponseEntity<>(this.logLevelTypeService.updateIntLogLevelType(intLogLevelTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntLogLevelType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntLogLevelType", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntLogLevelType() {
        logger.info("##### findAllIntLogLevelType Start");
        try {
            return new ResponseEntity<>(this.logLevelTypeService.findAllIntLogLevelType(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntLogLevelType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntLogLevelTypeSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntLogLevelTypeSearch(@RequestBody IntLogLevelTypeSearch intLogLevelTypeSearch) {
        logger.info("##### findAllIntLogLevelTypeSearch Start");
        try {
            return new ResponseEntity<>(this.logLevelTypeService.findAllIntLogLevelTypeSearch(intLogLevelTypeSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntLogLevelTypeSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntLogLevelTypeByIntLogLevelTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntLogLevelTypeByIntLogLevelTypeUuid(@RequestParam String intLogLevelTypeUuid) {
        logger.info("##### findIntLogLevelTypeByIntLogLevelTypeUuid Start");
        try {
            return new ResponseEntity<>(this.logLevelTypeService.findIntLogLevelTypeByIntLogLevelTypeUuid(intLogLevelTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntLogLevelTypeByIntLogLevelTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntLogLevelTypeByIntLogLevelTypeUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntLogLevelTypeByIntLogLevelTypeUuid(@RequestParam String intLogLevelTypeUuid) {
        logger.info("##### deleteIntLogLevelTypeByIntLogLevelTypeUuid Start");
        try {
            return new ResponseEntity<>(this.logLevelTypeService.deleteIntLogLevelTypeByIntLogLevelTypeUuid(intLogLevelTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntLogLevelTypeByIntLogLevelTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
