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
        <h2>New IntParams</h2>
        <c:if test="${isIntParamsAccess.permissionCreate == 'Y'}">
            <form:form action="createIntParams" method="post" modelAttribute="intParams">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntParams Name: </td>
                        <td><form:input path="intParamsName" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntParams Value: </td>
                        <td><form:input path="intParamsValue" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntParams TypeId: </td>
                        <td>
                            <form:select path="intParamsTypeId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intTypeIds}" />
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>IntParams TypeuuId: </td>
                        <td>
                            <form:select path="intParamsTypeuuId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intTypeUuids}" />
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>IntParams Label: </td>
                        <td><form:input path="intParamsLabel" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntParams ParamTypeId: </td>
                        <td><form:input path="intParamsParamTypeId" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntParams ParamTypeuuid: </td>
                        <td><form:input path="intParamsParamTypeuuid" required="required"/></td>
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
        <h1>IntParams</h1>
         <form:form action="intParamsSearch" method="post" modelAttribute="intParamsSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="intParamsId" placeholder="Enter intParamsId"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsUuid" placeholder="Enter intParamsUuid"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsName" placeholder="Enter intParamsName"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsValue" placeholder="Enter intParamsValue"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsTypeId" placeholder="Enter intParamsTypeId"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsTypeuuId" placeholder="Enter intParamsTypeuuId"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsLabel" placeholder="Enter intParamsLabel"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intParamsParamTypeId" placeholder="Enter intParamsParamTypeId"/>
                    </td>

                    <td>
                        <form:textarea path="intParamsParamTypeuuid" placeholder="Enter intParamsParamTypeuuid"/>
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
                    <th>IntParams Id</th>
                    <th>IntParams Uuid</th>
                    <th>IntParams Name</th>
                    <th>IntParams Value</th>
                    <th>IntParams TypeId</th>
                    <th>IntParams TypeuuId</th>
                    <th>IntParams Label</th>
                    <th>IntParams ParamTypeId</th>
                    <th>IntParams ParamTypeuuid</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${intParamsList}" var="intParams">
                    <tr>
                        <td>${intParams.intParamsId}</td>
                        <td>${intParams.intParamsUuid}</td>
                        <td>${intParams.intParamsName}</td>
                        <td>${intParams.intParamsValue}</td>
                        <td>${intParams.intParamsTypeId}</td>
                        <td>${intParams.intParamsTypeuuId}</td>
                        <td>${intParams.intParamsLabel}</td>
                        <td>${intParams.intParamsParamTypeId}</td>
                        <td>${intParams.intParamsParamTypeuuid}</td>
                        <td>${intParams.updatedDts}</td>
                        <td>${intParams.updatedBy}</td>
                        <td>${intParams.createdDts}</td>
                        <td>${intParams.createdBy}</td>
                        <td>${intParams.activeStatus}</td>
                        <td>
                            <c:if test="${isIntParamsAccess.permissionUpdate == 'Y'}">
                                <a href="/intParamsEdit/${intParams.intParamsUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntParamsAccess.permissionSoftDelete ae == 'Y'}">
                                <a href="/intParamsDelete/${intParams.intParamsUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>