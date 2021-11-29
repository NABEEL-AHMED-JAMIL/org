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
        <h2>Edit IntTrans</h2>
        <c:if test="${isIntTransAccess.permissionUpdate == 'Y'}">
            <form:form action="/intTransEdit/${intTrans.intTransUuid}" method="post" modelAttribute="intTrans">
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
                            <form:select path="updatedBy">
                               <form:option value="NONE" label="--- Select ---"/>
                               <form:options items="${userIds}" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td>Active Status: </td>
                        <td>
                            <form:select path="activeStatus">
                               <form:option value="Y" label="Yes"/>
                              <form:option value="N" label="No"/>
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
    </div>
</body>
</html>