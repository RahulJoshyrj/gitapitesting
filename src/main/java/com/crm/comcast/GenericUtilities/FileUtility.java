package com.crm.comcast.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author RJ
 *
 */
public class FileUtility {
	/**
	 * method to handle property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPrpertyValue(String key) throws IOException {
		FileInputStream fileinputstream=new FileInputStream(IConstants.filepath);
		Properties properties=new Properties();
		properties.load(fileinputstream);
		String value=properties.getProperty(key);
		return value;
	}

}
