  Feature: Customers
  @regression
  Scenario: Add New Customer
  
  Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	Then User can view Dashboad

	When User click on customers Menu 
	And click on customers Menu Item 
	
	And click on Add new button 
	Then User can view Add new customer page 
	
	When User enter customer info 
	And click on Save button 
	
	Then User can view confirmation message "The new customer has been added successfully." 
	And close browser