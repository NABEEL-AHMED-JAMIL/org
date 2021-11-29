package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntEnvTypeSearch {

    private String intEnvTypeId;
    private String intEnvTypeUuid;
    private String intEnvTypeName;
    private String intEnvTypeDescription;
    private String intEnvTypeShortDescription;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntEnvTypeSearch() {
    }

    public String getIntEnvTypeId() {
        return intEnvTypeId;
    }
    public void setIntEnvTypeId(String intEnvTypeId) {
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
