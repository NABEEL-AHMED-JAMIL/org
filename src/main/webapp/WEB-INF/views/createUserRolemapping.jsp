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
        <h2>New UserRoleMapping</h2>
        <c:if test="${isUserroleMappingAccess.permissionCreate == 'Y'}">
            <form:form action="createUserRolemapping" method="post" modelAttribute="userRoleMapping">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>RoleId: </td>
                        <td>
                            <form:select path="roleId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${roleIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>UserId: </td>
                        <td>
                            <form:select path="userId">
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
        <h3>User Role Mapping Mapping List</h3>
        <form:form action="userRoleMappingSearch" method="post" modelAttribute="userRoleMappingSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="id" placeholder="Enter id"/>
                    </td>

                    <td>
                        <form:textarea path="roleId" placeholder="Enter roleId"/>
                    </td>

                    <td>
                        <form:textarea path="userId" placeholder="Enter userId"/>
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
                    <th>Id</th>
                    <th>Role Id</th>
                    <th>UserId</th>
                    <th>UpdatedDts</th>
                    <th>CreatedDts</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${userRoleMappingList}" var="userRoleMapping">
                    <tr>
                        <td>${userRoleMapping.id}</td>
                        <td>${userRoleMapping.roleId}</td>
                        <td>${userRoleMapping.userId}</td>
                        <td>${userRoleMapping.updatedDts}</td>
                        <td>${userRoleMapping.createdDts}</td>
                        <td>${userRoleMapping.activeStatus}</td>
                        <td>
                            <c:if test="${isUserroleMappingAccess.permissionUpdate == 'Y'}">
                                <a href="/userRolemappingEdit/${userRoleMapping.id}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isUserroleMappingAccess.permissionSoftDelete == 'Y'}">
                                <a href="/userRolemappingDelete/${userRoleMapping.id}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>