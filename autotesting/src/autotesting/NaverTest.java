package autotesting;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.MethodSorters;
 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NaverTest
	{
    private static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static String CHROMEDRIVER_FILE_PATH;
 
    @BeforeClass
    public static void setUp() throws Exception
    {
 
        CHROMEDRIVER_FILE_PATH = "D:/Automation/chromedriver.exe";	// ũ�� ����̹� ���� ���
 
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
        driver = new ChromeDriver();
    }
 
    @Test // ���� ����Ʈ ����
    public void TC0001() throws Exception 
    {
        driver.get("http://www.naver.com");	// �⺻ ����Ʈ �ּ�
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @Test // ���� �޴� ����
    public void TC0002() throws Exception 
    {
    	//driver.findElement(By.xpath(".//div[@className='disaster-popup']/close")).click();
    	//driver.findElement(By.className("more")).click();
    	driver.findElement(By.linkText("����")).click();
    }
    
    @Test // RNB �޴� �α��� ��ư ����
    public void TC0003() throws Exception 
    {
    	//driver.findElement(By.xpath(".//div[@className='disaster-popup']/close")).click();
    	driver.findElement(By.className("btn_login")).click();
    }
    
    @Test // ���̵� �Է�
    public void TC0004() throws Exception 
    {
       	driver.findElement(By.id("id")).sendKeys("LoginID");

    }
 
    @Test // ��й�ȣ ���Է�
    public void TC0005() throws Exception 
    {
    	driver.findElement(By.id("pw")).sendKeys("");
    }
    
    @Test // �α��� ��ư Ŭ��
    public void TC0006() throws Exception 
    {
    	driver.findElement(By.className("btn_global")).click();
    }
    
    @Test // ��й�ȣ �Է� ���̵� ���� Ȯ��
    public void TC0007() throws Exception
    {
    	String ErrorPassText = driver.findElement(By.id("err_empty_pw")).getText();
    	if (ErrorPassText.equalsIgnoreCase("��й�ȣ�� �Է����ּ���.")!=true)
    	{
    		throw new Exception();
        }
    	
    }	
    
    @Test // �α��� ���� ���� Ŭ�� (�α��� ���� ��� ���� Ȯ��)
    public void TC0008() throws Exception
    {
    	driver.findElement(By.id("label_login_chk")).click();
    	//WebElement TextCheck1 = driver.findElement(By.className("login_check_box"));
    	WebElement TextCheck2 = driver.findElement(By.xpath(".//span[@class='login_check_box']/sp on"));
    	String TextCheck3 = TextCheck2.getText();
    	System.out.println(TextCheck3);
    
    }	
    
    
    @Test // 
    public void TC0009() throws Exception
    {
    	    	
    }	
    
    
    
    
    
    
    
    
    @AfterClass
    public static void tearDown() throws Exception
    {
        //driver.close(); //�׽�Ʈ �Ϸ� �� ������ ���� ��ɾ�
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }
}