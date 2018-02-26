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
import java.lang.String as String

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

if (WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/input_j_username'), 0)) {
    WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/form_ISH_COMNCLEN1.101'), 5)

    WebUI.setText(findTestObject('Test Link Page_IFrame/input_j_username'), 'alexadmin')

    WebUI.setText(findTestObject('Test Link Page_IFrame/input_j_password'), 'P@ger123')

    WebUI.click(findTestObject('Test Link Page_IFrame/input_lotusBtn'))

    WebUI.verifyElementPresent(findTestObject('Applicant Tab/td_Applicants Name_div_label'), 5)
}

applicantAdd = WebUI.getText(findTestObject('Applicant Tab/Main Residential Address Field '))

WebUI.click(findTestObject('My Details Tab/My Details tab btn'))

WebUI.verifyElementText(findTestObject('My Details Tab/My Name label'), 'My Name(s)')

WebUI.verifyElementAttributeValue(findTestObject('My Details Tab/My Name Field'), 'value', '', 0)

WebUI.verifyElementText(findTestObject('My Details Tab/My NRIC label'), 'My NRIC/Passport Number(s)')

WebUI.verifyElementAttributeValue(findTestObject('My Details Tab/My NRIC Field'), 'value', '', 0)

WebUI.verifyElementText(findTestObject('My Details Tab/Passport checkbox label'), 'Passport ?')

WebUI.verifyElementPresent(findTestObject('My Details Tab/Passport checkbox'), 0)

WebUI.verifyElementText(findTestObject('My Details Tab/Residential Address label'), 'My Residential Address(es)')

WebUI.verifyElementAttributeValue(findTestObject('My Details Tab/Residential Address Field'), 'value', '', 0)

WebUI.verifyElementText(findTestObject('My Details Tab/Same address checkbox label'), 'Same address as Applicant')

if (O_CONSTYP == 'CN') {
    WebUI.verifyElementHasAttribute(findTestObject('My Details Tab/My Name Field'), 'disabled', 0)

    WebUI.verifyElementHasAttribute(findTestObject('My Details Tab/My NRIC Field'), 'disabled', 0)

    WebUI.verifyElementHasAttribute(findTestObject('My Details Tab/Residential Address Field'), 'disabled', 0)

    WebUI.verifyElementText(findTestObject('My Details Tab/Residential Address Field'), '', FailureHandling.STOP_ON_FAILURE)
} else if ((O_CONSTYP == 'CI') || (O_CONSTYP == 'CM')) {
    WebUI.verifyElementVisibleInViewport(findTestObject('My Details Tab/My Name Field Invalid Msg '), 0)

    WebUI.verifyElementText(findTestObject('My Details Tab/My Name Field Invalid Msg '), 'This value is required.')

    WebUI.setText(findTestObject('My Details Tab/My Name Field'), 'Phua Sing Tat')

    WebUI.click(findTestObject('My Details Tab/My Name label'))

    WebUI.verifyElementNotVisibleInViewport(findTestObject('My Details Tab/My Name Field Invalid Msg '), 0)

    WebUI.verifyElementVisibleInViewport(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 0)

    WebUI.verifyElementText(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 'This value is required.')

    WebUI.setText(findTestObject('My Details Tab/My NRIC Field'), 'S1234567G', FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('My Details Tab/My Name label'))

    WebUI.verifyElementText(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 'NRIC is not valid. Please check your NRIC.')

    WebUI.check(findTestObject('My Details Tab/Passport checkbox'))

    WebUI.verifyElementNotVisibleInViewport(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 0)

    WebUI.uncheck(findTestObject('My Details Tab/Passport checkbox'))

    WebUI.verifyElementText(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 'NRIC is not valid. Please check your NRIC.')

    WebUI.clearText(findTestObject('My Details Tab/My NRIC Field'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('My Details Tab/My Name label'))

    WebUI.verifyElementText(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 'This value is required.')

    WebUI.setText(findTestObject('My Details Tab/My NRIC Field'), 'T0648142B')

    WebUI.click(findTestObject('My Details Tab/My Name label'))

    WebUI.verifyElementNotVisibleInViewport(findTestObject('My Details Tab/My NRIC Field Invalid Msg'), 0)

    WebUI.setText(findTestObject('My Details Tab/Residential Address Field'), 'Blk 444 Chin Chee Ave #09-189')

    WebUI.check(findTestObject('My Details Tab/Same address checkbox'))

    WebUI.verifyElementHasAttribute(findTestObject('My Details Tab/Residential Address Field'), 'disabled', 0)

    myDetailsAdd = WebUI.getText(findTestObject('My Details Tab/Residential Address Field'))

    WebUI.verifyMatch(applicantAdd, myDetailsAdd, false)

    WebUI.uncheck(findTestObject('My Details Tab/Same address checkbox'))

    WebUI.verifyElementNotHasAttribute(findTestObject('My Details Tab/Residential Address Field'), 'disabled', 0)

    WebUI.verifyElementText(findTestObject('My Details Tab/Residential Address Field'), '', FailureHandling.STOP_ON_FAILURE)

    if (O_CONSTYP == 'CM') {
        WebUI.verifyElementHasAttribute(findTestObject('My Details Tab/I_GUARD checkbox'), 'disabled', 0)

        WebUI.verifyElementNotHasAttribute(findTestObject('My Details Tab/I_DONEE checkbox'), 'disabled', 0)

        WebUI.check(findTestObject('My Details Tab/I_DONEE checkbox'))
    } else {
        WebUI.verifyElementHasAttribute(findTestObject('My Details Tab/I_DONEE checkbox'), 'disabled', 0)

        WebUI.verifyElementNotHasAttribute(findTestObject('My Details Tab/I_GUARD checkbox'), 'disabled', 0)

        WebUI.check(findTestObject('My Details Tab/I_GUARD checkbox'))
    }
}

WebUI.scrollToElement(findTestObject('Test Link Page_IFrame/Save as Draft btn'), 2)

WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/Save as Draft btn'), 0)

WebUI.click(findTestObject('Test Link Page_IFrame/Save as Draft btn'))

WebUI.delay(5)

WebUI.verifyElementPresent(findTestObject('Test Link Page_IFrame/OK btn of Save as draft dialog box'), 0)

WebUI.click(findTestObject('Test Link Page_IFrame/OK btn of Save as draft dialog box'))

WebUI.closeBrowser()

