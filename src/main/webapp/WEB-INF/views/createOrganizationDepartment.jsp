<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>New Organization Department</title>
    </head>
    <body>
        <div align="center">
            <h2>New Organization Module</h2>
            <c:if test="${isOrganizationDepartmentAccess.permissionCreate == 'Y'}">
                <form:form action="createOrganizationDepartment" method="post" modelAttribute="organizationDepartment">
                    <table border="0" cellpadding="5">
                        <tr>
                            <td>Organization Uuid: </td>
                            <td>
                                <form:select path="organizationUuid">
                                   <form:option value="NONE" label="--- Select ---"/>
                                   <form:options items="${organizationIds}" />
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>DepartmentLookup Uuid: </td>
                            <td>
                                <form:select path="departmentLookupUuid">
                                   <form:option value="NONE" label="--- Select ---"/>
                                   <form:options items="${moduleLookupIds}" />
                                </form:select>
                            </td>
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
                                <a href="/organization">Back</a>&nbsp;
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
            <h3>Link Organization Departmente</h3>
            <form:form action="organizationDepartmentSearch" method="post" modelAttribute="organizationDepartmentSearch">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>
                            <form:textarea path="organizationDepartmentId" placeholder="Enter OrganizationDepartment Id"/>
                        </td>
                        <td>
                            <form:textarea path="organizationDepartmentUuid" placeholder="Enter OrganizationDepartment Uuid"/>
                        </td>
                        <td>
                            <form:textarea path="organizationUuid" placeholder="Enter Organization Uuid"/>
                        </td>
                        <td>
                            <form:textarea path="departmentLookupUuid" placeholder="Enter DepartmentLookup Uuid"/>
                        </td>
                    </tr>
                    <tr>
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
                        <th>OrganizationDepartment Id</th>
                        <th>OrganizationDepartment Uuid</th>
                        <th>Organization Uuid</th>
                        <th>DepartmentLookup Uuid</th>
                        <th>Created By</th>
                        <th>Created Date</th>
                        <th>Active Status</th>
                        <th>Updated Date</th>
                        <th>Updated By</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach items="${organizationDepartmentList}" var="organizationDepartment">
                        <tr>
                            <td>${organizationDepartment.organizationDepartmentId}</td>
                            <td>${organizationDepartment.organizationDepartmentUuid}</td>
                            <td>${organizationDepartment.organizationUuid}</td>
                            <td>${organizationDepartment.departmentLookupUuid}</td>
                            <td>${organizationDepartment.createdBy}</td>
                            <td>${organizationDepartment.createdDts}</td>
                            <td>${organizationDepartment.activeStatus}</td>
                            <td>${organizationDepartment.updatedDts}</td>
                            <td>${organizationDepartment.updatedBy}</td>
                            <td>
                                <c:if test="${isOrganizationDepartmentAccess.permissionUpdate == 'Y'}">
                                    <a href="/organizationDepartmentEdit/${organizationDepartment.organizationDepartmentUuid}">Edit</a>
                                </c:if>
                                &nbsp;&nbsp;&nbsp;
                                <c:if test="${isOrganizationDepartmentAccess.permissionSoftDelete == 'Y'}">
                                    <a href="/organizationDepartmentDelete/${organizationDepartment.organizationDepartmentUuid}">Delete</a>
                                </c:if>
                            </td>
                        </tr>
                     </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>