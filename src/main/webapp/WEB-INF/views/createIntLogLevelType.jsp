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
        <h2>New IntLogLevelType</h2>
        <c:if test="${isIntLogLevelTypeAccess.permissionCreate == 'Y'}">
            <form:form action="createIntLogLevelType" method="post" modelAttribute="intLogLevelType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntLogLevelType Name: </td>
                        <td>
                            <td><form:input path="intLogLevelTypeName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntLogLevelType Desc: </td>
                        <td>
                            <td><form:input path="intLogLevelTypeDescription" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntLogLevelType ShortDesc: </td>
                        <td>
                            <td><form:input path="intLogLevelTypeShortDescription" required="required"/></td>
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
        <h1>IntEnvType</h1>
        <form:form action="intLogLevelTypeSearch" method="post" modelAttribute="intLogLevelTypeSearch">
            <table border="0" cellpadding="6">
                <tr>
	                <td>
                        <form:textarea path="intLogLevelTypeId" placeholder="Enter intLogLevelTypeId"/>
                    </td>
	                <td>
                        <form:textarea path="intLogLevelTypeUuid" placeholder="Enter intLogLevelTypeUuid"/>
                    </td>
	                <td>
                        <form:textarea path="intLogLevelTypeName" placeholder="Enter intLogLevelTypeName"/>
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
                    <th>IntLogLevelType Id</th>
                    <th>IntLogLevelType Uuid</th>
                    <th>IntLogLevelType Name</th>
                    <th>IntLogLevelType Description</th>
                    <th>IntLogLevelType ShortDescription</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intLogTypeList}" var="intLogLevelType">
                    <tr>
                        <td>${intLogLevelType.intLogLevelTypeId}</td>
                        <td>${intLogLevelType.intLogLevelTypeUuid}</td>
                        <td>${intLogLevelType.intLogLevelTypeName}</td>
                        <td>${intLogLevelType.intLogLevelTypeDescription}</td>
                        <td>${intLogLevelType.intLogLevelTypeShortDescription}</td>
                        <td>${intLogLevelType.updatedDts}</td>
                        <td>${intLogLevelType.updatedBy}</td>
                        <td>${intLogLevelType.createdDts}</td>
                        <td>${intLogLevelType.createdBy}</td>
                        <td>${intLogLevelType.activeStatus}</td>
                        <td>
                            <c:if test="${isIntLogLevelTypeAccess.permissionUpdate  == 'Y'}">
                                <a href="/intLogLevelTypeEdit/${intLogLevelType.intLogLevelTypeUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntLogLevelTypeAccess.permissionSoftDelete  == 'Y'}">
                                <a href="/intLogLevelTypeDelete/${intLogLevelType.intLogLevelTypeUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>