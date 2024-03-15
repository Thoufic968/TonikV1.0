package com.businessFunctions;

import static com.utility.ExtentReporter.HeaderChildNode;
import static com.utility.Utilities.*;

import com.pageObjects.pages.AndroidPages.ContactUsPage;
import com.pageObjects.pages.AndroidPages.LoginPage;
import com.pageObjects.pages.AndroidPages.OnBoardingPage;
import com.pageObjects.pages.AndroidPages.QuickLoanWithVasPage;
import com.propertyfilereader.PropertyFileReader;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuickLoanWithVasModule extends BaseClass{
	public QuickLoanWithVasModule() {
		super();
	}


	public void loanTileValidation() throws Exception {
		if (verifyElementPresent(QuickLoanWithVasPage.objEasypaymentsTitle, getText(QuickLoanWithVasPage.objEasypaymentsTitle))) {
			logger.info("Successufully navigated to  Need fast cash or easy payments? Screen");
			ExtentReporter.extentLoggerPass("Payments Page", "Successufully navigated to  Need fast cash or easy payments? Screen");
			valueValidation(getText(QuickLoanWithVasPage.objEasypaymentsTitle), propertyFileReader("easyPaymentsScreenTitle", "QuickLoanWithVas"), "Need fast cash title", "contains");
			valueValidation(getText(QuickLoanWithVasPage.objEayPaymentsSubTitle), propertyFileReader("easyPaymentsScreenSubTitle", "QuickLoanWithVas"), "Need fast cash sub title", "contains");
			valueValidation(getText(QuickLoanWithVasPage.objQuickLoanTileHeader), propertyFileReader("quickLoanHeader", "QuickLoanWithVas"), "Quick Loan title", "contains");
			valueValidation(getText(QuickLoanWithVasPage.objQuickLoanTile), propertyFileReader("quickLoanOption", "QuickLoanWithVas"), "Borrow Message", "contains");
			//valueValidation(getText(QuickLoanWithVasPage.objQuickLoanSubTitle), propertyFileReader("quickLoanBorrowMsg", "QuickLoanWithVas"),"Quick Loan sub title","contains");
			valueValidation(getText(QuickLoanWithVasPage.objShoppingTileHeader), propertyFileReader("shoppingTileHeader", "QuickLoanWithVas"), "Shopping Tile title", "contains");
			valueValidation(getText(QuickLoanWithVasPage.objShoppingTile), propertyFileReader("shoppingOption", "QuickLoanWithVas"), "Shopping tile", "contains");
			valueValidation(getText(QuickLoanWithVasPage.objShoppingSubTitle), propertyFileReader("shoppingSubTitle", "QuickLoanWithVas"), "Shopping Tile sub title", "contains");
		} else {
			logger.info("Failed to navigate Need fast cash or easy payments? Screen");
			ExtentReporter.extentLoggerPass("Payments Page", "Failed to navigate  Need fast cash or easy payments? Screen");
		}

	}

	public void loanValidation() throws Exception {
		verifyElementPresent(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		verifyElementPresent(QuickLoanWithVasPage.objLoansStatus, getTextVal(QuickLoanWithVasPage.objLoansStatus, ": Loan status"));
		assertionValidation(getText(QuickLoanWithVasPage.objLoanTileInfo),propertyFileReader("LoanTileInfo","QuickLoanWithVas"),": Tile info");
	}
	public void reasonForLoan(String sReason) throws Exception {
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))){
			assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("WhatDoYouNeedItForPage","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("WhatDoYouNeedItForPageSubTitle","QuickLoanWithVas"),": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int info = 0; info < values.size(); info++) {
				String displayedItem = values.get(info).getText();
				logger.info("Reason : '" + displayedItem + "' is displayed");
				ExtentReporter.extentLogger(" ", "Reason : '" + displayedItem + "' is displayed");
			}
			assertionValidation(getAttributValue("enabled",LoginPage.objNextButton),"false",": Enable Attribute value");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objReasonForLoan(sReason),getTextVal(QuickLoanWithVasPage.objReasonForLoan(sReason), ": Reason"));
			assertionValidation(getAttributValue("enabled",LoginPage.objNextButton),"true",": Enable Attribute value");
			click(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		}
	}

	public void fieldOfWork(String fieldOfWork) throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objFieldOfWorkPage,5,"Field of work");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("FieldOfWorkPage", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("FieldOfWorkPageSubtitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int info = 0; info < values.size(); info++) {
				String displayedItem = values.get(info).getText();
				logger.info("Field of work : '" + displayedItem + "' is displayed");
				ExtentReporter.extentLogger(" ", "Field of work : '" + displayedItem + "' is displayed");
			}
			assertionValidation(getAttributValue("enabled",LoginPage.objNextButton),"false",": Enable Attribute value");
			type(QuickLoanWithVasPage.objFieldOfWokSearchField,fieldOfWork,"Field name");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objList(1),getTextVal(QuickLoanWithVasPage.objList(1), ": Field Of Work"));
			assertionValidation(getAttributValue("enabled",LoginPage.objNextButton),"true",": Enable Attribute value");
			click(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		}
	}

	public void selectOccupation(String occupation) throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objWhatsYourJobRolePage,5,"What's your Job Role? Screen");
		if (verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": page title"))) {
			containsValidation(getText(LoginPage.objPageTitle), propertyFileReader("WhatsYourJobRolePage", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("WhatsYourJobRolePageSubtitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int info = 0; info < values.size(); info++) {
				String displayedItem = values.get(info).getText();
				logger.info("Occupation : '" + displayedItem + "' is displayed");
				ExtentReporter.extentLogger(" ", "Occupation : '" + displayedItem + "' is displayed");
			}
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "false", ": Enable Attribute value");
			type(QuickLoanWithVasPage.objFieldOfWokSearchField, occupation, "occupation input field");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objList(1), getTextVal(QuickLoanWithVasPage.objList(1), ": Occupation"));
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "true", ": Enable Attribute value");
			click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		}
	}

	public void selectIndustry(String industry,String subIndustry) throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objIndustrySelectionScreen,5,"Industry Selection screen");
		if (verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": page title"))) {
			containsValidation(getText(LoginPage.objPageTitle), propertyFileReader("IndustrySelectionScreen", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("IndustrySelectionScreenSubTitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int industryName = 1; industryName <= values.size(); industryName++) {
				assertionValidation(getText(QuickLoanWithVasPage.objList(industryName)), propertyFileReader("Industry"+industryName,"QuickLoanWithVas"), ": Industry "+industryName);
			}
			waitTime(3000);
			verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectIndustry(industry), getTextVal(QuickLoanWithVasPage.objSelectIndustry(industry), ": industry"));
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "false", ": Enable Attribute value");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectIndustry(subIndustry), getTextVal(QuickLoanWithVasPage.objSelectIndustry(subIndustry), ": subIndustry"));
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "true", ": Enable Attribute value");
			click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		}
	}

	public void selectMaritalStatus(String status) throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objMaritalStatusPage,5,"Marital status selection screen");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("MaritalStatus", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("MaritalStatusSubTitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int maritalStatusOption = 1; maritalStatusOption <= values.size(); maritalStatusOption++) {
				assertionValidation(getText(QuickLoanWithVasPage.objList(maritalStatusOption)), propertyFileReader("MaritalStatusOption"+maritalStatusOption,"QuickLoanWithVas"), ": Marital Status Option "+maritalStatusOption);
			}
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "false", ": Enable Attribute value");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectMaritalStatus(status), getTextVal(QuickLoanWithVasPage.objSelectMaritalStatus(status), ": marital status"));
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "true", ": Enable Attribute value");
			click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		}
	}

	public void selectKidsOrDependents(String kidsDependent) throws Exception {
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("SelectNoOfKids", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("SelectNoOfKidsSubTitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int kids = 1; kids <= values.size(); kids++) {
				assertionValidation(getText(QuickLoanWithVasPage.objList(kids)), propertyFileReader("DependentsOption"+kids,"QuickLoanWithVas"), ": Dependents Option "+kids);
			}
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "false", ": Enable Attribute value");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectMaritalStatus(kidsDependent), getTextVal(QuickLoanWithVasPage.objSelectMaritalStatus(kidsDependent), ": Kids/Dependents"));
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "true", ": Enable Attribute value");
			click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		}
	}

	public void selectHighestEducationalAttainment(String higherEducation) throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objHighestEducationalAttainment,5,"Highest Educational attainment");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("HighestEducationalAttainment", "QuickLoanWithVas"), ": page title");
			containsValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("HighestEducationalAttainmentSubTitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objList);
			for (int education = 1; education <= values.size(); education++) {
				assertionValidation(getText(QuickLoanWithVasPage.objList(education)), propertyFileReader("EducationalAttainment"+education,"QuickLoanWithVas"), ": Educational Attainment "+education);
			}
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "false", ": Enable Attribute value");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectMaritalStatus(higherEducation), getTextVal(QuickLoanWithVasPage.objSelectMaritalStatus(higherEducation), ": Kids/Dependents"));
			assertionValidation(getAttributValue("enabled", LoginPage.objNextButton), "true", ": Enable Attribute value");
			click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		}
	}

	public void leavingSoonPageValidation() throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objLeaveIcon,5,"Leave application Icon");
		click(QuickLoanWithVasPage.objLeaveIcon,"Leave Icon");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("LeavingSoonPage", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("LeavingSoonPageSubtitle", "QuickLoanWithVas"), ": page subtitle");
			List<WebElement> values = findElements(QuickLoanWithVasPage.objLeavingSoonReason);
			for (int info = 0; info < values.size(); info++) {
				String displayedItem = values.get(info).getText();
				logger.info("Leaving Reason : '" + displayedItem + "' is displayed");
				ExtentReporter.extentLogger(" ", "Leaving Reason : '" + displayedItem + "' is displayed");
			}
		}
		assertionValidation(getAttributValue("enabled",LoginPage.objNextButton),"false",": Enable Attribute value");
		click(LoginPage.objBackBtn,"Back button");
	}

	public void inputIncomeAmountAndNext(String sAmount) throws Exception {
		type(QuickLoanWithVasPage.objMonthlyIncomeField,sAmount,"Income input field");
		click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		if(verifyElementPresent(QuickLoanWithVasPage.objInvalidIncomeMsg,getTextVal(QuickLoanWithVasPage.objInvalidIncomeMsg,"Error message"))){
			assertionValidation(getText(QuickLoanWithVasPage.objInvalidIncomeMsg),propertyFileReader("InvalidIncome","QuickLoanWithVas"),": Error message");
		}
	}
	public void updateFirstNameLastNameAndRelationShip() throws Exception {
		type(QuickLoanWithVasPage.objFirstNameInputField,propertyFileReader("FirstName","QuickLoanWithVas"),"First name input field");
		type(QuickLoanWithVasPage.objLastNameInputField,propertyFileReader("LastName","QuickLoanWithVas"),"Last name input field");
		click(QuickLoanWithVasPage.objRelationShipDropdown,"Relationship dropdown");
		verifyElementPresent(QuickLoanWithVasPage.objRelationShipPopup,getTextVal(QuickLoanWithVasPage.objRelationShipPopup,"Popup"));
		click(QuickLoanWithVasPage.objSelectRelationShip(propertyFileReader("RelationShip","QuickLoanWithVas")), getTextVal(QuickLoanWithVasPage.objSelectRelationShip(propertyFileReader("RelationShip","QuickLoanWithVas")),": Relationship"));
	}

	public void isThisYourCurrentAddressConfirmation() throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objIsThisYourCurrentAddPage,5,"Is this your current address? Screen");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("IsThisYourCurrentAddPage", "QuickLoanWithVas"), ": page title");
			containsValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("IsThisYourCurrentAddPageSubtitle", "QuickLoanWithVas"), ": page subtitle");
			click(QuickLoanWithVasPage.objYesThisMyAddressBtn,getTextVal(QuickLoanWithVasPage.objYesThisMyAddressBtn,": button"));
		}
	}
	/**
	 * Reusable method to Apply zip code
	 * @param zipCode
	 * @throws Exception
	 */
	public void applyZipCode(String zipCode) throws Exception {
		waitForElementToBePresent(QuickLoanWithVasPage.objZipCodeInputField, 5, "Zip code page");
		type(QuickLoanWithVasPage.objZipCodeInputField,zipCode,"Zip code input field");
		verifyElementPresentAndClick(QuickLoanWithVasPage.objApplyZipCode,getTextVal(QuickLoanWithVasPage.objApplyZipCode,": button"));
	}
	/**
	 * Reusable method to select Barangay
	 * @throws Exception
	 */
	public void selectBarangay() throws Exception {
		verifyElementPresentAndClick(OnBoardingPage.objBarangay,getTextVal(OnBoardingPage.objBarangay,": field"));
		if(verifyElementDisplayed(OnBoardingPage.objBarangay)) {
			click(OnBoardingPage.objBarangay, getTextVal(OnBoardingPage.objBarangay, ": field"));
		}
		waitForElementToBePresent(OnBoardingPage.objBarangayDisplayed, 5, "Barangay");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(ContactUsPage.objPageHeader," : Page Title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("FindYourBarangay","onboarding"),": Title");
		if (verifyElementDisplayed(OnBoardingPage.objBarangayDisplayed)) {
			List<WebElement> values = findElements(OnBoardingPage.objBarangayDisplayed);
			for (int info = 0; info < values.size(); info++) {
				if(info%2==0) {
					String displayedItem = values.get(info).getText();
					logger.info("Barangay : '" + displayedItem + "' is displayed");
					ExtentReporter.extentLogger(" ", "Barangay : '" + displayedItem + "' is displayed");
				}
			}
		}
		type(OnBoardingPage.objBarangaySearchField,propertyFileReader("SanAndreBarangay","onboarding"),": Barangay search field");
		verifyElementPresent(OnBoardingPage.objBarangay("1"),getTextVal(OnBoardingPage.objBarangay("1"),": Barangay"));
		containsValidation(getText(OnBoardingPage.objBarangaySearchField),propertyFileReader("SanAndreBarangay","onboarding"),"Barangay");
		verifyElementPresentAndClick(OnBoardingPage.objBarangay("1"),getTextVal(OnBoardingPage.objBarangay("1"),": Barangay"));
	}

	public void updateContactForReference(String sContactNumber) throws Exception {
		if(verifyElementDisplayed(QuickLoanWithVasPage.objContactsPopup)){
			verifyElementPresent(QuickLoanWithVasPage.objContactsPopup,getTextVal(QuickLoanWithVasPage.objContactsPopup,": Contacts Permission popup"));
			click(LoginPage.objAllowBtn,getTextVal(LoginPage.objAllowBtn,": Button"));
		}
		verifyElementPresentAndClick(QuickLoanWithVasPage.objContactsIcon,"Contacts Icon");
		waitForElementToBePresent(QuickLoanWithVasPage.objSelectReferenceScreen,5,"Select reference Screen");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("SelectReferenceScreen", "QuickLoanWithVas"), ": page title");
		assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("SelectReferenceScreenSubtitle", "QuickLoanWithVas"), ": page subtitle");
		type(QuickLoanWithVasPage.objReferenceSearchField,sContactNumber,"Search field");
		click(QuickLoanWithVasPage.objList(1),getTextVal(QuickLoanWithVasPage.objList(1),"Contact"));
	}

	public void updateContactReference(String contactNumber) throws Exception {
		updateContactForReference(contactNumber);
		updateFirstNameLastNameAndRelationShip();
		click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
	}
	public void howMuchDoYouNeedPage() throws Exception {
		if (verifyElementPresent(QuickLoanWithVasPage.objHowMuchNeedPage, getTextVal(QuickLoanWithVasPage.objHowMuchNeedPage, "Text"))) {
			logger.info("Successufully navigated to  How much do you need? page");
			ExtentReporter.extentLoggerPass("Payments Page", "Successufully navigated to How much do you need? page");
			verifyElementPresent(QuickLoanWithVasPage.objHowMuchNeedPageBckBtn, "Back Button");
			verifyElementPresent(QuickLoanWithVasPage.objPesosSymbol, getTextVal(QuickLoanWithVasPage.objPesosSymbol, "Symbol"));
			verifyElementPresent(QuickLoanWithVasPage.objAmount, getTextVal(QuickLoanWithVasPage.objAmount, "Amount"));
			verifyElementPresentAndClick(QuickLoanWithVasPage.objContinueBtn, getTextVal(QuickLoanWithVasPage.objContinueBtn, "button"));
		} else {
			logger.info("Failed to navigate to How much do you need? page");
			ExtentReporter.extentLoggerPass("How Much do you need Page", "Failed to navigate to How much do you need? page");
		}
	}

	public void OnboardAsNewSKYCUserWithNoTSA_TDB_QLV_004() throws Exception {
		HeaderChildNode("TDB_BP_004, Verify if user can verify the email address from Bills Pay");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		scrollToVertical("Loans");
		valueValidation(getText(QuickLoanWithVasPage.objLoanTileHeader), propertyFileReader("loanTileHeader", "QuickLoanWithVas"), "Loan Tile header", "contains");
		valueValidation(getText(QuickLoanWithVasPage.objLoansTile), propertyFileReader("loanTile", "QuickLoanWithVas"), "Loan Tile", "contains");
		// valueValidation(getText(QuickLoanWithVasPage.objBorrowUpTxt), propertyFileReader("borrowTxtOnLoanTile", "QuickLoanWithVas"),"Loan Tile","contains");
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, "Tile"));
		loanTileValidation();
		click(QuickLoanWithVasPage.objBackButton, "Back Button");
		if (verifyElementPresent(LoginPage.objProfileName, getTextVal(LoginPage.objProfileName, " : Profile Name"))) {
			logger.info("Succesfully navigated to  Dasshboard screen");
			ExtentReporter.extentLoggerPass("Payments Page", "Succesfully navigated to  Dasshboard screen");
		}
		scrollToVertical("Loans");
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, "Tile"));
		click(QuickLoanWithVasPage.objQuickLoanTile, getTextVal(QuickLoanWithVasPage.objQuickLoanTile, "Tile"));

		verifyElementPresent(QuickLoanWithVasPage.objObjAsEasyScreen, getTextVal(QuickLoanWithVasPage.objObjAsEasyScreen, "Page Header"));
		verifyElementPresent(QuickLoanWithVasPage.objAsEasySubHeader, getTextVal(QuickLoanWithVasPage.objAsEasySubHeader, "Page Sub Header"));
		verifyElementPresentAndClick(QuickLoanWithVasPage.objGotTheseBtn, getTextVal(QuickLoanWithVasPage.objGotTheseBtn, "button"));

		verifyElementPresent(QuickLoanWithVasPage.objCallMeMaybePageHeader, getTextVal(QuickLoanWithVasPage.objCallMeMaybePageHeader, "Page Header"));
		verifyElementPresent(QuickLoanWithVasPage.objCallMeMaybePageSubTitle, getTextVal(QuickLoanWithVasPage.objCallMeMaybePageSubTitle, "Page Sub Header"));
		verifyElementPresentAndClick(QuickLoanWithVasPage.objGotItBtn, getTextVal(QuickLoanWithVasPage.objGotItBtn, "button"));

		verifyElementPresent(QuickLoanWithVasPage.objPayHingPageHeader, getTextVal(QuickLoanWithVasPage.objPayHingPageHeader, "Page Header"));
		verifyElementPresent(QuickLoanWithVasPage.objPayHingPageSubTitle, getTextVal(QuickLoanWithVasPage.objPayHingPageSubTitle, "Page Sub Header"));
		verifyElementPresentAndClick(QuickLoanWithVasPage.objLetsGoBtn, getTextVal(QuickLoanWithVasPage.objLetsGoBtn, "button"));

//		  verifyElementPresent(QuickLoanWithVasPage.objHowMuchNeedPage, getTextVal(QuickLoanWithVasPage.objHowMuchNeedPage, "Text"));
//		  verifyElementPresent(QuickLoanWithVasPage.objHowMuchNeedPageBckBtn, "Back Button"); 
//		  verifyElementPresent(QuickLoanWithVasPage.objPesosSymbol, getTextVal(QuickLoanWithVasPage.objPesosSymbol, "Symbol"));
//		  verifyElementPresent(QuickLoanWithVasPage.objAmount, getTextVal(QuickLoanWithVasPage.objAmount, "Amount"));
		howMuchDoYouNeedPage();
		howMuchDoYouNeedPage();
		verifyElementPresent(QuickLoanWithVasPage.objLoanCalculatorPage, getTextVal(QuickLoanWithVasPage.objLoanCalculatorPage, "Page"));
		verifyElementPresentAndClick(QuickLoanWithVasPage.objLoanCalculatorPage, "Back button");
	}

	public void amountErrMsgValidation() throws Exception {
		String[] amounts = {"2000", "260000", "20000"};
		for (int i = 0; i < amounts.length; i++) {
			type(QuickLoanWithVasPage.objAmount, amounts[i], "Amount Field");
			clearField(QuickLoanWithVasPage.objAmount, "Amount Field");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objContinueBtn, getTextVal(QuickLoanWithVasPage.objContinueBtn, "button"));
			logger.info(getTextVal(QuickLoanWithVasPage.AmountErrMsg, amounts[i]));
			ExtentReporter.extentLogger("Amount Error Message", getTextVal(QuickLoanWithVasPage.AmountErrMsg, amounts[i]));
		}
	}


	public void userCanEditAmountInHowMuchDoYouNeedScreen_TDB_QLV_005() throws Exception {
		HeaderChildNode("TDB_BP_004, Verify if user can edit the amount in the 'How much do you need?' screen");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		scrollToVertical("Loans");
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, "Tile"));
		click(QuickLoanWithVasPage.objQuickLoanTile, getTextVal(QuickLoanWithVasPage.objQuickLoanTile, "Tile"));
		howMuchDoYouNeedPage();
		click(QuickLoanWithVasPage.objAmount, "Amount Field");
		clearField(QuickLoanWithVasPage.objAmount, "Amount Field");
		amountErrMsgValidation();
		verifyElementPresent(QuickLoanWithVasPage.objLoanCalculatorPage, getTextVal(QuickLoanWithVasPage.objLoanCalculatorPage, "Page"));
	}


	public void reasonForLoanApplicationValidation_TDB_QLV_009() throws Exception {
		HeaderChildNode("TDB_QLV_009, Quick Loan With VAS - Verify if user can select the reason for the loan application");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		verifyElementPresent(QuickLoanWithVasPage.objWhatDoYouNeedItForPage,getTextVal(QuickLoanWithVasPage.objWhatDoYouNeedItForPage,": page"));
		click(LoginPage.objBackBtn,"Back button");
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		leavingSoonPageValidation();
		reasonForLoan("Education");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("FieldOfWorkPage","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("FieldOfWorkPageSubtitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_009, Quick Loan With VAS - User can select the reason for the loan application and navigated to Field of work screen validated");
			extentLoggerPass("TDB_QLV_009", "TDB_QLV_009, Quick Loan With VAS - User can select the reason for the loan application and navigated to Field of work screen validated");
		}
	}

	public void selectFieldOfWorkValidation_TDB_QLV_010() throws Exception {
		HeaderChildNode("TDB_QLV_010, Quick Loan With VAS - Verify if user can select the field of work");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("FieldOfWorkPage", "QuickLoanWithVas"), ": page title");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("WhatDoYouNeedItForPage","QuickLoanWithVas"),": page title");
		click(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		leavingSoonPageValidation();
		fieldOfWork(propertyFileReader("FieldOfWork","QuickLoanWithVas"));
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			containsValidation(getText(LoginPage.objPageTitle),propertyFileReader("WhatsYourJobRolePage","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("WhatsYourJobRolePageSubtitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_009, Quick Loan With VAS - User can select the field of work and navigated to What's your job Role? screen validated");
			extentLoggerPass("TDB_QLV_010", "TDB_QLV_010, Quick Loan With VAS - User can select the field of work and navigated to What's your job Role? screen validated");
		}
	}


	public void selectOccupationValidation_TDB_QLV_011() throws Exception {
		HeaderChildNode("TDB_QLV_011, Quick Loan With VAS - Verify if user can select the Occupation details");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork","QuickLoanWithVas"));
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		containsValidation(getText(LoginPage.objPageTitle), propertyFileReader("WhatsYourJobRolePage", "QuickLoanWithVas"), ": page title");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("FieldOfWorkPage","QuickLoanWithVas"),": page title");
		click(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		leavingSoonPageValidation();
		selectOccupation(propertyFileReader("Occupation","QuickLoanWithVas"));
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			containsValidation(getText(LoginPage.objPageTitle),propertyFileReader("IndustrySelectionScreen","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("IndustrySelectionScreenSubTitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_011, Quick Loan With VAS - User can select the field of work and navigated to What's your job Role? screen validated");
			extentLoggerPass("TDB_QLV_011", "TDB_QLV_011, Quick Loan With VAS - User can select the field of work and navigated to What's your job Role? screen validated");
		}
	}

	public void selectIndustryAndSubIndustryValidation_TDB_QLV_012() throws Exception {
		HeaderChildNode("TDB_QLV_012, Quick Loan With VAS - Verify if user can select the Industry & the Sub-Industry options");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork","QuickLoanWithVas"));
		selectOccupation(propertyFileReader("Occupation","QuickLoanWithVas"));
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		containsValidation(getText(LoginPage.objPageTitle), propertyFileReader("IndustrySelectionScreen", "QuickLoanWithVas"), ": page title");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		containsValidation(getText(LoginPage.objPageTitle),propertyFileReader("WhatsYourJobRolePage","QuickLoanWithVas"),": page title");
		click(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		leavingSoonPageValidation();
		selectIndustry(propertyFileReader("Industry1","QuickLoanWithVas"),propertyFileReader("SubIndustry","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objMaritalStatusPage,5,"Martial Status screen");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("MaritalStatus","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("MaritalStatusSubTitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_012, Quick Loan With VAS - User can select the Industry & the Sub-Industry options validated");
			extentLoggerPass("TDB_QLV_012", "TDB_QLV_011, Quick Loan With VAS - User can select the field of work and navigated to What's your job Role? screen validated");
		}
	}

	public void selectMaritalStatusValidation_TDB_QLV_013() throws Exception {
		HeaderChildNode("TDB_QLV_013, Quick Loan With VAS - Verify if user can select the Marital Status");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork","QuickLoanWithVas"));
		selectOccupation(propertyFileReader("Occupation","QuickLoanWithVas"));
		selectIndustry(propertyFileReader("Industry1","QuickLoanWithVas"),propertyFileReader("SubIndustry","QuickLoanWithVas"));
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("MaritalStatus","QuickLoanWithVas"),": page title");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": page title"));
		containsValidation(getText(LoginPage.objPageTitle), propertyFileReader("IndustrySelectionScreen", "QuickLoanWithVas"), ": page title");
		verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectIndustry(propertyFileReader("Industry1","QuickLoanWithVas")), getTextVal(QuickLoanWithVasPage.objSelectIndustry(propertyFileReader("Industry1","QuickLoanWithVas")), ": industry"));
		verifyElementPresentAndClick(QuickLoanWithVasPage.objSelectIndustry(propertyFileReader("SubIndustry","QuickLoanWithVas")), getTextVal(QuickLoanWithVasPage.objSelectIndustry(propertyFileReader("SubIndustry","QuickLoanWithVas")), ": Sub Industry"));
		click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		leavingSoonPageValidation();
		selectMaritalStatus(propertyFileReader("MaritalStatusOption1","QuickLoanWithVas"));
		selectKidsOrDependents(propertyFileReader("DependentsOption2","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objHighestEducationalAttainmentPage,5,"Select number of Kids");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("SelectNoOfKids","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("SelectNoOfKidsSubTitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_013, Quick Loan With VAS - User can select the Marital Status and navigated to Kids selection screen validated");
			extentLoggerPass("TDB_QLV_013", "TDB_QLV_013, Quick Loan With VAS - User can select the Marital Status and navigated to Kids selection screen validated");
		}
	}

	public void selectEducationalDetails_TDB_QLV_014() throws Exception {
		HeaderChildNode("TDB_QLV_014, Quick Loan With VAS - Verify if user can select the Educational details");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork", "QuickLoanWithVas"));
		selectOccupation(propertyFileReader("Occupation", "QuickLoanWithVas"));
		selectIndustry(propertyFileReader("Industry1", "QuickLoanWithVas"), propertyFileReader("SubIndustry", "QuickLoanWithVas"));
		selectMaritalStatus(propertyFileReader("MaritalStatusOption1","QuickLoanWithVas"));
		selectKidsOrDependents(propertyFileReader("DependentsOption2","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objHighestEducationalAttainmentPage,5,"Select number of Kids");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("HighestEducationalAttainment","QuickLoanWithVas"),": page title");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("SelectNoOfKids", "QuickLoanWithVas"), ": page title");
		click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		leavingSoonPageValidation();
		selectHighestEducationalAttainment(propertyFileReader("EducationalAttainment1","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objContactReferencePage,5,"Contact Reference");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("ContactReference","QuickLoanWithVas"),": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("ContactReferenceSubTitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_014, Quick Loan With VAS - User can select the Educational details and navigated to Highest Educational Attainment screen validated");
			extentLoggerPass("TDB_QLV_014", "TDB_QLV_014, Quick Loan With VAS - User can select the Educational details and navigated to Highest Educational Attainment screen validated");
		}
	}


	public void inputReferenceContactDetailsValidation_TDB_QLV_015() throws Exception {
		HeaderChildNode("TDB_QLV_015, Quick Loan With VAS - Verify if user can input the reference contact details");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork", "QuickLoanWithVas"));
		selectOccupation(propertyFileReader("Occupation", "QuickLoanWithVas"));
		selectIndustry(propertyFileReader("Industry1", "QuickLoanWithVas"), propertyFileReader("SubIndustry", "QuickLoanWithVas"));
		selectMaritalStatus(propertyFileReader("MaritalStatusOption1", "QuickLoanWithVas"));
		selectKidsOrDependents(propertyFileReader("DependentsOption2", "QuickLoanWithVas"));
		selectHighestEducationalAttainment(propertyFileReader("EducationalAttainment1","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objContactReferencePage,5,"Contact reference page");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("ContactReference","QuickLoanWithVas"),": page title");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("HighestEducationalAttainment", "QuickLoanWithVas"), ": page title");
		click(OnBoardingPage.objNextBtn, getTextVal(OnBoardingPage.objNextBtn, ": button"));
		waitForElementToBePresent(QuickLoanWithVasPage.objContactReferencePage,5,"Contact reference page");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("ContactReference","QuickLoanWithVas"),": page title");
		leavingSoonPageValidation();
		updateContactReference(propertyFileReader("InvalidReferenceNumber","QuickLoanWithVas"));
		if(verifyElementPresent(QuickLoanWithVasPage.objInvalidMobileNumberMsg,getTextVal(QuickLoanWithVasPage.objInvalidMobileNumberMsg,"Error message"))){
			assertionValidation(getText(QuickLoanWithVasPage.objInvalidMobileNumberMsg),propertyFileReader("InvalidMobileNumberMsg","QuickLoanWithVas"),"Error message");
		}
		updateContactReference(propertyFileReader("ContactMobileNumber","QuickLoanWithVas"));
		if(verifyElementPresent(QuickLoanWithVasPage.objRegisteredMobileNumberErrorMsg,getTextVal(QuickLoanWithVasPage.objRegisteredMobileNumberErrorMsg,"Error message"))){
			assertionValidation(getText(QuickLoanWithVasPage.objRegisteredMobileNumberErrorMsg),propertyFileReader("RegisteredMobileNumberErrorMsg","QuickLoanWithVas"),"Error message");
		}
		updateContactReference(propertyFileReader("ReferenceNumber1","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objHaveAnotherReference,5,"Have another Reference page");		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("HaveAnotherReference","QuickLoanWithVas"),": page title");
		assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("HaveAnotherReferenceSubtitle","QuickLoanWithVas"),": page subtitle");
		updateContactReference(propertyFileReader("ContactMobileNumber","QuickLoanWithVas"));
		if(verifyElementDisplayed(QuickLoanWithVasPage.objPopupHeader)){
			verifyElementPresent(QuickLoanWithVasPage.objPopupHeader,getTextVal(QuickLoanWithVasPage.objPopupHeader,": popup header"));
			assertionValidation(getText(QuickLoanWithVasPage.objPopupSubtext),propertyFileReader("SameNumberPopSubTxt","QuickLoanWithVas"),": Popup subtext");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objPopupButton,getTextVal(QuickLoanWithVasPage.objPopupButton,": popup button"));
		}
		updateContactReference(propertyFileReader("ReferenceNumber1","QuickLoanWithVas"));
		if(verifyElementDisplayed(QuickLoanWithVasPage.objPopupHeader)){
			verifyElementPresent(QuickLoanWithVasPage.objPopupHeader,getTextVal(QuickLoanWithVasPage.objPopupHeader,": popup header"));
			assertionValidation(getText(QuickLoanWithVasPage.objPopupSubtext),propertyFileReader("PopSubtext","QuickLoanWithVas"),": Popup subtext");
			verifyElementPresentAndClick(QuickLoanWithVasPage.objPopupButton,getTextVal(QuickLoanWithVasPage.objPopupButton,": popup button"));
		}
		updateContactReference(propertyFileReader("ReferenceNumber2","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objIsThisYourCurrentAddPage,5,"is this your current address screen");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("IsThisYourCurrentAddPage","QuickLoanWithVas"),": page title");
			containsValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("IsThisYourCurrentAddPageSubtitle","QuickLoanWithVas"),": page subtitle");
			logger.info("TDB_QLV_015, Quick Loan With VAS - User can input the reference contact details and navigated to Is This Your Current Address screen validated");
			extentLoggerPass("TDB_QLV_015", "TDB_QLV_015, Quick Loan With VAS - User can input the reference contact details and navigated to Is This Your Current Address screen validated");
		}
	}

	public void selectYourCurrentLivingCityValidation_TDB_QLV_016() throws Exception {
		HeaderChildNode("TDB_QLV_016, Quick Loan With VAS - Verify if user can select the Current Living City");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork", "QuickLoanWithVas"));
		selectOccupation(propertyFileReader("Occupation", "QuickLoanWithVas"));
		selectIndustry(propertyFileReader("Industry1", "QuickLoanWithVas"), propertyFileReader("SubIndustry", "QuickLoanWithVas"));
		selectMaritalStatus(propertyFileReader("MaritalStatusOption1", "QuickLoanWithVas"));
		selectKidsOrDependents(propertyFileReader("DependentsOption2", "QuickLoanWithVas"));
		selectHighestEducationalAttainment(propertyFileReader("EducationalAttainment1", "QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objContactReferencePage,5,"Contact reference page");
		updateContactReference(propertyFileReader("ReferenceNumber1","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objHaveAnotherReference,5,"Have another Reference Screen");
		updateContactReference(propertyFileReader("ReferenceNumber2","QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objIsThisYourCurrentAddPage,5,"Is this your current address? page");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("IsThisYourCurrentAddPage","QuickLoanWithVas"),": page title");
		containsValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("IsThisYourCurrentAddPageSubtitle","QuickLoanWithVas"),": page subtitle");
		List<WebElement> values = findElements(QuickLoanWithVasPage.objAddress);
		for (int address = 0; address < values.size(); address++) {
			String displayedItem = values.get(address).getText();
			logger.info("'" + displayedItem + "' Address "+address+"is displayed");
			ExtentReporter.extentLogger(" ", "'" + displayedItem + "' Address "+address+" is displayed");
		}
		click(QuickLoanWithVasPage.objChangeAddressBtn,getTextVal(QuickLoanWithVasPage.objChangeAddressBtn,": button"));
		applyZipCode(propertyFileReader("ValidZipCode","onboarding"));
		selectBarangay();
		Swipe("UP",2);
		type(QuickLoanWithVasPage.objHouseUnitFlrNumberInputField,propertyFileReader("HouseStreetName","QuickLoanWithVas"),"House/Street Name");
		verifyElementPresentAndClick(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		waitForElementToBePresent(QuickLoanWithVasPage.objMonthlyIncomeScreen,5,"What's your monthly income? screen");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("MonthlyIncomeScreen", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("MonthlyIncomeScreenSubTitle", "QuickLoanWithVas"), ": page subtitle");
		}
		click(LoginPage.objBackBtn,"Back button");
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresentAndClick(QuickLoanWithVasPage.objYesThisMyAddressBtn,getTextVal(QuickLoanWithVasPage.objYesThisMyAddressBtn,": button"));
		waitForElementToBePresent(QuickLoanWithVasPage.objMonthlyIncomeScreen,5,"What's your monthly income? screen");
		if(verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"))) {
			assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("MonthlyIncomeScreen", "QuickLoanWithVas"), ": page title");
			assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("MonthlyIncomeScreenSubTitle", "QuickLoanWithVas"), ": page subtitle");
			logger.info("TDB_QLV_016, Quick Loan With VAS - User can select the Current Living City and navigated to Is This Your Monthly Income screen validated");
			extentLoggerPass("TDB_QLV_016", "TDB_QLV_016, Quick Loan With VAS - User can select the Current Living City and navigated to Is This Your Monthly Income screen validated");
		}
	}

	public void selectYourCurrentLivingCityValidation_TDB_QLV_017() throws Exception {
		HeaderChildNode("TDB_QLV_017, Quick Loan With VAS - Verify if user can input the Monthly income, Company name & TIN details");
		tonikLogin(propertyFileReader("password", "QuickLoanWithVas"));
		loanValidation();
		click(QuickLoanWithVasPage.objLoansTile, getTextVal(QuickLoanWithVasPage.objLoansTile, ": Tile"));
		reasonForLoan("Education");
		fieldOfWork(propertyFileReader("FieldOfWork", "QuickLoanWithVas"));
		selectOccupation(propertyFileReader("Occupation", "QuickLoanWithVas"));
		selectIndustry(propertyFileReader("Industry1", "QuickLoanWithVas"), propertyFileReader("SubIndustry", "QuickLoanWithVas"));
		selectMaritalStatus(propertyFileReader("MaritalStatusOption1", "QuickLoanWithVas"));
		selectKidsOrDependents(propertyFileReader("DependentsOption2", "QuickLoanWithVas"));
		selectHighestEducationalAttainment(propertyFileReader("EducationalAttainment1", "QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objContactReferencePage, 5, "Contact reference page");
		updateContactReference(propertyFileReader("ReferenceNumber1", "QuickLoanWithVas"));
		waitForElementToBePresent(QuickLoanWithVasPage.objHaveAnotherReference, 5, "Have another Reference Screen");
		updateContactReference(propertyFileReader("ReferenceNumber2", "QuickLoanWithVas"));
		isThisYourCurrentAddressConfirmation();
		waitForElementToBePresent(QuickLoanWithVasPage.objMonthlyIncomeScreen,5,"Monthly Income Screen");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("MonthlyIncomeScreen", "QuickLoanWithVas"), ": page title");
		click(LoginPage.objBackBtn,"Back button");
		assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("IsThisYourCurrentAddPage","QuickLoanWithVas"),": page title");
		containsValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("IsThisYourCurrentAddPageSubtitle","QuickLoanWithVas"),": page subtitle");
		verifyElementPresentAndClick(QuickLoanWithVasPage.objYesThisMyAddressBtn,getTextVal(QuickLoanWithVasPage.objYesThisMyAddressBtn,": button"));
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("MonthlyIncomeScreen", "QuickLoanWithVas"), ": page title");
		waitTime(3000);
		leavingSoonPageValidation();
		inputIncomeAmountAndNext(propertyFileReader("InvalidIncome","QuickLoanWithVas"));
		inputIncomeAmountAndNext(propertyFileReader("MaxIncome","QuickLoanWithVas"));
		inputIncomeAmountAndNext(propertyFileReader("ValidIncome","QuickLoanWithVas"));
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("InputCompanyScreen", "QuickLoanWithVas"), ": page title");
		assertionValidation(getText(LoginPage.objPageSubTitle), propertyFileReader("InputCompanyScreenSubtitle", "QuickLoanWithVas"), ": page subtitle");
		leavingSoonPageValidation();
		click(LoginPage.objBackBtn,"Back button");
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("MonthlyIncomeScreen", "QuickLoanWithVas"), ": page title");
		verifyElementPresentAndClick(OnBoardingPage.objNextBtn,getTextVal(OnBoardingPage.objNextBtn,": button"));
		verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": page title"));
		assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("InputCompanyScreen", "QuickLoanWithVas"), ": page title");
		type(QuickLoanWithVasPage.objCompanyInputField,propertyFileReader("Company","QuickLoanWithVas"),"Company Input Field");
		verifyElementPresentAndClick(QuickLoanWithVasPage.objUpdateButton,getTextVal(QuickLoanWithVasPage.objUpdateButton,": button"));


	}
}
