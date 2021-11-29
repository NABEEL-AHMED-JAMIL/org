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
        <h2>New IntEnvType</h2>
        <c:if test="${isIntEnvTypeAccess.permissionCreate == 'Y'}">
            <form:form action="createIntEnvType" method="post" modelAttribute="intEnvType">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntEnvType Name: </td>
                        <td>
                            <td><form:input path="intEnvTypeName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntEnvType Desc: </td>
                        <td>
                            <td><form:input path="intEnvTypeDescription" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntEnvType ShortDesc: </td>
                        <td>
                            <td><form:input path="intEnvTypeShortDescription" required="required"/></td>
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
        <h1>IntEnvType</h1>
        <form:form action="intEnvTypeSearch" method="post" modelAttribute="intEnvTypeSearch">
            <table border="0" cellpadding="6">
                <tr>
	                <td>
                        <form:textarea path="intEnvTypeId" placeholder="Enter intEnvTypeId"/>
                    </td>
	                <td>
                        <form:textarea path="intEnvTypeUuid" placeholder="Enter intEnvTypeUuid"/>
                    </td>
	                <td>
                        <form:textarea path="intEnvTypeName" placeholder="Enter intEnvTypeName"/>
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
                    <th>IntEnvType Id</th>
                    <th>IntEnvType Uuid</th>
                    <th>IntEnvType Name</th>
                    <th>IntEnvType Description</th>
                    <th>IntEnvType ShortDescription</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intEnvTypeList}" var="intEnvType">
                    <tr>
                        <td>${intEnvType.intEnvTypeId}</td>
                        <td>${intEnvType.intEnvTypeUuid}</td>
                        <td>${intEnvType.intEnvTypeName}</td>
                        <td>${intEnvType.intEnvTypeDescription}</td>
                        <td>${intEnvType.intEnvTypeShortDescription}</td>
                        <td>${intEnvType.updatedDts}</td>
                        <td>${intEnvType.updatedBy}</td>
                        <td>${intEnvType.createdDts}</td>
                        <td>${intEnvType.createdBy}</td>
                        <td>${intEnvType.activeStatus}</td>
                        <td>
                            <c:if test="${isIntEnvTypeAccess.permissionUpdate == 'Y'}">
                                <a href="/intEnvTypeEdit/${intEnvType.intEnvTypeUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntEnvTypeAccess.permissionSoftDelete == 'Y'}">
                                <a href="/intEnvTypeDelete/${intEnvType.intEnvTypeUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>