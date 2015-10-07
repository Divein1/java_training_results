package by.java.training.chp;
import java.util.Scanner;
public class Notepad {

	public static void main(String[] args) {
		NotepadEdit edit = new NotepadEdit();
		Scanner scanner = new Scanner(System.in);
		int input;
		String[] memo = new String[50];
		while (true){
			System.out.println("Choose operation:");
			System.out.println("0: Exit 1: Add note 2: Remove note 3:Edit note 4:View all notes");
			input = scanner.nextInt();
			switch(input){
			case 0: 
				System.exit(0);
			case 1: 
				edit.addNote(memo);
				break;
			case 2:
				edit.removeNote(memo);
				break;
			case 3:
				edit.editNote(memo);
				break;
			case 4:
				edit.viewAll(memo);
				break;
			default: 
				System.out.println("Incorrect input");
				System.out.println();
			}
			}
		
		}

	}


