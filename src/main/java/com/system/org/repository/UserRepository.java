package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserUuid(String userUuid);

    Optional<User> findByUserEmailAndActiveStatus(String userEmail, ActiveStatus activeStatus);

}
