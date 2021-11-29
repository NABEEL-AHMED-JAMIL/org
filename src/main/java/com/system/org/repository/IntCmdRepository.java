package com.system.org.repository;

import com.system.org.model.IntCmd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntCmdRepository extends JpaRepository<IntCmd, Long> {

    @Query(value = "SELECT coalesce(max(int_cmd_id), 0) FROM int_cmd", nativeQuery = true)
    public Long getMaxId();

    Optional<IntCmd> findByIntCmdUuid(String intCmdUuid);
}
