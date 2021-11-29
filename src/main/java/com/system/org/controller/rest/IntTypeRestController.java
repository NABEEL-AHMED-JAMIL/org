package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntTypeDto;
import com.system.org.dto.search.IntTypeSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntTypeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intType.json")
public class IntTypeRestController {

    private Logger logger = LoggerFactory.getLogger(IntTypeRestController.class);

    @Autowired
    private IntTypeServiceImpl intTypeService;

    @RequestMapping(value = "/createIntType", method = RequestMethod.POST)
    public ResponseEntity<?> createIntType(@RequestBody IntTypeDto intTypeDto) {
        logger.info("##### createIntType Start");
        try {
            return new ResponseEntity<>(this.intTypeService.createIntType(intTypeDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntType", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntType(@RequestBody IntTypeDto intTypeDto) {
        logger.info("##### updateIntType Start");
        try {
            return new ResponseEntity<>(this.intTypeService.updateIntType(intTypeDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntType", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntType() {
        logger.info("##### findAllIntType Start");
        try {
            return new ResponseEntity<>(this.intTypeService.findAllIntType(),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntType ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntTypeSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntTypeSearch(@RequestBody IntTypeSearch intTypeSearch) {
        logger.info("##### findAllIntTypeSearch Start");
        try {
            return new ResponseEntity<>(this.intTypeService.findAllIntTypeSearch(intTypeSearch),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntTypeSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntTypeByIntTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntTypeByIntTypeUuid(@RequestParam String intTypeUuid) {
        logger.info("##### findIntTypeByIntTypeUuid Start");
        try {
            return new ResponseEntity<>(this.intTypeService.findIntTypeByIntTypeUuid(intTypeUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntTypeByIntTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntTypeByIntTypeUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntTypeByIntTypeUuid(@RequestParam String intTypeUuid) {
        logger.info("##### deleteIntTypeByIntTypeUuid Start");
        try {
            return new ResponseEntity<>(this.intTypeService.deleteIntTypeByIntTypeUuid(intTypeUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntTypeByIntTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
