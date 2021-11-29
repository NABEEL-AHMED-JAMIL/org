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
        <h2>New IntType</h2>
           <c:if test="${isIntTypeAccess.permissionCreate == 'Y'}">
            <form:form action="createIntType" method="post" modelAttribute="intType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntType Name: </td>
                        <td><form:input path="intTypeName" required="required"/></td>
                    </tr>
                    <tr>
                        <td>IntType ShortDescription: </td>
                        <td><form:input path="intTypeShortDescription" required="required"/></td>
                    </tr>
                    <tr>
                        <td>IntType Description: </td>
                        <td><form:input path="intTypeDescription" required="required"/></td>
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
        <h1>IntType</h1>
        <form:form action="intTypeSearch" method="post" modelAttribute="intTypeSearch">
        	<table border="0" cellpadding="6">
        		<tr>
        			<td>
        				<form:textarea path="intTypeId" placeholder="Enter intTypeId"/>
        			</td>
        			<td>
        				<form:textarea path="intTypeUuid" placeholder="Enter intTypeUuid"/>
        			</td>
        			<td>
        				<form:textarea path="intTypeName" placeholder="Enter intTypeName"/>
        			</td>
        			<td>
        				<form:textarea path="intTypeShortDescription" placeholder="Enter intTypeShortDescription"/>
        			</td>
        			<td>
        				<form:textarea path="intTypeDescription" placeholder="Enter intTypeDescription"/>
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
                    <th>IntType Id</th>
                    <th>IntType Uuid</th>
                    <th>IntType Name</th>
                    <th>IntType ShortDescription</th>
                    <th>IntType Description</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intTypeList}" var="intType">
                    <tr>
                        <td>${intType.intTypeId}</td>
                        <td>${intType.intTypeUuid}</td>
                        <td>${intType.intTypeName}</td>
                        <td>${intType.intTypeShortDescription}</td>
                        <td>${intType.intTypeDescription}</td>
                        <td>${intType.updatedDts}</td>
                        <td>${intType.updatedBy}</td>
                        <td>${intType.createdDts}</td>
                        <td>${intType.createdBy}</td>
                        <td>${intType.activeStatus}</td>
                        <td>
                            <c:if test="${isIntTypeAccess.permissionUpdate == 'Y'}">
                                <a href="/intTypeEdit/${intType.intTypeUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntTypeAccess.permissionSoftDelete == 'Y'}">
                                <a href="/intTypeDelete/${intType.intTypeUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>