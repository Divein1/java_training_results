package by.java.training.chp;
public class Notepad {

	/**
	 * Создает массив строк,
	 * заполняет шаблонными строками.
	 */
	public static void main(String[] args) {
		NotepadEdit edit = new NotepadEdit();
		String[] memo = new String[50];
		memo[0] = "-----Java is a general-purpose computer programming language that is concurrent,";
		memo[1] = "-----class-based, object-oriented,  and specifically designed to have ";
		memo[2] = "-----as few implementation dependencies as possible.";
		memo[3] = "-----It is intended to let application developers \"write once, run anywhere\" (WORA),";
		memo[4] = "-----meaning that compiled Java code can run on all platforms that support Java ";
		memo[5] = "-----without the need for recompilation.";
		/**  Вызывает метод класса NotepadEdit для отображения меню. */
		edit.menu(memo);
	}

}


