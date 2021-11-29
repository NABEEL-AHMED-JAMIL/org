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
        <h2>New IntTrans</h2>
        <c:if test="${isIntTransAccess.permissionCreate == 'Y'}">
            <form:form action="createIntTrans" method="post" modelAttribute="intTrans">
                <table border="0" cellpadding="6">
                    <tr>
                        <td>IntTrans Name: </td>
                        <td>
                            <td><form:input path="intTransName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntDetailLogSysId: </td>
                        <td>
                            <td><form:input path="intDetailLogSysId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntDetailLogSysName: </td>
                        <td>
                            <td><form:input path="intDetailLogSysName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntDetailLogSysUuid: </td>
                        <td>
                            <td><form:input path="intDetailLogSysUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransAppId: </td>
                        <td>
                            <td><form:input path="intTransAppId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransAppName: </td>
                        <td>
                            <td><form:input path="intTransAppName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransAppUuid: </td>
                        <td>
                            <td><form:input path="intTransAppUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusName1: </td>
                        <td>
                            <td><form:input path="intTransBusName1" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusName2: </td>
                        <td>
                            <td><form:input path="intTransBusName2" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusName3: </td>
                        <td>
                            <td><form:input path="intTransBusName3" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusName4: </td>
                        <td>
                            <td><form:input path="intTransBusName4" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusName5: </td>
                        <td>
                            <td><form:input path="intTransBusName5" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusVal1: </td>
                        <td>
                            <td><form:input path="intTransBusVal1" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusVal2: </td>
                        <td>
                            <td><form:input path="intTransBusVal2" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusVal3: </td>
                        <td>
                            <td><form:input path="intTransBusVal3" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusVal4: </td>
                        <td>
                            <td><form:input path="intTransBusVal4" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransBusVal5: </td>
                        <td>
                            <td><form:input path="intTransBusVal5" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransDesc: </td>
                        <td>
                            <td><form:input path="intTransDesc" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransEnvId: </td>
                        <td>
                            <td><form:input path="intTransEnvId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransEnvName: </td>
                        <td>
                            <td><form:input path="intTransEnvName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransEnvUuid: </td>
                        <td>
                            <td><form:input path="intTransEnvUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransLogLevelId: </td>
                        <td>
                            <td><form:input path="intTransLogLevelId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransLogLevelName: </td>
                        <td>
                            <td><form:input path="intTransLogLevelName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransLogLevelUuid: </td>
                        <td>
                            <td><form:input path="intTransLogLevelUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransLogTypeId: </td>
                        <td>
                            <td><form:input path="intTransLogTypeId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransLogTypeName: </td>
                        <td>
                            <td><form:input path="intTransLogTypeName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransLogTypeUuid: </td>
                        <td>
                            <td><form:input path="intTransLogTypeUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransOrgDepId: </td>
                        <td>
                            <td><form:input path="intTransOrgDepId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransOrgDepName: </td>
                        <td>
                            <td><form:input path="intTransOrgDepName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransOrgDepUuid: </td>
                        <td>
                            <td><form:input path="intTransOrgDepUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransOrgId: </td>
                        <td>
                            <td><form:input path="intTransOrgId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransOrgName: </td>
                        <td>
                            <td><form:input path="intTransOrgName" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransOrgUuid: </td>
                        <td>
                            <td><form:input path="intTransOrgUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransPayload: </td>
                        <td>
                            <td><form:input path="intTransPayload" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransPlayloadBlob: </td>
                        <td>
                            <td><form:input path="intTransPlayloadBlob" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransShortDesc: </td>
                        <td>
                            <td><form:input path="intTransShortDesc" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransSrcSystemTransId: </td>
                        <td>
                            <td><form:input path="intTransSrcSystemTransId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransSrcSystemTransuuid: </td>
                        <td>
                            <td><form:input path="intTransSrcSystemTransuuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransSrcSystemUuid: </td>
                        <td>
                            <td><form:input path="intTransSrcSystemUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransSrcSystemId: </td>
                        <td>
                            <td><form:input path="intTransSrcSystemId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechName1: </td>
                        <td>
                            <td><form:input path="intTransTechName1" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechName2: </td>
                        <td>
                            <td><form:input path="intTransTechName2" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechName3: </td>
                        <td>
                            <td><form:input path="intTransTechName3" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechName4: </td>
                        <td>
                            <td><form:input path="intTransTechName4" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechName5: </td>
                        <td>
                            <td><form:input path="intTransTechName5" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechVal1: </td>
                        <td>
                            <td><form:input path="intTransTechVal1" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechVal2: </td>
                        <td>
                            <td><form:input path="intTransTechVal2" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechVal3: </td>
                        <td>
                            <td><form:input path="intTransTechVal3" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechVal4: </td>
                        <td>
                            <td><form:input path="intTransTechVal4" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTechVal5: </td>
                        <td>
                            <td><form:input path="intTransTechVal5" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTransChildId: </td>
                        <td>
                            <td><form:input path="intTransTransChildId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTransChildUuid: </td>
                        <td>
                            <td><form:input path="intTransTransChildUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTransParentId: </td>
                        <td>
                            <td><form:input path="intTransTransParentId" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTransParentUuid: </td>
                        <td>
                            <td><form:input path="intTransTransParentUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTrgSystemUuid: </td>
                        <td>
                            <td><form:input path="intTransTrgSystemUuid" required="required"/></td>
                        </td>
                    </tr>
                    <tr>
                        <td>IntTransTrgSystemId: </td>
                        <td>
                            <td><form:input path="intTransTrgSystemId" required="required"/></td>
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

        <h1>IntTrans</h1>
        <form:form action="intTransSearch" method="post" modelAttribute="intTransSearch">
            <table border="0" cellpadding="6">
                <tr>
                    <td>
                        <form:textarea path="intTransId" placeholder="Enter intTransId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransUuid" placeholder="Enter intTransUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intDetailLogSysId" placeholder="Enter intDetailLogSysId"/>
                    </td>
                    <td>
                        <form:textarea path="intDetailLogSysName" placeholder="Enter intDetailLogSysName"/>
                    </td>
                    <td>
                        <form:textarea path="intDetailLogSysUuid" placeholder="Enter intDetailLogSysUuid"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransAppId" placeholder="Enter intTransAppId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransAppName" placeholder="Enter intTransAppName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransAppUuid" placeholder="Enter intTransAppUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusName1" placeholder="Enter intTransBusName1"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransBusName2" placeholder="Enter intTransBusName2"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusName3" placeholder="Enter intTransBusName3"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusName4" placeholder="Enter intTransBusName4"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusName5" placeholder="Enter intTransBusName5"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusVal1" placeholder="Enter intTransBusVal1"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusVal2" placeholder="Enter intTransBusVal2"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransBusVal3" placeholder="Enter intTransBusVal3"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusVal4" placeholder="Enter intTransBusVal4"/>
                    </td>
                    <td>
                        <form:textarea path="intTransBusVal5" placeholder="Enter intTransBusVal5"/>
                    </td>
                    <td>
                        <form:textarea path="intTransDesc" placeholder="Enter intTransDesc"/>
                    </td>
                    <td>
                        <form:textarea path="intTransEnvId" placeholder="Enter intTransEnvId"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransEnvName" placeholder="Enter intTransEnvName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransEnvUuid" placeholder="Enter intTransEnvUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransLogLevelId" placeholder="Enter intTransLogLevelId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransLogLevelName" placeholder="Enter intTransLogLevelName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransLogLevelUuid" placeholder="Enter intTransLogLevelUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransLogTypeId" placeholder="Enter intTransLogTypeId"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransLogTypeName" placeholder="Enter intTransLogTypeName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransLogTypeUuid" placeholder="Enter intTransLogTypeUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransName" placeholder="Enter intTransName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransOrgDepId" placeholder="Enter intTransOrgDepId"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransOrgDepName" placeholder="Enter intTransOrgDepName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransOrgDepUuid" placeholder="Enter intTransOrgDepUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransOrgId" placeholder="Enter intTransOrgId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransOrgName" placeholder="Enter intTransOrgName"/>
                    </td>
                    <td>
                        <form:textarea path="intTransOrgUuid" placeholder="Enter intTransOrgUuid"/>
                    </td>
                 </tr>
                 <tr>
                    <td>
                        <form:textarea path="intTransPayload" placeholder="Enter intTransPayload"/>
                    </td>
                    <td>
                        <form:textarea path="intTransPlayloadBlob" placeholder="Enter intTransPlayloadBlob"/>
                    </td>
                    <td>
                        <form:textarea path="intTransShortDesc" placeholder="Enter intTransShortDesc"/>
                    </td>
                    <td>
                        <form:textarea path="intTransSrcSystemTransId" placeholder="Enter intTransSrcSystemTransId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransSrcSystemTransuuid" placeholder="Enter intTransSrcSystemTransuuid"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransSrcSystemUuid" placeholder="Enter intTransSrcSystemUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransSrcSystemId" placeholder="Enter intTransSrcSystemId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechName1" placeholder="Enter intTransTechName1"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechName2" placeholder="Enter intTransTechName2"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechName3" placeholder="Enter intTransTechName3"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechName4" placeholder="Enter intTransTechName4"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechName5" placeholder="Enter intTransTechName5"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransTechVal1" placeholder="Enter intTransTechVal1"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechVal2" placeholder="Enter intTransTechVal2"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechVal3" placeholder="Enter intTransTechVal3"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechVal4" placeholder="Enter intTransTechVal4"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTechVal5" placeholder="Enter intTransTechVal5"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTransChildId" placeholder="Enter intTransTransChildId"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:textarea path="intTransTransChildUuid" placeholder="Enter intTransTransChildUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTransParentId" placeholder="Enter intTransTransParentId"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTransParentUuid" placeholder="Enter intTransTransParentUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTrgSystemUuid" placeholder="Enter intTransTrgSystemUuid"/>
                    </td>
                    <td>
                        <form:textarea path="intTransTrgSystemId" placeholder="Enter intTransTrgSystemId"/>
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
        		    <th>IntTransId</th>
                    <th>IntTransUuid</th>
                    <th>IntTransName</th>
                    <th>IntDetailLogSysId</th>
                    <th>IntDetailLogSysName</th>
                    <th>IntDetailLogSysUuid</th>
                    <th>IntTransAppId</th>
                    <th>IntTransAppName</th>
                    <th>IntTransAppUuid</th>
                    <th>IntTransBusName1</th>
                    <th>IntTransBusName2</th>
                    <th>IntTransBusName3</th>
                    <th>IntTransBusName4</th>
                    <th>IntTransBusName5</th>
                    <th>IntTransBusVal1</th>
                    <th>IntTransBusVal2</th>
                    <th>IntTransBusVal3</th>
                    <th>IntTransBusVal4</th>
                    <th>IntTransBusVal5</th>
                    <th>IntTransDesc</th>
                    <th>IntTransEnvId</th>
                    <th>IntTransEnvName</th>
                    <th>IntTransEnvUuid</th>
                    <th>IntTransLogLevelId</th>
                    <th>IntTransLogLevelName</th>
                    <th>IntTransLogLevelUuid</th>
                    <th>IntTransLogTypeId</th>
                    <th>IntTransLogTypeName</th>
                    <th>IntTransLogTypeUuid</th>
                    <th>IntTransOrgDepId</th>
                    <th>IntTransOrgDepName</th>
                    <th>IntTransOrgDepUuid</th>
                    <th>IntTransOrgId</th>
                    <th>IntTransOrgName</th>
                    <th>IntTransOrgUuid</th>
                    <th>IntTransPayload</th>
                    <th>IntTransPlayloadBlob</th>
                    <th>IntTransShortDesc</th>
                    <th>IntTransSrcSystemTransId</th>
                    <th>IntTransSrcSystemTransuuid</th>
                    <th>IntTransSrcSystemUuid</th>
                    <th>IntTransSrcSystemId</th>
                    <th>IntTransTechName1</th>
                    <th>IntTransTechName2</th>
                    <th>IntTransTechName3</th>
                    <th>IntTransTechName4</th>
                    <th>IntTransTechName5</th>
                    <th>IntTransTechVal1</th>
                    <th>IntTransTechVal2</th>
                    <th>IntTransTechVal3</th>
                    <th>IntTransTechVal4</th>
                    <th>IntTransTechVal5</th>
                    <th>IntTransTransChildId</th>
                    <th>IntTransTransChildUuid</th>
                    <th>IntTransTransParentId</th>
                    <th>IntTransTransParentUuid</th>
                    <th>IntTransTrgSystemUuid</th>
                    <th>IntTransTrgSystemId</th>
                    <th>updatedDts</th>
                    <th>updatedBy</th>
                    <th>createdDts</th>
                    <th>createdBy</th>
                    <th>ActiveStatus</th>
                    <th>Action</th>
        		</tr>
        	</thead>
        	<tbody>
        		 <c:forEach items="${intTransList}" var="intTrans">
        			<tr>
                        <td>${intTrans.intTransId}</td>
                        <td>${intTrans.intTransUuid}</td>
                        <td>${intTrans.intTransName}</td>
                        <td>${intTrans.intDetailLogSysId}</td>
                        <td>${intTrans.intDetailLogSysName}</td>
                        <td>${intTrans.intDetailLogSysUuid}</td>
                        <td>${intTrans.intTransAppId}</td>
                        <td>${intTrans.intTransAppName}</td>
                        <td>${intTrans.intTransAppUuid}</td>
                        <td>${intTrans.intTransBusName1}</td>
                        <td>${intTrans.intTransBusName2}</td>
                        <td>${intTrans.intTransBusName3}</td>
                        <td>${intTrans.intTransBusName4}</td>
                        <td>${intTrans.intTransBusName5}</td>
                        <td>${intTrans.intTransBusVal1}</td>
                        <td>${intTrans.intTransBusVal2}</td>
                        <td>${intTrans.intTransBusVal3}</td>
                        <td>${intTrans.intTransBusVal4}</td>
                        <td>${intTrans.intTransBusVal5}</td>
                        <td>${intTrans.intTransDesc}</td>
                        <td>${intTrans.intTransEnvId}</td>
                        <td>${intTrans.intTransEnvName}</td>
                        <td>${intTrans.intTransEnvUuid}</td>
                        <td>${intTrans.intTransLogLevelId}</td>
                        <td>${intTrans.intTransLogLevelName}</td>
                        <td>${intTrans.intTransLogLevelUuid}</td>
                        <td>${intTrans.intTransLogTypeId}</td>
                        <td>${intTrans.intTransLogTypeName}</td>
                        <td>${intTrans.intTransLogTypeUuid}</td>
                        <td>${intTrans.intTransOrgDepId}</td>
                        <td>${intTrans.intTransOrgDepName}</td>
                        <td>${intTrans.intTransOrgDepUuid}</td>
                        <td>${intTrans.intTransOrgId}</td>
                        <td>${intTrans.intTransOrgName}</td>
                        <td>${intTrans.intTransOrgUuid}</td>
                        <td>${intTrans.intTransPayload}</td>
                        <td>${intTrans.intTransPlayloadBlob}</td>
                        <td>${intTrans.intTransShortDesc}</td>
                        <td>${intTrans.intTransSrcSystemTransId}</td>
                        <td>${intTrans.intTransSrcSystemTransuuid}</td>
                        <td>${intTrans.intTransSrcSystemUuid}</td>
                        <td>${intTrans.intTransSrcSystemId}</td>
                        <td>${intTrans.intTransTechName1}</td>
                        <td>${intTrans.intTransTechName2}</td>
                        <td>${intTrans.intTransTechName3}</td>
                        <td>${intTrans.intTransTechName4}</td>
                        <td>${intTrans.intTransTechName5}</td>
                        <td>${intTrans.intTransTechVal1}</td>
                        <td>${intTrans.intTransTechVal2}</td>
                        <td>${intTrans.intTransTechVal3}</td>
                        <td>${intTrans.intTransTechVal4}</td>
                        <td>${intTrans.intTransTechVal5}</td>
                        <td>${intTrans.intTransTransChildId}</td>
                        <td>${intTrans.intTransTransChildUuid}</td>
                        <td>${intTrans.intTransTransParentId}</td>
                        <td>${intTrans.intTransTransParentUuid}</td>
                        <td>${intTrans.intTransTrgSystemUuid}</td>
                        <td>${intTrans.intTransTrgSystemId}</td>
                        <td>${intTrans.updatedDts}</td>
                        <td>${intTrans.updatedBy}</td>
                        <td>${intTrans.createdDts}</td>
                        <td>${intTrans.createdBy}</td>
                        <td>${intTrans.activeStatus}</td>
        				<td>
                            <c:if test="${isIntTransAccess.permissionUpdate == 'Y'}">
            					<a href="/intTransEdit/${intTrans.intTransUuid}">Edit</a>
                            </c:if>
                            &nbsp;&nbsp;&nbsp;
                            <c:if test="${isIntTransAccess.permissionSoftDelete == 'Y'}">
            					<a href="/intTransDelete/${intTrans.intTransUuid}">Delete</a>
                            </c:if>
        				</td>
        			</tr>
        		 </c:forEach>
        	</tbody>
        </table>
    </div>
</body>
</html>