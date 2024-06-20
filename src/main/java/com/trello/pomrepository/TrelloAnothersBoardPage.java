package com.trello.pomrepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloAnothersBoardPage {
	WebDriver driver;

	public TrelloAnothersBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusButton() {
		return plusButton;
	}

	public WebElement getAnotherBoardsPageTitle() {
		return anotherBoardsPageTitle;
	}

	public WebElement getAnotherBoardsPageTitleCreateButton() {
		return anotherBoardsPageTitleCreateButton;
	}

	@FindBy(xpath = "//button[@aria-label='Add board']//span[@class='css-snhnyn']")
	private WebElement plusButton;

	@FindBy(xpath = "//input[@class='nch-textfield__input lsOhPsHuxEMYEb lsOhPsHuxEMYEb VkPAAkbpkKnPst']")
	private WebElement anotherBoardsPageTitle;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement anotherBoardsPageTitleCreateButton;

	@FindBy(xpath = "//a[normalize-space()='Qspiders']")
	private WebElement qspidersBoardButton;

	@FindBy(xpath = "(//a[@aria-label='List actions'])[4]")
	private WebElement testingBoard3dots;

	@FindBy(xpath = "(//a[contains(text(),'Move list…')])[1]")
	private WebElement moveListbutton;

	@FindBy(xpath = "//select[@class='js-select-board']")
	private WebElement selectBoardnameButton;

	@FindBy(xpath = "//select[@class='js-select-board']//option")
	private WebElement pyspedersbutton;

	@FindBy(xpath = "(//input[@value='Move'])[1]")
	private WebElement moveButton;

	@FindBy(xpath = "(//div[@class='board-tile-details is-badged'])[1]")
	private WebElement pSpidersBoardButton;

	public WebElement getpSpidersBoardButton() {
		return pSpidersBoardButton;
	}

	public WebElement getMoveButton() {
		return moveButton;
	}

	public WebElement getPyspedersbutton() {
		return pyspedersbutton;
	}

	public WebElement getTestingBoard3dots() {
		return testingBoard3dots;
	}

	public WebElement getMoveListbutton() {
		return moveListbutton;
	}

	public WebElement getSelectBoardnameButton() {
		return selectBoardnameButton;
	}

	public WebElement getQspidersBoardButton() {
		return qspidersBoardButton;
	}
}
