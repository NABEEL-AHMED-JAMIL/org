package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdSearch {

    private String intCmdId;
    private String intCmdUuid;
    private String intCmdIntTypeId;
    private String intCmdIntTypeUuid;
    private String intCmdCmd;
    private String intCmdCmdUserfriendlyname;
    private String intCmdBlog;
    private String intCmdZebraId;
    private String intCmdZebraUuid;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;

    public IntCmdSearch() {
    }

    public String getIntCmdId() {
        return intCmdId;
    }
    public void setIntCmdId(String intCmdId) {
        this.intCmdId = intCmdId;
    }

    public String getIntCmdUuid() {
        return intCmdUuid;
    }
    public void setIntCmdUuid(String intCmdUuid) {
        this.intCmdUuid = intCmdUuid;
    }

    public String getIntCmdIntTypeId() {
        return intCmdIntTypeId;
    }
    public void setIntCmdIntTypeId(String intCmdIntTypeId) {
        this.intCmdIntTypeId = intCmdIntTypeId;
    }

    public String getIntCmdIntTypeUuid() {
        return intCmdIntTypeUuid;
    }
    public void setIntCmdIntTypeUuid(String intCmdIntTypeUuid) {
        this.intCmdIntTypeUuid = intCmdIntTypeUuid;
    }

    public String getIntCmdCmd() {
        return intCmdCmd;
    }
    public void setIntCmdCmd(String intCmdCmd) {
        this.intCmdCmd = intCmdCmd;
    }

    public String getIntCmdCmdUserfriendlyname() {
        return intCmdCmdUserfriendlyname;
    }
    public void setIntCmdCmdUserfriendlyname(String intCmdCmdUserfriendlyname) {
        this.intCmdCmdUserfriendlyname = intCmdCmdUserfriendlyname;
    }

    public String getIntCmdBlog() {
        return intCmdBlog;
    }
    public void setIntCmdBlog(String intCmdBlog) {
        this.intCmdBlog = intCmdBlog;
    }

    public String getIntCmdZebraId() {
        return intCmdZebraId;
    }
    public void setIntCmdZebraId(String intCmdZebraId) {
        this.intCmdZebraId = intCmdZebraId;
    }

    public String getIntCmdZebraUuid() {
        return intCmdZebraUuid;
    }
    public void setIntCmdZebraUuid(String intCmdZebraUuid) {
        this.intCmdZebraUuid = intCmdZebraUuid;
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
