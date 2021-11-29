package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "resource_type")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceType {

    @Id
    @Column(name = "resource_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceTypeId;

    @Column(name = "resource_type_uuid", nullable = false)
    private String resourceTypeUuid;

    @Column(name = "resource_type_name")
    private String resourceTypeName;

    @Column(name = "resource_type_desc")
    private String resourceTypeDesc;

    @Column(name = "active_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    @Column(name = "created_dts")
    private Timestamp createdDts;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_dts")
    private Timestamp updatedDts;

    @Column(name = "updated_by")
    private String updatedBy;

    public ResourceType() { }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDts = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        this.setCreatedDts(new Timestamp(System.currentTimeMillis()));
    }

    public Long getResourceTypeId() {
        return resourceTypeId;
    }
    public void setResourceTypeId(Long resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public String getResourceTypeUuid() {
        return resourceTypeUuid;
    }
    public void setResourceTypeUuid(String resourceTypeUuid) {
        this.resourceTypeUuid = resourceTypeUuid;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }
    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public String getResourceTypeDesc() {
        return resourceTypeDesc;
    }
    public void setResourceTypeDesc(String resourceTypeDesc) {
        this.resourceTypeDesc = resourceTypeDesc;
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

    
    public String toString() {
        return new Gson().toJson(this);
    }
}
