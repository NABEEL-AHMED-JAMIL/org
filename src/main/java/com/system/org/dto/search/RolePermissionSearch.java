package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolePermissionSearch {

    private String rolePermissionId;
    private String rolePermissionUuid;
    private String roleId;
    private String permissionId;
    private String rolePermissionAuthorizationUserId;
    private String rolePermissionAvailableIndicator;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public RolePermissionSearch() {
    }

    public String getRolePermissionId() {
        return rolePermissionId;
    }
    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public String getRolePermissionUuid() {
        return rolePermissionUuid;
    }
    public void setRolePermissionUuid(String rolePermissionUuid) {
        this.rolePermissionUuid = rolePermissionUuid;
    }

    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRolePermissionAuthorizationUserId() {
        return rolePermissionAuthorizationUserId;
    }
    public void setRolePermissionAuthorizationUserId(String rolePermissionAuthorizationUserId) {
        this.rolePermissionAuthorizationUserId = rolePermissionAuthorizationUserId;
    }

    public String getRolePermissionAvailableIndicator() {
        return rolePermissionAvailableIndicator;
    }
    public void setRolePermissionAvailableIndicator(String rolePermissionAvailableIndicator) {
        this.rolePermissionAvailableIndicator = rolePermissionAvailableIndicator;
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
