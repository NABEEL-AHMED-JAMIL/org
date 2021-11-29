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
        <h2>New PermissionType</h2>
        <c:if test="${isPermissionTypeAccess.permissionCreate == 'Y'}">
            <form:form action="createPermissionType" method="post" modelAttribute="permissionType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Permission TypeName: </td>
                        <td><form:input path="permissionTypeName" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Permission TypeShortDescription: </td>
                        <td><form:input path="permissionTypeShortDescription" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Permission TypeDescription: </td>
                        <td><form:input path="permissionTypeDescription" required="required"/></td>
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
                            <a href="/permissionView">Back</a>&nbsp;
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
        <h3>Permission Type</h3>
        <form:form action="permissionTypeSearch" method="post" modelAttribute="permissionTypeSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="permissionTypeId" placeholder="Enter PermissionType Id"/>
                    </td>
                    <td>
                        <form:textarea path="permissionTypeUuid" placeholder="Enter PermissionType Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="permissionTypeName" placeholder="Enter PermissionType Name"/>
                    </td>
                    <td>
                        <form:textarea path="permissionTypeShortDescription" placeholder="Enter PermissionType ShortDescription"/>
                    </td>
                    <td>
                        <form:textarea path="permissionTypeDescription" placeholder="Enter PermissionType Description"/>
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
                    <th>PermissionType Id</th>
                    <th>PermissionType Uuid</th>
                    <th>PermissionType Name</th>
                    <th>PermissionType ShortDescription</th>
                    <th>PermissionType Description</th>
                    <th>Created Dts</th>
                    <th>Created By</th>
                    <th>Active Status</th>
                    <th>Updated Dts</th>
                    <th>Updated By</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${permissionTypeList}" var="permissionType">
                    <tr>
                        <td>${permissionType.permissionTypeId}</td>
                        <td>${permissionType.permissionTypeUuid}</td>
                        <td>${permissionType.permissionTypeName}</td>
                        <td>${permissionType.permissionTypeShortDescription}</td>
                        <td>${permissionType.permissionTypeDescription}</td>
                        <td>${permissionType.createdDts}</td>
                        <td>${permissionType.createdBy}</td>
                        <td>${permissionType.activeStatus}</td>
                        <td>${permissionType.updatedDts}</td>
                        <td>${permissionType.updatedBy}</td>
                        <td>
                            <c:if test="${isPermissionTypeAccess.permissionUpdate == 'Y'}">
                                <a href="/permissionTypeEdit/${permissionType.permissionTypeUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isPermissionTypeAccess.permissionSoftDelete == 'Y'}">
                                <a href="/permissionTypeDelete/${permissionType.permissionTypeUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
           </tbody>
        </table>
    </div>
</body>
</html>