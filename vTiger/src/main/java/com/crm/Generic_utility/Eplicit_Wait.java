package com.crm.Generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Eplicit_Wait {
	public static WebDriver driver;
	public void  ExpicitWait(String Word)
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlContains(Word));
	}

}
