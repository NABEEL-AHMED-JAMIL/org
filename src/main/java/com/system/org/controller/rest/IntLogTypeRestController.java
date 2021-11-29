package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntLogTypeDto;
import com.system.org.dto.search.IntLogTypeSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntLogTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intLogType.json")
public class IntLogTypeRestController {

    private Logger logger = LoggerFactory.getLogger(IntLogTypeRestController.class);

    @Autowired
    private IntLogTypeServiceImpl intLogTypeService;

    @RequestMapping(value = "/createIntLogType", method = RequestMethod.POST)
    public ResponseEntity<?> createIntLogType(@RequestBody IntLogTypeDto intLogTypeDto) {
        logger.info("##### createIntLogType Start");
        try {
            logger.info(intLogTypeDto.toString());
            return new ResponseEntity<>(this.intLogTypeService.createIntLogType(intLogTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntLogType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntLogType", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntLogType(@RequestBody IntLogTypeDto intLogTypeDto) {
        logger.info("##### updateIntLogType Start");
        try {
            logger.info(intLogTypeDto.toString());
            return new ResponseEntity<>(this.intLogTypeService.updateIntLogType(intLogTypeDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntLogType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntLogType", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntLogType() {
        logger.info("##### findAllIntLogType Start");
        try {
            return new ResponseEntity<>(this.intLogTypeService.findAllIntLogType(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntLogType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntLogTypSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntLogTypSearch(@RequestBody IntLogTypeSearch intLogTypeSearch) {
        logger.info("##### findAllIntLogTypSearch Start");
        try {
            return new ResponseEntity<>(this.intLogTypeService.findAllIntLogTypSearch(intLogTypeSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntLogTypSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntLogTypByIntLogTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntLogTypByIntLogTypeUuid(@RequestParam String intLogTypeUuid) {
        logger.info("##### findIntLogTypByIntLogTypeUuid Start");
        try {
            return new ResponseEntity<>(this.intLogTypeService.findIntLogTypByIntLogTypeUuid(intLogTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntLogTypByIntLogTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntLogTypByIntLogTypeUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntLogTypByIntLogTypeUuid(@RequestParam String intLogTypeUuid) {
        logger.info("##### deleteIntLogTypByIntLogTypeUuid Start");
        try {
            return new ResponseEntity<>(this.intLogTypeService.deleteIntLogTypByIntLogTypeUuid(intLogTypeUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntLogLevelTypeByIntLogTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
