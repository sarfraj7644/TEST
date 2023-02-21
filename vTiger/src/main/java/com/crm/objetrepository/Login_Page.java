package com.crm.objetrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
		
	//Initialization
		public Login_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(name="user_name")
		private WebElement userNameTextFeild;
		
		@FindBy(name="user_password")
		private WebElement passWordTextFeild;
		
		@FindBy(id="submitButton")
		private WebElement submitbutton;

		//getter methods
		public WebElement getUserNameTextFeild() {
			return userNameTextFeild;
		}

		
		public WebElement getPassWordTextFeild() {
			return passWordTextFeild;
		}

		
		public WebElement getSubmitbutton() {
			return submitbutton;
		}
		
		/**
		 * this method is used to login the app
		 * @author sarfraj
		 */
		public void login(String userName, String passWord)
		{
			userNameTextFeild.sendKeys(userName);
			passWordTextFeild.sendKeys(passWord);
			submitbutton.click();
		}
		
}
