package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdDto;
import com.system.org.dto.search.IntCmdSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntCmdServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intCmd.json")
public class IntCmdRestController {

    private Logger logger = LoggerFactory.getLogger(IntCmdRestController.class);

    @Autowired
    private IntCmdServiceImpl intCmdService;

    @RequestMapping(value = "/createIntCmd", method = RequestMethod.POST)
    public ResponseEntity<?> createIntCmd(@RequestBody IntCmdDto intCmdDto) {
        logger.info("##### createIntCmd Start");
        try {
            return new ResponseEntity<>(this.intCmdService.createIntCmd(intCmdDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntCmd ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/updateIntCmd", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntCmd(@RequestBody IntCmdDto intCmdDto) {
        logger.info("##### updateIntCmd Start");
        try {
            return new ResponseEntity<>(this.intCmdService.updateIntCmd(intCmdDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntCmd ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findAllIntCmd", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntCmd() {
        logger.info("##### findAllIntCmd Start");
        try {
            return new ResponseEntity<>(this.intCmdService.findAllIntCmd(),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntCmd ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntCmdSearch", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntCmdSearch(@RequestBody IntCmdSearch intCmdSearch) {
        logger.info("##### findAllIntCmdSearch Start");
        try {
            return new ResponseEntity<>(this.intCmdService.findAllIntCmdSearch(intCmdSearch),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntCmdSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findIntCmdByIntCmdUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntCmdByIntCmdUuid(@RequestParam String intCmdUuid) {
        logger.info("##### findIntCmdByIntCmdUuid Start");
        try {
            return new ResponseEntity<>(this.intCmdService.findIntCmdByIntCmdUuid(intCmdUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntCmdByIntCmdUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntCmdByIntCmdUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntCmdByIntCmdUuid(@RequestParam String intCmdUuid) {
        logger.info("##### deleteIntCmdByIntCmdUuid Start");
        try {
            return new ResponseEntity<>(this.intCmdService.deleteIntCmdByIntCmdUuid(intCmdUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntCmdByIntCmdUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
