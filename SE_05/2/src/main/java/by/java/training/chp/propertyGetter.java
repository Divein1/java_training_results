package by.java.training.chp;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.Enumeration;
import java.util.Properties;

public class propertyGetter{

	public static String loadProp(String fileName, String key) {
		FileInputStream fis;
		Properties property = new Properties();

		try {
			fis = new FileInputStream(fileName);
			property.load(fis);

		} catch (IOException e) {
			System.err.format("Can't find file %s", fileName);
			e.printStackTrace();
		}

		if (property.getProperty(key) != null) {

			return property.getProperty(key);

		} else {
			throw new InvalidParameterException("No such key in file " + fileName);

		}

	}

	public static StringBuilder loadAllProp(String fileName) {

		FileInputStream fis;
		Properties property = new Properties();

		try {
			fis = new FileInputStream(fileName);
			property.load(fis);

		} catch (IOException e) {
			System.err.format("Can't find file %s", fileName);
			e.printStackTrace();
		}

		StringBuilder result = new StringBuilder();
		Enumeration<?> e = property.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			result.append(key + " ");
			result.append(property.getProperty(key));
			result.append(System.getProperty("line.separator"));
		}
		return result;
	}

}