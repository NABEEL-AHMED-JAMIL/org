package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "organization_department")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDepartment extends BaseEntity {

    @Id
    @Column(name = "Organization_department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationDepartmentId;

    @Column(name = "Organization_department_uuid", unique = true)
    private String organizationDepartmentUuid;

    @Column(name = "Organization_uuid")
    private String organizationUuid;

    @Column(name = "department_lookup_uuid")
    private String departmentLookupUuid;

    public OrganizationDepartment() { }

    public Long getOrganizationDepartmentId() {
        return organizationDepartmentId;
    }
    public void setOrganizationDepartmentId(Long organizationDepartmentId) {
        this.organizationDepartmentId = organizationDepartmentId;
    }

    public String getOrganizationDepartmentUuid() {
        return organizationDepartmentUuid;
    }
    public void setOrganizationDepartmentUuid(String organizationDepartmentUuid) {
        this.organizationDepartmentUuid = organizationDepartmentUuid;
    }

    public String getOrganizationUuid() {
        return organizationUuid;
    }
    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getDepartmentLookupUuid() {
        return departmentLookupUuid;
    }
    public void setDepartmentLookupUuid(String departmentLookupUuid) {
        this.departmentLookupUuid = departmentLookupUuid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
