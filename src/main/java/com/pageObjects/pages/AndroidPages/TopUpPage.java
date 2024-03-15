package com.pageObjects.pages.AndroidPages;

import org.openqa.selenium.By;
public class TopUpPage{
    // Private constructor to prevent instantiation
    private TopUpPage() {
    }
//  Top up page
    public static By objTopUpIcon = By.xpath("//*[@text='Top up']/preceding-sibling::*");
    public static  By objTopUpOptions = By.xpath("//android.widget.ScrollView/child::*/child::*/child::*/child::*/child::android.widget.TextView");
    public static By objNameHeader = By.xpath("//*[@text='Name']");
    public static By objAccountHolderNameDisplayed = By.xpath("//*[@text='Name']/following-sibling::android.widget.TextView");
    public static By objAccountHolderNameCopyIcon = By.xpath("(//*[@text='Name']/following-sibling::android.view.ViewGroup)[1]");
    public static By objBankHeader = By.xpath("//*[@text='Bank']");
    public static By objBankNameDisplayed = By.xpath("//*[@text='Bank']/following-sibling::android.widget.TextView");
    public static By objTonikAccountNumberHeader = By.xpath("//*[@text='Tonik Account No.']");
    public static By objTonikAccountNumberDisplayed = By.xpath("//*[@text='Tonik Account No.']/following-sibling::android.widget.TextView");
    public static By objTonikAccountNumberCopyIcon = By.xpath("(//*[@text='Tonik Account No.']/following-sibling::android.view.ViewGroup)[1]");
    public static By objCopyToClipBoardMsg = By.xpath("//*[@text='Copied to your clipboard']");
    public static By objReminders = By.xpath("//*[@text='Reminders']/parent::*/following-sibling::*/child::*/child::android.widget.TextView");
    public static By objReminderHeader = By.xpath("//*[@text='Reminders']");
    public static By objTopUpOption(String option){
        return By.xpath("//*[@text='"+option+"']");
    }
    public static By objOnlineTopUpOptions = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    public static By objGCashOnlineOption = By.xpath("//*[@text=' GCash']");
    public static By objAvailableBalance = By.xpath("//*[contains(@text, 'Balance')]");
    public static By objMaxTransaction = By.xpath("//*[contains(@text, 'Up to')]");
    public static By objTransactionFee = By.xpath("//*[contains(@text, 'Transaction Fee')]");
    public static By objAmountInputField = By.xpath("//*[@text='₱']/following-sibling::android.widget.EditText");
    public static By objTopUPInfo = By.xpath("//*[contains(@text, 'Transaction Fee')]/following-sibling::android.widget.TextView");
    public static By objNextButton = By.xpath("//*[@text='Next']");
    public static By objProceedToPayButton = By.xpath("//android.widget.Button[@text='Proceed to Pay']");
    public static By objTransactionStatusHeader = By.xpath("(//*[@text='View transaction details']/parent::*/preceding-sibling::android.widget.TextView)[1]");
    public static By objTransactionInfo = By.xpath("(//*[@text='View transaction details']/parent::*/preceding-sibling::android.widget.TextView)[2]");
    public static By objButtonDisplayedInTransactionInfoPage = By.xpath("//*[@text='View transaction details']/parent::*/following-sibling::*/child::android.widget.TextView");
    public static By objTopUpTXNId = By.xpath("//*[@text='Txn ID']/following-sibling::*");
    public static By objContactUsIconInTransactionDetails = By.xpath("//*[@resource-id='com.tonik.mobile:id/Header_right_click']/child::*");
    public static By objTopUpViaGCash = By.xpath("//*[@text='Top up via GCash']");
    public static By objGCashTransactionHistory = By.xpath("(//*[@text='Top-up'])[1]/preceding-sibling::android.widget.TextView");
    public static By objMaxTransactionErrorMsg = By.xpath("(//android.widget.EditText/following-sibling::android.widget.TextView)[1]");
    public static By objBPIOnlineOption = By.xpath("//*[@text=' BPI']");
    public static By objChinaBankOnlineOption = By.xpath("//*[@text=' Chinabank']");
    public static By objRCBCOnlineOption = By.xpath("//*[@text=' RCBC']");
    public static By objUnionBankOnlineOption = By.xpath("//*[@text=' Unionbank']");
    public static By objPopupHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_title_text']");
    public static By objPopupDescription = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_Description']");
    public static By objNotYetButton = By.xpath("//*[@resource-id='Not yet']");
    public static By objYesIWantToTopUp = By.xpath("//*[@resource-id='Yes I want to top up']");
    public static By objWeAreSorry = By.xpath("//*[@text=\"We're really sorry.\"]");
    public static By objSorryPageInfo = By.xpath("(//*[@text=\"We're really sorry.\"]/following-sibling::*)[1]");
    public static By objCloseButton = By.xpath("//*[@text='Close']");
    public static By objTopUpBankScreen = By.xpath("//*[@text='Top up using PESONet or InstaPay']");
}
