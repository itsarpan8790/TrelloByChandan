package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginIntoContinuePage {
	WebDriver driver;

	public TrelloLoginIntoContinuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//button[@id='login-submit']//span[@class='css-178ag6o']")
	private WebElement clickOnLoginButton;

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getClickOnLoginButton() {
		return clickOnLoginButton;
	}

}
