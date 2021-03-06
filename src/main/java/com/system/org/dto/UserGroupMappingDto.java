package com.system.org.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupMappingDto {

    private Long id;
    private String groupId;
    private String userId;
	private Timestamp updatedDts;
	private String updatedBy;
	private Timestamp createdDts;
	private String createdBy;
	private ActiveStatus activeStatus;

    public UserGroupMappingDto() { }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
