package com.crm.Generic_utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * its used to generate the random number with in the range of 1000
	 * @
	 * @return ranDom
	 * @author sarfraj
	 */
	
	public int getRandomValue() {
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}
