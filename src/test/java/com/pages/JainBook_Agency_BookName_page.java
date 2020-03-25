package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.ExcelLogin.ExcelWrite;

public class JainBook_Agency_BookName_page {
WebDriver driver;
	
	By login=By.linkText("Login");
	By Email=By.xpath("//input[@placeholder='Enter Email']");
	By password=By.xpath("//input[@placeholder='Enter Password']");
	By loginsubmit=By.xpath("(//input[@value='Login'])[2]");
	By book =By.xpath("(//span[@ id='title246903'])[1]");
	By title =By.xpath("(//div[@class='title'])[1]");
	By Close=By.xpath("//button[@class='close']");
	By Myaccount=By.xpath("//span[@class='uname']");
	By logout=By.xpath("//a[text()='Log Out']");
	
	// for launching different types of browser based on requirements
		public void launch(String browser) { 	
					try
						{
							// for launching chrome browser 
							if(browser.equalsIgnoreCase("chrome"))
							{
								System.setProperty("webdriver.chrome.driver","D:\\selenium\\driver\\chromedriver.exe");
								driver =new ChromeDriver();
							}
							
							// for launching firefox browser
							else if(browser.equalsIgnoreCase("firefox"))
							{
								System.setProperty("webdriver.gecko.driver","Driver\\geckodriver.exe");
								driver =new FirefoxDriver();
							}
						}
						
						// for throwing Exceptions
						catch(WebDriverException e)
						{
							System.out.println("driver not avilable");
						}
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
					}
					
					
					public void LoginPage(String url)
					{
						driver.get(url);
						System.out.println(driver.getTitle());
					
					}
					//login application
		public void LoginDetails(String emails,String pass) throws InterruptedException
		{
			driver.findElement(login).click();
			Thread.sleep(3000);
			driver.findElement(Email).sendKeys(emails);
			Thread.sleep(3000);
			driver.findElement(password).sendKeys(pass);
			driver.findElement(loginsubmit).click();
			
		}
		//select a book and write the name in excel
	
	public void Bookname() throws IOException, InterruptedException
	{
		driver.findElement(book).click();
		String name= driver.findElement(title).getText();
		System.out.println(name);
		ExcelWrite writ= new ExcelWrite();
		writ.Excel_write(name);
		Thread.sleep(3000);
		driver.findElement(Close).click();
	
		
	}
	//log out of application
	public void logOut() throws InterruptedException 
	{
		Thread.sleep(1000);
		WebElement a=driver.findElement(Myaccount);
		WebElement b=driver.findElement(logout);
		
		Actions act=new Actions(driver);
		act.moveToElement(a);
		act.moveToElement(b).click().build().perform();
		Thread.sleep(1000);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	}
	//close the browser
	public void close()
	{
		driver.close();
	}
}
