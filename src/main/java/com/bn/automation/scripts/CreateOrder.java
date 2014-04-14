package com.bn.automation.scripts;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.STAFScript;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.core.STAFDriver;
import com.bn.automation.staf.widget.Button;
import com.bn.automation.staf.widget.TextBox;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by fdkzv on 4/3/14.
 */
@STAFScript
public class CreateOrder {
	
	EomScreen eomScreen = new EomScreen();
	UtilityHelper util = new UtilityHelper();
	
    public STAFDriver driver;
    
    @BeforeMethod
        public void setup() {
        driver = new STAFDriver();
        driver.get("http://dwecdom01.hq.bn-corp.com:30000/ ");
       // driver.get("http://Administrator:manage@dwecmif01.hq.bn-corp.com:5555");
        
        

    }

    @AfterMethod
    public void tearDown() {


    }

    @Test(id = {4}, enabled = true)
    public void keywordDrivenTest() throws Throwable {
    	
    	driver.setData("data/CreateOrder.xml");
        driver.getWd().manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        new TextBox("id=textfield-1019-inputEl").populate("manh");
        new TextBox("id=textfield-1020-inputEl").populate("password");
        Thread.sleep(500);
        //new Button("id=button-1021-btnEl").click();
        new Button("id=button-1022").click();
        
        Thread.sleep(5000);
        System.out.println("driver.getTitle() = " + driver.getTitle());
       /* new Actions(driver.getWd()).doubleClick(driver.findElement(By.id("tile-1117"))).perform();
        Thread.sleep(3000);*/
        
        EomScreen.EomScreenWidget.createOrderIcon.click();
        Thread.sleep(3000);
        driver.autoPopulate(driver.getData().getDataContainer("searchScreen"), eomScreen);
        EomScreen.EomScreenWidget.searchField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        
        driver.switchTo().frame(0);
        Thread.sleep(3000);
            
        driver.autoPopulate(driver.getData().getDataContainer("nameInfo"), eomScreen);
        Thread.sleep(1000);
        driver.autoPopulate(driver.getData().getDataContainer("searchInput"), eomScreen);
        
        EomScreen.EomScreenWidget.searchItemField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        EomScreen.EomScreenWidget.searchBtn.click();
        Thread.sleep(3000);
        EomScreen.EomScreenWidget.addToOrderProceed.click();
        Thread.sleep(3000);
        EomScreen.EomScreenWidget.nextBtn.click();
        Thread.sleep(3000);
        EomScreen.EomScreenWidget.nextBtnPromo.click();



        Thread.sleep(25000);
        EomScreen.EomScreenWidget.addShipAddrBtn.click();
        Thread.sleep(5000);

        driver.autoPopulate(driver.getData().getDataContainer("shipAddress"), eomScreen);
        Thread.sleep(3000);
        Select state = new Select(driver.findElement(EomScreen.EomScreenWidget.stateDrpdown));
        state.selectByValue("GA");

        EomScreen.EomScreenWidget.saveBtnShipAddr.click();
        Thread.sleep(30000L);

        EomScreen.EomScreenWidget.saveAddrAsIs.click();
        Thread.sleep(10000);

        EomScreen.EomScreenWidget.nextBtnShipAddr.click();
        Thread.sleep(20000);

        EomScreen.EomScreenWidget.sameAsShipAddrChkBox.click();
        Thread.sleep(3000);


        driver.autoPopulate(driver.getData().getDataContainer("amexCard"), eomScreen);
        Thread.sleep(3000);

        Select cardType = new Select(driver.findElement(EomScreen.EomScreenWidget.cardType));
        cardType.selectByValue("Discover");

        Select expMonth = new Select(driver.findElement(EomScreen.EomScreenWidget.expMonth));
        expMonth.selectByValue("May");

        Select expYear = new Select(driver.findElement(EomScreen.EomScreenWidget.expYear));
        expYear.selectByValue("2018");

        EomScreen.EomScreenWidget.saveBtnCreditCard.click();
        Thread.sleep(20000);

        EomScreen.EomScreenWidget.nextBtnCreditCard.click();
        Thread.sleep(20000);

        EomScreen.EomScreenWidget.placeOrderBtn.click();
        Thread.sleep(20000);



    }
}
