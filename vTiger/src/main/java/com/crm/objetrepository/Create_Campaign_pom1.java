package com.crm.objetrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaign_pom1 {
	public Create_Campaign_pom1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement CampaignLink;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaign;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNameTextBox;

	
	public WebElement getCampaignNameTextBox() {
		return campaignNameTextBox;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}

	
	public WebElement getCampaignLink() {
		return CampaignLink;
	}
	
	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	
	public void moreLink(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(moreLink).perform();;
		
	}
	//business logic for Campaign Link
	public void clickCampaignLink()
	{
		CampaignLink.click();
	}
	//business logic for Create Campaign Link
	public void clickCreateCampaign()
	{
		createCampaign.click();
	}
	
	public void NameTextBox(String name)
	{
		campaignNameTextBox.sendKeys(name);
	}
}
