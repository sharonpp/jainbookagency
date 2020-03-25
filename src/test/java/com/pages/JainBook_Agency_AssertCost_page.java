package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Test;
import org.junit.Assert;

public class JainBook_Agency_AssertCost_page {
WebDriver driver;
	
	By login=By.linkText("Login");
	By Email=By.xpath("//input[@placeholder='Enter Email']");
	By password=By.xpath("//input[@placeholder='Enter Password']");
	By loginsubmit=By.xpath("(//input[@value='Login'])[2]");
	By Cart=By.xpath("//a[@id='cart']");
	By SelectOne=By.xpath("//span[@id='title246365']");
	By Edition=By.xpath("//span[@itemprop='bookEdition']");
	By Myaccount=By.xpath("//span[@class='uname']");
	By logout=By.xpath("//a[text()='Log Out']");
	By CloseButton=By.xpath("//button[@class='close']");

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
					//login the application
		public void LoginDetails(String emails,String pass) throws InterruptedException
		{
			driver.findElement(login).click();
			Thread.sleep(3000);
			driver.findElement(Email).sendKeys(emails);
			Thread.sleep(3000);
			driver.findElement(password).sendKeys(pass);
			driver.findElement(loginsubmit).click();
			
		}
	//check expected cost with actual cost
	public void AssertCost()
	{
		driver.findElement(SelectOne).click();
		String a=driver.findElement(Edition).getText();
		System.out.println(a);
		Assert.assertEquals(a,"2020");
		
		driver.findElement(CloseButton).click();
		
	}
	//logout application
	public void logOut() throws InterruptedException 
	{
		Thread.sleep(1000);
		WebElement a=driver.findElement(Myaccount);
		WebElement b=driver.findElement(logout);
		
		Actions act=new Actions(driver);
		act.moveToElement(a);
		act.moveToElement(b).click().build().perform();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	}
	//close browser
	public void close()
	{
		driver.close();
	}

}



