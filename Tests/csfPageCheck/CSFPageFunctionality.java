package csfPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class CSFPageFunctionality extends ApplicationKeywords{
	
	
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
	public CSFPageFunctionality(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public CSFPageFunctionality() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyCSFpageContents(){
		testStepInfo("*********************************CSF Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Desktop5")) {

			verifyCSFPageContentsInDesktop();

		} else {
			verifyCSFPageContentsInMobile();
		}
	}
	
	public void verifyCSFPageContentsInDesktop(){
		checkAdOnCSF();
		isListDisplayed();
		checkImagesOnCSF();
		checkvideosOnCSF();
	}
	
	
	public void verifyCSFPageContentsInMobile(){
		checkAdOnCSF();
		CheckMobileAd(OR.ad_MobileCSFPageCheck_Stickymobilead);
		this.scrollBy(0, 1000);
		isListDisplayedOnMobile("//span[@class='more']");
		checkImagesOnCSF();
		checkvideosOnCSF();
		
	}
	
	public void checkAdOnCSF(){
	try{
		waitTime(3);	
		int adCount = getElementCount(OR.ads_CSFPageCheck_allAdsOnCSF);
		testStepInfo("AdCount Upon landing on  CSF Page is"+adCount);
		if(adCount!=0){
			testStepPassed("CSF Page Check : "+ adCount+" ads are displayed on the CSF page");
		}
		else{
			testStepFailed("CSF Page Check : Ads are displayed on the CSF page");
		}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
	
	public void checkImagesOnCSF(){
		try{
		testStepInfo("*********************************Images check on CSF Page***********************************************");
		List<WebElement> images = driver.findElements(By.xpath("//div[@class='block-image ratio16x9']"));
		for(int i=0;i<images.size();i++){
			if(images.get(i).isDisplayed()){
				 testStepPassed("CSF image" +i +" is displayed");
			}
			else{
				testStepFailed("CSF image" +i +" is not displayed");
			}
		}
		testStepPassed("Number of CSF images displayed: " +images.size());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void checkvideosOnCSF(){
		try{
		testStepInfo("*********************************Videos check on CSF Page***********************************************");
		List<WebElement> videos = driver.findElements(By.xpath("//div[contains(@class,'video-thumb ratio16x9')]"));
		for(int i=0;i<videos.size();i++){
			if(videos.get(i).isDisplayed()){
				 testStepPassed("CSF video" +i+" is displayed");
			}
			else{
				testStepFailed("CSF video" +i+" is not displayed");
			}
		}	
		 testStepPassed("Number of CSF Videos displayed: "+videos.size());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
}
