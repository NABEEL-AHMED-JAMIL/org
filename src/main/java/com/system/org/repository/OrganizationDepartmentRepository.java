package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.Organization;
import com.system.org.model.OrganizationDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationDepartmentRepository extends JpaRepository<OrganizationDepartment, Long> {

    Optional<OrganizationDepartment> findByOrganizationDepartmentUuidAndActiveStatus(String organizationDepartmentUuid, ActiveStatus activeStatus);

    Optional<OrganizationDepartment> findByOrganizationDepartmentUuid(String organizationDepartmentUuid);

    List<OrganizationDepartment> findAllByActiveStatus(ActiveStatus activeStatus);
}
