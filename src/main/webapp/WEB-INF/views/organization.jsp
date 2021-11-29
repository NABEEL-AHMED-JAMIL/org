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
            <c:if test="${isOrganizationAccess == true}">
                <a href="/createOrganization">Create Organization</a>&nbsp;
            </c:if>
            <c:if test="${isModuleAccess == true}">
                <a href="/createModule">Create Module</a>&nbsp;
            </c:if>
            <c:if test="${isOrganizationModuleLinkAccess == true}">
                <a href="/createOrganizationModuleLink">Create Organization-Module Link</a>&nbsp;
            </c:if>
            <c:if test="${isOrganizationDepartmentAccess == true}">
                <a href="/createOrganizationDepartment">Create Organization Department</a>&nbsp;
            </c:if>
           <a href="/index">Back</a>&nbsp;
        </div>
    </body>
</html>