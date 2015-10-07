package by.java.training.chp;
import java.util.Scanner;

public class NotepadEdit {
	Scanner scanner = new Scanner(System.in);	 
	public void addNote(String[] strArray){
		String str;
		System.out.println("Input note.\n");
		str = scanner.nextLine();
		for (int i = 0; i < strArray.length; i++){
			if (strArray[i] == null) {
				strArray[i]=str;
				break;
			}
		
		}
		System.out.println("Done.");
	}
	
	public void removeNote(String[] strArray){
		int n;
		System.out.println("Input number of note you want to clear.");
		n = scanner.nextInt();
		strArray[n] = "";
		System.out.println("Done");
	}
	
	public void editNote(String[] strArray){
		int n= 6;
		String str;
		System.out.println("Input number of note you want to edit.");
		n = scanner.nextInt();
		System.out.println(strArray[n]);
		System.out.println("Input modified text.");
		//—кипает все что ниже до
		str = scanner.next();
		strArray[n] = str;
		//сюда
		System.out.println("Saved.");
	}
	
	public void viewAll(String[] strArray){
		for (int i = 0; i < strArray.length; i++){
			if (strArray[i]!=null && !strArray[i].isEmpty())
			System.out.println(i + " " + strArray[i]);
		}
	}
}
