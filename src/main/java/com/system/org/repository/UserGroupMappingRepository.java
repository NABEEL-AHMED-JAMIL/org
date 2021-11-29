package com.system.org.repository;

import com.system.org.model.UserGroupMapping;
import com.system.org.repository.projection.UserGroupMappingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupMappingRepository extends JpaRepository<UserGroupMapping, Long> {

    @Query(value = "select id as Id, groupId as groupId, userId as userId, updated_dts as updatedDts, " +
            "created_dts as createdDts, active_status as activeStatus from usergroupmapping", nativeQuery = true)
    List<UserGroupMappingProjection> findAllUserGroupMapping();
}
