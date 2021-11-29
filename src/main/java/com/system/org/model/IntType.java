package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_type")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntType extends BaseEntity {

    @Id
    @Column(name = "Int_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intTypeId;

    @Column(name = "int_type_uuid", nullable = false)
    private String intTypeUuid;

    @Column(name = "int_type_name")
    private String intTypeName;

    @Column(name = "int_type_short_description")
    private String intTypeShortDescription;

    @Column(name = "int_type_description")
    private String intTypeDescription;

    public IntType() {
    }

    public Long getIntTypeId() {
        return intTypeId;
    }
    public void setIntTypeId(Long intTypeId) {
        this.intTypeId = intTypeId;
    }

    public String getIntTypeUuid() {
        return intTypeUuid;
    }
    public void setIntTypeUuid(String intTypeUuid) {
        this.intTypeUuid = intTypeUuid;
    }

    public String getIntTypeName() {
        return intTypeName;
    }
    public void setIntTypeName(String intTypeName) {
        this.intTypeName = intTypeName;
    }

    public String getIntTypeShortDescription() {
        return intTypeShortDescription;
    }
    public void setIntTypeShortDescription(String intTypeShortDescription) {
        this.intTypeShortDescription = intTypeShortDescription;
    }

    public String getIntTypeDescription() {
        return intTypeDescription;
    }
    public void setIntTypeDescription(String intTypeDescription) {
        this.intTypeDescription = intTypeDescription;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
