<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       <meta charset="utf-8"/>
       <title>Product Manager</title>
    </head>
    <style>
        a.disabled {
          pointer-events: none;
          cursor: default;
        }
    </style>
    <body>
        <div align="center">
            <h1>Org Project</h1>
            <c:if test="${isOrganizationAccess == true}">
                <a href="/organization">Organization Page</a>&nbsp;
            </c:if>
            <c:if test="${isResourceAccess == true}">
                <a href="/resource">Resource Page</a>&nbsp;
            </c:if>
            <c:if test="${isPermissionAccess == true}">
                <a href="/permissionView">Permission View</a>&nbsp;
            </c:if>
            <c:if test="${isUserAccess == true}">
                <a href="/userdetail">User Detail</a>&nbsp;
            </c:if>
            <c:if test="${isIntAccess == true}">
                <a href="/int">Int Detail</a>&nbsp;
            </c:if>
        </div>
    </body>
</html>