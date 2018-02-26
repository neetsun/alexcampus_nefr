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
import java.lang.ProcessEnvironment$StringValues as StringValues
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString as SubString
import org.jsoup.select.Evaluator$ContainsText as ContainsText

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://sit104:9180/forms/secure/org/app/b6136cf0-7f49-40d9-8905-15a0aa0d8ba4/launch/index.html?form=F_Form1')

WebUI.setText(findTestObject('Direct Form Test/input_j_username (1)'), 'wasadmin')

WebUI.setText(findTestObject('Direct Form Test/input_j_password (1)'), 'P@ger123')

WebUI.click(findTestObject('Direct Form Test/input_lotusBtn'))

mainAdd = WebUI.getText(findTestObject('Direct Form Test/TEST Main Residential Address Field '))

WebUI.click(findTestObject('Direct Form Test/My Details tab btn test'))

not_run: WebUI.verifyElementPresent(findTestObject('My Details Tab/Same address checkbox label'), 0)

not_run: WebUI.verifyElementText(findTestObject('My Details Tab/Same address checkbox label'), 'Same address as Applicant')

WebUI.setText(findTestObject('Direct Form Test/TEST My Details - Residential Address Field'), 'Blk 444 Chin Chee Ave #09-189')

WebUI.check(findTestObject('My Details Tab/Same address checkbox'))

address = WebUI.getText(findTestObject('Direct Form Test/TEST My Details - Residential Address Field'))

WebUI.verifyMatch(mainAdd, address, false)

WebUI.uncheck(findTestObject('My Details Tab/Same address checkbox'))

WebUI.getText(findTestObject('Direct Form Test/TEST My Details - Residential Address Field'))

not_run: attributeValue = WebUI.getAttribute(findTestObject('null'), 'class')

not_run: WebUI.verifyMatch(attributeValue, '.*lfFormFieldDisabled$', true, FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('My Details Tab/My NRIC Field'), 'value', '', 0)

not_run: WebUI.closeBrowser()

