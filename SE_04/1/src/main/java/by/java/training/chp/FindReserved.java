package by.java.training.chp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class FindReserved {

	public static void main(String args[]) throws IOException {
		FileInputStream inFile = null;

		/**
		 * Creates byte input stream from a file
		 */
		try {
			inFile = new FileInputStream("NuclearSubmarine.java");
		} catch (FileNotFoundException e) {
			System.out.println("File not found in dir " + System.getProperty("user.dir"));
			e.printStackTrace();
		}

		/**
		 * Copies stream to string.
		 */

		String fileContent = null;
		fileContent = IOUtils.toString(inFile, "cp1251");
		inFile.close();

		/**
		 * Imports java keywords from file to ArrayList
		 * It will be used to find keywords by foreach.
		 */

		File file = new File("Keywords.txt");
		List<String> readStr = new ArrayList<String>();
		try {
			readStr = FileUtils.readLines(file, "cp1251");
		} catch (IOException e) {
			System.out.println("Keywords file not found");
			e.printStackTrace();
		}

		/**
		 * Creates output stream and checks main string for keywords.
		 * Then writes matching keywords as bytes to output stream.
		 */

		FileOutputStream outFile = null;
			outFile = new FileOutputStream("out.txt");
		for (String string : readStr) {
			int countMatches = StringUtils.countMatches(fileContent, string);
			if (countMatches > 0) {
				string += " " + countMatches;
				byte[] bytes = string.getBytes();
					outFile.write(bytes);
					outFile.write(System.getProperty("line.separator").getBytes());
			}

		}
		outFile.close();

	}

}
