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
        <h2>New Group</h2>
        <c:if test="${isGroupsAccess.permissionCreate == 'Y'}">
            <form:form action="createGroups" method="post" modelAttribute="group">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Group Name: </td>
                        <td><form:input path="groupName" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Group ShortName: </td>
                        <td><form:input path="groupShortName" required="required"/></td>
                    </tr>

                    <tr>
                        <td>Group Desc: </td>
                        <td><form:input path="groupDesc" required="required"/></td>
                    </tr>
                    <tr>
                        <td>CreatedBy: </td>
                        <td>
                            <form:select path="createdBy">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="/userdetail">Back</a>&nbsp;
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
        <h3>Groups List</h3>
        <form:form action="groupSearch" method="post" modelAttribute="groupSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="groupId" placeholder="Enter groupId"/>
                    </td>

                    <td>
                        <form:textarea path="groupUuid" placeholder="Enter groupUuid"/>
                    </td>

                    <td>
                        <form:textarea path="groupName" placeholder="Enter groupName"/>
                    </td>

                    <td>
                        <form:textarea path="groupShortName" placeholder="Enter groupShortName"/>
                    </td>

                    <td>
                        <form:textarea path="groupDesc" placeholder="Enter groupDesc"/>
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
                    <th>GroupId</th>
                    <th>GroupUuid</th>
                    <th>GroupName</th>
                    <th>GroupShortName</th>
                    <th>GroupDesc</th>
                    <th>UpdatedDts</th>
                    <th>UpdatedBy</th>
                    <th>CreatedDts</th>
                    <th>CreatedBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${groupList}" var="group">
                    <tr>
                        <td>${group.groupId}</td>
                        <td>${group.groupUuid}</td>
                        <td>${group.groupName}</td>
                        <td>${group.groupShortName}</td>
                        <td>${group.groupDesc}</td>
                        <td>${group.updatedBy}</td>
                        <td>${group.updatedDts}</td>
                        <td>${group.createdDts}</td>
                        <td>${group.createdBy}</td>
                        <td>${group.activeStatus}</td>
                        <td>
                            <c:if test="${isGroupsAccess.permissionUpdate  == 'Y'}">
                                <a href="/groupsEdit/${group.groupUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isGroupsAccess.permissionSoftDelete  == 'Y'}">
                                <a href="/groupsDelete/${group.groupUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>


    </div>
</body>
</html>