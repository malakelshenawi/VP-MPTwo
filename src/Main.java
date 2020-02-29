
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
	
public static void main(String[] args) throws FileNotFoundException{
	ArrayList<Shapes> SS = GetShapes();
	for(int i = 0;i<SS.size();i++) {
		System.out.println("type " + SS.get(i).getType()+ " min_x " + SS.get(i).getLeftx() + " min_y " + SS.get(i).getBottomy() + " max_x " +SS.get(i).getRightx()+ " max_y " +SS.get(i).getTopy());
	}
	
}
public static ArrayList<Shapes> GetShapes() throws FileNotFoundException{
	ArrayList<Shapes> S = new ArrayList<>();
	File file = new File("./test.txt"); 

	BufferedReader br = new BufferedReader(new FileReader(file)); 
	String st;
	String [] input = null;
	
	try {
		st = br.readLine();
		while ((st = br.readLine()) != null) {
		//	System.out.println(st);
		  input = st.split(" ");
		Shapes tmp = new Shapes(input[0],Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
		S.add(tmp);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Invalid Input");
		e.printStackTrace();
	} 
	return S;
}
public static boolean Contains(Shapes in1,Shapes in2) {
	boolean result = false;
	if(in1.getType().equals("rectangle") && in2.getType().equals("circle")) {
		if(in1.getLeftx()<=in2.getLeftx() && in1.getRightx()>=in2.getRightx() && in1.getBottomy()<=in2.getBottomy() && in1.getTopy()>=in2.getBottomy()) {
			result = true;
		}
	}
	return result;
}
public static boolean left_Of(Shapes in1,Shapes in2) {
	boolean result = false;
		if(in1.getRightx()<=in2.getLeftx()) {
			result = true;
		}
	
	return result;
}

}
