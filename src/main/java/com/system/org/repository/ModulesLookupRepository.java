package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.ModulesLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModulesLookupRepository extends JpaRepository<ModulesLookup, Long> {

    List<ModulesLookup> findAllByActiveStatus(ActiveStatus activeStatus);

    Optional<ModulesLookup> findByModulesLookupUuid(String modulesLookupUuid);

    Optional<ModulesLookup> findByModulesLookupUuidAndActiveStatus(String modulesLookupUuid, ActiveStatus activeStatus);

    Optional<ModulesLookup> findByModulesLookupNameAndActiveStatus(String modulesLookupName, ActiveStatus activeStatus);

}
