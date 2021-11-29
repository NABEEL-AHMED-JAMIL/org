package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntEnvTypeDto {

    private Long intEnvTypeId;
    private String intEnvTypeUuid;
    private String intEnvTypeName;
    private String intEnvTypeDescription;
    private String intEnvTypeShortDescription;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntEnvTypeDto() {
    }

    public Long getIntEnvTypeId() {
        return intEnvTypeId;
    }
    public void setIntEnvTypeId(Long intEnvTypeId) {
        this.intEnvTypeId = intEnvTypeId;
    }

    public String getIntEnvTypeUuid() {
        return intEnvTypeUuid;
    }
    public void setIntEnvTypeUuid(String intEnvTypeUuid) {
        this.intEnvTypeUuid = intEnvTypeUuid;
    }

    public String getIntEnvTypeName() {
        return intEnvTypeName;
    }
    public void setIntEnvTypeName(String intEnvTypeName) {
        this.intEnvTypeName = intEnvTypeName;
    }

    public String getIntEnvTypeDescription() {
        return intEnvTypeDescription;
    }
    public void setIntEnvTypeDescription(String intEnvTypeDescription) {
        this.intEnvTypeDescription = intEnvTypeDescription;
    }

    public String getIntEnvTypeShortDescription() {
        return intEnvTypeShortDescription;
    }
    public void setIntEnvTypeShortDescription(String intEnvTypeShortDescription) {
        this.intEnvTypeShortDescription = intEnvTypeShortDescription;
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
