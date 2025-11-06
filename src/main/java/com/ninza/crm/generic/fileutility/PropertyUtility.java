package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Kishor Kulkarni
 * this class contains the methods used to fetch the data from Property File
 */
public class PropertyUtility {
	
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties ");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
		
	}

}
