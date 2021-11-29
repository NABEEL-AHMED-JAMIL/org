package com.system.org.model;

import java.sql.Timestamp;

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
@Table(name = "role_permission")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolePermission extends BaseEntity {

    @Id
    @Column(name = "role_permission_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolePermissionId;

    @Column(name = "role_permission_uuid", nullable = false)
    private String rolePermissionUuid;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "permission_id")
    private String permissionId;

    @Column(name = "role_permission_authorization_user_id")
    private String rolePermissionAuthorizationUserId;

    @Column(name = "role_permission_available_indicator")
    private String rolePermissionAvailableIndicator;

    @Column(name = "role_permission_expiration_date")
    private Timestamp rolePermissionExpirationDate;

    public RolePermission() { }
    
	public Long getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(Long rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public String getRolePermissionUuid() {
		return rolePermissionUuid;
	}

	public void setRolePermissionUuid(String rolePermissionUuid) {
		this.rolePermissionUuid = rolePermissionUuid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getRolePermissionAuthorizationUserId() {
		return rolePermissionAuthorizationUserId;
	}

	public void setRolePermissionAuthorizationUserId(String rolePermissionAuthorizationUserId) {
		this.rolePermissionAuthorizationUserId = rolePermissionAuthorizationUserId;
	}

	public String getRolePermissionAvailableIndicator() {
		return rolePermissionAvailableIndicator;
	}

	public void setRolePermissionAvailableIndicator(String rolePermissionAvailableIndicator) {
		this.rolePermissionAvailableIndicator = rolePermissionAvailableIndicator;
	}

	public Timestamp getRolePermissionExpirationDate() {
		return rolePermissionExpirationDate;
	}

	public void setRolePermissionExpirationDate(Timestamp rolePermissionExpirationDate) {
		this.rolePermissionExpirationDate = rolePermissionExpirationDate;
	}

	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
