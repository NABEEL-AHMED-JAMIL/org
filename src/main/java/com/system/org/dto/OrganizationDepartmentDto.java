package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDepartmentDto {

    private Long organizationDepartmentId;
    private String organizationDepartmentUuid;
    private String organizationUuid;
    private String departmentLookupUuid;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public OrganizationDepartmentDto() { }

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

    public Timestamp getUpdatedDts() {
        return updatedDts;
    }
    public void setUpdatedDts(Timestamp updatedDts) {
        this.updatedDts = updatedDts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreatedDts() {
        return createdDts;
    }
    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
