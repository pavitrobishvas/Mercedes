import java.util.Comparator;

public class HashTagCampator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		//System.out.println("compator class---;;;"+(o2.length()-o1.length()));
		return o2.length() - o1.length();
	}
	
	
}
