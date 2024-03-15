package com.pageObjects.pages.AndroidPages;

import com.driverInstance.DriverManager;
import org.openqa.selenium.By;

public class QuickLoanWithVasPage {

	private QuickLoanWithVasPage() {
	}

	//Loan Tile Status Page
	public static By objLoanTileHeader = By.xpath("//*[contains(@text,'For your needs and wants')]");
	public static By objLoansTile = By.xpath("//*[contains(@text,'Loans')]");
	public static By objBorrowUpTxt = By.xpath("//*[contains(@text,'Borrow up to ₱5 million for your dreams, shopping, or peace of mind.')]");

	//Easy Payments screen
	public static By objEasypaymentsTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Main_title']");
	public static By objEayPaymentsSubTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Main_sub_title']");

	//QuickLoanTile
	public static By objQuickLoanTileHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_header1']");
	public static By objQuickLoanTile = By.xpath("//*[@resource-id='com.tonik.mobile:id/Quick loan']");
	public static By objQuickLoanSubTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_sub_title1']");

	// Shortcut to shopping tile
	public static By objShoppingTileHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_header2']");
	public static By objShoppingTile = By.xpath("//*[@resource-id='com.tonik.mobile:id/Shop installment loan']");
	public static By objShoppingSubTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_sub_title2']");

	public static By objBackButton = By.xpath("//*[@resource-id='com.tonik.mobile:id/Header_left_click']");

	//Loan As easy Page
	public static By objObjAsEasyScreen = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_header0']");
	public static By objAsEasySubHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_sub_header0']");
	public static By objGotTheseBtn = By.xpath("//*[contains(@text,'I got these!')]");

	//Call me maybe page
	public static By objCallMeMaybePageHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_header1']");
	public static By objCallMeMaybePageSubTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_sub_header1']");
	public static By objGotItBtn = By.xpath("//*[contains(@text,'Got it!')]");

	//Now with Pay Hinga page
	public static By objPayHingPageHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_header1']");
	public static By objPayHingPageSubTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_sub_header1']");
	public static By objLetsGoBtn = By.xpath("//*[contains(@text,'Let')]");

	// How much Do you need page
	public static By objHowMuchNeedPage = By.xpath("//*[@resource-id='com.tonik.mobile:id/Button_text']");
	public static By objPesosSymbol = By.xpath("(//*[contains(@text,'₱')])[1]");
	public static By objAmount = By.xpath("//*[contains(@text,'₱')]/following-sibling::android.widget.EditText");
	public static By objContinueBtn = By.xpath("(//*[@resource-id='com.tonik.mobile:id/Continue'])[2]");
	public static By objHowMuchNeedPageBckBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/Button_click']");

	//Loan Calculator Page
	public static By objLoanCalculatorPage = By.xpath("//*[@resource-id='com.tonik.mobile:id/Installment_selection_txt']");
	public static By objLoanCalculatorPageBackBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/Left_click']");

	//How much do you need page
	public static By AmountErrMsg = By.xpath("(//*[contains(@text,'₱')])[2]");

	public static By objWhatDoYouNeedItForPage = By.xpath("//*[@text='What do you need it for?']");
	public static By objReasonForLoan(String sReason){
		return By.xpath("//*[@resource-id='com.tonik.mobile:id/"+sReason+"']");
	}
	public static By objList = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
	public static By objList(int matchingElement){
		return By.xpath("(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)["+matchingElement+"]");
	}
	public static By objLoansStatus = By.xpath("(//*[@text='Loans']/following-sibling::android.widget.TextView)[1]");
	public static By objLoanTileInfo = By.xpath("(//*[@text='Loans']/following-sibling::android.widget.TextView)[2]");
	public static By objLeaveIcon = By.xpath("//*[@resource-id='com.tonik.mobile:id/Header_right_click']/child::*");
	public static By objLeavingSoonPage = By.xpath("//*[@text='Leaving so soon, luv?']");
	public static By objLeavingSoonReason = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
	public static By objFieldOfWokSearchField = By.xpath("//android.widget.EditText");
	public static By objFieldOfWorkPage = By.xpath("//*[@text='You work in...']");
	public static By objIndustrySelectionScreen = By.xpath("//*[@text='What industry do you work in?']");
	public static By objSelectIndustry(String industry){
		return By.xpath("//*[@resource-id='com.tonik.mobile:id/"+industry+"']");
	}
	public static By objMaritalStatusPage = By.xpath("//*[@text='Are you?']");
	public static By objSelectMaritalStatus(String status){
		return By.xpath("//*[@resource-id='com.tonik.mobile:id/"+status+"']");
	}
	public static By objSelectNoOfKids = By.xpath("//*[@text='How many kids do you have?']");
	public static By objContactReferencePage = By.xpath("//*[@text='Who can we contact for reference?']");
	public static By objHighestEducationalAttainmentPage = By.xpath("//*[@text='What is your highest educational attainment?']");

//	Reference Contact
	public static By objFirstNameInputField = By.xpath("//*[@resource-id='com.tonik.mobile:id/First_Name_text']");
	public static By objLastNameInputField = By.xpath("//*[@resource-id='com.tonik.mobile:id/Last_Name_text']");
	public static By objRelationShipDropdown = By.xpath("//*[@resource-id='com.tonik.mobile:id/relationShipTxt_text']");
	public static By objRelationShipPopup = By.xpath("//*[@resource-id='com.tonik.mobile:id/Relationship']");
	public static By objContactsIcon = By.xpath("//*[@resource-id='com.tonik.mobile:id/Phone_book_icon_click']");
	public static By objReferenceSearchField = By.xpath("//*[@resource-id='com.tonik.mobile:id/Search_placeholder']");
	public static By objInvalidMobileNumberMsg = By.xpath("//*[@text='Please enter a valid mobile number']");
	public static By objSelectRelationShip(String relationShip){
		return By.xpath("//*[@resource-id='com.tonik.mobile:id/"+relationShip+"']");
	}
	public static By objHighestEducationalAttainment = By.xpath("//*[@text='What is your highest educational attainment?']");
	public static By objContactsPopup = By.xpath("//*[@text='Allow TONIK to access your contacts?']");
	public static By objIsThisYourCurrentAddPage = By.xpath("//*[@text='Is this your current address?']");
	public static By objHaveAnotherReference = By.xpath("//*[@text='Have another reference?']");

	public static By objPopupHeader = By.id("com.tonik.mobile:id/Popup_header_txt");
	public static By objPopupSubtext = By.id("com.tonik.mobile:id/Popup_sub_txt");
	public static By objPopupButton = By.id("//*[@text='OK']");
	public static By objRegisteredMobileNumberErrorMsg = By.xpath("//*[@text=\"You can't enter registered mobile number\"]");
	public static By objSelectReferenceScreen = By.xpath("//*[@text='Select a reference']");
	public static By objAddress(int address){
		return By.xpath("((//*[@resource-id='com.tonik.mobile:id/Header_left_click']/parent::*/following-sibling::android.view.ViewGroup)[1]/child::*)["+address+"]");
	}
	public static By objAddress = By.xpath("(//*[@resource-id='com.tonik.mobile:id/Header_left_click']/parent::*/following-sibling::android.view.ViewGroup)[1]/child::*");
	public static By objChangeAddressBtn = By.xpath("//android.widget.TextView[@resource-id='com.tonik.mobile:id/Change_Address_click']");
	public static By objYesThisMyAddressBtn = By.xpath("//android.widget.TextView[@resource-id='com.tonik.mobile:id/Submit_click']");
	public static By objMonthlyIncomeScreen = By.id("//*[@text=\"What's your monthly income?\"]");
	public static By objZipCodeInputField = By.xpath("//*[@text='Zipcode']/parent::*/child::android.widget.EditText");
	public static By objApplyZipCode = By.xpath("//*[@text='Apply Zipcode']");
	public static By objMonthlyIncomeField = By.id("com.tonik.mobile:id/Monthly_inc_text");
	public static By objHouseUnitFlrNumberInputField = By.xpath("//*[@text='House/Unit/Flr #, Bldg, Blk or Lot #, Street']/parent::*/child::android.widget.EditText");
	public static By objInvalidIncomeMsg = By.id("com.tonik.mobile:id/Monthly_inc_error");
	public static By objCompanyInputField = By.id("com.tonik.mobile:id/Company_name_text");
	public static By objUpdateButton = By.id("com.tonik.mobile:id/Button_text");
	public static By objWhatsYourJobRolePage = By.xpath("//*[contains(@text,'your job title/role?')]");

















}
