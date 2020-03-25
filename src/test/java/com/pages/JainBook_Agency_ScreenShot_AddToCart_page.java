package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class JainBook_Agency_ScreenShot_AddToCart_page {
WebDriver driver;
	
	By login=By.linkText("Login");
	By Email=By.xpath("//input[@placeholder='Enter Email']");
	By password=By.xpath("//input[@placeholder='Enter Password']");
	By loginsubmit=By.xpath("(//input[@value='Login'])[2]");
	By SelectBook=By.xpath("//img[@id='img246903']");
	By BuyNow=By.xpath("//*[@id=\"ContentPlaceHolder1_bttnimg\"]/a");
	By CheckCart=By.xpath("//*[@id=\"mssgpop\"]");
	By closeWindow=By.xpath("//button[@class='close']");
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
					//log in the application
		public void LoginDetails(String emails,String pass) throws InterruptedException
		{
			driver.findElement(login).click();
			Thread.sleep(3000);
			driver.findElement(Email).sendKeys(emails);
			Thread.sleep(3000);
			driver.findElement(password).sendKeys(pass);
			driver.findElement(loginsubmit).click();
			
		}
		//selecting one book and take screenshot of the cart
	public void ScreenShot_AddToCart() throws IOException, InterruptedException
	{
		driver.findElement(SelectBook).click();
		driver.findElement(BuyNow).click();
		Thread.sleep(4000);
		File SrcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("D:\\selenium\\JainBook\\src\\test\\resources\\ScreenShot\\img.png"));
		Thread.sleep(4000);
		driver.findElement(closeWindow).click();
	
		
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
