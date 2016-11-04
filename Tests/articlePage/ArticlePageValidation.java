/**
 * Validate Author info & image
 * Article Ads
 * Social sharing

 */
package articlePage;

import java.util.List;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * class names are written in mixed case with the first letter of each internal
 * word capitalized.
 */
public class ArticlePageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Article Page Validation
	// Created by :Shakira
	// Created on :9 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new article page validation.
	 *
	 * @param obj the obj
	 */
	public ArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify ads in article page. methods are written in mixed case with the
		 */
	public void verifyAdsInArticlePage() {

		// String nextArticleInDesktop =
		// "Next Article#xpath=//article[@id='article-container-1']//header//h1";
		// String nextArticleInMobile =
		// "Next Article#xpath=//article[@id='article-container-1']//div[@class='article-text ng-scope']//h3";
		String articleText = null;
		// String articleHeader =
		// "Article Page#xpath=//article[@id='article-container-0']//header";
		try {

			if (currentExecutionMachineName.equalsIgnoreCase("Desktop1")) {
				waitForText("Today's Top Stories");
				waitTime(2);
				clickOnMainArticle();
				validateAuthorDetailsForDesktop();
				
				validateShare();
				validateAds();
				//validateArticleAds();
				verifyAdsInArticle();
				/*
				 * verifyAdsInDesktopArticle();
				 * testStepPassed(" Scrolled down to Next Article");
				 * scrollToElement(nextArticleInDesktop);
				 * manualScreenshot("Next Article");
				 */

			} else {
				waitForText("Top Stories");
				clickOnMainArticle();
				validateSocialShare();
				validateAuthorDetailsForMobile();
				verifyeFullBioInArticlePage();
				verifyAdsInMobileArticle();
				scrollToElement(OR.txt_Article_Page_Next_Article);
				scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				verifyPageShouldContainText(articleText);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validate share.
	 */
	public void validateShare() {
		testStepInfo("******************************* Share ****************************************");
		
		waitTime(3);
		try {
			waitForElement(OR.img_Article_Page_Facebook_Share);
			boolean facebook=elementPresent(OR.img_Article_Page_Facebook_Share);
			if(facebook==true)
			{
				//clickOn(OR.img_Article_Page_Facebook_Share);
				testStepPassed("Social Share is displayed");
			}
			else
			{
				testStepFailed("Social Share is not displayed"); 
			}
			
			/*waitForElement(OR.txt_Article_Page_Share);
			clickOn(OR.txt_Article_Page_Share);
			
			boolean facebook=elementPresent(OR.img_Article_Page_Social_Share);
			if(facebook==true)
			{
				clickOn(OR.img_Article_Page_Social_Share);
				testStepPassed("Facebook is displayed");
			}
			else
			{
				testStepFailed("Facebook is not displayed");
			}
			
			
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);
				//driver.manage().window().maximize();

			}
			boolean email = elementPresent(OR.txt_Home_Page_Facebook_Email);
			if (email == true) {
				testStepPassed("Navigating to Facebook Login Page");
			} else {
				testStepFailed("Facebook Login is not available");
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
			testStepPassed("Social Connects are available");
			//clickOn(OR.txt_Article_Page_Share);
			 * */
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	
	}

	/**
	 * Validate author details.
	 */
	public void validateAuthorDetailsForDesktop() {
		testStepInfo("***************************Author Information*************************");
		try {
			String authorName = getText(OR.txt_Article_Page_Author_Name);
			boolean name=elementPresent(OR.txt_Article_Page_Author_Name);
			if(name==true)
			{
			testStepPassed("Author Name is displayed---" + authorName);
			}
			else
			{
				testStepFailed("Author Name is not displayed");
			}
		} catch (Exception e1) {
			testStepFailed("Author Name is not displayed");
		}
		try {
			boolean varContributor = elementPresent(OR.img_Article_Page_Contributor);
			if (varContributor == true) {
				testStepPassed("Image is displayed with Author Details");
			} else {
				testStepFailed("Image is not displayed");
			}
		} catch (Exception e) {
			testStepFailed("Image is not displayed");
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
	 * Validate ads.
	 */
	public void validateAds() {
		testStepInfo("***************************************Article Ads******************************");
		try {
			boolean topAds=elementPresent(OR.ads_Article_Page_Top_Ads);
			if(topAds==true)
			{
				scrollBy(0, 50);
				//takeAdScreenshot(OR.ads_Article_Page_Top_Ads, "TopAds");
				testStepPassed("Top Ads is displayed "+topAds);
			}
			else
			{
				testStepFailed("Top Ads is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Top Ads is not displayed");
		}
	}

	// Start Date : 21 June 2016

	/**
	 * Verifye full bio in article page.
	 */
	public void verifyeFullBioInArticlePage() {
		testStepInfo("************************************************** Full Bio  ****************************************************");
		try {
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			String fullBioDetails = getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
			testStepPassed(fullBioDetails);
			scrollBy(0, 200);
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate author details for mobile.
	 */
	public void validateAuthorDetailsForMobile() {
		testStepInfo("************************************************** Author Details  ****************************************************");
		try {
			boolean authorName = elementPresent(OR.txt_Mob_Article_Page_Author_Name);
			if (authorName == true) {

				String varAuthorName = getText(OR.txt_Mob_Article_Page_Author_Name);
				testStepPassed("Author Name is -" + varAuthorName);

			} else {
				testStepFailed("Article Name is not displayed");
			}
			boolean authorImage = elementPresent(OR.img_Article_Page_Contributor);
			if (authorImage == true) {
				//takeAdScreenshot(OR.img_Article_Page_Contributor,"Author Image");
				testStepPassed("Author image is displayed");
			} else {
				testStepFailed("Image is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate social share.
	 */
	public void validateSocialShare() {
		try {
			testStepInfo("************************************************** Social Share ****************************************************");
			waitTime(3);
			clickOn(OR.img_Mob_Article_Page_Share_Icon);

			boolean shareFacebook = elementPresent(OR.img_Mob_Article_Page_Facebook);
			if (shareFacebook == true) {
				testStepPassed("Social Share Facebook is available");
			} else {
				testStepFailed("Social Share are not loaded properly");
			}
			clickOn(OR.img_Mob_Article_Page_Share_Icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	public void verifyAdsInArticle()
	{
		boolean ads=elementPresent(OR.txt_Article_Page_Ads);
		/*if(ads==true)
		{
			scrollBy(0, 100);
			testStepPassed("Article Ads is present");
		}
		else
		{
			testStepFailed("Article ads is not displayed");
		}*/
		
		try {
			List<WebElement> allAds=driver.findElements(By.xpath("//article[@id='article-container-0'][1]//div[@id='fbs-ad-rail-article-0']//div[@class='ng-scope']"));
			int countAds=allAds.size();
			testStepPassed("Total Number of Ads"+countAds);
			int scrollnum=100;
			for (int count = 1; count <=countAds; count++) {
				scrollBy(scrollnum+100, 100);
				String allArticleAds="Article Ads#xpath=//article[@id='article-container-0'][1]//div[@id='fbs-ad-rail-article-0']//div[@class='ng-scope']["+count+"]";
				boolean adPresent=elementPresent(allArticleAds);
				if (adPresent==true) {
					testStepPassed("Article Ads is displayed--"+count);
					
				}
				else
				{
					testStepFailed("Article Ads is not displayed");
				}
				
			}
		} catch (Exception e) {
			testStepFailed("Article Ads are not loaded properly");
		}
	}
	
	public void validateArticleAds()
	{
		
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe')]"));
		for (int k = 0; k < allAdLinks.size(); k++) {

			boolean isAdDisplayed = allAdLinks.get(k).isDisplayed();
			if(isAdDisplayed==true){
				System.out.println("---->"+""+(k+1));
			testStepPassed("Article Page validation (Article - " + (k + 1) + ")"
					+ isAdDisplayed);
			}
			else
			{
				testStepPassed("Article ads are not displayed");
			}
		}
	}
}
