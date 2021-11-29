package com.system.org.controller.rest;

import com.system.org.controller.Response;
import com.system.org.dto.JwtAuthenticationRequest;
import com.system.org.exception.ExceptionUtil;
import com.system.org.service.AuthTokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth.json", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthRestApi {

    public Logger logger = LogManager.getLogger(AuthRestApi.class);

    @Autowired
    private AuthTokenService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtAuthenticationRequest authenticationReq) {
        Response response = null;
        try {
            final Authentication authentication = this.authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(authenticationReq.getUsername(), authenticationReq.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            response = this.authService.login(authenticationReq);
            logger.info("Request for login " + authenticationReq);
            return new ResponseEntity<>(response, HttpStatus.OK);
          } catch (Exception ex) {
            logger.info("Error during login " + ExceptionUtil.getRootCause(ex));
            return new ResponseEntity<>(new Response("ERROR", "INVALID CREDENTIAL"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
