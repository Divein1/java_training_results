package by.java.training.chp.services.util;

import java.util.UUID;

public class RandomVal {
	public static String getRString(int num){
		String uuid =UUID.randomUUID().toString().replaceAll("-", "");
		int randomVal = (int) (Math.random()*num);
		uuid = uuid.substring(0,randomVal);
		return uuid;
	}
	public static int getRInt(int num){
		return ((int) (Math.random()*num)+1);
	}
	public static int getRInt(int start, int end ){
		return ((int) (Math.random()*(end-start))+1+start);
			
	}

}
