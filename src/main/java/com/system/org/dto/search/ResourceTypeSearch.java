package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceTypeSearch {

    private String resourceTypeId;
    private String resourceTypeUuid;
    private String resourceTypeName;
    private String resourceTypeDesc;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public ResourceTypeSearch() { }

    public String getResourceTypeId() {
        return resourceTypeId;
    }
    public void setResourceTypeId(String resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceTypeUuid() {
        return resourceTypeUuid;
    }
    public void setResourceTypeUuid(String resourceTypeUuid) {
        this.resourceTypeUuid = resourceTypeUuid;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }
    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public String getResourceTypeDesc() {
        return resourceTypeDesc;
    }
    public void setResourceTypeDesc(String resourceTypeDesc) {
        this.resourceTypeDesc = resourceTypeDesc;
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
