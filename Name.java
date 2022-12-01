import java.util.ArrayList;

public class Name {
	private ArrayList<String> vorNamen = new ArrayList<String>(2);
	String nachName;
	
	public Name() {
		
	}
	
	public ArrayList<String> getVorName() {
		return vorNamen;
	}
	
	public String getNachName() {
		return nachName;
	}
	
	public boolean addVorName(String vorName){
		return vorNamen.add(vorName);
	}
}
