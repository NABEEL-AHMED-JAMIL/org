package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_trans")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntTrans extends BaseEntity {

    @Id
    @Column(name = "int_trans_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intTransId;

    @Column(name = "int_trans_uuid")
    private String intTransUuid;

    @Column(name = "int_detail_log_sys_id")
    private String intDetailLogSysId;

    @Column(name = "int_detail_log_sys_name")
    private String intDetailLogSysName;

    @Column(name = "int_detail_log_sys_uuid")
    private String intDetailLogSysUuid;

    @Column(name = "int_trans_app_id")
    private String intTransAppId;

    @Column(name = "int_trans_app_name")
    private String intTransAppName;

    @Column(name = "int_trans_app_uuid")
    private String intTransAppUuid;

    @Column(name = "int_trans_bus_name1")
    private String intTransBusName1;

    @Column(name = "int_trans_bus_name2")
    private String intTransBusName2;

    @Column(name = "int_trans_bus_name3")
    private String intTransBusName3;

    @Column(name = "int_trans_bus_name4")
    private String intTransBusName4;

    @Column(name = "int_trans_bus_name5")
    private String intTransBusName5;

    @Column(name = "int_trans_bus_val1")
    private String intTransBusVal1;

    @Column(name = "int_trans_bus_val2")
    private String intTransBusVal2;

    @Column(name = "int_trans_bus_val3")
    private String intTransBusVal3;

    @Column(name = "int_trans_bus_val4")
    private String intTransBusVal4;

    @Column(name = "int_trans_bus_val5")
    private String intTransBusVal5;

    @Column(name = "int_trans_desc")
    private String intTransDesc;

    @Column(name = "int_trans_env_id")
    private String intTransEnvId;

    @Column(name = "int_trans_env_name")
    private String intTransEnvName;

    @Column(name = "int_trans_env_uuid")
    private String intTransEnvUuid;

    @Column(name = "int_trans_log_level_id")
    private String intTransLogLevelId;

    @Column(name = "int_trans_log_level_name")
    private String intTransLogLevelName;

    @Column(name = "int_trans_log_level_uuid")
    private String intTransLogLevelUuid;

    @Column(name = "int_trans_log_type_id")
    private String intTransLogTypeId;

    @Column(name = "int_trans_log_type_name")
    private String intTransLogTypeName;

    @Column(name = "int_trans_log_type_uuid")
    private String intTransLogTypeUuid;

    @Column(name = "int_trans_name")
    private String intTransName;

    @Column(name = "int_trans_org_dep_id")
    private String intTransOrgDepId;

    @Column(name = "int_trans_org_dep_name")
    private String intTransOrgDepName;

    @Column(name = "int_trans_org_dep_uuid")
    private String intTransOrgDepUuid;

    @Column(name = "int_trans_org_id")
    private String intTransOrgId;

    @Column(name = "int_trans_org_name")
    private String intTransOrgName;

    @Column(name = "int_trans_org_uuid")
    private String intTransOrgUuid;

    @Column(name = "int_trans_payload")
    private String intTransPayload;

    @Lob
    @Column(name = "int_trans_playload_blob")
    private String intTransPlayloadBlob;

    @Column(name = "int_trans_shortdesc")
    private String intTransShortDesc;

    @Column(name = "int_trans_src_system_transid")
    private String intTransSrcSystemTransId;

    @Column(name = "int_trans_src_system_transuuid")
    private String intTransSrcSystemTransuuid;

    @Column(name = "int_trans_src_system_uuid")
    private String intTransSrcSystemUuid;

    @Column(name = "int_trans_src_systemid")
    private String intTransSrcSystemId;

    @Column(name = "int_trans_tech_name1")
    private String intTransTechName1;

    @Column(name = "int_trans_tech_name2")
    private String intTransTechName2;

    @Column(name = "int_trans_tech_name3")
    private String intTransTechName3;

    @Column(name = "int_trans_tech_name4")
    private String intTransTechName4;

    @Column(name = "int_trans_tech_name5")
    private String intTransTechName5;

    @Column(name = "int_trans_tech_val1")
    private String intTransTechVal1;

    @Column(name = "int_trans_tech_val2")
    private String intTransTechVal2;

    @Column(name = "int_trans_tech_val3")
    private String intTransTechVal3;

    @Column(name = "int_trans_tech_val4")
    private String intTransTechVal4;

    @Column(name = "int_trans_tech_val5")
    private String intTransTechVal5;

    @Column(name = "int_trans_transchildid")
    private String intTransTransChildId;

    @Column(name = "int_trans_transchilduuid")
    private String intTransTransChildUuid;

    @Column(name = "int_trans_transparentid")
    private String intTransTransParentId;

    @Column(name = "int_trans_transparentuuid")
    private String intTransTransParentUuid;

    @Column(name = "int_trans_trg_system_uuid")
    private String intTransTrgSystemUuid;

    @Column(name = "int_trans_trg_systemid")
    private String intTransTrgSystemId;

    public IntTrans() { }

    public Long getIntTransId() {
        return intTransId;
    }
    public void setIntTransId(Long intTransId) {
        this.intTransId = intTransId;
    }

    public String getIntTransUuid() {
        return intTransUuid;
    }
    public void setIntTransUuid(String intTransUuid) {
        this.intTransUuid = intTransUuid;
    }

    public String getIntDetailLogSysId() {
        return intDetailLogSysId;
    }
    public void setIntDetailLogSysId(String intDetailLogSysId) {
        this.intDetailLogSysId = intDetailLogSysId;
    }

    public String getIntDetailLogSysName() {
        return intDetailLogSysName;
    }
    public void setIntDetailLogSysName(String intDetailLogSysName) {
        this.intDetailLogSysName = intDetailLogSysName;
    }

    public String getIntDetailLogSysUuid() {
        return intDetailLogSysUuid;
    }
    public void setIntDetailLogSysUuid(String intDetailLogSysUuid) {
        this.intDetailLogSysUuid = intDetailLogSysUuid;
    }

    public String getIntTransAppId() {
        return intTransAppId;
    }
    public void setIntTransAppId(String intTransAppId) {
        this.intTransAppId = intTransAppId;
    }

    public String getIntTransAppName() {
        return intTransAppName;
    }
    public void setIntTransAppName(String intTransAppName) {
        this.intTransAppName = intTransAppName;
    }

    public String getIntTransAppUuid() {
        return intTransAppUuid;
    }
    public void setIntTransAppUuid(String intTransAppUuid) {
        this.intTransAppUuid = intTransAppUuid;
    }

    public String getIntTransBusName1() {
        return intTransBusName1;
    }
    public void setIntTransBusName1(String intTransBusName1) {
        this.intTransBusName1 = intTransBusName1;
    }

    public String getIntTransBusName2() {
        return intTransBusName2;
    }
    public void setIntTransBusName2(String intTransBusName2) {
        this.intTransBusName2 = intTransBusName2;
    }

    public String getIntTransBusName3() {
        return intTransBusName3;
    }
    public void setIntTransBusName3(String intTransBusName3) {
        this.intTransBusName3 = intTransBusName3;
    }

    public String getIntTransBusName4() {
        return intTransBusName4;
    }
    public void setIntTransBusName4(String intTransBusName4) {
        this.intTransBusName4 = intTransBusName4;
    }

    public String getIntTransBusName5() {
        return intTransBusName5;
    }
    public void setIntTransBusName5(String intTransBusName5) {
        this.intTransBusName5 = intTransBusName5;
    }

    public String getIntTransBusVal1() {
        return intTransBusVal1;
    }
    public void setIntTransBusVal1(String intTransBusVal1) {
        this.intTransBusVal1 = intTransBusVal1;
    }

    public String getIntTransBusVal2() {
        return intTransBusVal2;
    }
    public void setIntTransBusVal2(String intTransBusVal2) {
        this.intTransBusVal2 = intTransBusVal2;
    }

    public String getIntTransBusVal3() {
        return intTransBusVal3;
    }
    public void setIntTransBusVal3(String intTransBusVal3) {
        this.intTransBusVal3 = intTransBusVal3;
    }

    public String getIntTransBusVal4() {
        return intTransBusVal4;
    }
    public void setIntTransBusVal4(String intTransBusVal4) {
        this.intTransBusVal4 = intTransBusVal4;
    }

    public String getIntTransBusVal5() {
        return intTransBusVal5;
    }
    public void setIntTransBusVal5(String intTransBusVal5) {
        this.intTransBusVal5 = intTransBusVal5;
    }

    public String getIntTransDesc() {
        return intTransDesc;
    }
    public void setIntTransDesc(String intTransDesc) {
        this.intTransDesc = intTransDesc;
    }

    public String getIntTransEnvId() {
        return intTransEnvId;
    }
    public void setIntTransEnvId(String intTransEnvId) {
        this.intTransEnvId = intTransEnvId;
    }

    public String getIntTransEnvName() {
        return intTransEnvName;
    }
    public void setIntTransEnvName(String intTransEnvName) {
        this.intTransEnvName = intTransEnvName;
    }

    public String getIntTransEnvUuid() {
        return intTransEnvUuid;
    }
    public void setIntTransEnvUuid(String intTransEnvUuid) {
        this.intTransEnvUuid = intTransEnvUuid;
    }

    public String getIntTransLogLevelId() {
        return intTransLogLevelId;
    }
    public void setIntTransLogLevelId(String intTransLogLevelId) {
        this.intTransLogLevelId = intTransLogLevelId;
    }

    public String getIntTransLogLevelName() {
        return intTransLogLevelName;
    }
    public void setIntTransLogLevelName(String intTransLogLevelName) {
        this.intTransLogLevelName = intTransLogLevelName;
    }

    public String getIntTransLogLevelUuid() {
        return intTransLogLevelUuid;
    }
    public void setIntTransLogLevelUuid(String intTransLogLevelUuid) {
        this.intTransLogLevelUuid = intTransLogLevelUuid;
    }

    public String getIntTransLogTypeId() {
        return intTransLogTypeId;
    }
    public void setIntTransLogTypeId(String intTransLogTypeId) {
        this.intTransLogTypeId = intTransLogTypeId;
    }

    public String getIntTransLogTypeName() {
        return intTransLogTypeName;
    }
    public void setIntTransLogTypeName(String intTransLogTypeName) {
        this.intTransLogTypeName = intTransLogTypeName;
    }

    public String getIntTransLogTypeUuid() {
        return intTransLogTypeUuid;
    }
    public void setIntTransLogTypeUuid(String intTransLogTypeUuid) {
        this.intTransLogTypeUuid = intTransLogTypeUuid;
    }

    public String getIntTransName() {
        return intTransName;
    }
    public void setIntTransName(String intTransName) {
        this.intTransName = intTransName;
    }

    public String getIntTransOrgDepId() {
        return intTransOrgDepId;
    }
    public void setIntTransOrgDepId(String intTransOrgDepId) {
        this.intTransOrgDepId = intTransOrgDepId;
    }

    public String getIntTransOrgDepName() {
        return intTransOrgDepName;
    }
    public void setIntTransOrgDepName(String intTransOrgDepName) {
        this.intTransOrgDepName = intTransOrgDepName;
    }

    public String getIntTransOrgDepUuid() {
        return intTransOrgDepUuid;
    }
    public void setIntTransOrgDepUuid(String intTransOrgDepUuid) {
        this.intTransOrgDepUuid = intTransOrgDepUuid;
    }

    public String getIntTransOrgId() {
        return intTransOrgId;
    }
    public void setIntTransOrgId(String intTransOrgId) {
        this.intTransOrgId = intTransOrgId;
    }

    public String getIntTransOrgName() {
        return intTransOrgName;
    }
    public void setIntTransOrgName(String intTransOrgName) {
        this.intTransOrgName = intTransOrgName;
    }

    public String getIntTransOrgUuid() {
        return intTransOrgUuid;
    }
    public void setIntTransOrgUuid(String intTransOrgUuid) {
        this.intTransOrgUuid = intTransOrgUuid;
    }

    public String getIntTransPayload() {
        return intTransPayload;
    }
    public void setIntTransPayload(String intTransPayload) {
        this.intTransPayload = intTransPayload;
    }

    public String getIntTransPlayloadBlob() {
        return intTransPlayloadBlob;
    }
    public void setIntTransPlayloadBlob(String intTransPlayloadBlob) {
        this.intTransPlayloadBlob = intTransPlayloadBlob;
    }

    public String getIntTransShortDesc() {
        return intTransShortDesc;
    }
    public void setIntTransShortDesc(String intTransShortDesc) {
        this.intTransShortDesc = intTransShortDesc;
    }

    public String getIntTransSrcSystemTransId() {
        return intTransSrcSystemTransId;
    }
    public void setIntTransSrcSystemTransId(String intTransSrcSystemTransId) {
        this.intTransSrcSystemTransId = intTransSrcSystemTransId;
    }

    public String getIntTransSrcSystemTransuuid() {
        return intTransSrcSystemTransuuid;
    }
    public void setIntTransSrcSystemTransuuid(String intTransSrcSystemTransuuid) {
        this.intTransSrcSystemTransuuid = intTransSrcSystemTransuuid;
    }

    public String getIntTransSrcSystemUuid() {
        return intTransSrcSystemUuid;
    }
    public void setIntTransSrcSystemUuid(String intTransSrcSystemUuid) {
        this.intTransSrcSystemUuid = intTransSrcSystemUuid;
    }

    public String getIntTransSrcSystemId() {
        return intTransSrcSystemId;
    }
    public void setIntTransSrcSystemId(String intTransSrcSystemId) {
        this.intTransSrcSystemId = intTransSrcSystemId;
    }

    public String getIntTransTechName1() {
        return intTransTechName1;
    }
    public void setIntTransTechName1(String intTransTechName1) {
        this.intTransTechName1 = intTransTechName1;
    }

    public String getIntTransTechName2() {
        return intTransTechName2;
    }
    public void setIntTransTechName2(String intTransTechName2) {
        this.intTransTechName2 = intTransTechName2;
    }

    public String getIntTransTechName3() {
        return intTransTechName3;
    }
    public void setIntTransTechName3(String intTransTechName3) {
        this.intTransTechName3 = intTransTechName3;
    }

    public String getIntTransTechName4() {
        return intTransTechName4;
    }
    public void setIntTransTechName4(String intTransTechName4) {
        this.intTransTechName4 = intTransTechName4;
    }

    public String getIntTransTechName5() {
        return intTransTechName5;
    }
    public void setIntTransTechName5(String intTransTechName5) {
        this.intTransTechName5 = intTransTechName5;
    }

    public String getIntTransTechVal1() {
        return intTransTechVal1;
    }
    public void setIntTransTechVal1(String intTransTechVal1) {
        this.intTransTechVal1 = intTransTechVal1;
    }

    public String getIntTransTechVal2() {
        return intTransTechVal2;
    }
    public void setIntTransTechVal2(String intTransTechVal2) {
        this.intTransTechVal2 = intTransTechVal2;
    }

    public String getIntTransTechVal3() {
        return intTransTechVal3;
    }
    public void setIntTransTechVal3(String intTransTechVal3) {
        this.intTransTechVal3 = intTransTechVal3;
    }

    public String getIntTransTechVal4() {
        return intTransTechVal4;
    }
    public void setIntTransTechVal4(String intTransTechVal4) {
        this.intTransTechVal4 = intTransTechVal4;
    }

    public String getIntTransTechVal5() {
        return intTransTechVal5;
    }
    public void setIntTransTechVal5(String intTransTechVal5) {
        this.intTransTechVal5 = intTransTechVal5;
    }

    public String getIntTransTransChildId() {
        return intTransTransChildId;
    }
    public void setIntTransTransChildId(String intTransTransChildId) {
        this.intTransTransChildId = intTransTransChildId;
    }

    public String getIntTransTransChildUuid() {
        return intTransTransChildUuid;
    }
    public void setIntTransTransChildUuid(String intTransTransChildUuid) {
        this.intTransTransChildUuid = intTransTransChildUuid;
    }

    public String getIntTransTransParentId() {
        return intTransTransParentId;
    }
    public void setIntTransTransParentId(String intTransTransParentId) {
        this.intTransTransParentId = intTransTransParentId;
    }

    public String getIntTransTransParentUuid() {
        return intTransTransParentUuid;
    }
    public void setIntTransTransParentUuid(String intTransTransParentUuid) {
        this.intTransTransParentUuid = intTransTransParentUuid;
    }

    public String getIntTransTrgSystemUuid() {
        return intTransTrgSystemUuid;
    }
    public void setIntTransTrgSystemUuid(String intTransTrgSystemUuid) {
        this.intTransTrgSystemUuid = intTransTrgSystemUuid;
    }

    public String getIntTransTrgSystemId() {
        return intTransTrgSystemId;
    }
    public void setIntTransTrgSystemId(String intTransTrgSystemId) {
        this.intTransTrgSystemId = intTransTrgSystemId;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
