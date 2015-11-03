package by.java.training.chp;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;

public class ConvertUTF {

	public static void main(String[] args) throws IOException {
		
		/**
		 * Creates byte input stream from a file
		 */
		
		FileInputStream inFile = null;
		try {
			inFile = new FileInputStream("UTF8Text.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found in dir " + System.getProperty("user.dir"));
			e.printStackTrace();
		}

		/**
		 * Copies stream to string.
		 */

		String fileContent = null;
		try {
			fileContent = IOUtils.toString(inFile, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		inFile.close();

		/**
		 * Writes string to new file in UTF-16
		 */

		BufferedWriter bw = null;
		bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("UTF16TextOut.txt"), "UTF-16"));
		bw.write(fileContent);
		bw.close();

		/**
		 * Creates byte input stream from a new UTF-16 file and prints it to
		 * console.
		 */

		FileInputStream inNewFile = null;
		try {
			inNewFile = new FileInputStream("UTF16TextOut.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found in dir " + System.getProperty("user.dir"));
			e.printStackTrace();
		}
		System.out.println(IOUtils.toString(inNewFile, "UTF-16"));
		inNewFile.close();
	}

}
