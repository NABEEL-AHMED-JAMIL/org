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
            <h1>Int Project</h1>
            <c:if test="${isIntCmdImpAccess == true}">
                <a href="/createIntCmdImp">Create IntCmdImp</a>&nbsp;
            </c:if>
            <c:if test="${isIntCmdParamAccess == true}">
                <a href="/createIntCmdParam">Create IntCmdParam</a>&nbsp;
            </c:if>
            <c:if test="${isIntCmdAccess == true}">
                <a href="/createIntCmd">Create IntCmd</a>&nbsp;
            </c:if>
            <c:if test="${isIntParamsAccess == true}">
                <a href="/createIntParams">Create IntParams</a>&nbsp;
            </c:if>
            <c:if test="${isIntTypeAccess == true}">
                <a href="/createIntType">Create IntType</a>&nbsp;
            </c:if>
            <c:if test="${isIntAppAccess == true}">
                <a href="/createIntApp">Create IntApp</a>&nbsp;
            </c:if>
            <c:if test="${isIntEnvTypeAccess == true}">
                <a href="/createIntEnvType">Create IntEnvType</a>&nbsp;
            </c:if>
            <c:if test="${isIntTransAccess == true}">
                <a href="/createIntTrans">Create IntTrans</a>&nbsp;
            </c:if>
            <c:if test="${isIntLogTypeAccess == true}">
                <a href="/createIntLogType">Create IntLogType</a>&nbsp;
            </c:if>
            <c:if test="${isIntLogLevelTypeAccess == true}">
                <a href="/createIntLogLevelType">Create IntLogLevelType</a>&nbsp;
            </c:if>
            <a href="/index">Back</a>&nbsp;
        </div>
    </body>
</html>
