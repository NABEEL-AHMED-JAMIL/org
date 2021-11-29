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
        <h2>Edit IntLogLevelType</h2>
        <c:if test="${isIntLogLevelTypeAccess.permissionUpdate == 'Y'}">
            <form:form action="/intLogLevelTypeEdit/${intLogLevelType.intLogLevelTypeUuid}" method="post" modelAttribute="intLogLevelType">
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
                        <td>Updated By</td>
                        <td>
                            <form:select path="updatedBy">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Active Status: </td>
                        <td>
                            <form:select path="activeStatus">
                               <form:option value="Y" label="Yes"/>
                              <form:option value="N" label="No"/>
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
    </div>
</body>
</html>