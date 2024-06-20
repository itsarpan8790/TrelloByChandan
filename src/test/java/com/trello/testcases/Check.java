package com.trello.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.trello.genericutility.BaseClass;
import com.trello.pomrepository.TrelloBoardsPage;
import com.trello.pomrepository.TrelloCreatedBoardPage;
import com.trello.pomrepository.TrelloHomePage;
import com.trello.pomrepository.TrelloLoginIntoContinuePage;
import com.trello.pomrepository.TrelloLoginpage;

public class Check extends BaseClass{
	
	@BeforeMethod
	public  void  loginToTrello() throws Throwable {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		webdriverutils.implicityWait(driver);
		driver.get("https://trello.com/");
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		TrelloLoginpage loginPage=new TrelloLoginpage(driver);
		loginPage.getLogintextField().sendKeys("manikrishna4849@gmail.com");
		loginPage.getContinueButton().submit();
		TrelloLoginIntoContinuePage loginToContinue=new TrelloLoginIntoContinuePage(driver);
		Thread.sleep(1000);
		loginToContinue.getPasswordTextField().sendKeys("Mani@4849");	
		loginToContinue.getClickOnLoginButton().submit();
	}
//	@DataProvider
	public Object[][] boardTitle() {
		Object[][] obj = new Object[2][1];
		obj[0][0]="Qspiders";
		obj[1][0]="PySpiders";
//		System.out.println(obj);
		return obj;
		
	}
	@Test( priority = 1)
	public void createBoard() throws Throwable {
		webdriverutils.implicityWait(driver);
		TrelloBoardsPage boardsPage=new TrelloBoardsPage(driver);
		boardsPage.getCreateOptionButton().click();
		boardsPage.getCreateBoardOptionButton().click();
		boardsPage.getBoardTitleTextField().sendKeys("Qspiders");
		Thread.sleep(2000);
		boardsPage.getCreateButton().click();
//		boardsPage.getBackToHome().click();
		Thread.sleep(3000);
		boardsPage.getCreateOptionButton().click();
		boardsPage.getCreateBoardOptionButton().click();
		Thread.sleep(2000);
		boardsPage.getBoardTitleTextField().sendKeys("Pyspiders");
		Thread.sleep(2000);
		boardsPage.getCreateButton().click();
//		boardsPage.getBackToHome().click();
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	@Parameters("createdBoardTitle")
	public  void  createListAndAddCardInBoard(String createdBoardTitle) throws Throwable, Throwable {
		webdriverutils.implicityWait(driver);
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		for (WebElement board : boardsPage.getBoards()) {
			if (board.getAttribute("title").equals(createdBoardTitle)) {
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
			}
		}
	}
	@Test(enabled =  false)
	public void moveListToOtherBoard() {
		webdriverutils.implicityWait(driver);
//		new Trello
	}
}
