package com.system.org.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import java.sql.Timestamp;

@Entity
@Table(name = "`group`")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(name = "group_uuid", nullable = false)
    private String groupUuid;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_short_name")
    private String groupShortName;

    @Column(name = "group_desc")
    private String groupDesc;

	@Column(name = "upated_dts")
	private Timestamp updatedDts;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "created_dts", columnDefinition =
			"timestamp default CURRENT_TIMESTAMP", nullable = false)
	private Timestamp createdDts;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "active_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private ActiveStatus activeStatus;

    public Group() { }

	@PreUpdate
	protected void onUpdate() {
		this.updatedDts = new Timestamp(System.currentTimeMillis());
	}

	@PrePersist
	protected void onCreate() {
    	this.createdDts = new Timestamp(System.currentTimeMillis());
	}

	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupUuid() {
		return groupUuid;
	}
	public void setGroupUuid(String groupUuid) {
		this.groupUuid = groupUuid;
	}

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupShortName() {
		return groupShortName;
	}
	public void setGroupShortName(String groupShortName) {
		this.groupShortName = groupShortName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
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
