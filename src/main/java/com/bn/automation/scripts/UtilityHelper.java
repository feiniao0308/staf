package com.bn.automation.scripts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.UUID;
//import com.bn.test.smoke.screenobjects.CheckoutScreen.CheckoutScreenWidget;


public class UtilityHelper {

	private WebDriver driver;

	

	public WebDriver openFirefoxBrowser() {

		driver = new FirefoxDriver();
		return driver;
	}

	public WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\fdkzv\\Documents\\DEV\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebDriver openInternetExplorerBrowser() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\fdkzv\\Documents\\DEV\\ie32\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		return driver;
	}

	public WebDriver openHTMLUnitBrowser() {

		driver = new HtmlUnitDriver();
		return driver;
	}

	public void loadURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public void selectDropDownValue(WebDriver driver, By listElement,
			String selectElement, By itemElement) {
		driver.findElement(listElement).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String jsCmd = "document.getElementById('" + selectElement
				+ "').click();";
		executor.executeScript(jsCmd);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(itemElement))
				.sendKeys(Keys.RETURN).perform();
	}
	public void selectDropDownValueByClass(WebDriver driver, By listElement,
			String selectElement, By itemElement, int index) {
		driver.findElement(listElement).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String jsCmd = "document.getElementsByName('" + selectElement
				+ "')['"+ index + "'].click();";
		executor.executeScript(jsCmd);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(itemElement))
				.sendKeys(Keys.RETURN).perform();
	}
		
	
	public void selectDropDownValueByClassName(WebDriver driver, By listElement,
			String selectElement, By itemElement, int index) {
		driver.findElement(listElement).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String jsCmd = "document.getElementsByClassName('" + selectElement
				+ "')['"+ index + "'].click();";
		executor.executeScript(jsCmd);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(itemElement))
				.sendKeys(Keys.RETURN).perform();
	}
	

	public void selectDropDownValueByTagName(WebDriver driver, By listElement,
			String selectElement, By itemElement) {
		int index = 0;
		driver.findElement(listElement).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String jsCmd = "document.getElementsByTagName('" + selectElement
				+ "')['"+ index + "'].click();";
		executor.executeScript(jsCmd);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(itemElement))
				.sendKeys(Keys.RETURN).perform();
	}
	
	
	/*public void createNewAcntMyAccount(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable{
		
		RegistrationScreenWidget.myAcntLink.click();
		Thread.sleep(3000);
		
		driver.findElement(RegistrationScreenWidget.mngAcntsLink).click();
		Thread.sleep(3000);
		
		driver.findElement(RegistrationScreenWidget.createNewAcntButton).click();
		Thread.sleep(5000);
				
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
		
		Thread.sleep(3000);
		
		String email = randomEmail();
		System.out.println(email);
		
	    RegistrationScreenWidget.bnemail.populate(email);
	    RegistrationScreenWidget.confirmEmail.populate(email);
	    
	    
	    selectDropDownValue(driver.getWd(),RegistrationScreenWidget.securityQandA, "securityQuestion", RegistrationScreenWidget.securityCityQ);
	   
	   	driver.findElement(RegistrationScreenWidget.createAccnt).click();
		Thread.sleep(3000);
	}

	public void doLogin(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
		
		RegistrationScreenWidget.myAcntLink.click();
		Thread.sleep(3000);

		driver.findElement(RegistrationScreenWidget.mngAcntsLink).click();
		Thread.sleep(3000);
		
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
		//driver.autopopulate(datacontianerName, registrationScreen);

		driver.findElement(RegistrationScreenWidget.secureSignInBtn).click();
		Thread.sleep(3000);
			
	}
	
	
	
	public void goToMemberShip(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable{
		signIn(driver, datacontianerName, registrationScreen);
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		MyAccountScreenWidget.mngYourMembershipLnkSignIn.click();
		Thread.sleep(3000);
	}
	
	public void goToManageTxtRental(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable{
		signIn(driver, datacontianerName, registrationScreen);
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		MyAccountScreenWidget.mngTxtBookRentalsLnk.click();
		Thread.sleep(3000);
	}
	
	public void addDefaultadd(STAFDriver driver, String datacontianerName1, String datacontianerName2, Object registrationScreen, Object myAccountScreen) throws Throwable{
		driver.findElement(HomeScreenWidget.SingInLink).click();
		Thread.sleep(3000);
		doSignIn(driver, "loginDetails", registrationScreen);
		Thread.sleep(3000);
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		MyAccountScreenWidget.addNewAddressLnkSignIn.click();
		Thread.sleep(3000);
		//driver.findElement(MyAccountScreenWidget.AddNewAddressButton).click();
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName2), myAccountScreen);
		//driver.autopopulate("shippingAddress", myAccountScreen);
		selectDropDownValue(driver.getWd(), MyAccountScreenWidget.selectStatedrpdwn, "state", MyAccountScreenWidget.IL);
		
		
	}
	
	public void addNewaddr(STAFDriver driver, String datacontianerName, Object myAccountScreen) throws Throwable{
			
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		MyAccountScreenWidget.addNewAddressLnkSignIn.click();
		Thread.sleep(3000);
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), myAccountScreen);
		//driver.autopopulate(datacontianerName, myAccountScreen);
		selectDropDownValue(driver.getWd(), MyAccountScreenWidget.selectStatedrpdwn, "state", MyAccountScreenWidget.IL);
		
		
	}
	
	
	public void addDefaultPymnt(STAFDriver driver, String datacontianerName1, String datacontianerName2, String datacontianerName3, Object registrationScreen, Object myAccountScreen, Object addPaymentScreen) throws Throwable{
		driver.findElement(HomeScreenWidget.SingInLink).click();
		
		signIn(driver, "loginDetails", registrationScreen);
		Thread.sleep(3000);
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		MyAccountScreenWidget.addnewPymntMtdLnk.click();
		Thread.sleep(3000);
		//driver.findElement(MyAccountScreenWidget.addNewShippingAdd).click();
		driver.autoPopulate(driver.getData().getDataContainer("creditCard"), addPaymentScreen);
		//driver.autopopulate("creditCard", addPaymentScreen);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expMonth, "cardExpDate", AddPaymentScreenWidget.february);
		Thread.sleep(4000L);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expYr, "cardExpYear", AddPaymentScreenWidget.y2016);
		//util.populateShippingAddress(driver, "shippingAddress", myAccountScreen);
		driver.autoPopulate(driver.getData().getDataContainer("billingAddress"), myAccountScreen);
		//driver.autopopulate("billingAddress", myAccountScreen);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.state, "state", AddPaymentScreenWidget.IL);
		
		
	}
	public void addDefaultPymnt(STAFDriver driver, String datacontianerName1, String datacontianerName2, Object addPaymentScreen, Object registrationScreen) throws Throwable{
		signIn(driver, "loginDetails", registrationScreen);
		Thread.sleep(3000);				
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		MyAccountScreenWidget.addnewPymntMtdLnk.click();
		Thread.sleep(3000);
		//driver.findElement(MyAccountScreenWidget.addNewShippingAdd).click();
		driver.autoPopulate(driver.getData().getDataContainer("creditCard"), addPaymentScreen);
		//driver.autopopulate("creditCard", addPaymentScreen);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expMonth, "cardExpDate", AddPaymentScreenWidget.february);
		Thread.sleep(2000);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expYr, "cardExpYear", AddPaymentScreenWidget.y2016);
		//util.populateShippingAddress(driver, "shippingAddress", myAccountScreen);
			
	}
	
	
	
	public void rmvDefaltPymnt(STAFDriver driver) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		MyAccountScreenWidget.mngDefaultPymntLnk.click();
		Thread.sleep(3000);
		AddPaymentScreenWidget.deletePymntmtd.click();
		Thread.sleep(3000);
		driver.findElement(AddPaymentScreenWidget.removePymntBtn).click();
	}
	
	public void addNewPymnt(STAFDriver driver,String datacontianerName, Object addPaymentScreen ) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		MyAccountScreenWidget.addnewPymntMtdLnk.click();
		Thread.sleep(3000);
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), addPaymentScreen);
		//driver.autopopulate(datacontianerName, addPaymentScreen);
		Thread.sleep(3000L);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expMonth, "cardExpDate", AddPaymentScreenWidget.february);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expYr, "cardExpYear", AddPaymentScreenWidget.y2016);
		Thread.sleep(3000L);
		CheckoutScreenWidget.selectSavedBillAdd.click();
		driver.findElement(CheckoutScreenWidget.selectBillAddRadio).click();
		driver.findElement(AddPaymentScreenWidget.savePymnt).click();
		Thread.sleep(3000);
	}
	
	public void addNewPymntAndBillInfo(STAFDriver driver,String datacontianerName1, String datacontianerName2, Object addPaymentScreen, Object checkoutScreen) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		MyAccountScreenWidget.addnewPymntMtdLnk.click();
		Thread.sleep(3000);
		
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName1), addPaymentScreen);
		//driver.autopopulate(datacontianerName1, addPaymentScreen);
		Thread.sleep(3000L);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expMonth, "cardExpDate", AddPaymentScreenWidget.february);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expYr, "cardExpYear", AddPaymentScreenWidget.y2016);
		Thread.sleep(3000L);
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName2), checkoutScreen);
		//driver.autopopulate(datacontianerName2, checkoutScreen);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.state, "state", AddPaymentScreenWidget.IL);
		driver.findElement(AddPaymentScreenWidget.savePymnt).click();
		Thread.sleep(3000);
		
	}
	
	public void addPymntAndBillInfo(STAFDriver driver,String datacontianerName1, String datacontianerName2, Object addPaymentScreen, Object checkoutScreen) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		MyAccountScreenWidget.mngPymntOptionsLnk.click();
		Thread.sleep(3000);
		driver.findElement(MyAccountScreenWidget.addNewPymntMtdBtn).click();
		Thread.sleep(4000);
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName1), addPaymentScreen);
		//driver.autopopulate(datacontianerName1, addPaymentScreen);
		Thread.sleep(3000L);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expMonth, "cardExpDate", AddPaymentScreenWidget.february);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.expYr, "cardExpYear", AddPaymentScreenWidget.y2016);
		Thread.sleep(3000L);
		
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName2), checkoutScreen);
		//driver.autopopulate(datacontianerName2, checkoutScreen);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.state, "state", AddPaymentScreenWidget.IL);
		driver.findElement(AddPaymentScreenWidget.savePymnt).click();
		Thread.sleep(3000);
		
	}
	
	public void addBillAddr(STAFDriver driver, String datacontianerName, Object myAccountScreen ) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		MyAccountScreenWidget.mngDefaultPymntLnk.click();
		Thread.sleep(3000);
		AddPaymentScreenWidget.editPymntmtd.click();
		Thread.sleep(3000);
		MyAccountScreenWidget.editShipAddPhone.clear();
		MyAccountScreenWidget.companyName.clear();
		MyAccountScreenWidget.streetAddress.clear();
		MyAccountScreenWidget.aptSuite.clear();
		MyAccountScreenWidget.city.clear();
		MyAccountScreenWidget.zipCode.clear();
		
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), myAccountScreen);
		//driver.autopopulate(datacontianerName, myAccountScreen);
		selectDropDownValue(driver.getWd(), AddPaymentScreenWidget.state, "state", AddPaymentScreenWidget.IL);
	}
	
	
	
	public void rmvDefaltBillAdd(STAFDriver driver) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		MyAccountScreenWidget.mngDefaultPymntLnk.click();
		Thread.sleep(3000);
		AddPaymentScreenWidget.rmvBillAdd.click();
		Thread.sleep(3000);
		driver.findElement(AddPaymentScreenWidget.removePymntBtn).click();
	}
	
	public void rmvDefaltAdd(STAFDriver driver) throws Throwable{
		driver.findElement(HomeScreenWidget.MyAccountLink).click();
		Thread.sleep(3000);
		//MyAccountScreenWidget.mngAddressBookLnk.click();
		MyAccountScreenWidget.mngDefaultAddressLnk.click();
		Thread.sleep(3000);
		driver.findElement(MyAccountScreenWidget.deleteBtn).click();
		Thread.sleep(3000);
		driver.findElement(MyAccountScreenWidget.removeBtn).click();
	}
	
	public void doSignIn(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable{
		
		driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
		//driver.autopopulate(datacontianerName, registrationScreen);
		driver.findElement(RegistrationScreenWidget.secureSignInBtn).click();
		Thread.sleep(3000);
	}
	
public String signInRemember(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
		
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(5000);
		
	driver.findElement(RegistrationScreenWidget.createNewAcntButton).click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
	
	Thread.sleep(3000);
	
	String email = randomEmail();
	System.out.println(email);
	
    RegistrationScreenWidget.bnemail.populate(email);
    RegistrationScreenWidget.confirmEmail.populate(email);
    
    
    selectDropDownValue(driver.getWd(),RegistrationScreenWidget.securityQandA, "securityQuestion", RegistrationScreenWidget.securityCityQ);
   
   	driver.findElement(RegistrationScreenWidget.createAccnt).click();
	Thread.sleep(3000);
	RegistrationScreenWidget.signOut.click();
	Thread.sleep(3000);
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
	RegistrationScreenWidget.email.populate(email);
	RegistrationScreenWidget.pswd.populate("test123");
			     
		if(!driver.findElement(RegistrationScreenWidget.rememberChkBox).isSelected()){
		driver.findElement(RegistrationScreenWidget.rememberChkBox).click();
		}
		
		driver.findElement(RegistrationScreenWidget.secureSignInBtn).click();
		Thread.sleep(3000);
		return email;
	
	}

public String signInMngAcnt(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	
	RegistrationScreenWidget.myAcntLink.click();
	Thread.sleep(3000);
	
	driver.findElement(RegistrationScreenWidget.mngAcntsLink).click();
	Thread.sleep(3000);
	
	driver.findElement(RegistrationScreenWidget.createNewAcntButton).click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
	//driver.autopopulate(datacontianerName, registrationScreen);
	Thread.sleep(3000);
	
	String email = randomEmail();
	System.out.println(email);
	
    RegistrationScreenWidget.bnemail.populate(email);
    RegistrationScreenWidget.confirmEmail.populate(email);
    
    
    selectDropDownValue(driver.getWd(),RegistrationScreenWidget.securityQandA, "securityQuestion", RegistrationScreenWidget.securityCityQ);
   
   	driver.findElement(RegistrationScreenWidget.createAccnt).click();
	Thread.sleep(3000);
	RegistrationScreenWidget.signOut.click();
	Thread.sleep(3000);
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
	RegistrationScreenWidget.email.populate(email);
	RegistrationScreenWidget.pswd.populate("test123");
			     
		if(!driver.findElement(RegistrationScreenWidget.rememberChkBox).isSelected()){
		driver.findElement(RegistrationScreenWidget.rememberChkBox).click();
		}
		
		driver.findElement(RegistrationScreenWidget.secureSignInBtn).click();
		Thread.sleep(3000);
		return email;
	
	}

	public String signInNoRememberMe(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
		
	driver.findElement(RegistrationScreenWidget.createNewAcntButton).click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
	//driver.autopopulate(datacontianerName, registrationScreen);
	Thread.sleep(3000);
	
	String email = randomEmail();
	System.out.println(email);
	
    RegistrationScreenWidget.bnemail.populate(email);
    RegistrationScreenWidget.confirmEmail.populate(email);
    
    
    selectDropDownValue(driver.getWd(),RegistrationScreenWidget.securityQandA, "securityQuestion", RegistrationScreenWidget.securityCityQ);
   
   	driver.findElement(RegistrationScreenWidget.createAccnt).click();
	Thread.sleep(3000);
	RegistrationScreenWidget.signOut.click();
	Thread.sleep(3000);
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
	RegistrationScreenWidget.email.populate(email);
	RegistrationScreenWidget.pswd.populate("test123");
			     
		if(driver.findElement(RegistrationScreenWidget.rememberChkBox).isSelected()){
		driver.findElement(RegistrationScreenWidget.rememberChkBox).click();
		}
		
		driver.findElement(RegistrationScreenWidget.secureSignInBtn).click();
		Thread.sleep(3000);
		return email;
	
	}
public void signIn(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
		
	//driver.autopopulate(datacontianerName, registrationScreen);
		
	driver.findElement(RegistrationScreenWidget.secureSignInBtn).click();
	Thread.sleep(3000);
	}

public void chngPswd(STAFDriver driver, String datacontainerName, Object accountSettingsScreen) throws Throwable{
	//driver.autopopulate(datacontainerName, accountSettingsScreen);
	driver.autoPopulate(driver.getData().getDataContainer(datacontainerName), accountSettingsScreen);
	driver.findElement(AccountSettingsScreenWidget.chngPswdSaveBtn).click();
	Thread.sleep(3000);
	driver.findElement(AccountSettingsScreenWidget.continueSoppingBtn).click();
}

public void chngEmail(STAFDriver driver, String datacontainerName, Object accountSettingsScreen) throws Throwable{
	AccountSettingsScreenWidget.confNewEmail.clear();
	AccountSettingsScreenWidget.confNewPswd.clear();
	driver.autoPopulate(driver.getData().getDataContainer(datacontainerName), accountSettingsScreen);
	//driver.autopopulate(datacontainerName, accountSettingsScreen);
	AccountSettingsScreenWidget.saveChngsNewEmail.click();
	Thread.sleep(3000);
	*//*driver.findElement(AccountSettingsScreenWidget.continueSoppingBtn).click();
	Thread.sleep(3000);*//*
}

public void goToMngPaymentSignIn(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	MyAccountScreenWidget.mngPymntOptionsLnk.click();
	Thread.sleep(3000);
	doSignIn(driver, datacontianerName, registrationScreen);
	Thread.sleep(3000);
}

public void createNewAccount(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
	driver.findElement(RegistrationScreenWidget.createNewAcntButton).click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
	//driver.autopopulate(datacontianerName, registrationScreen);
	Thread.sleep(3000);
	String email = randomEmail();
	System.out.println(email);
	
    RegistrationScreenWidget.bnemail.populate(email);
    RegistrationScreenWidget.confirmEmail.populate(email);
    
    selectDropDownValue(driver.getWd(),RegistrationScreenWidget.securityQandA, "securityQuestion", RegistrationScreenWidget.securityCityQ);
   
   	driver.findElement(RegistrationScreenWidget.createAccnt).click();
	Thread.sleep(4000);
	
}

public void goToOrderDetails(STAFDriver driver, String datacontianerName, Object orderdetailsScreen) throws Throwable {
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), orderdetailsScreen);
	//driver.autopopulate(datacontianerName, orderdetailsScreen);
	OrderdetailsScreenWidget.trackOrderbtn.click();
	Thread.sleep(3000);
}

public void goToOrderDetailsSignIn(STAFDriver driver, String datacontianerName1, String datacontianerName2, Object orderdetailsScreen,  Object registrationScreen) throws Throwable {
	
	signIn(driver, datacontianerName1, registrationScreen);
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName2), orderdetailsScreen);
	//driver.autopopulate(datacontianerName2, orderdetailsScreen);
	Thread.sleep(3000);
	OrderdetailsScreenWidget.trackOrderbtn.click();
	Thread.sleep(3000);
}

public void goToAccountSettings(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	MyAccountScreenWidget.mngAcntSettingsLnk.click();
	Thread.sleep(3000);
	doSignIn(driver, datacontianerName, registrationScreen);
	Thread.sleep(3000);
}

public void goToMngPayment(STAFDriver driver) throws Throwable {
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	MyAccountScreenWidget.mngPymntOptionsLnk.click();
	Thread.sleep(3000);
	}

public void goToMngAddresstSignIn(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable {
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	MyAccountScreenWidget.ManageAddressBook.click();
	Thread.sleep(1000);
	doSignIn(driver, datacontianerName, registrationScreen);
}

public void goToMngAddress(STAFDriver driver) throws Throwable {
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	MyAccountScreenWidget.ManageAddressBook.click();
}
	
public void goToFrgtPswd(STAFDriver driver) throws Throwable{
	RegistrationScreenWidget.signIn.click();
	Thread.sleep(3000);
	driver.findElement(RegistrationScreenWidget.forgotPswdLnk).click();
	Thread.sleep(3000);
}

public void goToEmailPref(STAFDriver driver,String datacontianerName, Object registrationScreen) throws Throwable{
	driver.findElement(HomeScreenWidget.MyAccountLink).click();
	Thread.sleep(3000);
	MyAccountScreenWidget.eMailPreferences.click();
	Thread.sleep(3000);
	doSignIn(driver, datacontianerName, registrationScreen);
}


public void resetEmailPref(STAFDriver driver) throws Throwable{
	
	driver.findElement(EmailPrefScreenWidget.yesRadioBtn).click();
	Thread.sleep(3000);
	driver.findElement(EmailPrefScreenWidget.postMailchkbox).click();
	driver.findElement(EmailPrefScreenWidget.telePhonechkbox).click();
	Thread.sleep(3000);
	driver.findElement(EmailPrefScreenWidget.noPrefRadio).click();
	
	driver.findElement(EmailPrefScreenWidget.saveBtn).click();
	Thread.sleep(3000);
}

public void populateShippingAddress(STAFDriver driver, String datacontianerName, Object checkoutScreen)throws Throwable{
	//CheckoutScreen checkoutScreen = new CheckoutScreen();
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), checkoutScreen);
	//driver.autopopulate(datacontianerName, checkoutScreen);
	selectDropDownValue(driver.getWd(), com.bn.test.core.screenobjects.CheckoutScreen.CheckoutScreenWidget.state, "state", com.bn.test.core.screenobjects.CheckoutScreen.CheckoutScreenWidget.IL);
			
	Thread.sleep(3000L);

	driver.findElement(com.bn.test.core.screenobjects.CheckoutScreen.CheckoutScreenWidget.continueButton).click();
	Thread.sleep(8000L);
}

public void searchAndSubmitGuest(STAFDriver driver, String datacontianerName, Object homePageScreen ) throws Throwable{
	//HomePageScreen homePageScreen = new HomePageScreen();

	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), homePageScreen);
	//driver.autopopulate(datacontianerName, homePageScreen);

	driver.findElement(HomeScreenWidget.searchSubmit).click();

	Thread.sleep(3000L);
}

public void editAddress(STAFDriver driver, String datacontianerName, String datacontianerName1,  Object registrationScreen, Object myAccountScreen ) throws Throwable{
	
	goToMngAddresstSignIn(driver, datacontianerName, registrationScreen);
	Thread.sleep(3000L);
	MyAccountScreenWidget.MngAddEdit.click();
	Thread.sleep(5000L);
	//MyAccountScreenWidget.editShipAddHeaderTxt.isDisplayed();
	//driver.autoVerify("shippingAddress", myAccountScreen);
	MyAccountScreenWidget.editShipAddPhone.clear();
	MyAccountScreenWidget.companyName.clear();
	MyAccountScreenWidget.aptSuite.clear();
	MyAccountScreenWidget.streetAddress.clear();
	MyAccountScreenWidget.zipCode.clear();
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName1), myAccountScreen);	
	//driver.autopopulate(datacontianerName1, myAccountScreen);
	Thread.sleep(3000L); 
	
}

public void editAddress(STAFDriver driver, String datacontianerName, Object myAccountScreen) throws Throwable{
	goToMngAddress(driver);
	MyAccountScreenWidget.MngAddEdit.click();
	Thread.sleep(5000L);
	MyAccountScreenWidget.editShipAddPhone.clear();
	MyAccountScreenWidget.companyName.clear();
	MyAccountScreenWidget.aptSuite.clear();
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), myAccountScreen);
	//driver.autopopulate(datacontianerName, myAccountScreen);
	Thread.sleep(3000L);
	driver.findElement(MyAccountScreenWidget.saveAddBtn).click();
	Thread.sleep(3000L);
}

public void editPymnt(STAFDriver driver, String datacontianerName, Object registrationScreen) throws Throwable{
	
	goToMngPaymentSignIn(driver, datacontianerName, registrationScreen);
	AddPaymentScreenWidget.editPymntmtd.click();
	 
	
}

public void populate(STAFDriver driver, String datacontianerName, String datacontianerName1, Object myAccountScreen ) throws Throwable{
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), myAccountScreen);
	//driver.autopopulate(datacontianerName, myAccountScreen);
	Thread.sleep(2000L);
 	driver.findElement(MyAccountScreenWidget.editSave).click();
 	Thread.sleep(5000L);
 	driver.autoVerify(driver.getData().getDataContainer(datacontianerName1), myAccountScreen);
	
}

public void populateFormInput(STAFDriver driver, String datacontianerName, String datacontianerName1, Object registrationScreen ) throws Throwable{
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), registrationScreen);
	//driver.autopopulate(datacontianerName, registrationScreen);
	Thread.sleep(2000L);
	driver.findElement(RegistrationScreenWidget.createAccnt).click();
 	Thread.sleep(5000L);
 	driver.autoVerify(driver.getData().getDataContainer(datacontianerName1), registrationScreen);
	
}


public void verifyAddPymntField(STAFDriver driver, String datacontianerName, String datacontianerName1, Object addPaymentScreen ) throws Throwable{
	
	driver.autoPopulate(driver.getData().getDataContainer(datacontianerName), addPaymentScreen);
	//driver.autopopulate(datacontianerName, addPaymentScreen);
 	
 	driver.findElement(AddPaymentScreenWidget.saveBtn).click();
 	Thread.sleep(3000L);
 	driver.autoVerify(driver.getData().getDataContainer(datacontianerName1), addPaymentScreen);
	
}


	
	public void checkLinks(WebDriver iDriver, By element) throws Throwable{
		
		
		
		WebElement element1 = driver.findElement(element);
		SearchPageFor searchPageFor = new SearchPageFor();
		List<WebElement> links = element1.findElements(By.tagName("a"));
		for (WebElement link : links) {
			System.out.println("text : " + link.getText());
			System.out.println("href : " + link.getAttribute("href"));
			String LinkText = link.getText();
			
			link.click();
			boolean isLinkVerificationPass = false;

			if (!isLinkVerificationPass) {
				if (!searchPageFor.isPageTitleHas(iDriver.getPageSource(), LinkText)) {
					System.out.println("false");
				} else {
					System.out.println("true");
					isLinkVerificationPass = true;
				}
		
			}
			
		iDriver.navigate().back();
		Thread.sleep(3000);
		}
	}*/
		
		public void checkLinks1(WebDriver iDriver, WebElement element) throws Throwable{		
		List<WebElement> allLinks = element.findElements(By.tagName("a"));
				for(int z=1; z<=allLinks.size();z++)
				{
				String navurl=iDriver.getCurrentUrl();
				allLinks.get(z).click();
				Thread.sleep(3000L);
				//checking something
				iDriver.navigate().to(navurl);
				Thread.sleep(3000L);
				}
		}
		/*	boolean isLinkVerificationPass = false;

			if (!isLinkVerificationPass) {
				if (!searchPageFor.isPageTitleHas(driver.getPageSource(), LinkText)) {
					System.out.println("false");
				} else {
					System.out.println("true");
					isLinkVerificationPass = true;
				}
		
			}*/
			
			//driver.quit();
		
	public void getLinkText(WebDriver driver, By element) throws Throwable{
		
		WebElement element1 = driver.findElement(element);
		List<WebElement> allLinks = element1.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for(int i=0; i<=allLinks.size();i++)
		{
			String linkText = allLinks.get(i).getText();
			System.out.println(linkText);
			String linkHref = allLinks.get(i).getAttribute("href");
			System.out.println(linkHref);
			allLinks.get(i).click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			
			driver.navigate().back();
			Thread.sleep(3000);
			
			
					
		}
		
		
			
		
	}
	
		
	
		
	public void deleteSavedAddress(){
		
	}
	
	
	public String randomString(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		return output;
	}
	
	public String randomPswd(){
		String pswd = "test" + UUID.randomUUID().toString().substring(10);
		return pswd;
	}

	public String randomEmail() {
		String email = "test" + UUID.randomUUID().toString().substring(24)
				+ "@bn.com";
		return email;
	}

	/*public void checkAllSubLinks(WebDriver iDriver, WebElement element)
			throws InterruptedException {

		SearchPageFor searchPageFor = new SearchPageFor();
		List<WebElement> links = element.findElements(By.tagName("a"));
		for (WebElement link : links) {
			System.out.println("text : " + link.getText());
			System.out.println("href : " + link.getAttribute("href"));
			String footerLinkText = link.getText();
			String footerLinkUrl = link.getAttribute("href");
			WebDriver driver = new FirefoxDriver();
			driver.get(footerLinkUrl);
			Thread.sleep(1000L);
			boolean isLinkVerificationPass = false;

			if (!isLinkVerificationPass) {
				if (!searchPageFor.isPageTitleEquals(driver.getTitle(),
						footerLinkText)) {
				} else {
					isLinkVerificationPass = true;
				}
			}

			if (!isLinkVerificationPass) {
				if (!searchPageFor.isPageTitleHas(driver.getTitle(),
						footerLinkText)) {

				} else {
					isLinkVerificationPass = true;
				}
			}

			if (!isLinkVerificationPass) {
				if (!searchPageFor.isPageSourceContains(driver, footerLinkText)) {

				} else {
					isLinkVerificationPass = true;
				}
			}

			driver.quit();

		}

	}*/
	
	public boolean isPresent(WebDriver driver, By element) {
		boolean isPresent = true;

		try {
		driver.findElement(element);
		} catch (Exception e) {

		isPresent = false;
		}
		return isPresent;

		}

}
