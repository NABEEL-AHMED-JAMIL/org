package com.system.org.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "int_cmd")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmd extends BaseEntity {

    @Id
    @Column(name = "int_cmd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intCmdId;

    @Column(name = "int_cmd_uuid", nullable = false)
    private String intCmdUuid;

    @Column(name = "int_cmd_int_type_id")
    private String intCmdIntTypeId;

    @Column(name = "int_cmd_int_type_uuid")
    private String intCmdIntTypeUuid;

    @Lob
    @Column(name="int_cmd_cmd")
    private String intCmdCmd;

    @Column(name="int_cmd_cmd_userfriendlyname")
    private String intCmdCmdUserfriendlyname;

    @Lob
    @Column(name="int_cmd_blog")
    private String intCmdBlog;

    @Column(name="int_cmd_zebra_id")
    private Integer intCmdZebraId;

    @Column(name="int_cmd_zebra_uuid")
    private String intCmdZebraUuid;

    public IntCmd() { }

    public Long getIntCmdId() {
        return intCmdId;
    }
    public void setIntCmdId(Long intCmdId) {
        this.intCmdId = intCmdId;
    }

    public String getIntCmdUuid() {
        return intCmdUuid;
    }
    public void setIntCmdUuid(String intCmdUuid) {
        this.intCmdUuid = intCmdUuid;
    }

    public String getIntCmdIntTypeId() {
        return intCmdIntTypeId;
    }
    public void setIntCmdIntTypeId(String intCmdIntTypeId) {
        this.intCmdIntTypeId = intCmdIntTypeId;
    }

    public String getIntCmdIntTypeUuid() {
        return intCmdIntTypeUuid;
    }
    public void setIntCmdIntTypeUuid(String intCmdIntTypeUuid) {
        this.intCmdIntTypeUuid = intCmdIntTypeUuid;
    }

    public String getIntCmdCmd() {
        return intCmdCmd;
    }
    public void setIntCmdCmd(String intCmdCmd) {
        this.intCmdCmd = intCmdCmd;
    }

    public String getIntCmdCmdUserfriendlyname() {
        return intCmdCmdUserfriendlyname;
    }
    public void setIntCmdCmdUserfriendlyname(String intCmdCmdUserfriendlyname) {
        this.intCmdCmdUserfriendlyname = intCmdCmdUserfriendlyname;
    }

    public String getIntCmdBlog() {
        return intCmdBlog;
    }
    public void setIntCmdBlog(String intCmdBlog) {
        this.intCmdBlog = intCmdBlog;
    }

    public Integer getIntCmdZebraId() {
        return intCmdZebraId;
    }
    public void setIntCmdZebraId(Integer intCmdZebraId) {
        this.intCmdZebraId = intCmdZebraId;
    }

    public String getIntCmdZebraUuid() {
        return intCmdZebraUuid;
    }
    public void setIntCmdZebraUuid(String intCmdZebraUuid) {
        this.intCmdZebraUuid = intCmdZebraUuid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
