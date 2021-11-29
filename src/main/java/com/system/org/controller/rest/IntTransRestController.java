package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntTransDto;
import com.system.org.dto.search.IntTransSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntTransServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intTrans.json")
public class IntTransRestController {

    private Logger logger = LoggerFactory.getLogger(IntTransRestController.class);

    @Autowired
    private IntTransServiceImpl intTransService;

    @RequestMapping(value = "/createIntTrans", method = RequestMethod.POST)
    public ResponseEntity<?> createIntTrans(@RequestBody IntTransDto intTransDto) {
        logger.info("##### createIntTrans Start");
        try {
            logger.info(intTransDto.toString());
            return new ResponseEntity<>(this.intTransService.createIntTrans(intTransDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntTrans ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntTrans", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntTrans(@RequestBody IntTransDto intTransDto) {
        logger.info("##### updateIntTrans Start");
        try {
            logger.info(intTransDto.toString());
            return new ResponseEntity<>(this.intTransService.updateIntTrans(intTransDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntTrans ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntTrans", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntTrans() {
        logger.info("##### findAllIntTrans Start");
        try {
            return new ResponseEntity<>(this.intTransService.findAllIntTrans(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntTrans ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntTransSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntTransSearch(@RequestBody IntTransSearch intTransSearch) {
        logger.info("##### findAllIntTransSearch Start");
        try {
            return new ResponseEntity<>(this.intTransService.findAllIntTransSearch(intTransSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntTransSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntTransByIntTransUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntTransByIntTransUuid(@RequestParam String intTransUuid) {
        logger.info("##### findIntTransByIntTransUuid Start");
        try {
            return new ResponseEntity<>(this.intTransService.findIntTransByIntTransUuid(intTransUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntTransByIntTransUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntTransByIntTransUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntTransByIntTransUuid(@RequestParam String intTransUuid) {
        logger.info("##### deleteIntTransByIntTransUuid Start");
        try {
            return new ResponseEntity<>(this.intTransService.deleteIntTransByIntTransUuid(intTransUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntTransByIntTransUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
