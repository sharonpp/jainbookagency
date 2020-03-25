package com.stepDefinition;

import java.io.IOException;

import com.pages.JainBook_Agency_AddToCart_page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JainBook_Agency_AddToCart_step {

	JainBook_Agency_AddToCart_page xpage=new JainBook_Agency_AddToCart_page();
	
	@Given("^user launch the chrome browser for first time$")
	public void user_launch_the_chrome_browser_for_first_time() throws InterruptedException
{
//	xpage.AlertHAndling();
	xpage.launch("chrome");
}

	@When("^the user open the jain book website for first time$")
	public void the_user_open_the_jain_book_website_for_first_time() throws InterruptedException 
{
	xpage.LoginPage("https://www.jainbookagency.com/");
	Thread.sleep(3000);
	xpage.LoginDetails("sharonpaulselenium@gmail.com","9048476427");
}

	@Then("^the user select one book and add to cart$")
	public void the_user_select_one_book_and_add_to_cart()  throws InterruptedException, IOException 
{
	xpage.AddToCart();
}

@Then("^the user logout the application and close the browser for first time$")
public void the_user_logout_the_application_and_close_the_browser_for_first_time() throws InterruptedException   
{
	xpage.logOut();
	xpage.close();
}

}
