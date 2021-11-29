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
        <h2>New Module</h2>
        <c:if test="${isModuleAccess.permissionCreate == 'Y'}">
            <form:form action="createModule" method="post" modelAttribute="modulesLookup">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>LookupNumber: </td>
                        <td><form:input path="modulesLookupNumber" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Lookup Name: </td>
                        <td><form:input path="modulesLookupName" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Short Description: </td>
                        <td><form:input path="modulesLookupShortDescription" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><form:input path="modulesLookupDescription" required="required"/></td>
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
        <br><br>
        <h3>Module List</h3>
        <form:form action="moduleSearch" method="post" modelAttribute="moduleSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="modulesLookupId" placeholder="Enter ModulesLookup Id"/>
                    </td>
                    <td>
                        <form:textarea path="modulesLookupUuid" placeholder="Enter ModulesLookup Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="modulesLookupNumber" placeholder="Enter ModulesLookup Number"/>
                    </td>
                    <td>
                        <form:textarea path="modulesLookupName" placeholder="Enter ModulesLookup Name"/>
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
                    <th>Number</th>
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
                 <c:forEach items="${moduleLookupList}" var="modulesLookup">
                    <tr>
                        <td>${modulesLookup.modulesLookupId}</td>
                        <td>${modulesLookup.modulesLookupUuid}</td>
                        <td>${modulesLookup.modulesLookupNumber}</td>
                        <td>${modulesLookup.modulesLookupName}</td>
                        <td>${modulesLookup.modulesLookupShortDescription}</td>
                        <td>${modulesLookup.modulesLookupDescription}</td>
                        <td>${modulesLookup.createdBy}</td>
                        <td>${modulesLookup.createdDts}</td>
                        <td>${modulesLookup.activeStatus}</td>
                        <td>${modulesLookup.updatedDts}</td>
                        <td>${modulesLookup.updatedBy}</td>
                        <td>
                            <c:if test="${isModuleAccess.permissionUpdate == 'Y'}">
                                <a href="/moduleEdit/${modulesLookup.modulesLookupUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isModuleAccess.permissionSoftDelete == 'Y'}">
                                <a href="/modulesDelete/${modulesLookup.modulesLookupUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>