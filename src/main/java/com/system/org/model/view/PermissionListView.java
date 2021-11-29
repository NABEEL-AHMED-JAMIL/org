package com.system.org.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionListView {

    private String roleName;
    private String groupName;
    private String permissionUuid;
    private String permissionName;
    private String permissionResourceId;
    private String permissionResourceUuid;
    private String permissionAvailableIndicator;
    private String permissionCreate;
    private String permissionCreatePermissionTypeId;
    private String permissionDelete;
    private String permissionDeletePermissionTypeId;
    private String permissionUpdate;
    private String permissionUpdatePermissionTypeId;
    private String permissionRead;
    private String permissionReadPermissionTypeId;
    private String permissionSoftDelete;
    private String permissionSoftDeletePermissionTypeId;

    private String permissionOperaterId;
    private String permissionAuthorizeUserId;

    public PermissionListView() {}

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getPermissionAvailableIndicator() {
        return permissionAvailableIndicator;
    }
    public void setPermissionAvailableIndicator(String permissionAvailableIndicator) {
        this.permissionAvailableIndicator = permissionAvailableIndicator;
    }

    public String getPermissionCreate() {
        return permissionCreate;
    }
    public void setPermissionCreate(String permissionCreate) {
        this.permissionCreate = permissionCreate;
    }

    public String getPermissionCreatePermissionTypeId() {
        return permissionCreatePermissionTypeId;
    }
    public void setPermissionCreatePermissionTypeId(String permissionCreatePermissionTypeId) {
        this.permissionCreatePermissionTypeId = permissionCreatePermissionTypeId;
    }

    public String getPermissionDelete() {
        return permissionDelete;
    }
    public void setPermissionDelete(String permissionDelete) {
        this.permissionDelete = permissionDelete;
    }

    public String getPermissionDeletePermissionTypeId() {
        return permissionDeletePermissionTypeId;
    }
    public void setPermissionDeletePermissionTypeId(String permissionDeletePermissionTypeId) {
        this.permissionDeletePermissionTypeId = permissionDeletePermissionTypeId;
    }

    public String getPermissionUpdate() {
        return permissionUpdate;
    }
    public void setPermissionUpdate(String permissionUpdate) {
        this.permissionUpdate = permissionUpdate;
    }

    public String getPermissionUpdatePermissionTypeId() {
        return permissionUpdatePermissionTypeId;
    }
    public void setPermissionUpdatePermissionTypeId(String permissionUpdatePermissionTypeId) {
        this.permissionUpdatePermissionTypeId = permissionUpdatePermissionTypeId;
    }

    public String getPermissionRead() {
        return permissionRead;
    }
    public void setPermissionRead(String permissionRead) {
        this.permissionRead = permissionRead;
    }

    public String getPermissionReadPermissionTypeId() {
        return permissionReadPermissionTypeId;
    }
    public void setPermissionReadPermissionTypeId(String permissionReadPermissionTypeId) {
        this.permissionReadPermissionTypeId = permissionReadPermissionTypeId;
    }

    public String getPermissionSoftDelete() {
        return permissionSoftDelete;
    }
    public void setPermissionSoftDelete(String permissionSoftDelete) {
        this.permissionSoftDelete = permissionSoftDelete;
    }

    public String getPermissionSoftDeletePermissionTypeId() {
        return permissionSoftDeletePermissionTypeId;
    }
    public void setPermissionSoftDeletePermissionTypeId(String permissionSoftDeletePermissionTypeId) {
        this.permissionSoftDeletePermissionTypeId = permissionSoftDeletePermissionTypeId;
    }

    public String getPermissionOperaterId() {
        return permissionOperaterId;
    }
    public void setPermissionOperaterId(String permissionOperaterId) {
        this.permissionOperaterId = permissionOperaterId;
    }

    public String getPermissionAuthorizeUserId() {
        return permissionAuthorizeUserId;
    }
    public void setPermissionAuthorizeUserId(String permissionAuthorizeUserId) {
        this.permissionAuthorizeUserId = permissionAuthorizeUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionListView that = (PermissionListView) o;
        return Objects.equals(roleName, that.roleName) && Objects.equals(groupName, that.groupName)
                && Objects.equals(permissionUuid, that.permissionUuid) &&
                Objects.equals(permissionName, that.permissionName) &&
                Objects.equals(permissionResourceId, that.permissionResourceId) &&
                Objects.equals(permissionResourceUuid, that.permissionResourceUuid) &&
                Objects.equals(permissionAvailableIndicator, that.permissionAvailableIndicator) &&
                Objects.equals(permissionCreate, that.permissionCreate) &&
                Objects.equals(permissionCreatePermissionTypeId, that.permissionCreatePermissionTypeId) &&
                Objects.equals(permissionDelete, that.permissionDelete) &&
                Objects.equals(permissionDeletePermissionTypeId, that.permissionDeletePermissionTypeId) &&
                Objects.equals(permissionUpdate, that.permissionUpdate) &&
                Objects.equals(permissionUpdatePermissionTypeId, that.permissionUpdatePermissionTypeId) &&
                Objects.equals(permissionRead, that.permissionRead) &&
                Objects.equals(permissionReadPermissionTypeId, that.permissionReadPermissionTypeId) &&
                Objects.equals(permissionSoftDelete, that.permissionSoftDelete) &&
                Objects.equals(permissionSoftDeletePermissionTypeId, that.permissionSoftDeletePermissionTypeId) &&
                Objects.equals(permissionOperaterId, that.permissionOperaterId) &&
                Objects.equals(permissionAuthorizeUserId, that.permissionAuthorizeUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, groupName, permissionUuid, permissionName, permissionResourceId, permissionResourceUuid, permissionAvailableIndicator, permissionCreate, permissionCreatePermissionTypeId, permissionDelete, permissionDeletePermissionTypeId, permissionUpdate, permissionUpdatePermissionTypeId, permissionRead, permissionReadPermissionTypeId, permissionSoftDelete, permissionSoftDeletePermissionTypeId, permissionOperaterId, permissionAuthorizeUserId);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
