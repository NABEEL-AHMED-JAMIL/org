package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import javax.persistence.*;

@Entity
@Table(name = "int_app")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntApp extends BaseEntity {

    @Id
    @Column(name = "int_app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intAppId;

    @Column(name = "int_app_uuid")
    private String intAppUuId;

    @Column(name = "int_app_name")
    private String intAppName;

    @Column(name = "int_app_desc")
    private String intAppDesc;

    @Column(name = "int_app_orgid")
    private String intAppOrgId;

    @Column(name = "int_app_orguuid")
    private String intAppOrgUUId;

    @Column(name = "int_app_shortdesc")
    private String intAppShortDesc;

    public IntApp() {}

    public Long getIntAppId() {
        return intAppId;
    }
    public void setIntAppId(Long intAppId) {
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
