package com.system.org.filter;

import com.system.org.exception.ExceptionUtil;
import com.system.org.security.AnonAuthentication;
import com.system.org.security.TokenHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nabeel Ahmed
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    public Logger logger = LogManager.getLogger(TokenAuthenticationFilter.class);

    @Autowired
    public TokenHelper tokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        FilterChain filterChain) throws ServletException, IOException {
        // get token from the request
        String authToken = this.tokenHelper.getToken(httpServletRequest);
        if (authToken != null) {
            try {
                // user email
                String requestJson = this.tokenHelper.getUsernameFromToken(authToken);
                if (requestJson != null) {
                    logger.debug("Verify AppUser Detail With Token.");
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(
                        this.userDetailsService.loadUserByUsername(requestJson));
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception ex) {
                logger.error("Error " + ExceptionUtil.getRootCauseMessage(ex));
                //SecurityContextHolder.getContext().setAuthentication(new AnonAuthentication());
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
