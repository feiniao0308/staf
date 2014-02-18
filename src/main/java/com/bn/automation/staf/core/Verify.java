package com.bn.automation.staf.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Verify {
	
	private static final Logger logger = LogManager.getLogger();
	
	public void verifyTrue(boolean condition, String message){
		try {
	        Assert.assertTrue(condition, message);
	        logger.info("Expected value: true" + " Actual value: " + condition + " - PASSED ", true);
	    } catch (Throwable e) {
	    	logger.info("Expected value: true" + " Actual value: " + condition + " - FAILED " + message, true);
	        //addVerificationFailure(e);
	    }
		
	}
	
	
	public void verifyFalse(boolean condition, String message){
		try {
	        Assert.assertFalse(condition, message);
	        logger.info("Expected value: false" + " Actual value: " + condition + " - PASSED ", true);
	    } catch (Throwable e) {
	    	logger.info("Expected value: false" + " Actual value: " + condition + " - FAILED " + message, true);
	        //addVerificationFailure(e);
	    }
		
	}
	
	public void verifyEquals(String actualValue, String expectedValue, String message){
		try {
	        Assert.assertEquals(actualValue, expectedValue, message);
	        logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - PASSED ", true);
	    } catch (Throwable e) {
	    	logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - FAILED " + message, true);
	        //addVerificationFailure(e);
	    }
	}
	
	public void verifyEquals(String actualValue, String expectedValue){
		try {
	        Assert.assertEquals(actualValue, expectedValue);
	        logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - PASSED ", true);
	    } catch (Throwable e) {
	    	logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - FAILED ", true);
	        //addVerificationFailure(e);
	    }
	}
	
	public void verifyContains(String actualValue, String expectedValue){
		try {
	        Assert.assertTrue(actualValue.contains(expectedValue));
	        logger.info("Expected value->" + expectedValue + " present in Actual value->" + actualValue + " - PASSED ", true);
	    } catch (Throwable e) {
	    	logger.info("Expected value->" + expectedValue + " present in Actual value->" + actualValue + " - FAILED ", true);
	        //addVerificationFailure(e);
	    }
	}
	
	

}
