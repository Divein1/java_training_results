package by.java.training.chp;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PropToMap {

	public static Map<String, String> loadPropMap(String fileName) {

		ResourceBundle prop = ResourceBundle.getBundle(fileName);
		Map<String, String> mapOfProperties = new HashMap<String, String>();

		Enumeration<String> e = prop.getKeys();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			String value = prop.getString(key);
			mapOfProperties.put(System.getProperty("line.separator") + key, value);
		}
		return mapOfProperties;

	}

	public static void main(String[] args) {
		System.out.println("Prop file contents:");
		System.out.println(loadPropMap("by.java.training.chp.questions").toString());

	}

	
}
