package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionResourceModuleSearch {

    private String permissionResourceModuleId;
    private String permissionResourceModuleUuid;
    private String permissionResourceModuleName;
    private String permissionResourceModuleDesc;
    private String permissionResourceModuleResourceUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public PermissionResourceModuleSearch() { }

    public String getPermissionResourceModuleId() {
        return permissionResourceModuleId;
    }
    public void setPermissionResourceModuleId(String permissionResourceModuleId) {
        this.permissionResourceModuleId = permissionResourceModuleId;
    }

    public String getPermissionResourceModuleUuid() {
        return permissionResourceModuleUuid;
    }
    public void setPermissionResourceModuleUuid(String permissionResourceModuleUuid) {
        this.permissionResourceModuleUuid = permissionResourceModuleUuid;
    }

    public String getPermissionResourceModuleName() {
        return permissionResourceModuleName;
    }
    public void setPermissionResourceModuleName(String permissionResourceModuleName) {
        this.permissionResourceModuleName = permissionResourceModuleName;
    }

    public String getPermissionResourceModuleDesc() {
        return permissionResourceModuleDesc;
    }
    public void setPermissionResourceModuleDesc(String permissionResourceModuleDesc) {
        this.permissionResourceModuleDesc = permissionResourceModuleDesc;
    }

    public String getPermissionResourceModuleResourceUuid() {
        return permissionResourceModuleResourceUuid;
    }
    public void setPermissionResourceModuleResourceUuid(String permissionResourceModuleResourceUuid) {
        this.permissionResourceModuleResourceUuid = permissionResourceModuleResourceUuid;
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
