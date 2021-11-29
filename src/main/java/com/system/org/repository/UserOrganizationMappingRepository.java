package com.system.org.repository;

import com.system.org.model.UserOrganizationMapping;
import com.system.org.repository.projection.UserOrganizationMappingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserOrganizationMappingRepository extends JpaRepository<UserOrganizationMapping, Long> {

    @Query(value = "select id as Id, orgId as orgId, userId as userId, created_dts as createdDts, updated_dts as updateDts, \n" +
            "active_status as activeStatus from userorganizationmapping", nativeQuery = true)
    List<UserOrganizationMappingProjection> findAllUserOrganizationMapping();
}
