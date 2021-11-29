package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntAppSearch {

    private String intAppId;
    private String intAppUuId;
    private String intAppName;
    private String intAppDesc;
    private String intAppOrgId;
    private String intAppOrgUUId;
    private String intAppShortDesc;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntAppSearch() { }

    public String getIntAppId() {
        return intAppId;
    }
    public void setIntAppId(String intAppId) {
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

    public String getFromDate() {
        return fromDate;
    }
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getUpdateFromDate() {
        return updateFromDate;
    }
    public void setUpdateFromDate(String updateFromDate) {
        this.updateFromDate = updateFromDate;
    }

    public String getUpdateToDate() {
        return updateToDate;
    }
    public void setUpdateToDate(String updateToDate) {
        this.updateToDate = updateToDate;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
