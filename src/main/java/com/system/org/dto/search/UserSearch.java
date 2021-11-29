package com.system.org.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSearch {

    private String userId;
    private String userUuid;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String address;
    private String userActivatedDate;
    private String userAuthUserId;
    private String userContactnumber;
    private String userEmail;
    private String userOrgId;
    private String userUserId;
    private String userExpirationDateFromDate;
    private String userExpirationDateToDate;
    private String userLastActivityDateFromDate;
    private String userLastActivityDateToDate;
    private String fromDate;
    private String toDate;
    private String updateFromDate;
    private String updateToDate;


    public UserSearch() { }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserUuid() {
        return userUuid;
    }
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserFirstName() {
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }
    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserActivatedDate() {
        return userActivatedDate;
    }
    public void setUserActivatedDate(String userActivatedDate) {
        this.userActivatedDate = userActivatedDate;
    }

    public String getUserAuthUserId() {
        return userAuthUserId;
    }
    public void setUserAuthUserId(String userAuthUserId) {
        this.userAuthUserId = userAuthUserId;
    }

    public String getUserContactnumber() {
        return userContactnumber;
    }
    public void setUserContactnumber(String userContactnumber) {
        this.userContactnumber = userContactnumber;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserOrgId() {
        return userOrgId;
    }
    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId;
    }

    public String getUserUserId() {
        return userUserId;
    }
    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
    }

    public String getUserExpirationDateFromDate() {
        return userExpirationDateFromDate;
    }

    public void setUserExpirationDateFromDate(String userExpirationDateFromDate) {
        this.userExpirationDateFromDate = userExpirationDateFromDate;
    }

    public String getUserExpirationDateToDate() {
        return userExpirationDateToDate;
    }

    public void setUserExpirationDateToDate(String userExpirationDateToDate) {
        this.userExpirationDateToDate = userExpirationDateToDate;
    }

    public String getUserLastActivityDateFromDate() {
        return userLastActivityDateFromDate;
    }

    public void setUserLastActivityDateFromDate(String userLastActivityDateFromDate) {
        this.userLastActivityDateFromDate = userLastActivityDateFromDate;
    }

    public String getUserLastActivityDateToDate() {
        return userLastActivityDateToDate;
    }

    public void setUserLastActivityDateToDate(String userLastActivityDateToDate) {
        this.userLastActivityDateToDate = userLastActivityDateToDate;
    }

    public String getFromDate() {
        return fromDate;
    }
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getUpdateFromDate() {
        return updateFromDate;
    }
    public void setUpdateFromDate(String updateFromDate) {
        this.updateFromDate = updateFromDate;
    }

    public String getUpdateToDate() {
        return updateToDate;
    }
    public void setUpdateToDate(String updateToDate) {
        this.updateToDate = updateToDate;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
