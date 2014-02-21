package com.bn.automation.staf.core;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;

import com.bn.automation.staf.helpers.Verify;

public class STAFCookie {

	private static final Logger logger = LogManager.getLogger();
	private Verify verify = new Verify();
	Set<Cookie> cookies = STAFDriver.getiDriver().manage().getCookies();

	public void verifyName(List<String> verifyCookie) {
		
		for(String entry:verifyCookie){
			verifyName(entry);
		}

		/*for (Map.Entry<String, String> entry : verifyCookie.entrySet()) {
			String s1 = entry.getKey();
			String s2 = entry.getValue();
			System.out.println(s1);
			System.out.println(s2);

			if (s1.equals("NAME")) {
				verifyName(s2);
			}

		}*/
	}

	public void verifyDomain(List<String> verifyCookie) {
		
		for(String entry:verifyCookie){
			verifyDomain(entry);
		}

		/*for (Map.Entry<String, String> entry : verifyCookie.entrySet()) {
			String s1 = entry.getKey();
			String s2 = entry.getValue();
			System.out.println(s1);
			System.out.println(s2);

			if (s1.equals("DOMAIN")) {
				verifyDomain(s2);
			}
		}*/

	}

	public void verifyName(String cookieName) {

		int nameCount = 0;
		Iterator<Cookie> itr = cookies.iterator();

		while (itr.hasNext()) {
			Cookie c = itr.next();
			if (c.getName().equals(cookieName)) {
				nameCount++;
			}

		}
		if (nameCount > 0) {
			logger.info("Verify that cookie named->" + cookieName
					+ " is set in this page");
			verify.verifyTrue(true, "Cookie Named->" + cookieName
					+ " is not set in this page");
		}

	}

	public void verifyDomain(String cookieDomain) {
		int domainCount = 0;
		Iterator<Cookie> itr = cookies.iterator();

		while (itr.hasNext()) {
			Cookie c = itr.next();
			if (c.getDomain().equals(cookieDomain)) {
				domainCount++;
			}

			/*logger.trace("Cookie Name: " + c.getName() + "\nCookie Domain: "
					+ c.getDomain() + "\nCookie Value: " + c.getValue()
					+ "\nPath: " + c.getPath() + "\nExpiry Date: "
					+ c.getExpiry() + "\nSecure: " + c.isSecure());*/
		}
		if (domainCount > 0) {
			logger.info("Verify that cookie domain->" + cookieDomain
					+ " is set in this page");
			verify.verifyTrue(true, "Cookie Domain->" + cookieDomain
					+ " is not set in this page");
		}
	}

}
