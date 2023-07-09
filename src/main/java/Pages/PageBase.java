package Pages;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {

	

	protected WebDriver driver ;


	//create constractor
	public PageBase (WebDriver Driver) {
		PageFactory.initElements(Driver,this);


	}
	
	
	// click on btn
	protected  static void Clickbtn(WebElement button) {
		
		button.click();
	}
	
	// send text to element by value
protected  static void SetTextElementText(WebElement TextElement , String value ) 
{
		
	TextElement.sendKeys(value);
	}
//select from drop down by Index
protected  static void selectIndexFromDropDown(WebElement TextElement , int value ) 
{
	Select select = new Select(TextElement);
	select.selectByIndex(value);
	}
//select from drop down by Value
protected  static void selectValueFromDropDown(WebElement TextElement ,String value ) 
{
	Select select = new Select(TextElement);
	select.selectByValue(value);
	}

public static void clickBack(WebDriver driver ) 
{

	driver.navigate().back();
	driver.navigate().back();
	Alert alert = driver.switchTo().alert();
	alert.accept();	}
	}


