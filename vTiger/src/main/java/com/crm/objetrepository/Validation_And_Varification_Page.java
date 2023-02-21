package com.crm.objetrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation_And_Varification_Page {
	
	public Validation_And_Varification_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationCreatedHeaderText;

	//getter method of Organization
	public WebElement getOrganizationCreatedHeaderText() 
	{
		return organizationCreatedHeaderText;
	}
	
	//business logic for Organization Validation
	
	public void organizationValidation(WebDriver driver,String data)
	{
		String actualData = organizationCreatedHeaderText.getText();
		if(actualData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement campaignCreatedHeaderText;

	//getter method Campaign validation
	public WebElement getCampaignCreatedHeaderText()
	{
		return campaignCreatedHeaderText;
	}
	
	public void campaignValidation(WebDriver driver,String data)
	{
		String actualData = campaignCreatedHeaderText.getText();
		if(actualData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement campaignWithProductHeaderText;

	//getter method for create Campaign With Product Module
	public WebElement getCampaignWithProductHeaderText()
	{
		return campaignWithProductHeaderText;
	}
	
	//business logic for Create Campaign With Product Module
	public void campaignProductValidation(WebDriver driver, String data)
	{
		String actualData = campaignWithProductHeaderText.getText();
		if(actualData.contains(data))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
	
}
