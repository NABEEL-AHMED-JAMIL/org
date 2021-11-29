package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntParamsDto;
import com.system.org.dto.search.IntParamsSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntParamsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intParams.json")
public class IntParamsRestController {

    private Logger logger = LoggerFactory.getLogger(IntParamsRestController.class);

    @Autowired
    private IntParamsServiceImpl intParamsService;

    @RequestMapping(value = "/createIntParams", method = RequestMethod.POST)
    public ResponseEntity<?> createIntParams(@RequestBody IntParamsDto intParamsDto) {
        logger.info("##### createIntParams Start");
        try {
            return new ResponseEntity<>(this.intParamsService.createIntParams(intParamsDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntParams ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntParams", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntParams(@RequestBody IntParamsDto intParamsDto) {
        logger.info("##### updateIntParams Start");
        try {
            return new ResponseEntity<>(this.intParamsService.updateIntParams(intParamsDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntParams ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntParams", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntParams() {
        logger.info("##### findAllIntParams Start");
        try {
            return new ResponseEntity<>(this.intParamsService.findAllIntParams(),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntParams ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntParamsSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntParamsSearch(@RequestBody IntParamsSearch intParamsSearch) {
        logger.info("##### findAllIntParamsSearch Start");
        try {
            return new ResponseEntity<>(this.intParamsService.findAllIntParamsSearch(intParamsSearch),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntParamsSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntParamsByIntParamsUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntParamsByIntParamsUuid(@RequestParam String intParamsUuid) {
        logger.info("##### findIntParamsByIntParamsUuid Start");
        try {
            return new ResponseEntity<>(this.intParamsService.findIntParamsByIntParamsUuid(intParamsUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntParamsByIntParamsUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntParamsByIntParamsUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntParamsByIntParamsUuid(@RequestParam String intParamsUuid) {
        logger.info("##### deleteIntParamsByIntParamsUuid Start");
        try {
            return new ResponseEntity<>(this.intParamsService.deleteIntParamsByIntParamsUuid(intParamsUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntParamsByIntParamsUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
