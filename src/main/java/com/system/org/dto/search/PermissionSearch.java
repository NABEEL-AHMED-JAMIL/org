package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionSearch {

    private String permissionId;
    private String permissionUuid;
    private String permissionName;
    private String permissionDesc;
    private String permissionResourceId;
    private String permissionResourceUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public PermissionSearch() { }

    public String getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionUuid() {
        return permissionUuid;
    }
    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid;
    }

    public String getPermissionName() {
        return permissionName;
    }
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }
    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getPermissionResourceId() {
        return permissionResourceId;
    }
    public void setPermissionResourceId(String permissionResourceId) {
        this.permissionResourceId = permissionResourceId;
    }

    public String getPermissionResourceUuid() {
        return permissionResourceUuid;
    }
    public void setPermissionResourceUuid(String permissionResourceUuid) {
        this.permissionResourceUuid = permissionResourceUuid;
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
