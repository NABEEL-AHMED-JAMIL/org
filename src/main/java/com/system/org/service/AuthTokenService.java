package com.system.org.service;


import com.system.org.controller.Response;
import com.system.org.dto.JwtAuthenticationRequest;

/**
 * @author Nabeel Ahmed
 */
public interface AuthTokenService {

     public Response login(JwtAuthenticationRequest jwtAuthenticationRequest) throws Exception;
}
