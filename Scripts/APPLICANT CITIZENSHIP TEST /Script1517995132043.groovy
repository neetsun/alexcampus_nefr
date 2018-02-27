import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://sit104.sit.startinpoint.com:9080/FEBWrapperApp/')

WebUI.waitForPageLoad(5)

WebUI.waitForElementPresent(findTestObject('Test Link Page_IFrame/testlink_inputField'), 5)

WebUI.setText(findTestObject('Test Link Page_IFrame/testlink_inputField'), testlink)

WebUI.click(findTestObject('Test Link Page_IFrame/testlink_btn'))

WebUI.waitForPageLoad(10)

WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/iframeid'), 3)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Applicant Tab/Citizenship/Citizenship Label'), 0)

if (!(WebUI.verifyElementPresent(findTestObject('Applicant Tab/td_Applicants Name_div_label'), 0))) {
    WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/form_ISH_COMNCLEN1.101'), 5)

    WebUI.setText(findTestObject('Test Link Page_IFrame/input_j_username'), 'alexadmin')

    WebUI.setText(findTestObject('Test Link Page_IFrame/input_j_password'), 'P@ger123')

    WebUI.click(findTestObject('Test Link Page_IFrame/input_lotusBtn'))

    WebUI.verifyElementPresent(findTestObject('Applicant Tab/Citizenship/Citizenship Label'), 5)
}

WebUI.verifyElementText(findTestObject('Applicant Tab/Citizenship/Citizenship Label'), 'Citizenship')

WebUI.verifyElementPresent(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Value - Singapore Citizen '), 
    0)

WebUI.verifyElementText(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Label - Singapore Citizen'), 
    'Singapore Citizen')

WebUI.verifyElementPresent(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Value - Permanent Resident'), 
    0)

WebUI.verifyElementText(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Label - Permanent Resident'), 
    'Permanent Resident')

WebUI.verifyElementPresent(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Value - Foreigner'), 0)

WebUI.verifyElementText(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Label - Foreigner'), 'Foreigner')

switch (docty_grp) {
    case 'A':
        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Value - Singapore Citizen '), 
            'aria-checked', 'true', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Value - Permanent Resident'), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Value - Foreigner'), 
            'aria-checked', 'false', 0)

        break
    case 'B':
        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Value - Singapore Citizen '), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Value - Permanent Resident'), 
            'aria-checked', 'true', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Value - Foreigner'), 
            'aria-checked', 'false', 0)

        break
    case 'C':
        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Value - Singapore Citizen '), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Value - Permanent Resident'), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Value - Foreigner'), 
            'aria-checked', 'true', 0)

        break
    case 'D':
        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Value - Singapore Citizen '), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Value - Permanent Resident'), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Value - Foreigner'), 
            'aria-checked', 'true', 0)

        break
    default:
        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 1 Value - Singapore Citizen '), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 2 Value - Permanent Resident'), 
            'aria-checked', 'false', 0)

        WebUI.verifyElementAttributeValue(findTestObject('Applicant Tab/Citizenship/Citizenship Radiobutton 3 Value - Foreigner'), 
            'aria-checked', 'false', 0)

        break
}

WebUI.scrollToElement(findTestObject('Test Link Page_IFrame/Save as Draft btn'), 2)

WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/Save as Draft btn'), 0)

WebUI.click(findTestObject('Test Link Page_IFrame/Save as Draft btn'))

WebUI.delay(5)

WebUI.click(findTestObject('Test Link Page_IFrame/OK btn of Save as draft dialog box'))

WebUI.closeBrowser()

