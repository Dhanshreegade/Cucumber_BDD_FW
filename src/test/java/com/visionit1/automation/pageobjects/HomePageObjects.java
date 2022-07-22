package com.visionit1.automation.pageobjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.visionit1.automation.pageobjects.HomePageObjects;

import io.cucumber.java.Scenario;
import junit.framework.Assert;

public class HomePageObjects {

	
		private static final Logger logger=LogManager.getLogger(HomePageObjects.class);
		WebDriver driver;
		Scenario scn;

        private By LogoImage=By.xpath("//img[@class='logo img-responsive']");
		private By SignInButton=By.xpath("//a[@class='login']");
		private By SearchBox=By.xpath("//input[@id='search_query_top']");
		private By DressSearchList=By.xpath("//div[@class='ac_results']/ul/li");
		private By twitter=By.xpath("//a[@href='https://twitter.com/seleniumfrmwrk']");
		private By sendBtn=By.xpath("//button[@name='submitNewsletter']");
		private By TwitterAccount=By.xpath("//div[@class='css-1dbjc4n r-6gpygo r-14gqq1x']//span/span");
		private By emailbox=By.xpath("//input[@id='newsletter-input']");
		private By successmessage=By.xpath("//p[@class='alert alert-success']"); 


		public HomePageObjects(WebDriver driver,Scenario scn)
		{
			this.driver=driver;
			this.scn=scn;
		}

		public void URLvalidationTest()
		{
			String ExpectedUrl="http://automationpractice.com/index.php";
			Assert.assertEquals(ExpectedUrl, driver.getCurrentUrl());
			scn.log("URL validation successful. Actual URL :" + driver.getCurrentUrl());
			logger.info("URL validation successful. Actual URL :" + driver.getCurrentUrl());
		}

		public void TitlevalidationTest()
		{
			String ExpectedTitle="My Store";
			  Assert.assertEquals(ExpectedTitle, driver.getTitle());
			  scn.log("Title validation successful. Actual Title :" + driver.getTitle());
			  logger.info("Title validation successful. Actual Title :" + driver.getTitle());
		}
		public void Catagorydisplaytest()
		{
			ArrayList<String> expectedcategorylist=new ArrayList<>();
			expectedcategorylist.add("WOMEN");
			expectedcategorylist.add("DRESSES");
			expectedcategorylist.add("T-SHIRTS");
		    List<WebElement> productcategorylist=driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
		    for(int i=0;i<productcategorylist.size();i++)
		    {
		    	
		    	Assert.assertEquals(expectedcategorylist.get(i),productcategorylist.get(i).getText());
		    	scn.log("All product catagories are displayed");
		    	logger.info("All product catagories are displayed");
		    	
		    }
		    
		}
		public void logodisplaytest()
		{
			WebElement LogoImageElement=driver.findElement(LogoImage);
			 logger.info("created webelement for logoimage");
				Assert.assertEquals(true,LogoImageElement.isDisplayed());
				scn.log("Landing page logo is displayed");
				logger.info("Landing page logo is displayed"); 
		}

		public void logoheighttest()
		{
			WebElement LogoImageElement=driver.findElement(LogoImage);
			logger.info("created webelement for logoimage");
		    Assert.assertEquals("99",LogoImageElement.getAttribute("height"));
		    scn.log("Landing page logo height is 99");
		    logger.info("Landing page logo height is 99");	
		}
		public void logowidthtest() 
		{
			WebElement LogoImageElement=driver.findElement(LogoImage);
			logger.info("created webelement for logoimage");
			Assert.assertEquals("350",LogoImageElement.getAttribute("width"));
			 scn.log("Landing page logo width is 350");
			 logger.info("Landing page logo width is 350");	
		}
		 public void signinclicktest() throws InterruptedException
		 {
			 logger.info("Created webelement for signin button");
				driver.findElement(SignInButton).click();
				logger.info("Clicked on sign in button");
				Thread.sleep(3000);
		 }
		 public void signinpagetitletest()
		 {
			 String Expsignintitle="Login - My Store";
			  Assert.assertEquals(Expsignintitle, driver.getTitle());
			  scn.log("Sign in page title is :" + driver.getTitle());
			  logger.info("Sign in page title is :" + driver.getTitle());
			  
		 }
		public void productsearchtest(String productname)
		{
			WebElement SearchBoxElement=driver.findElement(SearchBox);
			 logger.info("Created a webelement for searchbox");
			 Assert.assertEquals(true, SearchBoxElement.isEnabled());
			 scn.log("Search box is enabled");
			 logger.info("Search box is enabled");
			 SearchBoxElement.sendKeys(productname); 
			 logger.info("Sent product name in searchbox");
		}

		public void productlisttest()
		{
			List<WebElement> DressSearchListElement=driver.findElements(DressSearchList); 
			 logger.info("Created WebElement for dresssearchlist");
			 int count=0;
			    logger.info("Count set to 0");
			    for(int i=0;i<DressSearchListElement.size();i++)
			    {
			    	System.out.println((i+1) +"."+ DressSearchListElement.get(i).getText());
			    	logger.info("Search list is printed");
			    	if(DressSearchListElement.get(i).getText().contains("Dress"))
			    	{
			    		count++;
			    		logger.info("Count increased by 1");
			    	}
			    			
			    }
			    Assert.assertEquals(5, count);
			    scn.log("The number of products contains keyword dress are " + count);
			    logger.info("The number of products contains keyword dress are " + count);
			    System.out.println("The number of products contains keyword dress are " + count);
		}

		public void twiterclicktest()
		{
			WebElement twitterElement=driver.findElement(twitter);
			 logger.info("Created webElement for twiter");
			 twitterElement.click();
			   logger.info("Click on twitter logo");
			   
			
		}
		public void twiterpagedisplaytest()
		{
			 Set<String> handles = driver.getWindowHandles(); // get all the open windows
		     Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
		     String landingpage = it.next();//gives the parent window id
		     String twiterpage = it.next();
		     driver.switchTo().window(twiterpage);
		    logger.info("Window switched to twitter page");
		    
		    WebElement TwitterAccountElement=driver.findElement(TwitterAccount);
		    logger.info("Created WebElement for Twitter Account name");
		    Assert.assertEquals("Selenium Framework", TwitterAccountElement.getText());
		    scn.log("Twitter Account name is :" + TwitterAccountElement.getText() );
		    logger.info("Twitter Account name is :" + TwitterAccountElement.getText());
		}

		public void newslettervalidationtest(String email) 
		{
			
			WebElement emailboxElement=driver.findElement(emailbox);
			logger.info("created WebElement for email box");
			emailboxElement.sendKeys(email);
			logger.info("email entered in email box");
			
			WebElement sendBtnElement=driver.findElement(sendBtn);
			logger.info("created WebElement for send button");
			sendBtnElement.click();
			logger.info("Clicked on Sendbutton");
		}
		public void subscriptionsuccesstest()
		{
			WebElement successmessageElement=driver.findElement(successmessage);
			logger.info("created WebElement for successmessage");
			 String Expsuccessmessage="Newsletter : You have successfully subscribed to this newsletter.";
			 Assert.assertEquals(Expsuccessmessage, successmessageElement.getText()); 
			 scn.log("After successful email subscription the message should be: "+ successmessageElement.getText());
			 logger.info("After successful email subscription the message should be: "+ successmessageElement.getText());
		}
		}


