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
        <h2>New User Organizationmapping</h2>
        <c:if test="${isUserOrganizationMappingAccess.permissionCreate == 'Y'}">
            <form:form action="createUserOrganizationmapping" method="post" modelAttribute="userOrganizationMapping">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>OrgId: </td>
                        <td>
                            <form:select path="orgId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${organizationIds}" />
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
        <h3>User Organization Mapping List</h3>
        <form:form action="userOrganizationMappingSearch" method="post" modelAttribute="userOrganizationMappingSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="id" placeholder="Enter id"/>
                    </td>

                    <td>
                        <form:textarea path="orgId" placeholder="Enter orgId"/>
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
                    <th>Org Id</th>
                    <th>UserId</th>
                    <th>UpdatedDts</th>
                    <th>CreatedDts</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${userOrganizationMappingList}" var="userOrganizationMapping">
                    <tr>
                        <td>${userOrganizationMapping.id}</td>
                        <td>${userOrganizationMapping.orgId}</td>
                        <td>${userOrganizationMapping.userId}</td>
                        <td>${userOrganizationMapping.updatedDts}</td>
                        <td>${userOrganizationMapping.createdDts}</td>
                        <td>${userOrganizationMapping.activeStatus}</td>
                        <td>
                            <c:if test="${isUserOrganizationMappingAccess.permissionUpdate == 'Y'}">
                                <a href="/userOrganizationmappingEdit/${userOrganizationMapping.id}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isUserOrganizationMappingAccess.permissionSoftDelete == 'Y'}">
                                <a href="/userOrganizationmappingDelete/${userOrganizationMapping.id}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>