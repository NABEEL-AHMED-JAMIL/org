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
@Table(name = "role")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends BaseEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_uuid", nullable = false)
    private String roleUuid;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_type")
    private String roleType;

    @Column(name = "role_label")
    private String roleLabel;

    @Column(name = "role_indicator")
    private String roleIndicator;

    @Column(name = "role_auth_user_id")
    private String roleAuthUserId;

    @Column(name = "role_comments")
    private String roleComments;

    @Column(name = "role_group")
    private String roleGroup;

	public Role() {
	}

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleUuid() {
		return roleUuid;
	}
	public void setRoleUuid(String roleUuid) {
		this.roleUuid = roleUuid;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleLabel() {
		return roleLabel;
	}
	public void setRoleLabel(String roleLabel) {
		this.roleLabel = roleLabel;
	}

	public String getRoleIndicator() {
		return roleIndicator;
	}
	public void setRoleIndicator(String roleIndicator) {
		this.roleIndicator = roleIndicator;
	}

	public String getRoleAuthUserId() {
		return roleAuthUserId;
	}
	public void setRoleAuthUserId(String roleAuthUserId) {
		this.roleAuthUserId = roleAuthUserId;
	}

	public String getRoleComments() {
		return roleComments;
	}
	public void setRoleComments(String roleComments) {
		this.roleComments = roleComments;
	}

	public String getRoleGroup() {
		return roleGroup;
	}
	public void setRoleGroup(String roleGroup) {
		this.roleGroup = roleGroup;
	}

	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
