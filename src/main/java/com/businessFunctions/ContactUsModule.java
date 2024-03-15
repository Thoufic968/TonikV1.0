package com.businessFunctions;

import com.driverInstance.DriverManager;
import com.pageObjects.pages.AndroidPages.ContactUsPage;
import com.pageObjects.pages.AndroidPages.LoginPage;
//import com.pageObjects.pages.AndroidPages.SendMoneyPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utility.Utilities.*;
public class ContactUsModule extends BaseClass{
    public ContactUsModule() {
        super();
    }
    /**
     * Generalized method to navigate to Contact us page
     * @throws Exception
     */
    public void navigateToContactUs() throws Exception {
        verifyElementPresentAndClick(ContactUsPage.objQuestionMarkIcon,"Contact us, Question mark Icon");
        String sPageHeader = getText(ContactUsPage.objPageHeader);
        String sExceptedPageHeader = "Get in touch";
        assertionValidation(sPageHeader,sExceptedPageHeader,": Page title");
    }
    /**
     * Generalized method to validate Contact us User interface
     * @throws Exception
     */
    public void contactUsPageUI() throws Exception {
        verifyElementPresent(ContactUsPage.objPageHeader,getTextVal(ContactUsPage.objPageHeader," : Page Header"));
        if (verifyElementDisplayed(ContactUsPage.objGetInTouchInfo)) {
            List<WebElement> values = findElements(ContactUsPage.objGetInTouchInfo);
            for (int info = 0; info < values.size(); info++) {
                if(info%2==0) {
                    String displayedItem = values.get(info).getText();
                    logger.info("Info : '" + displayedItem + "' is displayed");
                    ExtentReporter.extentLogger(" ", "Info : '" + displayedItem + "' is displayed");
                }
            }
        }
        verifyElementPresent(ContactUsPage.objChatWithUs,getTextVal(ContactUsPage.objChatWithUs,"Contact Option"));
        verifyElementPresent(ContactUsPage.objContactNumber,getTextVal(ContactUsPage.objContactNumber,"Contact Number"));
        verifyElementPresent(ContactUsPage.objFrequentlyAskedQuestion,getTextVal(ContactUsPage.objFrequentlyAskedQuestion,""));
        verifyElementPresent(ContactUsPage.objBackBtn,getTextVal(ContactUsPage.objPageHeader,": Page Back button"));
    }
    /**
     * Method to Verify if account holder can view the Get in touch options
     * @throws Exception
     */
    public void contactUsPageUIValidation_TDB_CU_001() throws Exception {
        HeaderChildNode("TDB-CU-001, Contact Us - Verify if account holder can view the Get in touch options");
        tonikLogin(propertyFileReader("password","ContactUs"));
        navigateToContactUs();
        contactUsPageUI();
        click(ContactUsPage.objBackBtn,getTextVal(ContactUsPage.objPageHeader," : Page Back button"));
        if(verifyElementPresent(LoginPage.objProfileName,getTextVal(LoginPage.objProfileName," : Profile Name"))) {
            logger.info("TDB-CU-001, Contact Us - Account holder can view the Get in touch options and navigation back to dashboard is validated");
            extentLoggerPass("TDB-CU-001", "TDB-CU-001, Contact Us - Account holder can view the Get in touch options and navigation back to dashboard is validated");
        }
    }
    /**
     * Method to Verify if account holder can select Ask the Tonik chatBot
     * @throws Exception
     */
    public void contactUsContactUsingChatWithUsOption_TDB_CU_002() throws Exception {
        HeaderChildNode("TDB-CU-002, Contact Us - Verify if account holder can select Ask the Tonik chatBot");
        tonikLogin(propertyFileReader("password","ContactUs"));
        navigateToContactUs();
        contactUsPageUI();
        click(ContactUsPage.objChatWithUs,getTextVal(ContactUsPage.objChatWithUs,"Contact Option"));
        waitForElementToBePresent(ContactUsPage.objChatBoxTonikIcon,10,"Chat Box Tonik Icon");
        verifyElementPresent(ContactUsPage.objChatBoxTonikIcon,"Chat Box Tonik Icon");
        type(ContactUsPage.objChatInputField,propertyFileReader("Chat","Onboarding"),"Chat input field");
        verifyElementPresentAndClick(ContactUsPage.objSendButton,"Send Button");
        List<WebElement> values = findElements(ContactUsPage.objUserMessages);
        int userMessages = values.size();
        verifyElementPresent(ContactUsPage.objUserLatestMessage(userMessages),getTextVal(ContactUsPage.objUserLatestMessage(userMessages)," : User latest message"));
        List<WebElement> values1 = findElements(ContactUsPage.objUserMessages);
        int botMessages = values1.size()+1;
        waitForElementToBePresent(ContactUsPage.objBotLatestReplayMessage(botMessages),10,"Bot message");
        verifyElementPresent(ContactUsPage.objBotLatestReplayMessage(botMessages),getTextVal(ContactUsPage.objBotLatestReplayMessage(botMessages)," : Bot latest replay message"));
        verifyElementPresentAndClick(ContactUsPage.objChatBoxBackButton,"ChatBot Box back button");
        if(verifyElementPresent(ContactUsPage.objPageHeader,getTextVal(ContactUsPage.objPageHeader," ; Page Header"))){
            valueValidation(getText(ContactUsPage.objPageHeader),propertyFileReader("GetInTouchPageTitle","ContatUs"),"Page title","equals");
            logger.info("TDB-CU-002, Contact Us - Account holder can select Ask the Tonik chatBot, chat, replay and navigation back to Get in touch page is validated");
            extentLoggerPass("TDB-CU-002", "TDB-CU-001, Contact Us - Account holder can select Ask the Tonik chatBot, chat, replay and navigation back to Get in touch page is validated");
        }
    }
    /**
     * Method to Verify if account holder can select the +63 253222645
     * @throws Exception
     */
    public void contactUsContactUsingContactNumberDisplayed_TDB_CU_003() throws Exception {
        HeaderChildNode("TDB-CU-003, Contact Us - Verify if account holder can select the +63 253222645");
        tonikLogin(propertyFileReader("password","ContactUs"));
        navigateToContactUs();
        contactUsPageUI();
        String sContactNumberDisplayed = getText(ContactUsPage.objContactNumber);
        String sContactNumber = sContactNumberDisplayed.replaceAll(" ","").trim();
        click(ContactUsPage.objContactNumber,getTextVal(ContactUsPage.objContactNumber,"Contact Number"));
        if(verifyElementPresent(ContactUsPage.objDialPadNumber,getTextVal(ContactUsPage.objDialPadNumber,"Dial Pad Number"))) {
            valueValidation(getText(ContactUsPage.objDialPadNumber),sContactNumber,"Dial pad number","equals");
            logger.info("TDB-CU-003, Contact Us - Account holder can select the +63 253222645 and App navigates to dialPad is validated");
            extentLoggerPass("TDB-CU-003", "TDB-CU-003, Contact Us - Account holder can select the +63 253222645 and App navigates to dialPad is validated");
        }
    }
    /**
     * Method to Verify if the account holder can select Frequently Asked Questions
     * @throws Exception
     */
    public void contactUsFrequentlyAskedQuestionsOptionValidation_TDB_CU_011() throws Exception {
        HeaderChildNode("TDB-CU-011, Contact Us - Verify if the account holder can select Frequently Asked Questions");
        tonikLogin(propertyFileReader("password","ContactUs"));
        navigateToContactUs();
        contactUsPageUI();
        click(ContactUsPage.objFrequentlyAskedQuestion,getTextVal(ContactUsPage.objFrequentlyAskedQuestion,""));
        if(verifyElementPresent(ContactUsPage.objTonikWebPageTitle,getTextVal(ContactUsPage.objTonikWebPageTitle," : Page Title"))){
            logger.info("TDB-CU-011, Contact Us - Account holder can select Frequently Asked Questions option and App navigates to Tonik Web page is validated");
            extentLoggerPass("TDB-CU-011", "TDB-CU-011, Contact Us - Account holder can select Frequently Asked Questions option and App navigates to Tonik Web page is validated");
        }
    }
    /**
     * Method to Verify if the user can access the customer care email address
     * @throws Exception
     */
    public void contactUsUserCanAccessCustomerEmailIdValidation_TDB_CU_012() throws Exception {
        HeaderChildNode("TDB-CU-012, Contact Us - Verify if the user can access the customer care email address");
        tonikLogin(propertyFileReader("password","ContactUs"));
        navigateToContactUs();
        contactUsPageUI();
        click(ContactUsPage.objCustomerCareMailId,getTextVal(ContactUsPage.objCustomerCareMailId," : Customer care mail id"));
        verifyElementPresent(ContactUsPage.objToFieldInMailPage,getTextVal(ContactUsPage.objToFieldInMailPage," : To field in mail page"));
        String sMailPageAutoPopulatedMailId = getText(ContactUsPage.objToFieldInMailPage);
        valueValidation(sMailPageAutoPopulatedMailId,propertyFileReader("MailId","ContactUs"),"MailId","equals");
        DriverManager.getAppiumDriver().navigate().back();
        DriverManager.getAppiumDriver().navigate().back();
        if(verifyElementPresent(ContactUsPage.objPageHeader,getTextVal(ContactUsPage.objPageHeader," : Header"))){
            valueValidation(getText(ContactUsPage.objPageHeader),propertyFileReader("GetInTouchPageTitle","ContactUs"),"Page title","equals");
            logger.info("TDB-CU-012, Contact Us - User can access the customer care email address is validated");
            extentLoggerPass("TDB-CU-012", "TDB-CU-012, Contact Us - User can access the customer care email address is validated");
        }
    }
    /**
     * Method to Verify if user can access the Contact Us from Login screen
     * @throws Exception
     */
    public void contactUsPageNavigationFromLogInPageValidation_TDB_CU_013() throws Exception {
        HeaderChildNode("TDB-CU-013, Contact Us - Verify if user can access the Contact Us from Login screen");
        waitForElementToBePresent(LoginPage.objEditPassword, 60, "Password edit field");
        verifyElementPresentAndClick(ContactUsPage.objContactUsButton, "Contact us Button");
        if (verifyElementPresent(ContactUsPage.objPageHeader, getTextVal(ContactUsPage.objPageHeader, " : Header"))) {
            valueValidation(getText(ContactUsPage.objPageHeader),propertyFileReader("GetInTouchPageTitle","ContactUs"),"Page title","equals");
            contactUsPageUI();
            logger.info("TDB-CU-013, Contact Us - User can access the Contact Us from Login screen is validated");
            extentLoggerPass("TDB-CU-013", "TDB-CU-013, Contact Us - User can access the Contact Us from Login screen is validated");
        }
    }
}
