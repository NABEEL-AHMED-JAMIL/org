package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_log_type")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntLogType extends BaseEntity {

    @Id
    @Column(name = "int_log_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intLogTypeId;

    @Column(name = "int_log_type_uuid", nullable = false)
    private String intLogTypeUuid;

    @Column(name = "int_log_type_description")
    private String intLogTypeDescription;

    @Column(name = "int_log_type_name")
    private String intLogTypeName;

    @Column(name = "int_log_type_short_description")
    private String intLogTypeShortDescription;

    public IntLogType() { }

    public Long getIntLogTypeId() {
        return intLogTypeId;
    }
    public void setIntLogTypeId(Long intLogTypeId) {
        this.intLogTypeId = intLogTypeId;
    }

    public String getIntLogTypeUuid() {
        return intLogTypeUuid;
    }
    public void setIntLogTypeUuid(String intLogTypeUuid) {
        this.intLogTypeUuid = intLogTypeUuid;
    }

    public String getIntLogTypeDescription() {
        return intLogTypeDescription;
    }
    public void setIntLogTypeDescription(String intLogTypeDescription) {
        this.intLogTypeDescription = intLogTypeDescription;
    }

    public String getIntLogTypeName() {
        return intLogTypeName;
    }
    public void setIntLogTypeName(String intLogTypeName) {
        this.intLogTypeName = intLogTypeName;
    }

    public String getIntLogTypeShortDescription() {
        return intLogTypeShortDescription;
    }
    public void setIntLogTypeShortDescription(String intLogTypeShortDescription) {
        this.intLogTypeShortDescription = intLogTypeShortDescription;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
