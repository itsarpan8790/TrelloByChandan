package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginpage {
	WebDriver driver;

	public TrelloLoginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user']")
	private WebElement logintextField;  //

	@FindBy(id = "login")
	private WebElement continueButton;

	public WebElement getLogintextField() {
		return logintextField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

}
