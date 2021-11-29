package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdImpSearch {

    private String intCmdImpId;
    private String intCmdImpUuid;
    private String intCmdImpIntCmdId;
    private String intCmdImpIntCmdUuid;
    private String intCmdImpIntCmdParamId;
    private String intCmdImpIntCmdParamUuid;
    private String intCmdImpIntCmdParamValue;
    private String intCmdImpUserUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntCmdImpSearch() {
    }

    public String getIntCmdImpId() {
        return intCmdImpId;
    }
    public void setIntCmdImpId(String intCmdImpId) {
        this.intCmdImpId = intCmdImpId;
    }

    public String getIntCmdImpUuid() {
        return intCmdImpUuid;
    }
    public void setIntCmdImpUuid(String intCmdImpUuid) {
        this.intCmdImpUuid = intCmdImpUuid;
    }

    public String getIntCmdImpIntCmdId() {
        return intCmdImpIntCmdId;
    }
    public void setIntCmdImpIntCmdId(String intCmdImpIntCmdId) {
        this.intCmdImpIntCmdId = intCmdImpIntCmdId;
    }

    public String getIntCmdImpIntCmdUuid() {
        return intCmdImpIntCmdUuid;
    }
    public void setIntCmdImpIntCmdUuid(String intCmdImpIntCmdUuid) {
        this.intCmdImpIntCmdUuid = intCmdImpIntCmdUuid;
    }

    public String getIntCmdImpIntCmdParamId() {
        return intCmdImpIntCmdParamId;
    }
    public void setIntCmdImpIntCmdParamId(String intCmdImpIntCmdParamId) {
        this.intCmdImpIntCmdParamId = intCmdImpIntCmdParamId;
    }

    public String getIntCmdImpIntCmdParamUuid() {
        return intCmdImpIntCmdParamUuid;
    }
    public void setIntCmdImpIntCmdParamUuid(String intCmdImpIntCmdParamUuid) {
        this.intCmdImpIntCmdParamUuid = intCmdImpIntCmdParamUuid;
    }

    public String getIntCmdImpIntCmdParamValue() {
        return intCmdImpIntCmdParamValue;
    }
    public void setIntCmdImpIntCmdParamValue(String intCmdImpIntCmdParamValue) {
        this.intCmdImpIntCmdParamValue = intCmdImpIntCmdParamValue;
    }

    public String getIntCmdImpUserUuid() {
        return intCmdImpUserUuid;
    }
    public void setIntCmdImpUserUuid(String intCmdImpUserUuid) {
        this.intCmdImpUserUuid = intCmdImpUserUuid;
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

