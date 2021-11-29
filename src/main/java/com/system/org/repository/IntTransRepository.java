package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.IntTrans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IntTransRepository extends JpaRepository<IntTrans, Long> {

    Optional<IntTrans> findByIntTransNameAndActiveStatus(String intTransName, ActiveStatus activeStatus);

    Optional<IntTrans> findByIntTransUuidAndActiveStatus(String intTransUuid, ActiveStatus activeStatus);

    Optional<IntTrans> findByIntTransUuid(String intTransUuid);

    List<IntTrans> findAllByActiveStatus(ActiveStatus activeStatus);
}
