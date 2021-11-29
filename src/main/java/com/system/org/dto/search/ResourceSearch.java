package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceSearch {

    private String resourceId;
    private String resourceUuid;
    private String resourceName;
    private String resourceType;
    private String resourceDesc;
    private String resourceTypeDesc;
    private String resourceVersionNumber;
    private String resourceAvailableIndicator;
    private String resourceParentId;
    private String resourceAuthUserId;
    private String resourceResourceTypeUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public ResourceSearch() { }

    public String getResourceId() {
        return resourceId;
    }
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceUuid() {
        return resourceUuid;
    }
    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }

    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceTypeDesc() {
        return resourceTypeDesc;
    }
    public void setResourceTypeDesc(String resourceTypeDesc) {
        this.resourceTypeDesc = resourceTypeDesc;
    }

    public String getResourceVersionNumber() {
        return resourceVersionNumber;
    }
    public void setResourceVersionNumber(String resourceVersionNumber) {
        this.resourceVersionNumber = resourceVersionNumber;
    }

    public String getResourceAvailableIndicator() {
        return resourceAvailableIndicator;
    }
    public void setResourceAvailableIndicator(String resourceAvailableIndicator) {
        this.resourceAvailableIndicator = resourceAvailableIndicator;
    }

    public String getResourceParentId() {
        return resourceParentId;
    }
    public void setResourceParentId(String resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    public String getResourceAuthUserId() {
        return resourceAuthUserId;
    }
    public void setResourceAuthUserId(String resourceAuthUserId) {
        this.resourceAuthUserId = resourceAuthUserId;
    }

    public String getResourceResourceTypeUuid() {
        return resourceResourceTypeUuid;
    }
    public void setResourceResourceTypeUuid(String resourceResourceTypeUuid) {
        this.resourceResourceTypeUuid = resourceResourceTypeUuid;
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
