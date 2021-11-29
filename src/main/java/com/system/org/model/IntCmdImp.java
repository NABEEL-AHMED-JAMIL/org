package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_cmd_imp")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdImp extends BaseEntity {

    @Id
    @Column(name = "int_cmd_imp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intCmdImpId;

    @Column(name = "int_cmd_imp_uuid", nullable = false)
    private String intCmdImpUuid;

    @Column(name = "int_cmd_imp_int_cmd_id")
    private String intCmdImpIntCmdId;

    @Column(name = "int_cmd_imp_int_cmd_uuid")
    private String intCmdImpIntCmdUuid;

    @Column(name = "int_cmd_imp_int_cmd_param_id")
    private String intCmdImpIntCmdParamId;

    @Column(name = "int_cmd_imp_int_cmd_param_uuid")
    private String intCmdImpIntCmdParamUuid;

    @Column(name = "int_cmd_imp_int_cmd_param_value")
    private String intCmdImpIntCmdParamValue;

    @Column(name = "int_cmd_imp_user_uuid")
    private String intCmdImpUserUuid;

    public IntCmdImp() { }

    public Long getIntCmdImpId() {
        return intCmdImpId;
    }
    public void setIntCmdImpId(Long intCmdImpId) {
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
