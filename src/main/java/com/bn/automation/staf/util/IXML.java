package com.bn.automation.staf.util;

import java.util.List;

public interface IXML {

	//ITag getTag(String tagname);
	//List<ITag> getTags(String tagname);
	
	
	//IField getField(String fieldName);
	//ICookie getCookie(String cookieProperty);

	
	IDataContainer getDataContainer(String containerName);
	//IDataContainer getDataContainer(String containerName, String id);
	
	//List<IField> getFields();
	//List<ICookie> getCookies();
	//List<IDataContainer> getDataContainers();
}
