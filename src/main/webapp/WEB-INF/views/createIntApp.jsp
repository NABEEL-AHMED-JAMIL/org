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
        <h2>New IntApp</h2>
        <c:if test="${isIntAppAccess.permissionCreate == 'Y'}">
            <form:form action="createIntApp" method="post" modelAttribute="intApp">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntApp Name: </td>
                        <td>
                            <td><form:input path="intAppName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntApp Desc: </td>
                        <td>
                            <td><form:input path="intAppDesc" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntApp OrgId: </td>
                        <td>
                            <form:select path="intAppOrgId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${orgID}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>IntApp OrgUUId: </td>
                        <td>
                            <form:select path="intAppOrgUUId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${orgUUID}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>IntApp ShortDesc: </td>
                        <td>
                            <td><form:input path="intAppShortDesc" required="required"/></td>
                        </td>
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
                            <a href="/int">Back</a>&nbsp;
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
        <h1>IntApp</h1>
        <form:form action="intAppSearch" method="post" modelAttribute="intAppSearch">
            <table border="0" cellpadding="6">
                <tr>
	                <td>
                        <form:textarea path="intAppId" placeholder="Enter intAppId"/>
                    </td>
	                <td>
                        <form:textarea path="intAppUuId" placeholder="Enter intAppUuId"/>
                    </td>
	                <td>
                        <form:textarea path="intAppName" placeholder="Enter intAppName"/>
                    </td>
	                <td>
                        <form:textarea path="intAppOrgId" placeholder="Enter intAppOrgId"/>
                    </td>
	                <td>
                        <form:textarea path="intAppOrgUUId" placeholder="Enter intAppOrgUUId"/>
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
                    <th>IntApp Id</th>
                    <th>IntApp UuId</th>
                    <th>IntApp Name</th>
                    <th>IntApp Desc</th>
                    <th>IntApp OrgId</th>
                    <th>IntApp OrgUUId</th>
                    <th>IntApp ShortDesc</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intAppList}" var="intApp">
                    <tr>
                        <td>${intApp.intAppId}</td>
                        <td>${intApp.intAppUuId}</td>
                        <td>${intApp.intAppName}</td>
                        <td>${intApp.intAppDesc}</td>
                        <td>${intApp.intAppOrgId}</td>
                        <td>${intApp.intAppOrgUUId}</td>
                        <td>${intApp.intAppShortDesc}</td>
                        <td>${intApp.updatedDts}</td>
                        <td>${intApp.updatedBy}</td>
                        <td>${intApp.createdDts}</td>
                        <td>${intApp.createdBy}</td>
                        <td>${intApp.activeStatus}</td>
                        <td>
                            <c:if test="${isIntAppAccess.permissionUpdate == 'Y'}">
                                <a href="/intAppEdit/${intApp.intAppUuId}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntAppAccess.permissionSoftDelete == 'Y'}">
                                <a href="/intAppDelete/${intApp.intAppUuId}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>