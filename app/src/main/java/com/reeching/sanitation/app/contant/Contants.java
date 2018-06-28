package com.reeching.sanitation.app.contant;

/**
 * Created by 绍轩 on 2017/12/12.
 */

public class Contants {
    //基础数据平台 :基层单位界面（Basics_Grassroots）,业务检查科页面（Basics_Inspect）
    //基层单位界面（Basics_Grassroots）
    public static final int BASICS_WC = 1;
    public static final int BASICS_INVESTIGATE = 2;
    public static final int BASICS_ALTER = 3;


    //业务检查科页面（Basics_Inspect）：基础数据页面（Basics_InsFragment），待审核数据页面（Basics_InvFragment）
    public static final int BASICS_INS = 4;
    public static final int BASICS_INV = 5;
    //
    public static final int INS_WC = 6;//公厕
    public static final int INS_ROAD = 7;//道路
    public static final int INS_WASTE = 8;//垃圾楼
    public static final int INS_PEOPLE = 9;//人员

    public static final int PAZE_SIZE = 10;
    public static final int INS_WCAdd_ONEPIC = 11;//基础数据-公厕页面添加一张图片
    public static final int INS_WCAdd_MUCHPIC = 12;//基础数据-公厕页面添加多张图片
    public static final int INS_WASTEAdd_ONEPIC = 13;//基础数据-垃圾楼页面添加单张图片
    public static final int INS_WASTEAdd_MUCHPIC = 14;//基础数据-垃圾楼页面添加多张图片


    public static final int INS_PEOPLEAdd_ONEPIC = 15;//基础数据-人员页面添加单张图片
    public static final int INV_WC = 16;//公厕
    public static final int INV_ROAD = 17;//道路
    public static final int INV_WASTE = 18;//垃圾楼
    public static final int INV_PEOPLE = 19;//人员

    //添加页面
    public static final int ADD_LEADER = 20;//分管领导
    public static final int ADD_PLACE = 21;//所属场队
    public static final int ADD_PRINCIPAL = 22;//场队负责人
    public static final int ADD_ELEMENT = 23;//所属分队
    public static final int ADD_ELEMENT_PRINCIPAL = 24;//分队负责人
    public static final int ADD_CLASS = 25;//所属班组
    public static final int ADD_CLASS_PRINCIPAL = 26;//班组负责人
    public static final int ADD_BLOCK = 27;//获取所属街乡
    public static final int ADD_COMMUNITY = 28;//获取所属社区





    //监督检查考核平台:基层单位界面,
    public static final int MB_HOME = -1;//首页
    public static final int MB_GRIDS = -2;//网格案件
    public static final int MB_GUAZ = -3;//挂账案件
    public static final int MB_STATISTICS = -4;//案件统计
    //业务检查科界面
    public static final int MI_HOME = -5;//首页
    public static final int MI_GUAZ = -6;//挂账案件
    public static final int MI_ASSESS= -7;//考核情况
    public static final int MI_RANKING = -8;//排名情况
    //领导界面
    public static final int ML_HOME = -5;//首页
    public static final int ML_GUAZ = -6;//挂账案件
    public static final int ML_ASSESS= -7;//考核情况

    //主链接
//    public static final String SERVIECE_CLIENT = "http://192.168.2.25:8088/envir/f";
//    public static final String SERVIECE = "http://192.168.2.25:8088";
    public static final String SERVIECE_CLIENT = "http://www.reeching.com:8088/envir/f";
    public static final String SERVIECE = "http://www.reeching.com:8088";
    //登录
    public static final String LOGIN = SERVIECE_CLIENT+"/mobile/login";
    //获取公厕信息列表
    public static final String GETTOILETLIST=SERVIECE_CLIENT+"/mobile/getToiletList";
    //获取垃圾楼信息列表/查询
    public static final String GETRUBBISHLIST=SERVIECE_CLIENT+"/mobile/getRubbishList";
    //获取道路列表/查询
    public static final String GETSTREETLIST=SERVIECE_CLIENT+"/mobile/getStreetList";
    //获取人员
    public static final String GETUSERLIST=SERVIECE_CLIENT+"/mobile/getUserList";
    //获取所属街乡/社区
    public static final String GETAREAS=SERVIECE_CLIENT+"/mobile/getAreas";
    //获取基础数据的审核历史
    public static final String BASECHECKHISTORY=SERVIECE_CLIENT+"/mobile/baseCheckHistory";
    //待审核数据公厕列表
    public static final String WILLSUBMITTEDTOILET=SERVIECE_CLIENT+"/mobile/willSubmittedToilet";
    //保存公厕信息
    public static final String SAVETOILET=SERVIECE_CLIENT+"/mobile/saveToilet";
    //保存垃圾楼信息
    public static final String SAVERUBBISH=SERVIECE_CLIENT+"/mobile/saveRubbish";
    //保存道路信息
    public static final String SAVESTREET=SERVIECE_CLIENT+"/mobile/saveStreet";
    //待审核数据垃圾楼列表
    public static final String WILLSUBMITTEDRUBBISH=SERVIECE_CLIENT+"/mobile/willSubmittedRubbish";
    //待审核数据道路列表
    public static final String WILLSUBMITTEDSTREET=SERVIECE_CLIENT+"/mobile/willSubmittedStreet";
    //网格案件/挂账案件列表
    public static final String BILLCASELIST=SERVIECE_CLIENT+"/mobile/billCaseList";
    //添加案件回复
    public static final String ADDCASEREPLY=SERVIECE_CLIENT+"/mobile/addCaseReply";
    //案件回复历史
    public static final String CASEREPLYLIST=SERVIECE_CLIENT+"/mobile/caseReplyList";
    //验证公厕标号是否重复
    public static final String CHECKMARKNOTOILET=SERVIECE_CLIENT+"/mobile/checkMarkNoToilet";
    //验证公厕编号是否重复
    public static final String CHECKNUMBERTOILET=SERVIECE_CLIENT+"/mobile/checkNumberToilet";
    //验证垃圾楼标号是否重复
    public static final String CHECKMARKNORUBBISH=SERVIECE_CLIENT+"/mobile/checkMarkNoRubbish";
    //验证垃圾楼编号是否重复
    public static final String CHECKNUMBERRUBBISH=SERVIECE_CLIENT+"/mobile/checkNumberRubbish";
    //验证道路标号是否重复
    public static final String CHECKMARKNOSTREET=SERVIECE_CLIENT+"/mobile/checkMarkNoStreet";
    //案件详情页
    public static final String CASEDETAIL=SERVIECE_CLIENT+"/mobile/caseDetail";
    //案件流程列表
    public static final String CASEPROCESSLIST=SERVIECE_CLIENT+"/mobile/caseProcessList";
    //22.	案件改派
    public static final String GAIPAIUNITOPERATE=SERVIECE_CLIENT+"/mobile/gaipaiUnitOperate";
    //23.	案件非我辖区
    public static final String NOMEAREA=SERVIECE_CLIENT+"/mobile/nomeArea";
    //25.	案件非我权属
    public static final String NOMEBELONGUNIT=SERVIECE_CLIENT+"/mobile/nomeBelongUnit";
    //26.	案件挂账
    public static final String CASEBILLSELECTS=SERVIECE_CLIENT+"/mobile/caseBillSelects";
    //27.	案件撤销
    public static final String REVOKECASE=SERVIECE_CLIENT+"/mobile/revokeCase";
    //27.	案件删除
    public static final String DELSELECTS=SERVIECE_CLIENT+"/mobile/delSelects";
    //非我权属选择委办局接口
    public static final String FINDLISTNOMEBELONG=SERVIECE_CLIENT+"/mobile/findListNomeBelong";

    //下拉框
    public static final String GETSELECTLIST=SERVIECE_CLIENT+"/mobile/getSelectList";
    //轮播图
    public static final String GETINDEXPHOTOLIST=SERVIECE_CLIENT+"/mobile/getIndexPhotoList";

    //选择基础id
    public static final String FINDBASEID=SERVIECE_CLIENT+"/mobile/findBaseId";
    //选择委托公司
    public static final String FINDWORKCOMPANY=SERVIECE_CLIENT+"/mobile/findWorkCompany";
    //分管领导、所属场队、场队负责人、所属分队、分队负责人、分组、分组负责人
    public static final String TREEDATALEADER=SERVIECE_CLIENT+"/mobile/treeDataLeader";
    //删除公厕
    public static final String DELENVIRTOILETT=SERVIECE_CLIENT+"/mobile/delEnvirToiletT";
    //删除垃圾楼
    public static final String DELRUBBISHT=SERVIECE_CLIENT+"/mobile/delRubbishT";
    //删除道路
    public static final String DELSTREETT=SERVIECE_CLIENT+"/mobile/delStreetT";
    //道路详情
    public static final String STREETDETAIL=SERVIECE_CLIENT+"/mobile/streetDetail";
    //垃圾楼详情
    public static final String RUBBISHDETAIL=SERVIECE_CLIENT+"/mobile/rubbishDetail";
    //厕所详情
    public static final String TOILETDETAIL=SERVIECE_CLIENT+"/mobile/toiletDetail";
    //保存垃圾楼信息审核和流程
    public static final String SAVECHECKRUBBISH=SERVIECE_CLIENT+"/mobile/saveCheckRubbish";
    //保存道路信息审核和流程
    public static final String SAVECHECKSTREET=SERVIECE_CLIENT+"/mobile/saveCheckStreet";
    //保存公厕信息审核和流程
    public static final String SAVECHECKTOILET=SERVIECE_CLIENT+"/mobile/saveCheckToilet";





    //监督检查考核平台功能设计---基层单位功能（首页）
    public static final String CASECOUNTPAGE =SERVIECE_CLIENT+"/mobile/caseCountPage";
    //监督检查考核平台功能设计---基层单位功能（统计）
    public static final String BASEUNITCOUNTPAGE =SERVIECE_CLIENT+"/mobile/baseUnitCountPage";
    //监督检查考核平台功能设计---基层单位功能（上标）
    public static final String BASEUNITPAGECOUNT =SERVIECE_CLIENT+"/mobile/baseUnitPageCount";
    //监督检查考核平台功能设计---业务检查科（首页）
    public static final String BUSINESSCHECKPAGE =SERVIECE_CLIENT+"/mobile/businessCheckPage";
    //监督检查考核平台功能设计---业务检查科（排名情况）
    public static final String BUSINESSCHECKRANKING =SERVIECE_CLIENT+"/mobile/businessCheckRanking";
    //监督检查考核平台功能设计---领导页面（排名情况）
    public static final String LEADERCHECKPAGE =SERVIECE_CLIENT+"/mobile/leaderCheckPage";



}
