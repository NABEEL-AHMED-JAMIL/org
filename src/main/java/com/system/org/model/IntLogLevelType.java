package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_log_level_type")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntLogLevelType extends BaseEntity {

    @Id
    @Column(name = "int_log_level_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intLogLevelTypeId;

    @Column(name = "int_log_level_type_uuid", nullable = false)
    private String intLogLevelTypeUuid;

    @Column(name = "int_log_level_type_description")
    private String intLogLevelTypeDescription;

    @Column(name = "int_log_level_type_name")
    private String intLogLevelTypeName;

    @Column(name = "int_log_level_type_short_description")
    private String intLogLevelTypeShortDescription;

    public IntLogLevelType() { }

    public Long getIntLogLevelTypeId() {
        return intLogLevelTypeId;
    }
    public void setIntLogLevelTypeId(Long intLogLevelTypeId) {
        this.intLogLevelTypeId = intLogLevelTypeId;
    }

    public String getIntLogLevelTypeUuid() {
        return intLogLevelTypeUuid;
    }
    public void setIntLogLevelTypeUuid(String intLogLevelTypeUuid) {
        this.intLogLevelTypeUuid = intLogLevelTypeUuid;
    }

    public String getIntLogLevelTypeDescription() {
        return intLogLevelTypeDescription;
    }
    public void setIntLogLevelTypeDescription(String intLogLevelTypeDescription) {
        this.intLogLevelTypeDescription = intLogLevelTypeDescription;
    }

    public String getIntLogLevelTypeName() {
        return intLogLevelTypeName;
    }
    public void setIntLogLevelTypeName(String intLogLevelTypeName) {
        this.intLogLevelTypeName = intLogLevelTypeName;
    }

    public String getIntLogLevelTypeShortDescription() {
        return intLogLevelTypeShortDescription;
    }
    public void setIntLogLevelTypeShortDescription(String intLogLevelTypeShortDescription) {
        this.intLogLevelTypeShortDescription = intLogLevelTypeShortDescription;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
