package com.system.org.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.system.org.controller.Response;
import com.system.org.dto.search.*;
import com.system.org.enums.ActiveStatus;
import com.system.org.model.*;
import com.system.org.model.view.PermissionListView;
import com.system.org.service.IUtilService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class UtilServiceImpl implements IUtilService {

    private Logger logger = LoggerFactory.getLogger(UtilServiceImpl.class);

    @Autowired
    private QueryServices queryServices;

    @Override
    public Response getAllActiveUserUUID(ActiveStatus activeStatus) {
        String query = "select user_uuid, CONCAT(user_first_name , ' ' , user_last_name, ' ' , user_middle_name ) as Name from user;";
        Map<Object, Object> userDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { userDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", userDetail);
    }

    @Override
    public Response getAllOrganizationUUID(ActiveStatus activeStatus) {
        String query = "select organization_uuid, organization_name from organization;";
        Map<Object, Object> organizationDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { organizationDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", organizationDetail);
    }

    @Override
    public Response getAllModuleLookupUUID(ActiveStatus activeStatus) {
        String query = "select modules_lookup_uuid, modules_lookup_name from modules_lookup;";
        Map<Object, Object> moduleLookupDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { moduleLookupDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", moduleLookupDetail);
    }

    @Override
    public Response getAllResourceUUID(ActiveStatus activeStatus) {
        String query = "select resource_uuid, resource_name from resource";
        Map<Object, Object> resourceDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { resourceDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", resourceDetail);
    }

    @Override
    public Response getAllPermissionUUID(ActiveStatus activeStatus) {
        String query = "select permission_uuid, permission_name from permission";
        Map<Object, Object> permissionDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { permissionDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", permissionDetail);
    }

    @Override
    public Response getAllRoleUUID(ActiveStatus activeStatus) {
        String query = "select role_uuid, role_name from role";
        Map<Object, Object> roleDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { roleDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", roleDetail);
    }

    @Override
    public Response getAllGroupUUID(ActiveStatus activeStatus) {
        String query = "select group_uuid, group_name from `group`";
        Map<Object, Object> groupDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { groupDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", groupDetail);
    }

    @Override
    public Response getAllOrgUUID(ActiveStatus activeStatus) {
        String query = "select organization_uuid, organization_name from organization";
        Map<Object, Object> organizationDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { organizationDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", organizationDetail);
    }

    @Override
    public Response getAllOrgID(ActiveStatus activeStatus) {
        String query = "select organisation_id, organization_name from organization";
        Map<Object, Object> organizationDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { organizationDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", organizationDetail);
    }

    @Override
    public Response getAllPermissionTypeUUID(ActiveStatus activeStatus) {
        String query = "select permission_type_id, permission_type_name from permission_type";
        Map<Object, Object> permissionTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { permissionTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", permissionTypeDetail);
    }

    @Override
    public Response getAllPermissionTypeUUID2(ActiveStatus activeStatus) {
        String query = "select permission_type_uuid, permission_type_name from permission_type";
        Map<Object, Object> permissionTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { permissionTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", permissionTypeDetail);
    }

    @Override
    public Response getAllResourceId(ActiveStatus activeStatus) {
        String query = "select resource_id, resource_name from resource";
        Map<Object, Object> resourceDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { resourceDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", resourceDetail);
    }

    @Override
    public Response getAllResourceTypeId(ActiveStatus activeStatus) {
        String query = "select resource_type_uuid, resource_type_name from resource_type";
        Map<Object, Object> resourceTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { resourceTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", resourceTypeDetail);
    }

    @Override
    public Response getAllIntTypeId(ActiveStatus activeStatus) {
        String query = "select Int_type_id,int_type_name from int_type";
        Map<Object, Object> intTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { intTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", intTypeDetail);
    }

    @Override
    public Response getAllIntTypeUuid(ActiveStatus activeStatus) {
        String query = "select int_type_uuid,int_type_name from int_type";
        Map<Object, Object> intTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { intTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", intTypeDetail);
    }

    @Override
    public Response getAllIntCmdParamId(ActiveStatus activeStatus) {
        String query = "select int_cmd_param_id,int_cmd_param_name from int_cmd_param";
        Map<Object, Object> intTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { intTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", intTypeDetail);
    }

    @Override
    public Response getAllIntCmdParamUuid(ActiveStatus activeStatus) {
        String query = "select int_cmd_param_uuid,int_cmd_param_name from int_cmd_param";
        Map<Object, Object> intTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { intTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", intTypeDetail);
    }

    @Override
    public Response getAllIntCmdId(ActiveStatus activeStatus) {
        String query = "select int_cmd_id,int_cmd_cmd_userfriendlyname from int_cmd";
        Map<Object, Object> intTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { intTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", intTypeDetail);
    }

    @Override
    public Response getAllIntCmdUuid(ActiveStatus activeStatus) {
        String query = "select int_cmd_uuid, int_cmd_cmd_userfriendlyname from int_cmd";
        Map<Object, Object> intTypeDetail = new HashMap<>();
        this.queryServices.executeQuery(query).stream().forEach(objects -> { intTypeDetail.put(objects[0], objects[1]); });
        return new Response("Success", "Fetch Data Successfully", intTypeDetail);
    }

    @Override
    public Response findAllGroupSearch(GroupSearch groupSearch) {
        String query = "select * from `group`";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(groupSearch.getGroupId())) {
            inQuery.put("group_id", this.queryBuilder("group_id", groupSearch.getGroupId()));
        }
        if (isNotNull(groupSearch.getGroupUuid())) {
            inQuery.put("group_uuid", this.queryBuilderV2("group_uuid", groupSearch.getGroupUuid()));
        }
        if (isNotNull(groupSearch.getGroupName())) {
            inQuery.put("group_name", this.queryBuilderV2("group_name", groupSearch.getGroupName()));
        }
        if (isNotNull(groupSearch.getGroupShortName())) {
            inQuery.put("group_short_name", this.queryBuilderV2("group_short_name", groupSearch.getGroupShortName()));
        }
        if (isNotNull(groupSearch.getGroupDesc())) {
            inQuery.put("group_desc", this.queryBuilderV2("group_desc", groupSearch.getGroupDesc()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(groupSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, groupSearch.getFromDate());
            if (groupSearch.getToDate() == null || groupSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(groupSearch.getToDate())) {
            if (groupSearch.getFromDate() == null || groupSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", groupSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String upatedBetweenQuery = "upated_dts BETWEEN '%s'";
        if (isNotNull(groupSearch.getUpdateFromDate())) {
            upatedBetweenQuery= String.format(upatedBetweenQuery, groupSearch.getUpdateFromDate());
            if (groupSearch.getUpdateToDate() == null || groupSearch.getUpdateToDate().equals("")) {
                upatedBetweenQuery= String.format(upatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("upated_dts",upatedBetweenQuery);
        }
        if (isNotNull(groupSearch.getUpdateToDate())) {
            if (groupSearch.getUpdateFromDate() == null || groupSearch.getUpdateFromDate().equals("")) {
                upatedBetweenQuery= String.format(upatedBetweenQuery, LocalDate.now());
            }
            upatedBetweenQuery= String.format(upatedBetweenQuery+" and '%s'", groupSearch.getUpdateToDate());
            inQuery.put("upated_dts",upatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<Group> groupList = (List<Group>) this.queryServices.executeQueryV2(query, "Group");
        logger.info("Result " + groupList);
        return new Response("Success", "Fetch Data Successfully", groupList);
    }

    @Override
    public Response findAllIntCmdImpSearch(IntCmdImpSearch intCmdImpSearch) {
        String query = "select * from int_cmd_imp";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intCmdImpSearch.getIntCmdImpId())) {
            inQuery.put("int_cmd_imp_id", this.queryBuilder("int_cmd_imp_id", intCmdImpSearch.getIntCmdImpId()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpUuid())) {
            inQuery.put("int_cmd_imp_uuid", this.queryBuilderV2("int_cmd_imp_uuid", intCmdImpSearch.getIntCmdImpUuid()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpIntCmdId())) {
            inQuery.put("int_cmd_imp_int_cmd_id", this.queryBuilderV2("int_cmd_imp_int_cmd_id", intCmdImpSearch.getIntCmdImpIntCmdId()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpIntCmdUuid())) {
            inQuery.put("int_cmd_imp_int_cmd_uuid", this.queryBuilderV2("int_cmd_imp_int_cmd_uuid", intCmdImpSearch.getIntCmdImpIntCmdUuid()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpIntCmdParamId())) {
            inQuery.put("int_cmd_imp_int_cmd_param_id", this.queryBuilderV2("int_cmd_imp_int_cmd_param_id", intCmdImpSearch.getIntCmdImpIntCmdParamId()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpIntCmdParamUuid())) {
            inQuery.put("int_cmd_imp_int_cmd_param_uuid", this.queryBuilderV2("int_cmd_imp_int_cmd_param_uuid", intCmdImpSearch.getIntCmdImpIntCmdParamUuid()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpIntCmdParamValue())) {
            inQuery.put("int_cmd_imp_int_cmd_param_value", this.queryBuilderV2("int_cmd_imp_int_cmd_param_value", intCmdImpSearch.getIntCmdImpIntCmdParamValue()));
        }
        if (isNotNull(intCmdImpSearch.getIntCmdImpUserUuid())) {
            inQuery.put("int_cmd_imp_user_uuid", this.queryBuilderV2("int_cmd_imp_user_uuid", intCmdImpSearch.getIntCmdImpUserUuid()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intCmdImpSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, intCmdImpSearch.getFromDate());
            if (intCmdImpSearch.getToDate() == null || intCmdImpSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(intCmdImpSearch.getToDate())) {
            if (intCmdImpSearch.getFromDate() == null || intCmdImpSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", intCmdImpSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intCmdImpSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intCmdImpSearch.getUpdateFromDate());
            if (intCmdImpSearch.getUpdateToDate() == null || intCmdImpSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intCmdImpSearch.getUpdateToDate())) {
            if (intCmdImpSearch.getUpdateFromDate() == null || intCmdImpSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intCmdImpSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<IntCmdImp> intCmdImpList = (List<IntCmdImp>) this.queryServices.executeQueryV2(query, "IntCmdImp");
        logger.info("Result " + intCmdImpList);
        return new Response("Success", "Fetch Data Successfully", intCmdImpList);
    }

    @Override
    public Response findAllIntCmdParamSearch(IntCmdParamSearch intCmdParamSearch) {
        String query = "select * from int_cmd_param";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intCmdParamSearch.getIntCmdParamId())) {
            inQuery.put("int_cmd_param_id", this.queryBuilder("int_cmd_param_id", intCmdParamSearch.getIntCmdParamId()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamUuid())) {
            inQuery.put("int_cmd_param_uuid", this.queryBuilderV2("int_cmd_param_uuid", intCmdParamSearch.getIntCmdParamUuid()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamIntCmdUuid())) {
            inQuery.put("int_cmd_param_int_cmd_uuid", this.queryBuilderV2("int_cmd_param_int_cmd_uuid", intCmdParamSearch.getIntCmdParamIntCmdUuid()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamIntCmdId())) {
            inQuery.put("int_cmd_param_int_cmd_id", this.queryBuilderV2("int_cmd_param_int_cmd_id", intCmdParamSearch.getIntCmdParamIntCmdId()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamName())) {
            inQuery.put("int_cmd_param_name", this.queryBuilderV2("int_cmd_param_name", intCmdParamSearch.getIntCmdParamName()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamDefaultvalue())) {
            inQuery.put("int_cmd_param_defaultvalue", this.queryBuilderV2("int_cmd_param_defaultvalue", intCmdParamSearch.getIntCmdParamDefaultvalue()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamDescription())) {
            inQuery.put("int_cmd_param_description", this.queryBuilderV2("int_cmd_param_description", intCmdParamSearch.getIntCmdParamDescription()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamShortdescription())) {
            inQuery.put("int_cmd_param_shortdescription", this.queryBuilderV2("int_cmd_param_shortdescription", intCmdParamSearch.getIntCmdParamShortdescription()));
        }
        if (isNotNull(intCmdParamSearch.getIntCmdParamPosition())) {
            inQuery.put("int_cmd_param_position", this.queryBuilderV2("int_cmd_param_position", intCmdParamSearch.getIntCmdParamPosition()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intCmdParamSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, intCmdParamSearch.getFromDate());
            if (intCmdParamSearch.getToDate() == null || intCmdParamSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(intCmdParamSearch.getToDate())) {
            if (intCmdParamSearch.getFromDate() == null || intCmdParamSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", intCmdParamSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intCmdParamSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intCmdParamSearch.getUpdateFromDate());
            if (intCmdParamSearch.getUpdateToDate() == null || intCmdParamSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intCmdParamSearch.getUpdateToDate())) {
            if (intCmdParamSearch.getUpdateFromDate() == null || intCmdParamSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intCmdParamSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<IntCmdParam> intCmdParamList = (List<IntCmdParam>) this.queryServices.executeQueryV2(query, "IntCmdParam");
        logger.info("Result " + intCmdParamList);
        return new Response("Success", "Fetch Data Successfully", intCmdParamList);
    }

    @Override
    public Response findAllIntCmdSearch(IntCmdSearch intCmdSearch) {
        String query = "select * from int_cmd";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intCmdSearch.getIntCmdId())) {
            inQuery.put("int_cmd_id", this.queryBuilder("int_cmd_id", intCmdSearch.getIntCmdId()));
        }
        if (isNotNull(intCmdSearch.getIntCmdUuid())) {
            inQuery.put("int_cmd_uuid", this.queryBuilderV2("int_cmd_uuid", intCmdSearch.getIntCmdUuid()));
        }
        if (isNotNull(intCmdSearch.getIntCmdIntTypeId())) {
            inQuery.put("int_cmd_int_type_id", this.queryBuilderV2("int_cmd_int_type_id", intCmdSearch.getIntCmdIntTypeId()));
        }
        if (isNotNull(intCmdSearch.getIntCmdIntTypeUuid())) {
            inQuery.put("int_cmd_int_type_uuid", this.queryBuilderV2("int_cmd_int_type_uuid", intCmdSearch.getIntCmdIntTypeUuid()));
        }
        if (isNotNull(intCmdSearch.getIntCmdCmd())) {
            inQuery.put("int_cmd_cmd", this.queryBuilderV2("int_cmd_cmd", intCmdSearch.getIntCmdCmd()));
        }
        if (isNotNull(intCmdSearch.getIntCmdCmdUserfriendlyname())) {
            inQuery.put("int_cmd_cmd_userfriendlyname", this.queryBuilderV2("int_cmd_cmd_userfriendlyname", intCmdSearch.getIntCmdCmdUserfriendlyname()));
        }
        if (isNotNull(intCmdSearch.getIntCmdBlog())) {
            inQuery.put("int_cmd_blog", this.queryBuilderV2("int_cmd_blog", intCmdSearch.getIntCmdBlog()));
        }
        if (isNotNull(intCmdSearch.getIntCmdZebraId())) {
            inQuery.put("int_cmd_zebra_id", this.queryBuilder("int_cmd_zebra_id", intCmdSearch.getIntCmdZebraId()));
        }
        if (isNotNull(intCmdSearch.getIntCmdZebraUuid())) {
            inQuery.put("intCmdZebraUuid", this.queryBuilderV2("intCmdZebraUuid", intCmdSearch.getIntCmdZebraUuid()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intCmdSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, intCmdSearch.getFromDate());
            if (intCmdSearch.getToDate() == null || intCmdSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(intCmdSearch.getToDate())) {
            if (intCmdSearch.getFromDate() == null || intCmdSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", intCmdSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intCmdSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intCmdSearch.getUpdateFromDate());
            if (intCmdSearch.getUpdateToDate() == null || intCmdSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intCmdSearch.getUpdateToDate())) {
            if (intCmdSearch.getUpdateFromDate() == null || intCmdSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intCmdSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<IntCmd> intCmdList = (List<IntCmd>) this.queryServices.executeQueryV2(query, "IntCmd");
        logger.info("Result " + intCmdList);
        return new Response("Success", "Fetch Data Successfully", intCmdList);
    }

    @Override
    public Response findAllIntParamsSearch(IntParamsSearch intParamsSearch) {
        String query = "select * from int_params";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intParamsSearch.getIntParamsId())) {
            inQuery.put("int_params_id", this.queryBuilder("int_params_id", intParamsSearch.getIntParamsId()));
        }
        if (isNotNull(intParamsSearch.getIntParamsUuid())) {
            inQuery.put("int_params_uuid", this.queryBuilderV2("int_params_uuid", intParamsSearch.getIntParamsUuid()));
        }
        if (isNotNull(intParamsSearch.getIntParamsName())) {
            inQuery.put("int_params_name", this.queryBuilderV2("int_params_name", intParamsSearch.getIntParamsName()));
        }
        if (isNotNull(intParamsSearch.getIntParamsValue())) {
            inQuery.put("int_params_value", this.queryBuilderV2("int_params_value", intParamsSearch.getIntParamsValue()));
        }
        if (isNotNull(intParamsSearch.getIntParamsTypeId())) {
            inQuery.put("int_params_typeid", this.queryBuilderV2("int_params_typeid", intParamsSearch.getIntParamsTypeId()));
        }
        if (isNotNull(intParamsSearch.getIntParamsTypeuuId())) {
            inQuery.put("int_params_typeuuid", this.queryBuilderV2("int_params_typeuuid", intParamsSearch.getIntParamsTypeuuId()));
        }
        if (isNotNull(intParamsSearch.getIntParamsLabel())) {
            inQuery.put("int_params_label", this.queryBuilderV2("int_params_label", intParamsSearch.getIntParamsLabel()));
        }
        if (isNotNull(intParamsSearch.getIntParamsParamTypeId())) {
            inQuery.put("int_params_paramtypeid", this.queryBuilderV2("int_params_paramtypeid", intParamsSearch.getIntParamsParamTypeId()));
        }
        if (isNotNull(intParamsSearch.getIntParamsParamTypeuuid())) {
            inQuery.put("int_params_paramtypeuuid", this.queryBuilderV2("int_params_paramtypeuuid", intParamsSearch.getIntParamsParamTypeuuid()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intParamsSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, intParamsSearch.getFromDate());
            if (intParamsSearch.getToDate() == null || intParamsSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(intParamsSearch.getToDate())) {
            if (intParamsSearch.getFromDate() == null || intParamsSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", intParamsSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intParamsSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intParamsSearch.getUpdateFromDate());
            if (intParamsSearch.getUpdateToDate() == null || intParamsSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intParamsSearch.getUpdateToDate())) {
            if (intParamsSearch.getUpdateFromDate() == null || intParamsSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intParamsSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<IntParams> intParamsList = (List<IntParams>) this.queryServices.executeQueryV2(query, "IntParams");
        logger.info("Result " + intParamsList);
        return new Response("Success", "Fetch Data Successfully", intParamsList);
    }

    @Override
    public Response findAllIntTypeSearch(IntTypeSearch intTypeSearch) {
        String query = "select * from int_type";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intTypeSearch.getIntTypeId())) {
            inQuery.put("Int_type_id", this.queryBuilder("Int_type_id", intTypeSearch.getIntTypeId()));
        }
        if (isNotNull(intTypeSearch.getIntTypeUuid())) {
            inQuery.put("int_type_uuid", this.queryBuilderV2("int_type_uuid", intTypeSearch.getIntTypeUuid()));
        }
        if (isNotNull(intTypeSearch.getIntTypeName())) {
            inQuery.put("int_type_name", this.queryBuilderV2("int_type_name", intTypeSearch.getIntTypeName()));
        }
        if (isNotNull(intTypeSearch.getIntTypeShortDescription())) {
            inQuery.put("int_type_short_description", this.queryBuilderV2("int_type_short_description", intTypeSearch.getIntTypeShortDescription()));
        }
        if (isNotNull(intTypeSearch.getIntTypeDescription())) {
            inQuery.put("int_type_description", this.queryBuilderV2("int_type_description", intTypeSearch.getIntTypeDescription()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intTypeSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, intTypeSearch.getFromDate());
            if (intTypeSearch.getToDate() == null || intTypeSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(intTypeSearch.getToDate())) {
            if (intTypeSearch.getFromDate() == null || intTypeSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", intTypeSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intTypeSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intTypeSearch.getUpdateFromDate());
            if (intTypeSearch.getUpdateToDate() == null || intTypeSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intTypeSearch.getUpdateToDate())) {
            if (intTypeSearch.getUpdateFromDate() == null || intTypeSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intTypeSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<IntType> intTypeList = (List<IntType>) this.queryServices.executeQueryV2(query, "IntType");
        logger.info("Result " + intTypeList);
        return new Response("Success", "Fetch Data Successfully", intTypeList);
    }

    @Override
    public Response findAllModulesLookupBySearch(ModuleSearch moduleSearch) {
        String query = "select * from modules_lookup";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(moduleSearch.getModulesLookupId())) {
            inQuery.put("modules_lookup_id", this.queryBuilder("modules_lookup_id", moduleSearch.getModulesLookupId()));
        }
        if (isNotNull(moduleSearch.getModulesLookupUuid())) {
            inQuery.put("modules_lookup_uuid", this.queryBuilderV2("modules_lookup_uuid", moduleSearch.getModulesLookupUuid()));
        }
        if (isNotNull(moduleSearch.getModulesLookupNumber())) {
            inQuery.put("modules_lookup_number", this.queryBuilderV2("modules_lookup_number", moduleSearch.getModulesLookupNumber()));
        }
        if (isNotNull(moduleSearch.getModulesLookupName())) {
            inQuery.put("modules_lookup_name", this.queryBuilderV2("modules_lookup_name", moduleSearch.getModulesLookupName()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(moduleSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, moduleSearch.getFromDate());
            if (moduleSearch.getToDate() == null || moduleSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(moduleSearch.getToDate())) {
            if (moduleSearch.getFromDate() == null || moduleSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", moduleSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(moduleSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, moduleSearch.getUpdateFromDate());
            if (moduleSearch.getUpdateToDate() == null || moduleSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(moduleSearch.getUpdateToDate())) {
            if (moduleSearch.getUpdateFromDate() == null || moduleSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", moduleSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<ModulesLookup> modulesLookupList = (List<ModulesLookup>) this.queryServices.executeQueryV2(query, "ModulesLookup");
        logger.info("Result " + modulesLookupList);
        return new Response("Success", "Fetch Data Successfully", modulesLookupList);
    }

    @Override
    public Response findAllOrganizationModuleLinkSearch(OrganizationModuleLinkSearch organizationModuleLinkSearch) {
        String query = "select * from organization_module";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(organizationModuleLinkSearch.getOrganizationModuleId())) {
            inQuery.put("Organization_Module_id", this.queryBuilder("Organization_Module_id", organizationModuleLinkSearch.getOrganizationModuleId()));
        }
        if (isNotNull(organizationModuleLinkSearch.getOrganizationModuleUuid())) {
            inQuery.put("Organization_Module_uuid", this.queryBuilderV2("Organization_Module_uuid", organizationModuleLinkSearch.getOrganizationModuleUuid()));
        }
        if (isNotNull(organizationModuleLinkSearch.getOrganizationUuid())) {
            inQuery.put("Organization_uuid", this.queryBuilderV2("Organization_uuid", organizationModuleLinkSearch.getOrganizationUuid()));
        }
        if (isNotNull(organizationModuleLinkSearch.getModuleLookupUuid())) {
            inQuery.put("module_lookup_uuid", this.queryBuilderV2("module_lookup_uuid", organizationModuleLinkSearch.getModuleLookupUuid()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(organizationModuleLinkSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, organizationModuleLinkSearch.getFromDate());
            if (organizationModuleLinkSearch.getToDate() == null || organizationModuleLinkSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(organizationModuleLinkSearch.getToDate())) {
            if (organizationModuleLinkSearch.getFromDate() == null || organizationModuleLinkSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", organizationModuleLinkSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(organizationModuleLinkSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, organizationModuleLinkSearch.getUpdateFromDate());
            if (organizationModuleLinkSearch.getUpdateToDate() == null || organizationModuleLinkSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(organizationModuleLinkSearch.getUpdateToDate())) {
            if (organizationModuleLinkSearch.getUpdateFromDate() == null || organizationModuleLinkSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", organizationModuleLinkSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<OrganizationModule> organizationModuleList = (List<OrganizationModule>) this.queryServices.executeQueryV2(query, "OrganizationModule");
        logger.info("Result " + organizationModuleList);
        return new Response("Success", "Fetch Data Successfully", organizationModuleList);
    }

    @Override
    public Response findOrganizationBySearch(OrganizationSearch organizationSearch) {
        String query = "select * from organization";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(organizationSearch.getOrganisationId())) {
            inQuery.put("organisation_id", this.queryBuilder("organisation_id", organizationSearch.getOrganisationId()));
        }
        if (isNotNull(organizationSearch.getOrganizationUuid())) {
            inQuery.put("organization_uuid", this.queryBuilderV2("organization_uuid", organizationSearch.getOrganizationUuid()));
        }
        if (isNotNull(organizationSearch.getOrganizationName())) {
            inQuery.put("organization_name", this.queryBuilderV2("organization_name", organizationSearch.getOrganizationName()));
        }
        String createdBetweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(organizationSearch.getFromDate())) {
            createdBetweenQuery= String.format(createdBetweenQuery, organizationSearch.getFromDate());
            if (organizationSearch.getToDate() == null || organizationSearch.getToDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",createdBetweenQuery);
        }
        if (isNotNull(organizationSearch.getToDate())) {
            if (organizationSearch.getFromDate() == null || organizationSearch.getFromDate().equals("")) {
                createdBetweenQuery= String.format(createdBetweenQuery, LocalDate.now());
            }
            createdBetweenQuery= String.format(createdBetweenQuery+" and '%s'", organizationSearch.getToDate());
            inQuery.put("created_dts",createdBetweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(organizationSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, organizationSearch.getUpdateFromDate());
            if (organizationSearch.getUpdateToDate() == null || organizationSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(organizationSearch.getUpdateToDate())) {
            if (organizationSearch.getUpdateFromDate() == null || organizationSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", organizationSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<Organization> organizationList = (List<Organization>) this.queryServices.executeQueryV2(query, "Organization");
        logger.info("Result " + organizationList);
        return new Response("Success", "Fetch Data Successfully", organizationList);
    }

    @Override
    public Response findAllPermissionResourceModuleSearch(PermissionResourceModuleSearch permissionResourceModuleSearch) {
        String query = "select * from permission_resource_module";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(permissionResourceModuleSearch.getPermissionResourceModuleId())) {
            inQuery.put("permission_resource_module_id", this.queryBuilder("permission_resource_module_id", permissionResourceModuleSearch.getPermissionResourceModuleId()));
        }
        if (isNotNull(permissionResourceModuleSearch.getPermissionResourceModuleUuid())) {
            inQuery.put("permission_resource_module_uuid", this.queryBuilderV2("permission_resource_module_uuid", permissionResourceModuleSearch.getPermissionResourceModuleUuid()));
        }
        if (isNotNull(permissionResourceModuleSearch.getPermissionResourceModuleName())) {
            inQuery.put("permission_resource_module_name", this.queryBuilderV2("permission_resource_module_name", permissionResourceModuleSearch.getPermissionResourceModuleName()));
        }
        if (isNotNull(permissionResourceModuleSearch.getPermissionResourceModuleDesc())) {
            inQuery.put("permission_resource_module_desc", this.queryBuilderV2("permission_resource_module_desc", permissionResourceModuleSearch.getPermissionResourceModuleDesc()));
        }
        if (isNotNull(permissionResourceModuleSearch.getPermissionResourceModuleResourceUuid())) {
            inQuery.put("permission_resource_module_resource_uuid", this.queryBuilderV2("permission_resource_module_resource_uuid", permissionResourceModuleSearch.getPermissionResourceModuleResourceUuid()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(permissionResourceModuleSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, permissionResourceModuleSearch.getFromDate());
            if (permissionResourceModuleSearch.getToDate() == null || permissionResourceModuleSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(permissionResourceModuleSearch.getToDate())) {
            if (permissionResourceModuleSearch.getFromDate() == null || permissionResourceModuleSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", permissionResourceModuleSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(permissionResourceModuleSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, permissionResourceModuleSearch.getUpdateFromDate());
            if (permissionResourceModuleSearch.getUpdateToDate() == null || permissionResourceModuleSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(permissionResourceModuleSearch.getUpdateToDate())) {
            if (permissionResourceModuleSearch.getUpdateFromDate() == null || permissionResourceModuleSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", permissionResourceModuleSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<PermissionResourceModule> permissionResourceModuleList = (List<PermissionResourceModule>) this.queryServices
                .executeQueryV2(query, "PermissionResourceModule");
        logger.info("Result " + permissionResourceModuleList);
        return new Response("Success", "Fetch Data Successfully", permissionResourceModuleList);
    }

    @Override
    public Response findAllPermissionSearch(PermissionSearch permissionSearch) {
        String query = "select * from permission";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(permissionSearch.getPermissionId())) {
            inQuery.put("permission_id", this.queryBuilder("permission_id", permissionSearch.getPermissionId()));
        }
        if (isNotNull(permissionSearch.getPermissionUuid())) {
            inQuery.put("permissionUuid", this.queryBuilderV2("permissionUuid", permissionSearch.getPermissionUuid()));
        }
        if (isNotNull(permissionSearch.getPermissionName())) {
            inQuery.put("permission_name", this.queryBuilderV2("permission_name", permissionSearch.getPermissionName()));
        }
        if (isNotNull(permissionSearch.getPermissionDesc())) {
            inQuery.put("permission_desc", this.queryBuilderV2("permission_desc", permissionSearch.getPermissionDesc()));
        }
        if (isNotNull(permissionSearch.getPermissionResourceId())) {
            inQuery.put("permission_resource_id", this.queryBuilderV2("permission_resource_id", permissionSearch.getPermissionResourceId()));
        }
        if (isNotNull(permissionSearch.getPermissionResourceUuid())) {
            inQuery.put("permission_resource_uuid", this.queryBuilderV2("permission_resource_uuid", permissionSearch.getPermissionResourceUuid()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(permissionSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, permissionSearch.getFromDate());
            if (permissionSearch.getToDate() == null || permissionSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(permissionSearch.getToDate())) {
            if (permissionSearch.getFromDate() == null || permissionSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", permissionSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(permissionSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, permissionSearch.getUpdateFromDate());
            if (permissionSearch.getUpdateToDate() == null || permissionSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(permissionSearch.getUpdateToDate())) {
            if (permissionSearch.getUpdateFromDate() == null || permissionSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", permissionSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<Permission> permissionList = (List<Permission>) this.queryServices.executeQueryV2(query, "Permission");
        logger.info("Result " + permissionList);
        return new Response("Success", "Fetch Data Successfully", permissionList);
    }

    @Override
    public Response findAllPermissionTypeSearch(PermissionTypeSearch permissionTypeSearch) {
        String query = "select * from permission_type";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(permissionTypeSearch.getPermissionTypeId())) {
            inQuery.put("permission_type_id", this.queryBuilder("permission_type_id", permissionTypeSearch.getPermissionTypeId()));
        }
        if (isNotNull(permissionTypeSearch.getPermissionTypeUuid())) {
            inQuery.put("permission_type_uuid", this.queryBuilderV2("permission_type_uuid", permissionTypeSearch.getPermissionTypeUuid()));
        }
        if (isNotNull(permissionTypeSearch.getPermissionTypeName())) {
            inQuery.put("permission_type_name", this.queryBuilderV2("permission_type_name", permissionTypeSearch.getPermissionTypeName()));
        }
        if (isNotNull(permissionTypeSearch.getPermissionTypeDescription())) {
            inQuery.put("permission_type_description", this.queryBuilderV2("permission_type_description", permissionTypeSearch.getPermissionTypeDescription()));
        }
        if (isNotNull(permissionTypeSearch.getPermissionTypeShortDescription())) {
            inQuery.put("permission_type_short_description", this.queryBuilderV2("permission_type_short_description", permissionTypeSearch.getPermissionTypeShortDescription()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(permissionTypeSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, permissionTypeSearch.getFromDate());
            if (permissionTypeSearch.getToDate() == null || permissionTypeSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(permissionTypeSearch.getToDate())) {
            if (permissionTypeSearch.getFromDate() == null || permissionTypeSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", permissionTypeSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(permissionTypeSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, permissionTypeSearch.getUpdateFromDate());
            if (permissionTypeSearch.getUpdateToDate() == null || permissionTypeSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(permissionTypeSearch.getUpdateToDate())) {
            if (permissionTypeSearch.getUpdateFromDate() == null || permissionTypeSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", permissionTypeSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<PermissionType> permissionTypeList = (List<PermissionType>) this.queryServices.executeQueryV2(query, "PermissionType");
        logger.info("Result " + permissionTypeList);
        return new Response("Success", "Fetch Data Successfully", permissionTypeList);
    }

    @Override
    public Response findResourceModuleSearch(ResourceModuleSearch resourceModuleSearch) {
        String query = "select * from resource_module";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(resourceModuleSearch.getResourceModuleId())) {
            inQuery.put("resource_module_id", this.queryBuilder("resource_module_id", resourceModuleSearch.getResourceModuleId()));
        }
        if (isNotNull(resourceModuleSearch.getResourceModuleUuid())) {
            inQuery.put("resource_module_uuid", this.queryBuilderV2("resource_module_uuid", resourceModuleSearch.getResourceModuleUuid()));
        }
        if (isNotNull(resourceModuleSearch.getResourceUuid())) {
            inQuery.put("resource_uuid", this.queryBuilderV2("resource_uuid", resourceModuleSearch.getResourceUuid()));
        }
        if (isNotNull(resourceModuleSearch.getModuleUuid())) {
            inQuery.put("module_uuid", this.queryBuilderV2("module_uuid", resourceModuleSearch.getModuleUuid()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(resourceModuleSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, resourceModuleSearch.getFromDate());
            if (resourceModuleSearch.getToDate() == null || resourceModuleSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(resourceModuleSearch.getToDate())) {
            if (resourceModuleSearch.getFromDate() == null || resourceModuleSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", resourceModuleSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(resourceModuleSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, resourceModuleSearch.getUpdateFromDate());
            if (resourceModuleSearch.getUpdateToDate() == null || resourceModuleSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(resourceModuleSearch.getUpdateToDate())) {
            if (resourceModuleSearch.getUpdateFromDate() == null || resourceModuleSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", resourceModuleSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<ResourceModule> resourceModuleList = (List<ResourceModule>) this.queryServices.executeQueryV2(query, "ResourceModule");
        logger.info("Result " + resourceModuleList);
        return new Response("Success", "Fetch Data Successfully", resourceModuleList);
    }

    @Override
    public Response findAllResourceSearch(ResourceSearch resourceSearch) {
        String query = "select * from resource";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(resourceSearch.getResourceId())) {
            inQuery.put("resource_id", this.queryBuilder("resource_id", resourceSearch.getResourceId()));
        }
        if (isNotNull(resourceSearch.getResourceUuid())) {
            inQuery.put("resource_uuid", this.queryBuilderV2("resource_uuid", resourceSearch.getResourceUuid()));
        }
        if (isNotNull(resourceSearch.getResourceName())) {
            inQuery.put("resource_name", this.queryBuilderV2("resource_name", resourceSearch.getResourceName()));
        }
        if (isNotNull(resourceSearch.getResourceType())) {
            inQuery.put("resource_type", this.queryBuilderV2("resource_type", resourceSearch.getResourceType()));
        }
        if (isNotNull(resourceSearch.getResourceDesc())) {
            inQuery.put("resource_desc", this.queryBuilderV2("resource_desc", resourceSearch.getResourceDesc()));
        }
        if (isNotNull(resourceSearch.getResourceTypeDesc())) {
            inQuery.put("resource_type_desc", this.queryBuilderV2("resource_type_desc", resourceSearch.getResourceTypeDesc()));
        }
        if (isNotNull(resourceSearch.getResourceVersionNumber())) {
            inQuery.put("resource_version_number", this.queryBuilderV2("resource_version_number", resourceSearch.getResourceVersionNumber()));
        }
        if (isNotNull(resourceSearch.getResourceAvailableIndicator())) {
            inQuery.put("resource_available_indicator", this.queryBuilderV2("resource_available_indicator", resourceSearch.getResourceAvailableIndicator()));
        }
        if (isNotNull(resourceSearch.getResourceParentId())) {
            inQuery.put("resource_parent_id", this.queryBuilderV2("resource_parent_id", resourceSearch.getResourceParentId()));
        }
        if (isNotNull(resourceSearch.getResourceAuthUserId())) {
            inQuery.put("resource_auth_user_id", this.queryBuilderV2("resource_auth_user_id", resourceSearch.getResourceAuthUserId()));
        }
        if (isNotNull(resourceSearch.getResourceResourceTypeUuid())) {
            inQuery.put("resource_resource_type_uuid", this.queryBuilderV2("resource_resource_type_uuid", resourceSearch.getResourceResourceTypeUuid()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(resourceSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, resourceSearch.getFromDate());
            if (resourceSearch.getToDate() == null || resourceSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(resourceSearch.getToDate())) {
            if (resourceSearch.getFromDate() == null || resourceSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", resourceSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(resourceSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, resourceSearch.getUpdateFromDate());
            if (resourceSearch.getUpdateToDate() == null || resourceSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(resourceSearch.getUpdateToDate())) {
            if (resourceSearch.getUpdateFromDate() == null || resourceSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", resourceSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<Resource> resourceList = (List<Resource>) this.queryServices.executeQueryV2(query, "Resource");
        logger.info("Result " + resourceList);
        return new Response("Success", "Fetch Data Successfully", resourceList);
    }

    @Override
    public Response findAllResourceTypeSearch(ResourceTypeSearch resourceTypeSearch) {
        String query = "select * from resource_type";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(resourceTypeSearch.getResourceTypeId())) {
            inQuery.put("resource_type_id", this.queryBuilder("resource_type_id", resourceTypeSearch.getResourceTypeId()));
        }
        if (isNotNull(resourceTypeSearch.getResourceTypeUuid())) {
            inQuery.put("resource_type_uuid", this.queryBuilderV2("resource_type_uuid", resourceTypeSearch.getResourceTypeUuid()));
        }
        if (isNotNull(resourceTypeSearch.getResourceTypeName())) {
            inQuery.put("resource_type_name", this.queryBuilderV2("resource_type_name", resourceTypeSearch.getResourceTypeName()));
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(resourceTypeSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, resourceTypeSearch.getUpdateFromDate());
            if (resourceTypeSearch.getUpdateToDate() == null || resourceTypeSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(resourceTypeSearch.getUpdateToDate())) {
            if (resourceTypeSearch.getUpdateFromDate() == null || resourceTypeSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", resourceTypeSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        /**
         *String betweenQuery = "created_dts BETWEEN '%s'";
         * if (isNotNull(resourceTypeSearch.getFromDate())) {
         *     betweenQuery= String.format(betweenQuery, resourceTypeSearch.getFromDate());
         *     if (resourceTypeSearch.getToDate() == null || resourceTypeSearch.getToDate().equals("")) {
         *         betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
         *     }
         *     inQuery.put("created_dts",betweenQuery);
         * }
         * if (isNotNull(resourceTypeSearch.getToDate())) {
         *     if (resourceTypeSearch.getFromDate() == null || resourceTypeSearch.getFromDate().equals("")) {
         *         betweenQuery= String.format(betweenQuery, LocalDate.now());
         *     }
         *     betweenQuery= String.format(betweenQuery+" and '%s'", resourceTypeSearch.getToDate());
         *     inQuery.put("created_dts",betweenQuery);
         * }
         * */
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<ResourceType> resourceTypeList = (List<ResourceType>) this.queryServices.executeQueryV2(query, "ResourceType");
        logger.info("Result " + resourceTypeList);
        return new Response("Success", "Fetch Data Successfully", resourceTypeList);
    }

    @Override
    public Response findAllRolePermissionSearch(RolePermissionSearch rolePermissionSearch) {
        String query = "select * from role_permission";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(rolePermissionSearch.getRolePermissionId())) {
            inQuery.put("role_permission_id", this.queryBuilder("role_permission_id", rolePermissionSearch.getRolePermissionId()));
        }
        if (isNotNull(rolePermissionSearch.getRolePermissionUuid())) {
            inQuery.put("role_permission_uuid", this.queryBuilderV2("role_permission_uuid", rolePermissionSearch.getRolePermissionUuid()));
        }
        if (isNotNull(rolePermissionSearch.getRoleId())) {
            inQuery.put("role_id", this.queryBuilderV2("role_id", rolePermissionSearch.getRoleId()));
        }
        if (isNotNull(rolePermissionSearch.getPermissionId())) {
            inQuery.put("permission_id", this.queryBuilderV2("permission_id", rolePermissionSearch.getPermissionId()));
        }
        if (isNotNull(rolePermissionSearch.getRolePermissionAuthorizationUserId())) {
            inQuery.put("role_permission_authorization_user_id", this.queryBuilderV2("role_permission_authorization_user_id", rolePermissionSearch.getRolePermissionAuthorizationUserId()));
        }
        if (isNotNull(rolePermissionSearch.getRolePermissionAvailableIndicator())) {
            inQuery.put("role_permission_available_indicator", this.queryBuilderV2("role_permission_available_indicator", rolePermissionSearch.getRolePermissionAvailableIndicator()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(rolePermissionSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, rolePermissionSearch.getFromDate());
            if (rolePermissionSearch.getToDate() == null || rolePermissionSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(rolePermissionSearch.getToDate())) {
            if (rolePermissionSearch.getFromDate() == null || rolePermissionSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", rolePermissionSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(rolePermissionSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, rolePermissionSearch.getUpdateFromDate());
            if (rolePermissionSearch.getUpdateToDate() == null || rolePermissionSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(rolePermissionSearch.getUpdateToDate())) {
            if (rolePermissionSearch.getUpdateFromDate() == null || rolePermissionSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", rolePermissionSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<RolePermission> rolePermissionList = (List<RolePermission>) this.queryServices.executeQueryV2(query, "RolePermission");
        logger.info("Result " + rolePermissionList);
        return new Response("Success", "Fetch Data Successfully", rolePermissionList);
    }

    @Override
    public Response findAllRoleSearch(RoleSearch roleSearch) {
        String query = "select * from role";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(roleSearch.getRoleId())) {
            inQuery.put("role_id", this.queryBuilder("role_id", roleSearch.getRoleId()));
        }
        if (isNotNull(roleSearch.getRoleUuid())) {
            inQuery.put("role_uuid", this.queryBuilderV2("role_uuid", roleSearch.getRoleUuid()));
        }
        if (isNotNull(roleSearch.getRoleName())) {
            inQuery.put("role_name", this.queryBuilderV2("role_name", roleSearch.getRoleName()));
        }
        if (isNotNull(roleSearch.getRoleType())) {
            inQuery.put("role_type", this.queryBuilderV2("role_type", roleSearch.getRoleType()));
        }
        if (isNotNull(roleSearch.getRoleLabel())) {
            inQuery.put("role_label", this.queryBuilderV2("role_label", roleSearch.getRoleLabel()));
        }
        if (isNotNull(roleSearch.getRoleIndicator())) {
            inQuery.put("role_indicator", this.queryBuilderV2("role_indicator", roleSearch.getRoleIndicator()));
        }
        if (isNotNull(roleSearch.getRoleAuthUserId())) {
            inQuery.put("role_auth_user_id", this.queryBuilderV2("role_auth_user_id", roleSearch.getRoleAuthUserId()));
        }
        if (isNotNull(roleSearch.getRoleComments())) {
            inQuery.put("role_comments", this.queryBuilderV2("role_comments", roleSearch.getRoleComments()));
        }
        if (isNotNull(roleSearch.getRoleGroup())) {
            inQuery.put("role_group", this.queryBuilderV2("role_group", roleSearch.getRoleGroup()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(roleSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, roleSearch.getFromDate());
            if (roleSearch.getToDate() == null || roleSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(roleSearch.getToDate())) {
            if (roleSearch.getFromDate() == null || roleSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", roleSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(roleSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, roleSearch.getUpdateFromDate());
            if (roleSearch.getUpdateToDate() == null || roleSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(roleSearch.getUpdateToDate())) {
            if (roleSearch.getUpdateFromDate() == null || roleSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", roleSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<Role> roleList = (List<Role>) this.queryServices.executeQueryV2(query, "Role");
        logger.info("Result " + roleList);
        return new Response("Success", "Fetch Data Successfully", roleList);
    }

    @Override
    public Response findAllUserGroupMappingSearch(UserGroupMappingSearch userGroupMappingSearch) {
        String query = "select * from usergroupmapping";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(userGroupMappingSearch.getId())) {
            inQuery.put("id", this.queryBuilder("id", userGroupMappingSearch.getId()));
        }
        if (isNotNull(userGroupMappingSearch.getGroupId())) {
            inQuery.put("groupId", this.queryBuilderV2("groupId", userGroupMappingSearch.getGroupId()));
        }
        if (isNotNull(userGroupMappingSearch.getUserId())) {
            inQuery.put("userId", this.queryBuilderV2("userId", userGroupMappingSearch.getUserId()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(userGroupMappingSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, userGroupMappingSearch.getFromDate());
            if (userGroupMappingSearch.getToDate() == null || userGroupMappingSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(userGroupMappingSearch.getToDate())) {
            if (userGroupMappingSearch.getFromDate() == null || userGroupMappingSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", userGroupMappingSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(userGroupMappingSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, userGroupMappingSearch.getUpdateFromDate());
            if (userGroupMappingSearch.getUpdateToDate() == null || userGroupMappingSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(userGroupMappingSearch.getUpdateToDate())) {
            if (userGroupMappingSearch.getUpdateFromDate() == null || userGroupMappingSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", userGroupMappingSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<UserGroupMapping> userGroupMappingList = (List<UserGroupMapping>) this.queryServices.executeQueryV2(query, "UserGroupMapping");
        logger.info("Result " + userGroupMappingList);
        return new Response("Success", "Fetch Data Successfully", userGroupMappingList);
    }

    @Override
    public Response findAllUserOrganizationMappingSearch(UserOrganizationMappingSearch userOrganizationMappingSearch) {
        String query = "select * from userorganizationmapping";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(userOrganizationMappingSearch.getId())) {
            inQuery.put("id", this.queryBuilder("id", userOrganizationMappingSearch.getId()));
        }
        if (isNotNull(userOrganizationMappingSearch.getOrgId())) {
            inQuery.put("orgId", this.queryBuilderV2("orgId", userOrganizationMappingSearch.getOrgId()));
        }
        if (isNotNull(userOrganizationMappingSearch.getUserId())) {
            inQuery.put("userId", this.queryBuilderV2("userId", userOrganizationMappingSearch.getUserId()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(userOrganizationMappingSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, userOrganizationMappingSearch.getFromDate());
            if (userOrganizationMappingSearch.getToDate() == null || userOrganizationMappingSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(userOrganizationMappingSearch.getToDate())) {
            if (userOrganizationMappingSearch.getFromDate() == null || userOrganizationMappingSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", userOrganizationMappingSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(userOrganizationMappingSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, userOrganizationMappingSearch.getUpdateFromDate());
            if (userOrganizationMappingSearch.getUpdateToDate() == null || userOrganizationMappingSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(userOrganizationMappingSearch.getUpdateToDate())) {
            if (userOrganizationMappingSearch.getUpdateFromDate() == null || userOrganizationMappingSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", userOrganizationMappingSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<UserOrganizationMapping> userOrganizationMappingList = (List<UserOrganizationMapping>) this.queryServices.executeQueryV2(query, "UserOrganizationMapping");
        logger.info("Result " + userOrganizationMappingList);
        return new Response("Success", "Fetch Data Successfully", userOrganizationMappingList);
    }

    @Override
    public Response findAllUserRoleMappingSearch(UserRoleMappingSearch userRoleMappingSearch) {
        String query = "select * from userrolemapping";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(userRoleMappingSearch.getId())) {
            inQuery.put("id", this.queryBuilder("id", userRoleMappingSearch.getId()));
        }
        if (isNotNull(userRoleMappingSearch.getRoleId())) {
            inQuery.put("roleId", this.queryBuilderV2("roleId", userRoleMappingSearch.getRoleId()));
        }
        if (isNotNull(userRoleMappingSearch.getUserId())) {
            inQuery.put("userId", this.queryBuilderV2("userId", userRoleMappingSearch.getUserId()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(userRoleMappingSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, userRoleMappingSearch.getFromDate());
            if (userRoleMappingSearch.getToDate() == null || userRoleMappingSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(userRoleMappingSearch.getToDate())) {
            if (userRoleMappingSearch.getFromDate() == null || userRoleMappingSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", userRoleMappingSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(userRoleMappingSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, userRoleMappingSearch.getUpdateFromDate());
            if (userRoleMappingSearch.getUpdateToDate() == null || userRoleMappingSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(userRoleMappingSearch.getUpdateToDate())) {
            if (userRoleMappingSearch.getUpdateFromDate() == null || userRoleMappingSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", userRoleMappingSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<UserRoleMapping> userRoleMappingList = (List<UserRoleMapping>) this.queryServices.executeQueryV2(query, "UserRoleMapping");
        logger.info("Result " + userRoleMappingList);
        return new Response("Success", "Fetch Data Successfully", userRoleMappingList);
    }

    @Override
    public Response findAllUserRoleSearch(UserRoleSearch userRoleSearch) {
        String query = "select * from user_role";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(userRoleSearch.getUserRoleId())) {
            inQuery.put("user_role_id", this.queryBuilder("user_role_id", userRoleSearch.getUserRoleId()));
        }
        if (isNotNull(userRoleSearch.getUserRoleUuid())) {
            inQuery.put("user_role_uuid", this.queryBuilderV2("user_role_uuid", userRoleSearch.getUserRoleUuid()));
        }
        if (isNotNull(userRoleSearch.getPermissionId())) {
            inQuery.put("permission_id", this.queryBuilderV2("permission_id", userRoleSearch.getPermissionId()));
        }
        if (isNotNull(userRoleSearch.getUserId())) {
            inQuery.put("user_id", this.queryBuilderV2("user_id", userRoleSearch.getUserId()));
        }
        if (isNotNull(userRoleSearch.getUserRoleAuthorizationUserId())) {
            inQuery.put("user_role_authorization_user_id", this.queryBuilderV2("user_role_authorization_user_id", userRoleSearch.getUserRoleAuthorizationUserId()));
        }
        if (isNotNull(userRoleSearch.getUserRoleAvailableIndicator())) {
            inQuery.put("user_role_available_indicator", this.queryBuilderV2("user_role_available_indicator", userRoleSearch.getUserRoleAvailableIndicator()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(userRoleSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, userRoleSearch.getFromDate());
            if (userRoleSearch.getToDate() == null || userRoleSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(userRoleSearch.getToDate())) {
            if (userRoleSearch.getFromDate() == null || userRoleSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", userRoleSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(userRoleSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, userRoleSearch.getUpdateFromDate());
            if (userRoleSearch.getUpdateToDate() == null || userRoleSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(userRoleSearch.getUpdateToDate())) {
            if (userRoleSearch.getUpdateFromDate() == null || userRoleSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", userRoleSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<UserRole> userRoleList = (List<UserRole>) this.queryServices.executeQueryV2(query, "UserRole");
        logger.info("Result " + userRoleList);
        return new Response("Success", "Fetch Data Successfully", userRoleList);
    }

    @Override
    public Response findAllUserSearch(UserSearch userSearch) {
        String query = "select * from user";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(userSearch.getUserId())) {
            inQuery.put("user_id", this.queryBuilder("user_id", userSearch.getUserId()));
        }
        if (isNotNull(userSearch.getUserUuid())) {
            inQuery.put("user_uuid", this.queryBuilderV2("user_uuid", userSearch.getUserUuid()));
        }
        if (isNotNull(userSearch.getUserFirstName())) {
            inQuery.put("user_first_name", this.queryBuilderV2("user_first_name", userSearch.getUserFirstName()));
        }
        if (isNotNull(userSearch.getUserMiddleName())) {
            inQuery.put("user_middle_name", this.queryBuilderV2("user_middle_name", userSearch.getUserMiddleName()));
        }
        if (isNotNull(userSearch.getUserLastName())) {
            inQuery.put("user_last_name", this.queryBuilderV2("user_last_name", userSearch.getUserLastName()));
        }
        if (isNotNull(userSearch.getAddress())) {
            inQuery.put("address", this.queryBuilderV2("address", userSearch.getAddress()));
        }
        if (isNotNull(userSearch.getUserActivatedDate())) {
            inQuery.put("user_activated_date", this.queryBuilderV2("user_activated_date", userSearch.getUserActivatedDate()));
        }
        if (isNotNull(userSearch.getUserAuthUserId())) {
            inQuery.put("user_auth_user_id", this.queryBuilderV2("user_auth_user_id", userSearch.getUserAuthUserId()));
        }
        if (isNotNull(userSearch.getUserContactnumber())) {
            inQuery.put("user_contactnumber", this.queryBuilderV2("user_contactnumber", userSearch.getUserContactnumber()));
        }
        if (isNotNull(userSearch.getUserEmail())) {
            inQuery.put("user_email", this.queryBuilderV2("user_email", userSearch.getUserEmail()));
        }
        if (isNotNull(userSearch.getUserOrgId())) {
            inQuery.put("user_org_id", this.queryBuilderV2("user_org_id", userSearch.getUserOrgId()));
        }
        if (isNotNull(userSearch.getUserUserId())) {
            inQuery.put("user_user_id", this.queryBuilderV2("user_user_id", userSearch.getUserUserId()));
        }
        String userExpirationDateQuery = "user_expiration_date BETWEEN '%s'";
        if (isNotNull(userSearch.getUserExpirationDateFromDate())) {
            userExpirationDateQuery= String.format(userExpirationDateQuery, userSearch.getUserExpirationDateFromDate());
            if (userSearch.getUserExpirationDateToDate() == null || userSearch.getUserExpirationDateToDate().equals("")) {
                userExpirationDateQuery= String.format(userExpirationDateQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("user_expiration_date",userExpirationDateQuery);
        }
        if (isNotNull(userSearch.getUserExpirationDateToDate())) {
            if (userSearch.getUserExpirationDateFromDate() == null || userSearch.getUserExpirationDateFromDate().equals("")) {
                userExpirationDateQuery= String.format(userExpirationDateQuery, LocalDate.now());
            }
            userExpirationDateQuery= String.format(userExpirationDateQuery+" and '%s'", userSearch.getToDate());
            inQuery.put("user_expiration_date",userExpirationDateQuery);
        }
        String userLastActivityDateQuery = "user_lastactivity_date BETWEEN '%s'";
        if (isNotNull(userSearch.getUserLastActivityDateFromDate())) {
            userLastActivityDateQuery= String.format(userLastActivityDateQuery, userSearch.getUserLastActivityDateFromDate());
            if (userSearch.getUserLastActivityDateToDate() == null || userSearch.getUserLastActivityDateToDate().equals("")) {
                userLastActivityDateQuery= String.format(userLastActivityDateQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("user_lastactivity_date",userLastActivityDateQuery);
        }
        if (isNotNull(userSearch.getUserLastActivityDateToDate())) {
            if (userSearch.getUserLastActivityDateFromDate() == null || userSearch.getUserLastActivityDateFromDate().equals("")) {
                userLastActivityDateQuery= String.format(userLastActivityDateQuery, LocalDate.now());
            }
            userLastActivityDateQuery= String.format(userLastActivityDateQuery+" and '%s'", userSearch.getUserLastActivityDateToDate());
            inQuery.put("user_lastactivity_date",userLastActivityDateQuery);
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(userSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, userSearch.getFromDate());
            if (userSearch.getToDate() == null || userSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(userSearch.getToDate())) {
            if (userSearch.getFromDate() == null || userSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", userSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(userSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, userSearch.getUpdateFromDate());
            if (userSearch.getUpdateToDate() == null || userSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(userSearch.getUpdateToDate())) {
            if (userSearch.getUpdateFromDate() == null || userSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", userSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "User");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllIntAppSearch(IntAppSearch intAppSearch) {
        String query = "select * from int_app";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intAppSearch.getIntAppId())) {
            inQuery.put("int_app_id", this.queryBuilder("int_app_id", intAppSearch.getIntAppId()));
        }
        if (isNotNull(intAppSearch.getIntAppUuId())) {
            inQuery.put("int_app_uuid", this.queryBuilderV2("int_app_uuid", intAppSearch.getIntAppUuId()));
        }
        if (isNotNull(intAppSearch.getIntAppName())) {
            inQuery.put("int_app_name", this.queryBuilderV2("int_app_name", intAppSearch.getIntAppName()));
        }
        if (isNotNull(intAppSearch.getIntAppOrgId())) {
            inQuery.put("int_app_orgid", this.queryBuilderV2("int_app_orgid", intAppSearch.getIntAppOrgId()));
        }
        if (isNotNull(intAppSearch.getIntAppOrgUUId())) {
            inQuery.put("int_app_orguuid", this.queryBuilderV2("int_app_orguuid", intAppSearch.getIntAppOrgUUId()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intAppSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, intAppSearch.getFromDate());
            if (intAppSearch.getToDate() == null || intAppSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(intAppSearch.getToDate())) {
            if (intAppSearch.getFromDate() == null || intAppSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", intAppSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intAppSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intAppSearch.getUpdateFromDate());
            if (intAppSearch.getUpdateToDate() == null || intAppSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intAppSearch.getUpdateToDate())) {
            if (intAppSearch.getUpdateFromDate() == null || intAppSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intAppSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "IntApp");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllIntEnvTypeSearch(IntEnvTypeSearch intEnvTypeSearch) {
        String query = "select * from int_env_type";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intEnvTypeSearch.getIntEnvTypeId())) {
            inQuery.put("int_env_type_id", this.queryBuilder("int_env_type_id", intEnvTypeSearch.getIntEnvTypeId()));
        }
        if (isNotNull(intEnvTypeSearch.getIntEnvTypeUuid())) {
            inQuery.put("int_env_type_uuid", this.queryBuilderV2("int_env_type_uuid", intEnvTypeSearch.getIntEnvTypeUuid()));
        }
        if (isNotNull(intEnvTypeSearch.getIntEnvTypeName())) {
            inQuery.put("int_env_type_name", this.queryBuilderV2("int_env_type_name", intEnvTypeSearch.getIntEnvTypeName()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intEnvTypeSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, intEnvTypeSearch.getFromDate());
            if (intEnvTypeSearch.getToDate() == null || intEnvTypeSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(intEnvTypeSearch.getToDate())) {
            if (intEnvTypeSearch.getFromDate() == null || intEnvTypeSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", intEnvTypeSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intEnvTypeSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intEnvTypeSearch.getUpdateFromDate());
            if (intEnvTypeSearch.getUpdateToDate() == null || intEnvTypeSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intEnvTypeSearch.getUpdateToDate())) {
            if (intEnvTypeSearch.getUpdateFromDate() == null || intEnvTypeSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intEnvTypeSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "IntEnvType");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllIntLogLevelTypeSearch(IntLogLevelTypeSearch intLogLevelTypeSearch) {
        String query = "select * from int_log_level_type";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intLogLevelTypeSearch.getIntLogLevelTypeId())) {
            inQuery.put("int_log_level_type_id", this.queryBuilder("int_log_level_type_id", intLogLevelTypeSearch.getIntLogLevelTypeId()));
        }
        if (isNotNull(intLogLevelTypeSearch.getIntLogLevelTypeUuid())) {
            inQuery.put("int_log_level_type_uuid", this.queryBuilderV2("int_log_level_type_uuid", intLogLevelTypeSearch.getIntLogLevelTypeUuid()));
        }
        if (isNotNull(intLogLevelTypeSearch.getIntLogLevelTypeName())) {
            inQuery.put("int_log_level_type_name", this.queryBuilderV2("int_log_level_type_name", intLogLevelTypeSearch.getIntLogLevelTypeName()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intLogLevelTypeSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, intLogLevelTypeSearch.getFromDate());
            if (intLogLevelTypeSearch.getToDate() == null || intLogLevelTypeSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(intLogLevelTypeSearch.getToDate())) {
            if (intLogLevelTypeSearch.getFromDate() == null || intLogLevelTypeSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", intLogLevelTypeSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intLogLevelTypeSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intLogLevelTypeSearch.getUpdateFromDate());
            if (intLogLevelTypeSearch.getUpdateToDate() == null || intLogLevelTypeSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intLogLevelTypeSearch.getUpdateToDate())) {
            if (intLogLevelTypeSearch.getUpdateFromDate() == null || intLogLevelTypeSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intLogLevelTypeSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "IntLogLevelType");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllIntLogTypSearch(IntLogTypeSearch intLogTypeSearch) {
        String query = "select * from int_log_type";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intLogTypeSearch.getIntLogTypeId())) {
            inQuery.put("int_log_type_id", this.queryBuilder("int_log_type_id", intLogTypeSearch.getIntLogTypeId()));
        }
        if (isNotNull(intLogTypeSearch.getIntLogTypeUuid())) {
            inQuery.put("int_log_type_uuid", this.queryBuilderV2("int_log_type_uuid", intLogTypeSearch.getIntLogTypeUuid()));
        }
        if (isNotNull(intLogTypeSearch.getIntLogTypeName())) {
            inQuery.put("int_log_type_name", this.queryBuilderV2("int_log_type_name", intLogTypeSearch.getIntLogTypeName()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intLogTypeSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, intLogTypeSearch.getFromDate());
            if (intLogTypeSearch.getToDate() == null || intLogTypeSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(intLogTypeSearch.getToDate())) {
            if (intLogTypeSearch.getFromDate() == null || intLogTypeSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", intLogTypeSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intLogTypeSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intLogTypeSearch.getUpdateFromDate());
            if (intLogTypeSearch.getUpdateToDate() == null || intLogTypeSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intLogTypeSearch.getUpdateToDate())) {
            if (intLogTypeSearch.getUpdateFromDate() == null || intLogTypeSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intLogTypeSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "IntLogType");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllOrganizationDepartmentSearch(OrganizationDepartmentSearch organizationDepartmentSearch) {
        String query = "select * from organization_department";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(organizationDepartmentSearch.getOrganizationDepartmentId())) {
            inQuery.put("Organization_department_id", this.queryBuilder("Organization_department_id", organizationDepartmentSearch.getOrganizationDepartmentId()));
        }
        if (isNotNull(organizationDepartmentSearch.getOrganizationDepartmentUuid())) {
            inQuery.put("Organization_department_uuid", this.queryBuilderV2("Organization_department_uuid", organizationDepartmentSearch.getOrganizationDepartmentUuid()));
        }
        if (isNotNull(organizationDepartmentSearch.getOrganizationUuid())) {
            inQuery.put("Organization_uuid", this.queryBuilderV2("Organization_uuid", organizationDepartmentSearch.getOrganizationUuid()));
        }
        if (isNotNull(organizationDepartmentSearch.getDepartmentLookupUuid())) {
            inQuery.put("department_lookup_uuid", this.queryBuilderV2("department_lookup_uuid", organizationDepartmentSearch.getDepartmentLookupUuid()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(organizationDepartmentSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, organizationDepartmentSearch.getFromDate());
            if (organizationDepartmentSearch.getToDate() == null || organizationDepartmentSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(organizationDepartmentSearch.getToDate())) {
            if (organizationDepartmentSearch.getFromDate() == null || organizationDepartmentSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", organizationDepartmentSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(organizationDepartmentSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, organizationDepartmentSearch.getUpdateFromDate());
            if (organizationDepartmentSearch.getUpdateToDate() == null || organizationDepartmentSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(organizationDepartmentSearch.getUpdateToDate())) {
            if (organizationDepartmentSearch.getUpdateFromDate() == null || organizationDepartmentSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", organizationDepartmentSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "OrganizationDepartment");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllIntTransSearch(IntTransSearch intTransSearch) {
        String query = "select * from int_trans";
        Map<String, String> inQuery = new HashMap<>();
        if (isNotNull(intTransSearch.getIntTransId())) {
            inQuery.put("int_trans_id", this.queryBuilder("int_trans_id", intTransSearch.getIntTransId()));
        }
        if (isNotNull(intTransSearch.getIntTransUuid())) {
            inQuery.put("int_trans_uuid", this.queryBuilderV2("int_trans_uuid", intTransSearch.getIntTransUuid()));
        }
        if (isNotNull(intTransSearch.getIntDetailLogSysId())) {
            inQuery.put("int_detail_log_sys_id", this.queryBuilderV2("int_detail_log_sys_id", intTransSearch.getIntDetailLogSysId()));
        }
        if (isNotNull(intTransSearch.getIntDetailLogSysName())) {
            inQuery.put("int_detail_log_sys_name", this.queryBuilderV2("int_detail_log_sys_name", intTransSearch.getIntDetailLogSysName()));
        }
        if (isNotNull(intTransSearch.getIntDetailLogSysUuid())) {
            inQuery.put("int_detail_log_sys_uuid", this.queryBuilderV2("int_detail_log_sys_uuid", intTransSearch.getIntDetailLogSysUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransAppId())) {
            inQuery.put("int_trans_app_id", this.queryBuilderV2("int_trans_app_id", intTransSearch.getIntTransAppId()));
        }
        if (isNotNull(intTransSearch.getIntTransAppName())) {
            inQuery.put("int_trans_app_name", this.queryBuilderV2("int_trans_app_name", intTransSearch.getIntTransAppName()));
        }
        if (isNotNull(intTransSearch.getIntTransAppUuid())) {
            inQuery.put("int_trans_app_uuid", this.queryBuilderV2("int_trans_app_uuid", intTransSearch.getIntTransAppUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransBusName1())) {
            inQuery.put("int_trans_bus_name1", this.queryBuilderV2("int_trans_bus_name1", intTransSearch.getIntTransBusName1()));
        }
        if (isNotNull(intTransSearch.getIntTransBusName2())) {
            inQuery.put("int_trans_bus_name2", this.queryBuilderV2("int_trans_bus_name2", intTransSearch.getIntTransBusName2()));
        }
        if (isNotNull(intTransSearch.getIntTransBusName3())) {
            inQuery.put("int_trans_bus_name3", this.queryBuilderV2("int_trans_bus_name3", intTransSearch.getIntTransBusName3()));
        }
        if (isNotNull(intTransSearch.getIntTransBusName4())) {
            inQuery.put("int_trans_bus_name4", this.queryBuilderV2("int_trans_bus_name4", intTransSearch.getIntTransBusName4()));
        }
        if (isNotNull(intTransSearch.getIntTransBusName5())) {
            inQuery.put("int_trans_bus_name5", this.queryBuilderV2("int_trans_bus_name5", intTransSearch.getIntTransBusName5()));
        }
        if (isNotNull(intTransSearch.getIntTransBusVal1())) {
            inQuery.put("int_trans_bus_val1", this.queryBuilderV2("int_trans_bus_val1", intTransSearch.getIntTransBusVal1()));
        }
        if (isNotNull(intTransSearch.getIntTransBusVal2())) {
            inQuery.put("int_trans_bus_val2", this.queryBuilderV2("int_trans_bus_val2", intTransSearch.getIntTransBusVal2()));
        }
        if (isNotNull(intTransSearch.getIntTransBusVal3())) {
            inQuery.put("int_trans_bus_val3", this.queryBuilderV2("int_trans_bus_val3", intTransSearch.getIntTransBusVal3()));
        }
        if (isNotNull(intTransSearch.getIntTransBusVal4())) {
            inQuery.put("int_trans_bus_val4", this.queryBuilderV2("int_trans_bus_val4", intTransSearch.getIntTransBusVal4()));
        }
        if (isNotNull(intTransSearch.getIntTransBusVal5())) {
            inQuery.put("int_trans_bus_val5", this.queryBuilderV2("int_trans_bus_val5", intTransSearch.getIntTransBusVal5()));
        }
        if (isNotNull(intTransSearch.getIntTransDesc())) {
            inQuery.put("int_trans_desc", this.queryBuilderV2("int_trans_desc", intTransSearch.getIntTransDesc()));
        }
        if (isNotNull(intTransSearch.getIntTransEnvId())) {
            inQuery.put("int_trans_env_id", this.queryBuilderV2("int_trans_env_id", intTransSearch.getIntTransEnvId()));
        }
        if (isNotNull(intTransSearch.getIntTransEnvName())) {
            inQuery.put("int_trans_env_name", this.queryBuilderV2("int_trans_env_name", intTransSearch.getIntTransEnvName()));
        }
        if (isNotNull(intTransSearch.getIntTransEnvUuid())) {
            inQuery.put("int_trans_env_uuid", this.queryBuilderV2("int_trans_env_uuid", intTransSearch.getIntTransEnvUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransLogLevelId())) {
            inQuery.put("int_trans_log_level_id", this.queryBuilderV2("int_trans_log_level_id", intTransSearch.getIntTransLogLevelId()));
        }
        if (isNotNull(intTransSearch.getIntTransLogLevelName())) {
            inQuery.put("int_trans_log_level_name", this.queryBuilderV2("int_trans_log_level_name", intTransSearch.getIntTransLogLevelName()));
        }
        if (isNotNull(intTransSearch.getIntTransLogLevelUuid())) {
            inQuery.put("int_trans_log_level_uuid", this.queryBuilderV2("int_trans_log_level_uuid", intTransSearch.getIntTransLogLevelUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransLogTypeId())) {
            inQuery.put("int_trans_log_type_id", this.queryBuilderV2("int_trans_log_type_id", intTransSearch.getIntTransLogTypeId()));
        }
        if (isNotNull(intTransSearch.getIntTransLogTypeName())) {
            inQuery.put("int_trans_log_type_name", this.queryBuilderV2("int_trans_log_type_name", intTransSearch.getIntTransLogTypeName()));
        }
        if (isNotNull(intTransSearch.getIntTransLogTypeUuid())) {
            inQuery.put("int_trans_log_type_uuid", this.queryBuilderV2("int_trans_log_type_uuid", intTransSearch.getIntTransLogTypeUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransName())) {
            inQuery.put("int_trans_name", this.queryBuilderV2("int_trans_name", intTransSearch.getIntTransName()));
        }
        if (isNotNull(intTransSearch.getIntTransOrgDepId())) {
            inQuery.put("int_trans_org_dep_id", this.queryBuilderV2("int_trans_org_dep_id", intTransSearch.getIntTransOrgDepId()));
        }
        if (isNotNull(intTransSearch.getIntTransOrgDepName())) {
            inQuery.put("int_trans_org_dep_name", this.queryBuilderV2("int_trans_org_dep_name", intTransSearch.getIntTransOrgDepName()));
        }
        if (isNotNull(intTransSearch.getIntTransOrgDepUuid())) {
            inQuery.put("int_trans_org_dep_uuid", this.queryBuilderV2("int_trans_org_dep_uuid", intTransSearch.getIntTransOrgDepUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransOrgId())) {
            inQuery.put("int_trans_org_id", this.queryBuilderV2("int_trans_org_id", intTransSearch.getIntTransOrgId()));
        }
        if (isNotNull(intTransSearch.getIntTransOrgName())) {
            inQuery.put("int_trans_org_name", this.queryBuilderV2("int_trans_org_name", intTransSearch.getIntTransOrgName()));
        }
        if (isNotNull(intTransSearch.getIntTransOrgUuid())) {
            inQuery.put("int_trans_org_uuid", this.queryBuilderV2("int_trans_org_uuid", intTransSearch.getIntTransOrgUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransPayload())) {
            inQuery.put("int_trans_payload", this.queryBuilderV2("int_trans_payload", intTransSearch.getIntTransPayload()));
        }
        if (isNotNull(intTransSearch.getIntTransPlayloadBlob())) {
            inQuery.put("int_trans_playload_blob", this.queryBuilderV2("int_trans_playload_blob", intTransSearch.getIntTransPlayloadBlob()));
        }
        if (isNotNull(intTransSearch.getIntTransShortDesc())) {
            inQuery.put("int_trans_shortdesc", this.queryBuilderV2("int_trans_shortdesc", intTransSearch.getIntTransShortDesc()));
        }
        if (isNotNull(intTransSearch.getIntTransSrcSystemTransId())) {
            inQuery.put("int_trans_src_system_transid", this.queryBuilderV2("int_trans_src_system_transid", intTransSearch.getIntTransSrcSystemTransId()));
        }
        if (isNotNull(intTransSearch.getIntTransSrcSystemTransuuid())) {
            inQuery.put("int_trans_src_system_transuuid", this.queryBuilderV2("int_trans_src_system_transuuid", intTransSearch.getIntTransSrcSystemTransuuid()));
        }
        if (isNotNull(intTransSearch.getIntTransSrcSystemUuid())) {
            inQuery.put("int_trans_src_system_uuid", this.queryBuilderV2("int_trans_src_system_uuid", intTransSearch.getIntTransSrcSystemUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransSrcSystemId())) {
            inQuery.put("int_trans_src_systemid", this.queryBuilderV2("int_trans_src_systemid", intTransSearch.getIntTransSrcSystemId()));
        }
        if (isNotNull(intTransSearch.getIntTransTechName1())) {
            inQuery.put("int_trans_tech_name1", this.queryBuilderV2("int_trans_tech_name1", intTransSearch.getIntTransTechName1()));
        }
        if (isNotNull(intTransSearch.getIntTransTechName2())) {
            inQuery.put("int_trans_tech_name2", this.queryBuilderV2("int_trans_tech_name2", intTransSearch.getIntTransTechName2()));
        }
        if (isNotNull(intTransSearch.getIntTransTechName3())) {
            inQuery.put("int_trans_tech_name3", this.queryBuilderV2("int_trans_tech_name3", intTransSearch.getIntTransTechName3()));
        }
        if (isNotNull(intTransSearch.getIntTransTechName4())) {
            inQuery.put("int_trans_tech_name4", this.queryBuilderV2("int_trans_tech_name4", intTransSearch.getIntTransTechName4()));
        }
        if (isNotNull(intTransSearch.getIntTransTechName5())) {
            inQuery.put("int_trans_tech_name5", this.queryBuilderV2("int_trans_tech_name5", intTransSearch.getIntTransTechName5()));
        }
        if (isNotNull(intTransSearch.getIntTransTechVal1())) {
            inQuery.put("int_trans_tech_val1", this.queryBuilderV2("int_trans_tech_val1", intTransSearch.getIntTransTechVal1()));
        }
        if (isNotNull(intTransSearch.getIntTransTechVal2())) {
            inQuery.put("int_trans_tech_val2", this.queryBuilderV2("int_trans_tech_val2", intTransSearch.getIntTransTechVal2()));
        }
        if (isNotNull(intTransSearch.getIntTransTechVal3())) {
            inQuery.put("int_trans_tech_val3", this.queryBuilderV2("int_trans_tech_val3", intTransSearch.getIntTransTechVal3()));
        }
        if (isNotNull(intTransSearch.getIntTransTechVal4())) {
            inQuery.put("int_trans_tech_val4", this.queryBuilderV2("int_trans_tech_val4", intTransSearch.getIntTransTechVal4()));
        }
        if (isNotNull(intTransSearch.getIntTransTechVal5())) {
            inQuery.put("int_trans_tech_val5", this.queryBuilderV2("int_trans_tech_val5", intTransSearch.getIntTransTechVal5()));
        }
        if (isNotNull(intTransSearch.getIntTransTransChildId())) {
            inQuery.put("int_trans_transchildid", this.queryBuilderV2("int_trans_transchildid", intTransSearch.getIntTransTransChildId()));
        }
        if (isNotNull(intTransSearch.getIntTransTransChildUuid())) {
            inQuery.put("int_trans_transchilduuid", this.queryBuilderV2("int_trans_transchilduuid", intTransSearch.getIntTransTransChildUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransTransParentId())) {
            inQuery.put("int_trans_transparentid", this.queryBuilderV2("int_trans_transparentid", intTransSearch.getIntTransTransParentId()));
        }
        if (isNotNull(intTransSearch.getIntTransTransParentUuid())) {
            inQuery.put("int_trans_transparentuuid", this.queryBuilderV2("int_trans_transparentuuid", intTransSearch.getIntTransTransParentUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransTrgSystemUuid())) {
            inQuery.put("int_trans_trg_system_uuid", this.queryBuilderV2("int_trans_trg_system_uuid", intTransSearch.getIntTransTrgSystemUuid()));
        }
        if (isNotNull(intTransSearch.getIntTransTrgSystemId())) {
            inQuery.put("int_trans_trg_systemid", this.queryBuilderV2("int_trans_trg_systemid", intTransSearch.getIntTransTrgSystemId()));
        }
        String betweenQuery = "created_dts BETWEEN '%s'";
        if (isNotNull(intTransSearch.getFromDate())) {
            betweenQuery= String.format(betweenQuery, intTransSearch.getFromDate());
            if (intTransSearch.getToDate() == null || intTransSearch.getToDate().equals("")) {
                betweenQuery= String.format(betweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("created_dts",betweenQuery);
        }
        if (isNotNull(intTransSearch.getToDate())) {
            if (intTransSearch.getFromDate() == null || intTransSearch.getFromDate().equals("")) {
                betweenQuery= String.format(betweenQuery, LocalDate.now());
            }
            betweenQuery= String.format(betweenQuery+" and '%s'", intTransSearch.getToDate());
            inQuery.put("created_dts",betweenQuery);
        }
        String updatedBetweenQuery = "updated_dts BETWEEN '%s'";
        if (isNotNull(intTransSearch.getUpdateFromDate())) {
            updatedBetweenQuery= String.format(updatedBetweenQuery, intTransSearch.getUpdateFromDate());
            if (intTransSearch.getUpdateToDate() == null || intTransSearch.getUpdateToDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", LocalDate.now());
            }
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (isNotNull(intTransSearch.getUpdateToDate())) {
            if (intTransSearch.getUpdateFromDate() == null || intTransSearch.getUpdateFromDate().equals("")) {
                updatedBetweenQuery= String.format(updatedBetweenQuery, LocalDate.now());
            }
            updatedBetweenQuery= String.format(updatedBetweenQuery+" and '%s'", intTransSearch.getUpdateToDate());
            inQuery.put("updated_dts",updatedBetweenQuery);
        }
        if (inQuery.size() > 0) {
            query += " where ";
            Iterator it = inQuery.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if (it.hasNext()) {
                    query += pair.getValue() + " and ";
                } else {
                    query += pair.getValue();
                }
                it.remove();
            }
        }
        List<User> userList = (List<User>) this.queryServices.executeQueryV2(query, "IntTrans");
        logger.info("Result " + userList);
        return new Response("Success", "Fetch Data Successfully", userList);
    }

    @Override
    public Response findAllLoginUserRole(String username) {
        String query  = "SELECT role_name,group_name,permission_uuid,permission_name,permission_resource_id,permission_resource_uuid,\n" +
        "permission_available_indicator,permission_create,permission_create_permission_type_id,\n" +
        "permission_delete,permission_delete_permission_type_\u206Fid,permission_update,\n" +
        "permission_update_permission_type_\u206Fid,permission_read,permission_read_permission_type_\u206Fid,\n" +
        "permission_softdelete,permission_softdelete_permission_type_\u206Fid,permission_operater_id,\n" +
        "permission_authorize_user_id" +
        " FROM eventadministrationdb.permissionlist_v where roleuuid in (select roleid from userrolemapping " +
        "where userid = (SELECT user_uuid FROM eventadministrationdb.user where  user_user_id = '"+username+"'))\n" +
        "union all\n" +
        "SELECT role_name,group_name,permission_uuid,permission_name,permission_resource_id,permission_resource_uuid,\n" +
        "permission_available_indicator,permission_create,permission_create_permission_type_id,\n" +
        "permission_delete,permission_delete_permission_type_\u206Fid,permission_update,\n" +
        "permission_update_permission_type_\u206Fid,permission_read,permission_read_permission_type_\u206Fid,\n" +
        "permission_softdelete,permission_softdelete_permission_type_\u206Fid,permission_operater_id,\n" +
        "permission_authorize_user_id" +
        " FROM eventadministrationdb.permissionlist_v where group_uuid in (select groupid from usergroupmapping " +
        "where userid = (SELECT user_uuid FROM eventadministrationdb.user where user_user_id = '"+username+"'));";
        return new Response("Success", "Fetch Data Successfully",
                this.queryServices.executeQuery(query).stream().map(objects -> {
                    PermissionListView permissionListView = new PermissionListView();
                    permissionListView.setRoleName(String.valueOf(objects[0]));
                    permissionListView.setGroupName(String.valueOf(objects[1]));
                    permissionListView.setPermissionUuid(String.valueOf(objects[2]));
                    permissionListView.setPermissionName(String.valueOf(objects[3]));
                    permissionListView.setPermissionResourceId(String.valueOf(objects[4]));
                    permissionListView.setPermissionResourceUuid(String.valueOf(objects[5]));
                    permissionListView.setPermissionAvailableIndicator(String.valueOf(objects[6]));
                    permissionListView.setPermissionCreate(String.valueOf(objects[7]));
                    permissionListView.setPermissionCreatePermissionTypeId(String.valueOf(objects[8]));
                    permissionListView.setPermissionDelete(String.valueOf(objects[9]));
                    permissionListView.setPermissionDeletePermissionTypeId(String.valueOf(objects[10]));
                    permissionListView.setPermissionUpdate(String.valueOf(objects[11]));
                    permissionListView.setPermissionUpdatePermissionTypeId(String.valueOf(objects[12]));
                    permissionListView.setPermissionRead(String.valueOf(objects[13]));
                    permissionListView.setPermissionReadPermissionTypeId(String.valueOf(objects[14]));
                    permissionListView.setPermissionSoftDelete(String.valueOf(objects[15]));
                    permissionListView.setPermissionDeletePermissionTypeId(String.valueOf(objects[16]));
                    permissionListView.setPermissionOperaterId(String.valueOf(objects[17]));
                    permissionListView.setPermissionAuthorizeUserId(String.valueOf(objects[18]));
                    return permissionListView;
                }).collect(Collectors.toList()));
    }



    private String queryBuilder(String key, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(key+" in (").append(value.replace("|", ",")).append(")");
        return stringBuilder.toString();
    }

    public String queryBuilderV2(String key, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        value = value.replace("|", ",");
        stringBuilder.append(key+" in (");
        String values[] = value.split(",");
        for (int i=0; i<values.length; i++) {
            if (values.length-1 == i) {
                stringBuilder.append("'"+values[i]+"'");
            } else {
                stringBuilder.append("'"+values[i]+"',");
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean isNotNull(String key) {
        if (key != null && !key.equals("")) {
            return true;
        }
        return false;
    }

}
