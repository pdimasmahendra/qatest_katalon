import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser("https://the-internet.herokuapp.com/tables")
WebDriver driver = DriverFactory.getWebDriver()
driver.findElement(By.xpath("//table[@id='table1']//span[contains(.,'Last Name')]")).click()


List<WebElement> tableElements = driver.findElements(By.cssSelector("#table1 tr td:nth-child(1)"));
ArrayList<String> tableValues = new ArrayList<String>();
for(int i=0; i < tableElements.size(); i++){
    String str = tableElements.get(i).getText();
    tableValues.add(str);
}

ArrayList<String> referenceValues = new ArrayList<String>();
for(int i=0; i < tableValues.size(); i++){
    referenceValues.add(tableValues.get(i))         
}

Collections.sort(referenceValues)

assert referenceValues.equals(tableValues)