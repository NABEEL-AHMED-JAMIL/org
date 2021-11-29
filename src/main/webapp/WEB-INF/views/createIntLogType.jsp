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
        <h2>New IntLogType</h2>
        <c:if test="${isIntLogLevelTypeAccess.permissionCreate == 'Y'}">
            <form:form action="createIntLogType" method="post" modelAttribute="intLogType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntLogType Name: </td>
                        <td>
                            <td><form:input path="intLogTypeName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntLogType Desc: </td>
                        <td>
                            <td><form:input path="intLogTypeDescription" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntLogType ShortDesc: </td>
                        <td>
                            <td><form:input path="intLogTypeShortDescription" required="required"/></td>
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
        <h1>IntLogType</h1>
        <form:form action="intLogTypeSearch" method="post" modelAttribute="intLogTypeSearch">
            <table border="0" cellpadding="6">
                <tr>
	                <td>
                        <form:textarea path="intLogTypeId" placeholder="Enter intLogTypeId"/>
                    </td>
	                <td>
                        <form:textarea path="intLogTypeUuid" placeholder="Enter intLogTypeUuid"/>
                    </td>
	                <td>
                        <form:textarea path="intLogTypeName" placeholder="Enter intLogTypeName"/>
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
                    <th>IntLogType Id</th>
                    <th>IntLogType Uuid</th>
                    <th>IntLogType Name</th>
                    <th>IntLogType Description</th>
                    <th>IntLogType ShortDescription</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intLogTypeList}" var="intLogType">
                    <tr>
                        <td>${intLogType.intLogTypeId}</td>
                        <td>${intLogType.intLogTypeUuid}</td>
                        <td>${intLogType.intLogTypeName}</td>
                        <td>${intLogType.intLogTypeDescription}</td>
                        <td>${intLogType.intLogTypeShortDescription}</td>
                        <td>${intLogType.updatedDts}</td>
                        <td>${intLogType.updatedBy}</td>
                        <td>${intLogType.createdDts}</td>
                        <td>${intLogType.createdBy}</td>
                        <td>${intLogType.activeStatus}</td>
                        <td>
                            <c:if test="${isIntLogLevelTypeAccess.permissionUpdate == 'Y'}">
                                <a href="/intLogTypeEdit/${intLogType.intLogTypeUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntLogLevelTypeAccess.permissionSoftDelete == 'Y'}">
                                <a href="/intLogTypeDelete/${intLogType.intLogTypeUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>