package com.trello.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Open member menu']//span[@title='Mani Chowdry (manichowdry)']")
	private WebElement profileButton;

	@FindBy(xpath = "//span[normalize-space()='Log out']")
	private WebElement logoutOption;

	@FindBy(xpath = "//button[@aria-label='Create board or Workspace']") 
	private WebElement createOptionButton;

	@FindBy(xpath = "//button[@data-testid='header-create-board-button']")
	private WebElement createBoardOptionButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement boardTitleTextField;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement createButton;

	@FindBy(xpath = "//a[@aria-label='Back to home']")
	private WebElement backToHome;
	
	@FindBy(css = "div[class='board-tile-details-name']")
	private List<WebElement> boards;
	
	public List<WebElement> getBoards() {
		return boards;
	}
	public WebElement getBackToHome() {
		return backToHome;
	}
	public WebElement getProfileButton() {
		return profileButton;
	}

	public WebElement getLogoutOption() {
		return logoutOption;
	}

	public WebElement getCreateOptionButton() {
		return createOptionButton;
	}

	public WebElement getCreateBoardOptionButton() {
		return createBoardOptionButton;
	}

	public WebElement getBoardTitleTextField() {
		return boardTitleTextField;
	}

	public WebElement getCreateButton() {
		return createButton;
	}
}