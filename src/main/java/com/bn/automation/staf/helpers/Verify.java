package com.bn.automation.staf.helpers;


import com.bn.automation.staf.widget.Label;
import com.bn.automation.staf.widget.Widgets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Map;

public class Verify {

    private static final Logger logger = LogManager.getLogger();

    public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
            logger.info("Expected value: true" + " Actual value: " + condition + " - PASSED ", true);
        } catch (Throwable e) {
            logger.info("Expected value: true" + " Actual value: " + condition + " - FAILED " + message, true);
            //addVerificationFailure(e);
        }

    }


    public void verifyFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
            logger.info("Expected value: false" + " Actual value: " + condition + " - PASSED ", true);
        } catch (Throwable e) {
            logger.info("Expected value: false" + " Actual value: " + condition + " - FAILED " + message, true);
            //addVerificationFailure(e);
        }

    }

    public void verifyEquals(String actualValue, String expectedValue, String message) {
        try {
            Assert.assertEquals(actualValue, expectedValue, message);
            logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - PASSED ", true);
        } catch (Throwable e) {
            logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - FAILED " + message, true);
            //addVerificationFailure(e);
        }
    }

    public void verifyEquals(String actualValue, String expectedValue) {
        try {
            Assert.assertEquals(actualValue, expectedValue);
            logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - PASSED ", true);
        } catch (Throwable e) {
            logger.info("Expected value->" + expectedValue + " Actual value->" + actualValue + " - FAILED ", true);
            //addVerificationFailure(e);
        }
    }

    public void verifyContains(String actualValue, String expectedValue) {
        try {
            Assert.assertTrue(actualValue.contains(expectedValue));
            logger.info("Expected value->" + expectedValue + " present in Actual value->" + actualValue + " - PASSED ", true);
        } catch (Throwable e) {
            logger.info("Expected value->" + expectedValue + " present in Actual value->" + actualValue + " - FAILED ", true);
            //addVerificationFailure(e);
        }
    }

    public void verifyMap(Map<String, String> dataMap, Object so) {

        Class<?> ScreenClazz = so.getClass();
        if (ScreenClazz.getAnnotation(Widgets.class) != null) {
            Class<?>[] ScreenClazzInners = ScreenClazz.getDeclaredClasses();
            for (Class<?> ScreenClazzInner : ScreenClazzInners) {
                if (ScreenClazzInner.getAnnotation(Widgets.class) != null) {
                    for (Map.Entry<String, String> entry : dataMap
                            .entrySet()) {
                        logger.trace("Data map key->" + entry.getKey());
                        logger.trace("Data map value->" + entry.getValue());
                        String verifyName;
                        String verifyType;
                        String[] verifyProperty;
                        String expectedValue;
                        Label l = null;

                        verifyProperty = new StringOperation().splitHashTag(entry.getKey());
                        verifyName = verifyProperty[0];
                        verifyType = (verifyProperty.length == 2) ? verifyProperty[1] : STAFConstant.GET_TEXT;
                        expectedValue = entry.getValue();
                        /*if (verifyProperty.length == 2) {
                            verifyType = verifyProperty[1];
                        } else {
                            verifyType = STAFConstant.GET_TEXT;
                            //System.out.println("verifyName = " + verifyName);
                        }*/
                        logger.trace("verifyName->" + verifyName);
                        logger.trace("verifyType->" + verifyType);
                        logger.trace("expectedValue->" + expectedValue);


                        try {
                            l = (Label) ScreenClazzInner.getDeclaredField(verifyName).get(null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }

                        switch (verifyType) {
                            case STAFConstant.GET_TEXT:
                                logger.trace("Verification type->getText()");
                                verifyEquals(l.getText(), expectedValue);
                                break;
                            case STAFConstant.IS_DISPLAYED:
                                logger.trace("Verification type->isDisplayed()");
                                if (Boolean.valueOf(expectedValue)) {
                                    verifyTrue(l.isDisplayed(), "Element not displayed");
                                } else {
                                    verifyFalse(l.isDisplayed(), "Element displayed");
                                }
                                break;
                            case STAFConstant.IS_ENABLED:
                                logger.trace("Verification type->isEnabled()");
                                if (Boolean.valueOf(expectedValue)) {
                                    verifyTrue(l.isEnabled(), "Element not enabled");
                                } else {
                                    verifyFalse(l.isEnabled(), "Element enabled");
                                }
                                //verifyTrue(l.isEnabled(),"Element not enabled");
                                break;
                            case STAFConstant.IS_PRESENT:
                                logger.trace("Verification type->isPresent()");
                                if (Boolean.valueOf(expectedValue)) {
                                    verifyTrue(l.isPresent(), "Element not present1");
                                } else {
                                    verifyFalse(l.isPresent(), "Element present");
                                }
                                //verifyTrue(l.isPresent(),"Element not present");
                                //verifyTrue(l.findElement(l.getByElement()) != null, "Element not present");
                                break;
                            case STAFConstant.IS_SELECTED:
                                logger.trace("Verification type->isSelected()");
                                if (Boolean.valueOf(expectedValue)) {
                                    verifyTrue(l.isSelected(), "Element not selected");
                                } else {
                                    verifyFalse(l.isSelected(), "Element selected");
                                }
                                //verifyTrue(l.isSelected(),"Element not selected");
                                break;
                            case STAFConstant.COOKIE_NAME:
                                logger.trace("Verification type->cookie name");
                                //TODO method for cookie verify
                                System.out.println("inside cookie name");
                                break;
                            case STAFConstant.COOKIE_DOMAIN:
                                logger.trace("Verification type->cookie domain");
                                //TODO method for cookie verify
                                System.out.println("inside cookie domain");
                                break;
                            default:
                                logger.trace("Verification type->getAttribute()");
                                verifyEquals(l.getAttribute(verifyType), expectedValue);


                        }


                        // System.out.println(l.getText());
                        // new Verify().verifyEquals(l.getText(), entry.getValue());


                    }
                }
            }

        }
    }


}
