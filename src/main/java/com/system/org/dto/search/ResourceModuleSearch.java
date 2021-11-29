package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceModuleSearch {

    private String resourceModuleId;
    private String resourceModuleUuid;
    private String resourceUuid;
    private String moduleUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public ResourceModuleSearch() {
    }

    public String getResourceModuleId() {
        return resourceModuleId;
    }
    public void setResourceModuleId(String resourceModuleId) {
        this.resourceModuleId = resourceModuleId;
    }

    public String getResourceModuleUuid() {
        return resourceModuleUuid;
    }
    public void setResourceModuleUuid(String resourceModuleUuid) {
        this.resourceModuleUuid = resourceModuleUuid;
    }

    public String getResourceUuid() {
        return resourceUuid;
    }
    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }

    public String getModuleUuid() {
        return moduleUuid;
    }
    public void setModuleUuid(String moduleUuid) {
        this.moduleUuid = moduleUuid;
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
