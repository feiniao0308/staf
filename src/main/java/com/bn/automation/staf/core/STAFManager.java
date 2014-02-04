package com.bn.automation.staf.core;

import com.bn.automation.staf.helpers.STAFConstant;

public class STAFManager {

	private static STAFDriver stafInstance = null;

	public STAFManager() {
		createStafInstance();
	}

	protected void createStafInstance() {

		if (stafInstance != null)
			return;
		try {
			if (stafInstance == null) {
				stafInstance = STAFDriver.getInstance(STAFConstant.FIREFOX);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public STAFDriver getInstance(){
		return stafInstance;
	}

}
