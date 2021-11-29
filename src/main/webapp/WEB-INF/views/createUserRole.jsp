<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
    <div align="center">
        <h2>New User Role</h2>
        <c:if test="${isUserRoleAccess.permissionCreate == 'Y'}">
            <form:form action="createUserRole" method="post" modelAttribute="userRole">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Permission Id: </td>
                        <td><form:input path="permissionId" required="required"/></td>
                    </tr>

                    <tr>
                        <td>UserId: </td>
                        <td><form:input path="userId" required="required"/></td>
                    </tr>

                    <tr>
                        <td>User RoleAuthorizationUserId: </td>
                        <td><form:input path="userRoleAuthorizationUserId" required="required"/></td>
                    </tr>

                    <tr>
                        <td>User RoleAvailableIndicator: </td>
                        <td><form:input path="userRoleAvailableIndicator" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Created By: </td>
                        <td>
                            <form:select path="createdBy">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="/userdetail">Back</a>&nbsp;
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </form:form>
        </c:if>
        <br><br>
        <h3>User Role List</h3>
        <form:form action="userRoleSearch" method="post" modelAttribute="userRoleSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="userRoleId" placeholder="Enter userRoleId"/>
                    </td>

                    <td>
                        <form:textarea path="userRoleUuid" placeholder="Enter userRoleUuid"/>
                    </td>

                    <td>
                        <form:textarea path="permissionId" placeholder="Enter permissionId"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="userId" placeholder="Enter userId"/>
                    </td>

                    <td>
                        <form:textarea path="userRoleAuthorizationUserId" placeholder="Enter userRoleAuthorizationUserId"/>
                    </td>

                    <td>
                        <form:textarea path="userRoleAvailableIndicator" placeholder="Enter userRoleAvailableIndicator"/>
                    </td>
                    <td>Created Date: </td>
                    <td>
                        <form:input path="fromDate" type="date"/>
                    </td>
                    <td>
                        <form:input path="toDate" type="date"/>
                    </td>
                    <td>Update Date: </td>
                    <td>
                        <form:input path="updateFromDate" type="date"/>
                    </td>
                    <td>
                        <form:input path="updateToDate" type="date"/>
                    </td>
                    <td colspan="2">
                        <input type="submit" value="Search">
                    </td>
                </tr>
            </table>
        </form:form>
        <table border="1" cellpadding="10">
            <thead>
                <tr>
                    <th>User RoleId</th>
                    <th>User RoleUuid</th>
                    <th>PermissionId</th>
                    <th>UserId</th>
                    <th>User RoleAuthorizationUserId</th>
                    <th>User RoleAvailableIndicator</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${userRoleList}" var="userRole">
                    <tr>
                        <td>${userRole.userRoleId}</td>
                        <td>${userRole.userRoleUuid}</td>
                        <td>${userRole.permissionId}</td>
                        <td>${userRole.userId}</td>
                        <td>${userRole.userRoleAuthorizationUserId}</td>
                        <td>${userRole.userRoleAvailableIndicator}</td>
                        <td>${userRole.updatedDts}</td>
                        <td>${userRole.updatedBy}</td>
                        <td>${userRole.createdDts}</td>
                        <td>${userRole.createdBy}</td>
                        <td>${userRole.activeStatus}</td>
                        <td>
                            <c:if test="${isUserRoleAccess.permissionUpdate == 'Y'}">
                                <a href="/userRoleEdit/${userRole.userRoleUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isUserRoleAccess.permissionSoftDelete == 'Y'}">
                                <a href="/userRoleDelete/${userRole.userRoleUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>