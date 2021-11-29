package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleSearch {

    private String roleId;
    private String roleUuid;
    private String roleName;
    private String roleType;
    private String roleLabel;
    private String roleIndicator;
    private String roleAuthUserId;
    private String roleComments;
    private String roleGroup;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public RoleSearch() {
    }

    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleUuid() {
        return roleUuid;
    }
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid;
    }

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleLabel() {
        return roleLabel;
    }
    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public String getRoleIndicator() {
        return roleIndicator;
    }
    public void setRoleIndicator(String roleIndicator) {
        this.roleIndicator = roleIndicator;
    }

    public String getRoleAuthUserId() {
        return roleAuthUserId;
    }
    public void setRoleAuthUserId(String roleAuthUserId) {
        this.roleAuthUserId = roleAuthUserId;
    }

    public String getRoleComments() {
        return roleComments;
    }
    public void setRoleComments(String roleComments) {
        this.roleComments = roleComments;
    }

    public String getRoleGroup() {
        return roleGroup;
    }
    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
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
