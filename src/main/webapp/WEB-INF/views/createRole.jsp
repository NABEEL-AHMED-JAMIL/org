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
        <h2>New Role</h2>
        <c:if test="${isRoleAccess.permissionCreate == 'Y'}">
            <form:form action="createRole" method="post" modelAttribute="role">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Role Name: </td>
                        <td><form:input path="roleName" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Role Type: </td>
                        <td><form:input path="roleType" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Role Label: </td>
                        <td><form:input path="roleLabel" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Role Indicator: </td>
                        <td><form:input path="roleIndicator" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Role AuthUserId: </td>
                        <td><form:input path="roleAuthUserId" required="required"/></td>
                    </tr>

                    <tr>
                        <td>RoleComments: </td>
                        <td><form:input path="roleComments" required="required"/></td>
                    </tr>

                    <tr>
                        <td>RoleGroup: </td>
                        <td>
                            <form:select path="roleGroup">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${groupIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>CreatedBy: </td>
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

        <br/><br/>
        <h3>Role List</h3>
        <form:form action="roleSearch" method="post" modelAttribute="roleSearch">
            <table border="0" cellpadding="6">
                <tr>

                   <td>
                        <form:textarea path="roleId" placeholder="Enter roleId"/>
                    </td>

                   <td>
                        <form:textarea path="roleUuid" placeholder="Enter roleUuid"/>
                    </td>

                   <td>
                        <form:textarea path="roleName" placeholder="Enter roleName"/>
                    </td>

                   <td>
                        <form:textarea path="roleType" placeholder="Enter roleType"/>
                    </td>

                   <td>
                        <form:textarea path="roleLabel" placeholder="Enter roleLabel"/>
                    </td>

                   <td>
                        <form:textarea path="roleIndicator" placeholder="Enter roleIndicator"/>
                    </td>
                </tr>
                <tr>
                   <td>
                        <form:textarea path="roleAuthUserId" placeholder="Enter roleAuthUserId"/>
                    </td>
                   <td>
                        <form:textarea path="roleComments" placeholder="Enter roleComments"/>
                    </td>
                   <td>
                        <form:textarea path="roleGroup" placeholder="Enter roleGroup"/>
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
                    <th>RoleId</th>
                    <th>RoleUuid</th>
                    <th>RoleName</th>
                    <th>RoleType</th>
                    <th>RoleLabel</th>
                    <th>RoleIndicator</th>
                    <th>RoleAuthUserId</th>
                    <th>RoleComments</th>
                    <th>RoleGroup</th>
                    <th>UpdatedDts</th>
                    <th>CreatedDts</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${roleList}" var="role">
                    <tr>
                        <td>${role.roleId}</td>
                        <td>${role.roleUuid}</td>
                        <td>${role.roleName}</td>
                        <td>${role.roleType}</td>
                        <td>${role.roleLabel}</td>
                        <td>${role.roleIndicator}</td>
                        <td>${role.roleAuthUserId}</td>
                        <td>${role.roleComments}</td>
                        <td>${role.roleGroup}</td>
                        <td>${role.updatedDts}</td>
                        <td>${role.createdDts}</td>
                        <td>${role.activeStatus}</td>
                        <td>
                            <c:if test="${isRoleAccess.permissionUpdate == 'Y'}">
                                <a href="/roleEdit/${role.roleUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isRoleAccess.permissionSoftDelete == 'Y'}">
                                <a href="/roleDelete/${role.roleUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>