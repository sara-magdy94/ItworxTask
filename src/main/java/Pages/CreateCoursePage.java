package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateCoursePage extends PageBase {

	public CreateCoursePage(WebDriver Driver) {
		super(Driver);
		
	}

	

//	// CoursesBtn field locator
	@FindBy(xpath = "//a[@id='btnMyCoursesList']/em[1]")
	WebElement CoursesBtn;

    //AddCourseBtn field locator
	@FindBy(xpath = "//button[@id='btnListAddCourse']")
	WebElement AddCourseBtn;
	
	
// SignUpEmailTxtBox field locator
	@FindBy(id = "txtCourseName")
	WebElement CourseNameField;
	
//SubjectField field locator
	@FindBy(id = "courseSubject")
	WebElement SubjectField;

//	GradeField  locator
	@FindBy(id = "courseGrade")
	WebElement CourseGradeDropdown;

	
	
//	CourseTeacherField  locator
	@FindBy(xpath = "//span[@aria-label='Course Teacher activate']")
	WebElement CourseTeacher;
	
	//SelectCourseTeacherField  locator
	@FindBy(xpath = "//span[@class= 'ui-select-choices-row-inner']")
	WebElement SelectCourseTeacher;

	
  //Save locator
	@FindBy(id = "btnSaveAsDraftCourse")
	WebElement btnSave;

	//SuccessMsg locator
  @FindBy(xpath = "//div[@class='toast-title']")
  WebElement SuccessMsg;
	
	
	//CoursesBtn2 locator
	@FindBy(xpath = "//a[@id='btnMyCoursesList']/em[1]")
	WebElement CoursesBtn2;
	
	
	//SearchField  locator
	@FindBy(id = "txtCourseSearch")
  WebElement SearchField;
	
	//SearchBarBtn  locator
	@FindBy(xpath = "//button[@id='btnCourseSearch']//em")
	WebElement SearchBarBtn;
	
	
	//CreatedCourseTitle  locator
	@FindBy(xpath = "//a[@title='SaraMv12345']")
	WebElement CreatedCourseTitle;
	
	
	
	
	
	public void create_Course(WebDriver driver, String Name, String Grade) throws Throwable {
	
		Clickbtn(CoursesBtn);
		Clickbtn(AddCourseBtn);
		
		SetTextElementText(CourseNameField , Name);
		//SetTextElementText(SubjectField , Subject);
		selectValueFromDropDown(CourseGradeDropdown , Grade);
		Clickbtn(CourseTeacher);
		Clickbtn(SelectCourseTeacher);
		Clickbtn(btnSave);
		
		String Text3 = SuccessMsg.getText();
		System.out.println("The course has been " +Text3);
		Assert.assertEquals(Text3,"Successfully added");
	

	}

	public void AssertOn_Coursetitle(WebDriver driver , String Searchtext ) {
		
		
		Clickbtn(CoursesBtn2);
		SetTextElementText(SearchField , Searchtext);
		Clickbtn(SearchBarBtn);
		String Title = CreatedCourseTitle.getText();
		Assert.assertEquals(Title,"SaraMv12345");
		System.out.println("The course Title found is  " + Title);
		
	}
	
		
	}
	

	
	
	
