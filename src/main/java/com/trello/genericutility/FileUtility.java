package com.trello.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String readCommondata(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/trello.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;

	}
}
