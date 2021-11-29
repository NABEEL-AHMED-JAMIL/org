package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "resource_module")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceModule extends BaseEntity {

    @Id
    @Column(name = "resource_module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceModuleId;

    @Column(name = "resource_module_uuid", nullable = false)
    private String resourceModuleUuid;

    @Column(name = "resource_id")
    private String resourceId;

    @Column(name = "resource_uuid", nullable = false)
    private String resourceUuid;

    @Column(name = "module_id")
    private String moduleId;

    @Column(name = "module_uuid", nullable = false)
    private String moduleUuid;

    public ResourceModule() {
    }

    public Long getResourceModuleId() {
        return resourceModuleId;
    }
    public void setResourceModuleId(Long resourceModuleId) {
        this.resourceModuleId = resourceModuleId;
    }

    public String getResourceModuleUuid() {
        return resourceModuleUuid;
    }
    public void setResourceModuleUuid(String resourceModuleUuid) {
        this.resourceModuleUuid = resourceModuleUuid;
    }

    public String getResourceId() {
        return resourceId;
    }
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceUuid() {
        return resourceUuid;
    }
    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }

    public String getModuleId() {
        return moduleId;
    }
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleUuid() {
        return moduleUuid;
    }
    public void setModuleUuid(String moduleUuid) {
        this.moduleUuid = moduleUuid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
