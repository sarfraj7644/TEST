package com.crm.objetrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Generic_utility.WebDriver_Utility;

public class Home_Page {
	
	//Initialization
			public Home_Page(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
		
		@FindBy(linkText="Organizations")
		private WebElement orgaizationLink;
		
		@FindBy(xpath="//a[text()='Products']")
		private WebElement productLink;
		
		@FindBy(xpath="//img[@title='Create Product...']")
		private WebElement createProductLink;

		@FindBy(xpath="//a[text()='More']")
		private WebElement moreLink;
		
		@FindBy(name="Campaigns")
		private WebElement campaignsLink;
		
		@FindBy(xpath="//img[@title='Create Campaign...']")
		private WebElement createCampaignLink;
		
		@FindBy(xpath="//a[text()='Contacts']")
		private WebElement contactLink;
		
		 
		

		//getter method
		public WebElement getOrgaizationLink() {
			return orgaizationLink;
		}
		
		
		public WebElement getProductLink() {
			return productLink;
		}
		
		
		public WebElement getCreateProductLink() {
			return createProductLink;
		}
		
		
		public WebElement getMoreLink() {
			return moreLink;
		}

		
		public WebElement getCampaignsLink() {
			return campaignsLink;
		}
		
		public WebElement getCreateCampaignLink() {
			return createCampaignLink;
		}
		

		public WebElement getContactLink() {
			return contactLink;
		}

		
		
		//below lines is written for logout to the application
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement signoutImg;
		
		@FindBy(xpath="(//a[text()='Sign Out'])")
		private WebElement signoutLink;
		
		
		
		//getter method
		
		public WebElement getSignoutImg() {
			return signoutImg;
		}

		public WebElement getSignoutLink() {
			return signoutLink;
		}
		
		
		//business logic for organization
		public void clickOrganizations()
		{
			orgaizationLink.click();
		}
		
		
		//business logic for Product
		public void clickProduct()
		{
			productLink.click();
		}
		
		
		//business logic for Create Product
		public void clickCreateProductLink()
		{
			createProductLink.click();
		}
		
		
		//business logic for Campaigns
		public void clickCampaigns()
		{
			campaignsLink.click();
		}
		
		
		//business logic for Create campaigns
		public void clickCreateCampaignLink()
		{
			createCampaignLink.click();
		}
		
		
		//business logic for More
		public void moreLink(WebDriver driver)
		{
			WebDriver_Utility web=new WebDriver_Utility();
			web.moveToElement(driver,moreLink );
		}
		
		
		//business logic for organization
		public void signoutLink(WebDriver driver)
		{
			Actions a=new Actions(driver);
			a.moveToElement(signoutImg).perform();
			signoutLink.click();
		}
		
		
		//business logic for Contact Link
		public void clickContactLink()
		{
			contactLink.click();
		}
		
	
}
