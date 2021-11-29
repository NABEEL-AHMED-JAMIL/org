package com.system.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@Entity
@Table(name = "modules_lookup")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModulesLookup extends BaseEntity {

    @Id
    @Column(name = "modules_lookup_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modulesLookupId;

    @Column(name = "modules_lookup_uuid", nullable = false)
    private String modulesLookupUuid;

    @Column(name = "modules_lookup_number")
    private String modulesLookupNumber;

    @Column(name = "modules_lookup_short_description")
    private String modulesLookupShortDescription;

    @Column(name = "modules_lookup_name", nullable = false)
    private String modulesLookupName;

    @Column(name = "modules_lookup_description")
    private String modulesLookupDescription;

    public ModulesLookup() {
    }

    public Long getModulesLookupId() {
        return modulesLookupId;
    }
    public void setModulesLookupId(Long modulesLookupId) {
        this.modulesLookupId = modulesLookupId;
    }

    public String getModulesLookupUuid() {
        return modulesLookupUuid;
    }
    public void setModulesLookupUuid(String modulesLookupUuid) {
        this.modulesLookupUuid = modulesLookupUuid;
    }

    public String getModulesLookupNumber() {
        return modulesLookupNumber;
    }
    public void setModulesLookupNumber(String modulesLookupNumber) {
        this.modulesLookupNumber = modulesLookupNumber;
    }

    public String getModulesLookupShortDescription() {
        return modulesLookupShortDescription;
    }
    public void setModulesLookupShortDescription(String modulesLookupShortDescription) {
        this.modulesLookupShortDescription = modulesLookupShortDescription;
    }

    public String getModulesLookupName() {
        return modulesLookupName;
    }
    public void setModulesLookupName(String modulesLookupName) {
        this.modulesLookupName = modulesLookupName;
    }

    public String getModulesLookupDescription() {
        return modulesLookupDescription;
    }
    public void setModulesLookupDescription(String modulesLookupDescription) {
        this.modulesLookupDescription = modulesLookupDescription;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
