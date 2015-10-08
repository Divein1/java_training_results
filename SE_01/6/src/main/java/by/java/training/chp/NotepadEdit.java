package by.java.training.chp;
import java.util.Scanner;

public class NotepadEdit {
	Scanner scanner = new Scanner(System.in);	
	/**
	 * ������������ �������� �����,
	 * �� ��������� ������ ����� Int.
	 */	
	public void checkInt(){
		while (!scanner.hasNextInt()){
			System.out.println("Input correct number to proceed");
			scanner.next();
		}	
	}
	/**
	 * ������� �������� ���� ��������
	 * @param noteArray ������ ����� �� ����
	 */
	public void menu( String[] noteArray) {
		int input;
		while (true){
			System.out.println("Choose operation:");
			System.out.println("0: Exit 1: Add note 2: Remove note 3: Edit note 4: View all notes");
			checkInt();
			input = scanner.nextInt();
				switch(input){
					case 0:
						System.exit(0);
					case 1: 
						addNote(noteArray);
						break;
					case 2:
						removeNote(noteArray);
						break;
					case 3:
						editNote(noteArray);
						break;
					case 4:
						viewAll(noteArray);
						break;
					default: 
						System.out.println("Incorrect input");
						System.out.println();
				}
			
			
			}
		
	}
	/**
	 * ��������� ����� ������ � ������ ������ ������ �������
	 * @param strArray �������������� ������ �����
	 */
	public void addNote(String[] strArray){
		String str;
		System.out.println("Input note.\n");
		str = scanner.next();
		str = scanner.nextLine();
		for (int i = 0; i < strArray.length; i++){
			if (strArray[i] == null) {
				strArray[i]=str;
				break;
			}
		
		}
		System.out.print("Done.");
	}
	/**
	 * ������� ������.
	 * ����������� ������ ����� ��������� �� ������������������ ������.
	 * @param strArray  �������������� ������ �����.
	 */
	public void removeNote(String[] strArray){
		int n;
		System.out.println("Input number of note you want to clear.");
		checkInt();
		n = scanner.nextInt();
		strArray[n] = null;
		System.out.println("Done");
		for (int i = 0; i < strArray.length; i++) {
			if (i!=strArray.length-1) {
				
				if ((strArray[i] == "")||(strArray[i] == null)){
					strArray[i] = strArray[i+1];
					strArray[i+1] = null;
				
				}
			}
		}
	}
	/**
	 * ������� ������,
	 * ���������� � ��� ����� �������� ��������� �������������.
	 * @param strArray �������������� ������ �����.
	 */
	public void editNote(String[] strArray){
		String str;
		System.out.println("Input number of note you want to edit.");
		checkInt();
		int n = scanner.nextInt();
		System.out.println(strArray[n]);
		System.out.println("Input modified text.");
		//������� ��� ��� ���� ��
		str = scanner.nextLine();
		str = scanner.nextLine();
		strArray[n] = str;
		//����, ���� nextLine �� �2 ?
		System.out.println("Saved.");
	}
	/**
	 * ���������� ��� �� ������ ������ �������.
	 * @param strArray �������������� ������ �����.
	 */
	public void viewAll(String[] strArray){
		for (int i = 0; i < strArray.length; i++){
			if (strArray[i]!=null && !strArray[i].isEmpty())
			System.out.println(i + " " + strArray[i]);
		}
	}
}
