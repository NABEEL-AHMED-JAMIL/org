package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.IntCmdImpDto;
import com.system.org.dto.search.IntCmdImpSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.IntCmdImpServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/intCmdImp.json")
public class IntCmdImpRestController {

    private Logger logger = LoggerFactory.getLogger(IntCmdImpRestController.class);

    @Autowired
    private IntCmdImpServiceImpl intCmdImpService;

    @RequestMapping(value = "/createIntCmdImp", method = RequestMethod.POST)
    public ResponseEntity<?> createIntCmdImp(@RequestBody IntCmdImpDto intCmdImpDto) {
        logger.info("##### createIntCmdImp Start");
        try {
            logger.info(intCmdImpDto.toString());
            return new ResponseEntity<>(this.intCmdImpService.createIntCmdImp(intCmdImpDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createIntCmdImp ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateIntCmdImp", method = RequestMethod.PUT)
    public ResponseEntity<?> updateIntCmdImp(@RequestBody IntCmdImpDto intCmdImpDto) {
        logger.info("##### updateIntCmdImp Start");
        try {
            logger.info(intCmdImpDto.toString());
            return new ResponseEntity<>(this.intCmdImpService.updateIntCmdImp(intCmdImpDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateIntCmdImp ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findAllIntCmdImp", method = RequestMethod.GET)
    public ResponseEntity<?> findAllIntCmdImp() {
        logger.info("##### findAllIntCmdImp Start");
        try {
            return new ResponseEntity<>(this.intCmdImpService.findAllIntCmdImp(),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntCmdImp ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllIntCmdImpSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllIntCmdImpSearch(@RequestBody IntCmdImpSearch intCmdImpSearch) {
        logger.info("##### findAllIntCmdImpSearch Start");
        try {
            return new ResponseEntity<>(this.intCmdImpService.findAllIntCmdImpSearch(intCmdImpSearch),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllIntCmdImpSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findIntCmdImpByIntCmdImpUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findIntCmdImpByIntCmdImpUuid(@RequestParam String intCmdImpUuid) {
        logger.info("##### findIntCmdImpByIntCmdImpUuid Start");
        try {
            return new ResponseEntity<>(this.intCmdImpService.findIntCmdImpByIntCmdImpUuid(intCmdImpUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findIntCmdImpByIntCmdImpUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteIntCmdImpByIntCmdImpUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteIntCmdImpByIntCmdImpUuid(@RequestParam String intCmdImpUuid) {
        logger.info("##### deleteIntCmdImpByIntCmdImpUuid Start");
        try {
            return new ResponseEntity<>(this.intCmdImpService.deleteIntCmdImpByIntCmdImpUuid(intCmdImpUuid),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteIntCmdImpByIntCmdImpUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
