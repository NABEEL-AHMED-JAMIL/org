package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRoleSearch {

    private String userRoleId;
    private String userRoleUuid;
    private String permissionId;
    private String userId;
    private String userRoleAuthorizationUserId;
    private String userRoleAvailableIndicator;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public UserRoleSearch() { }

    public String getUserRoleId() {
        return userRoleId;
    }
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleUuid() {
        return userRoleUuid;
    }
    public void setUserRoleUuid(String userRoleUuid) {
        this.userRoleUuid = userRoleUuid;
    }

    public String getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRoleAuthorizationUserId() {
        return userRoleAuthorizationUserId;
    }
    public void setUserRoleAuthorizationUserId(String userRoleAuthorizationUserId) {
        this.userRoleAuthorizationUserId = userRoleAuthorizationUserId;
    }

    public String getUserRoleAvailableIndicator() {
        return userRoleAvailableIndicator;
    }
    public void setUserRoleAvailableIndicator(String userRoleAvailableIndicator) {
        this.userRoleAvailableIndicator = userRoleAvailableIndicator;
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
