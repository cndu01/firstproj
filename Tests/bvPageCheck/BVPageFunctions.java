package bvPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class BVPageFunctions extends ApplicationKeywords{
	
	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates  BVPage Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public BVPageFunctions(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public BVPageFunctions() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyBVpageContents(){
		testStepInfo("*********************************BV Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Desktop2")) {

			verifyBVPageContentsInDesktop();

		} else {
			verifyBVPageContentsInMobile();
		}
	}
	
	/*
	 * Verify BrandVoice page contents on Desktop
	 */
	public void verifyBVPageContentsInDesktop(){
	try{
		waitForElement(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVLabel = elementPresent(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVImageIcon = elementPresent(OR.txt_BVPage_Validation_Imageicon);
		Boolean varBVAboutLabel =  elementPresent(OR.txt_BVPage_Validation_Aboutheader);
		Boolean varBVourContributorsLabel =  elementPresent(OR.txt_BVPage_Validation_OurContributors);
		if(varBVLabel==true &&
			varBVImageIcon==true && 
			varBVAboutLabel==true &&
			varBVourContributorsLabel==true){
			testStepPassed("BV Page validation: Forbes BrandVoioce label/Image/About Header is displayed on the page::"+varBVLabel);
		}
		else{
			testStepFailed("BV Page validation: Forbes BrandVoioce label/Image/About Header is not displayed on the page::"+varBVLabel);
		}
		waitTime(3);
		verifyBVPageAdsInDesktop();
		checkShowMoreCircleButtons();
		checkPostsOnBV();
		checkadsOnBVArticlePage();
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/*
	 * Verify BrandVoice page contents on Mobile
	 */
	public void verifyBVPageContentsInMobile(){
		testStepInfo("*********************************Mobile BV Page validation**********************************");
		waitForElement(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVLabel = elementPresent(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVImageIcon = elementPresent(OR.txt_BVPage_Validation_Imageicon);
		Boolean varBVAboutLabel =  elementPresent(OR.txt_BVPage_Validation_Aboutheader);
		Boolean varBVourContributorsLabel =  elementPresent(OR.txt_BVPage_Validation_OurContributors);
		if(varBVLabel==true &&
			varBVImageIcon==true && 
			varBVAboutLabel==true &&
			varBVourContributorsLabel==true){
			testStepPassed("BV Page validation: Forbes BrandVoioce label/Image/About Header is displayed on the page::"+varBVLabel);
		}
		else{
			testStepFailed("BV Page validation: Forbes BrandVoioce label/Image/About Header is not displayed on the page::"+varBVLabel);
		}
		verifyBVPageAdsInDesktop();
		checkShowMoreCircleButtons();
		if(elementPresent(OR.txt_Mob_BVPage_Validation_postsLabel) && elementPresent(OR.button_Mob_BVPage_Validation_Latest) && elementPresent(OR.button_Mob_BVPage_Validation_Archive)){
			testStepPassed("BV Mobile Page validation: Latest and Archive are displayed on the page");
			this.scrollBy(0,1700);
			clickOn(OR.button_Mob_BVPage_Validation_Archive);
			if(elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel) && elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount)){
				testStepPassed("BV Mobile Page validation: Archive List is displayed");
			}
			else{
				testStepFailed("BV Mobile Page validation: Archive List is not displayed");
			}
		}
		else{
			testStepFailed("BV Mobile Page validation: Latest and Archive are not displayed on the page");
		}
		clickOn(OR.button_Mob_BVPage_Validation_inactiveLatest);
		waitTime(2);
		this.scrollBy(0,1700);
		waitTime(3);
		testStepInfo("*********************************Clicking on show more button on BV page**********************************");
		clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
		waitTime(3);
		checkadsOnBVArticlePage();
		
	}
	
	
	/**
	 * check the posts on BV page
	 */
	public void checkPostsOnBV(){
		try{
		testStepInfo("*********************************Verifying posts on BV page**********************************");
		int postCount = getElementCount(OR.txt_BVPage_Validation_BVPosts);
		if(!elementPresent(OR.txt_BVPage_Validation_BV6thPost) &&
				postCount==5){
		testStepPassed("BV Page validation (BV PostStream Showmore Button displayed after - " + postCount+" posts");
		clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
		}
		else{
			testStepInfo("BV Page validation (BV PostStream Showmore Button is displayed after - " + postCount+" posts");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify ads on BV article page
	 */
	public void checkadsOnBVArticlePage(){
		try{
		testStepInfo("****************************Ads on Brand Voice Article Page********************************************");
		this.scrollBy(0, -60);
		clickOn(OR.txt_BVPage_Validation_BV61stPost);
		waitTime(3);
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe')]/following-sibling::iframe[@loaded='1']"));
		int adCount = allAdLinks.size();
		testStepInfo("AdCount Upon landing on BV article Page::"+adCount);
		this.scrollBy(0, 6000);
		waitTime(3);
		waitForElement(OR.txt_BVPage_Validation_recommendedbyBVlabel);
		if(elementPresent(OR.txt_BVPage_Validation_recommendedbyBVlabel))
		{
			testStepPassed("BV Page validation (BV Recommended by BV label is  displayed");
		}
		else{
			takeAdScreenshot(OR.txt_BVPage_Validation_recommendedbyBVlabel, "BV Article Page");
			testStepFailed("BV Page validation (BV Recommended by BV label is not displayed");
		}
		List<WebElement> allAdLinksonScroll = driver
		.findElements(By
				.xpath("//iframe[contains(@id,'google_ads_iframe')]/following-sibling::iframe[@loaded='1']"));
		int adCountOnScroll = allAdLinksonScroll.size();
		testStepInfo("AdCount Upon Scrolling the BV article Page::"+adCountOnScroll);
		if(adCountOnScroll > adCount){
			testStepPassed("BV Page validation (BV Article page ad Count - " + adCountOnScroll+" ads loaded on the page upon scrolling)");
		}	
		else{
			testStepFailed("BV Page validation (BV Article Page Ads are not loaded");
		}
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}

}
