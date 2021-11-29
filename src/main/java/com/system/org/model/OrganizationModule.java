package com.system.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@Entity
@Table(name = "organization_module")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationModule extends BaseEntity {

    @Id
    @Column(name = "Organization_Module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationModuleId;

    @Column(name = "Organization_Module_uuid", nullable = false)
    private String organizationModuleUuid;

    @Column(name = "Organization_uuid", nullable = false)
    private String organizationUuid;

    @Column(name = "module_lookup_uuid", nullable = false)
    private String moduleLookupUuid;

    public OrganizationModule() { }

    public Long getOrganizationModuleId() {
        return organizationModuleId;
    }
    public void setOrganizationModuleId(Long organizationModuleId) {
        this.organizationModuleId = organizationModuleId;
    }

    public String getOrganizationModuleUuid() {
        return organizationModuleUuid;
    }
    public void setOrganizationModuleUuid(String organizationModuleUuid) {
        this.organizationModuleUuid = organizationModuleUuid;
    }

    public String getOrganizationUuid() {
        return organizationUuid;
    }
    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getModuleLookupUuid() {
        return moduleLookupUuid;
    }
    public void setModuleLookupUuid(String moduleLookupUuid) {
        this.moduleLookupUuid = moduleLookupUuid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
