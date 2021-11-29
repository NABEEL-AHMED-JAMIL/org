package com.system.org.repository;

import com.system.org.enums.ActiveStatus;
import com.system.org.model.OrganizationModule;
import com.system.org.repository.projection.OrganizationModuleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationModuleRepository extends JpaRepository<OrganizationModule, Long> {

    @Query(value = "select b.Organization_Module_id as organizationModuleId, b.Organization_Module_uuid as organizationModuleUuid," +
        "a.organisation_id as organisationId,a.organization_uuid as organizationUuid,a.organization_name as organizationName," +
        "a.organization_shortdescription as organizationShortDescription,a.organization_description as organizationDescription," +
        "c.modules_lookup_id as modulesLookupId,c.modules_lookup_uuid as modulesLookupUuid,c.modules_lookup_number as modulesLookupNumber,"+
        "c.modules_lookup_short_description as modulesLookupShortDescription,c.modules_lookup_name as modulesLookupName," +
        "c.modules_lookup_description as modulesLookupDescription FROM organization a, organization_module b, modules_lookup c\n" +
        "where (a.organization_uuid = b.organization_uuid) and (b.module_lookup_uuid = c.modules_lookup_uuid) and b.active_status='Y';", nativeQuery = true)
    public List<OrganizationModuleProjection> findAllByData();

    public Optional<OrganizationModule> findByOrganizationModuleUuidAndActiveStatus(String organizationModuleId, ActiveStatus activeStatus);

    public Optional<OrganizationModule> findByOrganizationModuleUuid(String organizationModuleId);


}
