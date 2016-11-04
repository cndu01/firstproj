/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  AutomationFramework.APIKeywords
 *  baseClass.BaseClass
 *  org.openqa.selenium.By
 *  org.openqa.selenium.WebElement
 *  org.openqa.selenium.remote.RemoteWebDriver
 */
package iSAFE;

import java.util.List;
import java.util.concurrent.TimeUnit;

import AutomationFramework.APIKeywords;
import AutomationFramework.GenericKeywords;
import Utilities.Mailing;
import Utilities.ZipReportFile;
import baseClass.BaseClass;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.APIKeywords;
import AutomationFramework.GenericKeywords;
import Utilities.Mailing;
import Utilities.ZipReportFile;
import baseClass.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationKeywords.
 *
 * @author indium
 */

public class ApplicationKeywords extends APIKeywords {

	/**
	 * Instantiates a new application keywords.
	 *
	 * @param obj
	 *            the obj
	 */
	public ApplicationKeywords(BaseClass obj) {
		super(obj);
	}

	/**
	 * Instantiates a new application keywords.
	 */
	public ApplicationKeywords() {
	}

	public static String executionReportStatus = "Pass";
	public static void sendMailOnFailure()
	 {
	  if(executionReportStatus.equals("Fail") && GenericKeywords.getConfigProperty("SendMailOnFailure").equalsIgnoreCase("yes"))
	  {
	   ZipReportFile.zipReport();
	   Mailing.sendMail(".//TestResults//"+GenericKeywords.timeStamp+".zip");
	  }
	 }
	
	public void swipeToLeft() 
	 {   
	  try {
		int startx = 990;  
		  int endx = 40;  
		  int starty = 960;
		  writeToLogFile("INFO", "startx = " + startx + " ,endx = " + endx + " , starty = " + starty); 
		  //Swipe from Right to Left. 
		  waitTime(2);
		  ((AndroidDriver)driver).context("NATIVE_APP");
		  ((AndroidDriver<WebElement>) driver).swipe(startx, starty, endx, starty, 5000);
		  ((AndroidDriver)driver).context("WEBVIEW");
		  testStepPassed("Swiped to Left");
	} catch (Exception e) {
		
	}
	 }
	
	/* public void swipeElement()
	  {
		 AppiumDriver appiumDriver = (AppiumDriver) driver;
	      try {
			
			  appiumDriver.context("NATIVE_APP"); 
			  Dimension size = appiumDriver.manage().window().getSize(); 
			  int startx = (int) (size.width * 0.8); 
			  int endx = (int) (size.width * 0.20); 
			  int starty = size.height / 2; 
			  testStepPassed("Before swipping");
			  appiumDriver.swipe(startx, starty, endx, starty, 1000);
			  testStepPassed("Slide is swipped");
			  
		} catch (Exception e) {
			//this.testStepFailed(e.toString());
			}
	      finally
	      {
	    	  appiumDriver=null;
	    	  
	      }
	  }
	
	 public void swipe(int startx, int starty, int endx, int endy,int durationMS) {
		  try {

			  ((AppiumDriver<?>)driver).swipe(startx, starty, endx, endy, durationMS);
			  Dimension size = driver.manage().window().getSize(); 
			  startx = (int) (size.width * 0.8); 
			   endx = (int) (size.width * 0.20); 
			   starty = size.height / 2; 
			  testStepPassed("Before swipping");
		   //driver.swipe(startx, starty, endx, endy, durationMS);
		   testStepPassed("Perform swipe operation");
		  } catch (Exception e) {
		   testStepFailed(e.toString());
		  }
		 }*/
	
	/*public void swipe(int startx, int starty, int endx, int endy,int durationMS) {
		  try {
			  AndroidDriver driver1 = (AndroidDriver)driver;
		   driver1.swipe(startx, starty, endx, endy, durationMS);
		   testStepPassed("Perform swipe operation");
		  } catch (Exception e) {
		   testStepFailed(e.toString());
		  }
		 }
	/**
	 * Take ad screenshot.
	 *
	 * @param element
	 *            the element
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(WebElement element, String screenshotName) {
		try {
			this.driver.executeScript("arguments[0].scrollIntoView();",
					new Object[] { element });
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Take ad screenshot.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(String objLocator, String screenshotName) {
		try {
			this.scrollToElement(objLocator);
			this.scrollBy(0, -60);
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Scroll to element.
	 *
	 * @param objLocator
	 *            the obj locator
	 */
	public void scrollToElement(String objLocator) {
		this.waitForElement(objLocator);
		this.driver.executeScript("arguments[0].scrollIntoView();",
				new Object[] { this.webElement });
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) ("Scroll to " + this.locatorDescription));
	}

	/**
	 * Scroll by.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollBy(int x, int y) {
		this.driver.executeScript("window.scrollBy(" + x + "," + y + ")",
				new Object[0]);
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) "Scroll to location: ");
	}

	/**
	 * Verify ad.
	 *
	 * @param adNumber
	 *            the ad number
	 */
	public void verifyAd(int adNumber) {
		this.scrollToElement("Ad place holder#id=article-0-ad-" + adNumber);
		this.takeAdScreenshot("Ad " + adNumber + "#id=inline-article-0-ad-"
				+ adNumber, "Ad No:" + adNumber);
	}

	/**
	 * Test step info.
	 *
	 * @param message
	 *            the message
	 */
	public void testStepInfo(String message) {
		this.writeHtmlTestStepReport("<font style='color:blue'>stepNo"
				+ message + "</font><br/>", this.currentExecutionMachineName,
				this.currentTestCaseName);
	}

	/**
	 * Gets the article heading.
	 *
	 * @param articleNumber
	 *            the article number
	 * @return the article heading
	 */
	public String getArticleHeading(int articleNumber) {
		String strXpath = "Article(" + articleNumber
				+ ")#xpath=//article[@id='article-container-" + --articleNumber
				+ "']//h1[@class='article-headline ng-binding ng-scope']";
		return this.getText(strXpath);
	}

	/**
	 * Gets the main article text.
	 *
	 * @return the main article text
	 */
	public String getMainArticleText() {
		String strXpath = "Main Article heading#xpath=//article[@class='feature promostory promostory-1']/div[@class='feature-headline']/h3/a";
		return this.getText(strXpath);
	}

	/**
	 * Click on main article.
	 */
	public void clickOnMainArticle() {
		String strXpath = "Main Article #xpath=//article[@class='feature promostory promostory-1']";
		waitForElement(strXpath);
		this.clickOn(strXpath);
	}

	/**
	 * Click on top stories.
	 *
	 * @param topStoryNumber
	 *            the top story number
	 * @return the string
	 */
	public String clickOnTopStories(int topStoryNumber) {
		String strXpath = "Top Stories (" + topStoryNumber
				+ ") #xpath=//li[@class='promostory promostory-"
				+ (topStoryNumber += 2) + " ']/h4/a";
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		strXpath = "Top Story - " + articleLinkText
				+ "#xpath=//li[@class='promostory promostory-" + topStoryNumber
				+ " ']/h4/a";
		this.clickOn(strXpath);
		return articleLinkText;
	}

	/**
	 * Click on most popular.
	 *
	 * @param mostPopularNumber the most popular number
	 * @return the string
	 */
	public String clickOnMostPopular(int mostPopularNumber) {
		String strXpath = "Top Stories ("
				+ mostPopularNumber
				+ ") #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3[mostPopularNumber]";

		// section[@class='popular_top_stories' or
		// @id='stackMostPopular']//ol//li//h3
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		/*
		 * strXpath = "Most Popular- " + articleLinkText +
		 * "#xpath=//li[@class='promostory promostory-" + mostPopularNumber +
		 * " ']/h4/a"; this.clickOn(strXpath);
		 */
		return articleLinkText;
	}

	/**
	 * Go to home page.
	 */
	public void goToHomePage() {
		String strXpath = "Forbes logo#xpath=//article[@id='article-container-0']//header[@class='article-header ng-scope']//a[@href='http://www.forbes.com/']/h1";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the element count.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @return the element count
	 */
	public int getElementCount(String objLocator) {
		int elementCount = 0;
		try {
			this.waitForElement(objLocator);
			elementCount = this.driver.findElements(
					By.xpath((String) this.locator)).size();
			ApplicationKeywords.writeToLogFile((String) "INFO",
					(String) ("Total Elements found for "
							+ this.locatorDescription + ": " + elementCount));
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
		return elementCount;
	}

	/**
	 * Verify ads in mobile article.
	 */
	public void verifyAdsInMobileArticle() {
		try {
			String adPlaceHolder = "Ad Placeholder#xpath=//div[@class='article-mobile-ad ng-scope ng-isolate-scope']";
			int adCount = getElementCount(adPlaceHolder);
			testStepPassed("Verifing (" + adCount + ") Ads in the Aritcle Page");
			int adsNum=1;
			for (adsNum = 1; adsNum <= adCount; adsNum++) {

				adCount = getElementCount(adPlaceHolder);
				verifyAd(adsNum);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify ads in desktop article.
	 */
	public void verifyAdsInDesktopArticle() {
		int topAdArticleNo = 0;
		int adRailArticleNo = 0;
		for (int i = 0; i <= 15; i++) {

			if (driver.getPageSource().contains(
					"top-ad-article-" + topAdArticleNo)
					|| driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
				if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)
						&& driver.getPageSource().contains(
								"ad-rail-article-" + adRailArticleNo)) {
					testStepPassed("Top Ad");
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1) + ","
									+ "SideAds" + (adRailArticleNo + 1));
					if (driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
						int railAdCount = driver
								.findElements(
										By.xpath("//*[@id='ad-rail-article-"
												+ adRailArticleNo
												+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
								.size();
						testStepPassed("Rail Ad Count: " + railAdCount);
						for (int j = 0; j < railAdCount; j++) {
							takeAdScreenshot(
									driver.findElements(
											By.xpath("//*[@id='ad-rail-article-"
													+ adRailArticleNo
													+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
											.get(j), "SideAds"
											+ (adRailArticleNo + 1));
						}
					}
					topAdArticleNo++;
					adRailArticleNo++;
				} else if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)) {
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1));
					topAdArticleNo++;

				}

			} else {
				((JavascriptExecutor) driver)
						.executeScript("window.scrollBy(0,100)");
			}
		}

	}

	/**
	 * Verify top stories links.
	 */
	public void verifyTopStoriesLinks() {
		testStepInfo("*********************************Top Stories***********************************************");
		int topStoriesCount = getElementCount(OR.lnkTopStories);
		testStepPassed("Total Top Stories: " + topStoriesCount);
		String articleLinkText = clickOnTopStories(1);
		String articleHeading = getArticleHeading(1);
		if (articleHeading.contains(articleLinkText)) {

			testStepPassed("Article Page (" + articleLinkText
					+ ") is displayed");
		} else {
			testStepFailed("Article page (" + articleLinkText
					+ ") is not displayed, instead " + articleHeading
					+ " is displayed");
		}
		clickOnBackButton();
		int articleNo = 0;
		int topStory = 1;
		for (topStory = 1; topStory <= topStoriesCount; topStory++) {

			if (currentExecutionMachineName.startsWith("Desktop")) {
				articleNo = topStory + 1;

			} else {
				articleNo = topStory + 2;
			}

			String strXpath = "Top Stories (" + topStory
					+ ") #xpath=//li[@class='promostory promostory-"
					+ articleNo + " ']/h4/a";
			if (elementPresent(strXpath)) {
				articleLinkText = getText(strXpath);
				testStepPassed("Top Story :" + topStory + " - "
						+ articleLinkText);
			}
		}

	}

	/**
	 * Gets the most popular links.
	 *
	 * @return the most popular links
	 */
	public void getMostPopularLinks() {
		testStepInfo("****************************Most Popular********************************************");
		List<WebElement> allMostLinks = driver
				.findElements(By
						.xpath("//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3"));
		int linksCount = 0;
		for (linksCount = 0; linksCount < allMostLinks.size(); linksCount++) {

			String textMost = allMostLinks.get(linksCount).getText();
			testStepPassed("Most Popular- " + linksCount +  textMost);
			/*
			 * allMostLinks.get(k).click(); clickOnBackButton();
			 */

		}
		//scrollBy(0, 300);
		
	}

	/**
	 * Verify most popular links.
	 */
	public void verifyMostPopularLinks() {
		testStepInfo("*********************************Most Popular***********************************************");
		scrollToElement(OR.txt_Home_Most_Popular_Links);
		scrollBy(0, 300);
		int mostPopular = 1;
		for (mostPopular = 1; mostPopular <= 1; mostPopular++) {
			String strXpath = "Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3]";
			clickOn(strXpath);
			String mostPopualrTitle1 = driver.getTitle();
			testStepPassed("Navigated to this page---" + mostPopualrTitle1);
			clickOnBackButton();
		}

	}

	/**
	 * Verify video on home page.
	 */
	public void verifyVideoOnHomePage() {

		testStepInfo("****************************Top Video***************************************");
		try {
			
			/*testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");*/
			waitTime(3);
			waitForElement(OR.vidHomePageVideo);
			scrollBy(0, 900);
			scrollToElement(OR.vidHomePageVideo);
			boolean video=elementPresent(OR.vidHomePageVideo);
			if(video==true)
			{
				testStepPassed("Video is displayed");
			}
			else
			{
				testStepFailed("Video is not displayed");
			}
			try {
				boolean playButton = isElementDisplayed(OR.btn_Home_Page_Video_Play_button);
				if (playButton == true) {
					clickOn(OR.btn_Home_Page_Video_Play_button);
					waitTime(5);
					//testStepPassed("Video Played for 5 seconds");
					takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
					clickOn(OR.vidHomePageVideo);
				} else {
					testStepFailed("Video Play button is not loaded");
				}
			} catch (Exception e) {
				testStepFailed("Video is not played");
			}

		} catch (Exception e) {
			testStepFailed("Error occured in the video");
		}
	}

	/**
	 * Verify ad displayed in home page.
	 */
	public void verifyAdDisplayedInHomePage() {
		
		boolean topAds = elementPresent(OR.adsHomePageTopAds);
		if (topAds == true) {
			testStepInfo("*********************************Top Ad***********************************************");
			waitForElement(OR.adsHomePageTopAds);
			//takeAdScreenshot(OR.adsHomePageTopAds, "Top Ads");
			testStepPassed("Top Ads is displayed");
		}
		else
		{
			testStepFailed("Top Ads is not displayed");
		}
		boolean recAds = elementPresent(OR.adsHomePageRecAds);
		if (recAds == true) {
			testStepInfo("*********************************Rec Ad***********************************************");
			waitForElement(OR.adsHomePageRecAds);
			//takeAdScreenshot(OR.adsHomePageRecAds, "Rec Ads");
			testStepPassed("Rec Ads is displayed");
		}
		else
		{
			testStepFailed("Rec Ads is not displayed");
		}
		// Added 497 line by Sindhu on 7/25
		waitForElement(OR.adsHomePageTopxAds);
		boolean topxAds = elementPresent(OR.adsHomePageTopxAds);
		if (topxAds == true) {
			testStepInfo("*********************************Topx Ad***********************************************");
			waitForElement(OR.adsHomePageTopxAds);
			//takeAdScreenshot(OR.adsHomePageTopxAds, "Topx Ads");
			testStepPassed("Topx Ads is displayed");
		}
		else
		{
			testStepFailed("Topx Ads is not displayed");
		}

	}

	/**
	 * Validate most read.
	 */
	public void validateMostRead() {
		testStepInfo("********************************* Most Read **************************************");

		try {
			scrollBy(0, 300);
			boolean varMostRead=elementPresent(OR.txt_Most_Popular_Most_Read);
			
			if(varMostRead==true)
			{
				testStepPassed("Most Read is displayed");
				
			}
			else
			{
				testStepFailed("Most Read is not displayed");
			}
			
			refreshPage();
			waitTime(3);
			
			//clickOn(OR.txt_Most_Popular_Page_Most_Read);
			try {
				boolean mostRead=elementPresent(OR.txt_Most_Popular_Page_Most_Read);
				if (mostRead==true) 
				{
					String mostReadLink=getText(OR.txt_Most_Popular_Page_Most_Read);
					testStepPassed("First Link of the Most Read---"+mostReadLink);
				testStepPassed("Most Read links are displayed");	
				}
				else
				{
					testStepFailed("Most Read links are not displayed");	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				testStepFailed("Most Read links are not displyed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//testStepPassed("Most Read are displayed");

	}

	/**
	 * Gets the current window handle.
	 *
	 * @return the current window handle
	 */
	public String getCurrentWindowHandle() {
		String windowHandle = null;
		try {
			windowHandle = driver.getWindowHandle();
			writeToLogFile("INFO", "Get Current Window Handle: " + windowHandle);

		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return windowHandle;
	}

	/**
	 * Switch to window using title.
	 *
	 * @param windowTitle the window title
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingTitle(String windowTitle) {
		Boolean flag = false;
		String title = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				title = driver.getTitle();
				if (title.equals("Microsoft Dynamics CRM")) {
					new WebDriverWait(driver, elementLoadWaitTime)
							.until(ExpectedConditions
									.titleContains(" - Microsoft Dynamics CRM"));
				}
				title = driver.getTitle();
				writeToLogFile("INFO", "Window Title: " + title);
				if (title.equalsIgnoreCase(windowTitle)
						|| title.startsWith(windowTitle)) {
					writeToLogFile("INFO", "Switched to window: " + windowTitle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowTitle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Switch to window using handle.
	 *
	 * @param windowHandle the window handle
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingHandle(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Close window.
	 *
	 * @param windowHandle the window handle
	 * @return the boolean
	 */
	public Boolean closeWindow(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					driver.close();
					writeToLogFile("INFO", windowHandle + "Window is closed");
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}
	
	public void validateTopAds()
	{
		
		try {
			boolean topAds=elementPresent(OR.adsHomePageTopAds);
			if(topAds==true)
			{
			//manualScreenshot(OR.adsHomePageTopAds);
				testStepPassed("Top Ads is present");
			}
			else {
				testStepFailed("Top Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateRecAds()
	{
		
		try {
			boolean recAds=elementPresent(OR.adsHomePageRecAds);
			if(recAds==true)
			{
			//takeAdScreenshot(OR.adsHomePageRecAds,"Rec Ads");
			testStepPassed("Rec Ads is present---"+recAds);
			}
			else {
				testStepFailed("Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			writeToLogFile("ERROR", "Exception: " + e.toString());
			}
	}
	public void validateRailRecAds()
	{
		
		try {
			boolean railAds=elementPresent(OR.ads_New_Posts_RailRec_Ads);
			if(railAds==true)
			{
			//takeAdScreenshot(OR.ads_New_Posts_RailRec_Ads,"Rec Ads");
			testStepPassed(" Rail Rec Ads is present---"+railAds);
			}
			else {
				testStepFailed("Rail Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateTextAds()
	{
		
		try {
			boolean topxAds=elementPresent(OR.ads_New_Posts_Text_Ads);
			if(topxAds==true)
			{
			//takeAdScreenshot(OR.ads_New_Posts_Text_Ads,"Rec Ads");
			testStepPassed(" Text Ads is present---"+topxAds);
			}
			else {
				testStepFailed("Text Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateLogeAds()
	{
		
		try {
			boolean logeAds=elementPresent(OR.ads_New_Posts_Loge_Ads);
			if(logeAds==true)
			{
			//takeAdScreenshot(OR.ads_New_Posts_Loge_Ads,"Rec Ads");
			testStepPassed(" Loge Ads is present----"+logeAds);
			}
			else {
				testStepFailed("Loge Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateHeading() {
		try {
			boolean forbesLists = elementPresent(OR.txt_Most_Popular_Page_Heading);
			if (forbesLists == true) {
				String forbesListsHeading = getText(OR.txt_Most_Popular_Page_Heading);
				testStepPassed("" + forbesListsHeading);
				clickOnBackButton();
			} else {
				testStepFailed(" Page is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyBottomAdsInMobile()
	{
		testStepInfo("******************************** Bottom Ads *****************************************");
	
		boolean mobileAds = elementPresent(OR.ads_Mob_Home_Page_Mobile_Ads);
		if (mobileAds == true) {
			//takeAdScreenshot(OR.ads_Mob_Home_Page_Mobile_Ads, "Mobile Ads");
			testStepPassed("Mobile Ads is present");
		} else {
			testStepFailed("Mobile Ads is not present");
		}
	}
	
	
	public void verifyMostReadOnForbesInMobile()
	{
		testStepInfo("*************************** Most Read on Forbes ******************************************");
		scrollBy(0, 600);
		scrollToElement(OR.txt_Mob_Most_Popular_Most_Read);
		takeAdScreenshot(OR.txt_Mob_Most_Popular_Most_Read, "Most Read");
		waitTime(3);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes News  is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes News is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_People);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes  People is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes People is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_Places);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes  Place is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes Place is  not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_Companies);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes Companies is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes Companies is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	
	/**
	 * Verify related topics in mob.
	 */
	public void verifyRelatedTopicsInMob()
	{
		testStepInfo("*************************** Related Topics ******************************************");
		try {
			scrollBy(0, 250);
			waitTime(3);
			boolean relatedTopics=elementPresent(OR.txt_Mob_Most_Popular_Related_Topics);
			if (relatedTopics==true) {
				testStepPassed("Related Topics are displayed");
			}
			else
			{
				testStepFailed("Related Topics are not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	

	/**
	 * Verify real time ads.
	 */
	public void verifyRealTimeAds() {
		testStepInfo("************************************* Ads**********************************************");
		
		validateTopAds();
		validateRecAds();
		validateRailRecAds();
		validateTextAds();
		validateLogeAds();
		
		

	}
	
	
	// ************************************************* Sindhu Methods **********************************************
	
		/**
		 * Verify ad displayed on BV home page.
		 */
		
		public void verifyBVPageAdsInDesktop() {
			try{
				testStepInfo("****************************Ads on Brand Voice Page********************************************");
				List<WebElement> allAdLinks = driver
						.findElements(By
							.xpath("//iframe[contains(@id,'google_ads_iframe')]/following-sibling::iframe[@loaded='1']"));
				if(allAdLinks.size()==3){
				testStepPassed("BV Page validation (BV Ads - Top, Rec, loge ads are displayed)");
				}
				else if(allAdLinks.size()==4){
					testStepPassed("BV Page validation (BV Ads - Top, Rec, loge and mobile ads are displayed)");
					}
				else if(allAdLinks.size()==2){
					testStepInfo("BV Page validation (BV Ads - Two ads of Top, Rec, loge ads are displayed)");
				}
				else{
					testStepFailed("BV Page validation (BV Ads - Top, Rec, loge ads are not displayed)");
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		/**
		 * Verify show more buttons on BV Page
		 */
		public void checkShowMoreCircleButtons(){
			try{
			testStepInfo("****************************Show more Buttons in Brand Voice Page********************************************");
			List<WebElement> allShowMoreButtons = driver
					.findElements(By
							.xpath("//div[@class='load-more']/div[@class='circle']"));
			for (int k = 0; k < allShowMoreButtons.size(); k++) {
				boolean areShowMoreButtonsDisplayed = allShowMoreButtons.get(k).isDisplayed();
				if(areShowMoreButtonsDisplayed==true){
				testStepPassed("BV Page validation (BV ShowMore Buttons - " +""+(k+1)+") "
						+ areShowMoreButtonsDisplayed);
				}
				else{
					testStepFailed("BV Page validation (BV ShowMore Buttons - " +""+(k+1)+") "
							+ areShowMoreButtonsDisplayed);
				}
			}	
		}catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		/**
		 * Verify mobile sticky ad
		 */
		public void CheckMobileAd(String strXpath){
			try{
			testStepInfo("*********************************Mobile Sticky Ad Check**********************************");
			if(elementPresent(strXpath)){
				testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is displayed on the page");
			}
			else{
				testStepFailed("Mobile Gallery Check (Mobile Gallery sticky ad is not displayed on the page");
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		/**
		 * Verify ads displayed on template gallery page
		 */
		public void checkAdsonTemplateGallery(){
		try{
			testStepInfo("****************************Ads on Template gallery Page********************************************");
			List<WebElement> allAdLinks = driver
					.findElements(By
							.xpath("//iframe[contains(@id,'google_ads_iframe') and @title='3rd party ad content']"));	
			if(allAdLinks.size()>0){
				testStepInfo("*********************************Ads on the gallery page***********************************************");
				testStepPassed("Gallery Check (Gallery Ads check - "+ allAdLinks.size()+" ads are displayed on the page");
			}
			else{
				testStepFailed("Gallery Check (Gallery Ads check - "+ allAdLinks.size()+" ads are displayed on the page");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		}
		
		/**
		 * Verify ads displayed on angular gallery page
		 */
		public void checkAdsonAngularGallery(){
			try{
			testStepInfo("*********************************Ads on Angular Gallery Check**********************************");
			List<WebElement> allAdLinks = driver
					.findElements(By
							.xpath("//iframe[contains(@id,'google_ads_iframe') and @title='3rd party ad content']"));	
			if(allAdLinks.size()>0){
				testStepInfo("*********************************Ads on the Angular gallery page***********************************************");
				testStepPassed("Angular Gallery Check (Angular Gallery Ads check - "+ allAdLinks.size()+" ads are displayed on the page");
			} 
			else{
				testStepFailed("Angular Gallery Check (Angular Gallery Ads check - "+ allAdLinks.size()+" ads are displayed on the page");
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		/**
		 * Check the images from gallery
		 */
		public void checkImagesInGallery(String slidecount, String nexticon){
			try{
			testStepInfo("*********************************Check the pictures from the gallery**********************************");
			String SlideCount = getText(slidecount);
			String[] parts = SlideCount.split(" of ");
			int toalSlideCount = Integer.valueOf(parts[1]);
			if(toalSlideCount!=0){
				testStepPassed("Gallery Check (Gallery images slide check- "+toalSlideCount+" slides are present in the gallery");
			}
			else{
				testStepInfo("**Number of pictures in gallery is "+toalSlideCount+"**");
			}
			for (int i = 1; i < 4; i++) {
				int currentSlideNum = Integer.valueOf(parts[0]);
				waitTime(5);
				waitForElementToDisplay(nexticon, 10);
				clickOn(nexticon);		
				testStepPassed("Gallery Check (Clicked on - "+currentSlideNum+"  slide");
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		/**
		 * Verify Lists and overlay on CSF page
		 */
		
		public void isListDisplayed(){
			try{
				testStepInfo("*********************************Top 5 List Check**********************************");
				this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath("//div[@class='overlay-item-info']"));
				int count =elements.size();
				 for(int i = 0; i < count; i++){
					 if(elements.get(i).isDisplayed()){
						 testStepPassed("Top 5 lists are displayed on the page:: List "+i+" is displayed");
					 }
					 else{
						 testStepFailed("Top 5 lists are not displayed on the page");
					 }
				 }
				 testStepInfo("Number of lists displayed on the page are "+count);
				 
				 elements.get(0).click();
				 
				 if(elementPresent((OR.txt_CSFPageCheck_overlayAd)) &&
						 elementPresent(OR.txt_CSFPageCheck_prevButtonOnOverlay) &&
				 elementPresent(OR.txt_CSFPageCheck_nextButtonOnOverlay))
				 
				 {
					 testStepPassed("CSF Overlay ad , next and prev buttons are displayed on the Overlay window ");
				 }
				 else{
					 testStepFailed("CSF Overlay ad , next and prev buttons are not displayed on the Overlay window ");
					 takeAdScreenshot(OR.txt_CSFPageCheck_overlayAd, "Overlay Ad");
				 }
				 clickOn(OR.closeButton);	
			}catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			}
		
		public void isListDisplayedOnMobile(String strXpath){
			try{
				this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath(strXpath));
				int count =elements.size();
				 for(int i = 0; i < count; i++){
					 if(elements.get(i).isDisplayed()){
						 testStepPassed("List Check (Displayed -:: "+i);
					 }
					 else{
						 testStepFailed("List Check (Not Displayed -:: "+i);
					 }
				 }
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
		
		/**
		 * Fluent wait for the element to appear
		 */
		public void fluentwaitforVisibility(String strXpath){
		try{
			
			FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver);
			fwait.withTimeout(30, TimeUnit.SECONDS);
			fwait.pollingEvery(2, TimeUnit.SECONDS);
			fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		}
}