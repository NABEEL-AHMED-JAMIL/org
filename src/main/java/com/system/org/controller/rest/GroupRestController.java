package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.GroupDto;
import com.system.org.dto.search.GroupSearch;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.GroupServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/group.json")
public class GroupRestController {

    private Logger logger = LoggerFactory.getLogger(GroupRestController.class);

    @Autowired
    private GroupServiceImpl groupService;

    @RequestMapping(value = "/createGroup", method = RequestMethod.POST)
    public ResponseEntity<?> createGroup(@RequestBody GroupDto groupDto) {
        logger.info("##### createGroup Start");
        try {
            logger.info(groupDto.toString());
            return new ResponseEntity<>(this.groupService.createGroup(groupDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while createGroup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGroup(@RequestBody GroupDto groupDto) {
        logger.info("##### updateGroup Start");
        try {
            logger.info(groupDto.toString());
            return new ResponseEntity<>(this.groupService.updateGroup(groupDto),
                    HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while updateGroup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllGroup", method = RequestMethod.GET)
    public ResponseEntity<?> findAllGroup() {
        logger.info("##### findAllGroup Start");
        try {
            return new ResponseEntity<>(this.groupService.findAllGroup(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllGroup ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllGroupWithActiveStatus", method = RequestMethod.GET)
    public ResponseEntity<?> findAllGroupWithActiveStatus() {
        logger.info("##### findAllGroupWithActiveStatus Start");
        try {
            return new ResponseEntity<>(this.groupService.findAllGroupWithActiveStatus(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllGroupWithActiveStatus ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllGroupSearch", method = RequestMethod.POST)
    public ResponseEntity<?> findAllGroupSearch(@RequestBody GroupSearch groupSearch) {
        logger.info("##### findAllGroupSearch Start");
        try {
            return new ResponseEntity<>(this.groupService.findAllGroupSearch(groupSearch), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllGroupSearch ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/findGroupByGroupUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findGroupByGroupUuid(@RequestParam String groupUuid) {
        logger.info("##### findGroupByGroupUuid Start");
        try {
            return new ResponseEntity<>(this.groupService.findGroupByGroupUuid(groupUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findGroupByGroupUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteGroupByGroupUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGroupByGroupUuid(@RequestParam String groupUuid) {
        logger.info("##### deleteGroupByGroupUuid Start");
        try {
            return new ResponseEntity<>(this.groupService.deleteGroupByGroupUuid(groupUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteGroupByGroupUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
