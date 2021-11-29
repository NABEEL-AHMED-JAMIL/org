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
        <h2>Resource Module</h2>
        <c:if test="${isResourceModuleAccess.permissionCreate == 'Y'}">
            <form:form action="createResourceModuleLink1" method="post" modelAttribute="resourceModule">
                <table border="0" cellpadding="5">
                    <tr>
                        <td>Organization Uuid: </td>
                        <td>
                            <form:select path="resourceUuid">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${resourceIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>ModuleLookup Uuid: </td>
                        <td>
                            <form:select path="moduleUuid">
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
        <br><br>
        <h3>Resource Module</h3>
        <form:form action="resourceModuleSearch" method="post" modelAttribute="resourceModuleSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="resourceModuleId" placeholder="Enter ResourceModule Id"/>
                    </td>
                    <td>
                        <form:textarea path="resourceModuleUuid" placeholder="Enter ResourceModule Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="resourceUuid" placeholder="Enter Resource Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="moduleUuid" placeholder="Enter Module Uuid"/>
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
                    <th>ResourceModule Id</th>
                    <th>ResourceModule Uuid</th>
                    <th>Resource Uuid</th>
                    <th>Module Uuid</th>
                    <th>Created By</th>
                    <th>Created Date</th>
                    <th>Active Status</th>
                    <th>Updated Date</th>
                    <th>Updated By</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${resourceModuleList}" var="resourceModule">
                    <tr>
                        <td>${resourceModule.resourceModuleId}</td>
                        <td>${resourceModule.resourceModuleUuid}</td>
                        <td>${resourceModule.resourceUuid}</td>
                        <td>${resourceModule.moduleUuid}</td>
                        <td>${resourceModule.createdBy}</td>
                        <td>${resourceModule.createdDts}</td>
                        <td>${resourceModule.activeStatus}</td>
                        <td>${resourceModule.updatedDts}</td>
                        <td>${resourceModule.updatedBy}</td>
                        <td>
                            <c:if test="${isResourceModuleAccess.permissionUpdate == 'Y'}">
                                <a href="/resourceModuleLinkEdit/${resourceModule.resourceModuleUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isResourceModuleAccess.permissionSoftDelete == 'Y'}">
                                <a href="/resourceModuleLinkDelete/${resourceModule.resourceModuleUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>