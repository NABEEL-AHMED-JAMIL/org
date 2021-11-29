package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntTransDto {

    private Long intTransId;
    private String intTransUuid;
    private String intTransName;
    private String intDetailLogSysId;
    private String intDetailLogSysName;
    private String intDetailLogSysUuid;
    private String intTransAppId;
    private String intTransAppName;
    private String intTransAppUuid;
    private String intTransBusName1;
    private String intTransBusName2;
    private String intTransBusName3;
    private String intTransBusName4;
    private String intTransBusName5;
    private String intTransBusVal1;
    private String intTransBusVal2;
    private String intTransBusVal3;
    private String intTransBusVal4;
    private String intTransBusVal5;
    private String intTransDesc;
    private String intTransEnvId;
    private String intTransEnvName;
    private String intTransEnvUuid;
    private String intTransLogLevelId;
    private String intTransLogLevelName;
    private String intTransLogLevelUuid;
    private String intTransLogTypeId;
    private String intTransLogTypeName;
    private String intTransLogTypeUuid;
    private String intTransOrgDepId;
    private String intTransOrgDepName;
    private String intTransOrgDepUuid;
    private String intTransOrgId;
    private String intTransOrgName;
    private String intTransOrgUuid;
    private String intTransPayload;
    private String intTransPlayloadBlob;
    private String intTransShortDesc;
    private String intTransSrcSystemTransId;
    private String intTransSrcSystemTransuuid;
    private String intTransSrcSystemUuid;
    private String intTransSrcSystemId;
    private String intTransTechName1;
    private String intTransTechName2;
    private String intTransTechName3;
    private String intTransTechName4;
    private String intTransTechName5;
    private String intTransTechVal1;
    private String intTransTechVal2;
    private String intTransTechVal3;
    private String intTransTechVal4;
    private String intTransTechVal5;
    private String intTransTransChildId;
    private String intTransTransChildUuid;
    private String intTransTransParentId;
    private String intTransTransParentUuid;
    private String intTransTrgSystemUuid;
    private String intTransTrgSystemId;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntTransDto() { }

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

    public Timestamp getUpdatedDts() {
        return updatedDts;
    }
    public void setUpdatedDts(Timestamp updatedDts) {
        this.updatedDts = updatedDts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreatedDts() {
        return createdDts;
    }
    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
