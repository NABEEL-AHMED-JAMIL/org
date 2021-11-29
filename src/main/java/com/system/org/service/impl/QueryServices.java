package com.system.org.service.impl;

import com.system.org.model.*;
import com.system.org.model.view.PermissionListView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class QueryServices {

    public Logger logger = LogManager.getLogger(QueryServices.class);

    @PersistenceContext
    private EntityManager _em;

    public List<Object[]> executeQuery(String queryStr) {
        logger.debug("Execute Query :- " + queryStr);
        Query query = this._em.createNativeQuery(queryStr);
        return query.getResultList();
    }

    public List<?> executeQueryV2(String queryStr, String classType) {
        logger.debug("Execute Query :- " + queryStr);
        Query query = null;
        if (classType.equals("Group")) {
            query = this._em.createNativeQuery(queryStr, Group.class);
        } else if (classType.equals("IntCmdImp")) {
            query = this._em.createNativeQuery(queryStr, IntCmdImp.class);
        } else if (classType.equals("IntCmdParam")) {
            query = this._em.createNativeQuery(queryStr, IntCmdParam.class);
        } else if (classType.equals("IntCmd")) {
            query = this._em.createNativeQuery(queryStr, IntCmd.class);
        } else if (classType.equals("IntParams")) {
            query = this._em.createNativeQuery(queryStr, IntParams.class);
        } else if (classType.equals("IntType")) {
            query = this._em.createNativeQuery(queryStr, IntType.class);
        } else if (classType.equals("ModulesLookup")) {
            query = this._em.createNativeQuery(queryStr, ModulesLookup.class);
        } else if (classType.equals("OrganizationModule")) {
            query = this._em.createNativeQuery(queryStr, OrganizationModule.class);
        } else if (classType.equals("Organization")) {
            query = this._em.createNativeQuery(queryStr, Organization.class);
        } else if (classType.equals("PermissionResourceModule")) {
            query = this._em.createNativeQuery(queryStr, PermissionResourceModule.class);
        } else if (classType.equals("Permission")) {
            query = this._em.createNativeQuery(queryStr, Permission.class);
        } else if (classType.equals("PermissionType")) {
            query = this._em.createNativeQuery(queryStr, PermissionType.class);
        } else if (classType.equals("ResourceModule")) {
            query = this._em.createNativeQuery(queryStr, ResourceModule.class);
        } else if (classType.equals("Resource")) {
            query = this._em.createNativeQuery(queryStr, Resource.class);
        } else if (classType.equals("ResourceType")) {
            query = this._em.createNativeQuery(queryStr, ResourceType.class);
        } else if (classType.equals("RolePermission")) {
            query = this._em.createNativeQuery(queryStr, RolePermission.class);
        } else if (classType.equals("Role")) {
            query = this._em.createNativeQuery(queryStr, Role.class);
        } else if (classType.equals("UserGroupMapping")) {
            query = this._em.createNativeQuery(queryStr, UserGroupMapping.class);
        } else if (classType.equals("UserOrganizationMapping")) {
            query = this._em.createNativeQuery(queryStr, UserOrganizationMapping.class);
        } else if (classType.equals("UserRoleMapping")) {
            query = this._em.createNativeQuery(queryStr, UserRoleMapping.class);
        } else if (classType.equals("UserRole")) {
            query = this._em.createNativeQuery(queryStr, UserRole.class);
        } else if (classType.equals("User")) {
            query = this._em.createNativeQuery(queryStr, User.class);
        } else if (classType.equals("IntApp")) {
            query = this._em.createNativeQuery(queryStr, IntApp.class);
        } else if (classType.equals("IntEnvType")) {
            query = this._em.createNativeQuery(queryStr, IntEnvType.class);
        } else if (classType.equals("IntLogLevelType")) {
            query = this._em.createNativeQuery(queryStr, IntLogLevelType.class);
        } else if (classType.equals("IntLogType")) {
            query = this._em.createNativeQuery(queryStr, IntLogType.class);
        } else if (classType.equals("OrganizationDepartment")) {
            query = this._em.createNativeQuery(queryStr, OrganizationDepartment.class);
        } else if (classType.equals("IntTrans")) {
            query = this._em.createNativeQuery(queryStr, IntTrans.class);
        } else if (classType.equals("PermissionListView")) {
            query = this._em.createNativeQuery(queryStr, PermissionListView.class);
        }
        return query.getResultList();
    }


    public List<Object[]> executeQuery(String queryStr, Pageable paging) {
        logger.debug("Execute Query :- " + queryStr);
        Query query = this._em.createNativeQuery(queryStr);
        if (paging != null) {
            query.setFirstResult(paging.getPageNumber() * paging.getPageSize());
            query.setMaxResults(paging.getPageSize());
        }
        return query.getResultList();
    }

    public Object executeQueryForSingleResult(String queryStr) {
        logger.debug("Execute Query :- " + queryStr);
        Query query = this._em.createNativeQuery(queryStr);
        return query.getSingleResult();
    }


    public Object save(Object object) {
        logger.debug("Object :- " + object);
        this._em.persist(object);
        this._em.close();
        return object;
    }


}
