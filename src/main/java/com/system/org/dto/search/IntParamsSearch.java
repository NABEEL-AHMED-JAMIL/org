package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntParamsSearch {

    private String intParamsId;
    private String intParamsUuid;
    private String intParamsName;
    private String intParamsValue;
    private String intParamsTypeId;
    private String intParamsTypeuuId;
    private String intParamsLabel;
    private String intParamsParamTypeId;
    private String intParamsParamTypeuuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntParamsSearch() {
    }

    public String getIntParamsId() {
        return intParamsId;
    }
    public void setIntParamsId(String intParamsId) {
        this.intParamsId = intParamsId;
    }

    public String getIntParamsUuid() {
        return intParamsUuid;
    }
    public void setIntParamsUuid(String intParamsUuid) {
        this.intParamsUuid = intParamsUuid;
    }

    public String getIntParamsName() {
        return intParamsName;
    }
    public void setIntParamsName(String intParamsName) {
        this.intParamsName = intParamsName;
    }

    public String getIntParamsValue() {
        return intParamsValue;
    }
    public void setIntParamsValue(String intParamsValue) {
        this.intParamsValue = intParamsValue;
    }

    public String getIntParamsTypeId() {
        return intParamsTypeId;
    }
    public void setIntParamsTypeId(String intParamsTypeId) {
        this.intParamsTypeId = intParamsTypeId;
    }

    public String getIntParamsTypeuuId() {
        return intParamsTypeuuId;
    }
    public void setIntParamsTypeuuId(String intParamsTypeuuId) {
        this.intParamsTypeuuId = intParamsTypeuuId;
    }

    public String getIntParamsLabel() {
        return intParamsLabel;
    }
    public void setIntParamsLabel(String intParamsLabel) {
        this.intParamsLabel = intParamsLabel;
    }

    public String getIntParamsParamTypeId() {
        return intParamsParamTypeId;
    }
    public void setIntParamsParamTypeId(String intParamsParamTypeId) {
        this.intParamsParamTypeId = intParamsParamTypeId;
    }

    public String getIntParamsParamTypeuuid() {
        return intParamsParamTypeuuid;
    }
    public void setIntParamsParamTypeuuid(String intParamsParamTypeuuid) {
        this.intParamsParamTypeuuid = intParamsParamTypeuuid;
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
