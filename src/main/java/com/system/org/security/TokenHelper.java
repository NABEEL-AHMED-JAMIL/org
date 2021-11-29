package com.system.org.security;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

/**
 * @author Nabeel Ahmed
 */
@Component
@Scope("prototype")
public class TokenHelper {

    private Logger logger = LogManager.getLogger(TokenHelper.class);

    @Value("${jwt.app.name}")
    private String APP_NAME;

    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.header}")
    private String AUTH_HEADER;

    @Value("${jwt.cookie}")
    private String AUTH_COOKIE;

    private String Bearer = "Bearer ";

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public TokenHelper() {}

    @PostConstruct
    public void init() {
        logger.info("+================TokenHelper-Start====================+");
        this.setSECRET(Base64.getEncoder().encodeToString(this.getSECRET().getBytes()));
        logger.info("+================TokenHelper-End====================+");
    }

    public String getAPP_NAME() {
        return APP_NAME;
    }
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME;
    }

    public String getSECRET() {
        return SECRET;
    }
    public void setSECRET(String SECRET) {
        this.SECRET = SECRET;
    }

    public int getEXPIRES_IN() {
        return EXPIRES_IN;
    }
    public void setEXPIRES_IN(int EXPIRES_IN) {
        this.EXPIRES_IN = EXPIRES_IN;
    }

    public String getAUTH_HEADER() {
        return AUTH_HEADER;
    }
    public void setAUTH_HEADER(String AUTH_HEADER) {
        this.AUTH_HEADER = AUTH_HEADER;
    }

    public String getAUTH_COOKIE() {
        return AUTH_COOKIE;
    }
    public void setAUTH_COOKIE(String AUTH_COOKIE) {
        this.AUTH_COOKIE = AUTH_COOKIE;
    }

    // will return the name of the user like email or username
    public String getUsernameFromToken(String token) throws Exception {
        return this.getClaimsFromToken(token).getSubject();
    }

    public String generateToken(String username) {
        return Jwts.builder().setIssuer(this.APP_NAME).setSubject(username).setIssuedAt(generateCurrentDate())
            .signWith(this.SIGNATURE_ALGORITHM, this.SECRET).compact();
    }

    private Claims getClaimsFromToken(String token) throws Exception {
        return Jwts.parser().setSigningKey(this.SECRET).parseClaimsJws(token).getBody();
    }

    public String getToken(HttpServletRequest request) {
        Cookie authCookie = getCookieValueByName(request, AUTH_COOKIE);
        if (authCookie != null) {
            logger.info("Token pic from cookie");
            return authCookie.getValue();
        }
        String authHeader = request.getHeader(this.AUTH_HEADER);
        if (authHeader != null && authHeader.startsWith(this.Bearer)) {
            logger.info("Token pic from header");
            return authHeader.substring(7);
        }
        return null;
    }

    public Cookie getCookieValueByName(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (int i = 0; i < request.getCookies().length; i++) {
                if (request.getCookies()[i].getName().equals(name)) {
                    return request.getCookies()[i];
                }
            }
        }
        return null;
    }

    private long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    private Date generateCurrentDate() {
        return new Date(getCurrentTimeMillis());
    }

    private Date generateExpirationDate() {
        return new Date(getCurrentTimeMillis() + this.EXPIRES_IN * 1000);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
