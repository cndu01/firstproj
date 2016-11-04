package angularGalleryCheck;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class AngularGalleryFunctionalityCheck extends ApplicationKeywords {
	
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
	public AngularGalleryFunctionalityCheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public AngularGalleryFunctionalityCheck() {

		// TODO Auto-generated constructor st ub
	}

	public void verifyAngularGallery(){
		testStepInfo("*********************************Angular Gallery Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Desktop3")) {

			verifyAngularGalleryOnDesktop();

		} else {
			verifyAngularGalleryOnMobile();
		}
	}
	
	public void verifyAngularGalleryOnDesktop(){
		waitForElement(OR.txt_GalleryCheck_PopularGallery);
		clickOn(OR.txt_GalleryCheck_PopularGallery);
		checkTopAdOnAngularGallery();
		checkAdsonAngularGallery();
		clickGalleryExpandButton();
		viewAngularGallerySlides();
	}
	
	public void checkTopAdOnAngularGallery(){
	try{
		testStepInfo("*********************************Top Ad Angular Gallery Check**********************************");
		boolean isTopAdDisplayed = elementPresent(OR.txt_AngularGalleryCheck_LeaderBoard);
		if(isTopAdDisplayed){
			testStepInfo("*********************************Top Leaderboard Ad***********************************************");
			testStepPassed("Angular Gallery Check (Angular Gallery Top Leaderboard Ad is displayed- "+ isTopAdDisplayed);
		}
		else{
			testStepFailed("Angular Gallery Check (Angular Gallery Top Leaderboard Ad is not displayed- "+ isTopAdDisplayed);
		}
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void viewAngularGallerySlides(){
		try{
		testStepInfo("*********************************Slides on Angular Gallery**********************************");
		waitTime(5);
		waitForElement(OR.txt_AngularGalleryCheck_ImagesBox);
		boolean isNexticonPresent=elementPresent(OR.txt_AngularGalleryCheck_nextIcon);
		if(isNexticonPresent==true){
			testStepPassed("Angular Gallery Check::Gallery next icon is displayed on the page)");
			
		}
		else if(!isNexticonPresent){
			refreshPage();
			if(isNexticonPresent){
				testStepPassed("Angular Gallery Check::Gallery next icon is displayed on the page after refreshing the page)");
			}
		}
		else{
			testStepFailed("Angular Gallery Check (Gallery imageBox is not displayed on the page)");
		}
		checkImagesInGallery(OR.txt_AngularGalleryCheck_SlideCount,OR.txt_AngularGalleryCheck_nextIcon);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void clickGalleryExpandButton(){
		try{	
			waitForElementToDisplay(OR.txt_AngularGalleryCheck_ExpandIcon, 10);
			boolean isIconDisplayed=elementPresent(OR.txt_AngularGalleryCheck_ExpandIcon);
			if(isIconDisplayed){
		
				testStepPassed("Angular Gallery Check:: Gallery slider icon is displayed on the page ");
				clickOn(OR.txt_AngularGalleryCheck_ExpandIcon);
				waitTime(2);
				boolean isIcon2Displayed=elementPresent(OR.txt_AngularGalleryCheck_AfterExpandIcon);
				if(isIcon2Displayed==true){
					testStepPassed("Angular Gallery Check:: Gallery slider icon is expanded on the gallery");
				}else{
					testStepFailed("Angular Gallery Check:: Gallery slider icon is not expanded on the gallery");
				}
			}
			else{
				testStepFailed("Angular Gallery Check:: Gallery slider icon is not displayed on the page");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void verifyAngularGalleryOnMobile(){
		this.scrollBy(0, 1700);
		waitForElement(OR.txt_GalleryCheck_mobilePopularGallery);
		clickOn(OR.txt_GalleryCheck_mobilePopularGallery);
		CheckMobileAd("//div[@id='mobile-gallery' and @gallery-ad-unit='mobile']");
		for(int i=1;i<6;i++){
			swipeToLeft();
			CheckMobileAd("//div[@id='mobile-gallery' and @gallery-ad-unit='mobile']");
		}
		
	}
}
