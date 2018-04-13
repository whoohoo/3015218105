package lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTest {
  private ArrayList<String> nameList;
  private ArrayList<String> pwList;
  private ArrayList<String> urlList;
  private String pw,name,url,test;
  private int number;
  

  @Before
  public void setUp() throws IOException {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
      WebDriver driver =new ChromeDriver();
      try {          
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        
      } catch (Exception e) {
          e.printStackTrace();
      }
      
      File file = new File("C:\\Users\\27655\\eclipse-workspace\\lab2\\docs\\input.xlsx");
      nameList = new ArrayList<String>(); 
      pwList = new ArrayList<String>(); 
      urlList = new ArrayList<String>();
      
      InputStream is = new FileInputStream(file);
      XSSFWorkbook wb = new XSSFWorkbook(is);
      XSSFSheet sheet = wb.getSheetAt(0);
      number = sheet.getLastRowNum();
      
      for (int i = 0; i <= number; i++) {    
          XSSFRow row = sheet.getRow(i);// 获取行对象       
          if (row == null) {// 如果为空，不处理    
              continue;    
          }
          DataFormatter formatter = new DataFormatter();
         // XSSFCell cell = row.getCell(0);
          name = formatter.formatCellValue(sheet.getRow(i).getCell(0));
          nameList.add(name);
          pw = name.substring(4, 10);
          pwList.add(pw);
          
          XSSFCell cell = row.getCell(1);
           if (cell == null) {// 单元格为空设置为空串    
        	   url = "";
        	   urlList.add(url);
           }else {
         	  url = cell.getStringCellValue();
         	  urlList.add(url);
           }
      }
     
 
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
      WebDriver driver =new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
	  for(int i=0;i<nameList.size();i++) {
		  
		  driver.get("https://psych.liebes.top/st");
		  driver.findElement(By.id("username")).click();
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys(nameList.get(i));
		  driver.findElement(By.id("password")).click();
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys(pwList.get(i));
		  driver.findElement(By.id("submitButton")).click();
		  test = driver.findElement(By.xpath("//p")).getText(); 
			 if(test.equals(urlList.get(i))) {
				 System.out.println(nameList.get(i)+urlList.get(i)+": success!");
			 }else {
				 System.out.println(nameList.get(i)+urlList.get(i)+": failed!");
			 }

		 
	  }
   
  }

  @After
  public void tearDown() throws Exception {
    //driver.close();
    
  }
}
