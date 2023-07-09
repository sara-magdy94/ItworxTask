package Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import Data.ExcelReaderForSignUp;
////import Tests.TestPase;
//import Utilities.ElementInteractionsUtilities;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
		
	}
	
	

	// EmailTxtBox field locator
	@FindBy(id = "Email")
		WebElement EmailTxtBox;

	// SignInPasswordlTxtBox field locator
	@FindBy(id = "inputPassword")
	WebElement SignInPasswordlTxtBox;
	

	@FindBy(id = "btnLogin")
	WebElement LoginBtn;
	

	
	@Test(dataProvider = "MyData")
	public void UserLogin( String Email , String Password) {
		
		SetTextElementText(EmailTxtBox , Email);
		SetTextElementText(SignInPasswordlTxtBox , Password);
		
		Clickbtn(LoginBtn);
		
	}
	
	
	
}