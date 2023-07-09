package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.CreateCoursePage;
import Pages.PageBase;
import Pages.UserRegisterationPage;

import org.openqa.selenium.*;
public class CreatCourseTest extends TestPase {



	public static WebDriver driver;
	private WebDriverWait wait;
	
	CreateCoursePage createCourseObject;
	UserRegisterationPage userRegisterationObject;
	
	@DataProvider(name="MyData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test(priority=1 , alwaysRun = true ,dataProvider = "MyData")
	public void UserCanLogin_AndCreateCourse(String Email, String password , String CourseName , String Grade ) throws Throwable {


		userRegisterationObject = new UserRegisterationPage(TestPase.driver);

		userRegisterationObject.UserLogin(Email,  password);
		createCourseObject = new CreateCoursePage(TestPase.driver);

		createCourseObject.create_Course(driver, CourseName , Grade);
	PageBase.clickBack(TestPase.driver);
	createCourseObject.AssertOn_Coursetitle(driver, CourseName);

	}



}