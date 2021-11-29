package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdParamSearch {

    private String intCmdParamId;
    private String intCmdParamUuid;
    private String intCmdParamIntCmdUuid;
    private String intCmdParamIntCmdId;
    private String intCmdParamName;
    private String intCmdParamDefaultvalue;
    private String intCmdParamDescription;
    private String intCmdParamShortdescription;
    private String intCmdParamPosition;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntCmdParamSearch() {
    }

    public String getIntCmdParamId() {
        return intCmdParamId;
    }
    public void setIntCmdParamId(String intCmdParamId) {
        this.intCmdParamId = intCmdParamId;
    }

    public String getIntCmdParamUuid() {
        return intCmdParamUuid;
    }
    public void setIntCmdParamUuid(String intCmdParamUuid) {
        this.intCmdParamUuid = intCmdParamUuid;
    }

    public String getIntCmdParamIntCmdUuid() {
        return intCmdParamIntCmdUuid;
    }
    public void setIntCmdParamIntCmdUuid(String intCmdParamIntCmdUuid) {
        this.intCmdParamIntCmdUuid = intCmdParamIntCmdUuid;
    }

    public String getIntCmdParamIntCmdId() {
        return intCmdParamIntCmdId;
    }
    public void setIntCmdParamIntCmdId(String intCmdParamIntCmdId) {
        this.intCmdParamIntCmdId = intCmdParamIntCmdId;
    }

    public String getIntCmdParamName() {
        return intCmdParamName;
    }
    public void setIntCmdParamName(String intCmdParamName) {
        this.intCmdParamName = intCmdParamName;
    }

    public String getIntCmdParamDefaultvalue() {
        return intCmdParamDefaultvalue;
    }
    public void setIntCmdParamDefaultvalue(String intCmdParamDefaultvalue) {
        this.intCmdParamDefaultvalue = intCmdParamDefaultvalue;
    }

    public String getIntCmdParamDescription() {
        return intCmdParamDescription;
    }
    public void setIntCmdParamDescription(String intCmdParamDescription) {
        this.intCmdParamDescription = intCmdParamDescription;
    }

    public String getIntCmdParamShortdescription() {
        return intCmdParamShortdescription;
    }
    public void setIntCmdParamShortdescription(String intCmdParamShortdescription) {
        this.intCmdParamShortdescription = intCmdParamShortdescription;
    }

    public String getIntCmdParamPosition() {
        return intCmdParamPosition;
    }
    public void setIntCmdParamPosition(String intCmdParamPosition) {
        this.intCmdParamPosition = intCmdParamPosition;
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
