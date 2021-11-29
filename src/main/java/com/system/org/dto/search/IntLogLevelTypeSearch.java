package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntLogLevelTypeSearch {

    private String intLogLevelTypeId;
    private String intLogLevelTypeUuid;
    private String intLogLevelTypeDescription;
    private String intLogLevelTypeName;
    private String intLogLevelTypeShortDescription;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntLogLevelTypeSearch() { }

    public String getIntLogLevelTypeId() {
        return intLogLevelTypeId;
    }
    public void setIntLogLevelTypeId(String intLogLevelTypeId) {
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
