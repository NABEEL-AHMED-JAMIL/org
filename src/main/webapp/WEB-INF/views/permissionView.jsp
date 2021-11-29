<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       <meta charset="utf-8"/>
       <title>Product Manager</title>
    </head>
    <body>
        <div align="center">
            <h1>Org Project</h1>
            <c:if test="${isPermissionAccess == true}">
                <a href="/createPermission">Create Permission</a>&nbsp;
            </c:if>
            <c:if test="${isPermissionTypeAccess == true}">
                <a href="/createPermissionType">Create PermissionType</a>&nbsp;
            </c:if>
            <c:if test="${isPermissionResourceModuleAccess == true}">
                 <a href="/createPermissionResourceModule">Create PermissionResourceModule</a>&nbsp;
            </c:if>
            <a href="/index">Back</a>&nbsp;
        </div>
    </body>
</html>
