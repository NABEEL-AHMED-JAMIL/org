package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntLogLevelTypeDto {

    private Long intLogLevelTypeId;
    private String intLogLevelTypeUuid;
    private String intLogLevelTypeDescription;
    private String intLogLevelTypeName;
    private String intLogLevelTypeShortDescription;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntLogLevelTypeDto() {
    }

    public Long getIntLogLevelTypeId() {
        return intLogLevelTypeId;
    }
    public void setIntLogLevelTypeId(Long intLogLevelTypeId) {
        this.intLogLevelTypeId = intLogLevelTypeId;
    }

    public String getIntLogLevelTypeUuid() {
        return intLogLevelTypeUuid;
    }
    public void setIntLogLevelTypeUuid(String intLogLevelTypeUuid) {
        this.intLogLevelTypeUuid = intLogLevelTypeUuid;
    }

    public String getIntLogLevelTypeDescription() {
        return intLogLevelTypeDescription;
    }
    public void setIntLogLevelTypeDescription(String intLogLevelTypeDescription) {
        this.intLogLevelTypeDescription = intLogLevelTypeDescription;
    }

    public String getIntLogLevelTypeName() {
        return intLogLevelTypeName;
    }
    public void setIntLogLevelTypeName(String intLogLevelTypeName) {
        this.intLogLevelTypeName = intLogLevelTypeName;
    }

    public String getIntLogLevelTypeShortDescription() {
        return intLogLevelTypeShortDescription;
    }
    public void setIntLogLevelTypeShortDescription(String intLogLevelTypeShortDescription) {
        this.intLogLevelTypeShortDescription = intLogLevelTypeShortDescription;
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
