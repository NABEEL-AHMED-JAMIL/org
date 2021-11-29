package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionTypeSearch {

    private String permissionTypeId;
    private String permissionTypeUuid;
    private String permissionTypeName;
    private String permissionTypeShortDescription;
    private String permissionTypeDescription;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public PermissionTypeSearch() { }

    public String getPermissionTypeId() {
        return permissionTypeId;
    }
    public void setPermissionTypeId(String permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    public String getPermissionTypeUuid() {
        return permissionTypeUuid;
    }
    public void setPermissionTypeUuid(String permissionTypeUuid) {
        this.permissionTypeUuid = permissionTypeUuid;
    }

    public String getPermissionTypeName() {
        return permissionTypeName;
    }
    public void setPermissionTypeName(String permissionTypeName) {
        this.permissionTypeName = permissionTypeName;
    }

    public String getPermissionTypeShortDescription() {
        return permissionTypeShortDescription;
    }
    public void setPermissionTypeShortDescription(String permissionTypeShortDescription) {
        this.permissionTypeShortDescription = permissionTypeShortDescription;
    }

    public String getPermissionTypeDescription() {
        return permissionTypeDescription;
    }
    public void setPermissionTypeDescription(String permissionTypeDescription) {
        this.permissionTypeDescription = permissionTypeDescription;
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
