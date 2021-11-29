<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
    <div align="center">
        <h2>New Organization</h2>
        <c:if test="${isOrganizationAccess.permissionCreate == 'Y'}">
            <form:form action="createOrganization" method="post" modelAttribute="organization">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Name: </td>
                        <td><form:input path="organizationName" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Short Description: </td>
                        <td><form:input path="organizationShortDescription" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><form:input path="organizationDescription" required="required"/></td>
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
        <h3>Organization List</h3>
        <form:form action="organizationSearch" method="post" modelAttribute="organizationSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="organisationId" placeholder="Enter Organisation Id"/>
                    </td>
                    <td>
                        <form:textarea path="organizationUuid" placeholder="Enter Organization Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="organizationName" placeholder="Enter Organization Name"/>
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
                    <th>ID</th>
                    <th>Uuid</th>
                    <th>Name</th>
                    <th>Short Description</th>
                    <th>Description</th>
                    <th>Created By</th>
                    <th>Created Date</th>
                    <th>Active Status</th>
                    <th>Updated Date</th>
                    <th>Updated By</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${organizationList}" var="organization1">
                    <tr>
                        <td>${organization1.organisationId}</td>
                        <td>${organization1.organizationUuid}</td>
                        <td>${organization1.organizationName}</td>
                        <td>${organization1.organizationShortDescription}</td>
                        <td>${organization1.organizationDescription}</td>
                        <td>${organization1.createdBy}</td>
                        <td>${organization1.createdDts}</td>
                        <td>${organization1.activeStatus}</td>
                        <td>${organization1.updatedDts}</td>
                        <td>${organization1.updatedBy}</td>
                        <td>
                            <c:if test="${isOrganizationAccess.permissionUpdate == 'Y'}">
                                <a href="/organizationEdit/${organization1.organizationUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isOrganizationAccess.permissionSoftDelete == 'Y'}">
                                <a href="/organizationDelete/${organization1.organizationUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
        <br/><br/>
    </div>
</body>
</html>