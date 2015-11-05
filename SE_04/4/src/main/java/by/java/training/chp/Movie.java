package by.java.training.chp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Movie() {
		this.title = "Some movie";
		addActor("Some actor1");
		addActor("Some actor2");
		addActor("Some actor3");
	}
	public Movie(String title) {
		this.title = title;
	}

	private String title;

	public String getTitle() {
		return title;
	}

	List<Actor> actors = new ArrayList<Actor>();

	public void addActor(String name) {
		actors.add(new Actor(name));
	}
	public void delActor(int index) {
		actors.remove(index);
	}
	public void delAllActors() {
		actors.removeAll(actors);
	}

	public void showActors() {
		System.out.println(actors.toString());
	}

	@Override
	public String toString() {
		return "\n" + title + ",actors:	" + actors;
	}
	

}
