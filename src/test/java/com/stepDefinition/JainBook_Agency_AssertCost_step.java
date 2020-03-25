package com.stepDefinition;

import com.pages.JainBook_Agency_AssertCost_page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JainBook_Agency_AssertCost_step {
	JainBook_Agency_AssertCost_page xpage1=new JainBook_Agency_AssertCost_page();
	@Given("^user launch the chrome browser for second time$")
	public void user_launch_the_chrome_browser_for_second_time()
{
	xpage1.launch("chrome");
}

	@When("^the user open the jain book website for second time$")
	public void the_user_open_the_jain_book_website_for_second_time() throws InterruptedException
{
	xpage1.LoginPage("https://www.jainbookagency.com/");
	Thread.sleep(1000);
	xpage1.LoginDetails("sharonpaulselenium@gmail.com","9048476427");
}
@Then("^the user select one book and gets the cost and assert the value with actual cost$")
public void the_user_select_one_book_and_gets_the_cost_and_assert_the_value_with_actual_cost() 
{
	xpage1.AssertCost();
}

@Then("^the user logout the application and close the browser for second time$")
public void the_user_logout_the_application_and_close_the_browser_for_second_time() throws InterruptedException 
{
	xpage1.logOut();
	xpage1.close();
}

}
