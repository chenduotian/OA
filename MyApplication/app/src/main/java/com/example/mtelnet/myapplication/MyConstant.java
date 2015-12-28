package com.example.mtelnet.myapplication;

import android.util.DisplayMetrics;

/**
 * Created by sundy on 15/7/30.
 */
public class MyConstant {

    public static final String APP_NAME = "HKJC";
    public static final String IS_FIRST_LUNCH = "IS_FIRST_LUNCH";
    public static final String IS_FIRST_INIT_DB = "IS_FIRST_INIT_DB";
    public static final String IS_FIRST_OPEN_CALENDAR = "IS_FIRST_OPEN_CALENDAR";
    public static final String IS_NOTIFICATION = "IS_NOTIFICATION";
    public static int SCREEN_WIDTH = 720;
    public static int SCREEN_HEIGHT = 1080;
    public static float SCREEN_DENSITY = DisplayMetrics.DENSITY_HIGH;

    //private static final String HTTP_UAT = "http://devsvr6.mtel.ws/hkjc_badge/";
    private static final String DEV = "http://devsvr6.mtel.ws/hkjc_badge/";
    private static final String PROD = "http://hkjcbadge.mtelnet.com/";
    public static final String HTTP_BASE = PROD;
    public static final String HTTP_NOTIFY_BASE = "https://notifyapp.co/";
    public static final String HTTP_NOTIFY_TYPE = "gcm";
    public static final String HTTP_NOTIFY_Domain = "hkjc_badges_prod";
    //UAT: "hkjc_badges_uat"
    //PROD: "hkjc_badges_prod";

    public static final boolean IsDebug = false;

    public static final String LANG_EN = "en";
    public static final String LANG_HK = "zh-Hant";
    public static String Language = LANG_EN;
    public static final String CURRENT_LANGUAGE = "CURRENT_LANGUAGE";

    public final static String DEVICE = "android";
    public static String PUSH_TOKEN = "";
    public final static String PUSH_KEY = "MSG";

    public final static String IS_LOGIN = "IS_LOGIN";
    public final static String IS_REMEMBER = "IS_REMEMBER";
    public final static String MENU_SELECTION = "MENU_SELECTION";
    public final static String SUB_MENU_SELECTION = "SUB_MENU_SELECTION";

    public static boolean IS_NET_CONNECT = false;
    public final static String MEMBER_ID = "MEMBER_ID";
    public static boolean IS_MEMBERSHIP_CLICK = false;
    public static boolean IS_LOG_COVERSTORY = true;
//    public static boolean IS_CLICK_Categories = false;
    public static boolean is_AdobeLog = true;
    public static boolean IS_LOGIN_Log = true;
    public static String Tutorial_to_fragment = "";
    public static boolean IS_TABLET = false;
    public static boolean SHOW_CONTENT = false;

    //incomplete URL handling
    public static final String HTTP_MEMBER = "http://member.hkjc.com";
    public static final String HTTP_HOME = "http://www.hkjc.com";
    public static final String HTTP_ENTERTAINMENT = "http://entertainment.hkjc.com";
    public static final String HTTP_RACING = "http://racing.hkjc.com";
    public static final String HTTP_FOOTBALL = "http://football.hkjc.com";
    public static final String HTTP_CHARITIES = "http://charities.hkjc.com";
    public static final String HTTP_CORPORATE = "http://corporate.hkjc.com";
    public static final String HTTP_UTILITY = "http://common.hkjc.com";
    public static final String HTTP_SEARCH = "http://search.hkjc.com";

}
