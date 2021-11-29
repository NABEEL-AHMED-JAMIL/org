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
        <h2>New Resource</h2>
        <c:if test="${isResourceAccess.permissionCreate == 'Y'}">
            <form:form action="createResource" method="post" modelAttribute="resource">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>Name: </td>
                        <td><form:input path="resourceName" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Type: </td>
                        <td><form:input path="resourceType" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><form:input path="resourceDesc" required="required"/></td>
                    </tr>
                    <tr>
                        <td>VersionNumber: </td>
                        <td><form:input path="resourceVersionNumber" required="required"/></td>
                    </tr>
                    <tr>
                        <td>TypeDesc: </td>
                        <td><form:input path="resourceTypeDesc" required="required"/></td>
                    </tr>
                    <tr>
                        <td>AvailableIndicator: </td>
                        <td><form:input path="resourceAvailableIndicator" required="required"/></td>
                    </tr>
                    <tr>
                        <td>ParentId: </td>
                        <td><form:input path="resourceParentId" required="required"/></td>
                    </tr>
                    <tr>
                        <td>AuthUserId: </td>
                        <td><form:input path="resourceAuthUserId" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Resource ResourceTypeUuid: </td>
                        <td>
                            <form:select path="resourceResourceTypeUuid">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${resourceTypeIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Created By: </td>
                        <td>
                            <form:select path="createdBy">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="/resource">Back</a>&nbsp;
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
        <h3>Resource List</h3>
        <form:form action="resourceSearch" method="post" modelAttribute="resourceSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="resourceId" placeholder="Enter Resource Id"/>
                    </td>
                    <td>
                        <form:textarea path="resourceUuid" placeholder="Enter Resource Uuid"/>
                    </td>
                    <td>
                        <form:textarea path="resourceName" placeholder="Enter Resource Name"/>
                    </td>
                    <td>
                        <form:textarea path="resourceType" placeholder="Enter Resource Type"/>
                    </td>
                    <td>
                        <form:textarea path="resourceDesc" placeholder="Enter Resource Desc"/>
                    </td>
                    <td>
                        <form:textarea path="resourceTypeDesc" placeholder="Enter ResourceType Desc"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="resourceVersionNumber" placeholder="Enter ResourceVersion Number"/>
                    </td>
                    <td>
                        <form:textarea path="resourceAvailableIndicator" placeholder="Enter ResourceAvailable Indicator"/>
                    </td>
                    <td>
                        <form:textarea path="resourceParentId" placeholder="Enter ResourceParent Id"/>
                    </td>
                    <td>
                        <form:textarea path="resourceAuthUserId" placeholder="Enter ResourceAuthUser Id"/>
                    </td>
                    <td>
                        <form:textarea path="resourceResourceTypeUuid" placeholder="Enter ResourceTypeUuid Id"/>
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
                    <th>Resource ID</th>
                    <th>Resource Uuid</th>
                    <th>Resource Name</th>
                    <th>Resource Type</th>
                    <th>Resource Description</th>
                    <th>Resource Type Description</th>
                    <th>Resource Version Number</th>
                    <th>Resource Available Indicator</th>
                    <th>ParentId</th>
                    <th>AuthUserId: </th>
                    <th>ResourceTypeUuid</th>
                    <th>Created By</th>
                    <th>Created Date</th>
                    <th>Active Status</th>
                    <th>Updated Date</th>
                    <th>Updated By</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                 <c:forEach items="${resourceList}" var="resource">
                    <tr>
                        <td>${resource.resourceId}</td>
                        <td>${resource.resourceUuid}</td>
                        <td>${resource.resourceName}</td>
                        <td>${resource.resourceType}</td>
                        <td>${resource.resourceDesc}</td>
                        <td>${resource.resourceTypeDesc}</td>
                        <td>${resource.resourceVersionNumber}</td>
                        <td>${resource.resourceAvailableIndicator}</td>
                        <td>${resource.resourceParentId}</td>
                        <td>${resource.resourceAuthUserId}</td>
                        <td>${resource.resourceResourceTypeUuid}</td>
                        <td>${resource.createdBy}</td>
                        <td>${resource.createdDts}</td>
                        <td>${resource.activeStatus}</td>
                        <td>${resource.updatedDts}</td>
                        <td>${resource.updatedBy}</td>
                        <td>
                            <c:if test="${isResourceAccess.permissionUpdate == 'Y'}">
                                <a href="/resourceEdit/${resource.resourceUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isResourceAccess.permissionSoftDelete == 'Y'}">
                                <a href="/resourceDelete/${resource.resourceUuid}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>