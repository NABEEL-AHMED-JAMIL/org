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
            <c:if test="${isResourceAccess == true}">
                <a href="/createResource">Create Resource</a>&nbsp;
            </c:if>
            <c:if test="${isResourceTypeAccess == true}">
                <a href="/createResourceType">Create ResourceType</a>&nbsp;
            </c:if>
            <c:if test="${isResourceModuleAccess == true}">
                <a href="/createResourceModuleLink1">Create ResourceModule</a>&nbsp;
            </c:if>
            <a href="/index">Back</a>&nbsp;
        </div>
    </body>
</html>
