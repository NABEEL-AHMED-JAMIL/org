package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntTypeSearch {

    private String intTypeId;
    private String intTypeUuid;
    private String intTypeName;
    private String intTypeShortDescription;
    private String intTypeDescription;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntTypeSearch() {
    }

    public String getIntTypeId() {
        return intTypeId;
    }
    public void setIntTypeId(String intTypeId) {
        this.intTypeId = intTypeId;
    }

    public String getIntTypeUuid() {
        return intTypeUuid;
    }
    public void setIntTypeUuid(String intTypeUuid) {
        this.intTypeUuid = intTypeUuid;
    }

    public String getIntTypeName() {
        return intTypeName;
    }
    public void setIntTypeName(String intTypeName) {
        this.intTypeName = intTypeName;
    }

    public String getIntTypeShortDescription() {
        return intTypeShortDescription;
    }
    public void setIntTypeShortDescription(String intTypeShortDescription) {
        this.intTypeShortDescription = intTypeShortDescription;
    }

    public String getIntTypeDescription() {
        return intTypeDescription;
    }
    public void setIntTypeDescription(String intTypeDescription) {
        this.intTypeDescription = intTypeDescription;
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
