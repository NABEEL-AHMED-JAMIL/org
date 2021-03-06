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
        <h2>New IntCmdParam</h2>
        <c:if test="${isIntCmdParamAccess.permissionCreate == 'Y'}">
            <form:form action="createIntCmdParam" method="post" modelAttribute="intCmdParam">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntCmdParam IntCmdUuid: </td>
                        <td>
                            <form:select path="intCmdParamIntCmdUuid">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intCmdUuids}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>IntCmdParam IntCmdId: </td>
                        <td>
                            <form:select path="intCmdParamIntCmdId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intCmdIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>IntCmdParam Name: </td>
                        <td><form:input path="intCmdParamName" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntCmdParam Defaultvalue: </td>
                        <td><form:input path="intCmdParamDefaultvalue" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntCmdParam Description: </td>
                        <td><form:input path="intCmdParamDescription" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntCmdParam Shortdescription: </td>
                        <td><form:input path="intCmdParamShortdescription" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntCmd ParamPosition: </td>
                        <td><form:input path="intCmdParamPosition" required="required"/></td>
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
        <h1>IntCmdParam</h1>

        <form:form action="intCmdParamSearch" method="post" modelAttribute="intCmdParamSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="intCmdParamId" placeholder="Enter intCmdParamId"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamUuid" placeholder="Enter intCmdParamUuid"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamIntCmdUuid" placeholder="Enter intCmdParamIntCmdUuid"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamIntCmdId" placeholder="Enter intCmdParamIntCmdId"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamName" placeholder="Enter intCmdParamName"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamDefaultvalue" placeholder="Enter intCmdParamDefaultvalue"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamDescription" placeholder="Enter intCmdParamDescription"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intCmdParamShortdescription" placeholder="Enter intCmdParamShortdescription"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdParamPosition" placeholder="Enter intCmdParamPosition"/>
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
                    <th>IntCmdParam Id</th>
                    <th>IntCmdParam Uuid</th>
                    <th>IntCmdParam IntCmdUuid</th>
                    <th>IntCmdParam IntCmdId</th>
                    <th>IntCmdParam Name</th>
                    <th>IntCmdParam Defaultvalue</th>
                    <th>IntCmdParam Description</th>
                    <th>IntCmdParam Shortdescription</th>
                    <th>IntCmdParam Position</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intCmdParamList}" var="intCmdParam">
                    <tr>
                        <td>${intCmdParam.intCmdParamId}</td>
                        <td>${intCmdParam.intCmdParamUuid}</td>
                        <td>${intCmdParam.intCmdParamIntCmdUuid}</td>
                        <td>${intCmdParam.intCmdParamIntCmdId}</td>
                        <td>${intCmdParam.intCmdParamName}</td>
                        <td>${intCmdParam.intCmdParamDefaultvalue}</td>
                        <td>${intCmdParam.intCmdParamDescription}</td>
                        <td>${intCmdParam.intCmdParamShortdescription}</td>
                        <td>${intCmdParam.intCmdParamPosition}</td>
                        <td>${intCmdParam.updatedDts}</td>
                        <td>${intCmdParam.updatedBy}</td>
                        <td>${intCmdParam.createdDts}</td>
                        <td>${intCmdParam.createdBy}</td>
                        <td>${intCmdParam.activeStatus}</td>
                        <td>
                            <c:if test="${isIntCmdParamAccess.permissionUpdate == 'Y'}">
                                <a href="/intCmdParamEdit/${intCmdParam.intCmdParamUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                             <c:if test="${isIntCmdParamAccess.permissionSoftDelete == 'Y'}">
                                <a href="/intCmdParamDelete/${intCmdParam.intCmdParamUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>