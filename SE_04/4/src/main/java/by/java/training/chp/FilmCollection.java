package by.java.training.chp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FilmCollection {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Code below is used to generate basic collection
		/*
		 * List<Movie> movieCollection = new ArrayList<Movie>(); 
		 * Movie movie = new Movie("Good movie"); 
		 * movie.addActor("Jeff Bridges");
		 * movie.addActor("Jack Nicholson");
		 * movie.addActor("Robert De Niro");
		 * 
		 * movieCollection.add(movie); 
		 * movieCollection.add(new Movie());
		 * movieCollection.add(new Movie());
		 * System.out.println(movieCollection);
		 */

		/**
		 * Reads collection object from file.
		 */
		ObjectInputStream in = null;
		List<Movie> movieCollection = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("MovieCollection.col")));
			movieCollection = (List<Movie>) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/**
		 * Modifies collection via console.
		 */

		System.out.println(movieCollection);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
					"\nWhat do you want to do?>\n 1.View collection. \n 2.Add movie. \n 3.Remove movie. \n 4.Save and exit");
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.println("Incorrect input, try again!");
			}
			switch (sc.nextInt()) {
			case 1:
				System.out.println(movieCollection);
				break;
			case 2:
				addMovie(movieCollection);
				break;
			case 3:
				System.out.println("Input index");
				int index = sc.nextInt();
				movieCollection.remove(index);
				break;
			case 4:
				writeClose(movieCollection);
				System.exit(0);
			default:
				System.out.println("Input correct number");
				break;
			}

		}

	}

	/**
	 * Adds movie to collection via console input.
	 */

	private static void addMovie(List<Movie> movieCollection) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input movie title.");

		String name = scanner.nextLine();
		Movie movie = new Movie(name);
		System.out.println("Do you want to add actors? y/n");

		if (scanner.nextLine().equalsIgnoreCase("y")) {
			System.out.println("Input name of actor or 0 to finish.");
			boolean moreActors = true;
			while (moreActors) {
				String actorName = scanner.nextLine();
				if (actorName.equals("0")) {
					moreActors = false;
					break;
				} else {
					movie.addActor(actorName);
				}
			}

		}

		movieCollection.add(movie);
	}

	/**
	 * Writes modified collection object to file.
	 */

	private static void writeClose(List<Movie> movieCollection) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("MovieCollection.col")));
			out.writeObject(movieCollection);
			out.flush();
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
