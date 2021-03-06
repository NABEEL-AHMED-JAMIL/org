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
        <h2>New ResourceType</h2>
        <c:if test="${isResourceTypeAccess.permissionCreate == 'Y'}">
            <form:form action="createResourceType" method="post" modelAttribute="resourceType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Name: </td>
                        <td><form:input path="resourceTypeName" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Short Description: </td>
                        <td><form:input path="resourceTypeDesc" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Created By</td>
                        <td>
                            <form:select path="createdBy">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="/resource">Back</a>&nbsp;
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                            <input type="submit" value="Save">
                        </td>
                    </tr>
                </table>
            </form:form>
        </c:if>
        &nbsp&nbsp
        <h3>Resource Type</h3>
        <form:form action="resourceTypeSearch" method="post" modelAttribute="resourceTypeSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="resourceTypeId" placeholder="Enter ResourceType Id"/>
                    </td>
                    <td>
                        <form:textarea path="resourceTypeUuid" placeholder="Enter ResourceType Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="resourceTypeName" placeholder="Enter ResourceType Name"/>
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
                    <th>ResourceType ID</th>
                    <th>ResourceType UUID</th>
                    <th>ResourceType Name</th>
                    <th>ResourceType Description</th>
                    <th>Active Status</th>
                    <th>Created Date</th>
                    <th>Created By</th>
                    <th>Updated Date</th>
                    <th>Updated By</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${resourceTypeList}" var="resourceType">
                    <tr>
                        <td>${resourceType.resourceTypeId}</td>
                        <td>${resourceType.resourceTypeUuid}</td>
                        <td>${resourceType.resourceTypeName}</td>
                        <td>${resourceType.resourceTypeDesc}</td>
                        <td>${resourceType.activeStatus}</td>
                        <td>${resourceType.createdDts}</td>
                        <td>${resourceType.createdBy}</td>
                        <td>${resourceType.updatedDts}</td>
                        <td>${resourceType.updatedBy}</td>
                        <td>
                            <c:if test="${isResourceTypeAccess.permissionUpdate == 'Y'}">
                                <a href="/resourceTypeEdit/${resourceType.resourceTypeUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isResourceTypeAccess.permissionSoftDelete == 'Y'}">
                                <a href="/resourceTypeDelete/${resourceType.resourceTypeUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>