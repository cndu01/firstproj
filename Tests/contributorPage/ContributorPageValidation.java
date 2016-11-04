/**
 * Check Contributor Home page
 * Check on Contributor Image & Name
 * Click on Follow button
 * Click on Full Bio
 * Click on Show More

 */

package contributorPage;

import iSAFE.ApplicationKeywords;

import java.util.List;

import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class ContributorPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Contributor Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////
	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new contributor page validation.
	 *
	 * @param obj the obj
	 */
	public ContributorPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new contributor page validation.
	 */
	public ContributorPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Desktop2"))
		{
			clickOnMainArticle();
			clickOn(OR.img_Article_Page_Contributor);
			verifyAuthorName();
			clickOnBackButton();
			clickOn(OR.txt_Article_Page_Author_Name);
			verifyAuthorName();
			
			// clickOnBackButton();
			verifyFullBio();
			verifyFollowInDeskyop();
			//validatePromoBlogs();
			//validateLatestPosts();
			validatePromoLatestPosts();
			//verifyShowMoreInDesktop();

		}
		else
		{
		
			//clickOnMainArticle();
			clickOn(OR.txt_Mob_Contributor_Page_Article);
			verifyContributorDetailsInMobile();
			verifyAuthorNameInMobile();
			verifyFullBio();
			verifyFollowInMobile();
			validateLatestPosts();
			
			/*verifyNewPostsInMobile();
			clickOn(OR.tab_Mob_Contributor_Page_Posts_Latest);
			verifyShowMoreInMobile();*/
		}
		
	}
	
	public void validatePromoLatestPosts()
	{
		testStepInfo("*************************************** Contributor Promo Blogs *******************************************");
		try {
			List<WebElement> links=driver.findElements(By.xpath("//section[@class='section section-2  contrib-top-feature']//ul//li/a[2]//h3"));
			int countLinks=links.size();
			testStepPassed("Total number of Promo blogs are ---"+countLinks);
			if(countLinks==4)
			{
				for (int i = 1; i <=countLinks; i++)
				{
					scrollBy(0, 60);
					String countributorBlogs="Promo Blogs#xpath=//section[@class='section section-2  contrib-top-feature']//ul//li["+i+"]/a[2]//h3";
					String textPromo=getText(countributorBlogs);
					testStepPassed(textPromo);
					
				}
				
				testStepInfo("*************************************** Latest Posts *******************************************");
				scrollBy(0, 200);
				List<WebElement> allPosts=driver.findElements(By.xpath("//div[@id='contrib-main-content']/div/section[4]/span/div[1]/div[2]/div/div//ul//li[@class='article ng-scope']//div//div//h3"));
				int countPosts=allPosts.size();
				testStepPassed("Total Number of Posts are --- "+countPosts);
				
				if(countPosts==5 ||  countPosts>=7 )
				{

					for (int i = 1; i <=countPosts; i++)
					{
						String countributorPosts="Contributor Posts#xpath=//div[@id='contrib-main-content']/div/section[4]/span/div[1]/div[2]/div/div//ul//li[@class='article ng-scope']["+i+"]//div//div//h3";
						String textPromo=getText(countributorPosts);
						testStepPassed(textPromo);
					}
					verifyShowMoreInDesktop();	
				}
				else if(countPosts==0)
				{
					testStepFailed("Posts are not displayed");
				}
				else
				{
					testStepFailed("Show more button is not displayed for this Contributor");
				}
			}
			else
			{
				testStepFailed("Posts are not displayed in the Latest Tab");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateLatestPosts()
	{
		testStepInfo("*************************************** Latest Posts *******************************************");
		try {
			scrollBy(0, 200);
			List<WebElement> allPosts=driver.findElements(By.xpath("//div[@id='contrib-main-content']/div/section[4]/span/div[1]/div[2]/div/div//ul//li[@class='article ng-scope']//div//div//h3"));
			int countPosts=allPosts.size();
			testStepPassed("Total Number of Posts are --- "+countPosts);
			for (int i = 1; i <=countPosts; i++)
			{
				String countributorPosts="Contributor Posts#xpath=//div[@id='contrib-main-content']/div/section[4]/span/div[1]/div[2]/div/div//ul//li[@class='article ng-scope']["+i+"]//div//div//h3";
				String textPosts=getText(countributorPosts);
				testStepPassed(textPosts);
			}
			if(countPosts==5 ||  countPosts>=7 )
			{
				
				verifyShowMoreInDesktop();	
			}
			else if(countPosts==0 || countPosts<=4)
			{
				testStepFailed("Show More button is not displayed");
			}
				
			else
			{
				testStepFailed("Show more button is not displayed for this Contributor");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validatePromoBlogs()
	{
		testStepInfo("************************************** Contributor Promo Blogs *****************************************************");
		try {
			List<WebElement> links=driver.findElements(By.xpath("//section[@class='section section-2  contrib-top-feature']//ul//li/a[2]//h3"));
			int countLinks=links.size();
			testStepPassed("Total number of Promo blogs are ---"+countLinks);
			for (int i = 1; i <=countLinks; i++)
			{
				scrollBy(0, 60);
				String countributorBlogs="Promo Blogs#xpath=//section[@class='section section-2  contrib-top-feature']//ul//li["+i+"]/a[2]//h3";
				String textPromo=getText(countributorBlogs);
				testStepPassed(textPromo);
				
			}
		} catch (Exception e) {
			testStepFailed("Promo blogs are not displayed");
		}
	}

	/**
	 * Verify author name.
	 */
	public void verifyAuthorName() {
		try {
			boolean authorName = elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
			if (authorName == true) {
				String contributor = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);

				testStepPassed("Navigated to Contributor Page--" + contributor);
				//clickOnBackButton();
			} else {
				testStepFailed("Failed to navigate to the author page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Contributor Name link is broke");
		}
	}
	
	public void verifyFullBio()
	{
		testStepInfo("******************************************** Full Bio *******************************************************");
		try {
			waitTime(3);
			boolean varFullBio=elementPresent(OR.btn_Contributor_Page_Full_Bio);
			if (varFullBio==true) {
				testStepPassed("Full Bio is displayed");
				clickOn(OR.btn_Contributor_Page_Full_Bio);
				String fullBio = getText(OR.txt_Contributor_Page_Full_Bio_Details);
				testStepPassed(fullBio);
				clickOn(OR.btn_Contributor_Page_Full_Bio);
				
			}
			else {
				testStepFailed("Full Bio is not displayed ");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void verifyFollowInDeskyop()
	{
		testStepInfo("******************************************** Follow *******************************************************");
		try {
			boolean follow=elementPresent(OR.btn_Contributor_Page_Follow);
			if(follow==true)
			{
			mouseOver(OR.btn_Contributor_Page_Follow);
			testStepPassed("Follow is displayed");
			//manualScreenshot(OR.btn_Contributor_Page_Follow);
			}
			else
			{
				testStepFailed("Follow is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyShowMoreInDesktop()
	{
		testStepInfo("******************************************** Show More *******************************************************");
		try {
			//waitForElement(OR.btn_Contributor_Page_Show_More);
			scrollBy(0, 700);
			//scrollToElement(OR.btn_Contributor_Page_Show_More);
		//	scrollToElement(OR.btn_Contributor_Page_Show_More);
			waitTime(3);
			//takeAdScreenshot(OR.btn_Contributor_Page_Show_More,"Show More");
			boolean showMore=elementPresent(OR.btn_Contributor_Page_Show_More);
			if (showMore==true)
			{
			
				//clickOn(OR.btn_Contributor_Page_Show_More);
				testStepPassed("Show More button is displayed");
			}
			else
			{
				testStepFailed("Show More button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Author : Shakira
	 * Created on : 23 June 2016
	 * 
	 */
	public void verifyContributorDetailsInMobile()
	{
		testStepInfo("************************************* Contributor Details ************************************************");
		try {
			boolean authorName=elementPresent(OR.txt_Mob_Contributor_Page_Author_Name);
			if(authorName==true)
			{
				testStepPassed("Author name is displayed");
				clickOn(OR.txt_Mob_Contributor_Page_Author_Name);
			}
			else
			{
				testStepFailed("Author name is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyFollowInMobile()
	{
		testStepInfo("******************************************** Follow *******************************************************");
		try {
			boolean follow=elementPresent(OR.btn_Contributor_Page_Follow);
			if (follow==true) {
				testStepPassed("Follow button is displayed");
				clickOn(OR.btn_Contributor_Page_Follow);
				boolean socialShare=elementPresent(OR.img_Mob_Contributor_Page_Social_Share);
				if (socialShare==true) {
					testStepPassed("Social Shares are displayed");
					clickOn(OR.btn_Mob_Contributor_Page_Close);
				}
				else
				{
					testStepFailed("Social Shares are not displayed");
				}
				
			}
			else
			{
				testStepFailed("Follow button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void verifyAuthorNameInMobile()
	{
		try {
			boolean auhtorImage=elementPresent(OR.img_Mob_Contributor_Page_Author_Image);
			if(auhtorImage==true)
			{
				testStepPassed("Author image is displayed");
			}
			else
			{
				testStepFailed("Author image is not displayed");
			}
			
			
			boolean author=elementPresent(OR.txt_Mob_Contributor_Page_Author);
			if (author==true) {
				String authorName=getText(OR.txt_Mob_Contributor_Page_Author);
				testStepPassed("Author Name is ---"+authorName);
				testStepPassed("Author Name is displayed");
			}
			else
			{
				testStepFailed("Author Name is not displayed");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Created On : 24 June 2016
	 */
	
	public void verifyNewPostsInMobile()
	{
		
		try {
			scrollToElement(OR.tab_Mob_Contributor_Page_Posts_Latest);
			scrollBy(0, -60);
			waitTime(3);
			boolean latest=elementPresent(OR.tab_Mob_Contributor_Page_Posts_Latest);
			if(latest==true)
			{
				testStepPassed("Latest tab is displayed");	
				
			}
			else
			{
				testStepFailed("Latest tab is not displayed");	
			}
			//scrollBy(0, 200);
			boolean archive=elementPresent(OR.tab_Mob_Contributor_Page_Posts_Archive);
			if (archive==true) {
				clickOn(OR.tab_Mob_Contributor_Page_Posts_Archive);
				testStepPassed("Archive tab is displayed");
			}
			else
			{
				testStepFailed("Archive tab is not displayed");	
			}
			//clickOn(OR.tab_Mob_Contributor_Page_Posts_Latest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void verifyShowMoreInMobile()
	{
		testStepInfo("******************************************** Show More *******************************************************");
		try {
			//waitForElement(OR.btn_Contributor_Page_Show_More);
			scrollBy(0, 900);
		//	scrollToElement(OR.btn_Contributor_Page_Show_More);
			waitTime(3);
			boolean showMore=elementPresent(OR.btn_Contributor_Page_Show_More);
			if (showMore==true)
			{
			
				//clickOn(OR.btn_Contributor_Page_Show_More);
				testStepPassed("Show More button is displayed");
			}
			else
			{
				testStepFailed("Show More button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Show More button is not displayed");
		}
	}
}
