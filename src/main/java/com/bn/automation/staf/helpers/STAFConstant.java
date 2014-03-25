package com.bn.automation.staf.helpers;

import java.io.File;

public class STAFConstant {
	
	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String IE = "ie";
	public static final String HTML_UNIT = "htmlunit";
	public static final String SAFARI = "safari";
	public static final String BY_ID = "id";
	public static final String BY_NAME = "name";
	public static final String BY_XPATH = "xpath";
	public static final String BY_CLASS_NAME = "classname";
	public static final String BY_TAG_NAME = "tagname";
	
	public static final String NULL = "null";
	public static final String BROWSER_NAME_KEY = "browser_name";
	public static final String BROWSER_NAME_ARG = "browser";
	public static final String URL_KEY = "url";
	public static final String URL_ARG = "url";
	public static final String CONFIG_KEY = "config";
	public static final String CONFIG_ARG = "config";
	public static final String XML_DATA_KEY = "xmldata";
	public static final String XML_DATA_ARG = "xmldata";
	public static final String LOG_PATH_KEY = "log_path";
	public static final String LOG_PATH_ARG = "log_path";
	public static final String GRID_KEY = "grid";
	public static final String GRID_ARG = "grid";
	public static final String HUB_URL_KEY = "hub_url";
	public static final String HUB_URL_ARG = "hub_url";
	public static final String BROWSER_VERSION_KEY = "browser_version";
	public static final String BROWSER_VERSION_ARG = "b_version";
	public static final String PLATFORM_KEY = "platform";
	public static final String PLATFORM_ARG = "platform";
	public static final String MACHINE_NAME_KEY = "machine_name";
	public static final String MACHINE_NAME_ARG = "machine_name";
	public static final String SCREENSHOT_KEY = "screenshot";
	public static final String SCREENSHOT_ARG = "screenshot";
	
	public static final String NAME = "name";
	public static final String VALUE = "value";
	public static final String DEFAULT_BROWSER_NAME = "DEFAULT_BROWSER_NAME";
	public static final String DEFAULT_URL = "DEFAULT_URL";
	public static final String IE_DRIVER_PATH = "IE_DRIVER_PATH";
	public static final String IE_DRIVER_PATH_KEY = "iedriver";
	public static final String CHROME_DRIVER_PATH = "CHROME_DRIVER_PATH";
	public static final String CHROME_DRIVER_PATH_KEY = "chromedriver";
	public static final String KILL_BROWSER_AFTER_TEST = "KILL_BROWSER_AFTER_TEST";
	public static final String KILL_BROWSER_AFTER_TEST_KEY = "kill_browser_after_test";
	public static final String KILL_DRIVER_AFTER_TEST = "KILL_DRIVER_AFTER_TEST";
	public static final String KILL_DRIVER_AFTER_TEST_KEY = "kill_driver_after_test";
	public static final String GRID = "GRID";
	public static final String LOCAL = "LOCAL";
	
	public static final String DASH = "------------------------------------------------------------------------";
	
	public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";

    public static final String IS_SELECTED = "isSelected";
    public static final String IS_PRESENT = "isPresent";
    public static final String IS_ENABLED = "isEnabled";
    public static final String IS_DISPLAYED = "isDisplayed";
    public static final String GET_TEXT = "getText";
    public static final String COOKIE_NAME = "cookieName";
    public static final String COOKIE_DOMAIN = "cookieDomain";

    public static final String DATE_FORMAT = "MM-dd-yyyy_HH-mm-ss.S";
    //public static final String LOG_PATH_PREFIX = "STAFLog/XML/STAFLog_";
    public static final String LOG_PATH_PREFIX = "STAFLog"+ File.separator+"XML"+ File.separator+"STAFLog_";
    public static final String LOG4J2_FILE_NAME = "xml_log";
    public static final String START_TIME = "start_time";
    public static final String XML_LOG = "xml_log_name";
    public static final String LOG_PREFIX = "STAFLog_";
    public static final String USER_DIR = "user.dir";
    public static final String ALL_XML_LOCATION = "all_xml_location";
    public static final String XML_LOG_PATH = "xml_log_path";
    //public static final String XML_LOG_REF = "\\STAFLog\\XML\\";
    public static final String XML_LOG_REF = File.separator+"STAFLog"+ File.separator+"XML"+ File.separator;
    //public static final String HTML_LOG_REF = "\\STAFLog\\HTML\\";
    public static final String HTML_LOG_REF = File.separator+"STAFLog"+ File.separator+"HTML"+ File.separator;


	

}
