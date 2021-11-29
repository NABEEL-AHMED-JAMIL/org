package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntAppDto {

    private Long intAppId;
    private String intAppUuId;
    private String intAppName;
    private String intAppDesc;
    private String intAppOrgId;
    private String intAppOrgUUId;
    private String intAppShortDesc;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntAppDto() {}

    public Long getIntAppId() {
        return intAppId;
    }
    public void setIntAppId(Long intAppId) {
        this.intAppId = intAppId;
    }

    public String getIntAppUuId() {
        return intAppUuId;
    }
    public void setIntAppUuId(String intAppUuId) {
        this.intAppUuId = intAppUuId;
    }

    public String getIntAppName() {
        return intAppName;
    }
    public void setIntAppName(String intAppName) {
        this.intAppName = intAppName;
    }

    public String getIntAppDesc() {
        return intAppDesc;
    }
    public void setIntAppDesc(String intAppDesc) {
        this.intAppDesc = intAppDesc;
    }

    public String getIntAppOrgId() {
        return intAppOrgId;
    }
    public void setIntAppOrgId(String intAppOrgId) {
        this.intAppOrgId = intAppOrgId;
    }

    public String getIntAppOrgUUId() {
        return intAppOrgUUId;
    }
    public void setIntAppOrgUUId(String intAppOrgUUId) {
        this.intAppOrgUUId = intAppOrgUUId;
    }

    public String getIntAppShortDesc() {
        return intAppShortDesc;
    }
    public void setIntAppShortDesc(String intAppShortDesc) {
        this.intAppShortDesc = intAppShortDesc;
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
