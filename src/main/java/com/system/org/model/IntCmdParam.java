package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_cmd_param")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdParam extends BaseEntity { 
  
    @Id
    @Column(name = "int_cmd_param_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intCmdParamId;

    @Column(name = "int_cmd_param_uuid", nullable = false)
    private String intCmdParamUuid;

    @Column(name = "int_cmd_param_int_cmd_uuid")
    private String intCmdParamIntCmdUuid;

    @Column(name = "int_cmd_param_int_cmd_id")
    private String intCmdParamIntCmdId;

    @Column(name = "int_cmd_param_name")
    private String intCmdParamName;

    @Column(name = "int_cmd_param_defaultvalue")
    private String intCmdParamDefaultvalue;

    @Column(name = "int_cmd_param_description")
    private String intCmdParamDescription;

    @Column(name = "int_cmd_param_shortdescription")
    private String intCmdParamShortdescription;

    @Column(name = "int_cmd_param_position")
    private String intCmdParamPosition;

    public IntCmdParam() { }

    public Long getIntCmdParamId() {
      return intCmdParamId;
    }
    public void setIntCmdParamId(Long intCmdParamId) {
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

    @Override
      public String toString() {
            return new Gson().toJson(this);
        }
}
