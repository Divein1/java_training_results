package by.java.training.chp;

import java.io.Serializable;

public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	
	public Actor(){
		this.name = "Some actor";
	}
	
	public Actor(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return  name;
	}
	

}
