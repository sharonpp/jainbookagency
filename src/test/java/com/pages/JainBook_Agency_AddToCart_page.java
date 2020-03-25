package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import com.ExcelLogin.ExcelWrite;

public class JainBook_Agency_AddToCart_page {
WebDriver driver;
	
	By login=By.linkText("Login");
	By Email=By.xpath("//input[@placeholder='Enter Email']");
	By password=By.xpath("//input[@placeholder='Enter Password']");
	By loginsubmit=By.xpath("(//input[@value='Login'])[2]");
	By CloseAlert=By.xpath("(//span[@aria-hidden='true'])[2]");
	By SelectOne=By.xpath("//img[@id='img246365']");
	By BuyNow=By.xpath("//*[@id=\"ContentPlaceHolder1_bttnimg\"]/a");
	By CheckCart=By.xpath("//*[@id=\"mssgpop\"]");
	By CountinueShopping=By.xpath("//input[@value='Continue Shopping']");
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
				
				
				public void LoginPage(String url) throws InterruptedException
				{
					driver.get(url);
					System.out.println(driver.getTitle());
				Thread.sleep(4000);
				}
			
					/*public void AlertHAndling() throws InterruptedException
				{
						Thread.sleep(4000);
						Alert a=driver.switchTo().alert();
						a.dismiss();
					Thread.sleep(4000);
					Actions act= new Actions(driver);
//					act.sendKeys(Keys.ENTER).build().perform();
					act.sendKeys(Keys.ESCAPE).build().perform();
					driver.findElement(CloseAlert).click();
					Thread.sleep(4000);
					driver.findElement(CloseAlert).click();*/
			/*	Actions act=new Actions(driver);		
				WebElement a=driver.findElement(CloseAlert);
				act.doubleClick().perform();
//				act.sendKeys(Keys.ESCAPE).build().perform();
				}*/
				// log in to website
	public void LoginDetails(String emails,String pass) throws InterruptedException
	{
		driver.findElement(login).click();
		Thread.sleep(3000);
		driver.findElement(Email).sendKeys(emails);
		Thread.sleep(3000);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginsubmit).click();
		
	}
	//add a book to the cart 
	public void AddToCart() throws InterruptedException, IOException
	{
		driver.findElement(SelectOne).click();
		Thread.sleep(3000);
		driver.findElement(BuyNow).click();
		Thread.sleep(4000);
		/*File SrcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("D:\\selenium\\JainBook\\src\\test\\resources\\ScreenShot\\pic.png"));
		Thread.sleep(4000);*/
		driver.findElement(CountinueShopping).click();
		
	}
	//log out of website
	public void logOut() throws InterruptedException 
	{
		Thread.sleep(1000);
		WebElement a=driver.findElement(Myaccount);
		WebElement b=driver.findElement(logout);
		
		Actions act=new Actions(driver);
		act.moveToElement(a);
		act.moveToElement(b).click().build().perform();
		
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	}
	//close the browser
	public void close()
	{
		driver.close();
	}
}
