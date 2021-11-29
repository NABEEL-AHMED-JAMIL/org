package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.Group;
import com.system.org.repository.projection.GroupProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByGroupNameAndActiveStatus(String groupName, ActiveStatus activeStatus);

    Optional<Group> findByGroupUuid(String groupUuid);

    @Query(value = "select group_id as groupId, group_uuid as groupUuid, group_name as groupName,\n" +
        "group_short_name as groupShortName, group_desc as groupDesc, created_by as createdBy, created_dts as createdDts,\n" +
        "updated_by as updateBy, upated_dts as updatedDts, active_status as activeStatus \n" +
        "from `group`;", nativeQuery = true)
    List<GroupProjection> findAllGroup();

    List<Group> findAllByActiveStatus(ActiveStatus activeStatus);
}
