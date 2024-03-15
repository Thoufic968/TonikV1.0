package com.pageObjects.pages.AndroidPages;

import org.openqa.selenium.By;

public class LoginPage {

    // Private constructor to prevent instantiation
    private LoginPage() {
    }

//  Edit Input field
    public static By objEditPassword = By.xpath("//android.widget.EditText[@resource-id='com.tonik.mobile:id/pin']");

//  Login button
    public static By objLoginBtn = By.xpath("//android.widget.Button[@resource-id='com.tonik.mobile:id/loginbutton']");

//  Profile Name
    public static By objProfileName = By.xpath("//*[@resource-id='appbar-content-title-text']");

//  Back button
    public static By objBackBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/Header_left_click']");
//  Page Title
    public static By objPageTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Main_title_txt']");

//  Page Subtitle
    public static By objPageSubTitle = By.xpath("//*[@resource-id='com.tonik.mobile:id/Sub_title_txt']");

//  AvailableBalance
    public static By objAvailableBalance = By.xpath("(//*[@text='Your tonik account']/following-sibling::android.widget.TextView)[1]");

//  History Icon
    public static By objHistoryIcon = By.xpath("//*[@text='History']/preceding-sibling::*");

//  Cross button
    public static By objCrossButton = By.xpath("//*[@content-desc='Header_right_click']/child::*");

//  View transaction link
    public static By objViewTransactionLink = By.xpath("//*[@text='View transaction details']");

//  Back to dashboard
    public static By objBackToDashboard = By.xpath("//*[@text='Back to Dashboard']");

//  Transaction details amount
    public static By objTransactionAmount = By.xpath("//*[@text='Amount']/following-sibling::*");

//  Transaction details from
    public static By objTransactionFrom = By.xpath("//*[@text='From']/following-sibling::*");

//  Transaction details to
    public static By objTransactionTo = By.xpath("//*[@text='To']/following-sibling::*");

//  Transaction details date and time
    public static By objTransactionDateAndTime = By.xpath("//*[@text='When']/following-sibling::*");

//  Transaction details Reference Number
    public static By objTransactionReferenceNumber = By.xpath("//*[@text='Reference No.']/following-sibling::*");

//  Web page header
    public static By objWebPageHeader = By.xpath("//*[@resource-id='com.sec.android.app.sbrowser:id/location_bar_edit_text']");

//      Next Button
    public static By objNextBtn = By.xpath("//*[@text='Next']");

//  Next button parent
    public static By objNextButton = By.xpath("//*[@text='Next']/parent::*");

//  Permission message
    public static By objCallsPermissionPopup = By.xpath("//*[@text='Allow TONIK to make and manage phone calls?']");

//  Location access message
    public static By objLocationAccessPopup = By.xpath("//*[@text='Allow TONIK to access this device’s location?']");

//  Allow button
    public static By objAllowBtn = By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_button']");

//  While using App
    public static By objWhileUsingApp = By.xpath("//*[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']");

//  Picture Access popup
    public static By objPictureAccessPopup = By.xpath("//*[@text='Allow TONIK to access photos and media on your device?']");

//  Take picture permission
    public static By objTakePicturePermission = By.xpath("//*[@text='Allow TONIK to take pictures and record video?']");

//  Allow Notification popup
    public static By objAllowNotificationPopup = By.xpath("//*[@text='Allow TONIK to send you notifications?']");

//  popupSubHeader
    public static By objPopupSubHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_sub_header_txt']");

//  Ok button
    public static By objOkBtn = By.xpath("//*[@text='Ok']");

//  Header text
    public static By objHeaderTxt = By.xpath("//*[@resource-id='com.tonik.mobile:id/header_textView']");



}
