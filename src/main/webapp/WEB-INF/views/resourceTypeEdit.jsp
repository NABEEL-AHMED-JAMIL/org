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
        <h2>New ResourceType</h2>
        <c:if test="${isResourceTypeAccess.permissionUpdate eq 'Y'}">
            <form:form action="/resourceTypeEdit/${resourceTypeUuid}" method="post" modelAttribute="resourceType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Name: </td>
                        <td><form:input path="resourceTypeName" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Short Description: </td>
                        <td><form:input path="resourceTypeDesc" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Updated By: </td>
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
                        <td colspan="2"><input type="submit" value="Save"></td>
                    </tr>
                </table>
            </form:form>
        </c:if>
    </div>
</body>
</html>