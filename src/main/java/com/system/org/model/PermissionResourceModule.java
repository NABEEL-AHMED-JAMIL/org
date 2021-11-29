package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "permission_resource_module")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionResourceModule {

    @Id
    @Column(name = "permission_resource_module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionResourceModuleId;

    @Column(name = "permission_resource_module_uuid", nullable = false)
    private String permissionResourceModuleUuid;

    @Column(name = "permission_resource_module_name")
    private String permissionResourceModuleName;

    @Column(name = "permission_resource_module_desc")
    private String permissionResourceModuleDesc;

    @Column(name = "permission_resource_module_resource_id")
    private String permissionResourceModuleResourceId;

    @Column(name = "permission_resource_module_resource_uuid")
    private String permissionResourceModuleResourceUuid;

    @Column(name = "permission_resource_module_available_indicator")
    private String permissionResourceModuleAvailableIndicator;

    @Column(name = "permission_resource_module_create")
    private String permissionResourceModuleCreate;

    @Column(name = "permission_resource_module_create_permission_type_id")
    private String permissionResourceModuleCreatePermissionTypeId;

    @Column(name = "permission_resource_module_delete")
    private String permissionResourceModuleDelete;

    @Column(name = "permission_resource_module_delete_permission_type_\u206Fid")
    private String permissionResourceModuleDeletePermissionTypeId;

    @Column(name = "permission_resource_module_update")
    private String permissionResourceModuleUpdate;

    @Column(name = "permission_resource_module_update_permission_type_\u206Fid")
    private String permissionResourceModuleUpdatePermissionTypeId;

    @Column(name = "permission_resource_module_read")
    private String permissionResourceModuleRead;

    @Column(name = "permission_resource_module_read_permission_type_\u206Fid")
    private String permissionResourceModuleReadPermissionTypeId;

    @Column(name = "permission_resource_module_softdelete")
    private String permissionResourceModuleSoftDelete;

    @Column(name = "permission_resource_module_softdelete_permission_type_\u206Fid")
    private String permissionResourceModuleSoftDeletePermissionTypeId;

    @Column(name = "permission_resource_module_operater_id")
    private String permissionResourceModuleOperaterId;

    @Column(name = "permission_resource_module_authorize_user_id")
    private String permissionResourceModuleAuthorizeUserId;

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

    public PermissionResourceModule() { }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDts = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        this.setCreatedDts(new Timestamp(System.currentTimeMillis()));
    }

    public Long getPermissionResourceModuleId() {
        return permissionResourceModuleId;
    }
    public void setPermissionResourceModuleId(Long permissionResourceModuleId) {
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

    public String getPermissionResourceModuleResourceId() {
        return permissionResourceModuleResourceId;
    }
    public void setPermissionResourceModuleResourceId(String permissionResourceModuleResourceId) {
        this.permissionResourceModuleResourceId = permissionResourceModuleResourceId;
    }

    public String getPermissionResourceModuleResourceUuid() {
        return permissionResourceModuleResourceUuid;
    }
    public void setPermissionResourceModuleResourceUuid(String permissionResourceModuleResourceUuid) {
        this.permissionResourceModuleResourceUuid = permissionResourceModuleResourceUuid;
    }

    public String getPermissionResourceModuleAvailableIndicator() {
        return permissionResourceModuleAvailableIndicator;
    }
    public void setPermissionResourceModuleAvailableIndicator(String permissionResourceModuleAvailableIndicator) {
        this.permissionResourceModuleAvailableIndicator = permissionResourceModuleAvailableIndicator;
    }

    public String getPermissionResourceModuleCreate() {
        return permissionResourceModuleCreate;
    }
    public void setPermissionResourceModuleCreate(String permissionResourceModuleCreate) {
        this.permissionResourceModuleCreate = permissionResourceModuleCreate;
    }
    public String getPermissionResourceModuleCreatePermissionTypeId() {
        return permissionResourceModuleCreatePermissionTypeId;
    }

    public void setPermissionResourceModuleCreatePermissionTypeId(String permissionResourceModuleCreatePermissionTypeId) {
        this.permissionResourceModuleCreatePermissionTypeId = permissionResourceModuleCreatePermissionTypeId;
    }
    public String getPermissionResourceModuleDelete() {
        return permissionResourceModuleDelete;
    }

    public void setPermissionResourceModuleDelete(String permissionResourceModuleDelete) {
        this.permissionResourceModuleDelete = permissionResourceModuleDelete;
    }
    public String getPermissionResourceModuleDeletePermissionTypeId() {
        return permissionResourceModuleDeletePermissionTypeId;
    }

    public void setPermissionResourceModuleDeletePermissionTypeId(String permissionResourceModuleDeletePermissionTypeId) {
        this.permissionResourceModuleDeletePermissionTypeId = permissionResourceModuleDeletePermissionTypeId;
    }
    public String getPermissionResourceModuleUpdate() {
        return permissionResourceModuleUpdate;
    }
    public void setPermissionResourceModuleUpdate(String permissionResourceModuleUpdate) {
        this.permissionResourceModuleUpdate = permissionResourceModuleUpdate;
    }

    public String getPermissionResourceModuleUpdatePermissionTypeId() {
        return permissionResourceModuleUpdatePermissionTypeId;
    }
    public void setPermissionResourceModuleUpdatePermissionTypeId(String permissionResourceModuleUpdatePermissionTypeId) {
        this.permissionResourceModuleUpdatePermissionTypeId = permissionResourceModuleUpdatePermissionTypeId;
    }

    public String getPermissionResourceModuleRead() {
        return permissionResourceModuleRead;
    }
    public void setPermissionResourceModuleRead(String permissionResourceModuleRead) {
        this.permissionResourceModuleRead = permissionResourceModuleRead;
    }

    public String getPermissionResourceModuleReadPermissionTypeId() {
        return permissionResourceModuleReadPermissionTypeId;
    }
    public void setPermissionResourceModuleReadPermissionTypeId(String permissionResourceModuleReadPermissionTypeId) {
        this.permissionResourceModuleReadPermissionTypeId = permissionResourceModuleReadPermissionTypeId;
    }

    public String getPermissionResourceModuleSoftDelete() {
        return permissionResourceModuleSoftDelete;
    }
    public void setPermissionResourceModuleSoftDelete(String permissionResourceModuleSoftDelete) {
        this.permissionResourceModuleSoftDelete = permissionResourceModuleSoftDelete;
    }

    public String getPermissionResourceModuleSoftDeletePermissionTypeId() {
        return permissionResourceModuleSoftDeletePermissionTypeId;
    }
    public void setPermissionResourceModuleSoftDeletePermissionTypeId(String permissionResourceModuleSoftDeletePermissionTypeId) {
        this.permissionResourceModuleSoftDeletePermissionTypeId = permissionResourceModuleSoftDeletePermissionTypeId;
    }

    public String getPermissionResourceModuleOperaterId() {
        return permissionResourceModuleOperaterId;
    }
    public void setPermissionResourceModuleOperaterId(String permissionResourceModuleOperaterId) {
        this.permissionResourceModuleOperaterId = permissionResourceModuleOperaterId;
    }

    public String getPermissionResourceModuleAuthorizeUserId() {
        return permissionResourceModuleAuthorizeUserId;
    }
    public void setPermissionResourceModuleAuthorizeUserId(String permissionResourceModuleAuthorizeUserId) {
        this.permissionResourceModuleAuthorizeUserId = permissionResourceModuleAuthorizeUserId;
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
