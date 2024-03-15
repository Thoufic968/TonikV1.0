package com.businessFunctions;

import com.driverInstance.DriverManager;
import com.pageObjects.pages.AndroidPages.*;
import com.utility.ExtentReporter;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.utility.Utilities.*;
public class TopUpModule extends BaseClass{
    public TopUpModule() {
        super();
    }
    /**
     * Generalized method for Top-up options
     * @throws Exception
     */
    public static void topUpOptions() throws Exception {
        if (verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"))) {
            String sPageTitle = getText(LoginPage.objPageTitle);
            String sExceptedTitle = "Top up options";
            assertionValidation(sPageTitle, sExceptedTitle,": Top options");
            List<WebElement> values = findElements(TopUpPage.objTopUpOptions);
            for (int topUpOption = 0; topUpOption < values.size(); topUpOption++) {
                String displayedItem = values.get(topUpOption).getText();
                logger.info("Top-up option : '" + displayedItem + "' is displayed");
                ExtentReporter.extentLogger(" ", "Top-up option : '" + displayedItem + "' is displayed");
            }
            verifyElementPresent(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        }
    }
    /**
     * Generalized method for Top-up using PESONet Or InstaPay Page Validation
     * @throws Exception
     */
    public void topUpUsingPESONetOrInstaPayPageValidation() throws Exception {
        if (verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"))) {
            assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("TopUpBankScreen","TopUp"),"Page title");
            verifyElementPresent(LoginPage.objPageSubTitle,getTextVal(LoginPage.objPageSubTitle,": SubTitle"));
            verifyElementPresent(TopUpPage.objNameHeader,getTextVal(TopUpPage.objNameHeader,": Header"));
            verifyElementPresent(TopUpPage.objAccountHolderNameDisplayed,getTextVal(TopUpPage.objAccountHolderNameDisplayed,": Account holder name"));
            verifyElementPresent(TopUpPage.objAccountHolderNameCopyIcon,"Account holder name copy icon");
            verifyElementPresent(TopUpPage.objBankHeader,getTextVal(TopUpPage.objBankHeader,": Header"));
            verifyElementPresent(TopUpPage.objBankNameDisplayed,getTextVal(TopUpPage.objBankNameDisplayed,": Bank name"));
            verifyElementPresent(TopUpPage.objTonikAccountNumberHeader,getTextVal(TopUpPage.objTonikAccountNumberHeader,": Header"));
            verifyElementPresent(TopUpPage.objTonikAccountNumberDisplayed,getTextVal(TopUpPage.objTonikAccountNumberDisplayed,": Tonik Account number"));
            verifyElementPresent(TopUpPage.objTonikAccountNumberCopyIcon,"Tonik Account number copy icon");
            verifyElementPresent(TopUpPage.objReminderHeader,getTextVal(TopUpPage.objReminderHeader,": Header"));
            List<WebElement> values = findElements(TopUpPage.objReminders);
            for (int reminder = 0; reminder < values.size(); reminder++) {
                String displayedItem = values.get(reminder).getText();
                logger.info("Remainder : '" + displayedItem + "' is displayed");
                ExtentReporter.extentLogger(" ", "Remainder : '" + displayedItem + "' is displayed");
            }
            verifyElementPresent(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        }
    }
    /**
     * Generalized method for Top-up via gcash page UI Validation
     * @throws Exception
     */
    public void topUpViaGCashPage() throws Exception {
        if (verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"))) {
            assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpAmountPage","TopUp"),": Page title");
            verifyElementPresent(TopUpPage.objAvailableBalance,getTextVal(TopUpPage.objAvailableBalance,""));
            verifyElementPresent(TopUpPage.objMaxTransaction,getTextVal(TopUpPage.objMaxTransaction,": Max transaction amount"));
            verifyElementPresent(TopUpPage.objTransactionFee,getTextVal(TopUpPage.objTransactionFee,""));
            verifyElementPresent(TopUpPage.objTopUPInfo,getTextVal(TopUpPage.objTopUPInfo,": Top-up Info"));
            verifyElementPresent(TopUpPage.objNextButton,getTextVal(TopUpPage.objNextButton,": Button"));
            verifyElementPresent(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        }
    }
    /**
     * Generalized method for Online Topup options validation
     * @throws Exception
     */
    public void onlineTopUpOptions() throws Exception {
        waitForElementToBePresent(TopUpPage.objOnlineTopUpOptions,5,"Online TopUp options");
        if (verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"))) {
            assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("OnlineTopUpOptions","TopUp"),": Page title");
            List<WebElement> values = findElements(TopUpPage.objOnlineTopUpOptions);
            for (int topUpOption = 0; topUpOption < values.size(); topUpOption++) {
                String displayedItem = values.get(topUpOption).getText();
                logger.info("Online Top-up option : '" + displayedItem + "' is displayed");
                ExtentReporter.extentLogger(" ", "Online Top-up option : '" + displayedItem + "' is displayed");
            }
            verifyElementPresent(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        }
    }
    /**
     * Generalized method for Transaction details page validation
     * @throws Exception
     */
    public void transactionDetailsValidation() throws Exception {
        waitForElementToBePresent(SendMoneyPage.objTransactionDetails,3,"Transaction details");
        verifyElementPresent(SendMoneyPage.objTransactionDetails,getTextVal(SendMoneyPage.objTransactionDetails,": title"));
        List<WebElement> values1 = findElements(SendMoneyPage.objTransactionDetailsInfo);
        for (int transactionDetails = 1; transactionDetails <= values1.size(); transactionDetails++) {
            if(transactionDetails%2!=0) {
                verifyElementPresent(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),getTextVal(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),": transaction details header"));
            }else{
                verifyElementPresent(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),getTextVal(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),": "+getText(SendMoneyPage.objTransactionDetailsInfo(transactionDetails-1))));
            }
        }
    }
    /**
     * Common method to input amount and click on next
     * @param sAmount
     * @throws Exception
     */
    public void inputAmountAndClickNext(String sAmount) throws Exception {
        type(TopUpPage.objAmountInputField,sAmount,"Amount Input field");
        click(TopUpPage.objNextButton,getTextVal(TopUpPage.objNextButton,": Button"));
    }
    /**
     * Common method to select Online transaction
     * @param onlineTransactionType
     * @throws Exception
     */
    public void selectOnlineTransaction(By onlineTransactionType) throws Exception {
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"));
        assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpOptions","TopUp"),": Page title");
        click(TopUpPage.objTopUpOption("Online"),getTextVal(TopUpPage.objTopUpOption("Online"),": Top-up option"));
        click(onlineTransactionType,getTextVal(onlineTransactionType,": Online Top-up Option"));
    }
    /**
     * Common method to Next button
     * @throws Exception
     */
    public void leaveAmountInputFieldValidateNextButton() throws Exception {
        clearField(TopUpPage.objAmountInputField,"Amount input field");
        assertionValidation(getAttributValue("enabled",LoginPage.objNextButton),"false",": Enable Attribute value");
    }
    /**
     * Method to Verify the user can access the Top up module if TSA is not created
     * @throws Exception
     */
    public void accessTopUpModuleIfTSANotCreated_TDB_TU_001() throws Exception {
        HeaderChildNode("TDB_TU_001, Top-up - Verify the user can access the Top up module if TSA is not created");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        topUpOptions();
        click(TopUpPage.objTopUpOption("PESONet or InstaPay"),getTextVal(TopUpPage.objTopUpOption("PESONet or InstaPay"),": Top-up option"));
        verifyElementPresent(TopUpPage.objPopupHeader,getTextVal(TopUpPage.objPopupHeader,": popup header"));
        assertionValidation(getText(TopUpPage.objPopupHeader),propertyFileReader("ReadyToStartPopup","TopUp"),": Popup header");
        assertionValidation(getText(TopUpPage.objPopupDescription),propertyFileReader("ReadyToStartPopupDescription","TopUp"),": Popup Description");
        click(TopUpPage.objNotYetButton,getTextVal(TopUpPage.objNotYetButton,": button"));
        if(verifyElementPresent(LoginPage.objProfileName,getTextVal(LoginPage.objProfileName,": Profile name"))){
            verifyElementPresent(OnBoardingPage.objHistoryIcon, "History icon");
            assertionValidation(getAttributValue("enabled", OnBoardingPage.objHistoryIcon), "false", ": History icon");
            logger.info("TDB_TU_001, Top-up - User can't access the Top up module if TSA is not created validated");
            extentLoggerPass("TDB_TU_001", "TDB_TU_001, Top-up - User can't access the Top up module if TSA is not created validated");
        }
    }
    /**
     * Method to Verify the user can access the Top up module if TSA is created
     * @throws Exception
     */
    public void accessTopUpModuleIfTSAIsCreated_TDB_TU_002() throws Exception {
        HeaderChildNode("TDB_TU_002, Top-up - Verify the user can access the Top up module if TSA is created");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        topUpOptions();
        click(TopUpPage.objTopUpOption("PESONet or InstaPay"),getTextVal(TopUpPage.objTopUpOption("PESONet or InstaPay"),": Top-up option"));
        verifyElementPresent(TopUpPage.objPopupHeader,getTextVal(TopUpPage.objPopupHeader,": popup header"));
        assertionValidation(getText(TopUpPage.objPopupHeader),propertyFileReader("ReadyToStartPopup","TopUp"),": Popup header");
        assertionValidation(getText(TopUpPage.objPopupDescription),propertyFileReader("ReadyToStartPopupDescription","TopUp"),": Popup Description");
        click(TopUpPage.objYesIWantToTopUp,getTextVal(TopUpPage.objYesIWantToTopUp,": button"));
        click(LoginPage.objBackBtn,"Back button");
        if(verifyElementPresent(LoginPage.objProfileName,getTextVal(LoginPage.objProfileName,": Profile name"))){
            verifyElementPresent(OnBoardingPage.objHistoryIcon, "History icon");
            assertionValidation(getAttributValue("enabled", OnBoardingPage.objHistoryIcon), "false", ": History icon");
            logger.info("TDB_TU_002, Top-up - user can access the Top up module if TSA is created validated");
            extentLoggerPass("TDB_TU_002", "TDB_TU_002, Top-up - user can access the Top up module if TSA is created validated");
        }
    }
    /**
     * Method to Verify if account holder can copy the account details from the PESONet or InstaPay screen
     * @throws Exception
     */
    public void topUpCopyAccountDetailsFromPESONetAndInstaPayValidation_TDB_TU_003() throws Exception {
        HeaderChildNode("TDB-TU-003, Top-up - Verify if account holder can copy the account details from the PESONet or InstaPay screen");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        topUpOptions();
        click(TopUpPage.objTopUpOption("PESONet or InstaPay"),getTextVal(TopUpPage.objTopUpOption("PESONet or InstaPay"),": Top-up option"));
        waitForElementToBePresent(TopUpPage.objTopUpBankScreen,5,"Top up bank screen");
        topUpUsingPESONetOrInstaPayPageValidation();
        click(TopUpPage.objAccountHolderNameCopyIcon,"Account holder name copy icon");
        waitForElementToBePresent(TopUpPage.objCopyToClipBoardMsg,5,"Copied to click board message");
        valueValidation(getText(TopUpPage.objCopyToClipBoardMsg),propertyFileReader("ExceptedCopiedMsg","TopUp"),"Excepted Copied message","equals");
        click(TopUpPage.objTonikAccountNumberCopyIcon,"Account holder name copy icon");
        waitForElementToBePresent(TopUpPage.objCopyToClipBoardMsg,5,"Copied to click board message");
        valueValidation(getText(TopUpPage.objCopyToClipBoardMsg),propertyFileReader("ExceptedCopiedMsg","TopUp"),"Excepted Copied message","equals");
        click(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        waitForElementToBePresent(TopUpPage.objTopUpOptions,5,"Top Up Options");
        if(verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"))) {
            valueValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpOptions","TopUp"),"page title","equals");
            logger.info("TDB-TU-003, Top-up - Account holder can copy the account details from the PESONet or InstaPay screen validated");
            extentLoggerPass("TDB-TU-003", "TDB-TU-003, Top-up - Account holder can copy the account details from the PESONet or InstaPay screen validated");
        }
    }
    /**
     * Method to Verify if account holder can Top up via GCash Account
     * @param sInvalidAmount
     * @param sValidAmount
     * @throws Exception
     */
    public void topUpViaGCashAccount_TDB_TU_004(String sInvalidAmount,String sValidAmount) throws Exception {
        HeaderChildNode("TDB_TU_004, Top-up - Verify if account holder can Top up via GCash Account");
        tonikLogin(propertyFileReader("password","TopUp"));
        String sAvailableBalanceBeforeTopUp = getText(LoginPage.objAvailableBalance);
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        topUpOptions();
        click(TopUpPage.objTopUpOption("Online"),getTextVal(TopUpPage.objTopUpOption("Online"),": Top-up option"));
        onlineTopUpOptions();
        click(TopUpPage.objGCashOnlineOption,getTextVal(TopUpPage.objGCashOnlineOption,": Online Top-up Option"));
        topUpViaGCashPage();
        inputAmountAndClickNext(sInvalidAmount);
        inputAmountAndClickNext(sValidAmount);
        verifyElementPresent(TopUpPage.objTopUpViaGCash, getTextVal(TopUpPage.objTopUpViaGCash, ": Page Title"));
        click(TopUpPage.objProceedToPayButton,getTextVal(TopUpPage.objProceedToPayButton,": Button"));
        verifyElementPresent(TopUpPage.objTransactionStatusHeader,getTextVal(TopUpPage.objTransactionStatusHeader,": Status"));
        containsValidation(getText(TopUpPage.objTransactionInfo),propertyFileReader("TransactionInfo","TopUp"),": Transaction Info");
        verifyElementPresentAndClick(LoginPage.objViewTransactionLink,getTextVal(LoginPage.objViewTransactionLink,": Link"));
        transactionDetailsValidation();
        verifyElementPresentAndClick(TopUpPage.objContactUsIconInTransactionDetails,getTextVal(LoginPage.objPageTitle,"Contact us Link"));
        contactUsPageUI();
        click(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        waitTime(3000);// Time required to load entire page
        click(LoginPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        waitForElementToBePresent(TopUpPage.objButtonDisplayedInTransactionInfoPage,5,"");
        click(TopUpPage.objButtonDisplayedInTransactionInfoPage,getTextVal(TopUpPage.objButtonDisplayedInTransactionInfoPage,": Button"));
        verifyElementPresent(LoginPage.objAvailableBalance,getTextVal(LoginPage.objAvailableBalance,": Available balance after Top-up"));
        String sAvailableBalanceAfterTopUp = getText(LoginPage.objAvailableBalance);
        if(sAvailableBalanceAfterTopUp!=sAvailableBalanceBeforeTopUp){
            logger.info("TDB_TU_004, Top-up - Account holder successfully Topped up via GCash Account");
            extentLoggerPass("TDB_TU_004", "TDB_TU_002, Top-up - Account holder successfully Topped up via GCash Account");
        }else{
            logger.info("TDB_TU_004, Top-up - Account holder can't able Top up via GCash Account");
            extentLoggerPass("TDB_TU_004", "TDB_TU_002, Top-up - Account holder can't able Top up via GCash Account");
        }
    }
    /**
     * Method to Verify if user can Top up beyond the maximum limit of GCash
     * @param sAmount
     * @throws Exception
     */
    public void topUpBeyondMaxLimitOfGCashValidation_TDB_TU_005(String sAmount) throws Exception {
        HeaderChildNode("TDB_TU_005, Top-up - Verify if user can Top up beyond the maximum limit of GCash");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        selectOnlineTransaction(TopUpPage.objGCashOnlineOption);
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"));
        assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpAmountPage","TopUp"),": Page title");
        inputAmountAndClickNext(sAmount);
        if(verifyElementPresent(TopUpPage.objMaxTransactionErrorMsg,getTextVal(TopUpPage.objMaxTransactionErrorMsg,": Error message"))) {
            containsValidation(getText(TopUpPage.objMaxTransactionErrorMsg), propertyFileReader("ExceptedErrorMsg", "TopUp"), ": Error message");
            logger.info("TDB_TU_005, Top-up - User can't Top up beyond the maximum limit of GCash validated");
            extentLoggerPass("TDB_TU_005", "TDB_TU_005, Top-up - User can't Top up beyond the maximum limit of GCash validated");
        }
    }
    /**
     * Method to Verify if user can Top up beyond the maximum limit of BPI
     * @param sAmount
     * @throws Exception
     */
    public void topUpBeyondMaxLimitOfBPIValidation_TDB_TU_007(String sAmount) throws Exception {
        HeaderChildNode("TDB_TU_007, Top-up - Verify if user can Top up beyond the maximum limit of BPI");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        selectOnlineTransaction(TopUpPage.objBPIOnlineOption);
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"));
        assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpAmountPage","TopUp"),": Page title");
        leaveAmountInputFieldValidateNextButton();
        inputAmountAndClickNext(sAmount);
        if(verifyElementPresent(TopUpPage.objMaxTransactionErrorMsg,getTextVal(TopUpPage.objMaxTransactionErrorMsg,": Error message"))) {
            containsValidation(getText(TopUpPage.objMaxTransactionErrorMsg), propertyFileReader("BPIMaxTransactionErrorMsg", "TopUp"), ": Error message");
            logger.info("TDB_TU_007, Top-up - User can't Top up beyond the maximum limit of BPI validated");
            extentLoggerPass("TDB_TU_007", "TDB_TU_007, Top-up - Top-up - User can't Top up beyond the maximum limit of BPI validated");
        }
    }
    /**
     * Method to Verify if user can Top up beyond the maximum limit of Chinabank
     * @param sAmount
     * @throws Exception
     */
    public void topUpBeyondMaxLimitOfChinaBankValidation_TDB_TU_009(String sAmount) throws Exception {
        HeaderChildNode("TDB_TU_009, Top-up - Verify if user can Top up beyond the maximum limit of Chinabank");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        selectOnlineTransaction(TopUpPage.objChinaBankOnlineOption);
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"));
        assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpAmountPage","TopUp"),": Page title");
        leaveAmountInputFieldValidateNextButton();
        inputAmountAndClickNext(sAmount);
        if(verifyElementPresent(TopUpPage.objMaxTransactionErrorMsg,getTextVal(TopUpPage.objMaxTransactionErrorMsg,": Error message"))) {
            containsValidation(getText(TopUpPage.objMaxTransactionErrorMsg), propertyFileReader("ChinaBankMaxTransactionErrorMsg", "TopUp"), ": Error message");
            logger.info("TDB_TU_009, Top-up - User can't Top up beyond the maximum limit of Chinabank validated");
            extentLoggerPass("TDB_TU_009", "TDB_TU_009, Top-up - Top-up - User can't Top up beyond the maximum limit of Chinabank validated");
        }
    }
    /**
     * Method to Verify if user can Top up beyond the maximum limit of RCBC
     * @param sAmount
     * @throws Exception
     */
    public void topUpBeyondMaxLimitOfRCBCValidation_TDB_TU_011(String sAmount) throws Exception {
        HeaderChildNode("TDB_TU_011, Top-up - Verify if user can Top up beyond the maximum limit of RCBC");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        selectOnlineTransaction(TopUpPage.objRCBCOnlineOption);
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"));
        assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpAmountPage","TopUp"),": Page title");
        leaveAmountInputFieldValidateNextButton();
        inputAmountAndClickNext(sAmount);
        if(verifyElementPresent(TopUpPage.objMaxTransactionErrorMsg,getTextVal(TopUpPage.objMaxTransactionErrorMsg,": Error message"))) {
            containsValidation(getText(TopUpPage.objMaxTransactionErrorMsg), propertyFileReader("RCBCMaxTransactionErrorMsg", "TopUp"), ": Error message");
            logger.info("TDB_TU_011, Top-up - User can't Top up beyond the maximum limit of RCBC validated");
            extentLoggerPass("TDB_TU_011", "TDB_TU_011, Top-up - Top-up - User can't Top up beyond the maximum limit of RCBC validated");
        }
    }
    /**
     * Method to Verify if user can Top up beyond the maximum limit of Unionbank
     * @param sAmount
     * @throws Exception
     */
    public void topUpBeyondMaxLimitOfUnionBankValidation_TDB_TU_013(String sAmount) throws Exception {
        HeaderChildNode("TDB_TU_013, Top-up - Verify if user can Top up beyond the maximum limit of Unionbank");
        tonikLogin(propertyFileReader("password","TopUp"));
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        selectOnlineTransaction(TopUpPage.objUnionBankOnlineOption);
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": Page Title"));
        assertionValidation(getText(LoginPage.objPageTitle), propertyFileReader("TopUpAmountPage","TopUp"),": Page title");
        leaveAmountInputFieldValidateNextButton();
        inputAmountAndClickNext(sAmount);
        if(verifyElementPresent(TopUpPage.objMaxTransactionErrorMsg,getTextVal(TopUpPage.objMaxTransactionErrorMsg,": Error message"))) {
            containsValidation(getText(TopUpPage.objMaxTransactionErrorMsg), propertyFileReader("UnionBankMaxTransactionErrorMsg", "TopUp"), ": Error message");
            logger.info("TDB_TU_013, Top-up - User can't Top up beyond the maximum limit of Unionbank validated");
            extentLoggerPass("TDB_TU_013", "TDB_TU_013, Top-up - Top-up - User can't Top up beyond the maximum limit of Unionbank validated");
        }
    }
}
