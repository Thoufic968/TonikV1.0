package com.pageObjects.pages.AndroidPages;
import org.openqa.selenium.By;
public class SendMoneyPage {
    // Private constructor to prevent instantiation
    private SendMoneyPage() {
    }
//  Send Icon and page
    public static By objSendIcon = By.xpath("//*[@text='Send']/preceding-sibling::*");
    public  static  By objPageHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Main_title_txt']");
    public static By objToAnotherBankOption = By.xpath("//*[@text='To another bank']");
    public static  By objToAnotherBankOptions = By.xpath("//*[@text='To another bank']/following-sibling::android.widget.TextView");
    public static By objToAnotherTonikCustomerOption = By.xpath("//*[@text='To another Tonik customer']");
    public static  By objProcessingFee = By.xpath("//*[@text='To another Tonik customer']/following-sibling::android.widget.TextView");
    public static By objBackBtn = By.xpath("//android.view.ViewGroup[@content-desc='Header_left_click']/android.view.ViewGroup");
    public static By objSendMoneyToBankOptionsDropdown = By.xpath("//*[@resource-id='com.tonik.mobile:id/Button_click']");
    public static By objSendMoneyViaDropdown = By.xpath("//*[@text='Send money via?']");
    public static By objPesonetOption = By.xpath("//*[@text='PESONet']");
    public static By objPesonetTransactionLimit = By.xpath("//*[@text='PESONet']/following-sibling::android.widget.TextView");
    public static By objInstaPayOption = By.xpath("//*[@text='InstaPay']");
    public static By objInstaPayTransactionLimit = By.xpath("//*[@text='InstaPay']/following-sibling::android.widget.TextView");
    public static By objCurrentBalance = By.xpath("//*[contains(@text,'Current')]");
    public static By objTransactionFee = By.xpath("//*[contains(@text,'Transaction')]");
    public static By objNextBtn = By.xpath("//*[@text='Next']/parent::*");
    public static By objAmountInputField = By.xpath("//*[@text='₱']/following-sibling::android.widget.EditText");
    public static By objPurposeDropdown = By.xpath("//*[@text='Purpose']/parent::*/child::android.widget.EditText");
    public static By objSelectPurpose(String sPurpose){
        return By.xpath("//*[contains(@text,'"+sPurpose+"')]/following-sibling::android.view.ViewGroup");
    }
    public static By objPurposes = By.xpath("//*[@class='android.widget.ScrollView']/child::*/child::*/child::*/child::android.widget.TextView");
    public static By objPurpose(int purpose){
        return By.xpath("(//*[@class='android.widget.ScrollView']/child::*/child::*/child::*/child::android.widget.TextView)["+purpose+"]");
    }
    public static By objPurposeEditField = By.xpath("//*[@text='Purpose']/parent::*/child::android.widget.EditText");
    public static By objMaxTransactionErrorMsg = By.xpath("(//*[@text='₱']/following-sibling::android.widget.TextView)[1]");
    public static By objRecipientInputField = By.xpath("//*[@class='android.widget.EditText']");
    public static By objUseTonikAccountLink = By.xpath("//*[@text='Use the Tonik account number instead']");
    public static By objContactsIcon = By.xpath("//*[@class='android.widget.EditText']/following-sibling::android.view.ViewGroup");
    public static By objCutOffMessage = By.xpath("//*[contains(@text,'4PM daily cut-off')]");
//  Confirm send money page
    public static By objRecipientMobileNumber = By.xpath("(//*[@resource-id='com.tonik.mobile:id/Main_title_txt']/parent::*/parent::*/following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)[1]");
    public static By objAmountToSend = By.xpath("//*[@text='Amount']/following-sibling::*");
    public static By objFeeToSend = By.xpath("//*[@text='Fee']/following-sibling::*");
    public static By objTotalAmount = By.xpath("//*[@text='Total']/following-sibling::*");
    public static By objSendingFrom = By.xpath("//*[@text='From']/following-sibling::*");
    public static By objSendingTo = By.xpath("//*[@text='To']/following-sibling::*");
    public static By objConfirmSendMoneyInfo = By.xpath("//*[contains(@text,'Please')]");
    public static By objAddAMessage = By.xpath("//*[@class='android.widget.EditText']");
    public static By objConfirmButton = By.xpath("//*[@text='Confirm']");
//  Enter OTP
    public static By objEnterOTP = By.xpath("//*[@text='Enter OTP']");
    public static By objEnterOTPInfo = By.xpath("//*[@text='Enter OTP']/following-sibling::*");
    public static By objEnterOTPInputField = By.xpath("(//*[@class='android.widget.ImageView']/preceding-sibling::*)[2]");
    public static By objResendOTPLink = By.xpath("//*[@text='Resend OTP']");
//  Transaction Status page
    public static By objScoreStatus = By.xpath("//*[@text='Scooore!']");
    public static By objTransactionInfoScreen = By.xpath("(//*[@text='Scooore!']/following-sibling::*)[1]");
    public static By objPopUpTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_title_text']");
    public static By objPopupDescription = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_Description']");
    public static By objOkayLetsGoBtn = By.xpath("//*[@resource-id='Okay, let’s go']");
    public static By objEntireScreen = By.xpath("//*[@resource-id='android:id/content']");
    public static By objSendMoneyOptionsPage = By.xpath("//*[@text='Send money options']");
    public static By objSendMoneyPage = By.xpath("//*[contains(@text,'money')]");
//  Account details
    public static By objAccountHolderName = By.xpath("//*[@text='Account holder name']/parent::*/child::android.widget.EditText");
    public static By objBankNameEditField = By.xpath("//*[@text='Bank name']/parent::*/child::android.widget.EditText");
    public static By objAccountNumber = By.xpath("//*[@text='Account number']/parent::*/child::android.widget.EditText");
    public static By objFindYourBankPage = By.xpath("//*[@text='Find your Bank']");
    public static By objSearchBank = By.xpath("//android.widget.EditText");
    public static By objBank(String bank){
        return By.xpath("//*[contains(@text,'"+bank+"')]");
    }
    public static By objConfirmSendMoneyInfoList(int info){
        return By.xpath("(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)["+info+"]");
    }
    public static By objConfirmSendMoneyPage = By.xpath("//*[@text='Confirm send money']");
    public static By objTransactionInfo(String info){
        return By.xpath("//*[@text='"+info+"']/following-sibling::*/child::*");
    }
    public static By objPESONetTransactionStatus = By.xpath("//*[@text='Working on it, luv']");
    public static By objPESONetTransactionInformation = By.xpath("//*[contains(@text,' transfer')]");
    public static By objViewTransactionDetails = By.xpath("//*[@text='View transaction details']");
    public static By objTransactionDetails = By.xpath("//*[contains(@text,'Transaction')]");
    public static By objTransactionDetailsInfo = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
    public static By objTransactionDetailsInfo(int info) {
        return By.xpath("(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView)["+info+"]");
    }
    public static By objBackToDashboard = By.xpath("//*[@text='Back to Dashboard']");
    public static By objEnterOTPField = By.xpath("(//android.widget.TextView[@text='⋆'])[1]");
    public static By objPESONetTransaction = By.xpath("(//*[@text='PESONet'])[1]");
    public static By objInstaPayTransaction = By.xpath("(//*[@text='InstaPay'])[1]");
    public static By objTransactionSummary = By.xpath("//*[@text='Transaction Summary']");
    public static By objTransactionDate = By.xpath("//*[contains(@text,'Transaction Date')]");
    public static By objReferenceNo = By.xpath("//*[contains(@text,'Reference No')]");
    public static By objContactIcon = By.xpath("//android.widget.EditText/following-sibling::android.view.ViewGroup");
    public static By objUseAccountNumberLink = By.xpath("//*[@text='Use the Tonik account number instead']");
    public static By objTonikToTonikTransferLimit = By.xpath("//*[contains(@text,'Tonik-to-Tonik')]");
    public static By objTonikToTonikTransactionInfo = By.xpath("//*[contains(@text,'This transaction is always free')]");
    public static By objTonikToTonikSendMoney = By.xpath("//*[@text='Send money']/preceding-sibling::android.widget.TextView");
    public static By objContactNumberInfo = By.xpath("//*[contains(@text,'Current')]/preceding-sibling::*/child::android.widget.TextView");
    public static By objSelectTonikUser = By.xpath("//*[@text='Select Tonik User']");
    public static By objContactNumber (String sContactName){
        return By.xpath("//*[@text='"+sContactName+"']/following-sibling::*");
    }
    public static By objSelectContact(String sContactName){
        return By.xpath("//android.widget.TextView[contains(@text,'"+sContactName+"')]");
    }
    public static By objAccNumberInputField = By.xpath("//android.widget.EditText");
    public static By objRecipientAccountNumber = By.xpath("//android.widget.TextView[contains(@text,'Recipient')])");
    public static By objMaxTransactionTonikCustomer = By.xpath("//*[contains(@text,'Tonik-to-Tonik transfers are limited to')]");
    public static By objSorryScreen = By.xpath("//*[@text='So sorry!']");
    public static By objSameFromAndToAccountMsg = By.xpath("//*[@text=\"From and To accounts can't be same.\"]");
    public static By objGotIt = By.xpath("//*[contains(@text,'Got')]");
    public static By objInvalidAccountNumber = By.xpath("//*[@text=\"Sorry. We can't find the account number you entered with us.\"]");
    public static By objRefundAmount = By.xpath("(//*[@text='InstaPay refund']/following-sibling::android.widget.TextView)[2]");
    public static By objInstaPayRefund = By.xpath("//*[@text='InstaPay refund']");
    public static By objSaveRecipientSwitchSlider = By.xpath("//*[@resource-id='com.tonik.mobile:id/List_Click_undefined']");
    public static By objQuickSendListHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Quick Send list']");
    public static By objRecipientFirstLetter = By.xpath("//*[@resource-id='com.tonik.mobile:id/ List_Click_0']/child::*/child::android.widget.TextView");
    public static By objRecipientsName = By.xpath("(//*[@resource-id='com.tonik.mobile:id/ List_Click_0']/child::android.widget.TextView)[1]");
    public static By objQuickSendListTransactionDetails = By.xpath("(//*[@resource-id='com.tonik.mobile:id/ List_Click_0']/child::android.widget.TextView)[2]");
    public static By objEllipseButton = By.xpath("//*[@resource-id='com.tonik.mobile:id/ List_Click_0']/child::android.view.ViewGroup/child::android.view.ViewGroup");
    public static By objDeleteRecipient = By.xpath("//*[contains(@text,'Delete')]");
    public static By objRecipientName (String sRecipientName){
        return By.xpath("//*[@text='"+sRecipientName+"']");
    }
    public static By objMessageInputField = By.xpath("//*[@resource-id='com.tonik.mobile:id/Confirm send moneyText_Input_1']");
    public static By objInvalidErrorMsg = By.xpath("//*[@resource-id='com.tonik.mobile:id/Confirm send moneyText_Error_1']");
    public static By objMessageInTransactionHistory = By.xpath("//*[@text='Message']/following-sibling::*");
}
