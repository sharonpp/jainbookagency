package com.stepDefinition;

import java.io.IOException;

import com.pages.JainBook_Agency_BookName_page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JainBook_Agency_BookName_step {

	JainBook_Agency_BookName_page xpage3=new JainBook_Agency_BookName_page();
	@Given("^user launch the chrome browser for fourth time$")
	public void user_launch_the_chrome_browser_for_fourth_time()
{
	xpage3.launch("chrome");
}

@When("^the user open the jain book website for fourth time$")
public void the_user_open_the_jain_book_website_for_fourth_time() throws InterruptedException
{
	xpage3.LoginPage("https://www.jainbookagency.com/");
	Thread.sleep(3000);
	xpage3.LoginDetails("sharonpaulselenium@gmail.com","9048476427");
}

@Then("^the user click on a book and write the name in excel$")
public void the_user_click_on_a_book_and_write_the_name_in_excel() throws IOException, InterruptedException
{
	xpage3.Bookname();
}

@Then("^the user logout the application and close the browser for fourth time$")
public void the_user_logout_the_application_and_close_the_browser_for_fourth_time() throws InterruptedException 
{
	xpage3.logOut();
	xpage3.close();
}

}
