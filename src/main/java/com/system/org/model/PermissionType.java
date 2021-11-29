package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "permission_type")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionType {

    @Id
    @Column(name = "permission_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionTypeId;

    @Column(name = "permission_type_uuid", nullable = false)
    private String permissionTypeUuid;

    @Column(name = "permission_type_name")
    private String permissionTypeName;

    @Column(name = "permission_type_short_description")
    private String permissionTypeShortDescription;

    @Column(name = "permission_type_description")
    private String permissionTypeDescription;

    @Column(name = "created_dts", columnDefinition =
            "timestamp default CURRENT_TIMESTAMP", nullable = false)
    private Timestamp createdDts;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "active_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    @Column(name = "updated_dts")
    private Timestamp updatedDts;

    @Column(name = "udated_by")
    private String updatedBy;

    public PermissionType() {
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDts = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        this.setCreatedDts(new Timestamp(System.currentTimeMillis()));
    }

    public Long getPermissionTypeId() {
        return permissionTypeId;
    }
    public void setPermissionTypeId(Long permissionTypeId) {
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

    public Timestamp getCreatedDts() {
        return createdDts;
    }
    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
