package by.java.training.chp;

@ControlledObject(name = "Boat")
public class NuclearSubmarineAnno {
	@NameAnno("VERONICA")
	String name = "BOAT NAME";
	
	private NuclearDrive drive = new NuclearDrive();

	
	public void callEngineStart(int fuel) {
		drive.engineStart(fuel);
	}
	@MethAnno(name = "callStart")
	public void callEngineStart() {
		drive.engineStart(10);
	}
	class NuclearDrive {
		public void engineStart(int fuel) {
			String str = " ";
			System.out.println("Engine started. Moving to new location.");
			for (int i = 0; i < fuel; i++) {
				System.out.println(str + "->");
				str = str + "     ";
				try {
					Thread.sleep(200);
				} catch (Exception e) {
					System.out.println("Exception caught");
				}
			}
			System.out.println("Destination reached.");
		}

	}

	public static void main(String[] args) {
		NuclearSubmarineAnno boat = new NuclearSubmarineAnno();
		boat.callEngineStart(5);
	}

}
