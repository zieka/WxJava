package me.chanjar.weixin.cp.constant;


/**
 * <pre>
 *  企业微信api地址常量类
 *  Created by BinaryWang on 2019-06-02.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public interface WxCpApiPathConsts {
  String DEFAULT_CP_BASE_URL = "https://qyapi.weixin.qq.com";

  String GET_JSAPI_TICKET = "/cgi-bin/get_jsapi_ticket";
  String GET_AGENT_CONFIG_TICKET = "/cgi-bin/ticket/get?&type=agent_config";
  String GET_CALLBACK_IP = "/cgi-bin/getcallbackip";
  String BATCH_REPLACE_PARTY = "/cgi-bin/batch/replaceparty";
  String BATCH_REPLACE_USER = "/cgi-bin/batch/replaceuser";
  String BATCH_GET_RESULT = "/cgi-bin/batch/getresult?jobid=";
  String JSCODE_TO_SESSION = "/cgi-bin/miniprogram/jscode2session";
  String GET_TOKEN = "/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
  String WEBHOOK_SEND = "/cgi-bin/webhook/send?key=";

  /**
   * 消息推送相关接口
   * https://work.weixin.qq.com/api/doc/90000/90135/90235
   */
  interface Message {
    /**
     * 发送应用消息
     */
    String MESSAGE_SEND = "/cgi-bin/message/send";

    /**
     * 查询应用消息发送统计
     */
    String GET_STATISTICS = "/cgi-bin/message/get_statistics";

    /**
     * 互联企业发送应用消息
     */
    String LINKEDCORP_MESSAGE_SEND = "/cgi-bin/linkedcorp/message/send";
  }

  interface Agent {
    String AGENT_GET = "/cgi-bin/agent/get?agentid=%d";
    String AGENT_SET = "/cgi-bin/agent/set";
    String AGENT_LIST = "/cgi-bin/agent/list";
  }

  interface WorkBench {
    String WORKBENCH_TEMPLATE_SET = "/cgi-bin/agent/set_workbench_template";
    String WORKBENCH_TEMPLATE_GET = "/cgi-bin/agent/get_workbench_template";
    String WORKBENCH_DATA_SET = "/cgi-bin/agent/set_workbench_data";
  }

  interface OAuth2 {
    String GET_USER_INFO = "/cgi-bin/user/getuserinfo?code=%s&agentid=%d";
    String GET_USER_DETAIL = "/cgi-bin/user/getuserdetail";
    String URL_OAUTH2_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";
  }

  interface Chat {
    String APPCHAT_CREATE = "/cgi-bin/appchat/create";
    String APPCHAT_UPDATE = "/cgi-bin/appchat/update";
    String APPCHAT_GET_CHATID = "/cgi-bin/appchat/get?chatid=";
    String APPCHAT_SEND = "/cgi-bin/appchat/send";
  }

  interface Department {
    String DEPARTMENT_CREATE = "/cgi-bin/department/create";
    String DEPARTMENT_UPDATE = "/cgi-bin/department/update";
    String DEPARTMENT_DELETE = "/cgi-bin/department/delete?id=%d";
    String DEPARTMENT_LIST = "/cgi-bin/department/list";
  }

  interface Media {
    String MEDIA_GET = "/cgi-bin/media/get";
    String MEDIA_UPLOAD = "/cgi-bin/media/upload?type=";
    String IMG_UPLOAD = "/cgi-bin/media/uploadimg";
    String JSSDK_MEDIA_GET = "/cgi-bin/media/get/jssdk";
  }

  interface Menu {
    String MENU_CREATE = "/cgi-bin/menu/create?agentid=%d";
    String MENU_DELETE = "/cgi-bin/menu/delete?agentid=%d";
    String MENU_GET = "/cgi-bin/menu/get?agentid=%d";
  }

  interface Oa {
    String GET_CORP_CHECKIN_OPTION = "/cgi-bin/checkin/getcorpcheckinoption";
    String GET_CHECKIN_DATA = "/cgi-bin/checkin/getcheckindata";
    String GET_CHECKIN_OPTION = "/cgi-bin/checkin/getcheckinoption";
    String GET_CHECKIN_DAY_DATA = "/cgi-bin/checkin/getcheckin_daydata";
    String GET_CHECKIN_MONTH_DATA = "/cgi-bin/checkin/getcheckin_monthdata";
    String GET_CHECKIN_SCHEDULE_DATA = "/cgi-bin/checkin/getcheckinschedulist";
    String SET_CHECKIN_SCHEDULE_DATA = "/cgi-bin/checkin/setcheckinschedulist";
    String GET_APPROVAL_INFO = "/cgi-bin/oa/getapprovalinfo";
    String GET_APPROVAL_DETAIL = "/cgi-bin/oa/getapprovaldetail";
    String GET_DIAL_RECORD = "/cgi-bin/dial/get_dial_record";
    String GET_TEMPLATE_DETAIL = "/cgi-bin/oa/gettemplatedetail";
    String APPLY_EVENT = "/cgi-bin/oa/applyevent";

    String CALENDAR_ADD = "/cgi-bin/oa/calendar/add";
    String CALENDAR_UPDATE = "/cgi-bin/oa/calendar/update";
    String CALENDAR_GET = "/cgi-bin/oa/calendar/get";
    String CALENDAR_DEL = "/cgi-bin/oa/calendar/del";

    String SCHEDULE_ADD = "/cgi-bin/oa/schedule/add";
    String SCHEDULE_UPDATE = "/cgi-bin/oa/schedule/update";
    String SCHEDULE_GET = "/cgi-bin/oa/schedule/get";
    String SCHEDULE_DEL = "/cgi-bin/oa/schedule/del";
    String SCHEDULE_LIST = "/cgi-bin/oa/schedule/get_by_calendar";

    String COPY_TEMPLATE = "/cgi-bin/oa/approval/copytemplate";
  }

  interface Living {
    String GET_LIVING_CODE = "/cgi-bin/living/get_living_code";
    String GET_LIVING_INFO = "/cgi-bin/living/get_living_info?livingid=";
    String GET_WATCH_STAT = "/cgi-bin/living/get_watch_stat";
    String GET_LIVING_SHARE_INFO = "/cgi-bin/living/get_living_share_info";
    String GET_USER_ALL_LIVINGID = "/cgi-bin/living/get_user_all_livingid";

    String CREATE = "/cgi-bin/living/create";
    String MODIFY = "/cgi-bin/living/modify";
    String CANCEL = "/cgi-bin/living/cancel";
    String DELETE_REPLAY_DATA = "/cgi-bin/living/delete_replay_data";
  }

  interface Tag {
    String TAG_CREATE = "/cgi-bin/tag/create";
    String TAG_UPDATE = "/cgi-bin/tag/update";
    String TAG_DELETE = "/cgi-bin/tag/delete?tagid=%s";
    String TAG_LIST = "/cgi-bin/tag/list";
    String TAG_GET = "/cgi-bin/tag/get?tagid=%s";
    String TAG_ADD_TAG_USERS = "/cgi-bin/tag/addtagusers";
    String TAG_DEL_TAG_USERS = "/cgi-bin/tag/deltagusers";
  }

  interface TaskCard {
    String UPDATE_TASK_CARD = "/cgi-bin/message/update_taskcard";
  }

  interface Tp {
    String JSCODE_TO_SESSION = "/cgi-bin/service/miniprogram/jscode2session";
    String GET_CORP_TOKEN = "/cgi-bin/service/get_corp_token";
    String GET_PERMANENT_CODE = "/cgi-bin/service/get_permanent_code";
    String GET_SUITE_TOKEN = "/cgi-bin/service/get_suite_token";
    String GET_PROVIDER_TOKEN = "/cgi-bin/service/get_provider_token";
    String GET_PREAUTH_CODE = "/cgi-bin/service/get_pre_auth_code";
    String GET_AUTH_INFO = "/cgi-bin/service/get_auth_info";
    String GET_AUTH_CORP_JSAPI_TICKET = "/cgi-bin/get_jsapi_ticket";
    String GET_SUITE_JSAPI_TICKET = "/cgi-bin/ticket/get";
    String GET_USERINFO3RD = "/cgi-bin/service/getuserinfo3rd";
    String GET_USERDETAIL3RD = "/cgi-bin/service/getuserdetail3rd";
    String GET_LOGIN_INFO = "/cgi-bin/service/get_login_info";


    String CONTACT_SEARCH = "/cgi-bin/service/contact/search";
    String GET_ADMIN_LIST = "/cgi-bin/service/get_admin_list";

  }

  interface User {
    String USER_AUTHENTICATE = "/cgi-bin/user/authsucc?userid=";
    String USER_CREATE = "/cgi-bin/user/create";
    String USER_UPDATE = "/cgi-bin/user/update";
    String USER_DELETE = "/cgi-bin/user/delete?userid=";
    String USER_BATCH_DELETE = "/cgi-bin/user/batchdelete";
    String USER_GET = "/cgi-bin/user/get?userid=";
    String USER_LIST = "/cgi-bin/user/list?department_id=";
    String USER_SIMPLE_LIST = "/cgi-bin/user/simplelist?department_id=";
    String BATCH_INVITE = "/cgi-bin/batch/invite";
    String USER_CONVERT_TO_OPENID = "/cgi-bin/user/convert_to_openid";
    String USER_CONVERT_TO_USERID = "/cgi-bin/user/convert_to_userid";
    String GET_USER_ID = "/cgi-bin/user/getuserid";
    String GET_EXTERNAL_CONTACT = "/cgi-bin/crm/get_external_contact?external_userid=";
    String GET_JOIN_QR_CODE = "/cgi-bin/corp/get_join_qrcode?size_type=";
  }

  interface ExternalContact {
    @Deprecated
    String GET_EXTERNAL_CONTACT = "/cgi-bin/crm/get_external_contact?external_userid=";

    String ADD_CONTACT_WAY = "/cgi-bin/externalcontact/add_contact_way";
    String GET_CONTACT_WAY = "/cgi-bin/externalcontact/get_contact_way";
    String UPDATE_CONTACT_WAY = "/cgi-bin/externalcontact/update_contact_way";
    String DEL_CONTACT_WAY = "/cgi-bin/externalcontact/del_contact_way";
    String CLOSE_TEMP_CHAT = "/cgi-bin/externalcontact/close_temp_chat";
    String GET_FOLLOW_USER_LIST = "/cgi-bin/externalcontact/get_follow_user_list";
    String GET_CONTACT_DETAIL = "/cgi-bin/externalcontact/get?external_userid=";
    String CONVERT_TO_OPENID = "/cgi-bin/externalcontact/convert_to_openid";
    String UNIONID_TO_EXTERNAL_USERID = "/cgi-bin/externalcontact/unionid_to_external_userid";
    String UNIONID_TO_EXTERNAL_USERID_3RD = "/cgi-bin/service/externalcontact/unionid_to_external_userid_3rd";
    String GET_NEW_EXTERNAL_USERID = "/cgi-bin/service/externalcontact/get_new_external_userid";
    String TO_SERVICE_EXTERNAL_USERID = "/cgi-bin/externalcontact/to_service_external_userid";
    String FINISH_EXTERNAL_USERID_MIGRATION = "/cgi-bin/externalcontact/finish_external_userid_migration";
    String GET_CONTACT_DETAIL_BATCH = "/cgi-bin/externalcontact/batch/get_by_user?";
    String UPDATE_REMARK = "/cgi-bin/externalcontact/remark";
    String LIST_EXTERNAL_CONTACT = "/cgi-bin/externalcontact/list?userid=";
    String LIST_UNASSIGNED_CONTACT = "/cgi-bin/externalcontact/get_unassigned_list";
    @Deprecated
    String TRANSFER_UNASSIGNED_CONTACT = "/cgi-bin/externalcontact/transfer";
    String TRANSFER_CUSTOMER = "/cgi-bin/externalcontact/transfer_customer";
    String TRANSFER_RESULT = "/cgi-bin/externalcontact/transfer_result";
    String RESIGNED_TRANSFER_CUSTOMER = "/cgi-bin/externalcontact/resigned/transfer_customer";
    String RESIGNED_TRANSFER_RESULT = "/cgi-bin/externalcontact/resigned/transfer_result";
    String GROUP_CHAT_LIST = "/cgi-bin/externalcontact/groupchat/list";
    String GROUP_CHAT_INFO = "/cgi-bin/externalcontact/groupchat/get";
    String OPENID_TO_CHATID= "/cgi-bin/externalcontact/opengid_to_chatid";
    String GROUP_CHAT_TRANSFER = "/cgi-bin/externalcontact/groupchat/transfer";
    String LIST_USER_BEHAVIOR_DATA = "/cgi-bin/externalcontact/get_user_behavior_data";
    String LIST_GROUP_CHAT_DATA = "/cgi-bin/externalcontact/groupchat/statistic";
    String ADD_MSG_TEMPLATE = "/cgi-bin/externalcontact/add_msg_template";
    String SEND_WELCOME_MSG = "/cgi-bin/externalcontact/send_welcome_msg";

    String GET_CORP_TAG_LIST = "/cgi-bin/externalcontact/get_corp_tag_list";
    String ADD_CORP_TAG = "/cgi-bin/externalcontact/add_corp_tag";
    String EDIT_CORP_TAG = "/cgi-bin/externalcontact/edit_corp_tag";
    String DEL_CORP_TAG = "/cgi-bin/externalcontact/del_corp_tag";
    String MARK_TAG = "/cgi-bin/externalcontact/mark_tag";

    String ADD_MOMENT_TASK = "/cgi-bin/externalcontact/add_moment_task";
    String GET_MOMENT_TASK_RESULT = "/cgi-bin/externalcontact/get_moment_task_result";
    String GET_MOMENT_LIST = "/cgi-bin/externalcontact/get_moment_list";
    String GET_MOMENT_TASK = "/cgi-bin/externalcontact/get_moment_task";
    String GET_MOMENT_CUSTOMER_LIST = "/cgi-bin/externalcontact/get_moment_customer_list";
    String GET_MOMENT_SEND_RESULT = "/cgi-bin/externalcontact/get_moment_send_result";
    String GET_MOMENT_COMMENTS = "/cgi-bin/externalcontact/get_moment_comments";

    String GET_GROUP_MSG_SEND_RESULT = "/cgi-bin/externalcontact/get_groupmsg_send_result";
    String GET_GROUP_MSG_TASK = "/cgi-bin/externalcontact/get_groupmsg_task";
    String GET_GROUP_MSG_LIST_V2 = "/cgi-bin/externalcontact/get_groupmsg_list_v2";
    String GET_GROUP_MSG_RESULT = "/cgi-bin/externalcontact/get_group_msg_result";

    String GET_PRODUCT_ALBUM = "/cgi-bin/externalcontact/get_product_album";
    String GET_PRODUCT_ALBUM_LIST = "/cgi-bin/externalcontact/get_product_album_list";

    String GROUP_WELCOME_TEMPLATE_ADD = "/cgi-bin/externalcontact/group_welcome_template/add";
    String GROUP_WELCOME_TEMPLATE_EDIT = "/cgi-bin/externalcontact/group_welcome_template/edit";
    String GROUP_WELCOME_TEMPLATE_GET = "/cgi-bin/externalcontact/group_welcome_template/get";
    String GROUP_WELCOME_TEMPLATE_DEL = "/cgi-bin/externalcontact/group_welcome_template/del";

  }
}
