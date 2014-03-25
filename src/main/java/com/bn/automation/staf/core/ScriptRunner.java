package com.bn.automation.staf.core;

import com.bn.automation.staf.anno.AfterMethod;
import com.bn.automation.staf.anno.BeforeMethod;
import com.bn.automation.staf.anno.Test;
import com.bn.automation.staf.helpers.STAFConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

class ScriptRunner {

    private static final Logger logger = LogManager
            .getLogger(ScriptRunner.class);
    private Method beforeMethod;
    private Method afterMethod;
    private boolean isBeforePresent = false;
    private boolean isAfterPresent = false;
    private boolean isTestPresent = false;

    public boolean isBeforePresent() {
        return isBeforePresent;
    }

    public void setBeforePresent(boolean isBeforePresent) {
        this.isBeforePresent = isBeforePresent;
    }

    public boolean isAfterPresent() {
        return isAfterPresent;
    }

    public void setAfterPresent(boolean isAfterPresent) {
        this.isAfterPresent = isAfterPresent;
    }

    public boolean isTestPresent() {
        return isTestPresent;
    }

    public void setTestPresent(boolean isTestPresent) {
        this.isTestPresent = isTestPresent;
    }

    public Method getBeforeMethod() {
        return beforeMethod;
    }

    public void setBeforeMethod(Method beforeMethod) {
        this.beforeMethod = beforeMethod;
    }

    public Method getAfterMethod() {
        return afterMethod;
    }

    public void setAfterMethod(Method afterMethod) {
        this.afterMethod = afterMethod;
    }

    public void initiateScript(Class<?> clazz) {
        System.out.println(clazz.getCanonicalName());
        System.out.println("**************INITIALIZING SCRIPT***************");
        Object obz = null;
        try {
            obz = clazz.newInstance();

            invokeTestMethod(obz);

			/*
             * for (Method method : methods) { if
			 * (method.getAnnotation(Test.class) != null) { try {
			 * System.out.println
			 * ("****************INVOKING TEST METHOD****************");
			 * method.invoke(obz); } catch (Exception e) { e.printStackTrace();
			 * } } }
			 */
        } catch (InstantiationException | IllegalAccessException e1) {
            e1.printStackTrace();
        }

    }

    private List<Method> getTestMethods(Object o) {
        List<Method> testMethods = new LinkedList<Method>();

        Method[] methods = o.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                setTestPresent(true);
                try {
                    testMethods.add(method);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (method.getAnnotation(BeforeMethod.class) != null) {
                setBeforePresent(true);
                setBeforeMethod(method);
            } else if (method.getAnnotation(AfterMethod.class) != null) {
                setAfterPresent(true);
                setAfterMethod(method);
            } else {
                logger.trace("This method not either of these types : Test, BeforeMethod & AfterMethod");
            }
        }

        logger.info("Number of test methods in class : "
                + o.getClass().getCanonicalName() + " is " + testMethods.size());
        return testMethods;

    }

    private void invokeTestMethod(Object obz) {
        int passed = 0;
        int failed = 0;
        int skipped = 0;

        for (Method method : getTestMethods(obz)) {
            long startTime = System.currentTimeMillis();
            long endTime;
            if (method.getAnnotation(Test.class) != null) {
                boolean enabled = method.getAnnotation(Test.class).enabled();
                int[] id = method.getAnnotation(Test.class).id();
                if (enabled) {

                    for (int currentID : id) {
                        System.out
                                .println("======================" + currentID);
                        try {
                            STAFRunner.setTestID(currentID);
                            if (isBeforePresent()) {
                                logger.info(STAFConstant.DASH);
                                logger.info("BEFORE METHOD : " + getBeforeMethod().getName());
                                logger.info(STAFConstant.DASH);
                                getBeforeMethod().invoke(obz);
                            }
                            if (isTestPresent()) {
                                logger.info(STAFConstant.DASH);
                                logger.info("TEST METHOD : " + method.getName());
                                logger.info(STAFConstant.DASH);
                                method.invoke(obz);
                                endTime = System.currentTimeMillis();
                                new STAFLogger().logResult(STAFRunner.getInfo().get("result_log").toString(), Integer.toString(currentID), method.getDeclaringClass().toString(), method.getName().toString(), "PASSED", Long.toString(endTime - startTime));
                                //new STAFLogger().logEvent(STAFRunner.getInfo().get(STAFConstant.XML_LOG_PATH).toString(),"hello","world","pass","1.0s");
                                passed++;
                            }
                            if (isAfterPresent()) {
                                logger.info(STAFConstant.DASH);
                                logger.info("AFTER METHOD : " + getAfterMethod().getName());
                                logger.info(STAFConstant.DASH);
                                getAfterMethod().invoke(obz);
                            }


                        } catch (Exception e) {
                            logger.error("Failed Test Method: " + method.getName() + "\n" + e.getCause());
                            endTime = System.currentTimeMillis();
                            new STAFLogger().logResult(STAFRunner.getInfo().get("result_log").toString(), Integer.toString(currentID), method.getDeclaringClass().toString(), method.getName().toString(), "FAILED", Long.toString(endTime - startTime));
                            e.printStackTrace();
                            failed++;
                        }
                    }
                } else {
                    skipped += id.length;
                }

            }

        }
        logger.info("Passed: " + passed + " Failed: " + failed + " Skipped: "
                + skipped);
    }


}
