package com.system.org.service.impl;

import com.system.org.controller.Response;
import com.system.org.dto.JwtAuthenticationRequest;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.User;
import com.system.org.model.view.PermissionListView;
import com.system.org.repository.UserRepository;
import com.system.org.security.TokenHelper;
import com.system.org.security.UserPrincipal;
import com.system.org.service.AuthTokenService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@Transactional
@Scope("prototype")
public class AuthServiceImpl implements AuthTokenService {

    public Logger logger = LogManager.getLogger(AuthServiceImpl.class);

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private UtilServiceImpl utilService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response login(JwtAuthenticationRequest jwtAuthenticationRequest) throws Exception {
        Optional<User> appUser = null;
        if (isValidEmail(jwtAuthenticationRequest.getUsername().trim())) {
            appUser = this.userRepository.findByUserEmailAndActiveStatus(jwtAuthenticationRequest.getUsername(), ActiveStatus.Y);
            if (!appUser.isPresent()) {
                return new Response("ERROR", "USER NOT FOUND");
            }
            String token = this.tokenHelper.generateToken(appUser.get().getUserEmail());
            if (!token.isEmpty()) {
                UserPrincipal userPrincipal = UserPrincipal.create(appUser.get(), (List<PermissionListView>)
                        this.utilService.findAllLoginUserRole(appUser.get().getUserEmail()).getData());
                userPrincipal.setToken(token);
                userPrincipal.setPassword(null);
                return new Response("SUCCESS", "User login success",  userPrincipal);
            } else {
                return new Response("ERROR", "UNEXPECTED ERROR");
            }
        } else {
            return new Response("ERROR", "INVALID EMAIL Or User Not Found");
        }
    }

    public static boolean isValidEmail(String emailStr) {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE).matcher(emailStr);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }
}