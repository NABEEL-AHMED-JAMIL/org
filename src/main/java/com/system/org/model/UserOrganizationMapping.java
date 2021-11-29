package com.system.org.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.enums.ActiveStatus;

import java.sql.Timestamp;

@Entity
@Table(name = "userorganizationmapping")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOrganizationMapping {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orgId", nullable = false)
    private String orgId;

    @Column(name = "userId")
    private String userId;

	@Column(name = "updated_dts")
	private Timestamp updatedDts;

	@Column(name = "created_dts", columnDefinition =
		"timestamp default CURRENT_TIMESTAMP", nullable = false)
	private Timestamp createdDts;

	@Column(name = "active_status", nullable = false)
	private ActiveStatus activeStatus;

    public UserOrganizationMapping() { }

	@PreUpdate
	protected void onUpdate() {
		this.updatedDts = new Timestamp(System.currentTimeMillis());
	}

	@PrePersist
	protected void onCreate() { this.createdDts = new Timestamp(System.currentTimeMillis()); }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
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

	public Timestamp getCreatedDts() {
		return createdDts;
	}
	public void setCreatedDts(Timestamp createdDts) {
		this.createdDts = createdDts;
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
