export enum ApiTestRouteEnum {
  API_TEST = 'apiTest',
  API_TEST_DEBUG = 'apiTestDebug',
}

export enum BugManagementRouteEnum {
  BUG_MANAGEMENT = 'bugManagement',
  BUG_MANAGEMENT_INDEX = 'bugManagementIndex',
  BUG_MANAGEMENT_DETAIL = 'bugManagementDetail',
  BUG_MANAGEMENT_RECYCLE = 'bugManagementRecycle',
}

export enum CaseManagementRouteEnum {
  CASE_MANAGEMENT = 'caseManagement',
  CASE_MANAGEMENT_CASE = 'caseManagementCase',
  CASE_MANAGEMENT_CASE_CREATE_SUCCESS = 'caseManagementCaseCreateSuccess',
  CASE_MANAGEMENT_CASE_RECYCLE = 'caseManagementCaseRecycle',
  CASE_MANAGEMENT_CASE_DETAIL = 'caseManagementCaseDetail',
  CASE_MANAGEMENT_REVIEW = 'caseManagementReview',
  CASE_MANAGEMENT_REVIEW_CREATE = 'caseManagementReviewCreate',
  CASE_MANAGEMENT_REVIEW_DETAIL = 'caseManagementReviewDetail',
  CASE_MANAGEMENT_REVIEW_DETAIL_CASE_DETAIL = 'caseManagementReviewDetailCaseDetail',
}

export enum PerformanceTestRouteEnum {
  PERFORMANCE_TEST = 'performanceTest',
}

export enum ProjectManagementRouteEnum {
  PROJECT_MANAGEMENT = 'projectManagement',
  PROJECT_MANAGEMENT_FILE_MANAGEMENT = 'projectManagementFileManageMent',
  PROJECT_MANAGEMENT_MESSAGE_MANAGEMENT = 'projectManagementMessageManagement',
  PROJECT_MANAGEMENT_COMMON_SCRIPT = 'projectManagementCommonScript',
  PROJECT_MANAGEMENT_MESSAGE_MANAGEMENT_EDIT = 'projectManagementMessageManagementEdit',
  PROJECT_MANAGEMENT_LOG = 'projectManagementLog',
  PROJECT_MANAGEMENT_PERMISSION = 'projectManagementPermission',
  PROJECT_MANAGEMENT_PERMISSION_BASIC_INFO = 'projectManagementPermissionBasicInfo',
  PROJECT_MANAGEMENT_PERMISSION_MENU_MANAGEMENT = 'projectManagementPermissionMenuManagement',
  PROJECT_MANAGEMENT_TEMPLATE = 'projectManagementTemplate',
  PROJECT_MANAGEMENT_TEMPLATE_MANAGEMENT = 'projectManagementTemplateManagement',
  PROJECT_MANAGEMENT_TEMPLATE_MANAGEMENT_DETAIL = 'projectManagementTemplateManagementDetail',
  PROJECT_MANAGEMENT_TEMPLATE_MANAGEMENT_WORKFLOW = 'projectManagementTemplateManagementWorkFlow',
  PROJECT_MANAGEMENT_TEMPLATE_FIELD_SETTING = 'projectManagementTemplateFiledSetting',
  PROJECT_MANAGEMENT_PERMISSION_VERSION = 'projectManagementPermissionVersion',
  PROJECT_MANAGEMENT_PERMISSION_USER_GROUP = 'projectManagementPermissionUserGroup',
  PROJECT_MANAGEMENT_PERMISSION_MEMBER = 'projectManagementPermissionMember',
  PROJECT_MANAGEMENT_MENU_MANAGEMENT_ERROR_REPORT_RULE = 'projectManagementMenuManagementErrorReportRule',
}

export enum TestPlanRouteEnum {
  TEST_PLAN = 'testPlan',
}

export enum UITestRouteEnum {
  UI_TEST = 'uiTest',
}

export enum WorkbenchRouteEnum {
  WORKBENCH = 'workbench',
}

export enum SettingRouteEnum {
  SETTING = 'setting',
  SETTING_SYSTEM = 'settingSystem',
  SETTING_SYSTEM_USER_SINGLE = 'settingSystemUser',
  SETTING_SYSTEM_USER_GROUP = 'settingSystemUserGroup',
  SETTING_SYSTEM_ORGANIZATION = 'settingSystemOrganization',
  SETTING_SYSTEM_PARAMETER = 'settingSystemParameter',
  SETTING_SYSTEM_RESOURCE_POOL = 'settingSystemResourcePool',
  SETTING_SYSTEM_RESOURCE_POOL_DETAIL = 'settingSystemResourcePoolDetail',
  SETTING_SYSTEM_AUTHORIZED_MANAGEMENT = 'settingSystemAuthorizedManagement',
  SETTING_SYSTEM_LOG = 'settingSystemLog',
  SETTING_SYSTEM_PLUGIN_MANAGEMENT = 'settingSystemPluginManagement',
  SETTING_ORGANIZATION = 'settingOrganization',
  SETTING_ORGANIZATION_MEMBER = 'settingOrganizationMember',
  SETTING_ORGANIZATION_USER_GROUP = 'settingOrganizationUserGroup',
  SETTING_ORGANIZATION_PROJECT = 'settingOrganizationProject',
  SETTING_ORGANIZATION_TEMPLATE = 'settingOrganizationTemplate',
  SETTING_ORGANIZATION_TEMPLATE_FILED_SETTING = 'settingOrganizationTemplateFiledSetting',
  SETTING_ORGANIZATION_TEMPLATE_MANAGEMENT = 'settingOrganizationTemplateManagement',
  SETTING_ORGANIZATION_TEMPLATE_MANAGEMENT_DETAIL = 'settingOrganizationTemplateManagementDetail',
  SETTING_ORGANIZATION_TEMPLATE_MANAGEMENT_WORKFLOW = 'settingOrganizationTemplateWorkFlow',
  SETTING_ORGANIZATION_SERVICE = 'settingOrganizationService',
  SETTING_ORGANIZATION_LOG = 'settingOrganizationLog',
}

export const RouteEnum = {
  ...ApiTestRouteEnum,
  ...SettingRouteEnum,
  ...BugManagementRouteEnum,
  ...CaseManagementRouteEnum,
  ...PerformanceTestRouteEnum,
  ...ProjectManagementRouteEnum,
  ...TestPlanRouteEnum,
  ...UITestRouteEnum,
  ...WorkbenchRouteEnum,
};
