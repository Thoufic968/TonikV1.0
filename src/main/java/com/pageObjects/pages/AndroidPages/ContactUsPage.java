package com.pageObjects.pages.AndroidPages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
public class ContactUsPage {
    // Private constructor to prevent instantiation
    private ContactUsPage() {
    }
//  ContactUs page
    public static By objQuestionMarkIcon = By.xpath("(//*[@resource-id='appbar-header']/child::android.view.ViewGroup)[3]");
    public  static By objPageHeader = By.xpath("//*[@resource-id='com.tonik.mobile:id/Main_title_txt']");
    public static By objGetInTouchInfo = By.xpath("//*[@class='android.widget.ScrollView']/child::*/child::android.widget.TextView");
    public static By objChatWithUs = By.xpath("(//*[@class='android.widget.ScrollView']/child::*/child::android.view.ViewGroup/child::android.widget.TextView)[1]");
    public static By objContactNumber =  By.xpath("(//*[@class='android.widget.ScrollView']/child::*/child::android.view.ViewGroup/child::android.widget.TextView)[2]");
    public static By objFrequentlyAskedQuestion = By.xpath("(//*[@class='android.widget.ScrollView']/child::*/child::android.view.ViewGroup/child::android.widget.TextView)[3]");
    public static By objBackBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/Header_left_click']");
    public static By objChatInputField = By.xpath("//android.widget.EditText");
    public static By objSendButton = By.xpath("//android.widget.EditText/parent::*/following-sibling::*/child::*");
    public static By objUserMessages = By.xpath("//*[@resource-id='userMsg']");
    public static  By objUserLatestMessage(int index){
        return By.xpath("(//*[@resource-id='userMsg'])["+index+"]");
    }
    public static By objBotReplayMessages = By.xpath("//*[@resource-id='botMessage']");
    public static  By objBotLatestReplayMessage(int index){
        return By.xpath("(//*[@resource-id='botMessage'])["+index+"]/child::*/child::*/child::android.widget.TextView");
    }
    public static By objChatBoxTonikIcon = By.xpath("//*[@text='header-icon']");
    public static By objChatBoxBackButton = By.xpath("//*[@text='minimize']");
    public static By objDialPadNumber = By.xpath("//*[@class='android.widget.EditText']");
    public static By objTonikWebPageTitle = By.xpath("//*[@resource-id='com.sec.android.app.sbrowser:id/location_bar_edit_text']");
    public static By objCustomerCareMailId = By.xpath("//*[contains(@text, 'customercare@tonikbank.com')]");
    public static By objToFieldInMailPage = By.xpath("//*[@resource-id='com.google.android.gm:id/peoplekit_chip']");
    public static By objContactUsButton = By.xpath("//*[@resource-id='com.tonik.mobile:id/contact_button']");
}
