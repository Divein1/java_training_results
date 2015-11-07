package by.java.training.chp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author chp
 *
 */
public class DirectoryViewer {

	public static void main(String[] args) {
		String[] strArray = new String[]{"ABC","DEF","GHI"};
		String fileName = "LOG.txt";
		File curDir = new File(System.getProperty("user.dir"));


		fillFile(fileName, "SAMPLE TEXT", "TEXT SAMPLE");
		fillFile(fileName,strArray);
		
		readFile(fileName);
		dirView(curDir);
		
		delFile(fileName);
		dirView(curDir);

	}

	/**
	 * Views directory
	 * 
	 * [directory] file
	 */

	private static void dirView(File curDir) {

		File[] filesList = curDir.listFiles();
		System.out.println("\nCurrent directory:");

		for (File f : filesList) {
			if (f.isDirectory())
				System.err.println(f.getAbsoluteFile() + "\\");
		}

		for (File f : filesList) {
			if (f.isFile()) {
				System.out.println(f.getAbsoluteFile());
			}
		}

	}

	/**
	 * Creates file, and fills it with strings 
	 */

	private static void fillFile(String name) {
		File file = new File(name);
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			}
		} catch (IOException e) {
			System.out.println("Can't create file");
			e.printStackTrace();
		}

	}

	private static void fillFile(String name, String... msg) {
		fillFile(name);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(name, true));
			for (String string : msg) {
				bw.write(string);
				bw.write(System.lineSeparator());
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	

	/**
	 * Deletes file
	 */

	private static void delFile(String name) {

		Path path = Paths.get(name);
		try {
			Files.delete(path);
			System.out.format("\nFile %s deleted.%n", path);
		} catch (NoSuchFileException e) {
			System.err.format("%s: no such" + " file or directory%n", path);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.format("Can't delete file %s", path);
			e.printStackTrace();
		}

	}

	/**
	 * Prints file to console
	 */
	private static void readFile(String name) {
		try {
			Scanner in = new Scanner(new FileReader(name));
			System.out.println("\nFile contents:");
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
