package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntAppDto;
import com.system.org.dto.search.IntAppSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntAppServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intApp.json")
public class IntAppRestController {

    private Logger logger = LoggerFactory.getLogger(IntAppRestController.class);

    @Autowired
    private IntAppServiceImpl intAppService;

    @RequestMapping(value = "/createIntApp", method = RequestMethod.POST)
    public ResponseEntity<?> createIntApp(@RequestBody IntAppDto intAppDto) {
        logger.info("##### createIntApp Start");
        try {
            logger.info(intAppDto.toString());
            return new ResponseEntity<>(this.intAppService.createIntApp(intAppDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntApp ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntApp", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntApp(@RequestBody IntAppDto intAppDto) {
        logger.info("##### updateIntApp Start");
        try {
            logger.info(intAppDto.toString());
            return new ResponseEntity<>(this.intAppService.updateIntApp(intAppDto), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntApp ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntApp", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntApp() {
        logger.info("##### findAllIntApp Start");
        try {
            return new ResponseEntity<>(this.intAppService.findAllIntApp(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntApp ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntAppSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntAppSearch(@RequestBody IntAppSearch intAppSearch) {
        logger.info("##### findAllIntAppSearch Start");
        try {
            return new ResponseEntity<>(this.intAppService.findAllIntAppSearch(intAppSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntAppSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntAppByIntAppUuId", method = RequestMethod.GET)
    public ResponseEntity<?> findIntAppByIntAppUuId(@RequestParam String intAppUuId) {
        logger.info("##### findIntAppByIntAppUuId Start");
        try {
            return new ResponseEntity<>(this.intAppService.findIntAppByIntAppUuId(intAppUuId), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntAppByIntAppUuId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntAppByIntAppUuId", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntAppByIntAppUuId(@RequestParam String intAppUuId) {
        logger.info("##### deleteIntAppByIntAppUuId Start");
        try {
            return new ResponseEntity<>(this.intAppService.deleteIntAppByIntAppUuId(intAppUuId), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntAppByIntAppUuId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
