package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdParamDto;
import com.system.org.dto.search.IntCmdParamSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntCmdParamServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intCmdParam.json")
public class IntCmdParamRestController {

    private Logger logger = LoggerFactory.getLogger(IntCmdParamRestController.class);

    @Autowired
    private IntCmdParamServiceImpl intCmdParamService;

    @RequestMapping(value = "/createIntCmdParam", method = RequestMethod.POST)
    public ResponseEntity<?> createIntCmdParam(@RequestBody IntCmdParamDto intCmdParamDto) {
        logger.info("##### createIntCmdParam Start");
        try {
            logger.info(intCmdParamDto.toString());
            return new ResponseEntity<>(this.intCmdParamService.createIntCmdParam(intCmdParamDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntCmdParam ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/updateIntCmdParam", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntCmdParam(@RequestBody IntCmdParamDto intCmdParamDto) {
        logger.info("##### updateIntCmdParam Start");
        try {
            logger.info(intCmdParamDto.toString());
            return new ResponseEntity<>(this.intCmdParamService.updateIntCmdParam(intCmdParamDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntCmdParam ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findAllIntCmdParam", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntCmdParam() {
        logger.info("##### findAllIntCmdParam Start");
        try {
            return new ResponseEntity<>(this.intCmdParamService.findAllIntCmdParam(),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntCmdParam ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntCmdParamSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntCmdParamSearch(@RequestBody IntCmdParamSearch intCmdParamSearch) {
        logger.info("##### findAllIntCmdParamSearch Start");
        try {
            return new ResponseEntity<>(this.intCmdParamService.findAllIntCmdParamSearch(intCmdParamSearch),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntCmdParamSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findIntCmdParamByIntCmdParamUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntCmdParamByIntCmdParamUuid(@RequestParam String intCmdParamUuid) {
        logger.info("##### findIntCmdParamByIntCmdParamUuid Start");
        try {
            return new ResponseEntity<>(this.intCmdParamService.findIntCmdParamByIntCmdParamUuid(intCmdParamUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntCmdParamByIntCmdParamUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/deleteIntCmdParamByIntCmdParamUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntCmdParamByIntCmdParamUuid(@RequestParam String intCmdParamUuid) {
        logger.info("##### deleteIntCmdParamByIntCmdParamUuid Start");
        try {
            return new ResponseEntity<>(this.intCmdParamService.deleteIntCmdParamByIntCmdParamUuid(intCmdParamUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntCmdParamByIntCmdParamUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
