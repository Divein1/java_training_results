package by.java.training.chp;

public class Pen {
	private boolean isWorking;
	private String colour;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + (isWorking ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (isWorking != other.isWorking)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pen [isWorking=" + isWorking + ", colour=" + colour + "]";
	}
	
}
