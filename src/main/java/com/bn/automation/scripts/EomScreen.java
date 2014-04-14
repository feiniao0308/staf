package com.bn.automation.scripts;

import com.bn.automation.staf.widget.Button;
import com.bn.automation.staf.widget.Label;
import com.bn.automation.staf.widget.TextBox;
import com.bn.automation.staf.widget.Widgets;
import org.openqa.selenium.By;

@Widgets
public class EomScreen {
	
	@Widgets
	public static class EomScreenWidget{
		
		public static Label createOrderIcon = new Label("xpath=html/body/div[1]/div/div/div[1]/em/button");
		
		public static TextBox searchField = new TextBox("xpath=html/body/div[5]/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/input");
		                                                     
		//html/body/div[7]/div/ul/li/div
		
		public static TextBox fName = new TextBox("id=dataForm:inp_txt_preorder_createCO_fn");
		public static TextBox lName = new TextBox("id=dataForm:inp_txt_preorder_createCO_ln");
		
		public static TextBox searchItemField =  new TextBox("id=dataForm:SICCO_main_search_item_ip_text");
		public static Label searchBtn = new Label("id=dataForm:SICCO_Item_Search_Panel_Search_Button");
		
		public static Label addItem = new Label("id=dataForm:addItemBtn2");
		public static Button nextBtn = new Button("id=dataForm:createCustomerOrderNextButton");
		public static Label addToOrderProceed = new Label("id=dataForm:SICCO_footer_btn_addItemProceedToOrderDetails");
		public static Label nextBtnPromo = new Label("id=dataForm:coPromotionDetailsStepFooterNextButton");
		public static Label nextBtnShipAddr = new Label("id=dataForm:coShippingInfoFooterNextButton");
		
		public static Label addShipAddrBtn = new Label("id=dataForm:coLineShipToAddressAddButton");
		
		public static TextBox firstName = new TextBox("id=dataForm:addShippingAddressPopupFirstName");
		public static TextBox lastName = new TextBox("id=dataForm:addShippingAddressPopupLastName");
		public static TextBox addrLine1 = new TextBox("id=dataForm:addShippingAddressPopupAddrLine1");
		public static TextBox addrLine2 = new TextBox("id=dataForm:addShippingAddressPopupAddrLine2");
		
		public static TextBox city = new TextBox("id=dataForm:addShippingAddressPopupCity");
		public static TextBox zipCode = new TextBox("id=dataForm:addShippingAddressPopupZipCode");
		public static TextBox phoneNum = new TextBox("id=dataForm:addShippingAddressPopupPhoneNumber");
		//public static TextBox shipToemail = new TextBox("id=dataForm:addShippingAddressPopupPhoneNumber");
				
		public static By stateDrpdown = By.id("dataForm:addShippingAddressPrimaryStateList");
		public static Label saveAddrAsIs = new Label("id=dataForm:avsUnavblSaveAddressAsIsLink");
		
		public static Label saveBtnShipAddr = new Label("id=dataForm:addShippingAddressPopupSaveButton");
		
		public static Label sameAsShipAddrChkBox = new Label("id=dataForm:coPaymentDetailsAppliedCreditCardList:0:coCreditCardDetailsUseShippingAddressAsBillingAddressCheckBox");
		
		public static TextBox cardNum = new TextBox("id=dataForm:coPaymentDetailsAppliedCreditCardList:0:coPaymentDetailsCreditCardDetailsCardNumberEditable");
		public static TextBox secCode = new TextBox("id=dataForm:coPaymentDetailsAppliedCreditCardList:0:coPaymentDetailsCreditCardDetailsSecurityCodeEditable");
		public static By cardType = By.id("dataForm:coPaymentDetailsAppliedCreditCardList:0:coPaymentDetailsCreditCardDetailsCardTypeEditable");
		public static By expMonth = By.id("dataForm:coPaymentDetailsAppliedCreditCardList:0:coPaymentDetailsCreditCardDetailsExpMonthEditable");
		public static By expYear = By.id("dataForm:coPaymentDetailsAppliedCreditCardList:0:coPaymentDetailsCreditCardDetailsExpYearEditable");
		
		public static By may = By.xpath("/html/body/form/div[4]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/span/table/tbody/tr/td/span/table/tbody/tr/td[2]/div/div/div/div/span[2]/table/tbody/tr[2]/td[3]/table/tbody/tr[10]/td[3]/table/tbody/tr/td/select/option[6]");
		public static By y2018 = By.xpath("/html/body/form/div[4]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/span/table/tbody/tr/td/span/table/tbody/tr/td[2]/div/div/div/div/span[2]/table/tbody/tr[2]/td[3]/table/tbody/tr[10]/td[3]/table/tbody/tr/td[3]/select/option[6]");
		
		public static By amex = By.xpath("/html/body/form/div[4]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/span/table/tbody/tr/td/span/table/tbody/tr/td[2]/div/div/div/div/span[2]/table/tbody/tr[2]/td[3]/table/tbody/tr[4]/td[3]/table/tbody/tr/td/select/option[2]");
		public static By discover = By.linkText("Discover");
		public static By visa = By.linkText("Visa");
		public static By jcb = By.linkText("JCB");
		public static By diners = By.linkText("Diners Club");
		public static By master = By.linkText("Master Card");
		
		public static Label saveBtnCreditCard = new Label("id=dataForm:coPaymentDetailsAppliedCreditCardList:0:coPaymentDetailsCCSaveCCCmdLink");
		
		public static Label nextBtnCreditCard = new Label("id=dataForm:coPaymentDetailsFooterPlaceOrderButton");
		public static Label placeOrderBtn = new Label("id=dataForm:coReviewOrderPlaceOrderButton");
		
		
		public static Label paymentStatus = new Label("id=dataForm:op_txt_postorder_view_createCO_PaymentStatus");
		public static Label orderStatus = new Label("id=dataForm:op_txt_postorder_view_createCO_status");
		
		public static By optionsDrpdown = By.id("dataForm:drop_down_page_ids_som");
		public static By additionalDetails = By.xpath("/html/body/form/div[4]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/table/tbody/tr/td[2]/span/select/option[5]");
		public static Label lineAdditionalDetails = new Label("id=customerOrderLineAdditionalDetailTab_lnk");
		
	
		
		
		
		
	}

}
