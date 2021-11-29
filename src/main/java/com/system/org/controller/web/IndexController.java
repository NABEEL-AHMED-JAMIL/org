package com.system.org.controller.web;

import com.system.org.controller.Response;
import com.system.org.controller.rest.*;
import com.system.org.dto.*;
import com.system.org.dto.search.*;
import com.system.org.exception.ExceptionUtil;

import com.system.org.security.TokenHelper;
import com.system.org.security.UserPrincipal;
import com.system.org.service.AuthTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;


@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private OrganizationRestController organizationRestController;
    @Autowired
    private ModuleLookupRestController moduleLookupRestController;
    @Autowired
    private OrganizationModuleRestController organizationModuleRestController;
    @Autowired
    private ResourceRestController resourceRestController;
    @Autowired
    private ResourceTypeRestController resourceTypeRestController;
    @Autowired
    private ResourceModuleRestController resourceModuleRestController;
    @Autowired
    private PermissionRestController permissionRestController;
    @Autowired
    private PermissionTypeRestController permissionTypeRestController;
    @Autowired
    private PermissionResourceModuleRestController permissionResourceModuleRestController;
    @Autowired
    private UserRestController userRestController;
    @Autowired
    private UserRoleRestController userRoleRestController;
    @Autowired
    private RoleRestController roleRestController;
    @Autowired
    private RolePermissionRestController rolePermissionRestController;
    @Autowired
    private GroupRestController groupRestController;
    @Autowired
    private UserGroupMappingRestController userGroupMappingRestController;
    @Autowired
    private UserOrganizationMappingRestController userOrganizationMappingRestController;
    @Autowired
    private UserRoleMappingRestController userRoleMappingRestController;
    @Autowired
    private IntCmdImpRestController intCmdImpRestController;
    @Autowired
    private IntCmdParamRestController intCmdParamRestController;
    @Autowired
    private IntCmdRestController intCmdRestController;
    @Autowired
    private IntParamsRestController intParamsRestController;
    @Autowired
    private IntTypeRestController intTypeRestController;
    @Autowired
    private IntAppRestController intAppRestController;
    @Autowired
    private IntEnvTypeRestController intEnvTypeRestController;
    @Autowired
    private IntLogLevelTypeRestController intLogLevelTypeRestController;
    @Autowired
    private IntLogTypeRestController intLogTypeRestController;
    @Autowired
    private IntTransRestController intTransRestController;
    @Autowired
    private OrganizationDepartmentRestController organizationDepartmentRestController;
    @Autowired
    private UtilRestController utilRestController;
    @Autowired
    private AuthTokenService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenHelper tokenHelper;


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("jwtAuthenticationRequest", new JwtAuthenticationRequest());
        return mav;
    }

    @GetMapping({"/"})
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("jwtAuthenticationRequest", new JwtAuthenticationRequest());
        return mav;
    }

    @GetMapping({"/index"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        UserPrincipal userPrincipal = getUserPrincipal();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("isOrganizationAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_view")) {
                    return true;
                }
                return false;
            }));
        mav.addObject("isResourceAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_view")) {
                    return true;
                }
                return false;
            }));
        mav.addObject("isIntAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_cmd_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_view")) {
                    return true;
                }
                return false;
            }));
        mav.addObject("isPermissionAccess",  userPrincipal.getPermissionListViews().stream()
                .anyMatch(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_permission_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_permission_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_permission_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_permission_view")) {
                        return true;
                    }
                    return false;
                }));
        mav.addObject("isUserAccess",  userPrincipal.getPermissionListViews().stream()
        .anyMatch(t -> {
            if (t.getRoleName().equalsIgnoreCase("role_user_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_view")) {
                return true;
            }
            return false;
        }));
        mav.addObject("jwtAuthenticationRequest", new JwtAuthenticationRequest());
        return mav;
    }

    @GetMapping({"/organization"})
    public String organization(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isOrganizationDepartmentAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_department_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isOrganizationModuleLinkAccess",  userPrincipal.getPermissionListViews().stream()
                .anyMatch(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_view")) {
                        return true;
                    }
                    return false;
                }));
        return "organization";
    }

    @GetMapping({"/resource"})
    public String resource(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isResourceTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_type_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_type_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_type_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_type_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_module_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_module_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_module_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_module_view")) {
                    return true;
                }
                return false;
            }));
        return "resource";
    }

    @GetMapping({"/permissionView"})
    public String permissionView(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isPermissionTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isPermissionResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_view")) {
                    return true;
                }
                return false;
            }));
        return "permissionView";
    }

    @GetMapping({"/userdetail"})
    public String userdetail(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isUserRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isRolePermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isGroupsAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_groups_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_groups_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_groups_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_groups_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isUsergroupmappingAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_usergroupmapping_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_usergroupmapping_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_usergroupmapping_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_usergroupmapping_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isUserOrganizationMappingAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isUserroleMappingAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_userrolemapping_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_userrolemapping_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_userrolemapping_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_userrolemapping_view")) {
                    return true;
                }
                return false;
            }));
        return "userdetail";
    }

    @GetMapping({"/int"})
    public String iInt(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdImpAccess",  userPrincipal.getPermissionListViews().stream()
                .anyMatch(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_view")) {
                        return true;
                    }
                    return false;
                }));
        model.addAttribute("isIntCmdParamAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_cmd_param_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_view")) {
                    return true;
                }
                return false;
            }));

        model.addAttribute("isIntCmdAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_cmd_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntParamsAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_params_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_params_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_params_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_params_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_type_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntAppAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_app_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_app_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_app_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_app_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntEnvTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_env_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_env_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_env_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_env_type_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntTransAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_trans_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_trans_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_trans_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_trans_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntLogTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_log_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_log_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_log_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_log_type_view")) {
                    return true;
                }
                return false;
            }));
        model.addAttribute("isIntLogLevelTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_log_level_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_log_level_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_log_level_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_log_level_type_view")) {
                    return true;
                }
                return false;
            }));
        return "int";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute("jwtAuthenticationRequest") JwtAuthenticationRequest jwtAuthenticationRequest) {
        logger.info(jwtAuthenticationRequest.toString());
        try {
            final Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                jwtAuthenticationRequest.getUsername(), jwtAuthenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Response response1 = this.authService.login(jwtAuthenticationRequest);
            logger.info("Request for login " + response1);
            if (response1.getStatus().equalsIgnoreCase("SUCCESS")) {
                // user login success
                UserPrincipal userPrincipal = (UserPrincipal)response1.getData();
                Cookie cookie = new Cookie("AUTH-TOKEN", userPrincipal.getToken());
                cookie.setSecure(false);
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                return "redirect:index";
            } else {
                logger.info("User not found");
                return "redirect:login";
            }
        } catch (Exception ex) {
            logger.info("Error during login " + ExceptionUtil.getRootCause(ex));
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/organizationSearch", method = RequestMethod.POST)
    public String organizationSearch(Model model, @ModelAttribute("organizationSearch") OrganizationSearch organizationSearch) {
        logger.info(organizationSearch.toString());
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(isIntAccess -> {
                if (isIntAccess.getRoleName().equalsIgnoreCase("role_organization_superadmin") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_admin") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_editor") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        OrganizationDto organizationDto = new OrganizationDto();
        model.addAttribute("organization", organizationDto);
        model.addAttribute("organizationSearch", organizationSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.organizationRestController.findOrganizationBySearch(organizationSearch).getBody();
        model.addAttribute("organizationList", response.getData());
        return "createOrganization";
    }

    @GetMapping("/createOrganization")
    public String createOrganization(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(isIntAccess -> {
                if (isIntAccess.getRoleName().equalsIgnoreCase("role_organization_superadmin") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_admin") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_editor") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        OrganizationDto organizationDto = new OrganizationDto();
        model.addAttribute("organization", organizationDto);
        OrganizationSearch organizationSearch = new OrganizationSearch();
        model.addAttribute("organizationSearch", organizationSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.organizationRestController.findAllOrganization().getBody();
        model.addAttribute("organizationList", response.getData());
        return "createOrganization";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(Model model, @ModelAttribute("organization") OrganizationDto organization) {
        Response response = (Response) this.organizationRestController.createOrganization(organization).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:index";
        } else {
            model.addAttribute(response);
            return "createOrganization";
        }
    }

    @GetMapping(value="/organizationEdit/{organizationUuid}")
    public String organizationEdit(Model model, @PathVariable String organizationUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(isIntAccess -> {
                if (isIntAccess.getRoleName().equalsIgnoreCase("role_organization_superadmin") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_admin") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_editor") ||
                    isIntAccess.getRoleName().equalsIgnoreCase("role_organization_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.organizationRestController.findOrganizationByOrganizationUuid(organizationUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("organization", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "organizationEdit";
    }

    @RequestMapping(value="/organizationEdit/{organizationUuid}", method=RequestMethod.POST)
    public String organizationEdit(Model model, @PathVariable String organizationUuid, @ModelAttribute("organization") OrganizationDto organization) {
        logger.info(organization.toString());
        Response response = (Response) this.organizationRestController.updateOrganization(organization).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:/index";
        } else {
            model.addAttribute(response);
            return "organizationEdit";
        }
    }

    @RequestMapping(value="/organizationDelete/{organizationUuid}",method = RequestMethod.GET)
    public String organizationDelete(@PathVariable String organizationUuid) {
        Response response = (Response) this.organizationRestController.deleteOrganizationById(organizationUuid).getBody();
        return "redirect:/index";
    }

    @RequestMapping(value = "/moduleSearch", method = RequestMethod.POST)
    public String moduleSearch(Model model, @ModelAttribute("moduleSearch") ModuleSearch moduleSearch) {
        logger.info(moduleSearch.toString());
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_module_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_organization_module_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_organization_module_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_organization_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ModulesLookupDto modulesLookupDto = new ModulesLookupDto();
        model.addAttribute("modulesLookup", modulesLookupDto);
        model.addAttribute("moduleSearch", moduleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.moduleLookupRestController.findAllModulesLookupBySearch(moduleSearch).getBody();
        model.addAttribute("moduleLookupList", response.getData());
        return "createModule";
    }

    @GetMapping("/createModule")
    public String createModule(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ModulesLookupDto modulesLookupDto = new ModulesLookupDto();
        model.addAttribute("modulesLookup", modulesLookupDto);
        ModuleSearch moduleSearch = new ModuleSearch();
        model.addAttribute("moduleSearch", moduleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.moduleLookupRestController.findAllModulesLookup().getBody();
        model.addAttribute("moduleLookupList", response.getData());
        return "createModule";
    }

    @RequestMapping(value = "/createModule", method = RequestMethod.POST)
    public String createModule(Model model, @ModelAttribute("modulesLookup") ModulesLookupDto modulesLookupDto) {
        Response response = (Response) this.moduleLookupRestController.createModulesLookup(modulesLookupDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:index";
        } else {
            // with error message
            model.addAttribute("response", response);
            return "createModule";
        }
    }

    @GetMapping(value="/moduleEdit/{modulesLookupUuid}")
    public String moduleEdit(Model model, @PathVariable String modulesLookupUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.moduleLookupRestController.findModulesLookupByModulesLookupUuid(modulesLookupUuid).getBody();
        model.addAttribute("modulesLookup", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "moduleEdit";
    }

    @RequestMapping(value="/moduleEdit/{modulesLookupUuid}", method=RequestMethod.POST)
    public String moduleEdit(Model model, @PathVariable String modulesLookupUuid, @ModelAttribute("modulesLookup") ModulesLookupDto modulesLookupDto) {
        Response response = (Response) this.moduleLookupRestController.updateModulesLookup(modulesLookupDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/index";
        } else {
            model.addAttribute(response);
            return "moduleEdit";
        }
    }

    @RequestMapping(value="/modulesDelete/{modulesLookupUuid}", method = RequestMethod.GET)
    public String modulesLookupDelete(@PathVariable String modulesLookupUuid) {
        Response response = (Response) this.moduleLookupRestController.deleteModulesLookupByModulesLookupUuid(modulesLookupUuid).getBody();
        return "redirect:/index";
    }

    @RequestMapping(value="/organizationModuleLinkSearch", method = RequestMethod.POST)
    public String organizationModuleLinkSearch(Model model, @ModelAttribute("organizationModuleLinkSearch") OrganizationModuleLinkSearch organizationModuleLinkSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationModuleLinkAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        OrganizationModuleDto organizationModuleDto = new OrganizationModuleDto();
        model.addAttribute("organizationModule", organizationModuleDto);
        model.addAttribute("organizationModuleLinkSearch", organizationModuleLinkSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        response = (Response) this.organizationModuleRestController.findAllOrganizationModuleLinkSearch(organizationModuleLinkSearch).getBody();
        model.addAttribute("organizationModuleList", response.getData());
        return "createOrganizationModuleLink";
    }

    @GetMapping("/createOrganizationModuleLink")
    public String createOrganizationModuleLink(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationModuleLinkAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        OrganizationModuleDto organizationModuleDto = new OrganizationModuleDto();
        model.addAttribute("organizationModule", organizationModuleDto);
        OrganizationModuleLinkSearch organizationModuleLinkSearch = new OrganizationModuleLinkSearch();
        model.addAttribute("organizationModuleLinkSearch", organizationModuleLinkSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        response = (Response) this.organizationModuleRestController.findAllOrganizationModule().getBody();
        model.addAttribute("organizationModuleList", response.getData());
        return "createOrganizationModuleLink";
    }

    @RequestMapping(value = "/createOrganizationModuleLink", method = RequestMethod.POST)
    public String createOrganizationModuleLink(Model model, @ModelAttribute("organizationModule") OrganizationModuleDto organizationModuleDto) {
        Response response = (Response) this.organizationModuleRestController.linkModuleToOrganization(organizationModuleDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:index";
        } else {
            model.addAttribute(response);
            return "createOrganizationModuleLink";
        }
    }

    @GetMapping(value="/organizationModuleLinkEdit/{organizationModuleUuid}")
    public String organizationModuleLinkEdit(Model model, @PathVariable String organizationModuleUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationModuleLinkAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_moduleLink_access_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.organizationModuleRestController.findOrganizationModuleByOrganizationModuleUuid(organizationModuleUuid).getBody();
        model.addAttribute("organizationModule", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        return "organizationModuleLinkEdit";
    }

    @RequestMapping(value="/organizationModuleLinkEdit/{organizationModuleUuid}", method=RequestMethod.POST)
    public String organizationModuleLinkEdit(Model model, @PathVariable String organizationModuleUuid,
        @ModelAttribute("organizationModule") OrganizationModuleDto organizationModuleDto) {
        Response response = (Response) this.organizationModuleRestController.upDateLinkModuleToOrganization(organizationModuleDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/index";
        } else {
            model.addAttribute(response);
            return "organizationModuleLinkEdit";
        }
    }

    @RequestMapping(value="/organizationModuleLinkDelete/{organizationModuleUuid}", method = RequestMethod.GET)
    public String organizationModuleLinkDelete(@PathVariable String organizationModuleUuid) {
        Response response = (Response) this.organizationModuleRestController.deleteOrganizationModuleByOrganizationModuleUuid(organizationModuleUuid).getBody();
        return "redirect:/index";
    }

    @RequestMapping(value="/organizationDepartmentSearch", method = RequestMethod.POST)
    public String organizationDepartmentSearch(Model model, @ModelAttribute("organizationDepartmentSearch")
            OrganizationDepartmentSearch organizationDepartmentSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationDepartmentAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_department_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        OrganizationDepartmentDto organizationDepartmentDto = new OrganizationDepartmentDto();
        model.addAttribute("organizationDepartment", organizationDepartmentDto);
        model.addAttribute("organizationDepartmentSearch", organizationDepartmentSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        response = (Response) this.organizationDepartmentRestController
        .findAllOrganizationDepartmentSearch(organizationDepartmentSearch).getBody();
        model.addAttribute("organizationDepartmentList", response.getData());
        return "createOrganizationDepartment";
    }

    @GetMapping("/createOrganizationDepartment")
    public String createOrganizationDepartment(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationDepartmentAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_department_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        OrganizationDepartmentDto organizationDepartmentDto = new OrganizationDepartmentDto();
        model.addAttribute("organizationDepartment", organizationDepartmentDto);
        OrganizationDepartmentSearch organizationDepartmentSearch = new OrganizationDepartmentSearch();
        model.addAttribute("organizationDepartmentSearch", organizationDepartmentSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        response = (Response) this.organizationDepartmentRestController.findAllOrganizationDepartment().getBody();
        model.addAttribute("organizationDepartmentList", response.getData());
        return "createOrganizationDepartment";
    }

    @RequestMapping(value = "/createOrganizationDepartment", method = RequestMethod.POST)
    public String createOrganizationDepartment(Model model, @ModelAttribute("organizationDepartment")
            OrganizationDepartmentDto organizationDepartmentDto) {
        Response response = (Response) this.organizationDepartmentRestController
            .createOrganizationDepartment(organizationDepartmentDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:organization";
        } else {
            model.addAttribute(response);
            return "createOrganizationDepartment";
        }
    }

    @GetMapping(value="/organizationDepartmentEdit/{organizationDepartmentUuid}")
    public String organizationDepartmentEdit(Model model, @PathVariable String organizationDepartmentUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isOrganizationDepartmentAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_organization_department_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_organization_department_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.organizationDepartmentRestController
        .findOrganizationDepartmentByOrganizationDepartmentUuid(organizationDepartmentUuid).getBody();
        model.addAttribute("organizationDepartment", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        return "organizationDepartmentEdit";
    }

    @RequestMapping(value="/organizationDepartmentEdit/{organizationDepartmentUuid}", method=RequestMethod.POST)
    public String organizationDepartmentEdit(Model model, @PathVariable String organizationDepartmentUuid,
        @ModelAttribute("organizationDepartment") OrganizationDepartmentDto organizationDepartmentDto) {
        Response response = (Response) this.organizationDepartmentRestController
        .updateOrganizationDepartment(organizationDepartmentDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/index";
        } else {
            model.addAttribute(response);
            return "organizationDepartmentEdit";
        }
    }

    @RequestMapping(value="/organizationDepartmentDelete/{organizationDepartmentUuid}", method = RequestMethod.GET)
    public String organizationDepartmentDelete(@PathVariable String organizationDepartmentUuid) {
        Response response = (Response) this.organizationDepartmentRestController.
            deleteOrganizationDepartmentByOrganizationDepartmentUuid(organizationDepartmentUuid).getBody();
        return "redirect:/organization";
    }

    @RequestMapping(value="/resourceSearch", method=RequestMethod.POST)
    public String resourceSearch(Model model, @ModelAttribute("resourceSearch") ResourceSearch resourceSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ResourceDto resourceDto = new ResourceDto();
        model.addAttribute("resource", resourceDto);
        model.addAttribute("resourceSearch", resourceSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceTypeId().getBody();
        model.addAttribute("resourceTypeIds", response.getData());
        response = (Response) this.resourceRestController.findAllResourceSearch(resourceSearch).getBody();
        model.addAttribute("resourceList", response.getData());
        return "createResource";
    }

    @GetMapping("/createResource")
    public String createResource(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ResourceDto resourceDto = new ResourceDto();
        model.addAttribute("resource", resourceDto);
        ResourceSearch resourceSearch = new ResourceSearch();
        model.addAttribute("resourceSearch", resourceSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceTypeId().getBody();
        model.addAttribute("resourceTypeIds", response.getData());
        response = (Response) this.resourceRestController.findAllResource().getBody();
        model.addAttribute("resourceList", response.getData());
        return "createResource";
    }

    @RequestMapping(value = "/createResource", method = RequestMethod.POST)
    public String createResource(Model model, @ModelAttribute("resource") ResourceDto resourceDto) {
        Response response = (Response) this.resourceRestController.createResource(resourceDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:resource";
        } else {
            // with error message
            model.addAttribute("response", response);
            return "createModule";
        }
    }

    @GetMapping(value="/resourceEdit/{resourceUuid}")
    public String resourceEdit(Model model, @PathVariable String resourceUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.resourceRestController.findResourceByResourceUuid(resourceUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("resource", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceTypeId().getBody();
        model.addAttribute("resourceTypeIds", response.getData());
        return "resourceEdit";
    }

    @RequestMapping(value="/resourceEdit/{resourceUuid}", method=RequestMethod.POST)
    public String resourceEdit(Model model, @PathVariable String resourceUuid, @ModelAttribute("resource") ResourceDto resourceDto) {
        Response response = (Response) this.resourceRestController.updateResource(resourceDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/resource";
        } else {
            model.addAttribute(response);
            return "resourceEdit";
        }
    }

    @RequestMapping(value="/resourceDelete/{resourceUuid}",method = RequestMethod.GET)
    public String resourceDelete(@PathVariable String resourceUuid) {
        Response response = (Response) this.resourceRestController.deleteResourceByResourceUuid(resourceUuid).getBody();
        return "redirect:/resource";
    }

    @RequestMapping(value="/resourceTypeSearch", method=RequestMethod.POST)
    public String resourceTypeSearch(Model model, @ModelAttribute("resourceTypeSearch") ResourceTypeSearch resourceTypeSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_type_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ResourceTypeDto resourceTypeDto = new ResourceTypeDto();
        model.addAttribute("resourceType", resourceTypeDto);
        model.addAttribute("resourceTypeSearch", resourceTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.resourceTypeRestController.findAllResourceTypeSearch(resourceTypeSearch).getBody();
        model.addAttribute("resourceTypeList", response.getData());
        return "createResourceType";
    }

    @GetMapping("/createResourceType")
    public String createResourceType(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_type_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ResourceTypeDto resourceTypeDto = new ResourceTypeDto();
        model.addAttribute("resourceType", resourceTypeDto);
        ResourceTypeSearch resourceTypeSearch = new ResourceTypeSearch();
        model.addAttribute("resourceTypeSearch", resourceTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.resourceTypeRestController.findAllResourceType().getBody();
        model.addAttribute("resourceTypeList", response.getData());
        return "createResourceType";
    }

    @RequestMapping(value = "/createResourceType", method = RequestMethod.POST)
    public String createResourceType(Model model, @ModelAttribute("resourceType") ResourceTypeDto resourceTypeDto) {
        Response response = (Response) this.resourceTypeRestController.createResourceType(resourceTypeDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:resource";
        } else {
            // with error message
            model.addAttribute("response", response);
            return "createResourceType";
        }
    }

    @GetMapping(value="/resourceTypeEdit/{resourceTypeUuid}")
    public String resourceTypeEdit(Model model, @PathVariable String resourceTypeUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_type_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_type_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_type_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_resource_type_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.resourceTypeRestController.findResourceTypeByResourceTypeUuid(resourceTypeUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("resourceType", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "resourceTypeEdit";
    }

    @RequestMapping(value="/resourceTypeEdit/{resourceTypeUuid}", method=RequestMethod.POST)
    public String resourceTypeEdit(Model model, @PathVariable String resourceTypeUuid, @ModelAttribute("resourceType") ResourceTypeDto resourceTypeDto) {
        Response response = (Response) this.resourceTypeRestController.updateResourceType(resourceTypeDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/resource";
        } else {
            model.addAttribute(response);
            return "resourceTypeEdit";
        }
    }

    @RequestMapping(value="/resourceTypeDelete/{resourceTypeUuid}",method = RequestMethod.GET)
    public String resourceTypeDelete(@PathVariable String resourceTypeUuid) {
        Response response = (Response) this.resourceTypeRestController.deleteResourceTypeByResourceTypeUuid(resourceTypeUuid).getBody();
        return "redirect:/resource";
    }

    @RequestMapping(value="/resourceModuleSearch", method=RequestMethod.POST)
    public String resourceModuleSearch(Model model, @ModelAttribute("resourceModuleSearch") ResourceModuleSearch resourceModuleSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ResourceModuleDto resourceModuleDto = new ResourceModuleDto();
        model.addAttribute("resourceModule", resourceModuleDto);
        model.addAttribute("resourceModuleSearch", resourceModuleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        response = (Response) this.resourceModuleRestController.findResourceModuleSearch(resourceModuleSearch).getBody();
        model.addAttribute("resourceModuleList", response.getData());
        return "createResourceModuleLink1";
    }

    @GetMapping("/createResourceModuleLink1")
    public String createResourceModuleLink1(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        ResourceModuleDto resourceModuleDto = new ResourceModuleDto();
        model.addAttribute("resourceModule", resourceModuleDto);
        ResourceModuleSearch resourceModuleSearch = new ResourceModuleSearch();
        model.addAttribute("resourceModuleSearch", resourceModuleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        response = (Response) this.resourceModuleRestController.findAllResourceModule().getBody();
        model.addAttribute("resourceModuleList", response.getData());
        return "createResourceModuleLink1";
    }

    @RequestMapping(value = "/createResourceModuleLink1", method = RequestMethod.POST)
    public String createResourceModuleLink1(Model model, @ModelAttribute("resourceModule") ResourceModuleDto resourceModuleDto) {
        Response response = (Response) this.resourceModuleRestController.createResourceModule(resourceModuleDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:resource";
        } else {
            // with error message
            model.addAttribute("response", response);
            return "createResourceModuleLink1";
        }
    }

    @GetMapping(value="/resourceModuleLinkEdit/{resourceModuleUuid}")
    public String resourceModuleLinkEdit(Model model, @PathVariable String resourceModuleUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_resource_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.resourceModuleRestController.findResourceModuleByResourceModuleUuid(resourceModuleUuid).getBody();
        model.addAttribute("resourceModule", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllModuleLookupUUID().getBody();
        model.addAttribute("moduleLookupIds", response.getData());
        return "resourceModuleLinkEdit";
    }

    @RequestMapping(value="/resourceModuleLinkEdit/{resourceModuleUuid}", method=RequestMethod.POST)
    public String resourceModuleLinkEdit(Model model, @PathVariable String resourceModuleUuid,
        @ModelAttribute("resourceModule") ResourceModuleDto resourceModuleDto) {
        Response response = (Response) this.resourceModuleRestController.updateResourceModule(resourceModuleDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/resource";
        } else {
            model.addAttribute(response);
            return "resourceModuleLinkEdit";
        }
    }

    @RequestMapping(value="/resourceModuleLinkDelete/{resourceModuleUuid}",method = RequestMethod.GET)
    public String resourceModuleLinkDelete(@PathVariable String resourceModuleUuid) {
        Response response = (Response) this.resourceModuleRestController.deleteResourceModuleByResourceModuleUuid(resourceModuleUuid).getBody();
        return "redirect:/resource";
    }

    @RequestMapping(value="/permissionSearch",method = RequestMethod.POST)
    public String permissionSearch(Model model, @ModelAttribute("permissionSearch") PermissionSearch permissionSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_view")) {
                    return true;
                }
                return false;
            }));
        PermissionDto permissionDto = new PermissionDto();
        model.addAttribute("permission", permissionDto);
        model.addAttribute("permissionSearch", permissionSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionTypeUUID2().getBody();
        model.addAttribute("permissionTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceId().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceUuids", response.getData());
        response = (Response) this.permissionRestController.findAllPermissionSearch(permissionSearch).getBody();
        model.addAttribute("permissionList", response.getData());
        return "createPermission";
    }

    @GetMapping("/createPermission")
    public String createPermission(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_view")) {
                    return true;
                }
                return false;
            }));
        PermissionDto permissionDto = new PermissionDto();
        model.addAttribute("permission", permissionDto);
        PermissionSearch permissionSearch = new PermissionSearch();
        model.addAttribute("permissionSearch", permissionSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionTypeUUID2().getBody();
        model.addAttribute("permissionTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceId().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceUuids", response.getData());
        response = (Response) this.permissionRestController.findAllPermission().getBody();
        model.addAttribute("permissionList", response.getData());
        return "createPermission";
    }

    @RequestMapping(value = "/createPermission", method = RequestMethod.POST)
    public String createPermission(Model model, @ModelAttribute("permission") PermissionDto permission) {
        Response response = (Response) this.permissionRestController.createPermission(permission).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:permissionView";
        } else {
            model.addAttribute(response);
            return "createPermission";
        }
    }

    @GetMapping(value="/permissionEdit/{permissionUuid}")
    public String permissionEdit(Model model, @PathVariable String permissionUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .anyMatch(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_view")) {
                    return true;
                }
                return false;
            }));
        Response response = (Response) this.permissionRestController.findPermissionByPermissionUuid(permissionUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("permission", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionTypeUUID2().getBody();
        model.addAttribute("permissionTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceId().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceUuids", response.getData());
        return "permissionEdit";
    }

    @RequestMapping(value="/permissionEdit/{permissionUuid}", method=RequestMethod.POST)
    public String permissionEdit(Model model, @PathVariable String permissionUuid, @ModelAttribute("permission") PermissionDto permission) {
        Response response = (Response) this.permissionRestController.updatePermission(permission).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/permissionView";
        } else {
            model.addAttribute(response);
            return "permissionEdit";
        }
    }

    @RequestMapping(value="/permissionDelete/{permissionUuid}",method = RequestMethod.GET)
    public String permissionDelete(@PathVariable String permissionUuid) {
        Response response = (Response) this.permissionRestController.deletePermissionByPermissionUuid(permissionUuid).getBody();
        return "redirect:/permissionView";
    }

    @RequestMapping(value="/permissionTypeSearch", method=RequestMethod.POST)
    public String permissionTypeSearch(Model model, @ModelAttribute("permissionTypeSearch") PermissionTypeSearch permissionTypeSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        PermissionTypeDto permissionTypeDto = new PermissionTypeDto();
        model.addAttribute("permissionType", permissionTypeDto);
        model.addAttribute("permissionTypeSearch", permissionTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.permissionTypeRestController.findAllPermissionTypeSearch(permissionTypeSearch).getBody();
        model.addAttribute("permissionTypeList", response.getData());
        return "createPermissionType";
    }

    @GetMapping("/createPermissionType")
    public String createPermissionType(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        PermissionTypeDto permissionTypeDto = new PermissionTypeDto();
        model.addAttribute("permissionType", permissionTypeDto);
        PermissionTypeSearch permissionTypeSearch = new PermissionTypeSearch();
        model.addAttribute("permissionTypeSearch", permissionTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.permissionTypeRestController.findAllPermissionType().getBody();
        model.addAttribute("permissionTypeList", response.getData());
        return "createPermissionType";
    }

    @RequestMapping(value = "/createPermissionType", method = RequestMethod.POST)
    public String createPermissionType(Model model, @ModelAttribute("permissionType") PermissionTypeDto permissionTypeDto) {
        Response response = (Response) this.permissionTypeRestController.createPermissionType(permissionTypeDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:permissionView";
        } else {
            model.addAttribute(response);
            return "createPermissionType";
        }
    }

    @GetMapping(value="/permissionTypeEdit/{permissionTypeUuid}")
    public String permissionTypeEdit(Model model, @PathVariable String permissionTypeUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionTypeAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_type_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_type_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.permissionTypeRestController.findPermissionTypeByPermissionTypeUuid(permissionTypeUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("permissionType", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "permissionTypeEdit";
    }

    @RequestMapping(value="/permissionTypeEdit/{permissionTypeUuid}", method=RequestMethod.POST)
    public String permissionTypeEdit(Model model, @PathVariable String permissionTypeUuid, @ModelAttribute("permissionType") PermissionTypeDto permissionTypeDto) {
        Response response = (Response) this.permissionTypeRestController.updatePermissionType(permissionTypeDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/permissionView";
        } else {
            model.addAttribute(response);
            return "permissionTypeEdit";
        }
    }

    @RequestMapping(value="/permissionTypeDelete/{permissionTypeUuid}",method = RequestMethod.GET)
    public String permissionTypeDelete(@PathVariable String permissionTypeUuid) {
        Response response = (Response) this.permissionTypeRestController.deletePermissionTypeByPermissionTypeUuid(permissionTypeUuid).getBody();
        return "redirect:/permissionView";
    }

    @RequestMapping(value="/permissionResourceModuleSearch", method=RequestMethod.POST)
    public String permissionResourceModuleSearch(Model model,
         @ModelAttribute("permissionResourceModuleSearch") PermissionResourceModuleSearch permissionResourceModuleSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        PermissionResourceModuleDto permissionResourceModuleDto = new PermissionResourceModuleDto();
        model.addAttribute("permissionResourceModule", permissionResourceModuleDto);
        model.addAttribute("permissionResourceModuleSearch", permissionResourceModuleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionTypeUUID().getBody();
        model.addAttribute("permissionTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceId().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceUuids", response.getData());
        response = (Response) this.permissionResourceModuleRestController.findAllPermissionResourceModuleSearch(permissionResourceModuleSearch).getBody();
        model.addAttribute("permissionResourceModuleList", response.getData());
        return "createPermissionResourceModule";
    }

    @GetMapping("/createPermissionResourceModule")
    public String createPermissionResourceModule(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        PermissionResourceModuleDto permissionResourceModuleDto = new PermissionResourceModuleDto();
        model.addAttribute("permissionResourceModule", permissionResourceModuleDto);
        PermissionResourceModuleSearch permissionResourceModuleSearch = new PermissionResourceModuleSearch();
        model.addAttribute("permissionResourceModuleSearch", permissionResourceModuleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionTypeUUID().getBody();
        model.addAttribute("permissionTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceId().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceUuids", response.getData());
        response = (Response) this.permissionResourceModuleRestController.findAllPermissionResourceModule().getBody();
        model.addAttribute("permissionResourceModuleList", response.getData());
        return "createPermissionResourceModule";
    }

    @RequestMapping(value = "/createPermissionResourceModule", method = RequestMethod.POST)
    public String createPermissionResourceModule(Model model, @ModelAttribute("permissionResourceModule") PermissionResourceModuleDto permissionResourceModuleDto) {
        Response response = (Response) this.permissionResourceModuleRestController.createPermissionResourceModule(permissionResourceModuleDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:permissionView";
        } else {
            model.addAttribute(response);
            return "createPermissionResourceModule";
        }
    }

    @GetMapping(value="/permissionResourceModuleEdit/{permissionResourceModuleUuid}")
    public String permissionResourceModuleEdit(Model model, @PathVariable String permissionResourceModuleUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isPermissionResourceModuleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_permission_resource_module_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_permission_resource_module_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.permissionResourceModuleRestController
            .findPermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("permissionResourceModule", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllPermissionTypeUUID().getBody();
        model.addAttribute("permissionTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceId().getBody();
        model.addAttribute("resourceIds", response.getData());
        response = (Response) this.utilRestController.getAllResourceUUID().getBody();
        model.addAttribute("resourceUuids", response.getData());
        return "permissionResourceModuleEdit";
    }

    @RequestMapping(value="/permissionResourceModuleEdit/{permissionResourceModuleUuid}", method=RequestMethod.POST)
    public String permissionResourceModuleEdit(Model model, @PathVariable String permissionResourceModuleUuid,
       @ModelAttribute("permissionResourceModule") PermissionResourceModuleDto permissionResourceModuleDto) {
        Response response = (Response) this.permissionResourceModuleRestController.updatePermissionResourceModule(permissionResourceModuleDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/permissionView";
        } else {
            model.addAttribute(response);
            return "permissionResourceModuleEdit";
        }
    }

    @RequestMapping(value="/permissionResourceModuleDelete/{permissionResourceModuleUuid}",method = RequestMethod.GET)
    public String permissionResourceModuleDelete(@PathVariable String permissionResourceModuleUuid) {
        Response response = (Response) this.permissionResourceModuleRestController
                .deletePermissionResourceModuleByPermissionResourceModuleUuid(permissionResourceModuleUuid).getBody();
        return "redirect:/permissionView";
    }

    @RequestMapping(value="/userSearch",method = RequestMethod.POST)
    public String userSearch(Model model, @ModelAttribute("userSearch") UserSearch userSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        model.addAttribute("userSearch", userSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrgUUID().getBody();
        model.addAttribute("orgIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        response = (Response) this.userRestController.findAllUserSearch(userSearch).getBody();
        model.addAttribute("userList", response.getData());
        return "createUser";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        UserSearch userSearch = new UserSearch();
        model.addAttribute("userSearch", userSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrgUUID().getBody();
        model.addAttribute("orgIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        response = (Response) this.userRestController.findAllUser().getBody();
        model.addAttribute("userList", response.getData());
        return "createUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("user") UserDto userDto) {
        Response response = (Response) this.userRestController.createUser(userDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createUser";
        }
    }

    @GetMapping(value="/userEdit/{userUuid}")
    public String userEdit(Model model, @PathVariable String userUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.userRestController.findUserByUserUuid(userUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("user", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllOrgUUID().getBody();
        model.addAttribute("orgIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        return "userEdit";
    }

    @RequestMapping(value="/userEdit/{userUuid}", method=RequestMethod.POST)
    public String userEdit(Model model, @PathVariable String userUuid, @ModelAttribute("user") UserDto userDto) {
        Response response = (Response) this.userRestController.updateUser(userDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "userEdit";
        }
    }

    @RequestMapping(value="/userDelete/{userUuid}",method = RequestMethod.GET)
    public String userDelete(@PathVariable String userUuid) {
        Response response = (Response) this.userRestController.deleteUserByUserUuid(userUuid).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/userRoleSearch",method = RequestMethod.POST)
    public String userRoleSearch(Model model, @ModelAttribute("userRoleSearch") UserRoleSearch userRoleSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        UserRoleDto userRoleDto = new UserRoleDto();
        model.addAttribute("userRole", userRoleDto);
        model.addAttribute("userRoleSearch", userRoleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.userRoleRestController.findAllUserRoleSearch(userRoleSearch).getBody();
        model.addAttribute("userRoleList", response.getData());
        return "createUserRole";
    }

    @GetMapping("/createUserRole")
    public String createUserRole(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        UserRoleDto userRoleDto = new UserRoleDto();
        model.addAttribute("userRole", userRoleDto);
        UserRoleSearch userRoleSearch = new UserRoleSearch();
        model.addAttribute("userRoleSearch", userRoleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.userRoleRestController.findAllUserRole().getBody();
        model.addAttribute("userRoleList", response.getData());
        return "createUserRole";
    }

    @RequestMapping(value = "/createUserRole", method = RequestMethod.POST)
    public String createUserRole(Model model, @ModelAttribute("userRole") UserRoleDto userRoleDto) {
        Response response = (Response) this.userRoleRestController.createUserRole(userRoleDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createUserRole";
        }
    }

    @GetMapping(value="/userRoleEdit/{userRoleUuid}")
    public String userRoleEdit(Model model, @PathVariable String userRoleUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_user_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_user_role_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.userRoleRestController.findUserRoleByUserRoleUuid(userRoleUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("userRole", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        return "userRoleEdit";
    }

    @RequestMapping(value="/userRoleEdit/{userRoleUuid}", method=RequestMethod.POST)
    public String userRoleEdit(Model model, @PathVariable String userRoleUuid, @ModelAttribute("userRole") UserRoleDto userRoleDto) {
        Response response = (Response) this.userRoleRestController.updateUserRole(userRoleDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "userRoleEdit";
        }
    }

    @RequestMapping(value="/userRoleDelete/{userRoleUuid}",method = RequestMethod.GET)
    public String userRoleDelete(@PathVariable String userRoleUuid) {
        Response response = (Response) this.userRoleRestController.deleteUserRoleByUserRoleUuid(userRoleUuid).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/roleSearch",method = RequestMethod.POST)
    public String roleSearch(Model model, @ModelAttribute("roleSearch") RoleSearch roleSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        RoleDto roleDto = new RoleDto();
        model.addAttribute("role", roleDto);
        model.addAttribute("roleSearch", roleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        response = (Response) this.roleRestController.findAllRoleSearch(roleSearch).getBody();
        model.addAttribute("roleList", response.getData());
        return "createRole";
    }

    @GetMapping("/createRole")
    public String createRole(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        RoleDto roleDto = new RoleDto();
        model.addAttribute("role", roleDto);
        RoleSearch roleSearch = new RoleSearch();
        model.addAttribute("roleSearch", roleSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        response = (Response) this.roleRestController.findAllRole().getBody();
        model.addAttribute("roleList", response.getData());
        return "createRole";
    }

    @RequestMapping(value = "/createRole", method = RequestMethod.POST)
    public String createRole(Model model, @ModelAttribute("role") RoleDto roleDto) {
        Response response = (Response) this.roleRestController.createRole(roleDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createRole";
        }
    }

    @GetMapping(value="/roleEdit/{roleUuid}")
    public String roleEdit(Model model, @PathVariable String roleUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isRoleAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.roleRestController.findRoleByRoleUuid(roleUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("role", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        return "roleEdit";
    }

    @RequestMapping(value="/roleEdit/{roleUuid}", method=RequestMethod.POST)
    public String roleEdit(Model model, @PathVariable String roleUuid, @ModelAttribute("role") RoleDto roleDto) {
        Response response = (Response) this.roleRestController.updateRole(roleDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "roleEdit";
        }
    }

    @RequestMapping(value="/roleDelete/{roleUuid}",method = RequestMethod.GET)
    public String roleDelete(@PathVariable String roleUuid) {
        Response response = (Response) this.roleRestController.deleteRoleByRoleUuid(roleUuid).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/rolePermissionSearch",method = RequestMethod.POST)
    public String rolePermissionSearch(Model model, RolePermissionSearch rolePermissionSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isRolePermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        RolePermissionDto rolePermissionDto = new RolePermissionDto();
        model.addAttribute("rolePermission", rolePermissionDto);
        model.addAttribute("rolePermissionSearch", rolePermissionSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllRoleUUID().getBody();
        model.addAttribute("roleIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionUUID().getBody();
        model.addAttribute("permissionIds", response.getData());
        response = (Response) this.rolePermissionRestController.findAllRolePermissionSearch(rolePermissionSearch).getBody();
        model.addAttribute("rolePermissionList", response.getData());
        return "createRolePermission";
    }

    @GetMapping("/createRolePermission")
    public String createRolePermission(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isRolePermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        RolePermissionDto rolePermissionDto = new RolePermissionDto();
        model.addAttribute("rolePermission", rolePermissionDto);
        RolePermissionSearch rolePermissionSearch = new RolePermissionSearch();
        model.addAttribute("rolePermissionSearch", rolePermissionSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllRoleUUID().getBody();
        model.addAttribute("roleIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionUUID().getBody();
        model.addAttribute("permissionIds", response.getData());
        response = (Response) this.rolePermissionRestController.findAllRolePermission().getBody();
        model.addAttribute("rolePermissionList", response.getData());
        return "createRolePermission";
    }

    @RequestMapping(value = "/createRolePermission", method = RequestMethod.POST)
    public String createRolePermission(Model model, @ModelAttribute("rolePermission") RolePermissionDto rolePermissionDto) {
        Response response = (Response) this.rolePermissionRestController.createRolePermission(rolePermissionDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createRolePermission";
        }
    }

    @GetMapping(value="/rolePermissionEdit/{rolePermissionUuid}")
    public String rolePermissionEdit(Model model, @PathVariable String rolePermissionUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isRolePermissionAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_role_permission_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_role_permission_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        Response response = (Response) this.rolePermissionRestController.findRolePermissionByRolePermissionUuid(rolePermissionUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("rolePermission", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllRoleUUID().getBody();
        model.addAttribute("roleIds", response.getData());
        response = (Response) this.utilRestController.getAllPermissionUUID().getBody();
        model.addAttribute("permissionIds", response.getData());
        return "rolePermissionEdit";
    }

    @RequestMapping(value="/rolePermissionEdit/{rolePermissionUuid}", method=RequestMethod.POST)
    public String rolePermissionEdit(Model model, @PathVariable String rolePermissionUuid, @ModelAttribute("rolePermission") RolePermissionDto rolePermissionDto) {
        Response response = (Response) this.rolePermissionRestController.updateRolePermission(rolePermissionDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "rolePermissionEdit";
        }
    }

    @RequestMapping(value="/rolePermissionDelete/{rolePermissionUuid}",method = RequestMethod.GET)
    public String rolePermissionDelete(@PathVariable String rolePermissionUuid) {
        Response response = (Response) this.rolePermissionRestController.deleteRolePermissionByRolePermissionUuid(rolePermissionUuid).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/groupSearch",method = RequestMethod.POST)
    public String groupSearch(Model model, @ModelAttribute("groupSearch") GroupSearch groupSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isGroupsAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_groups_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        GroupDto groupDto = new GroupDto();
        model.addAttribute("group", groupDto);
        model.addAttribute("groupSearch", groupSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.groupRestController.findAllGroupSearch(groupSearch).getBody();
        model.addAttribute("groupList", response.getData());
        return "createGroups";
    }

    @GetMapping("/createGroups")
    public String createGroups(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isGroupsAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_groups_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        GroupDto groupDto = new GroupDto();
        model.addAttribute("group", groupDto);
        GroupSearch groupSearch = new GroupSearch();
        model.addAttribute("groupSearch", groupSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.groupRestController.findAllGroup().getBody();
        model.addAttribute("groupList", response.getData());
        return "createGroups";
    }

    @RequestMapping(value = "/createGroups", method = RequestMethod.POST)
    public String createGroups(Model model, @ModelAttribute("group") GroupDto groupDto) {
        Response response = (Response) this.groupRestController.createGroup(groupDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createGroups";
        }
    }

    @GetMapping(value="/groupsEdit/{groupUuid}")
    public String groupsEdit(Model model, @PathVariable String groupUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isGroupsAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_groups_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_groups_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.groupRestController.findGroupByGroupUuid(groupUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("group", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        return "groupsEdit";
    }

    @RequestMapping(value="/groupsEdit/{groupUuid}", method=RequestMethod.POST)
    public String groupsEdit(Model model, @PathVariable String groupUuid, @ModelAttribute("group") GroupDto groupDto) {
        Response response = (Response) this.groupRestController.updateGroup(groupDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "groupsEdit";
        }
    }

    @RequestMapping(value="/groupsDelete/{groupUuid}",method = RequestMethod.GET)
    public String groupsDelete(@PathVariable String groupUuid) {
        Response response = (Response) this.groupRestController.deleteGroupByGroupUuid(groupUuid).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/userGroupMappingSearch",method = RequestMethod.POST)
    public String userGroupMappingSearch(Model model, @ModelAttribute("userGroupMappingSearch") UserGroupMappingSearch userGroupMappingSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUsergroupmappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_usergroupmapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        UserGroupMappingDto userGroupMappingDto = new UserGroupMappingDto();
        model.addAttribute("userGroupMapping", userGroupMappingDto);
        model.addAttribute("userGroupMappingSearch", userGroupMappingSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        response = (Response) this.userGroupMappingRestController.findAllUserGroupMappingSearch(userGroupMappingSearch).getBody();
        model.addAttribute("userGroupMappingList", response.getData());
        return "createUserGroupmapping";
    }

    @GetMapping("/createUserGroupmapping")
    public String createUserGroupmapping(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUsergroupmappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_usergroupmapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        UserGroupMappingDto userGroupMappingDto = new UserGroupMappingDto();
        model.addAttribute("userGroupMapping", userGroupMappingDto);
        UserGroupMappingSearch userGroupMappingSearch = new UserGroupMappingSearch();
        model.addAttribute("userGroupMappingSearch", userGroupMappingSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        response = (Response) this.userGroupMappingRestController.findAllUserGroupMapping().getBody();
        model.addAttribute("userGroupMappingList", response.getData());
        return "createUserGroupmapping";
    }

    @RequestMapping(value = "/createUserGroupmapping", method = RequestMethod.POST)
    public String createUserGroupmapping(Model model, @ModelAttribute("userGroupMapping") UserGroupMappingDto userGroupMappingDto) {
        Response response = (Response) this.userGroupMappingRestController.createUserGroupMapping(userGroupMappingDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createUserGroupmapping";
        }
    }

    @GetMapping(value="/userGroupmappingEdit/{id}")
    public String userGroupmappingEdit(Model model, @PathVariable Long id) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUsergroupmappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_usergroupmapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_usergroupmapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.userGroupMappingRestController.findUserGroupMappingById(id).getBody();
        logger.info(response.toString());
        model.addAttribute("userGroupMapping", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllGroupUUID().getBody();
        model.addAttribute("groupIds", response.getData());
        return "userGroupmappingEdit";
    }

    @RequestMapping(value="/userGroupmappingEdit/{id}", method=RequestMethod.POST)
    public String userGroupmappingEdit(Model model, @PathVariable Long id, @ModelAttribute("userGroupMapping") UserGroupMappingDto userGroupMappingDto) {
        Response response = (Response) this.userGroupMappingRestController.updateUserGroupMapping(userGroupMappingDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "userGroupmappingEdit";
        }
    }

    @RequestMapping(value="/userGroupmappingDelete/{id}",method = RequestMethod.GET)
    public String userGroupmappingDelete(@PathVariable Long id) {
        Response response = (Response) this.userGroupMappingRestController.deleteUserGroupMappingTypeById(id).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/userOrganizationMappingSearch", method=RequestMethod.POST)
    public String userOrganizationMappingSearch(Model model, @ModelAttribute("userOrganizationMappingSearch") UserOrganizationMappingSearch userOrganizationMappingSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserOrganizationMappingAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        UserOrganizationMappingDto userOrganizationMappingDto = new UserOrganizationMappingDto();
        model.addAttribute("userOrganizationMapping", userOrganizationMappingDto);
        model.addAttribute("userOrganizationMappingSearch", userOrganizationMappingSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.userOrganizationMappingRestController.findAllUserOrganizationMappingSearch(userOrganizationMappingSearch).getBody();
        model.addAttribute("userOrganizationMappingList", response.getData());
        return "createUserOrganizationmapping";
    }

    @GetMapping("/createUserOrganizationmapping")
    public String createUserOrganizationmapping(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserOrganizationMappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        UserOrganizationMappingDto userOrganizationMappingDto = new UserOrganizationMappingDto();
        model.addAttribute("userOrganizationMapping", userOrganizationMappingDto);
        UserOrganizationMappingSearch userOrganizationMappingSearch = new UserOrganizationMappingSearch();
        model.addAttribute("userOrganizationMappingSearch", userOrganizationMappingSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        response = (Response) this.userOrganizationMappingRestController.findAllUserOrganizationMapping().getBody();
        model.addAttribute("userOrganizationMappingList", response.getData());
        return "createUserOrganizationmapping";
    }

    @RequestMapping(value = "/createUserOrganizationmapping", method = RequestMethod.POST)
    public String createUserOrganizationmapping(Model model, @ModelAttribute("userOrganizationMapping") UserOrganizationMappingDto userOrganizationMappingDto) {
        Response response = (Response) this.userOrganizationMappingRestController.createUserOrganizationMapping(userOrganizationMappingDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createUserOrganizationmapping";
        }
    }

    @GetMapping(value="/userOrganizationmappingEdit/{id}")
    public String userOrganizationmappingEdit(Model model, @PathVariable Long id) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserOrganizationMappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_userorganizationmapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.userOrganizationMappingRestController.findUserOrganizationMappingById(id).getBody();
        logger.info(response.toString());
        model.addAttribute("userOrganizationMapping", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllOrganizationUUID().getBody();
        model.addAttribute("organizationIds", response.getData());
        return "userOrganizationmappingEdit";
    }

    @RequestMapping(value="/userOrganizationmappingEdit/{id}", method=RequestMethod.POST)
    public String userOrganizationmappingEdit(Model model, @PathVariable Long id, @ModelAttribute("userOrganizationMapping") UserOrganizationMappingDto userOrganizationMappingDto) {
        Response response = (Response) this.userOrganizationMappingRestController.updateUserOrganizationMapping(userOrganizationMappingDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "userOrganizationmappingEdit";
        }
    }

    @RequestMapping(value="/userOrganizationmappingDelete/{id}",method = RequestMethod.GET)
    public String groupsDelete(@PathVariable Long id) {
        Response response = (Response) this.userOrganizationMappingRestController.deleteUserOrganizationMappingTypeById(id).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/userRoleMappingSearch", method=RequestMethod.POST)
    public String userRoleMappingSearch(Model model, @ModelAttribute("userRoleMappingSearch") UserRoleMappingSearch userRoleMappingSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserroleMappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_userrolemapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        UserRoleMappingDto userRoleMappingDto = new UserRoleMappingDto();
        model.addAttribute("userRoleMapping", userRoleMappingDto);
        model.addAttribute("userRoleMappingSearch", userRoleMappingSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllRoleUUID().getBody();
        model.addAttribute("roleIds", response.getData());
        response = (Response) this.userRoleMappingRestController.findAllUserRoleMappingSearch(userRoleMappingSearch).getBody();
        model.addAttribute("userRoleMappingList", response.getData());
        return "createUserRolemapping";
    }

    @GetMapping("/createUserRolemapping")
    public String createUserRolemapping(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserroleMappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_userrolemapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        UserRoleMappingDto userRoleMappingDto = new UserRoleMappingDto();
        model.addAttribute("userRoleMapping", userRoleMappingDto);
        UserRoleMappingSearch userRoleMappingSearch = new UserRoleMappingSearch();
        model.addAttribute("userRoleMappingSearch", userRoleMappingSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllRoleUUID().getBody();
        model.addAttribute("roleIds", response.getData());
        response = (Response) this.userRoleMappingRestController.findAllUserRoleMapping().getBody();
        model.addAttribute("userRoleMappingList", response.getData());
        return "createUserRolemapping";
    }

    @RequestMapping(value = "/createUserRolemapping", method = RequestMethod.POST)
    public String createUserRolemapping(Model model, @ModelAttribute("userRoleMapping") UserRoleMappingDto userRoleMappingDto) {
        Response response = (Response) this.userRoleMappingRestController.createUserRoleMapping(userRoleMappingDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:userdetail";
        } else {
            model.addAttribute(response);
            return "createUserRolemapping";
        }
    }

    @GetMapping(value="/userRolemappingEdit/{id}")
    public String userRolemappingEdit(Model model, @PathVariable Long id) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isUserroleMappingAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_userrolemapping_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_userrolemapping_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.userRoleMappingRestController.findUserRoleMappingById(id).getBody();
        logger.info(response.toString());
        model.addAttribute("userRoleMapping", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllRoleUUID().getBody();
        model.addAttribute("roleIds", response.getData());
        return "userRolemappingEdit";
    }

    @RequestMapping(value="/userRolemappingEdit/{id}", method=RequestMethod.POST)
    public String userRolemappingEdit(Model model, @PathVariable Long id, @ModelAttribute("userRoleMapping") UserRoleMappingDto userRoleMappingDto) {
        Response response = (Response) this.userRoleMappingRestController.updateUserRoleMapping(userRoleMappingDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/userdetail";
        } else {
            model.addAttribute(response);
            return "userRolemappingEdit";
        }
    }

    @RequestMapping(value="/userRolemappingDelete/{id}",method = RequestMethod.GET)
    public String userRolemappingDelete(@PathVariable Long id) {
        Response response = (Response) this.userRoleMappingRestController.deleteUserRoleMappingById(id).getBody();
        return "redirect:/userdetail";
    }

    @RequestMapping(value="/intCmdSearch",method = RequestMethod.POST)
    public String intCmdSearch(Model model, @ModelAttribute("intCmdSearch") IntCmdSearch intCmdSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntCmdDto intCmdDto = new IntCmdDto();
        model.addAttribute("intCmd", intCmdDto);
        model.addAttribute("intCmdSearch", intCmdSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeId().getBody();
        model.addAttribute("intTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeUuid().getBody();
        model.addAttribute("intTypeUuids", response.getData());
        response = (Response) this.intCmdRestController.findAllIntCmdSearch(intCmdSearch).getBody();
        model.addAttribute("intCmdList", response.getData());
        return "createIntCmd";
    }

    @GetMapping("/createIntCmd")
    public String createIntCmd(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntCmdDto intCmdDto = new IntCmdDto();
        model.addAttribute("intCmd", intCmdDto);
        IntCmdSearch intCmdSearch = new IntCmdSearch();
        model.addAttribute("intCmdSearch", intCmdSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeId().getBody();
        model.addAttribute("intTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeUuid().getBody();
        model.addAttribute("intTypeUuids", response.getData());
        response = (Response) this.intCmdRestController.findAllIntCmd().getBody();
        model.addAttribute("intCmdList", response.getData());
        return "createIntCmd";
    }

    @RequestMapping(value = "/createIntCmd", method = RequestMethod.POST)
    public String createIntCmd(Model model, @ModelAttribute("intCmd") IntCmdDto intCmdDto) {
        Response response = (Response) this.intCmdRestController.createIntCmd(intCmdDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntCmd";
        }
    }

    @GetMapping(value="/intCmdEdit/{intCmdUuid}")
    public String intCmdEdit(Model model, @PathVariable String intCmdUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intCmdRestController.findIntCmdByIntCmdUuid(intCmdUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intCmd", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllIntTypeId().getBody();
        model.addAttribute("intTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeUuid().getBody();
        model.addAttribute("intTypeUuids", response.getData());
        return "intCmdEdit";
    }

    @RequestMapping(value="/intCmdEdit/{intCmdUuid}", method=RequestMethod.POST)
    public String intCmdEdit(Model model, @PathVariable String intCmdUuid, @ModelAttribute("intCmd") IntCmdDto intCmdDto) {
        Response response = (Response) this.intCmdRestController.updateIntCmd(intCmdDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intCmdEdit";
        }
    }

    @RequestMapping(value="/intCmdDelete/{intCmdUuid}",method = RequestMethod.GET)
    public String intCmdDelete(@PathVariable String intCmdUuid) {
        Response response = (Response) this.intCmdRestController.deleteIntCmdByIntCmdUuid(intCmdUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intCmdImpSearch",method = RequestMethod.POST)
    public String intCmdImpSearch(Model model, @ModelAttribute("intCmdImpSearch") IntCmdImpSearch intCmdImpSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdImpAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        IntCmdImpDto intCmdImpDto = new IntCmdImpDto();
        model.addAttribute("intCmdImp", intCmdImpDto);
        model.addAttribute("intCmdImpSearch", intCmdImpSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userUUIDs", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdParamId().getBody();
        model.addAttribute("intCmdParamIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdParamUuid().getBody();
        model.addAttribute("intCmdParamUuids", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdId().getBody();
        model.addAttribute("intCmdIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdUuid().getBody();
        model.addAttribute("intCmdUuids", response.getData());
        response = (Response) this.intCmdImpRestController.findAllIntCmdImpSearch(intCmdImpSearch).getBody();
        model.addAttribute("intCmdImpList", response.getData());
        return "createIntCmdImp";
    }

    @GetMapping("/createIntCmdImp")
    public String createIntCmdImp(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdImpAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntCmdImpDto intCmdImpDto = new IntCmdImpDto();
        model.addAttribute("intCmdImp", intCmdImpDto);
        IntCmdImpSearch intCmdImpSearch = new IntCmdImpSearch();
        model.addAttribute("intCmdImpSearch", intCmdImpSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userUUIDs", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdParamId().getBody();
        model.addAttribute("intCmdParamIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdParamUuid().getBody();
        model.addAttribute("intCmdParamUuids", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdId().getBody();
        model.addAttribute("intCmdIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdUuid().getBody();
        model.addAttribute("intCmdUuids", response.getData());
        response = (Response) this.intCmdImpRestController.findAllIntCmdImp().getBody();
        model.addAttribute("intCmdImpList", response.getData());
        return "createIntCmdImp";
    }

    @RequestMapping(value = "/createIntCmdImp", method = RequestMethod.POST)
    public String createIntCmdImp(Model model, @ModelAttribute("intCmdImp") IntCmdImpDto intCmdImpDto) {
        Response response = (Response) this.intCmdImpRestController.createIntCmdImp(intCmdImpDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntCmdImp";
        }
    }

    @GetMapping(value="/intCmdImpEdit/{intCmdImpUuid}")
    public String intCmdImpEdit(Model model, @PathVariable String intCmdImpUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdImpAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_imp_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intCmdImpRestController.findIntCmdImpByIntCmdImpUuid(intCmdImpUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intCmdImp", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userUUIDs", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdParamId().getBody();
        model.addAttribute("intCmdParamIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdParamUuid().getBody();
        model.addAttribute("intCmdParamUuids", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdId().getBody();
        model.addAttribute("intCmdIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdUuid().getBody();
        model.addAttribute("intCmdUuids", response.getData());
        return "intCmdImpEdit";
    }

    @RequestMapping(value="/intCmdImpEdit/{intCmdImpUuid}", method=RequestMethod.POST)
    public String intCmdImpEdit(Model model, @PathVariable String intCmdImpUuid, @ModelAttribute("intCmdImp") IntCmdImpDto intCmdImpDto) {
        Response response = (Response) this.intCmdImpRestController.updateIntCmdImp(intCmdImpDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intCmdImpEdit";
        }
    }

    @RequestMapping(value="/intCmdImpDelete/{intCmdImpUuid}",method = RequestMethod.GET)
    public String intCmdImpDelete(@PathVariable String intCmdImpUuid) {
        Response response = (Response) this.intCmdImpRestController.deleteIntCmdImpByIntCmdImpUuid(intCmdImpUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intCmdParamSearch",method = RequestMethod.POST)
    public String intCmdParamSearch(Model model, @ModelAttribute("intCmdParamSearch") IntCmdParamSearch intCmdParamSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdParamAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_cmd_param_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        IntCmdParamDto intCmdParamDto = new IntCmdParamDto();
        model.addAttribute("intCmdParam", intCmdParamDto);
        model.addAttribute("intCmdParamSearch", intCmdParamSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdId().getBody();
        model.addAttribute("intCmdIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdUuid().getBody();
        model.addAttribute("intCmdUuids", response.getData());
        response = (Response) this.intCmdParamRestController.findAllIntCmdParamSearch(intCmdParamSearch).getBody();
        model.addAttribute("intCmdParamList", response.getData());
        return "createIntCmdParam";
    }

    @GetMapping("/createIntCmdParam")
    public String createIntCmdParam(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdParamAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_cmd_param_superadmin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_admin") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_editor") ||
                    t.getRoleName().equalsIgnoreCase("role_int_cmd_param_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        IntCmdParamDto intCmdParamDto = new IntCmdParamDto();
        model.addAttribute("intCmdParam", intCmdParamDto);
        IntCmdParamSearch intCmdParamSearch = new IntCmdParamSearch();
        model.addAttribute("intCmdParamSearch", intCmdParamSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdId().getBody();
        model.addAttribute("intCmdIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdUuid().getBody();
        model.addAttribute("intCmdUuids", response.getData());
        response = (Response) this.intCmdParamRestController.findAllIntCmdParam().getBody();
        model.addAttribute("intCmdParamList", response.getData());
        return "createIntCmdParam";
    }

    @RequestMapping(value = "/createIntCmdParam", method = RequestMethod.POST)
    public String createIntCmdParam(Model model, @ModelAttribute("intCmdParam") IntCmdParamDto intCmdParamDto) {
        Response response = (Response) this.intCmdParamRestController.createIntCmdParam(intCmdParamDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntCmdParam";
        }
    }

    @GetMapping(value="/intCmdParamEdit/{intCmdParamUuid}")
    public String intCmdParamEdit(Model model, @PathVariable String intCmdParamUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntCmdParamAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_cmd_param_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_param_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_param_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_cmd_param_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intCmdParamRestController.findIntCmdParamByIntCmdParamUuid(intCmdParamUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intCmdParam", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllIntCmdId().getBody();
        model.addAttribute("intCmdIds", response.getData());
        response = (Response) this.utilRestController.getAllIntCmdUuid().getBody();
        model.addAttribute("intCmdUuids", response.getData());
        return "intCmdParamEdit";
    }

    @RequestMapping(value="/intCmdParamEdit/{intCmdParamUuid}", method=RequestMethod.POST)
    public String intCmdParamEdit(Model model, @PathVariable String intCmdParamUuid, @ModelAttribute("intCmdParam") IntCmdParamDto intCmdParamDto) {
        Response response = (Response) this.intCmdParamRestController.updateIntCmdParam(intCmdParamDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intCmdParamEdit";
        }
    }

    @RequestMapping(value="/intCmdParamDelete/{intCmdParamUuid}",method = RequestMethod.GET)
    public String intCmdParamDelete(@PathVariable String intCmdParamUuid) {
        Response response = (Response) this.intCmdParamRestController.deleteIntCmdParamByIntCmdParamUuid(intCmdParamUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intParamsSearch",method = RequestMethod.POST)
    public String intParamsSearch(Model model, @ModelAttribute("intParamsSearch") IntParamsSearch intParamsSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntParamsAccess",  userPrincipal.getPermissionListViews().stream()
            .filter(t -> {
                if (t.getRoleName().equalsIgnoreCase("role_int_params_superadmin") ||
                        t.getRoleName().equalsIgnoreCase("role_int_params_admin") ||
                        t.getRoleName().equalsIgnoreCase("role_int_params_editor") ||
                        t.getRoleName().equalsIgnoreCase("role_int_params_view")) {
                    return true;
                }
                return false;
            }).findFirst().get());
        IntParamsDto intParamsDto = new IntParamsDto();
        model.addAttribute("intParams", intParamsDto);
        model.addAttribute("intParamsSearch", intParamsSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeId().getBody();
        model.addAttribute("intTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeUuid().getBody();
        model.addAttribute("intTypeUuids", response.getData());
        response = (Response) this.intParamsRestController.findAllIntParamsSearch(intParamsSearch).getBody();
        model.addAttribute("intParamsList", response.getData());
        return "createIntParams";
    }

    @GetMapping("/createIntParams")
    public String createIntParams(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntParamsAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_params_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_params_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_params_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_params_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntParamsDto intParamsDto = new IntParamsDto();
        model.addAttribute("intParams", intParamsDto);
        IntParamsSearch intParamsSearch = new IntParamsSearch();
        model.addAttribute("intParamsSearch", intParamsSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeId().getBody();
        model.addAttribute("intTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeUuid().getBody();
        model.addAttribute("intTypeUuids", response.getData());
        response = (Response) this.intParamsRestController.findAllIntParams().getBody();
        model.addAttribute("intParamsList", response.getData());
        return "createIntParams";
    }

    @RequestMapping(value = "/createIntParams", method = RequestMethod.POST)
    public String createIntParams(Model model, @ModelAttribute("intParams") IntParamsDto intParamsDto) {
        Response response = (Response) this.intParamsRestController.createIntParams(intParamsDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntParams";
        }
    }

    @GetMapping(value="/intParamsEdit/{intParamsUuid}")
    public String intParamsEdit(Model model, @PathVariable String intParamsUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntParamsAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_params_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_params_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_params_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_params_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intParamsRestController.findIntParamsByIntParamsUuid(intParamsUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intParams", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        response = (Response) this.utilRestController.getAllIntTypeId().getBody();
        model.addAttribute("intTypeIds", response.getData());
        response = (Response) this.utilRestController.getAllIntTypeUuid().getBody();
        model.addAttribute("intTypeUuids", response.getData());
        return "intParamsEdit";
    }

    @RequestMapping(value="/intParamsEdit/{intParamsUuid}", method=RequestMethod.POST)
    public String intParamsEdit(Model model, @PathVariable String intParamsUuid, @ModelAttribute("intParams") IntParamsDto intParamsDto) {
        Response response = (Response) this.intParamsRestController.updateIntParams(intParamsDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intParamsEdit";
        }
    }

    @RequestMapping(value="/intParamsDelete/{intParamsUuid}",method = RequestMethod.GET)
    public String intParamsDelete(@PathVariable String intParamsUuid) {
        Response response = (Response) this.intParamsRestController.deleteIntParamsByIntParamsUuid(intParamsUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intTypeSearch",method = RequestMethod.POST)
    public String intTypeSearch(Model model, @ModelAttribute("intTypeSearch") IntTypeSearch intTypeSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntTypeDto intTypeDto = new IntTypeDto();
        model.addAttribute("intType", intTypeDto);
        model.addAttribute("intTypeSearch", intTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intTypeRestController.findAllIntTypeSearch(intTypeSearch).getBody();
        model.addAttribute("intTypeList", response.getData());
        return "createIntType";
    }

    @GetMapping("/createIntType")
    public String createIntType(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntTypeDto intTypeDto = new IntTypeDto();
        model.addAttribute("intType", intTypeDto);
        IntTypeSearch intTypeSearch = new IntTypeSearch();
        model.addAttribute("intTypeSearch", intTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intTypeRestController.findAllIntType().getBody();
        model.addAttribute("intTypeList", response.getData());
        return "createIntType";
    }

    @RequestMapping(value = "/createIntType", method = RequestMethod.POST)
    public String createIntType(Model model, @ModelAttribute("intType") IntTypeDto intTypeDto) {
        Response response = (Response) this.intTypeRestController.createIntType(intTypeDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntType";
        }
    }

    @GetMapping(value="/intTypeEdit/{intTypeUuid}")
    public String intTypeEdit(Model model, @PathVariable String intTypeUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intTypeRestController.findIntTypeByIntTypeUuid(intTypeUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intType", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", (Map)response.getData());
        return "intTypeEdit";
    }

    @RequestMapping(value="/intTypeEdit/{intTypeUuid}", method=RequestMethod.POST)
    public String intTypeEdit(Model model, @PathVariable String intTypeUuid, @ModelAttribute("intType") IntTypeDto intTypeDto) {
        Response response = (Response) this.intTypeRestController.updateIntType(intTypeDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intTypeEdit";
        }
    }

    @RequestMapping(value="/intTypeDelete/{intTypeUuid}",method = RequestMethod.GET)
    public String intTypeDelete(@PathVariable String intTypeUuid) {
        Response response = (Response) this.intTypeRestController.deleteIntTypeByIntTypeUuid(intTypeUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intAppSearch",method = RequestMethod.POST)
    public String intAppSearch(Model model, @ModelAttribute("intAppSearch") IntAppSearch intAppSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntAppAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_app_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntAppDto intAppDto = new IntAppDto();
        model.addAttribute("intApp", intAppDto);
        model.addAttribute("intTypeSearch", intAppSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrgID().getBody();
        model.addAttribute("orgID", response.getData());
        response = (Response) this.utilRestController.getAllOrgUUID().getBody();
        model.addAttribute("orgUUID", response.getData());
        response = (Response) this.intAppRestController.findAllIntAppSearch(intAppSearch).getBody();
        model.addAttribute("intAppList", response.getData());
        return "createIntApp";
    }

    @GetMapping("/createIntApp")
    public String createIntApp(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntAppAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_app_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntAppDto intAppDto = new IntAppDto();
        model.addAttribute("intApp", intAppDto);
        IntAppSearch intAppSearch = new IntAppSearch();
        model.addAttribute("intAppSearch", intAppSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrgID().getBody();
        model.addAttribute("orgID", response.getData());
        response = (Response) this.utilRestController.getAllOrgUUID().getBody();
        model.addAttribute("orgUUID", response.getData());
        response = (Response) this.intAppRestController.findAllIntApp().getBody();
        model.addAttribute("intAppList", response.getData());
        return "createIntApp";
    }

    @RequestMapping(value = "/createIntApp", method = RequestMethod.POST)
    public String createIntApp(Model model, @ModelAttribute("intApp") IntAppDto intAppDto) {
        Response response = (Response) this.intAppRestController.createIntApp(intAppDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntApp";
        }
    }

    @GetMapping(value="/intAppEdit/{intAppUuId}")
    public String intAppEdit(Model model, @PathVariable String intAppUuId) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntAppAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_app_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_app_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intAppRestController.findIntAppByIntAppUuId(intAppUuId).getBody();
        logger.info(response.toString());
        model.addAttribute("intApp", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.utilRestController.getAllOrgID().getBody();
        model.addAttribute("orgID", response.getData());
        response = (Response) this.utilRestController.getAllOrgUUID().getBody();
        model.addAttribute("orgUUID", response.getData());
        return "intAppEdit";
    }

    @RequestMapping(value="/intAppEdit/{intAppUuId}", method=RequestMethod.POST)
    public String intAppEdit(Model model, @PathVariable String intAppUuId, @ModelAttribute("intApp") IntAppDto intAppDto) {
        Response response = (Response) this.intAppRestController.updateIntApp(intAppDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intAppEdit";
        }
    }

    @RequestMapping(value="/intAppDelete/{intAppUuId}",method = RequestMethod.GET)
    public String intAppDelete(@PathVariable String intAppUuId) {
        Response response = (Response) this.intAppRestController.deleteIntAppByIntAppUuId(intAppUuId).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intEnvTypeSearch",method = RequestMethod.POST)
    public String intEnvTypeSearch(Model model, @ModelAttribute("intEnvTypeSearch") IntEnvTypeSearch intEnvTypeSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntEnvTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_env_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntEnvTypeDto intEnvTypeDto = new IntEnvTypeDto();
        model.addAttribute("intEnvType", intEnvTypeDto);
        model.addAttribute("intEnvTypeSearch", intEnvTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intEnvTypeRestController.findAllIntEnvTypeSearch(intEnvTypeSearch).getBody();
        model.addAttribute("intEnvTypeList", response.getData());
        return "createIntEnvType";
    }

    @GetMapping("/createIntEnvType")
    public String createIntEnvType(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntEnvTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_env_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntEnvTypeDto intEnvTypeDto = new IntEnvTypeDto();
        model.addAttribute("intEnvType", intEnvTypeDto);
        IntEnvTypeSearch intEnvTypeSearch = new IntEnvTypeSearch();
        model.addAttribute("intEnvTypeSearch", intEnvTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intEnvTypeRestController.findAllIntEnvType().getBody();
        model.addAttribute("intEnvTypeList", response.getData());
        return "createIntEnvType";
    }

    @RequestMapping(value = "/createIntEnvType", method = RequestMethod.POST)
    public String createIntEnvType(Model model, @ModelAttribute("intEnvType") IntEnvTypeDto intEnvTypeDto) {
        Response response = (Response) this.intEnvTypeRestController.createIntEnvType(intEnvTypeDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntEnvType";
        }
    }

    @GetMapping(value="/intEnvTypeEdit/{intEnvTypeUuid}")
    public String intEnvTypeEdit(Model model, @PathVariable String intEnvTypeUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntEnvTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_env_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_env_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intEnvTypeRestController.findIntEnvTypeByIntEnvTypeUuid(intEnvTypeUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intEnvType", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "intEnvTypeEdit";
    }

    @RequestMapping(value="/intEnvTypeEdit/{intEnvTypeUuid}", method=RequestMethod.POST)
    public String intAppEdit(Model model, @PathVariable String intEnvTypeUuid, @ModelAttribute("intEnvType") IntEnvTypeDto intEnvTypeDto) {
        Response response = (Response) this.intEnvTypeRestController.updateIntEnvType(intEnvTypeDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intEnvTypeEdit";
        }
    }

    @RequestMapping(value="/intEnvTypeDelete/{intEnvTypeUuid}",method = RequestMethod.GET)
    public String intEnvTypeDelete(@PathVariable String intEnvTypeUuid) {
        Response response = (Response) this.intEnvTypeRestController.deleteIntEnvTypeByIntEnvTypeUuid(intEnvTypeUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intLogTypeSearch",method = RequestMethod.POST)
    public String intLogTypeSearch(Model model, @ModelAttribute("intLogTypeSearch") IntLogTypeSearch intLogTypeSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntLogTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_log_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntLogTypeDto intLogTypeDto = new IntLogTypeDto();
        model.addAttribute("intLogType", intLogTypeDto);
        model.addAttribute("intLogTypeSearch", intLogTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intLogTypeRestController.findAllIntLogTypSearch(intLogTypeSearch).getBody();
        model.addAttribute("intLogTypeList", response.getData());
        return "createIntLogType";
    }

    @GetMapping("/createIntLogType")
    public String createIntLogType(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntLogTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_log_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntLogTypeDto intLogTypeDto = new IntLogTypeDto();
        model.addAttribute("intLogType", intLogTypeDto);
        IntLogTypeSearch intLogTypeSearch = new IntLogTypeSearch();
        model.addAttribute("intLogTypeSearch", intLogTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intLogTypeRestController.findAllIntLogType().getBody();
        model.addAttribute("intLogTypeList", response.getData());
        return "createIntLogType";
    }

    @RequestMapping(value = "/createIntLogType", method = RequestMethod.POST)
    public String createIntLogType(Model model, @ModelAttribute("intLogType") IntLogTypeDto intLogTypeDto) {
        Response response = (Response) this.intLogTypeRestController.createIntLogType(intLogTypeDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntLogType";
        }
    }

    @GetMapping(value="/intLogTypeEdit/{intLogTypeUuid}")
    public String intLogTypeEdit(Model model, @PathVariable String intLogTypeUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntLogTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_log_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intLogTypeRestController.findIntLogTypByIntLogTypeUuid(intLogTypeUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intLogType", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "intLogTypeEdit";
    }

    @RequestMapping(value="/intLogTypeEdit/{intLogTypeUuid}", method=RequestMethod.POST)
    public String intAppEdit(Model model, @PathVariable String intLogTypeUuid, @ModelAttribute("intLogType") IntLogTypeDto intLogTypeDto) {
        Response response = (Response) this.intLogTypeRestController.updateIntLogType(intLogTypeDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intLogTypeEdit";
        }
    }

    @RequestMapping(value="/intLogTypeDelete/{intLogTypeUuid}",method = RequestMethod.GET)
    public String intLogTypeDelete(@PathVariable String intLogTypeUuid) {
        Response response = (Response) this.intLogTypeRestController.deleteIntLogTypByIntLogTypeUuid(intLogTypeUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intLogLevelTypeSearch",method = RequestMethod.POST)
    public String intLogLevelTypeSearch(Model model, @ModelAttribute("intLogLevelTypeSearch") IntLogLevelTypeSearch intLogLevelTypeSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntLogLevelTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_log_level_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntLogLevelTypeDto logLevelTypeDto = new IntLogLevelTypeDto();
        model.addAttribute("intLogLevelType", logLevelTypeDto);
        model.addAttribute("intLogLevelTypeSearch", intLogLevelTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intLogLevelTypeRestController.findAllIntLogLevelTypeSearch(intLogLevelTypeSearch).getBody();
        model.addAttribute("intLogTypeList", response.getData());
        return "createIntLogLevelType";
    }

    @GetMapping("/createIntLogLevelType")
    public String createIntLogLevelType(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntLogLevelTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_log_level_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntLogLevelTypeDto logLevelTypeDto = new IntLogLevelTypeDto();
        model.addAttribute("intLogLevelType", logLevelTypeDto);
        IntLogLevelTypeSearch intLogLevelTypeSearch = new IntLogLevelTypeSearch();
        model.addAttribute("intLogLevelTypeSearch", intLogLevelTypeSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intLogLevelTypeRestController.findAllIntLogLevelType().getBody();
        model.addAttribute("intLogTypeList", response.getData());
        return "createIntLogLevelType";
    }

    @RequestMapping(value = "/createIntLogLevelType", method = RequestMethod.POST)
    public String createIntLogType(Model model, @ModelAttribute("intLogLevelType") IntLogLevelTypeDto logLevelTypeDto) {
        Response response = (Response) this.intLogLevelTypeRestController.createIntLogLevelType(logLevelTypeDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntLogLevelType";
        }
    }

    @GetMapping(value="/intLogLevelTypeEdit/{intLogLevelTypeUuid}")
    public String intLogLevelTypeEdit(Model model, @PathVariable String intLogLevelTypeUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntLogLevelTypeAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_log_level_type_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_log_level_type_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intLogLevelTypeRestController.findIntLogLevelTypeByIntLogLevelTypeUuid(intLogLevelTypeUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intLogLevelType", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "intLogLevelTypeEdit";
    }

    @RequestMapping(value="/intLogLevelTypeEdit/{intLogLevelTypeUuid}", method=RequestMethod.POST)
    public String intLogLevelTypeEdit(Model model, @PathVariable String intLogLevelTypeUuid,
        @ModelAttribute("intLogLevelType") IntLogLevelTypeDto logLevelTypeDto) {
        Response response = (Response) this.intLogLevelTypeRestController.updateIntLogLevelType(logLevelTypeDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intLogLevelTypeEdit";
        }
    }

    @RequestMapping(value="/intLogLevelTypeDelete/{intLogLevelTypeUuid}",method = RequestMethod.GET)
    public String intLogLevelTypeDelete(@PathVariable String intLogLevelTypeUuid) {
        Response response = (Response) this.intLogLevelTypeRestController.deleteIntLogLevelTypeByIntLogLevelTypeUuid(intLogLevelTypeUuid).getBody();
        return "redirect:/int";
    }

    @RequestMapping(value="/intTransSearch",method = RequestMethod.POST)
    public String intTransSearch(Model model, @ModelAttribute("intTransSearch") IntTransSearch intTransSearch) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntTransAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_trans_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntTransDto intTransDto = new IntTransDto();
        model.addAttribute("intTrans", intTransDto);
        model.addAttribute("intTransSearch", intTransSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intTransRestController.findAllIntTransSearch(intTransSearch).getBody();
        model.addAttribute("intTransList", response.getData());
        return "createIntTrans";
    }

    @GetMapping("/createIntTrans")
    public String createIntTrans(Model model) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntTransAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_trans_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        IntTransDto intTransDto = new IntTransDto();
        model.addAttribute("intTrans", intTransDto);
        IntTransSearch intTransSearch = new IntTransSearch();
        model.addAttribute("intTransSearch", intTransSearch);
        Response response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        response = (Response) this.intTransRestController.findAllIntTrans().getBody();
        model.addAttribute("intTransList", response.getData());
        return "createIntTrans";
    }

    @RequestMapping(value = "/createIntTrans", method = RequestMethod.POST)
    public String createIntTrans(Model model, @ModelAttribute("intTrans") IntTransDto intTransDto) {
        Response response = (Response) this.intTransRestController.createIntTrans(intTransDto).getBody();
        logger.info(response.toString());
        if (response.getStatus().equals("Success")) {
            return "redirect:int";
        } else {
            model.addAttribute(response);
            return "createIntTrans";
        }
    }

    @GetMapping(value="/intTransEdit/{intTransUuid}")
    public String intTransEdit(Model model, @PathVariable String intTransUuid) {
        UserPrincipal userPrincipal = getUserPrincipal();
        model.addAttribute("isIntTransAccess",  userPrincipal.getPermissionListViews().stream()
                .filter(t -> {
                    if (t.getRoleName().equalsIgnoreCase("role_int_trans_superadmin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_admin") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_editor") ||
                            t.getRoleName().equalsIgnoreCase("role_int_trans_view")) {
                        return true;
                    }
                    return false;
                }).findFirst().get());
        Response response = (Response) this.intTransRestController.findIntTransByIntTransUuid(intTransUuid).getBody();
        logger.info(response.toString());
        model.addAttribute("intTrans", response.getData());
        response = (Response) this.utilRestController.getAllActiveUserUUID().getBody();
        model.addAttribute("userIds", response.getData());
        return "intTransEdit";
    }

    @RequestMapping(value="/intTransEdit/{intTransUuid}", method=RequestMethod.POST)
    public String intTransEdit(Model model, @PathVariable String intTransUuid, @ModelAttribute("intTrans") IntTransDto intTransDto) {
        Response response = (Response) this.intTransRestController.updateIntTrans(intTransDto).getBody();
        if (response.getStatus().equals("Success")) {
            return "redirect:/int";
        } else {
            model.addAttribute(response);
            return "intTransEdit";
        }
    }

    @RequestMapping(value="/intTransDelete/{intTransUuid}",method = RequestMethod.GET)
    public String intTransDelete(@PathVariable String intTransUuid) {
        Response response = (Response) this.intTransRestController.deleteIntTransByIntTransUuid(intTransUuid).getBody();
        return "redirect:/int";
    }

    private UserPrincipal getUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return userPrincipal;
    }

}