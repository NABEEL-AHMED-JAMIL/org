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
@Table(name = "user_role")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRole extends BaseEntity {

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @Column(name = "user_role_uuid", nullable = false)
    private String userRoleUuid;

    @Column(name = "permission_id")
    private String permissionId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_role_authorization_user_id")
    private String userRoleAuthorizationUserId;

    @Column(name = "user_role_available_indicator")
    private String userRoleAvailableIndicator;

    @Column(name = "user_role_expiration_date")
    private Timestamp userRoleExpirationDate;

    public UserRole() { }

	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleUuid() {
		return userRoleUuid;
	}
	public void setUserRoleUuid(String userRoleUuid) {
		this.userRoleUuid = userRoleUuid;
	}

	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRoleAuthorizationUserId() {
		return userRoleAuthorizationUserId;
	}
	public void setUserRoleAuthorizationUserId(String userRoleAuthorizationUserId) {
		this.userRoleAuthorizationUserId = userRoleAuthorizationUserId;
	}

	public String getUserRoleAvailableIndicator() {
		return userRoleAvailableIndicator;
	}
	public void setUserRoleAvailableIndicator(String userRoleAvailableIndicator) {
		this.userRoleAvailableIndicator = userRoleAvailableIndicator;
	}

	public Timestamp getUserRoleExpirationDate() {
		return userRoleExpirationDate;
	}
	public void setUserRoleExpirationDate(Timestamp userRoleExpirationDate) {
		this.userRoleExpirationDate = userRoleExpirationDate;
	}

	@Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
