package TestCases;

import galleryCheck.GalleryPageFunctionalityCheck;
import homePage.HomePageValidation;
import iSAFE.ApplicationKeywords;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import listsPage.ListsPageValidation;
import mostPopularPage.MostPopularPageValidation;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import realTimePage.RealTimePageValidation;
import videoPage.VideoPageValidation;
import welcomePage.WelcomePageValidation;
import AutomationFramework.GenericKeywords;
import angularGalleryCheck.AngularGalleryFunctionalityCheck;
import articlePage.ArticlePageValidation;
import baseClass.BaseClass;
import bvPageCheck.BVPageFunctions;
import contributorPage.ContributorPageValidation;
import csfPageCheck.CSFPageFunctionality;
import csrPageCheck.CSRPageFunctionality;

@Listeners({ Utilities.HtmlReport.class })
public class TestCases {
	String machineName = "";
	BaseClass obj;
	WelcomePageValidation welcomePageValidation;
	HomePageValidation homePageValidation;
	ArticlePageValidation articlePageValidation;
	MostPopularPageValidation mostPopularPageValidation;
	RealTimePageValidation realTimePageValidation;
	ContributorPageValidation contributorPageValidation;
	VideoPageValidation videoPageValidation;
	ListsPageValidation listsPageValidation;

	BVPageFunctions bvpagefunctions;
	GalleryPageFunctionalityCheck gallerypagefunctionalitycheck;
	AngularGalleryFunctionalityCheck angulargalleryfunctionalitycheck;
	CSFPageFunctionality csffunctionality;
	CSRPageFunctionality csrfunctionality;

	public void TestStart(String testCaseDescription, String hostName,
			String testCaseName) {

		obj.currentTestCaseName = testCaseName;
		obj.setEnvironmentTimeouts();
		obj.reportStart(testCaseDescription, hostName);
		obj.iterationCount.clear();
		obj.iterationCountInTextData();

	}

	@BeforeClass
	@Parameters({ "selenium.machinename", "selenium.host", "selenium.port",
			"selenium.browser", "selenium.os", "selenium.browserVersion",
			"selenium.osVersion", "TestData.SheetNumber" })
	public void precondition(String machineName, String host, String port,
			String browser, String os, String browserVersion, String osVersion,
			String sheetNo) {

		// module2functionalities.udid="ZX1D64HN6H";
		obj = new BaseClass();
		obj.udid = "a9039b11";
		if (os.contains("Android")) {
			// obj.startServer(host,port);
			// obj.waitTime(10);
		}
		obj.setup(machineName, host, port, browser, os, browserVersion,
				osVersion, sheetNo);
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC001_MR_WelcomePage(String machineName, Method method)
			throws MalformedURLException {

		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop1"))
		{
		
		TestStart("Welcome Page Validations", machineName, method.getName());
		welcomePageValidation = new WelcomePageValidation(obj);
		for (int i = 0; i < welcomePageValidation.iterationCount.size(); i++) {

			welcomePageValidation.dataRowNo = Integer
					.parseInt(welcomePageValidation.iterationCount.get(i)
							.toString());
			welcomePageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					welcomePageValidation.currentExecutionMachineName,
					welcomePageValidation.currentTestCaseName);
			welcomePageValidation.navigateTo("http://www.forbes.com/forbes/welcome/?autoforward=false");
			welcomePageValidation.verifyWelcomePage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Welcome Page Validations", machineName, method.getName());
			welcomePageValidation = new WelcomePageValidation(obj);
			for (int i = 0; i < welcomePageValidation.iterationCount.size(); i++) {

				welcomePageValidation.dataRowNo = Integer
						.parseInt(welcomePageValidation.iterationCount.get(i)
								.toString());
				welcomePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						welcomePageValidation.currentExecutionMachineName,
						welcomePageValidation.currentTestCaseName);
				welcomePageValidation.navigateTo("http://www.forbes.com/forbes/welcome/?autoforward=false");
				welcomePageValidation.verifyWelcomePage();
			}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = welcomePageValidation.testCaseExecutionStatus;
		obj.testFailure=welcomePageValidation.testFailure;
		TestEnd();
	}

	@AfterClass
	public void closeSessions() {
		obj.closeAllSessions();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC002_MR_HomePage(String machineName, Method method)
			throws MalformedURLException {

		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop1"))
		{
		TestStart("Home page Validations", machineName, method.getName());
		homePageValidation = new HomePageValidation(obj);
		for (int i = 0; i < homePageValidation.iterationCount.size(); i++) {

			homePageValidation.dataRowNo = Integer
					.parseInt(homePageValidation.iterationCount.get(i)
							.toString());
			homePageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					homePageValidation.currentExecutionMachineName,
					homePageValidation.currentTestCaseName);
			homePageValidation.navigateTo("http://www.forbes.com");
			homePageValidation.verifyHomePage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Home page Validations", machineName, method.getName());
			homePageValidation = new HomePageValidation(obj);
			for (int i = 0; i < homePageValidation.iterationCount.size(); i++) {

				homePageValidation.dataRowNo = Integer
						.parseInt(homePageValidation.iterationCount.get(i)
								.toString());
				homePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						homePageValidation.currentExecutionMachineName,
						homePageValidation.currentTestCaseName);
				homePageValidation.navigateTo("http://www.forbes.com");
				homePageValidation.verifyHomePage();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = homePageValidation.testCaseExecutionStatus;
		obj.testFailure=homePageValidation.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC003_MR_ArticlePage(String machineName, Method method) {
		
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop1"))
		{
		TestStart("Article Page Validations", machineName, method.getName());
		articlePageValidation = new ArticlePageValidation(obj);
		for (int i = 0; i < articlePageValidation.iterationCount.size(); i++) {
			articlePageValidation.dataRowNo = Integer
					.parseInt(articlePageValidation.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ articlePageValidation.dataRowNo);
			articlePageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					articlePageValidation.currentExecutionMachineName,
					articlePageValidation.currentTestCaseName);
			articlePageValidation.navigateTo("http://www.forbes.com");
			articlePageValidation.verifyAdsInArticlePage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Article Page Validations", machineName, method.getName());
			articlePageValidation = new ArticlePageValidation(obj);
			for (int i = 0; i < articlePageValidation.iterationCount.size(); i++) {
				articlePageValidation.dataRowNo = Integer
						.parseInt(articlePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ articlePageValidation.dataRowNo);
				articlePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						articlePageValidation.currentExecutionMachineName,
						articlePageValidation.currentTestCaseName);
				articlePageValidation.navigateTo("http://www.forbes.com/");
				articlePageValidation.verifyAdsInArticlePage();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = articlePageValidation.testCaseExecutionStatus;
		obj.testFailure=articlePageValidation.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC004_MR_ContributorPage(String machineName, Method method) {
		
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop2"))
		{
		
		TestStart("Contributor Page Validations", machineName, method.getName());
		contributorPageValidation = new ContributorPageValidation(obj);
		for (int i = 0; i < contributorPageValidation.iterationCount.size(); i++) {
			contributorPageValidation.dataRowNo = Integer
					.parseInt(contributorPageValidation.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ contributorPageValidation.dataRowNo);
			contributorPageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					contributorPageValidation.currentExecutionMachineName,
					contributorPageValidation.currentTestCaseName);
			contributorPageValidation.navigateTo("http://www.forbes.com/");
			contributorPageValidation.validateContributorPage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Contributor Page Validations", machineName, method.getName());
			contributorPageValidation = new ContributorPageValidation(obj);
			for (int i = 0; i < contributorPageValidation.iterationCount.size(); i++) {
				contributorPageValidation.dataRowNo = Integer
						.parseInt(contributorPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ contributorPageValidation.dataRowNo);
				contributorPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						contributorPageValidation.currentExecutionMachineName,
						contributorPageValidation.currentTestCaseName);
				contributorPageValidation.navigateTo("http://www.forbes.com/");
				contributorPageValidation.validateContributorPage();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = contributorPageValidation.testCaseExecutionStatus;
		obj.testFailure=contributorPageValidation.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC005_MR_BVPageTest(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop2"))
		{
		TestStart("BrandVoice Page validation", machineName, method.getName());
		bvpagefunctions = new BVPageFunctions(obj);
		for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
			bvpagefunctions.dataRowNo = Integer
					.parseInt(bvpagefunctions.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ bvpagefunctions.dataRowNo);
			bvpagefunctions.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							bvpagefunctions.currentExecutionMachineName,
							bvpagefunctions.currentTestCaseName);
			bvpagefunctions.navigateTo("http://www.forbes.com/sites/northwesternmutual/");
			bvpagefunctions.verifyBVpageContents();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("BrandVoice Page validation", machineName, method.getName());
			bvpagefunctions = new BVPageFunctions(obj);
			for (int i = 0; i < bvpagefunctions.iterationCount.size(); i++) {
				bvpagefunctions.dataRowNo = Integer
						.parseInt(bvpagefunctions.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ bvpagefunctions.dataRowNo);
				bvpagefunctions.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
								bvpagefunctions.currentExecutionMachineName,
								bvpagefunctions.currentTestCaseName);
				bvpagefunctions.navigateTo("http://www.forbes.com/sites/northwesternmutual/");
				bvpagefunctions.verifyBVpageContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = bvpagefunctions.testCaseExecutionStatus;
		obj.testFailure=bvpagefunctions.testFailure;
		TestEnd();
	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC006_MR_NewPostPage(String machineName, Method method) {
		
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop3"))
		{
		TestStart("New Posts Page Validations", machineName, method.getName());
		realTimePageValidation = new RealTimePageValidation(obj);
		for (int i = 0; i < realTimePageValidation.iterationCount.size(); i++) {
			realTimePageValidation.dataRowNo = Integer
					.parseInt(realTimePageValidation.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ realTimePageValidation.dataRowNo);
			realTimePageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					realTimePageValidation.currentExecutionMachineName,
					realTimePageValidation.currentTestCaseName);
			realTimePageValidation.navigateTo("http://www.forbes.com/real-time/");
			realTimePageValidation.verifyNewPostsPage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("New Posts Page Validations", machineName, method.getName());
			realTimePageValidation = new RealTimePageValidation(obj);
			for (int i = 0; i < realTimePageValidation.iterationCount.size(); i++) {
				realTimePageValidation.dataRowNo = Integer
						.parseInt(realTimePageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ realTimePageValidation.dataRowNo);
				realTimePageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						realTimePageValidation.currentExecutionMachineName,
						realTimePageValidation.currentTestCaseName);
				realTimePageValidation.navigateTo("http://www.forbes.com/real-time/");
				realTimePageValidation.verifyNewPostsPage();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = realTimePageValidation.testCaseExecutionStatus;
		obj.testFailure=realTimePageValidation.testFailure;
		TestEnd();

	}


	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC007_MR_MostPopularPage(String machineName, Method method)
			throws Exception {
		
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop3"))
		{
		TestStart("Most Popular validation", machineName, method.getName());
		mostPopularPageValidation = new MostPopularPageValidation(obj);
		for (int i = 0; i < mostPopularPageValidation.iterationCount.size(); i++) {
			mostPopularPageValidation.dataRowNo = Integer
					.parseInt(mostPopularPageValidation.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ mostPopularPageValidation.dataRowNo);
			mostPopularPageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
					mostPopularPageValidation.currentExecutionMachineName,
					mostPopularPageValidation.currentTestCaseName);
			mostPopularPageValidation.navigateTo("http://www.forbes.com/most-popular/");
			mostPopularPageValidation.verifyMostPopularPage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
			
		{
			TestStart("Most Popular validation", machineName, method.getName());
			mostPopularPageValidation = new MostPopularPageValidation(obj);
			for (int i = 0; i < mostPopularPageValidation.iterationCount.size(); i++) {
				mostPopularPageValidation.dataRowNo = Integer
						.parseInt(mostPopularPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ mostPopularPageValidation.dataRowNo);
				mostPopularPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
						mostPopularPageValidation.currentExecutionMachineName,
						mostPopularPageValidation.currentTestCaseName);
				mostPopularPageValidation.navigateTo("http://www.forbes.com/most-popular/");
				mostPopularPageValidation.verifyMostPopularPage();
		}
		}
			else
			{
				throw new SkipException("");
			}
		obj.testCaseExecutionStatus = mostPopularPageValidation.testCaseExecutionStatus;
		obj.testFailure=mostPopularPageValidation.testFailure;
		TestEnd();
	}
	
	/*@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC10_MR_TemplateGalleryCheck(String machineName, Method method)  {
		
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop1"))
		{
		TestStart("Template Gallery Check", machineName, method.getName());
		gallerypagefunctionalitycheck = new GalleryPageFunctionalityCheck(obj);
		for (int i = 0; i < gallerypagefunctionalitycheck.iterationCount.size(); i++) {
			gallerypagefunctionalitycheck.dataRowNo = Integer
					.parseInt(gallerypagefunctionalitycheck.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ gallerypagefunctionalitycheck.dataRowNo);
			gallerypagefunctionalitycheck.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							gallerypagefunctionalitycheck.currentExecutionMachineName,
							gallerypagefunctionalitycheck.currentTestCaseName);
			gallerypagefunctionalitycheck.navigateTo("http://www.forbes.com/most-popular/");
			gallerypagefunctionalitycheck.verifyTemplateGallery();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Template Gallery Check", machineName, method.getName());
			gallerypagefunctionalitycheck = new GalleryPageFunctionalityCheck(obj);
			for (int i = 0; i < gallerypagefunctionalitycheck.iterationCount.size(); i++) {
				gallerypagefunctionalitycheck.dataRowNo = Integer
						.parseInt(gallerypagefunctionalitycheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ gallerypagefunctionalitycheck.dataRowNo);
				gallerypagefunctionalitycheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
								gallerypagefunctionalitycheck.currentExecutionMachineName,
								gallerypagefunctionalitycheck.currentTestCaseName);
				gallerypagefunctionalitycheck.navigateTo("http://www.forbes.com/most-popular/");
				gallerypagefunctionalitycheck.verifyTemplateGallery();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = gallerypagefunctionalitycheck.testCaseExecutionStatus;
		obj.testFailure=gallerypagefunctionalitycheck.testFailure;
		TestEnd();
	}*/
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC008_MR_AngularGalleryCheck(String machineName, Method method) throws MalformedURLException, IOException {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop3"))
		{
		TestStart("Angular Gallery Check", machineName, method.getName());
		angulargalleryfunctionalitycheck = new AngularGalleryFunctionalityCheck(obj);
		for (int i = 0; i < angulargalleryfunctionalitycheck.iterationCount.size(); i++) {
			angulargalleryfunctionalitycheck.dataRowNo = Integer
					.parseInt(angulargalleryfunctionalitycheck.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ angulargalleryfunctionalitycheck.dataRowNo);
			angulargalleryfunctionalitycheck.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							angulargalleryfunctionalitycheck.currentExecutionMachineName,
							angulargalleryfunctionalitycheck.currentTestCaseName);
			angulargalleryfunctionalitycheck.navigateTo("http://www.forbes.com/most-popular/");
			angulargalleryfunctionalitycheck.verifyAngularGallery();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Angular Gallery Check", machineName, method.getName());
			angulargalleryfunctionalitycheck = new AngularGalleryFunctionalityCheck(obj);
			for (int i = 0; i < angulargalleryfunctionalitycheck.iterationCount.size(); i++) {
				angulargalleryfunctionalitycheck.dataRowNo = Integer
						.parseInt(angulargalleryfunctionalitycheck.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ angulargalleryfunctionalitycheck.dataRowNo);
				angulargalleryfunctionalitycheck.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
								angulargalleryfunctionalitycheck.currentExecutionMachineName,
								angulargalleryfunctionalitycheck.currentTestCaseName);
				angulargalleryfunctionalitycheck.navigateTo("http://www.forbes.com/most-popular/");
				angulargalleryfunctionalitycheck.verifyAngularGallery();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = angulargalleryfunctionalitycheck.testCaseExecutionStatus;
		obj.testFailure=angulargalleryfunctionalitycheck.testFailure;
		TestEnd();
	}

	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC009_MR_VideoPage(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop4"))
		{
		TestStart("Video Page Validations", machineName, method.getName());
		videoPageValidation = new VideoPageValidation(obj);
		for (int i = 0; i < videoPageValidation.iterationCount.size(); i++) {
			videoPageValidation.dataRowNo = Integer
					.parseInt(videoPageValidation.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ videoPageValidation.dataRowNo);
			videoPageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					videoPageValidation.currentExecutionMachineName,
					videoPageValidation.currentTestCaseName);
			videoPageValidation.navigateTo("http://www.forbes.com/video/");
			videoPageValidation.verifyVideoPage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("Video Page Validations", machineName, method.getName());
			videoPageValidation = new VideoPageValidation(obj);
			for (int i = 0; i < videoPageValidation.iterationCount.size(); i++) {
				videoPageValidation.dataRowNo = Integer
						.parseInt(videoPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ videoPageValidation.dataRowNo);
				videoPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						videoPageValidation.currentExecutionMachineName,
						videoPageValidation.currentTestCaseName);
				videoPageValidation.navigateTo("http://www.forbes.com/video/");
				videoPageValidation.verifyVideoPage();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = videoPageValidation.testCaseExecutionStatus;
		obj.testFailure=videoPageValidation.testFailure;
		TestEnd();

	}
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC010_MR_CSFPageCheck(String machineName, Method method) throws MalformedURLException, IOException {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop5"))
		{
		TestStart("CSF Check", machineName, method.getName());
		csffunctionality = new CSFPageFunctionality(obj);
		for (int i = 0; i < csffunctionality.iterationCount.size(); i++) {
			csffunctionality.dataRowNo = Integer
					.parseInt(csffunctionality.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ csffunctionality.dataRowNo);
			csffunctionality.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							csffunctionality.currentExecutionMachineName,
							csffunctionality.currentTestCaseName);
			csffunctionality.navigateTo("http://www.forbes.com/actors");
			csffunctionality.verifyCSFpageContents();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("CSF Check", machineName, method.getName());
			csffunctionality = new CSFPageFunctionality(obj);
			for (int i = 0; i < csffunctionality.iterationCount.size(); i++) {
				csffunctionality.dataRowNo = Integer
						.parseInt(csffunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csffunctionality.dataRowNo);
				csffunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
								csffunctionality.currentExecutionMachineName,
								csffunctionality.currentTestCaseName);
				csffunctionality.navigateTo("http://www.forbes.com/actors");
				csffunctionality.verifyCSFpageContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = csffunctionality.testCaseExecutionStatus;
		obj.testFailure=csffunctionality.testFailure;
		TestEnd();
	}
	
	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC011_MR_CSRPageCheck(String machineName, Method method) throws MalformedURLException, IOException {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop5"))
		{
		TestStart("CSR Check", machineName, method.getName());
		csrfunctionality = new CSRPageFunctionality(obj);
		for (int i = 0; i < csrfunctionality.iterationCount.size(); i++) {
			csrfunctionality.dataRowNo = Integer
					.parseInt(csrfunctionality.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ csrfunctionality.dataRowNo);
			csrfunctionality.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>DataSet:" + (i + 1)
							+ "</font><br/>",
							csrfunctionality.currentExecutionMachineName,
							csrfunctionality.currentTestCaseName);
			csrfunctionality.navigateTo("http://www.forbes.com/business");
			csrfunctionality.verifyCSRpageContents();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
			TestStart("CSR Check", machineName, method.getName());
			csrfunctionality = new CSRPageFunctionality(obj);
			for (int i = 0; i < csrfunctionality.iterationCount.size(); i++) {
				csrfunctionality.dataRowNo = Integer
						.parseInt(csrfunctionality.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ csrfunctionality.dataRowNo);
				csrfunctionality.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>DataSet:" + (i + 1)
								+ "</font><br/>",
								csrfunctionality.currentExecutionMachineName,
								csrfunctionality.currentTestCaseName);
				csrfunctionality.navigateTo("http://www.forbes.com/business");
				csrfunctionality.verifyCSRpageContents();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = csrfunctionality.testCaseExecutionStatus;
		obj.testFailure=csrfunctionality.testFailure;
		TestEnd();
	}

	
	@Test(alwaysRun = true)
	@Parameters({ "selenium.machinename" })
	public void TC012_MR_ListsPage(String machineName, Method method) {
		if(obj.currentExecutionMachineName.equalsIgnoreCase("Desktop5"))
		{
		TestStart("Lists Page Validations", machineName, method.getName());
		listsPageValidation = new ListsPageValidation(obj);
		for (int i = 0; i < listsPageValidation.iterationCount.size(); i++) {
			listsPageValidation.dataRowNo = Integer
					.parseInt(listsPageValidation.iterationCount.get(i)
							.toString());
			System.out.println("-------------->"
					+ listsPageValidation.dataRowNo);
			listsPageValidation.writeHtmlTestStepReport(
					"<font size=4 style='color:blue'>Forbes:" + (i + 1)
							+ "</font><br/>",
					listsPageValidation.currentExecutionMachineName,
					listsPageValidation.currentTestCaseName);
			listsPageValidation.navigateTo("http://www.forbes.com/billionaires/");
			listsPageValidation.verifyListsPage();
		}
		}
		else if(obj.currentExecutionMachineName.startsWith("AndroidMobile"))
		{
		
			TestStart("Lists Page Validations", machineName, method.getName());
			listsPageValidation = new ListsPageValidation(obj);
			for (int i = 0; i < listsPageValidation.iterationCount.size(); i++) {
				listsPageValidation.dataRowNo = Integer
						.parseInt(listsPageValidation.iterationCount.get(i)
								.toString());
				System.out.println("-------------->"
						+ listsPageValidation.dataRowNo);
				listsPageValidation.writeHtmlTestStepReport(
						"<font size=4 style='color:blue'>Forbes:" + (i + 1)
								+ "</font><br/>",
						listsPageValidation.currentExecutionMachineName,
						listsPageValidation.currentTestCaseName);
				listsPageValidation.navigateTo("http://www.forbes.com/billionaires/");
				listsPageValidation.verifyListsPage();
		}
		}
		else
		{
			throw new SkipException("");
		}
		obj.testCaseExecutionStatus = listsPageValidation.testCaseExecutionStatus;
		obj.testFailure=listsPageValidation.testFailure;
		TestEnd();

	}

	// Test cases added by Sindhu 6/7/2016
	
	public void TestEnd() {
		obj.waitTime(1);
		if(obj.testFailure)
		  {
		   ApplicationKeywords.executionReportStatus = "Fail";
		  }
		if (obj.testCaseExecutionStatus) {
			GenericKeywords.testFailed();
		}
	}

	@BeforeMethod
	public void before() {
		obj.testFailure = false;
	}

}
