<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
    <div align="center">
        <h2>Login</h2>
        <form:form action="/loginProcess" method="post" modelAttribute="jwtAuthenticationRequest">
            <table border="0" cellpadding="6">
                <tr>
                    <td>Username: </td>
                    <td><form:input path="username" required="required"/></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:input path="password" required="required"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>