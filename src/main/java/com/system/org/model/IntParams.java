package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_params")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntParams extends BaseEntity {

    @Id
    @Column(name = "int_params_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intParamsId;

    @Column(name = "int_params_uuid", nullable = false)
    private String intParamsUuid;

    @Column(name = "int_params_name")
    private String intParamsName;

    @Column(name = "int_params_value")
    private String intParamsValue;

    @Column(name = "int_params_typeid")
    private String intParamsTypeId;

    @Column(name = "int_params_typeuuid")
    private String intParamsTypeuuId;

    @Column(name = "int_params_label")
    private String intParamsLabel;

    @Column(name = "int_params_paramtypeid")
    private String intParamsParamTypeId;

    @Column(name = "int_params_paramtypeuuid")
    private String intParamsParamTypeuuid;

    public IntParams() { }

    public Long getIntParamsId() {
      return intParamsId;
    }
    public void setIntParamsId(Long intParamsId) {
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

    @Override
    public String toString() {
      return new Gson().toJson(this);
    }
}
