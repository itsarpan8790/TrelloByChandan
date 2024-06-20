package com.trello.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.trello.genericutility.BaseClass;
import com.trello.pomrepository.TrelloBoardsPage;
import com.trello.pomrepository.TrelloCreatedBoardPage;
import com.trello.pomrepository.TrelloHomePage;
import com.trello.pomrepository.TrelloLoginIntoContinuePage;
import com.trello.pomrepository.TrelloLoginpage;
import com.trello.pomrepository.TrelloLogoutPage;

public class TrelloBoards extends BaseClass {
	@Test(priority = 3, groups = "systemtesting")
	public void trelloBoardPageCheck() throws Exception {
		webdriverutils.implicityWait(driver);
		TrelloHomePage trello = new TrelloHomePage(driver);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
		webdriverutils.explicityWaitForButton(driver, trello.getLoginOption()).click();
		String exceptedLoginPageTitle = excelUtility.stringCommonData("mySheet", 1, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, exceptedLoginPageTitle);
		String actualLoginPageTitle = driver.getTitle();
		Assert.assertEquals(actualLoginPageTitle, exceptedLoginPageTitle,
				"LoginPageUrl Tile Found Correct and It is Not Verified");
		String exceptedLoginPageurl = excelUtility.stringCommonData("mySheet", 2, 1);
		webdriverutils.explicityPartialurl(driver, exceptedLoginPageurl);
		String actualLoginPageurl = driver.getCurrentUrl();
		Assert.assertEquals(actualLoginPageurl, exceptedLoginPageurl, "ActualLoginPageurl Found and It Is Not Verified");
		TrelloLoginpage trelloLogin = new TrelloLoginpage(driver);
		//Thread.sleep(2000);
		webdriverutils.explicityWaitForButton(driver, trelloLogin.getLogintextField())
				.sendKeys(fileutils.readCommondata("username"));
		trelloLogin.getContinueButton().submit();
		String exceptedLoginToContinuePagetitle = excelUtility.stringCommonData("mysheet", 3, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedLoginToContinuePagetitle);
		String actualLoginToContinuePagetitle = driver.getTitle();
		Assert.assertEquals(actualLoginToContinuePagetitle, exceptedLoginToContinuePagetitle,
				"Login To continue pageTitle  found correct and It Is Not verifed");
		String exceptedLoginToContinuePageUrl = excelUtility.stringCommonData("mySheet", 4, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedLoginToContinuePageUrl), true);
		TrelloLoginIntoContinuePage loginPage = new TrelloLoginIntoContinuePage(driver);
		loginPage.getPasswordTextField().sendKeys(fileutils.readCommondata("password"));
		loginPage.getClickOnLoginButton().click();
		String expectedLoginPageUrl = excelUtility.stringCommonData("mySheet", 5, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLoginPageUrl), true);
		String expectedBordsPageTitle = excelUtility.stringCommonData("mySheet", 6, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, expectedBordsPageTitle);
		String actualBordsPageTitle = driver.getTitle();
		Assert.assertEquals(actualBordsPageTitle, expectedBordsPageTitle,
				"Actual boardsPageTitle Found Correct And it is Not Verified");
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getProfileButton().click();
		boardsPage.getLogoutOption().click();
		String expectedLogoutPageUrl = excelUtility.stringCommonData("mySheet", 8, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLogoutPageUrl), true);
		String expectedLogoutPageTitle = excelUtility.stringCommonData("mysheet", 9, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, expectedLogoutPageTitle);
		String actualLogoutPageTitle = driver.getTitle();
		Assert.assertEquals(actualLogoutPageTitle, expectedLogoutPageTitle,
				"ActualLogoutPageTitle Found And It Is Not Verified");
		TrelloLogoutPage trelloLogoutPage = new TrelloLogoutPage(driver);
		trelloLogoutPage.getLogoutButton().click();
		String exceptedHomePageTitle = excelUtility.stringCommonData("mySheet", 0, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedHomePageTitle);
		String actualHomePageTitleAfterLogout = driver.getTitle();
		Assert.assertEquals(actualHomePageTitleAfterLogout, exceptedHomePageTitle,
				"ActualHomePageTitleAfterLogout Found And It Is Verified");
		String expectedHomePageUrlAfterLogout = excelUtility.stringCommonData("mySheet", 10, 1);
		webdriverutils.explicityPartialurl(driver, expectedHomePageUrlAfterLogout);
		String actualHomePageUrlAfterLogout = driver.getCurrentUrl();
		Assert.assertEquals(actualHomePageUrlAfterLogout, expectedHomePageUrlAfterLogout,
				"ActualHomePageUrlAfterLogout Found Correct And Its Verified");
	}

	@Test(priority = 2, groups = "smoketesting")
	public void trelloLoginPageCheck() throws Exception {
		webdriverutils.implicityWait(driver);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
		TrelloHomePage trello = new TrelloHomePage(driver);
		webdriverutils.explicityWaitForButton(driver, trello.getLoginOption()).click();
		String actualLoginPageTitle = driver.getTitle();
		Assert.assertEquals(actualLoginPageTitle, excelUtility.stringCommonData("mySheet", 1, 1),
				"LoginPageUrl Tile Found Correct and It is Not Verified");
		String actualLoginPageurl = driver.getCurrentUrl();
		Assert.assertEquals(actualLoginPageurl, excelUtility.stringCommonData("mySheet", 2, 1),
				"AtualLoginPageurl Found and It Is Not Verified");
	}

	@Test(priority = 1, groups = "smoketesting")
	public void trelloHomePageCheck() throws Exception {
		webdriverutils.implicityWait(driver);
		String exceptedHomePageTitle = excelUtility.stringCommonData("mySheet", 0, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, exceptedHomePageTitle);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
	}

	@Test(priority = 4, groups = "systemtesting")
	public void trelloCreateAndDeleteBoard() throws Exception {
		webdriverutils.implicityWait(driver);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
		TrelloHomePage trello = new TrelloHomePage(driver);
		// trello.getLoginOption().click();
		webdriverutils.explicityWaitForButton(driver, trello.getLoginOption()).click();
		String actualLoginPageTitle = driver.getTitle();
		Assert.assertEquals(actualLoginPageTitle, excelUtility.stringCommonData("mySheet", 1, 1),
				"LoginPageUrl Tile Found Correct and It is Not Verified");
		String actualLoginPageurl = driver.getCurrentUrl();
		Assert.assertEquals(actualLoginPageurl, excelUtility.stringCommonData("mySheet", 2, 1),
				"AtualLoginPageurl Found and It Is Not Verified");
		TrelloLoginpage trelloLogin = new TrelloLoginpage(driver);
		webdriverutils.explicityWaitForButton(driver, trelloLogin.getLogintextField())
				.sendKeys(fileutils.readCommondata("username"));
		trelloLogin.getContinueButton().submit();
		String exceptedLoginToContinuePagetitle = excelUtility.stringCommonData("mysheet", 3, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedLoginToContinuePagetitle);
		String actualLoginToContinuePagetitle = driver.getTitle();
		Assert.assertEquals(actualLoginToContinuePagetitle, exceptedLoginToContinuePagetitle,
				"Login To continue pageTitle  found correct and It Is Not verifed");

		String exceptedLoginToContinuePageUrl = excelUtility.stringCommonData("mySheet", 4, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedLoginToContinuePageUrl), true);
		TrelloLoginIntoContinuePage loginPage = new TrelloLoginIntoContinuePage(driver);
		loginPage.getPasswordTextField().sendKeys(fileutils.readCommondata("password"));
		loginPage.getClickOnLoginButton().click();
		String expectedLoginPageUrl = excelUtility.stringCommonData("mySheet", 5, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLoginPageUrl), true);
		String expectedBordsPageTitle = excelUtility.stringCommonData("mySheet", 6, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, expectedBordsPageTitle);
		String actualBordsPageTitle = driver.getTitle();
		Assert.assertEquals(actualBordsPageTitle, expectedBordsPageTitle,
				"Actual boardsPageTitle Found Correct And it is Not Verified");
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getCreateOptionButton().click();
		boardsPage.getCreateBoardOptionButton().click();
		if (boardsPage.getBoardTitleTextField().isDisplayed()) {
			Reporter.log("BoardTitleTextField is visible");
		} else {
			Reporter.log("BoardTitleTextField is Not visible");
		}
		boardsPage.getBoardTitleTextField().sendKeys(excelUtility.stringCommonData("mySheet", 11, 1));
		webdriverutils.explicityWaitForButton(driver, boardsPage.getCreateButton()).click();
		String exceptedCreatedBoardsPageTitle = excelUtility.stringCommonData("mySheet", 12, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedCreatedBoardsPageTitle);
		String actualCreatedBoardsPageTitle = driver.getTitle();
		Assert.assertEquals(actualCreatedBoardsPageTitle, exceptedCreatedBoardsPageTitle,
				"Actual Created Boards PageTitle Found And It Is Not Verified");
		String exceptedCreatedBoardsPageUrl = excelUtility.stringCommonData("mySheet", 13, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedCreatedBoardsPageUrl), true);
		TrelloCreatedBoardPage createdBoard = new TrelloCreatedBoardPage(driver);
		createdBoard.getShowMenuOption().click();
		createdBoard.getMoreOption().click();
		createdBoard.getCloseBoardOption().click();
		createdBoard.getCloseOption().click();
		createdBoard.getPermanentlyDeleteBoardOptioon().click();
		createdBoard.getDeleteOption().click();
		boardsPage.getProfileButton().click();
		boardsPage.getLogoutOption().click();
		String expectedLogoutPageUrl = excelUtility.stringCommonData("mySheet", 8, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLogoutPageUrl), true);
		String expectedLogoutPageTitle = excelUtility.stringCommonData("mysheet", 9, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, expectedLogoutPageTitle);
		String actualLogoutPageTitle = driver.getTitle();
		Assert.assertEquals(actualLogoutPageTitle, expectedLogoutPageTitle,
				"ActualLogoutPageTitle Found And It Is Not Verified");
		TrelloLogoutPage trelloLogoutPage = new TrelloLogoutPage(driver);
		trelloLogoutPage.getLogoutButton().click();
		String exceptedHomePageTitle = excelUtility.stringCommonData("mySheet", 0, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedHomePageTitle);
		String actualHomePageTitleAfterLogout = driver.getTitle();
		Assert.assertEquals(actualHomePageTitleAfterLogout, exceptedHomePageTitle,
				"ActualHomePageTitleAfterLogout Found And It Is Verified");
		String expectedHomePageUrlAfterLogout = excelUtility.stringCommonData("mySheet", 10, 1);
		webdriverutils.explicityPartialurl(driver, expectedHomePageUrlAfterLogout);
		String actualHomePageUrlAfterLogout = driver.getCurrentUrl();
		Assert.assertEquals(actualHomePageUrlAfterLogout, expectedHomePageUrlAfterLogout,
				"ActualHomePageUrlAfterLogout Found Correct And Its Verified");
	}

	@Test(priority = 5, groups = "systemtesting")
	public void trelloCreateMultipleListAndSwapInCreatedBoard() throws Exception {
		webdriverutils.implicityWait(driver);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
		TrelloHomePage trello = new TrelloHomePage(driver);
		webdriverutils.explicityWaitForButton(driver, trello.getLoginOption()).click();
		String actualLoginPageTitle = driver.getTitle();
		Assert.assertEquals(actualLoginPageTitle, excelUtility.stringCommonData("mySheet", 1, 1),
				"LoginPageUrl Tile Found Correct and It is Not Verified");
		String actualLoginPageurl = driver.getCurrentUrl();
		Assert.assertEquals(actualLoginPageurl, excelUtility.stringCommonData("mySheet", 2, 1),
				"AtualLoginPageurl Found and It Is Not Verified");
		TrelloLoginpage trelloLogin = new TrelloLoginpage(driver);
		webdriverutils.explicityWaitForButton(driver, trelloLogin.getLogintextField())
				.sendKeys(fileutils.readCommondata("username"));
		trelloLogin.getContinueButton().submit();
		String exceptedLoginToContinuePagetitle = excelUtility.stringCommonData("mysheet", 3, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedLoginToContinuePagetitle);
		String actualLoginToContinuePagetitle = driver.getTitle();
		Assert.assertEquals(actualLoginToContinuePagetitle, exceptedLoginToContinuePagetitle,
				"Login To continue pageTitle  found correct and It Is Not verifed");
		String exceptedLoginToContinuePageUrl = excelUtility.stringCommonData("mySheet", 4, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedLoginToContinuePageUrl), true);
		TrelloLoginIntoContinuePage loginPage = new TrelloLoginIntoContinuePage(driver);
		loginPage.getPasswordTextField().sendKeys(fileutils.readCommondata("password"));
		loginPage.getClickOnLoginButton().click();
		String expectedLoginPageUrl = excelUtility.stringCommonData("mySheet", 5, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLoginPageUrl), true);
		String expectedBordsPageTitle = excelUtility.stringCommonData("mySheet", 6, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, expectedBordsPageTitle);
		String actualBordsPageTitle = driver.getTitle();
		Assert.assertEquals(actualBordsPageTitle, expectedBordsPageTitle,
				"Actual boardsPageTitle Found Correct And it is Not Verified");
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getCreateOptionButton().click();
		boardsPage.getCreateBoardOptionButton().click();
		if (boardsPage.getBoardTitleTextField().isDisplayed()) {
			Reporter.log("BoardTitleTextField is visible");
		} else {
			Reporter.log("BoardTitleTextField is Not visible");
		}
		boardsPage.getBoardTitleTextField().sendKeys(excelUtility.stringCommonData("mySheet", 11, 1));
		webdriverutils.explicityWaitForButton(driver, boardsPage.getCreateButton()).click();
		String exceptedCreatedBoardsPageTitle = excelUtility.stringCommonData("mySheet", 12, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedCreatedBoardsPageTitle);
		String actualCreatedBoardsPageTitle = driver.getTitle();
		Assert.assertEquals(actualCreatedBoardsPageTitle, exceptedCreatedBoardsPageTitle,
				"Actual Created Boards PageTitle Found And It Is Not Verified");
		String exceptedCreatedBoardsPageUrl = excelUtility.stringCommonData("mySheet", 13, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedCreatedBoardsPageUrl), true);
		TrelloCreatedBoardPage createdBoardPage = new TrelloCreatedBoardPage(driver);
		createdBoardPage.getAddAnotherListButton().click();
		createdBoardPage.getEnterListTitleTextField1().sendKeys(excelUtility.stringCommonData("mySheet", 14, 1));
		createdBoardPage.getAddListButton().click();
		createdBoardPage.getEnterListTitleTextField2().sendKeys(excelUtility.stringCommonData("mySheet", 15, 1));
		createdBoardPage.getAddListButton().click();
		Actions action = new Actions(driver);
		action.clickAndHold(createdBoardPage.getAddedListTesting())
				.moveToElement(createdBoardPage.getAddedListPending()).release().build().perform();
		TrelloCreatedBoardPage createdBoard = new TrelloCreatedBoardPage(driver);
		createdBoard.getShowMenuOption().click();
		createdBoard.getMoreOption().click();
		createdBoard.getCloseBoardOption().click();
		createdBoard.getCloseOption().click();
		createdBoard.getPermanentlyDeleteBoardOptioon().click();
		createdBoard.getDeleteOption().click();
		boardsPage.getProfileButton().click();
		boardsPage.getLogoutOption().click();
		String expectedLogoutPageUrl = excelUtility.stringCommonData("mySheet", 8, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLogoutPageUrl), true);
		String expectedLogoutPageTitle = excelUtility.stringCommonData("mysheet", 9, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, expectedLogoutPageTitle);
		String actualLogoutPageTitle = driver.getTitle();
		Assert.assertEquals(actualLogoutPageTitle, expectedLogoutPageTitle,
				"ActualLogoutPageTitle Found And It Is Not Verified");
		TrelloLogoutPage trelloLogoutPage = new TrelloLogoutPage(driver);
		trelloLogoutPage.getLogoutButton().click();
		String exceptedHomePageTitle = excelUtility.stringCommonData("mySheet", 0, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedHomePageTitle);
		String actualHomePageTitleAfterLogout = driver.getTitle();
		Assert.assertEquals(actualHomePageTitleAfterLogout, exceptedHomePageTitle,
				"ActualHomePageTitleAfterLogout Found And It Is Verified");
		String expectedHomePageUrlAfterLogout = excelUtility.stringCommonData("mySheet", 10, 1);
		webdriverutils.explicityPartialurl(driver, expectedHomePageUrlAfterLogout);
		String actualHomePageUrlAfterLogout = driver.getCurrentUrl();
		Assert.assertEquals(actualHomePageUrlAfterLogout, expectedHomePageUrlAfterLogout,
				"ActualHomePageUrlAfterLogout Found Correct And Its Verified");
	}
}
