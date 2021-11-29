package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "resource")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resource extends BaseEntity {

    @Id
    @Column(name = "resource_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    @Column(name = "resource_uuid", nullable = false)
    private String resourceUuid;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "resource_desc")
    private String resourceDesc;

    @Column(name = "resource_type_desc")
    private String resourceTypeDesc;

    @Column(name = "resource_version_number")
    private String resourceVersionNumber;

    @Column(name = "resource_available_indicator")
    private String resourceAvailableIndicator;

    @Column(name = "resource_parent_id")
    private String resourceParentId;

    @Column(name = "resource_auth_user_id")
    private String resourceAuthUserId;

    @Column(name = "resource_resource_type_uuid")
    private String resourceResourceTypeUuid;


    public Resource() { }

    public Long getResourceId() {
        return resourceId;
    }
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceUuid() {
        return resourceUuid;
    }
    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }

    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceTypeDesc() {
        return resourceTypeDesc;
    }
    public void setResourceTypeDesc(String resourceTypeDesc) {
        this.resourceTypeDesc = resourceTypeDesc;
    }

    public String getResourceVersionNumber() {
        return resourceVersionNumber;
    }
    public void setResourceVersionNumber(String resourceVersionNumber) {
        this.resourceVersionNumber = resourceVersionNumber;
    }

    public String getResourceAvailableIndicator() {
        return resourceAvailableIndicator;
    }
    public void setResourceAvailableIndicator(String resourceAvailableIndicator) {
        this.resourceAvailableIndicator = resourceAvailableIndicator;
    }

    public String getResourceParentId() {
        return resourceParentId;
    }
    public void setResourceParentId(String resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    public String getResourceAuthUserId() {
        return resourceAuthUserId;
    }
    public void setResourceAuthUserId(String resourceAuthUserId) {
        this.resourceAuthUserId = resourceAuthUserId;
    }

    public String getResourceResourceTypeUuid() {
        return resourceResourceTypeUuid;
    }
    public void setResourceResourceTypeUuid(String resourceResourceTypeUuid) {
        this.resourceResourceTypeUuid = resourceResourceTypeUuid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
