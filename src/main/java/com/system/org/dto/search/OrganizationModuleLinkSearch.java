package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationModuleLinkSearch {

    private String organizationModuleId;
    private String organizationModuleUuid;
    private String organizationUuid;
    private String moduleLookupUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public OrganizationModuleLinkSearch() { }

    public String getOrganizationModuleId() {
        return organizationModuleId;
    }
    public void setOrganizationModuleId(String organizationModuleId) {
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
