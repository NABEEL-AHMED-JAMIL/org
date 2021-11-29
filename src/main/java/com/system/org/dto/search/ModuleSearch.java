package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModuleSearch {

    private String modulesLookupId;
    private String modulesLookupUuid;
    private String modulesLookupNumber;
    private String modulesLookupName;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public ModuleSearch() {
    }

    public String getModulesLookupId() {
        return modulesLookupId;
    }
    public void setModulesLookupId(String modulesLookupId) {
        this.modulesLookupId = modulesLookupId;
    }

    public String getModulesLookupUuid() {
        return modulesLookupUuid;
    }
    public void setModulesLookupUuid(String modulesLookupUuid) {
        this.modulesLookupUuid = modulesLookupUuid;
    }

    public String getModulesLookupNumber() {
        return modulesLookupNumber;
    }
    public void setModulesLookupNumber(String modulesLookupNumber) {
        this.modulesLookupNumber = modulesLookupNumber;
    }

    public String getModulesLookupName() {
        return modulesLookupName;
    }
    public void setModulesLookupName(String modulesLookupName) {
        this.modulesLookupName = modulesLookupName;
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
