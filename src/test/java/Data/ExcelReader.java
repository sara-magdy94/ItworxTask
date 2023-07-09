package Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

static FileInputStream fis = null ; 
	
	public FileInputStream getFileInputStream() 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/Data/MySheet.xlsx"; 
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found. treminating Process !! : Check file path of TestData");
			System.exit(0);
		}
		return fis ; 
	}
	
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream(); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 4 ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}

}
//
//    private static final String FILE_NAME = System.getProperty("user.dir")+ "/src/test/java/Data/LastUserData11.xlsx";
//    private static final String SHEET_NAME = "Sheet1";
//
//    public static void main(String[] args) {
//
//        try (FileInputStream file = new FileInputStream(FILE_NAME)) {
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            Sheet sheet = workbook.getSheet(SHEET_NAME);
//
//            // Read data from the sheet
//            for (Row row : sheet) {
//                Cell EmailCell = row.getCell(0);
//                Cell passwordCell = row.getCell(1);
//                Cell CourseNameCell = row.getCell(2);
//                Cell CourseSubjectCell = row.getCell(3);
//                Cell CoursegradeCell = row.getCell(4);
//                String username = EmailCell.getStringCellValue();
//                String password = passwordCell.getStringCellValue();
//                String CourseName = CourseNameCell.getStringCellValue();
//                String CourseSubject = CourseSubjectCell.getStringCellValue();
//                String Coursegrade = CoursegradeCell.getStringCellValue();
//
//                System.out.println("Username: " + username + ", Password: " + password + ", CourseName: " + CourseName + ", CourseSubject: " + CourseSubject
//                		+ ", Coursegrade: " +	Coursegrade	);
//            }
//
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

