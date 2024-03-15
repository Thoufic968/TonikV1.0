package com.businessFunctions;
import com.pageObjects.pages.AndroidPages.*;
import com.pageObjects.pages.AndroidPages.OnBoardingPage;
import com.pageObjects.pages.AndroidPages.SendMoneyPage;
import com.utility.ExtentReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Random;
import static com.businessFunctions.TopUpModule.topUpOptions;
import static com.utility.Utilities.*;
public class SendMoneyModule extends BaseClass {
    public SendMoneyModule() {
        super();
    }
    /**
     * Common method for Send money option page UI related validation
     * @throws Exception
     */
    public void selectSendMoneyOption(By byLocator) throws Exception {
        waitForElementToBePresent(SendMoneyPage.objSendMoneyOptionsPage,3,"Send money page");
        verifyElementPresent(SendMoneyPage.objPageHeader,getTextVal(SendMoneyPage.objPageHeader,": Page Header"));
        assertionValidation(getText(SendMoneyPage.objPageHeader),propertyFileReader("SendMoneyOptions","SendMoney"),": Header");
        click(byLocator,getTextVal(byLocator,": Send Money Option"));
    }
    /**
     * Common method for Tonik number input
     * @param sTonikAccountNumber
     * @throws Exception
     */
    public void inputTonikAccountNumber(String sTonikAccountNumber) throws Exception {
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage,3,"Send money page");
        verifyElementPresent(SendMoneyPage.objSendMoneyPage, getTextVal(SendMoneyPage.objSendMoneyPage, ": title"));
        verifyElementPresentAndClick(SendMoneyPage.objUseTonikAccountLink,getTextVal(SendMoneyPage.objUseTonikAccountLink,": link"));
        waitForElementToBePresent(LoginPage.objPageSubTitle,5,"Recipient Account number page");
        verifyElementPresent(LoginPage.objPageSubTitle,getTextVal(LoginPage.objPageSubTitle," : Page Subtitle"));
        assertionValidation(getText(LoginPage.objPageSubTitle),propertyFileReader("RecipientAccNumber","SendMoney"),": Page Subtitle");
        type(SendMoneyPage.objAccNumberInputField,sTonikAccountNumber,"Account number input field");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 5, "Send Money page");
    }
    /**
     * Common method for Validating the Send money to bank via, dropdown UI related validation
     * @throws Exception
     */
    public void sendMoneyToBankViaDropdownValidation() throws Exception {
        verifyElementPresent(SendMoneyPage.objSendMoneyViaDropdown,getTextVal(SendMoneyPage.objSendMoneyViaDropdown,": Dropdown header"));
        verifyElementPresent(SendMoneyPage.objPesonetOption,getTextVal(SendMoneyPage.objPesonetOption,": Send money to bank option"));
        verifyElementPresent(SendMoneyPage.objPesonetTransactionLimit,getTextVal(SendMoneyPage.objPesonetTransactionLimit,": Pesonet transaction limit"));
        verifyElementPresent(SendMoneyPage.objInstaPayOption,getTextVal(SendMoneyPage.objInstaPayOption,": Send money to bank option"));
        verifyElementPresent(SendMoneyPage.objInstaPayTransactionLimit,getTextVal(SendMoneyPage.objInstaPayTransactionLimit,": InstaPay transaction limit"));
    }
    /**
     * Common method for select Send money to bank option and Related UI Validation
     * @throws Exception
     */
    public void selectSendMoneyToBankOption(By selectSendMoneyOption) throws Exception {
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage,5,"Send Money page");
        if(verifyElementPresent(SendMoneyPage.objPageHeader,getTextVal(SendMoneyPage.objPageHeader,": Page Header"))) {
            verifyElementPresentAndClick(SendMoneyPage.objSendMoneyToBankOptionsDropdown,"Send Money to Bank options dropdown");
            sendMoneyToBankViaDropdownValidation();
            click(selectSendMoneyOption,getTextVal(selectSendMoneyOption,": Send money to bank option"));
            waitForElementToBePresent(SendMoneyPage.objSendMoneyPage,5,"Send Money page");
            verifyElementPresent(selectSendMoneyOption,getTextVal(selectSendMoneyOption,": Selected Send Money option"));
        }
    }
    /**
     * Common method for select Send money to tonik user option and Related UI Validation
     * @throws Exception
     */
    public void selectSendMoneyToTonikAccount() throws Exception {
        if(verifyElementPresent(SendMoneyPage.objPageHeader,getTextVal(SendMoneyPage.objPageHeader,": Page Header"))) {
            verifyElementPresent(SendMoneyPage.objRecipientMobileNumber, getTextVal(SendMoneyPage.objRecipientMobileNumber, ": Recipient number"));
            verifyElementPresent(SendMoneyPage.objCurrentBalance, getTextVal(SendMoneyPage.objCurrentBalance, ""));
            verifyElementPresent(SendMoneyPage.objTransactionFee, getTextVal(SendMoneyPage.objTransactionFee, ""));
            verifyElementPresent(SendMoneyPage.objNextBtn, getTextVal(SendMoneyPage.objNextBtn, "Next Button"));
            String sNextBtnAttribute = getAttributValue("enabled", SendMoneyPage.objNextBtn);
            assertionValidation(sNextBtnAttribute, "false",": Enable attribute value");
            verifyElementPresent(SendMoneyPage.objBackBtn, getTextVal(SendMoneyPage.objPageHeader, "back button"));
        }
    }
    /**
     * Common method for getting Available balance for TSA and Incrementing value by 1 for negative validation
     * @return
     * @throws Exception
     */
    public static String getAvailableAndIncreaseValue() throws Exception {
        String sAvailableBalance = getText(OnBoardingPage.objAvailableBalance);
        String sTrimAvailableBalance = sAvailableBalance.replace(",","");
        String STrim = sTrimAvailableBalance.replace("₱","");
        float fAvailableValue = Float.parseFloat(STrim);
        float fAmountInput = fAvailableValue+1;
        String sAmountInput = String.valueOf(fAmountInput);
        return sAmountInput;
    }
    /**
     * Common method to get available balance
     * @return
     * @throws Exception
     */
    public static String sBalance() throws Exception {
        String sAvailableBalance = getText(OnBoardingPage.objAvailableBalance);
        String sTrimAvailableBalance = sAvailableBalance.replace(",","");
        String STrim = sTrimAvailableBalance.replace("₱","");
        float fAvailableValue = Float.parseFloat(STrim);
        String sAmountInput = String.valueOf(fAvailableValue);
        return sAmountInput;
    }
    /**
     * Generalized method for adding amount to amount input field and adding the purpose to purpose dropdown
     * @param amount
     * @param purpose
     * @throws Exception
     */
    public void addMoneyAndPurpose(String amount,String purpose) throws Exception {
        type(SendMoneyPage.objAmountInputField,amount,"Amount input field");
        verifyElementPresentAndClick(SendMoneyPage.objPurposeDropdown,"Purpose Dropdown");
        purposesValidation();
        verifyElementPresentAndClick(SendMoneyPage.objPurpose(1),getTextVal(SendMoneyPage.objPurpose(1),": Purpose"));
    }
    /**
     * Common method to validate bank and select the bank
     * @param Bank
     * @throws Exception
     */
    public void validateBankListAndSelect(String Bank) throws Exception {
        click(SendMoneyPage.objBankNameEditField,"Bank name edit field");
        waitForElementToBePresent(SendMoneyPage.objFindYourBankPage,5,"Find your bank page");
        List<WebElement> values = findElements(OnBoardingPage.objList);
        for (int bank = 0; bank < values.size(); bank++) {
            String displayedItem = values.get(bank).getText();
            logger.info("Bank : '" + displayedItem + "' is displayed");
            ExtentReporter.extentLogger(" ", "Bank : '" + displayedItem + "' is displayed");
        }
        type(SendMoneyPage.objSearchBank,Bank,": Search bank field");
        click(OnBoardingPage.objList(1),getTextVal(OnBoardingPage.objList(1),": Bank"));
    }
    /**
     * Common method to generate Random Account number
     * @return
     */
    public String generateRandomAccNumber(){
        Random rnd = new Random();
        long min = 1000000000000000L; // 10^15
        long max = 9999999999999999L; // (10^16 - 1)
        long random16DigitNumber = min + ((long) (rnd.nextDouble() * (max - min)));
        String number = String.valueOf(random16DigitNumber);
        return number;
    }
    /**
     * Common method to select Account holder name, bank and account number
     * @param accountHolderName
     * @param bank
     * @param accountNumber
     * @throws Exception
     */
    public void selectAccountInfoAndBank(String accountHolderName,String bank,String accountNumber) throws Exception {
        verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": title"));
        type(SendMoneyPage.objAccountHolderName,accountHolderName,": Account holder name");
        validateBankListAndSelect(bank);
        type(SendMoneyPage.objAccountNumber,accountNumber,": Account number");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
    }
    /**
     * Common method to validate Confirm transaction page validation
     * @throws Exception
     */
    public void confirmTransactionPageValidation() throws Exception {
        waitForElementToBePresent(SendMoneyPage.objConfirmSendMoneyPage,5,"Confirm send money page");
        verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": title"));
        assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("ConfirmSendMoney","SendMoney"),": page title");
        for (int info = 1; info < 8; info++) {
            assertionValidation(getText(SendMoneyPage.objConfirmSendMoneyInfoList(info)),propertyFileReader("ConfirmSendMoneyInfoList"+info,"SendMoney"),"Confirm Send Money Info List");
            verifyElementPresent(SendMoneyPage.objTransactionInfo(propertyFileReader("ConfirmSendMoneyInfoList"+info,"SendMoney")),
                    getTextVal(SendMoneyPage.objTransactionInfo(propertyFileReader("ConfirmSendMoneyInfoList"+info,"SendMoney")), ": "+propertyFileReader("ConfirmSendMoneyInfoList"+info,"SendMoney")));
        }
    }
    /**
     * Common method to validate Confirm send money page for Tonik to tonik customer
     * @throws Exception
     */
    public void confirmSendMoneyPageTonikToTonik() throws Exception {
        waitForElementToBePresent(SendMoneyPage.objConfirmSendMoneyPage,5,"Confirm send money page");
        verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": title"));
        assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("ConfirmSendMoney","SendMoney"),": page title");
        List<WebElement> values = findElements(SendMoneyPage.objTransactionDetailsInfo);
        for (int transactionDetails = 1; transactionDetails <= values.size()-2; transactionDetails++) {
            if(transactionDetails%2!=0) {
                verifyElementPresent(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),getTextVal(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),": header"));
            }else{
                verifyElementPresent(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),getTextVal(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),": "+getText(SendMoneyPage.objTransactionDetailsInfo(transactionDetails-1))));
            }
        }
        verifyElementPresentAndClick(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
    }
    /**
     * Common method to navigate to account history
     * @throws Exception
     */
    public void navigateToAccountHistory() throws Exception {
        verifyElementPresentAndClick(OnBoardingPage.objHistoryIcon,"History Icon");
        verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": title"));
        assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("AccountHistory","SendMoney"),": page title");
    }
    /**
     * Common method to validate transaction summary
     * @throws Exception
     */
    public void transactionSummaryValidation() throws Exception {
        verifyElementPresent(SendMoneyPage.objTransactionSummary,getTextVal(SendMoneyPage.objTransactionSummary,": Header"));
        containsValidation(getText(SendMoneyPage.objTransactionDate), propertyFileReader("TransactionDate","SendMoney"), "");
        containsValidation(getText(SendMoneyPage.objReferenceNo), propertyFileReader("ReferenceNo","SendMoney"), "");
        List<WebElement> values2 = findElements(SendMoneyPage.objTransactionDetailsInfo);
        for (int transactionDetails = 1; transactionDetails <= values2.size(); transactionDetails++) {
            if(transactionDetails%2!=0) {
                verifyElementPresent(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),getTextVal(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),": transaction Summary header"));
            }else{
                verifyElementPresent(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),getTextVal(SendMoneyPage.objTransactionDetailsInfo(transactionDetails),": Transaction Summary "+getText(SendMoneyPage.objTransactionDetailsInfo(transactionDetails-1))));
            }
        }
    }
    /**
     * Common method to validate transaction details
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
     * Generalized method for validating the purposes displayed
     * @throws Exception
     */
    public void purposesValidation() throws Exception {
        if (verifyElementDisplayed(SendMoneyPage.objPurposes)) {
            List<WebElement> values = findElements(SendMoneyPage.objPurposes);
            for (int purpose = 0; purpose < values.size()-1; purpose++) {
                String displayedItem = values.get(purpose).getText();
                logger.info("Purpose : " + displayedItem + " is displayed");
                extentLogger(" ", "Purpose : " + displayedItem + " is displayed");
            }
            for (int purpose = 1; purpose < values.size(); purpose++) {
                click(SendMoneyPage.objPurpose(purpose),getTextVal(SendMoneyPage.objPurpose(purpose),": Purpose"));
                waitForElementToBePresent(SendMoneyPage.objSendMoneyPage,3,"Send Money page");
                assertionValidation(getText(SendMoneyPage.objPurposeEditField),propertyFileReader("Purpose"+purpose,"SendMoney"),": Purpose");
                click(SendMoneyPage.objPurposeEditField,"Purpose Dropdown");
            }
        }
    }
    /**
     * Common method to validate transaction status and transaction details and navigating back to Dashboard
     * @throws Exception
     */
    public void validateTransactionStatusAndDetails() throws Exception {
        waitForElementToBePresent(SendMoneyPage.objScoreStatus,20,"Transaction status");
        verifyElementPresent(SendMoneyPage.objScoreStatus,getTextVal(SendMoneyPage.objScoreStatus,": Transaction status"));
        containsValidation(getText(SendMoneyPage.objTonikToTonikTransactionInfo),propertyFileReader("TonikToTonikTransactionInfo","SendMoney"),": Transaction Information");
        verifyElementPresentAndClick(SendMoneyPage.objViewTransactionDetails,getTextVal(SendMoneyPage.objViewTransactionDetails,": button"));
        transactionDetailsValidation();
        click(LoginPage.objBackBtn,"Back button");
        click(SendMoneyPage.objBackToDashboard,getTextVal(SendMoneyPage.objBackToDashboard,": button"));
    }

//==================================== Test methods ==============================================================//
    /**
     * Method to Verify if a newly onboarded user can access the Send Money without TSA
     * @param password
     * @throws Exception
     */
    public void sendMoneyNewlyOnboardedUserWithNoTSA_TDB_SM_001(String password) throws Exception {
        HeaderChildNode("TDB_SM_001, Send Money - Verify if a newly onboarded user can access the Send Money without TSA");
        tonikLogin(password);
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        verifyElementPresent(SendMoneyPage.objPageHeader,getTextVal(SendMoneyPage.objPageHeader,": Page Header"));
        assertionValidation(getText(SendMoneyPage.objPageHeader),propertyFileReader("SendMoneyOptions","SendMoney"),": Header");
        assertionValidation(getText(SendMoneyPage.objToAnotherBankOption),propertyFileReader("ToAnotherBankOption","SendMoney"),": Send money options");
        assertionValidation(getText(SendMoneyPage.objToAnotherBankOptions),propertyFileReader("ToAnotherBankOptions","SendMoney"),": To Another Bank Options");assertionValidation(getText(SendMoneyPage.objToAnotherTonikCustomerOption),propertyFileReader("ToAnotherTonikCustomerOption","SendMoney"),": Send money options");
        assertionValidation(getText(SendMoneyPage.objProcessingFee),propertyFileReader("ProcessingFee","SendMoney"),": Processing fee");
        verifyElementPresent(SendMoneyPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        waitForElementToBePresent(SendMoneyPage.objPopUpTitle,5,"Send money options page");
        verifyElementPresent(SendMoneyPage.objPopUpTitle,getTextVal(SendMoneyPage.objPopUpTitle,": popup title"));
        assertionValidation(getText(SendMoneyPage.objPopUpTitle),propertyFileReader("PopUpTitle","SendMoney"),": popup title");
        assertionValidation(getText(SendMoneyPage.objPopupDescription),propertyFileReader("PopupDescription","SendMoney"),": popup Description");
        containsValidation(getText(SendMoneyPage.objOkayLetsGoBtn), propertyFileReader("OkayBtn","SendMoney"), ": button");
        click(SendMoneyPage.objEntireScreen,"Entire screen");
        if(verifyElementNotDisplayed(SendMoneyPage.objPopUpTitle,"Pop up title")){
            logger.info("Pop up got closed");
            extentLogger("","Pop up got closed");
        }
        verifyElementPresentAndClick(LoginPage.objBackBtn,"Back button");
        if(verifyElementPresent(LoginPage.objProfileName,getTextVal(LoginPage.objProfileName,": Profile name"))) {
            verifyElementPresent(OnBoardingPage.objHistoryIcon, "History icon");
            assertionValidation(getAttributValue("enabled", OnBoardingPage.objHistoryIcon), "false", ": History icon");
            logger.info("TDB_SM_001, Send Money - Newly onboarded user can't access the Send Money without TSA created and navigated back to Dashboard");
            extentLoggerPass("TDB_SM_001", "TDB_SM_001, Send Money - Newly onboarded user can't access the Send Money without TSA created and navigated back to Dashboard");
        }
    }
    /**
     * Method to Verify if a newly onboarded user can create the TSA from Send Money
     * @param password
     * @throws Exception
     */
    public void createTSAUsingSendMoney__TDB_SM_002(String password) throws Exception {
        HeaderChildNode("TDB_SM_002, Send Money - Verify if a newly onboarded user can create the TSA from Send Money");
        tonikLogin(password);
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        waitForElementToBePresent(SendMoneyPage.objPopUpTitle,5,"Send money options page");
        verifyElementPresent(SendMoneyPage.objPopUpTitle,getTextVal(SendMoneyPage.objPopUpTitle,": popup title"));
        click(SendMoneyPage.objOkayLetsGoBtn,getTextVal(SendMoneyPage.objOkayLetsGoBtn,": button"));
        topUpOptions();
        verifyElementPresentAndClick(LoginPage.objBackBtn,"Back button");
        verifyElementPresent(LoginPage.objProfileName,getTextVal(LoginPage.objProfileName,": Profile name"));
        if(verifyElementPresent(OnBoardingPage.objHistoryIcon, "History icon")) {
            assertionValidation(getAttributValue("enabled", OnBoardingPage.objHistoryIcon), "false", ": History icon");
            logger.info("TDB_SM_002, Send Money - User can create the TSA from Send Money validated");
            extentLoggerPass("TDB_SM_002", "TDB_SM_002, Send Money - User can create the TSA from Send Money validated");
        }
    }
    /**
     * Method to  Verify if user can send money to other bank via PESONet
     * @param password
     * @param sendMoneyOption
     * @param sAmount
     * @param sPurpose
     * @throws Exception
     */
    public void sendMoneyToOtherBankViaPESONet_TDB_SM_005(String password, By sendMoneyOption,String sAmount, String sPurpose) throws Exception {
        HeaderChildNode("TDB_SM_005, Send Money - Verify if user can send money to other bank via PESONet");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        selectSendMoneyToBankOption(sendMoneyOption);
        verifyElementPresent(SendMoneyPage.objCurrentBalance,getTextVal(SendMoneyPage.objCurrentBalance,""));
        verifyElementPresent(SendMoneyPage.objTransactionFee,getTextVal(SendMoneyPage.objTransactionFee,""));
        assertionValidation(getAttributValue("enabled",SendMoneyPage.objNextBtn),"false",": Enable attribute value");
        verifyElementPresent(SendMoneyPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        containsValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionInfo","SendMoney"),": Max Transaction Info");
        addMoneyAndPurpose(sAmount,sPurpose);
        containsValidation(getText(SendMoneyPage.objCutOffMessage),propertyFileReader("CutOffMessage","SendMoney"),": Cut-off message");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        selectAccountInfoAndBank(propertyFileReader("AccountHolderName","SendMoney"),propertyFileReader("Bank","SendMoney"), propertyFileReader("AccountNumber","SendMoney"));
        confirmTransactionPageValidation();
        click(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
        enterOTP();
        waitForElementToBePresent(SendMoneyPage.objPESONetTransactionStatus,5,"Transaction status");
        verifyElementPresent(SendMoneyPage.objPESONetTransactionStatus,getTextVal(SendMoneyPage.objPESONetTransactionStatus,": Transaction status"));
        containsValidation(getText(SendMoneyPage.objPESONetTransactionInformation),propertyFileReader("PESONetTransactionInformation","SendMoney"),": Transaction Information");
        verifyElementPresentAndClick(SendMoneyPage.objViewTransactionDetails,getTextVal(SendMoneyPage.objViewTransactionDetails,": button"));
        transactionDetailsValidation();
        click(LoginPage.objBackBtn,"Back button");
        click(SendMoneyPage.objBackToDashboard,getTextVal(SendMoneyPage.objBackToDashboard,": button"));
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objPESONetTransaction,getTextVal(SendMoneyPage.objPESONetTransaction,": Transaction"));
        transactionSummaryValidation();
        logger.info("TDB_SM_005, Send Money - User can send money to other bank via PESONet validated");
        extentLoggerPass("TDB_SM_005", "TDB_SM_005, Send Money - User can send money to other bank via PESONet validated");
    }
    /**
     * Method to Verify if user can send money to other bank via InstaPay
     * @param password
     * @param sendMoneyOption
     * @param sAmount
     * @param sPurpose
     * @throws Exception
     */
    public void sendMoneyToOtherBankViaInstaPay_TDB_SM_006(String password, By sendMoneyOption,String sAmount, String sPurpose) throws Exception {
        HeaderChildNode("TDB_SM_006, Send Money - Verify if user can send money to other bank via InstaPay");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        selectSendMoneyToBankOption(sendMoneyOption);
        containsValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionInfo","SendMoney"),": Max Transaction Info");
        addMoneyAndPurpose(sAmount,sPurpose);
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        selectAccountInfoAndBank(propertyFileReader("AccountHolderName","SendMoney"),propertyFileReader("InstaPayBank","SendMoney"), propertyFileReader("AccountNumber","SendMoney"));
        confirmTransactionPageValidation();
        click(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
        enterOTP();
        waitForElementToBePresent(SendMoneyPage.objPESONetTransactionStatus,5,"Transaction status");
        verifyElementPresent(SendMoneyPage.objPESONetTransactionStatus,getTextVal(SendMoneyPage.objPESONetTransactionStatus,": Transaction status"));
        click(SendMoneyPage.objViewTransactionDetails,getTextVal(SendMoneyPage.objViewTransactionDetails,": button"));
        transactionDetailsValidation();
        click(LoginPage.objBackBtn,"Back button");
        click(SendMoneyPage.objBackToDashboard,getTextVal(SendMoneyPage.objBackToDashboard,": button"));
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objInstaPayTransaction,getTextVal(SendMoneyPage.objInstaPayTransaction,": Transaction"));
        transactionSummaryValidation();
        logger.info("TDB_SM_006, Send Money - User can send money to other bank via InstaPay validated");
        extentLoggerPass("TDB_SM_006", "TDB_SM_006, Send Money - User can send money to other bank via InstaPay validated");
    }
    /**
     * Method to Verify if user can send money to other bank via InstaPay (insufficient balance)
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyToBankInstaPayInsufficientBalanceValidation_TDB_SM_009(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB-SM-009, Send Money - Verify if user can send money to other bank via InstaPay (insufficient balance)");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        String sAmount = getAvailableAndIncreaseValue();
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        selectSendMoneyToBankOption(selectSendMoneyOption);
        addMoneyAndPurpose(sAmount,"Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        waitForElementToBePresent(SendMoneyPage.objMaxTransactionErrorMsg,5,"Error message");
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionErrorMsg,getTextVal(SendMoneyPage.objMaxTransactionErrorMsg,"Max transaction error message"))){
            assertionValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionErrorMsg","SendMoney"),": Error message");
            logger.info("TDB-SM-009, Send Money - Send transfer to bank via InstaPay Insufficient balance error message validated");
            extentLoggerPass("TDB-SM-009", "TDB-SM-009, Send Money - Send transfer to bank via InstaPay Insufficient balance error message validated");
        }
    }
    /**
     * Method to Verify if user can send money to other banks/e-wallet via PESONET (insufficient balance)
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyToBankPESONetInsufficientBalanceValidation_TDB_SM_010(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB-SM-010, Send Money - Verify if user can send money to other banks/e-wallet via PESONET (insufficient balance)");
        tonikLogin(password);
        String sAmount = getAvailableAndIncreaseValue();
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        selectSendMoneyToBankOption(selectSendMoneyOption);
        addMoneyAndPurpose(sAmount,"Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        waitForElementToBePresent(SendMoneyPage.objMaxTransactionErrorMsg,5,"Error message");
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionErrorMsg,getTextVal(SendMoneyPage.objMaxTransactionErrorMsg,"Max transaction error message"))){
            assertionValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionErrorMsg","SendMoney"),": Error message");
            logger.info("TDB-SM-010, Send Money - Send transfer to bank via InstaPay Insufficient balance error message validated)");
            extentLoggerPass("TDB-SM-010", "TDB-SM-010, Send Money - Send transfer to bank via InstaPay Insufficient balance error message validated");
        }
    }
    /**
     * Method to Verify if user can send money to other Tonik Customer by entering receipient's Mobile Number
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyToTonikCustomerByEnteringRecipientMobileNumber_TDB_SM_011(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_011, Verify if user can send money to other Tonik Customer by entering receipient's Mobile Number");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("ReceiverMobileNumber","SendMoney"));
        verifyElementPresent(SendMoneyPage.objContactsIcon,"Contacts Icon");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 5, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        verifyElementPresent(SendMoneyPage.objContactNumberInfo,getTextVal(SendMoneyPage.objContactNumberInfo,": Contact Number Info"));
        verifyElementPresent(SendMoneyPage.objTransactionFee,getTextVal(SendMoneyPage.objTransactionFee,""));
        assertionValidation(getAttributValue("enabled",SendMoneyPage.objNextBtn),"false",": Enable attribute value");
        verifyElementPresent(SendMoneyPage.objBackBtn,getTextVal(SendMoneyPage.objPageHeader,"back button"));
        verifyElementPresent(SendMoneyPage.objCurrentBalance,getTextVal(SendMoneyPage.objCurrentBalance,""));
        addMoneyAndPurpose("100","Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        confirmSendMoneyPageTonikToTonik();
        enterOTP();
        validateTransactionStatusAndDetails();
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objTonikToTonikSendMoney,getTextVal(SendMoneyPage.objTonikToTonikSendMoney,": Transaction"));
        transactionDetailsValidation();
        logger.info("TDB_SM_011, Send Money - User can send money to other Tonik Customer by entering receipient's Mobile Number validated");
        extentLoggerPass("TDB_SM_011", "TDB_SM_011, Send Money - User can send money to other Tonik Customer by entering receipient's Mobile Number validated");
    }
    /**
     * Method to Verify if user can send money to other Tonik Customer via Contacts
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyToTonikCustomerViaContacts_TDB_SM_012(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_012, Send Money - Verify if user can send money to other Tonik Customer via Contacts");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage,3,"Send money page");
        verifyElementPresent(SendMoneyPage.objSendMoneyPage, getTextVal(SendMoneyPage.objSendMoneyPage, ": title"));
        verifyElementPresentAndClick(SendMoneyPage.objContactsIcon,"Contacts Icon");
        waitForElementToBePresent(OnBoardingPage.objMobileNumberInputField,5,"Contacts Screen");
        type(OnBoardingPage.objMobileNumberInputField,propertyFileReader("ContactName","SendMoney"),": Contact search field");
        click(SendMoneyPage.objSelectContact(propertyFileReader("ContactName","SendMoney")), getTextVal(SendMoneyPage.objSelectContact(propertyFileReader("ContactName","SendMoney")), ": Contact"));
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 5, "Send Money page");
        addMoneyAndPurpose("100","Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        confirmSendMoneyPageTonikToTonik();
        enterOTP();
        validateTransactionStatusAndDetails();
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objTonikToTonikSendMoney,getTextVal(SendMoneyPage.objTonikToTonikSendMoney,": Transaction"));
        transactionDetailsValidation();
        logger.info("TDB_SM_012, Send Money - User can send money to other Tonik Customer by entering receipient's Mobile Number validated");
        extentLoggerPass("TDB_SM_012", "TDB_SM_012, Send Money - User can send money to other Tonik Customer by entering receipient's Mobile Number validated");
    }
    /**
     * Method to Verify if user can send money to other Tonik Customer using receipient's Tonik Account Number
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyToTonikCustomerUsingReceipientTonikAccountNumber_TDB_SM_013(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_013, Send Money - Verify if user can send money to other Tonik Customer using receipient's Tonik Account Number");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        inputTonikAccountNumber(propertyFileReader("ReceiverAccNumber","SendMoney"));
        addMoneyAndPurpose("100","Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        confirmSendMoneyPageTonikToTonik();
        enterOTP();
        validateTransactionStatusAndDetails();
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objTonikToTonikSendMoney,getTextVal(SendMoneyPage.objTonikToTonikSendMoney,": Transaction"));
        transactionDetailsValidation();
        logger.info("TDB_SM_013, Send Money - User can send money to other Tonik Customer by entering receipient's Mobile Number validated");
        extentLoggerPass("TDB_SM_013", "TDB_SM_013, Send Money - User can send money to other Tonik Customer by entering receipient's Mobile Number validated");
    }
    /**
     * Method to Verify if user can send the money above the limited transaction amount to other Tonik customer
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyAboveLimitedTransactionToTonikCustomer_TDB_SM_014(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_014, Send Money - Verify if user can send the money above the limited transaction amount to other Tonik customer");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("ReceiverMobileNumber","SendMoney"));
        addMoneyAndPurpose("10000000","Fund Transfer");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionTonikCustomer,getTextVal(SendMoneyPage.objMaxTransactionTonikCustomer,": Error message"))){
            containsValidation(getText(SendMoneyPage.objMaxTransactionTonikCustomer),propertyFileReader("MaxTransactionTonikCustomer","SendMoney"),": error message");
            logger.info("TDB_SM_014, Send Money - User can't able to send the money above the limited transaction amount to other Tonik customer validated");
            extentLoggerPass("TDB_SM_014", "TDB_SM_014, Send Money - User can't able to send the money above the limited transaction amount to other Tonik customer validated");
        }
    }
    /**
     * Method to Verify if user can send money to other Tonik Customer (via mobile number) with insufficient TSA balance
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionToTonikCustomerViaMobileNumberInsufficientBalance_TDB_SM_015(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_015, Send Money - Verify if user can send money to other Tonik Customer (via mobile number) with insufficient TSA balance");
        tonikLogin(password);
        String sAmount = getAvailableAndIncreaseValue();
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("ReceiverMobileNumber","SendMoney"));
        addMoneyAndPurpose(sAmount,"Fund Transfer");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionErrorMsg,getTextVal(SendMoneyPage.objMaxTransactionErrorMsg,"Max transaction error message"))){
            assertionValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionErrorMsg","SendMoney"),": Error message");
            logger.info("TDB_SM_015, Send Money - User can't able to send money to other Tonik Customer (via mobile number) with insufficient TSA balance validated");
            extentLoggerPass("TDB_SM_015", "TDB_SM_015, Send Money - User can't able to send money to other Tonik Customer (via mobile number) with insufficient TSA balance validated");
        }
    }
    /**
     * Method to Verify if user can send money to other Tonik Customer (via Contacts) with insufficient TSA balance
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionToTonikCustomerViaContactsInsufficientBalance_TDB_SM_016(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_016, Send Money - Verify if user can send money to other Tonik Customer (via Contacts) with insufficient TSA balance");
        tonikLogin(password);
        String sAmount = getAvailableAndIncreaseValue();
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage,3,"Send money page");
        verifyElementPresent(SendMoneyPage.objSendMoneyPage, getTextVal(SendMoneyPage.objSendMoneyPage, ": title"));
        verifyElementPresentAndClick(SendMoneyPage.objContactsIcon,"Contacts Icon");
        waitForElementToBePresent(OnBoardingPage.objMobileNumberInputField, 5, "Send Icon");
        type(OnBoardingPage.objMobileNumberInputField,propertyFileReader("ContactName","SendMoney"),": Contact search field");
        click(SendMoneyPage.objSelectContact(propertyFileReader("ContactName","SendMoney")), getTextVal(SendMoneyPage.objSelectContact(propertyFileReader("ContactName","SendMoney")), ": Contact"));
        addMoneyAndPurpose(sAmount,"Fund Transfer");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionErrorMsg,getTextVal(SendMoneyPage.objMaxTransactionErrorMsg,"Max transaction error message"))){
            assertionValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionErrorMsg","SendMoney"),": Error message");
            logger.info("TDB_SM_016, Send Money - User can't able to send money to other Tonik Customer (via Contacts) with insufficient TSA balance validated");
            extentLoggerPass("TDB_SM_016", "TDB_SM_015, Send Money - User can't able to send money to other Tonik Customer (via Contacts) with insufficient TSA balance validated");
        }
    }
    /**
     * Method to Verify if user can send money to other Tonik Customer (via Tonik Account Number) with insufficient TSA balance
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionToTonikCustomerViaTonikAccountNumberInsufficientBalance_TDB_SM_017(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_017, Send Money - Verify if user can send money to other Tonik Customer (via Tonik Account Number) with insufficient TSA balance");
        tonikLogin(password);
        String sAmount = getAvailableAndIncreaseValue();
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        inputTonikAccountNumber(propertyFileReader("ReceiverAccNumber","SendMoney"));
        addMoneyAndPurpose(sAmount,"Fund Transfer");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionErrorMsg,getTextVal(SendMoneyPage.objMaxTransactionErrorMsg,"Max transaction error message"))){
            assertionValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionErrorMsg","SendMoney"),": Error message");
            logger.info("TDB_SM_017, Send Money - User can't able to send money to other Tonik Customer (via Tonik Account Number) with insufficient TSA balance validated");
            extentLoggerPass("TDB_SM_017", "TDB_SM_017, Send Money - User can't able to send money to other Tonik Customer (via Tonik Account Number) with insufficient TSA balance validated");
        }
    }
    /**
     * Method to Verify if user can send money to own account - using own mobile number registered to Tonik Account
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionToOwnAccountUsingRegisteredMobileNumber_TDB_SM_018(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_018, Send Money - Verify if user can send money to own account - using own mobile number registered to Tonik Account");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("OwnMobileNumber", "SendMoney"));
        addMoneyAndPurpose("100", "Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn, getTextVal(SendMoneyPage.objNextBtn, "Next Button"));
        confirmSendMoneyPageTonikToTonik();
        if(verifyElementPresent(SendMoneyPage.objSorryScreen, getTextVal(SendMoneyPage.objSorryScreen, ": Screen"))) {
            assertionValidation(getText(SendMoneyPage.objSameFromAndToAccountMsg), propertyFileReader("SameFromAndToAccountMsg", "SendMoney"), ": Sorry Screen Info");
            verifyElementPresentAndClick(SendMoneyPage.objGotIt, getTextVal(SendMoneyPage.objGotIt, ": button"));
            verifyElementPresent(SendMoneyPage.objSendMoneyOptionsPage, getTextVal(SendMoneyPage.objSendMoneyOptionsPage, ": page"));
            logger.info("TDB_SM_018, Send Money - User can't able to send money to own account - using own mobile number registered to Tonik Account validated");
            extentLoggerPass("TDB_SM_018", "TDB_SM_018, Send Money - User can't able to send money to own account - using own mobile number registered to Tonik Account validated");
        }
    }
    /**
     * Method to Verify if user can send money to own account - using own Tonik Account number
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionToOwnAccountUsingTonikAccountNumber_TDB_SM_019(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_019, Send Money - Verify if user can send money to own account - using own Tonik Account number");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(TopUpPage.objTopUpIcon,"Top-up Icon");
        click(TopUpPage.objTopUpOption("PESONet or InstaPay"),getTextVal(TopUpPage.objTopUpOption("PESONet or InstaPay"),": Top-up option"));
        verifyElementPresent(TopUpPage.objTonikAccountNumberDisplayed,"Tonik Account number");
        String sOwnTonikAccountNumber = getText(TopUpPage.objTonikAccountNumberDisplayed);
        click(SendMoneyPage.objBackBtn,"Back button");
        waitTime(3000);// Wait time required to load entire screen
        click(SendMoneyPage.objBackBtn,"Back button");
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        inputTonikAccountNumber(sOwnTonikAccountNumber);
        addMoneyAndPurpose("100","Fund Transfer");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        confirmSendMoneyPageTonikToTonik();
        if(verifyElementPresent(SendMoneyPage.objSorryScreen, getTextVal(SendMoneyPage.objSorryScreen, ": Screen"))) {
            assertionValidation(getText(SendMoneyPage.objSameFromAndToAccountMsg), propertyFileReader("SameFromAndToAccountMsg", "SendMoney"), ": Sorry Screen Info");
            verifyElementPresentAndClick(SendMoneyPage.objGotIt, getTextVal(SendMoneyPage.objGotIt, ": button"));
            verifyElementPresent(SendMoneyPage.objSendMoneyOptionsPage, getTextVal(SendMoneyPage.objSendMoneyOptionsPage, ": page"));
            logger.info("TDB_SM_019, Send Money - User can't able to send money to own account - using own Tonik Account number validated");
            extentLoggerPass("TDB_SM_019", "TDB_SM_019, Send Money - User can't able to send money to own account - using own Tonik Account number validated");
        }
    }
    /**
     * Method to Verify if user can send money to invalid Account number via InstaPay
     * @param password
     * @param sAmount
     * @param sPurpose
     * @throws Exception
     */
    public void sendMoneyToInvalidAccountNumberViaInstaPayTDB_SM_020(String password,String sAmount, String sPurpose) throws Exception {
        HeaderChildNode("TDB_SM_020, Send Money - Verify if user can send money to invalid Account number via InstaPay");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        selectSendMoneyToBankOption(SendMoneyPage.objInstaPayOption);
        addMoneyAndPurpose(sAmount,sPurpose);
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        selectAccountInfoAndBank(propertyFileReader("AccountHolderName","SendMoney"),"Bank Of ", propertyFileReader("AccountNumber","SendMoney"));
        confirmTransactionPageValidation();
        click(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
        enterOTP();
        waitForElementToBePresent(SendMoneyPage.objPESONetTransactionStatus,5,"Transaction status");
        verifyElementPresent(SendMoneyPage.objPESONetTransactionStatus,getTextVal(SendMoneyPage.objPESONetTransactionStatus,": Transaction status"));
        containsValidation(getText(SendMoneyPage.objPESONetTransactionInformation),propertyFileReader("PESONetTransactionInformation","SendMoney"),": Transaction Information");
        verifyElementPresentAndClick(SendMoneyPage.objViewTransactionDetails,getTextVal(SendMoneyPage.objViewTransactionDetails,": button"));
        transactionDetailsValidation();
        click(LoginPage.objBackBtn,"Back button");
        click(SendMoneyPage.objBackToDashboard,getTextVal(SendMoneyPage.objBackToDashboard,": button"));
        navigateToAccountHistory();
        verifyElementPresent(SendMoneyPage.objRefundAmount,getTextVal(SendMoneyPage.objRefundAmount,": Refund amount"));
        verifyElementPresentAndClick(SendMoneyPage.objInstaPayRefund,getTextVal(SendMoneyPage.objInstaPayRefund,": Transaction"));
        transactionDetailsValidation();
        click(SendMoneyPage.objBackBtn,"Back button");
        verifyElementPresentAndClick(SendMoneyPage.objInstaPayTransaction,getTextVal(SendMoneyPage.objInstaPayTransaction,": transaction"));
        transactionDetailsValidation();
        logger.info("TDB_SM_020, Send Money - User can't able send money to invalid Account number via InstaPay and refund validated");
        extentLoggerPass("TDB_SM_020", "TDB_SM_020, Send Money - User can't able send money to invalid Account number via InstaPay and refund validated");
    }
    /**
     * Method to Verify if user can send money to a mobile number that has no Tonik Account
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionToUnregisteredTonikNumber_TDB_SM_021(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_021, Send Money - Verify if user can send money to a mobile number that has no Tonik Account");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("UnRegisteredMobileNumber", "SendMoney"));
        addMoneyAndPurpose("100", "Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn, getTextVal(SendMoneyPage.objNextBtn, "Next Button"));
        confirmSendMoneyPageTonikToTonik();
        if(verifyElementPresent(SendMoneyPage.objSorryScreen, getTextVal(SendMoneyPage.objSorryScreen, ": Screen"))) {
            assertionValidation(getText(SendMoneyPage.objInvalidAccountNumber), propertyFileReader("InvalidAccountNumberMsg", "SendMoney"), ": Sorry Screen Info");
            verifyElementPresentAndClick(SendMoneyPage.objGotIt, getTextVal(SendMoneyPage.objGotIt, ": button"));
            verifyElementPresent(SendMoneyPage.objSendMoneyOptionsPage, getTextVal(SendMoneyPage.objSendMoneyOptionsPage, ": page"));
            logger.info("TDB_SM_021, Send Money - User can't able to send money to a mobile number that has no Tonik Account validated");
            extentLoggerPass("TDB_SM_021", "TDB_SM_021, Send Money - User can't able to send money to a mobile number that has no Tonik Account validated");
        }
    }

    /**
     * Method to Verify if user can send money to an invalid account number from Tonik Account number screen
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyTransactionInvalidAccountNumber_TDB_SM_022(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_022, Send Money - Verify if user can send money to an invalid account number from Tonik Account number screen");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon,5,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        inputTonikAccountNumber(propertyFileReader("InvalidTonikAccNumber","SendMoney"));
        addMoneyAndPurpose("100", "Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn, getTextVal(SendMoneyPage.objNextBtn, "Next Button"));
        confirmSendMoneyPageTonikToTonik();
        if(verifyElementPresent(SendMoneyPage.objSorryScreen, getTextVal(SendMoneyPage.objSorryScreen, ": Screen"))) {
            assertionValidation(getText(SendMoneyPage.objInvalidAccountNumber), propertyFileReader("InvalidAccountNumberMsg", "SendMoney"), ": Sorry Screen Info");
            verifyElementPresentAndClick(SendMoneyPage.objGotIt, getTextVal(SendMoneyPage.objGotIt, ": button"));
            verifyElementPresent(SendMoneyPage.objSendMoneyOptionsPage, getTextVal(SendMoneyPage.objSendMoneyOptionsPage, ": page"));
            logger.info("TDB_SM_022, Send Money - User can't able to send money to an invalid account number from Tonik Account number validated");
            extentLoggerPass("TDB_SM_022", "TDB_SM_022, Send Money - User can't able to send money to an invalid account number from Tonik Account number validated");
        }
    }
    /**
     * Method to Verify if user can save a recipient
     * @param password
     * @param sAmount
     * @param sPurpose
     * @throws Exception
     */
    public void sendMoneySaveARecipient_TDB_SM_023(String password,String sAmount, String sPurpose) throws Exception {
        HeaderChildNode("TDB_SM_023, Send Money - Verify if user can save a recipient");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        String sAccountNumber = generateRandomAccNumber();
        String sRecipientName = propertyFileReader("AccountHolderName","SendMoney");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        selectSendMoneyOption(SendMoneyPage.objToAnotherBankOption);
        selectSendMoneyToBankOption(SendMoneyPage.objInstaPayOption);
        addMoneyAndPurpose(sAmount,sPurpose);
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        selectAccountInfoAndBank(sRecipientName,"Bank Of ", sAccountNumber);
        confirmTransactionPageValidation();
        Swipe("UP",2);
        verifyElementPresentAndClick(SendMoneyPage.objSaveRecipientSwitchSlider,"Save Recipient Switch slider");
        click(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
        enterOTP();
        waitForElementToBePresent(SendMoneyPage.objPESONetTransactionStatus,5,"Transaction status");
        verifyElementPresent(SendMoneyPage.objPESONetTransactionStatus,getTextVal(SendMoneyPage.objPESONetTransactionStatus,": Transaction status"));
        verifyElementPresentAndClick(SendMoneyPage.objViewTransactionDetails,getTextVal(SendMoneyPage.objViewTransactionDetails,": button"));
        transactionDetailsValidation();
        click(LoginPage.objBackBtn,"Back button");
        click(SendMoneyPage.objBackToDashboard,getTextVal(SendMoneyPage.objBackToDashboard,": button"));
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        if(verifyElementPresent(SendMoneyPage.objRecipientsName,getTextVal(SendMoneyPage.objRecipientsName,": Recipient name"))){
            String sRecipientsName = getText(SendMoneyPage.objRecipientsName);
            String sRecipientFirstLetter = sRecipientsName.substring(0,1);
            assertionValidation(getText(SendMoneyPage.objRecipientFirstLetter),sRecipientFirstLetter,"Recipient name first letter");
            verifyElementPresent(SendMoneyPage.objEllipseButton,"Ellipse button");
            logger.info("TDB_SM_023, Send Money - User can save a recipient validated");
            extentLoggerPass("TDB_SM_023", "TDB_SM_023, Send Money - User can save a recipient validated");
        }
    }
    /**
     * Method to Verify if user can send money from the Quick Send list
     * @param password
     * @param sAmount
     * @param sPurpose
     * @throws Exception
     */
    public void sendMoneyFromQuickSendList_TDB_SM_024(String password,String sAmount, String sPurpose) throws Exception {
        HeaderChildNode("TDB_SM_024, Send Money - Verify if user can send money from the Quick Send list");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        String sBeforeTransaction = sBalance();
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objRecipientsName,getTextVal(SendMoneyPage.objRecipientsName,": Recipient name"));
        addMoneyAndPurpose(sAmount,sPurpose);
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        confirmTransactionPageValidation();
        click(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
        enterOTP();
        waitForElementToBePresent(SendMoneyPage.objPESONetTransactionStatus, 5, "PESONet Transaction Status");
        waitForElementToBePresent(SendMoneyPage.objPESONetTransactionStatus,5,"Transaction status");
        verifyElementPresent(SendMoneyPage.objPESONetTransactionStatus,getTextVal(SendMoneyPage.objPESONetTransactionStatus,": Transaction status"));
        verifyElementPresentAndClick(SendMoneyPage.objViewTransactionDetails,getTextVal(SendMoneyPage.objViewTransactionDetails,": button"));
        transactionDetailsValidation();
        click(LoginPage.objBackBtn,"Back button");
        click(SendMoneyPage.objBackToDashboard,getTextVal(SendMoneyPage.objBackToDashboard,": button"));
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        String sAfterTransaction = sBalance();
        if(sBeforeTransaction!=sAfterTransaction){
            logger.info("TDB_SM_024, Send Money - User can send money from the Quick Send list validated");
            extentLoggerPass("TDB_SM_024", "TDB_SM_024, Send Money - User can send money from the Quick Send list validated");
        }
    }
    /**
     * Method to Verify if user delete the saved recipient from the Quick Send list
     * @param password
     * @throws Exception
     */
    public void sendMoneyDeleteRecipientFromQuickSendList_TDB_SM_025(String password) throws Exception {
        HeaderChildNode("TDB_SM_025, Send Money - Verify if user delete the saved recipient from the Quick Send list");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon,"Send Icon");
        verifyElementPresent(SendMoneyPage.objRecipientsName,getTextVal(SendMoneyPage.objRecipientsName,": Recipient name"));
        String sRecipientName = getText(SendMoneyPage.objRecipientsName);
        verifyElementPresentAndClick(SendMoneyPage.objEllipseButton,"Ellipse button");
        verifyElementPresentAndClick(SendMoneyPage.objDeleteRecipient,getTextVal(SendMoneyPage.objDeleteRecipient,": button"));
        if(verifyElementNotDisplayed(SendMoneyPage.objRecipientName(sRecipientName),"Saved Recipient")){
            logger.info("TDB_SM_025, Send Money - User delete the saved recipient from the Quick Send list validated");
            extentLoggerPass("TDB_SM_025", "TDB_SM_025, Send Money - User delete the saved recipient from the Quick Send list validated");
        }
    }
    /**
     * Method to Verify is user can Add a message while sending the money
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void addMessageWhileSendMoneyTransaction_TDB_SM_026(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_026, Send Money - Verify is user can Add a message while sending the money");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("ReceiverMobileNumber","SendMoney"));
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 5, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        addMoneyAndPurpose("100","Fund Transfer");
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        verifyElementPresent(LoginPage.objPageTitle,getTextVal(LoginPage.objPageTitle,": title"));
        assertionValidation(getText(LoginPage.objPageTitle),propertyFileReader("ConfirmSendMoney","SendMoney"),": page title");
        Swipe("UP",2);
        type(SendMoneyPage.objMessageInputField,propertyFileReader("InvalidMessage","SendMoney"),"Message input field");
        waitForElementToBePresent(SendMoneyPage.objInvalidErrorMsg, 5, "Invalid error message");
        assertionValidation(getText(SendMoneyPage.objInvalidErrorMsg),propertyFileReader("InvalidErrorMsg","SendMoney"),": Error message");
        type(SendMoneyPage.objMessageInputField,propertyFileReader("Message","SendMoney"),"Message input field");
        click(SendMoneyPage.objConfirmButton,getTextVal(SendMoneyPage.objConfirmButton,": button"));
        enterOTP();
        validateTransactionStatusAndDetails();
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objTonikToTonikSendMoney,getTextVal(SendMoneyPage.objTonikToTonikSendMoney,": Transaction"));
        if(verifyElementPresent(SendMoneyPage.objMessageInTransactionHistory,getTextVal(SendMoneyPage.objMessageInTransactionHistory,": Message in transaction history"))) {
            assertionValidation(getText(SendMoneyPage.objMessageInTransactionHistory),propertyFileReader("Message","SendMoney"),": Message");
            logger.info("TDB_SM_026, Send Money - User can Add a message while sending the money and message is reflected in Transaction history");
            extentLoggerPass("TDB_SM_026", "TDB_SM_026, Send Money -User can Add a message while sending the money and message is reflected in Transaction history");
        }
    }
    /**
     * Mehod to Verify if BKYC user can send more than ₱50,000 to another Tonik customer
     * @param password
     * @param selectSendMoneyOption
     * @throws Exception
     */
    public void sendMoneyMoreThanMaxLimitFromBKYCUser_TDB_SM_027(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_027, Send Money - Verify if BKYC user can send more than ₱50,000 to another Tonik customer");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("ReceiverMobileNumber", "SendMoney"));
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 5, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        addMoneyAndPurpose("50001", "Fund Transfer");
        click(LoginPage.objNextBtn, getTextVal(LoginPage.objNextBtn, ": button"));
        if(verifyElementPresent(SendMoneyPage.objMaxTransactionErrorMsg,getTextVal(SendMoneyPage.objMaxTransactionErrorMsg,"Max transaction error message"))){
            assertionValidation(getText(SendMoneyPage.objMaxTransactionErrorMsg),propertyFileReader("MaxTransactionErrorMsg","SendMoney"),": Error message");
            logger.info("TDB_SM_027, Send Money - BKYC user can't able to send more than ₱50,000 to another Tonik customer validated");
            extentLoggerPass("TDB_SM_027", "TDB_SM_027, Send Money - BKYC user can't able to send more than ₱50,000 to another Tonik customer validated");
        }
    }

    public void sendMoneyToBKYCTonikCustomerByEnteringRecipientMobileNumber_TDB_SM_028(String password,By selectSendMoneyOption) throws Exception {
        HeaderChildNode("TDB_SM_028, Send Money - Verify if BKYC user can send money to another Tonik customer");
        tonikLogin(password);
        waitForElementToBePresent(SendMoneyPage.objSendIcon, 5, "Send Icon");
        verifyElementPresentAndClick(SendMoneyPage.objSendIcon, "Send Icon");
        selectSendMoneyOption(selectSendMoneyOption);
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 3, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        enterMobileNumber(propertyFileReader("ReceiverMobileNumber","SendMoney"));
        click(LoginPage.objNextBtn,getTextVal(LoginPage.objNextBtn,": button"));
        waitForElementToBePresent(SendMoneyPage.objSendMoneyPage, 5, "Send Money page");
        verifyElementPresent(LoginPage.objPageTitle, getTextVal(LoginPage.objPageTitle, ": title"));
        addMoneyAndPurpose("100","Fund Transfer");
        verifyElementPresentAndClick(SendMoneyPage.objNextBtn,getTextVal(SendMoneyPage.objNextBtn,"Next Button"));
        confirmSendMoneyPageTonikToTonik();
        enterOTP();
        validateTransactionStatusAndDetails();
        navigateToAccountHistory();
        verifyElementPresentAndClick(SendMoneyPage.objTonikToTonikSendMoney,getTextVal(SendMoneyPage.objTonikToTonikSendMoney,": Transaction"));
        transactionDetailsValidation();
        logger.info("TDB_SM_028, Send Money - BKYC user can send money to another Tonik customer validated");
        extentLoggerPass("TDB_SM_028", "TDB_SM_028, Send Money - BKYC user can send money to another Tonik customer validated");
    }

}