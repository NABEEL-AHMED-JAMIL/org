package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.enums.ActiveStatus;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.impl.UtilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/util.json")
public class UtilRestController {

    private Logger logger = LoggerFactory.getLogger(UtilRestController.class);

    @Autowired
    private UtilServiceImpl utilService;

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllActiveUserUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllActiveUserUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllActiveUserUUID() {
        logger.info("##### getAllActiveUserUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllActiveUserUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllActiveUserUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to fetch the organization uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllOrganizationUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllOrganizationUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrganizationUUID() {
        logger.info("##### getAllOrganizationUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllOrganizationUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllOrganizationUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to fetch the organization
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllModuleLookupUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllModuleLookupUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllModuleLookupUUID() {
        logger.info("##### getAllModuleLookupUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllModuleLookupUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllModuleLookupUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the organization
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllResourceUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllResourceUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllResourceUUID() {
        logger.info("##### getAllResourceUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllResourceUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllResourceUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the organization
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllResourceId
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllResourceId", method = RequestMethod.GET)
    public ResponseEntity<?> getAllResourceId() {
        logger.info("##### getAllResourceId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllResourceId(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllResourceId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllPermissionUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllPermissionUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermissionUUID() {
        logger.info("##### getAllPermissionUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllPermissionUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllPermissionUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllRoleUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllRoleUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoleUUID() {
        logger.info("##### getAllRoleUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllRoleUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllRoleUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllGroupUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllGroupUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllGroupUUID() {
        logger.info("##### getAllGroupUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllGroupUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllGroupUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllOrgUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllOrgUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrgUUID() {
        logger.info("##### getAllOrgUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllOrgUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllOrgUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllOrgID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrgID() {
        logger.info("##### getAllOrgID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllOrgID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllOrgID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllPermissionTypeUUID
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllPermissionTypeUUID", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermissionTypeUUID() {
        logger.info("##### getAllOrgUUID Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllPermissionTypeUUID(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllOrgUUID ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllPermissionTypeUUID2
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllPermissionTypeUUID2", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPermissionTypeUUID2() {
        logger.info("##### getAllPermissionTypeUUID2 Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllPermissionTypeUUID2(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllPermissionTypeUUID2 ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllResourceTypeId
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllResourceTypeId", method = RequestMethod.GET)
    public ResponseEntity<?> getAllResourceTypeId() {
        logger.info("##### getAllResourceTypeId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllResourceTypeId(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllResourceTypeId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllYntTypeId
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllIntTypeId", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntTypeId() {
        logger.info("##### getAllIntTypeId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllIntTypeId(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllIntTypeId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllIntTypeUuid
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllIntTypeUuid", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntTypeUuid() {
        logger.info("##### getAllIntTypeId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllIntTypeUuid(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllIntTypeUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllIntCmdParamId
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllIntCmdParamId", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntCmdParamId() {
        logger.info("##### getAllIntTypeId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllIntCmdParamId(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllIntCmdParamId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllIntCmdParamUuid
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllIntCmdParamUuid", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntCmdParamUuid() {
        logger.info("##### getAllIntTypeId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllIntCmdParamUuid(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllIntCmdParamUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllIntCmdId
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllIntCmdId", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntCmdId() {
        logger.info("##### getAllIntCmdId Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllIntCmdId(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllIntCmdId ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method use to fetch the user uuid
     * @return ResponseEntity<?>
     * http://localhost:9095/api/util.json/getAllIntCmdUuid
     * {
     *     "status": "Success",
     *     "message": "Fetch Data Successfully",
     *     "data": [
     *         "ec9eddee-32dd-11eb-8551-f84a89d27f07",
     *         "0597302e-44fb-11eb-a086-3df61ba5e799",
     *         "07bad1b6-4600-11eb-a086-3df61ba5e799",
     *         "3bb5d7e0-4600-11eb-a086-3df61ba5e799"
     *     ]
     * }
     * */
    @RequestMapping(value = "/getAllIntCmdUuid", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntCmdUuid() {
        logger.info("##### getAllIntCmdUuid Start");
        try {
            return new ResponseEntity<>(this.utilService.getAllIntCmdUuid(ActiveStatus.Y), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("An error occurred while getAllIntCmdUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
