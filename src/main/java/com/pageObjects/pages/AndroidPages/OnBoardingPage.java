package com.pageObjects.pages.AndroidPages;

import org.openqa.selenium.By;

public class OnBoardingPage {

    // Private constructor to prevent instantiation
    private OnBoardingPage() {
    }

//  Welcome Screen 1  message
    public static By objWelcomeScreen1 = By.xpath("//*[@text='Welcome to Tonik, the first neobank in the Philippines.']");
//  Welcome Screen 1 Button
    public static By objWelcomeScreen1Btn = By.xpath("//*[@text='Welcome to Tonik, the first neobank in the Philippines.']/parent::*/following-sibling::android.view.ViewGroup/child::*/child::*");
//  Welcome Screen 2  message
    public static By objWelcomeScreen2 = By.xpath("//*[@text='A neobank is 100% digital - that means FAST. Do stuff like   opening an account and getting a loan in just minutes. ']");
//  Welcome Screen 2 Button
    public static By objWelcomeScreen2Btn = By.xpath("//*[@text='A neobank is 100% digital - that means FAST. Do stuff like   opening an account and getting a loan in just minutes. ']/parent::*/following-sibling::android.view.ViewGroup/child::*/child::*");
//  Welcome Screen 3  message
    public static By objWelcomeScreen3 = By.xpath("//*[@text='Loans have never been easier. No credit history and collaterals? No problem! Get a fuss-free loan QUICK with  minimal docs needed.']");
//  Welcome Screen 3 Button
    public static By objWelcomeScreen3Btn = By.xpath("//*[@text='Loans have never been easier. No credit history and collaterals? No problem! Get a fuss-free loan QUICK with  minimal docs needed.']/parent::*/following-sibling::android.view.ViewGroup/child::*/child::*");
//  Welcome Screen 4  message
    public static By objWelcomeScreen4 = By.xpath("//*[@text='You’ll also get a virtual debit card instantly. Ready to use for online shopping and payments.']");
//  Welcome Screen 4 Button
    public static By objWelcomeScreen4Btn = By.xpath("//*[@text='You’ll also get a virtual debit card instantly. Ready to use for online shopping and payments.']/parent::*/following-sibling::android.view.ViewGroup/child::*/child::*");
//  Welcome Screen 5 message
    public static By objWelcomeScreen5 = By.xpath("//*[@text='Smart. Digital. Simple. \n" +
            "Your neobanking romance.']");
//  Welcome Screen 5 Button
    public static By objWelcomeScreen5Btn = By.xpath("//*[@text='Smart. Digital. Simple. \n" +
            "Your neobanking romance.']/parent::*/following-sibling::android.view.ViewGroup/child::*/child::*");
//  Mobile number input field
    public static By objMobileNumberInputField = By.xpath("//android.widget.EditText");
//  Tick Symbol
    public static By objTickSymbol = By.xpath("//android.widget.EditText/following-sibling::android.view.ViewGroup");
//  Already have an account
    public static By objAlreadyHaveAccount = By.xpath("//*[@text='Already have an account?']");
//  Fancy meeting you here, so what's your number?
    public static By objCreateAccountPage = By.xpath("//*[@text='Fancy meeting you here, so what's your number?']");
//  Login here link
    public static By objLoginHereLink = By.xpath("//*[@text='Log in here']");
//  Next Button
    public static By objNextBtn = By.xpath("//*[@text='Next']");
//  Terms and conditions info
    public static By objTermsAndConditionInfo = By.xpath("//*[contains(@text,'complete terms and conditions')]");
//
    public static By objHouseRule(int houseRule) {
        return By.xpath("(//*[@resource-id='com.tonik.mobile:id/Main_title_view']/parent::*/following-sibling::android.widget.TextView)["+houseRule+"]");
    }
//  Who can open a Tonik account rule
    public static By objHouseRule1 = By.xpath("//*[@text='Who can open a Tonik account.']");
//  What you can do with your Tonik accounts
    public static By objHouseRule2 = By.xpath("//*[@text='What you can do with your Tonik accounts.']");
//  Dos and don'ts of using Tonik's services
    public static By objHouseRule3 = By.xpath("//*[@text=\"Dos and don'ts of using Tonik's services.\"]");
//  Why it's necessary to verify your identity by providing documents or performing certain actions
    public static By objHouseRule4 = By.xpath("//*[@text=\"Why it's necessary to verify your identity by providing documents or performing certain actions.\"]");
//  How we keep your Tonik app, accounts and cards safe
    public static By objHouseRule5 = By.xpath("//*[@text=\"How we keep your Tonik app, accounts and cards safe.\"]");
//  Explaining our fees, limits, and interest
    public static By objHouseRule6 = By.xpath("//*[@text=\"Explaining our fees, limits, and interest.\"]");
//  How we will reach out to you
    public static By objHouseRule7 = By.xpath("//*[@text=\"How we will reach out to you.\"]");
//  Terms and condition
    public static By objReadTermsAndConditionLink = By.xpath("//*[@text=\"Read full General Terms & Conditions\"]");
//  Terms and condition info
    public static By objTermsAndConditionCheckBoxInfo = By.xpath("//*[@text='I confirm that I have read, understood, and agreed to the full General Terms & Conditions.']");
//  Terms and condition info Radio button
    public static By objTermsAndConditionInfoCheckBox = By.xpath("//*[@text='I confirm that I have read, understood, and agreed to the full General Terms & Conditions.']/preceding-sibling::*");
//  Agree and Continue
    public static By objAgreeAndContinueBtn = By.xpath("//*[@text='Agree and Continue']");
//  Our privacy matters
    public static By objOurPrivacyMatters = By.xpath("//*[@text='Our privacy matters']");
//  Privacy matters info
    public static By objPrivacyMattersInfo = By.xpath("//*[@text='In the Data Privacy Statement, you will find our complete statement regarding your privacy including the provisions on the following items:']");
//  Privacy policy 1
    public static By objPrivacyPolicy1 = By.xpath("//*[@text='How we obtain your data.']");
//  Privacy policy 2
    public static By objPrivacyPolicy2 = By.xpath("//*[@text='What data we get from you.']");
//  Privacy policy 3
    public static By objPrivacyPolicy3 = By.xpath("//*[@text='Why we need your data.']");
//  Privacy policy 4
    public static By objPrivacyPolicy4 = By.xpath("//*[@text='What we do with your data.']");
//  Privacy policy 5
    public static By objPrivacyPolicy5 = By.xpath("//*[@text='Who we share your data with and why.']");
//  Privacy policy 6
    public static By objPrivacyPolicy6 = By.xpath("//*[@text='Your rights and how we respect them.']");
//  Privacy policy 7
    public static By objPrivacyPolicy7 = By.xpath("//*[@text='How we keep your data safe.']");
//  Tonik App access device apps
    public static By objTonikAppAccessOtherDeviceAppsMsg = By.xpath("//*[@text='The Tonik App requires your permission to access your  camera, audio, gallery, contacts, installed apps, and location  to function as intended. We do not store any of your contacts’ details in the Tonik cloud.']");
//  Data privacy statement link
    public static By objDataPrivacyStatementLink = By.xpath("//*[@text='Read full Data Privacy Statement']");
//  Data Privacy statement info
    public static By objDataPrivacyStatementInfo = By.xpath("//*[contains(@text,'I have read the Data Privacy statement')]");
//  Data Privacy statement Radio button
    public static By objDataPrivacyStatementRadioBtn = By.xpath("//*[contains(@text,'I have read the Data Privacy statement')]/preceding-sibling::*");
//  YES, I am a Filipino / Filipina.
    public static By objYesIamFilipinoOption = By.xpath("//*[@text='YES, I am a Filipino / Filipina.']");
//  No, I am not. I have a different nationality
    public static By objNoIamNotFilipinoOption = By.xpath("//*[@text='No, I am not. I have a different nationality.']");
//  Let’s get to know each other better
    public static By objLetsGetToKnowBetter = By.xpath("//*[@text='Let’s get to know each other better...']");
//  Take a Face Identity Scan
    public static By objTakeAFaceIdentityScan = By.xpath("//*[@text='Take a Face Identity Scan']");
//  Scan one Valid ID you own
    public static By objScanValidId = By.xpath("//*[@text='Scan one Valid ID you own.']");
//  Get your digital signature
    public static By objGetYourDigitalSignature = By.xpath("//*[@text='Get your digital signature.']");
//  Initiate Face Identity Scan
    public static By objInitiateFaceIdentityScan = By.xpath("//*[@text='Initiate Face Identity Scan']");
//  Question mark (contact us) icon
    public static By objCustomerCareIcon = By.xpath("//*[@resource-id='com.tonik.mobile:id/Header_right_click' or @resource-id='com.tonik.mobile:id/contact_button']");
//  OTP Input field
    public static By objOTPInputField (int number){
        return  By.xpath("(//android.widget.TextView[@text='⋆'])["+number+"]");
    }
//  Resend OTP Link
    public static By objResendOTP = By.xpath("//*[@text='Resend OTP']");
//  Resend parent element
    public static By objResendOTPParentElement = By.xpath("//*[@text='Resend OTP']/parent::*");
//  Invalid OTP Popup
    public static By objInvalidOTPPopup = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_sub_header_txt']     ");
//  Popup Button
    public static By objPopupBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_single_btn_txt']");
//  ID Selection Page Tile
    public static By objIDSelectionPageTile = By.xpath("//*[@text='You look too young. We’ll need to check your ID']");
//  Auto Populated First Name
    public static By objAutoPopulatedFirstName = By.xpath("//*[@text='First name']/following-sibling::*");
//  Auto Populated Middle Name
    public static By objAutoPopulatedMiddleName = By.xpath("//*[@text='Middle name']/following-sibling::*");
//  Auto Populated Last name
    public static By objAutoPopulatedLastName = By.xpath("//*[@text='Last name']/following-sibling::*");
//  Auto Populated Gender
    public static By objAutoPopulatedGender = By.xpath("//*[@text='Gender']/following-sibling::*");
//  Gender input field
    public static By objGenderInputField = By.xpath("//*[@text='Gender']/preceding-sibling::*");
//  AutoPopulatedDateOfBirth
    public static By objAutoPopulatedDateOfBirth = By.xpath("//*[@text='Date of birth']/following-sibling::*");
//  PlaceOfBirth
    public static By objPlaceOfBirth = By.xpath("//*[@text='Place of birth']/parent::*/child::android.widget.EditText");
//  Place of Birth input field
    public static By objPlaceOfBirthInputField = By.xpath("//*[@text='Place of birth']/parent::*/child::android.widget.EditText");
//   Gender dropdown
    public static By objGenderDropdown(String dropdown){
        return By.xpath("//*[@text='"+dropdown+"']");
    }
//  Passport Option
    public static By objPassportOption = By.xpath("//*[@text='Passport']");
//  National ID/ PhilID Option
    public static By objPhilID = By.xpath("//*[@text='National ID/ PhilID']");
//  Let Scan This ID Btn
    public static By objLetScanThisIDBtn = By.xpath("//*[@text=\"Let's scan this ID\"]");
//  Skip This Step
    public static By objSkipThisStep = By.xpath("//*[@text='Skip this step']");
//  Got A Clear Scan Title
    public static By objGotAClearScanTitle = By.xpath("//*[@text='Got a clear scan?']");
//  Submit Front ID Scan Btn
    public static By objSubmitFrontIDScanBtn = By.xpath("//*[@text='Submit Front ID scan']");
//  Submit Back ID Scan Btn
    public static By objSubmitBackIDScanBtn = By.xpath("//*[@text='Submit Back ID scan']");
//  Did We Get It Right Title
    public static By objDidWeGetItRightTitle = By.xpath("//*[@text='Did we get it right?']");
//  Looks Good Btn
    public static By objLooksGoodBtn = By.xpath("//*[@text='Looks good']");
//  This is the button you need to tap
    public static By objButtonToTapBtn = By.xpath("//*[@text='This is the button you need to tap.']");
//  Auto Details Populated Page Title
    public static By objAutoDetailsPopulatedPageTitle = By.xpath("//*[@text='Let’s get to know the real you.']");
//  Enter OTP
    public static By objEnterOTP = By.xpath("//*[@text='Enter OTP']");
//  SSS ID
    public static By objSSSID = By.xpath("//*[@text='SSS ID']");
//   Previous month
    public static By objPreviousMonth = By.xpath("//*[@content-desc='Previous month']");
//   Select date
    public static By objSelectDate(String date){
        return By.xpath("//*[@text='"+date+"']");
    }
//  Calendar Ok Button
    public static By objCalendarOkBtn = By.xpath("//*[@resource-id='android:id/button1']");
//  Invalid OTP Popup
    public static By objMaxOTPAttemptPopup = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_sub_header_txt']");
//  Ok Button
    public static By objOkBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_single_btn_click']");
//  Continue button
    public static By objContinueBtn = By.xpath("//*[@text='Continue']");
//  Invalid place of birth error message
    public static By objInvalidPlaceOfBirth = By.xpath("//*[@text='Please enter a valid place of birth']");
//  Please enter alphabets only
    public static By objEnterAlphabetsErrorMessage = By.xpath("//*[@text='Please enter alphabets only']");
//  Let’s get to know the real you.
    public static By objLetsGetToKnowYou = By.xpath("//*[@text='Let’s get to know the real you.']");
//  Country of Residence
    public static By objAutoPopulatedCountryOfResidence = By.xpath("//*[@text='Country of Residence']/following-sibling::*");
//  Zip code
    public static By objZipCode = By.xpath("//*[@text='Zip code']");
//  Apply zip code
    public static By objApplyZipCode = By.xpath("//*[@text='Apply zip code']");
//  How to find your zip code?
    public static By objHowToFindZipCodeLink = By.xpath("//*[@text='How to find your zip code?']");
//  How to find your zip code?
    public static By objHowToFindZipCodeWebPage = By.xpath("//*[@resource-id='com.sec.android.app.sbrowser:id/location_bar_edit_text']");
//  Province
    public static By objProvince = By.xpath("//*[@text='Province']");
//  City / Municipality
    public static By objCityOrMunicipality = By.xpath("//*[@text='City / Municipality']");
//  Barangay
    public static By objBarangay = By.xpath("//*[@text='Barangay']");
//  House/Unit/Flr #, Bldg, Blk or Lots
    public static By objHouseUnitFlrNumber = By.xpath("//*[@text='House/Unit/Flr #, Bldg, Blk or Lots']");
//  ZipCode input field
    public static By objZipCodeInputField = By.xpath("//*[@text='Zip code']/parent::*/child::android.widget.EditText");
//  Province
    public static By objProvinceInputField = By.xpath("//*[@text='Province']/following-sibling::*");
//  City / Municipality input field
    public static By objCityOrMunicipalityInputField = By.xpath("//*[@text='City / Municipality']/following-sibling::*");
//  Barangay
    public static By objBarangayInputField = By.xpath("//*[@text='Barangay']/following-sibling::*");
//  House/Unit/Flr #, Bldg, Blk or Lots
    public static By objHouseUnitFlrNumberInputField = By.xpath("//*[@text='House/Unit/Flr #, Bldg, Blk or Lots']/parent::*/child::android.widget.EditText");
//  Please enter a valid Zipcode
    public static By objInvalidZipCodeErrorMsg = By.xpath("//*[@text='Please enter a valid Zipcode']");
//  Displayed Barangay
    public static By objBarangayDisplayed = By.xpath("//*[@class='android.widget.ScrollView']/child::*/child::*/child::*/child::*/child::android.widget.TextView");
//  Select Barangay
    public static By objBarangay(String barangay){
        return By.xpath("(//*[@class='android.widget.ScrollView']/child::*/child::*/child::*/child::*/child::android.widget.TextView)["+barangay+"]");
    }
//  Barangay Search field
    public static By objBarangaySearchField = By.xpath("//*[@class='android.widget.EditText']");
//  Source of funds
    public static By objSourceOfFundsInputField = By.xpath("//*[@text='Source of Funds']/parent::*/child::android.widget.EditText");
//  Current Employment Status
    public static By objCurrentEmploymentStatus = By.xpath("//*[@text='Current employment status']/parent::*/child::android.widget.EditText");
//  Nature of work
    public static By objNatureOfWork = By.xpath("//*[@text='Nature of work']/parent::*/child::android.widget.EditText");
//  Industry
    public static By objIndustry = By.xpath("//*[@text='Industry']/parent::*/child::android.widget.EditText");
//  Source Of Funds List
    public static By objList = By.xpath("//*[@class='android.widget.ScrollView']/child::*/child::*/child::*/child::android.widget.TextView");
    public static By objList(int listElement) {
        return By.xpath("(//*[@class='android.widget.ScrollView']/child::*/child::*/child::*/child::android.widget.TextView)["+listElement+"]");
    }
//  Source of funds page
    public static By objSourceOfFundsPage = By.xpath("//*[@text='What are your sources of funds?']");
//  What's your current employment status?
    public static By objCurrentEmploymentStatusPage = By.xpath("//*[@text='What's your current employment status?']");
//  select Source of Funds
    public static By objSelectSourceOfFunds(String sourceOfFund){
        return By.xpath("//*[contains(@text,'"+sourceOfFund+"')]");
    }
//  select Current employment status
    public static By objSelectCurrentEmploymentStatus(String currentEmploymentStatus){
        return By.xpath("//*[contains(@text,'"+currentEmploymentStatus+"')]");
    }
//  select nature of Work
    public static By objSelectNatureOfWork(String natureOfWork){
        return By.xpath("//*[contains(@text,'"+natureOfWork+"')]");
    }
//  Industry
    public static By objSelectIndustry(String industry){
        return By.xpath("//*[contains(@text,'"+industry+"')]");
    }

//  What do you do?
    public static By objWhatDoYouDoPage = By.xpath("//*[@text='What do you do?']");
//  Are you sure you are not...
    public static By objFATCAPageTitle = By.xpath("//*[@text='Are you sure you are not...']");
//  A USA Citizen
    public static By objAUSACitizen = By.xpath("//*[@text='A USA Citizen']");
//  A USA Green Card Holder
    public static By objGreenCardHolder = By.xpath("//*[@text='A USA Green Card Holder']");
//  A USA Resident
    public static By objUSAResident = By.xpath("//*[@text='A USA Resident']");
//  None of the above
    public static By objNoneOfTheAbove = By.xpath("//*[@text='None of the above']");
//  Email address
    public static By objEmailAddress = By.xpath("//*[@text='Email address']/parent::*/child::android.widget.EditText");
//  Mother's maiden name
    public static By objMotherMaidenName = By.xpath("//*[@text=\"Mother's maiden name\"]/parent::*/child::android.widget.EditText");
//  Define our banking relationship
    public static By objDefineOurBankingRelationship = By.xpath("//*[@text='Define our banking relationship']/parent::*/child::android.widget.EditText");
//  I plan to transact more than ₱500,000 per month
    public static By objMoreTransitionText = By.xpath("//*[@text='I plan to transact more than ₱500,000 per month']");
//  I plan to transact more than ₱500,000 per month Switch slider
    public static By objMoreTransitionTextSwitchSlider = By.xpath("//*[@text='I plan to transact more than ₱500,000 per month']/following-sibling::*/child::*");
//  banking relation
    public static By objSelectBankingRelationship(String relationship){
        return By.xpath("//*[contains(@text,\""+relationship+"\")]");
    }
//  Please enter a valid email address
    public static By objInvalidEmailAddressErrorMessage = By.xpath("//*[@text='Please enter a valid email address']");
//  Email address cannot be blank
    public static By objBlankEmailAddressErrorMessage = By.xpath("//*[@text='Email address cannot be blank']");
//  Please enter a valid Mother's maiden name
    public static By objInvalidMotherMaidenName = By.xpath("//*[@text=\"Please enter a valid Mother's maiden name\"]");
//  Please enter alphabets only
    public static By objInvalidMotherMaidenNameErrorMsg = By.xpath("//*[@text='Please enter alphabets only']");
//  Blank mother maiden name
    public static By objBlankMotherMaidenName = By.xpath("//*[@text=\"Mother's maiden name cannot be blank\"]");
//  Purpose of account
    public static By objPurposeOfAccount = By.xpath("//*[@text='Define our banking relationship']/parent::*/following-sibling::*/child::*/child::*/child::android.widget.TextView");
    public static By objPurposeOfAccount(int sPurpose) {
        return By.xpath("(//*[@text='Define our banking relationship']/parent::*/following-sibling::*/child::*/child::*/child::android.widget.TextView)["+sPurpose+"]");
    }
//  Define our banking relationship
    public static By objDefineBankingRelationshipPopup = By.xpath("//*[@text='Define our banking relationship']");
//  What will you use the account for?
    public static By objPurposeOfAccountTxt = By.xpath("//*[@text='What will you use the account for?']");
//  It's personal option
    public static By objPersonalOption = By.xpath("//*[@text=\"It's personal\"]");
//  It's all business option
    public static By objBusinessOption = By.xpath("//*[@text=\"It's all business\"]");
//  For my remittances option
    public static By objRemittancesOption = By.xpath("//*[@text=\"For my remittances\"]");
//  Eraser icon
    public static By objEraserIcon = By.xpath("//android.widget.LinearLayout/following-sibling::android.view.ViewGroup");

//  Lets Seal The Deal Page
    public static By objLetsSealTheDealPage = By.xpath("//*[contains(@text,'seal the deal')]");
//  Next btn Info
    public static By objNextBtnInfo = By.xpath("//*[contains(@text,'By tapping')]");
//  Couple more things
    public static By objCoupleMoreThinsPage = By.xpath("//*[contains(@text,'A couple more things')]");
//  Signature screen
    public static By objSignatureScreen = By.xpath("//android.widget.LinearLayout/child::*");
//  How to login page
    public static By objHowToLoginPage = By.xpath("//*[@text='How to login']");

//  LoginStep1
    public static By objLoginStep1 = By.xpath("//*[@text='Enter your registered mobile number']");

//  LoginStep2
    public static By objLoginStep2 = By.xpath("//*[@text='Take a Face Identity Scan']");

//  LoginStep3
    public static By objLoginStep3 = By.xpath("//*[@text='Reset your password']");

//  LoginStep1Info
    public static By objLoginStep1Info = By.xpath("//*[@text='If your registered mobile number is unavailable, please contact us.']");

//  LoginStep2Info
    public static By objLoginStep2Info = By.xpath("//*[@text='We need to confirm your identity again since you are trying to log in on a new device.']");

//  LoginStep3Info
    public static By objLoginStep3Info = By.xpath("//*[@text='For security reasons, we have to ask you to update your password.']");

//  Verify mobile number
    public static By objVerifyMobileNumberPage = By.xpath("//*[@text='Verify mobile number']");

//  Please enter your mobile number.
    public static By objVerifyMobileNumberPageSubTitle = By.xpath("//*[@text='Please enter your mobile number.']");

//  Try Again Btn
    public static By objTryAgainBtn = By.xpath("//*[@text='Try again']");

//  Change Registered Mobile Number
    public static By objChangeRegisteredMobileNumber = By.xpath("//*[@text='Change my registered mobile number']");

//  Invalid Mobile Number Popup
    public static By objInvalidMobileNumberPopup = By.xpath("//*[@resource-id='com.tonik.mobile:id/Popup_sub_header_txt']     ");

//  Get In Touch With Customer Care Page
    public static By objGetInTouchWithCustomerCarePage = By.xpath("//*[contains(@text,'Get in touch')]");

//
    public static By objGetInTouchWithCustomerCarePageInfo = By.xpath("//*[contains(@text,'For security reasons')]");

//  Contact Tonik Btn
    public static By objContactTonikBtn = By.xpath("//*[@text='Contact Tonik']");

//  Close Btn
    public static By objCloseBtn = By.xpath("//*[@text='Close']");

//  Existing Tonik Customer Popup
    public static By objExistingTonikCustomerPopup = By.xpath("//*[contains(@text,'We already have this number')]");

//
    public static By objEnterNewNumber = By.xpath("//*[@text='Enter new number']");

//  LogIn To Tonik
    public static By objLogInToTonik = By.xpath("//*[@text='Log in to Tonik']");

//
    public static By objHeresTheDeal = By.xpath("//*[@text='Here’s the deal']");

//  Feature1
    public static By objFeature1 = By.xpath("//*[@text='No minimum balance, no dormancy fees, no minimum deposits, no account closure fees']");

//  Feature2
    public static By objFeature2 = By.xpath("//*[@text='Open up to 5 Solo and Group Stashes']");

//  Feature3
    public static By objFeature3 = By.xpath("//*[@text='Open up to 5 Time Deposit accounts']");

//  Feature4
    public static By objFeature4 = By.xpath("//*[@text='Free transfers to other banks.']");

//  Feature5
    public static By objFeature5 = By.xpath("//*[@text='Free virtual card']");

//  Feature6
    public static By objFeature6 = By.xpath("//*[@text='Free Tonik to Tonik transfers.']");

//  Feature7
    public static By objFeature7 = By.xpath("//*[@text='Free hugs!']");

//  Deal button
    public static By objDeal = By.xpath("//*[@text='DEAL!']");

//  Create a Password
    public static By objCreateAPassword = By.xpath("//*[@text='Create a password']");

//  Password Rule
    public static By objPasswordRule(int rule){
        return By.xpath("(//*[@resource-id='com.tonik.mobile:id/rules_main']/child::*/child::android.widget.TextView)["+rule+"]");
    }

    public static By objPasswordRule = By.xpath("//*[@resource-id='com.tonik.mobile:id/rules_main']/child::*/child::android.widget.TextView");

//  Password field
    public static By objPasswordField = By.xpath("//*[@resource-id='com.tonik.mobile:id/pin']");

//  Confirm Password field
    public static By objConfirmPasswordField = By.xpath("//*[@resource-id='com.tonik.mobile:id/confirm']");

//  Terms And Condition Page Title
    public static By objTermsAndConditionPageTitle = By.xpath("//*[contains(@text,'A few house rules')]");
//  Industry last option
    public static By objIndustryLastOption = By.xpath("//*[@text='Wholesale and Retail Trade']");
//  Nature of work last option
    public static By objNatureOfWorkLastOption = By.xpath("//*[@text='Other Professional services']");
//  password suggestion popup
    public static By objPasswordSuggestionPopup = By.xpath("//*[@resource-id='com.tonik.mobile:id/tvPasswordTitle']");
//  Password Suggestion
    public static By objPasswordSuggestion = By.xpath("//*[@resource-id='com.tonik.mobile:id/tvInfo']");
//  Password Suggestion
    public static By objPasswordSuggestion(int passwordSuggestion){
        return By.xpath("(//*[@resource-id='com.tonik.mobile:id/tvInfo'])["+passwordSuggestion+"]");
    }
//  Got it
    public static By objGotItBtn = By.xpath("//*[@resource-id='com.tonik.mobile:id/btnGotIt']");
//  Password Mismatch Error
    public static By objPasswordMismatchError = By.xpath("//*[@text='Passwords did not match']");
//  Password Suggestion Check Box
    public static By objPasswordSuggestionCheckBox(int checkBox) {
        return By.xpath("//*[@resource-id='com.tonik.mobile:id/img_rule"+checkBox+"']");
    }
//  Your Tonik Bank Header
    public static By objYourTonikBankHeader = By.xpath("//*[@text='Your tonik account']");
//  Available Balance
    public static By objAvailableBalance = By.xpath("(//*[contains(@text,'₱')])[1]");
//  Top up Icon
    public static By objTopUpIcon = By.xpath("//*[@text='Top up']/preceding-sibling::*/child::*");
//  Send Icon
    public static By objSendIcon = By.xpath("//*[@text='Send']/preceding-sibling::*/child::*");
//  Pay Icon
    public static By objPayIcon = By.xpath("//*[@text='Pay']/preceding-sibling::*/child::*");
//  History Icon
    public static By objHistoryIcon = By.xpath("//*[@text='History']/preceding-sibling::*/child::*");
//  Dashboard Customer Care Icon
    public static By objDashboardCustomerCareIcon = By.xpath("//*[@resource-id='appbar-content']/following-sibling::android.view.ViewGroup");
//  Virtual card
    public static By objVirtualCard = By.xpath("//*[contains(@text,'Virtual Card')]/parent::*/parent::*/parent::*");
//  Debit card
    public static By objDebitCard = By.xpath("//*[contains(@text,'Debit Card')]/parent::*/parent::*/parent::*");
//  Your other accounts
    public static By objYourOtherAccountsHeader = By.xpath("//*[@text='Your other accounts']");
//  Stash tile
    public static By objStashTile = By.xpath("//*[@text='Stashes']");
//  Stash tile info
    public static By objStashTileInfo = By.xpath("//*[@text='Stashes']/following-sibling::android.widget.TextView");
//  Time Deposit tile
    public static By objTimeDepositTile = By.xpath("//*[@text='Time Deposit']");
//  Time Deposit tile info
    public static By objTimeDepositTileInfo = By.xpath("//*[@text='Time Deposit']/following-sibling::android.widget.TextView");
//  Loans tile
    public static By objLoansTile = By.xpath("//*[@text='Loans']");
//  Loans tile info
    public static By objLoansTileInfo = By.xpath("//*[@text='Loans']/following-sibling::android.widget.TextView");

//  Welcome to Tonik, hun!
    public static By objDashBoardWelcomeScreen = By.xpath("//*[@text='Welcome to Tonik, hun!']");
//  Your neobanking romance starts now
    public static By objWelcomeInfo = By.xpath("//*[@text='Your neobanking romance starts now']");
//  Borrow tile
    public static By objBorrow = By.xpath("//*[@text='Borrow']");
//  Borrow Info
    public static By objBorrowInfo = By.xpath("//*[@text='Find the right loan that fits your needs and wants. One day approval.']");
//  Borrow Learn More
    public static By objBorrowLearnMore = By.xpath("(//*[@text='Learn more'])[1]");

    public static By objSave = By.xpath("//*[@text='Save']");

    public static By objSaveLearnMore = By.xpath("(//*[@text='Learn more'])[2]");

    public static By objSaveInfo = By.xpath("//*[@text='Fall in love with BIG savings - get up to 6% p.a.']");

    public static By objExploreNow = By.xpath("//*[@text='I want to Explore']");

    public static By objIWillDoItBtn = By.xpath("//*[contains(@text,'ll do it later, pinky swear')]");

    public static By objBorrowScreenTitle = By.xpath("//*[@text='Need fast cash or easy payments?']");

    public static By objTileHeader(int header) {
        return By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_header"+header+"']");
    }

    public static By objTileName(int header,int tileName){
        return By.xpath("(//*[@resource-id='com.tonik.mobile:id/Txt_header"+header+"']/following-sibling::*)["+tileName+"]");
    }

    public static By objSubtitle(int subtitle){
        return By.xpath("//*[@resource-id='com.tonik.mobile:id/Txt_sub_title"+subtitle+"']");
    }
//  Review in progress
    public static By objReviewInProgress = By.xpath("//*[@text='Review in progress']");
//  Review In Progress info 1
    public static By objReviewInProgressInfo1 = By.xpath("//*[contains(@text,'We now have to review your application before we can open your Tonik')]");
//  Review In Progress info 2
    public static By objReviewInProgressInfo2 = By.xpath("//*[contains(@text,'This review will take around 1 working days')]");
//  Contact Tonik Customer Care
    public static By objContactTonikCustomerCare = By.xpath("//*[contains(@text,'Customer Care')]");
//  Close the app
    public static By objCloseTheApp = By.xpath("//*[@text='Close the app']");
//  Got It
    public static By objGotItButton = By.xpath("//*[contains(@text,'Got it')]");
//  This is really hard for us
    public static By objBlockedUSCitizenPage = By.xpath("//*[contains(@text,'This is really hard for us')]");
//  Blocked US Citizen Info
    public static By objBlockedUSCitizenInfo = By.xpath("//*[contains(@text,'we are unable to open a Tonik account')]");

}



