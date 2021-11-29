package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "permission")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission {

    @Id
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(name = "permission_uuid", nullable = false)
    private String permissionUuid;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_desc")
    private String permissionDesc;

    @Column(name = "permission_resource_id")
    private String permissionResourceId;

    @Column(name = "permission_resource_uuid")
    private String permissionResourceUuid;

    @Column(name = "permission_available_indicator")
    private String permissionAvailableIndicator;

    @Column(name = "permission_create")
    private String permissionCreate;

    @Column(name = "permission_create_permission_type_id")
    private String permissionCreatePermissionTypeId;

    @Column(name = "permission_delete")
    private String permissionDelete;

    @Column(name = "permission_delete_permission_type_\u206Fid")
    private String permissionDeletePermissionTypeId;

    @Column(name = "permission_update")
    private String permissionUpdate;

    @Column(name = "permission_update_permission_type_\u206Fid")
    private String permissionUpdatePermissionTypeId;

    @Column(name = "permission_read")
    private String permissionRead;

    @Column(name = "permission_read_permission_type_\u206Fid")
    private String permissionReadPermissionTypeId;

    @Column(name = "permission_softdelete")
    private String permissionSoftDelete;

    @Column(name = "permission_softdelete_permission_type_\u206Fid")
    private String permissionSoftDeletePermissionTypeId;

    @Column(name = "permission_operater_id")
    private String permissionOperaterId;

    @Column(name = "permission_authorize_user_id")
    private String permissionAuthorizeUserId;

    @Column(name = "created_dts", columnDefinition =
            "timestamp default CURRENT_TIMESTAMP", nullable = false)
    private Timestamp createdDts;

    @Column(name = "crated_by")
    private String cratedBy;

    @Column(name = "active_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    @Column(name = "updated_dts")
    private Timestamp updatedDts;

    @Column(name = "updated_by")
    private String updatedBy;


    public Permission() {
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDts = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        this.setCreatedDts(new Timestamp(System.currentTimeMillis()));
    }

    public Long getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Long permissionId) {
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

    public Timestamp getCreatedDts() {
        return createdDts;
    }
    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCratedBy() {
        return cratedBy;
    }
    public void setCratedBy(String cratedBy) {
        this.cratedBy = cratedBy;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Timestamp getUpdatedDts() {
        return updatedDts;
    }
    public void setUpdatedDts(Timestamp updatedDts) {
        this.updatedDts = updatedDts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
