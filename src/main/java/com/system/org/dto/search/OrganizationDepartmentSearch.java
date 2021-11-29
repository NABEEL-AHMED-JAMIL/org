package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDepartmentSearch {

    private String organizationDepartmentId;
    private String organizationDepartmentUuid;
    private String organizationUuid;
    private String departmentLookupUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public OrganizationDepartmentSearch() {}

    public String getOrganizationDepartmentId() {
        return organizationDepartmentId;
    }
    public void setOrganizationDepartmentId(String organizationDepartmentId) {
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

    public String getFromDate() {
        return fromDate;
    }
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getUpdateFromDate() {
        return updateFromDate;
    }
    public void setUpdateFromDate(String updateFromDate) {
        this.updateFromDate = updateFromDate;
    }

    public String getUpdateToDate() {
        return updateToDate;
    }
    public void setUpdateToDate(String updateToDate) {
        this.updateToDate = updateToDate;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
