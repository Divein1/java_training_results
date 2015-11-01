package by.java.training.chp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class FindReservedCh {

	public static void main(String args[]) throws IOException {
		
		/**
		 * Creates character stream reader from a file;
		 */

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("NuclearSubmarine.java"));
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
		}

		/**
		 * Extracts content from BufferedReader to string.
		 */

		String fileContent = null;
		fileContent = IOUtils.toString(br);
		br.close();

		/**
		 * Imports java keywords from file to List. It will be used to find
		 * keywords by foreach.
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
		 * Creates Writer and checks main string for keywords. Then writes
		 * matching keywords to file.
		 */
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		for (String string : readStr) {
			int countMatches = StringUtils.countMatches(fileContent, string);
			if (countMatches > 0) {
				string += " " + countMatches;
				bw.write(string);
				bw.write(System.getProperty("line.separator"));
			}
		}
		bw.close();
	}

}
