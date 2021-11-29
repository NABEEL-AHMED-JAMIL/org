package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntLogTypeDto {

    private Long intLogTypeId;
    private String intLogTypeUuid;
    private String intLogTypeDescription;
    private String intLogTypeName;
    private String intLogTypeShortDescription;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntLogTypeDto() { }

    public Long getIntLogTypeId() {
        return intLogTypeId;
    }
    public void setIntLogTypeId(Long intLogTypeId) {
        this.intLogTypeId = intLogTypeId;
    }

    public String getIntLogTypeUuid() {
        return intLogTypeUuid;
    }
    public void setIntLogTypeUuid(String intLogTypeUuid) {
        this.intLogTypeUuid = intLogTypeUuid;
    }

    public String getIntLogTypeDescription() {
        return intLogTypeDescription;
    }
    public void setIntLogTypeDescription(String intLogTypeDescription) {
        this.intLogTypeDescription = intLogTypeDescription;
    }

    public String getIntLogTypeName() {
        return intLogTypeName;
    }
    public void setIntLogTypeName(String intLogTypeName) {
        this.intLogTypeName = intLogTypeName;
    }

    public String getIntLogTypeShortDescription() {
        return intLogTypeShortDescription;
    }
    public void setIntLogTypeShortDescription(String intLogTypeShortDescription) {
        this.intLogTypeShortDescription = intLogTypeShortDescription;
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
