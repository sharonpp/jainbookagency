package com.stepDefinition;

import java.io.IOException;

import com.pages.JainBook_Agency_ScreenShot_AddToCart_page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JainBook_Agency_ScreenShot_AddToCart_step {
	
	JainBook_Agency_ScreenShot_AddToCart_page xpage2=new JainBook_Agency_ScreenShot_AddToCart_page();
	
	@Given("^user launch the chrome browser for third time$")
	public void user_launch_the_chrome_browser_for_third_time() 
	{
		xpage2.launch("chrome");
	}

	@When("^the user open the jain book website for third time$")
	public void the_user_open_the_jain_book_website_for_third_time() throws InterruptedException 
	{
		xpage2.LoginPage("https://www.jainbookagency.com/");
		Thread.sleep(2000);
		xpage2.LoginDetails("sharonpaulselenium@gmail.com","9048476427");
	}

	@Then("^the user add a book takes a screen shot of AddToCart$")
	public void the_user_add_a_book_takes_a_screen_shot_of_AddToCart() throws IOException, InterruptedException
	{
		xpage2.ScreenShot_AddToCart();
	}

	@Then("^the user logout the application and close the browser for third time$")
	public void the_user_logout_the_application_and_close_the_browser_for_third_time() throws InterruptedException 
	{
		xpage2.logOut();
		xpage2.close();
	}

}
