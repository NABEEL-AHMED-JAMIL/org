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
        <h2>New IntCmdImp</h2>
        <c:if test="${isIntCmdImpAccess.permissionCreate == 'Y'}">
            <form:form action="createIntCmdImp" method="post" modelAttribute="intCmdImp">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntCmdImp IntCmdId: </td>
                        <td>
                            <form:select path="intCmdImpIntCmdId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intCmdIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>IntCmdImp IntCmdUuid: </td>
                        <td>
                            <form:select path="intCmdImpIntCmdUuid">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intCmdUuids}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>IntCmdImp IntCmdParamId: </td>
                        <td>
                            <form:select path="intCmdImpIntCmdParamId">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intCmdParamIds}" />
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>IntCmdImp IntCmdParamUuid: </td>
                        <td>
                            <form:select path="intCmdImpIntCmdParamUuid">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${intCmdParamUuids}" />
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>IntCmdImp IntCmdParamValue: </td>
                        <td><form:input path="intCmdImpIntCmdParamValue" required="required"/></td>
                    </tr>

                    <tr>
                        <td>IntCmdImp UserUuid: </td>
                        <td>
                            <form:select path="intCmdImpUserUuid">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userUUIDs}" />
                            </form:select>
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
        <br/><br/>
        <h1>IntCmdImp</h1>
        <form:form action="intCmdImpSearch" method="post" modelAttribute="intCmdImpSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="intCmdImpId" placeholder="Enter intCmdImpId"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdImpUuid" placeholder="Enter intCmdImpUuid"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdImpIntCmdId" placeholder="Enter intCmdImpIntCmdId"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdImpIntCmdUuid" placeholder="Enter intCmdImpIntCmdUuid"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdImpIntCmdParamId" placeholder="Enter intCmdImpIntCmdParamId"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdImpIntCmdParamUuid" placeholder="Enter intCmdImpIntCmdParamUuid"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intCmdImpIntCmdParamValue" placeholder="Enter intCmdImpIntCmdParamValue"/>
                    </td>

                    <td>
                        <form:textarea path="intCmdImpUserUuid" placeholder="Enter intCmdImpUserUuid"/>
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
                    <th>IntCmdImp Id</th>
                    <th>IntCmdImp Uuid</th>
                    <th>IntCmdImp IntCmdId</th>
                    <th>IntCmdImp IntCmdUuid</th>
                    <th>IntCmdImp IntCmdParamId</th>
                    <th>IntCmdImp IntCmdParamUuid</th>
                    <th>IntCmdImp IntCmdParamValue</th>
                    <th>IntCmdImp UserUuid</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
             <c:forEach items="${intCmdImpList}" var="intCmdImp">
                <tr>
                    <td>${intCmdImp.intCmdImpId}</td>
                    <td>${intCmdImp.intCmdImpUuid}</td>
                    <td>${intCmdImp.intCmdImpIntCmdId}</td>
                    <td>${intCmdImp.intCmdImpIntCmdUuid}</td>
                    <td>${intCmdImp.intCmdImpIntCmdParamId}</td>
                    <td>${intCmdImp.intCmdImpIntCmdParamUuid}</td>
                    <td>${intCmdImp.intCmdImpIntCmdParamValue}</td>
                    <td>${intCmdImp.intCmdImpUserUuid}</td>
                    <td>${intCmdImp.updatedDts}</td>
                    <td>${intCmdImp.updatedBy}</td>
                    <td>${intCmdImp.createdDts}</td>
                    <td>${intCmdImp.createdBy}</td>
                    <td>${intCmdImp.activeStatus}</td>
                    <td>
                        <c:if test="${isIntCmdImpAccess.permissionUpdate == 'Y'}">
                        <a href="/intCmdImpEdit/${intCmdImp.intCmdImpUuid}">Edit</a>
                        </c:if>
                        &nbsp;&nbsp;&nbsp;
                        <c:if test="${isIntCmdImpAccess.permissionSoftDelete == 'Y'}">
                        <a href="/intCmdImpDelete/${intCmdImp.intCmdImpUuid}">Delete</a>
                        </c:if>
                    </td>
                </tr>
             </c:forEach>
        </tbody>
        </table>


    </div>
</body>
</html>