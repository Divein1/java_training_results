package by.java.training.chp;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;

public class CrazyLogger {

	//Find string at list
	public static void findStr(String find, List<StringBuilder> c) {
		int count = 0;
		StringBuilder result = new StringBuilder("At fields: ");
		for (StringBuilder strb : c) {
			if (strb.indexOf(find) != -1) {
				count++;
				result.append("\n" + strb);
			}
		}
		System.out.println(String.format("String found %s times. %s", count, result));

	}
	//Find string at specific field
	public static void findStr(String find,int index , List<StringBuilder> c){
		if (c.get(index).indexOf(find)!=-1){
			System.out.println("\nYour string is a part of field ¹"+ index);
		}else 
			System.out.println("\nYour string is not found at field "+ index);
			
	}

	public static void main(String[] args) throws IOException {
		File file = new File("log.txt");
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY : hh-mm – ");
		ArrayList<StringBuilder> stringB = new ArrayList<StringBuilder>();

		// Fill list
		for (int i = 0; i < 20; i++) {
			StringBuilder logMessage = new StringBuilder();
			logMessage.append(dateFormat.format(currentDate));
			logMessage.append(String.format("THIS IS LOG MESSAGE %s", i));
			stringB.add(logMessage);
		}

		// Write to file from List
		FileUtils.writeLines(file, "UTF-8", stringB);

		// Pull strings from file
		List<String> readStr = new ArrayList<String>();
		readStr = FileUtils.readLines(file, "UTF-8");
		//System.out.println(readStr);

		// Find string
		findStr(" 1", stringB);
		findStr("20",19, stringB);
		

	}

}
