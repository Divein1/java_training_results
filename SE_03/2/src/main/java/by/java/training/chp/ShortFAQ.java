package by.java.training.chp;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShortFAQ {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Locale locale;
		Locale localeRu = new Locale("ru", "RU");
		Locale localeEn = new Locale("en", "US");

		System.out.println("Input 1 for locale en_En or 2 for locale ru_RU");

		while (!scanner.hasNextInt()) {
			System.out.println("Input correct number to proceed");
			scanner.next();
		}
		switch (scanner.nextInt()) {
		case 1:
			locale = localeEn;
			break;
		case 2:
			locale = localeRu;
			break;
		default:
			locale = localeEn;
			break;
		}

		ResourceBundle questions = ResourceBundle.getBundle("by.java.training.chp.questions", locale);
		Enumeration<String> keys = questions.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = questions.getString(key);
			System.out.println(key + ": " + value);
		}
		System.out.println("\nInput number of question.");
		while (!scanner.hasNextInt()) {
			System.out.println("Input correct number to proceed");
			scanner.next();
		}
		ResourceBundle answers = ResourceBundle.getBundle("by.java.training.chp.answers", locale);
		scanner.nextLine(); //without this scanner magic runs both try and catch blocks

		while (true) {
			try {
				System.out.println(answers.getString(scanner.nextLine()));
				break;
			} catch (MissingResourceException e) {
				System.out.println("There's no such question. Try again.");
			}
		}
		scanner.close();
	}

}
