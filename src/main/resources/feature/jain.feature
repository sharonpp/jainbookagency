 @jain_book_agency
Feature: Checking JainBookWebsite

@TC_01_jainBook
Scenario: user add books to cart

Given user launch the chrome browser for first time
When the user open the jain book website for first time
Then the user select one book and add to cart
Then the user logout the application and close the browser for first time

@TC_02_jainBook
Scenario: user gets the cost and assert it with actual cost

Given user launch the chrome browser for second time
When the user open the jain book website for second time
Then the user select one book and gets the cost and assert the value with actual cost
Then the user logout the application and close the browser for second time

@TC_03_jainBook
Scenario: user add book and take screenshot of add to cart 

Given user launch the chrome browser for third time
When the user open the jain book website for third time
Then the user add a book takes a screen shot of AddToCart
Then the user logout the application and close the browser for third time	



@TC_04_jainBook
Scenario: the user select a book and write name in excel

Given user launch the chrome browser for fourth time
When the user open the jain book website for fourth time
Then the user click on a book and write the name in excel
Then the user logout the application and close the browser for fourth time