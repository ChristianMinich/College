
public class Student {
	public static final String HOCHSCHULE = "HS Osnabrueck";
	Boolean istEingeschrieben;
	Integer immanr;
	Double durchschnittsNote;
	Name name;
	Geschlecht geschlecht;

	public boolean setdurchschnittsNote(double durchschnittsNote) {
		if (durchschnittsNote >= 1.0 && durchschnittsNote <= 5.0) {
			this.durchschnittsNote = durchschnittsNote;
			return true;
		}
		return false;
	}
}