package com.trello.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.trello.genericutility.BaseClass;
import com.trello.pomrepository.TrelloAnothersBoardPage;
import com.trello.pomrepository.TrelloBoardsPage;
import com.trello.pomrepository.TrelloCreatedBoardPage;
import com.trello.pomrepository.TrelloHomePage;
import com.trello.pomrepository.TrelloLoginIntoContinuePage;
import com.trello.pomrepository.TrelloLoginpage;
import com.trello.pomrepository.TrelloLogoutPage;

public class TrelloBoards2 extends BaseClass {
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
		Assert.assertEquals(actualLoginPageurl, exceptedLoginPageurl, "AtualLoginPageurl Found and It Is Not Verified");
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
		Assert.assertEquals(actualLoginPageurl, exceptedLoginPageurl, "AtualLoginPageurl Found and It Is Not Verified");
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
		TrelloHomePage trello = new TrelloHomePage(driver);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
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
		webdriverutils.explicityWaitForButton(driver, trelloLogin.getContinueButton()).submit();
		String exceptedLoginToContinuePagetitle = excelUtility.stringCommonData("mysheet", 3, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedLoginToContinuePagetitle);
		String actualLoginToContinuePagetitle = driver.getTitle();
		Assert.assertEquals(actualLoginToContinuePagetitle, exceptedLoginToContinuePagetitle,
				"Login To continue pageTitle  found correct and It Is Not verifed");

		String exceptedLoginToContinuePageUrl = excelUtility.stringCommonData("mySheet", 4, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedLoginToContinuePageUrl), true);
		TrelloLoginIntoContinuePage loginPage = new TrelloLoginIntoContinuePage(driver);
		webdriverutils.explicityWaitForButton(driver, loginPage.getPasswordTextField())
				.sendKeys(fileutils.readCommondata("password"));
		webdriverutils.explicityWaitForButton(driver, loginPage.getClickOnLoginButton()).click();
		String expectedLoginPageUrl = excelUtility.stringCommonData("mySheet", 5, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLoginPageUrl), true);
		String expectedBordsPageTitle = excelUtility.stringCommonData("mySheet", 6, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, expectedBordsPageTitle);
		String actualBordsPageTitle = driver.getTitle();
		Assert.assertEquals(actualBordsPageTitle, expectedBordsPageTitle,
				"Actual boardsPageTitle Found Correct And it is Not Verified");
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverutils.explicityWaitForButton(driver, boardsPage.getCreateOptionButton()).click();
		webdriverutils.explicityWaitForButton(driver, boardsPage.getCreateBoardOptionButton()).click();
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
		TrelloHomePage trello = new TrelloHomePage(driver);
		String actualHomePageTitle = driver.getTitle();
		Assert.assertEquals(actualHomePageTitle, excelUtility.stringCommonData("mySheet", 0, 1),
				"HomePage Title IS Found and It is not Verified");
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
		webdriverutils.explicityWaitForButton(driver, trelloLogin.getContinueButton()).submit();
		String exceptedLoginToContinuePagetitle = excelUtility.stringCommonData("mysheet", 3, 1);
		webdriverutils.explicitywaitForCompleteTitle(driver, exceptedLoginToContinuePagetitle);
		String actualLoginToContinuePagetitle = driver.getTitle();
		Assert.assertEquals(actualLoginToContinuePagetitle, exceptedLoginToContinuePagetitle,
				"Login To continue pageTitle  found correct and It Is Not verifed");

		String exceptedLoginToContinuePageUrl = excelUtility.stringCommonData("mySheet", 4, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, exceptedLoginToContinuePageUrl), true);
		TrelloLoginIntoContinuePage loginPage = new TrelloLoginIntoContinuePage(driver);
		webdriverutils.explicityWaitForButton(driver, loginPage.getPasswordTextField())
				.sendKeys(fileutils.readCommondata("password"));
		webdriverutils.explicityWaitForButton(driver, loginPage.getClickOnLoginButton()).click();
		String expectedLoginPageUrl = excelUtility.stringCommonData("mySheet", 5, 1);
		Assert.assertEquals(webdriverutils.explicityPartialurl(driver, expectedLoginPageUrl), true);
		String expectedBordsPageTitle = excelUtility.stringCommonData("mySheet", 6, 1);
		webdriverutils.explicitWaitForPartialTitle(driver, expectedBordsPageTitle);
		String actualBordsPageTitle = driver.getTitle();
		Assert.assertEquals(actualBordsPageTitle, expectedBordsPageTitle,
				"Actual boardsPageTitle Found Correct And it is Not Verified");
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverutils.explicityWaitForButton(driver, boardsPage.getCreateOptionButton()).click();
		webdriverutils.explicityWaitForButton(driver, boardsPage.getCreateBoardOptionButton()).click();
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
		TrelloAnothersBoardPage anothersBoardPage = new TrelloAnothersBoardPage(driver);
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getPlusButton()).click();
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getAnotherBoardsPageTitle())
				.sendKeys(excelUtility.stringCommonData("mySheet", 21, 1));
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getAnotherBoardsPageTitleCreateButton())
				.click();
		Thread.sleep(2000);
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getQspidersBoardButton()).click();
		TrelloCreatedBoardPage createdBoardPage = new TrelloCreatedBoardPage(driver);
		createdBoardPage.getAddAnotherListButton().click();
		createdBoardPage.getEnterListTitleTextField1().sendKeys(excelUtility.stringCommonData("mySheet", 14, 1));
		createdBoardPage.getAddListButton().click();
		createdBoardPage.getAddACardTestingButton1().click();
		createdBoardPage.getAddACardTestingButton1name().sendKeys(excelUtility.stringCommonData("mySheet", 16, 1));
		createdBoardPage.getAddACardTestingButton2().click();
		createdBoardPage.getAddACardTestingButton2name().sendKeys(excelUtility.stringCommonData("mySheet", 17, 1));
		createdBoardPage.getAddACardTestingButton3().click();
		createdBoardPage.getAddACardTestingButton3name().sendKeys(excelUtility.stringCommonData("mySheet", 18, 1));
		createdBoardPage.getAddACardTestingButton4().click();
		createdBoardPage.getAddACardTestingButton4name().sendKeys(excelUtility.stringCommonData("mySheet", 19, 1));
		createdBoardPage.getAddACardTestingButton5().click();
		createdBoardPage.getAddACardTestingButton5name().sendKeys(excelUtility.stringCommonData("mySheet", 20, 1));
		createdBoardPage.getAddACardTestingButton6name().click();

		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getTestingBoard3dots()).click();
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getMoveListbutton()).click();
		Thread.sleep(2000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", anothersBoardPage.getSelectBoardnameButton());
		Thread.sleep(2000);
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getPyspedersbutton()).click();
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getMoveButton()).click();
		TrelloCreatedBoardPage createdBoard = new TrelloCreatedBoardPage(driver);
		createdBoard.getShowMenuOption().click();
		createdBoard.getMoreOption().click();
		createdBoard.getCloseBoardOption().click();
		createdBoard.getCloseOption().click();
		createdBoard.getPermanentlyDeleteBoardOptioon().click();
		createdBoard.getDeleteOption().click();
		Thread.sleep(5000);
		webdriverutils.explicityWaitForButton(driver, anothersBoardPage.getpSpidersBoardButton()).click();
		Thread.sleep(5000);
		createdBoard.getShowMenuOption().click();
		createdBoard.getMoreOption().click();
		createdBoard.getCloseBoardOption().click();
		createdBoard.getCloseOption().click();
		createdBoard.getPermanentlyDeleteBoardOptioon().click();
		createdBoard.getDeleteOption().click();
	}

}
