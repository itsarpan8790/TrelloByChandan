package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trello.genericutility.BaseClass;

public class TrelloCreatedBoardPage extends BaseClass {
	WebDriver driver;

	public TrelloCreatedBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Show menu']//span[@class='css-snhnyn']")
	private WebElement showMenuOption;

	@FindBy(xpath = "//a[@class='board-menu-navigation-item-link js-open-more']")
	private WebElement moreOption;

	@FindBy(xpath = "//a[contains(text(),'Close board…')]")
	private WebElement closeBoardOption;

	@FindBy(xpath = "//input[@value='Close']")
	private WebElement closeOption;

	@FindBy(xpath = "//button[normalize-space()='Permanently delete board']")
	private WebElement permanentlyDeleteBoardOptioon;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	private WebElement deleteOption;

	@FindBy(xpath = "//span[@class='placeholder']")
	private WebElement addAnotherListButton;

	@FindBy(xpath = "//input[@placeholder='Enter list title…']")
	private WebElement enterListTitleTextField1;

	@FindBy(xpath = "//input[@placeholder='Enter list title…']")
	private WebElement enterListTitleTextField2;

	@FindBy(xpath = "//input[@value='Add list']")
	private WebElement addListButton;

	@FindBy(xpath = "(//a[@aria-label='List actions'])[4]")
	private WebElement addedListTesting;

	@FindBy(xpath = "(//a[@aria-label='List actions'])[5]")
	private WebElement addedListPending;

	@FindBy(xpath = "//div[4]//div[1]//div[3]//a[1]")
	private WebElement addACardTestingButton1;

	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	private WebElement addACardTestingButton1name;

	@FindBy(xpath = "//input[@value='Add card']")
	private WebElement addACardTestingButton2;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	private WebElement addACardTestingButton2name;
  
	
	@FindBy(xpath = "//input[@value='Add card']")
	private WebElement addACardTestingButton3;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	private WebElement addACardTestingButton3name;
	
	@FindBy(xpath = "//input[@value='Add card']")
	private WebElement addACardTestingButton4;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	private WebElement addACardTestingButton4name;
	
	@FindBy(xpath = "//input[@value='Add card']")
	private WebElement addACardTestingButton5;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
	private WebElement addACardTestingButton5name;
	
	@FindBy(xpath = "//input[@value='Add card']")
	private WebElement addACardTestingButton6name;
	
	public WebElement getAddACardTestingButton6name() {
		return addACardTestingButton6name;
	}

	@FindBy(xpath = "(//span[@class='list-card-title js-card-name'])[1]")
	private WebElement addedCardManual;
	
	@FindBy(xpath = "(//a[@aria-label='List actions'])[4]")
	private WebElement testing3DotsOption;
	
	@FindBy(xpath = "//a[contains(text(),'Move all cards in this list…')]") 
	private WebElement moveAllCardsOption;
	
	@FindBy(xpath = "//a[normalize-space()='Pending']")
	private WebElement moveAllOptionPending;
	
	public WebElement getTesting3DotsOption() {
		return testing3DotsOption;
	}

	public WebElement getMoveAllCardsOption() {
		return moveAllCardsOption;
	}

	public WebElement getMoveAllOptionPending() {
		return moveAllOptionPending;
	}

	public WebElement getAddedCardManual() {
		return addedCardManual;
	}

	public WebElement getAddCardPending() {
		return addCardPending;
	}

	@FindBy(xpath = "(//div[@class='js-list list-wrapper list-wrapper-with-margins'])[5]")
	private WebElement addCardPending;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddACardTestingButton5() {
		return addACardTestingButton5;
	}

	public WebElement getAddACardTestingButton5name() {
		return addACardTestingButton5name;
	}

	public WebElement getAddACardTestingButton4() {
		return addACardTestingButton4;
	}

	public WebElement getAddACardTestingButton4name() {
		return addACardTestingButton4name;
	}

	public WebElement getAddACardTestingButton3() {
		return addACardTestingButton3;
	}

	public WebElement getAddACardTestingButton3name() {
		return addACardTestingButton3name;
	}

	public WebElement getAddACardTestingButton2() {
		return addACardTestingButton2;
	}

	public WebElement getAddACardTestingButton2name() {
		return addACardTestingButton2name;
	}

	
	public WebElement getAddACardTestingButton1() {
		return addACardTestingButton1;
	}

	public WebElement getAddACardTestingButton1name() {
		return addACardTestingButton1name;
	}

	public WebElement getAddedListTesting() {
		return addedListTesting;
	}

	public WebElement getAddedListPending() {
		return addedListPending;
	}

	public WebElement getShowMenuOption() {
		return showMenuOption;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getCloseBoardOption() {
		return closeBoardOption;
	}

	public WebElement getCloseOption() {
		return closeOption;
	}

	public WebElement getPermanentlyDeleteBoardOptioon() {
		return permanentlyDeleteBoardOptioon;
	}

	public WebElement getDeleteOption() {
		return deleteOption;
	}

	public WebElement getAddAnotherListButton() {
		return addAnotherListButton;
	}

	public WebElement getEnterListTitleTextField1() {
		return enterListTitleTextField1;
	}

	public WebElement getEnterListTitleTextField2() {
		return enterListTitleTextField2;
	}

	public WebElement getAddListButton() {
		return addListButton;
	}
}