<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       <meta charset="utf-8"/>
       <title>Product Manager</title>
    </head>
    <body>
        <div align="center">
            <h1>User Detail</h1>
            <c:if test="${isUserAccess == true}">
                <a href="/createUser">Create User</a>&nbsp;
            </c:if>
            <c:if test="${isUserRoleAccess == true}">
                <a href="/createUserRole">Create User Role</a>&nbsp;
            </c:if>
            <c:if test="${isRoleAccess == true}">
                <a href="/createRole">Create Role</a>&nbsp;
            </c:if>
            <c:if test="${isRolePermissionAccess == true}">
                <a href="/createRolePermission">Create Role Permission</a>&nbsp;
            </c:if>
            <c:if test="${isGroupsAccess == true}">
                <a href="/createGroups">Create Groups</a>&nbsp;
            </c:if>
            <c:if test="${isUsergroupmappingAccess == true}">
                <a href="/createUserGroupmapping">Create UserGroup mapping</a>&nbsp;
            </c:if>
            <c:if test="${isUserOrganizationMappingAccess == true}">
                <a href="/createUserOrganizationmapping">Create User Organization mapping</a>&nbsp;
            </c:if>
            <c:if test="${isUserroleMappingAccess == true}">
                <a href="/createUserRolemapping">Create User Role mapping</a>&nbsp;
            </c:if>
            <a href="/index">Back</a>&nbsp;
            <br/><br/>
        </div>
    </body>
</html>
