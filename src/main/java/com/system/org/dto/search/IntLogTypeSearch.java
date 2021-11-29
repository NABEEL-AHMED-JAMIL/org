package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntLogTypeSearch {

    private String intLogTypeId;
    private String intLogTypeUuid;
    private String intLogTypeDescription;
    private String intLogTypeName;
    private String intLogTypeShortDescription;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntLogTypeSearch() { }

    public String getIntLogTypeId() {
        return intLogTypeId;
    }
    public void setIntLogTypeId(String intLogTypeId) {
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
