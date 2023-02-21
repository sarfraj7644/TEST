package com.crm.campaign;

import org.testng.annotations.Test;

import com.crm.Generic_utility.Base_Class;
import com.crm.Generic_utility.Java_Utility;
import com.crm.objetrepository.Create_Campaign_pom1;

public class Create_Campaign extends Base_Class  {
	@Test 
	public void Create_Campaign_Test() throws Throwable {
//		Excel_Utility excel=new Excel_Utility();
//		Java_Utility jav=new Java_Utility();
//		int ranDom = jav.getRandomValue();
		
		
		Create_Campaign_pom1 camp=new Create_Campaign_pom1(driver);
		camp.moreLink(driver);
		camp.clickCampaignLink();
		camp.clickCreateCampaign();
		//camp.NameTextBox("sarfraj ah");
	}
}
