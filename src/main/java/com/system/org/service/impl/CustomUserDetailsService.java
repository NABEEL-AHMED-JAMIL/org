package com.system.org.service.impl;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.User;
import com.system.org.model.view.PermissionListView;
import com.system.org.repository.UserRepository;
import com.system.org.security.UserPrincipal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@Service
@Scope("prototype")
public class CustomUserDetailsService implements UserDetailsService {

    public Logger logger = LogManager.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UtilServiceImpl utilService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("login detail " + username);
        Optional<User> user = this.userRepository.findByUserEmailAndActiveStatus(username, ActiveStatus.Y);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return UserPrincipal.create(user.get(), (List<PermissionListView>)
                this.utilService.findAllLoginUserRole(username).getData());
        }
    }

}
