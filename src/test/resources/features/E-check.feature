@tc @E-check
Feature:E-commerce website for online shopping

Background:Navigated to url
When User navigated to home application Url

@1LandingPageURL
Scenario: User able to open the browser, navigated to url and validate Url
Then Landing page URL validated 

@2LandingPageTitle
Scenario: User able to open the browser,navigated to url and validate Title
Then Landing page title validated

@3Product_Catagory
Scenario: User able to open the browser,navigated to url and product catagories are displayed
Then  All product catagories are displayed

@4Logovalidation
Scenario: User able to open the browser,navigated to url and landing page logo is displayed
Then  Landing page logo is displayed

@5Logo_Height
Scenario: User able to open the browser,navigated to url and landing page logo height validated
Then  Landing page logo height validated

@6Logo_Width
Scenario: User able to open the browser,navigated to url and landing page logo width validated
Then  Landing page logo width validated

@7Sign_In_page_Title
Scenario: User navigated to url and click on signin button
When  Click On Sign in button 
Then Sign in page title validated

@8SearchResult
Scenario: User navigated to url , Search for product and the list for product displayed

When   Search for product "Dress"
Then  list for product is displayed

@9Twitter_Acc
Scenario: User navigated to url,click on twitter and validate

When Click on twitter
Then Twitter social media page displayed

@10NewSletter_Subscription
Scenario: User navigated to url,enter email in newsletter and validate email subsciption is successful 

When enter "dsg9595@gmail.com" in newsletter and click on proceed
Then Email subscription successful is validated











