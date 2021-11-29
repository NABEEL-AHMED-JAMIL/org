package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_env_type")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntEnvType extends BaseEntity {

    @Id
    @Column(name = "int_env_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intEnvTypeId;

    @Column(name = "int_env_type_uuid")
    private String intEnvTypeUuid;

    @Column(name = "int_env_type_name", unique = true)
    private String intEnvTypeName;

    @Column(name = "int_env_type_description")
    private String intEnvTypeDescription;

    @Column(name = "int_env_type_short_description")
    private String intEnvTypeShortDescription;

    public IntEnvType() {
    }

    public Long getIntEnvTypeId() {
        return intEnvTypeId;
    }
    public void setIntEnvTypeId(Long intEnvTypeId) {
        this.intEnvTypeId = intEnvTypeId;
    }

    public String getIntEnvTypeUuid() {
        return intEnvTypeUuid;
    }
    public void setIntEnvTypeUuid(String intEnvTypeUuid) {
        this.intEnvTypeUuid = intEnvTypeUuid;
    }

    public String getIntEnvTypeName() {
        return intEnvTypeName;
    }
    public void setIntEnvTypeName(String intEnvTypeName) {
        this.intEnvTypeName = intEnvTypeName;
    }

    public String getIntEnvTypeDescription() {
        return intEnvTypeDescription;
    }
    public void setIntEnvTypeDescription(String intEnvTypeDescription) {
        this.intEnvTypeDescription = intEnvTypeDescription;
    }

    public String getIntEnvTypeShortDescription() {
        return intEnvTypeShortDescription;
    }
    public void setIntEnvTypeShortDescription(String intEnvTypeShortDescription) {
        this.intEnvTypeShortDescription = intEnvTypeShortDescription;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
