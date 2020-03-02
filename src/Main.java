
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
	
public static void main(String[] args) throws FileNotFoundException{
	ArrayList<Shape> SS = GetShapes();
	//System.out.println(SS.size());
	int rect = 0;
	int cir = 0;
	for(int i = 0;i<SS.size();i++) {
		if(SS.get(i) instanceof Rectangle2D) {
			rect ++;
		}
		if(SS.get(i) instanceof Ellipse2D) {
			cir ++;
		}
		System.out.println(" min_x " + ((RectangularShape) SS.get(i)).getMinX() + " min_y " + ((RectangularShape) SS.get(i)).getMinY() + " max_x " +((RectangularShape) SS.get(i)).getMaxX()+ " max_y " +((RectangularShape) SS.get(i)).getMaxY());
	}
	if(rect<=2 && cir <=2) {
		
	}
}
public static ArrayList<Shape> GetShapes() throws FileNotFoundException{
	ArrayList<Shapes> S = new ArrayList<>();
	ArrayList<Shape> W= new ArrayList<>();
	File file = new File("./test.txt"); 

	BufferedReader br = new BufferedReader(new FileReader(file)); 
	String st;
	String [] input = null;
	
	try {
		
		while ((st = br.readLine()) != null) {
		//	System.out.println(st);
		  input = st.split(" ");
		  if(input[0].equals("rectangle")) {
			  // Text Representation location 0 : object_name -- location 1 : minimum_x -- location 2 : minimum_y -- location 3 : maximum_x -- location 4 :maximum_y
			  //Shape parameters X,Y,Width,Height
		  Shape tp = new Rectangle2D.Float(Integer.parseInt(input[1]),Integer.parseInt(input[2]),(Integer.parseInt(input[3])-Integer.parseInt(input[1])),(Integer.parseInt(input[4])-Integer.parseInt(input[2])));
		//rect ++;
		  W.add(tp);
		  }
		  if(input[0].equals("circle")) {
			  Shape tp = new Ellipse2D.Float(Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
		//	 cir ++;
			  W.add(tp); 
		  }
		//Shapes tmp = new Shapes(input[0],Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]),Integer.parseInt(input[4]));
		//S.add(tmp);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Invalid Input");
		e.printStackTrace();
	} 
	return W;
}
public static boolean Contains(Shape in1,Shape in2) {
	boolean result = false;
//	if(in1.getType().equals("rectangle") && in2.getType().equals("circle")) {
//		if(in1.getLeftx()<=in2.getLeftx() && in1.getRightx()>=in2.getRightx() && in1.getBottomy()<=in2.getBottomy() && in1.getTopy()>=in2.getBottomy()) {
//			result = true;
//		}
		if(in1 instanceof Rectangle2D && in2 instanceof Ellipse2D) {
			if(in1.contains(in2.getBounds2D())) {
				result = true;
			}
	}
	return result;
}
public static boolean left_Of(Shape in1,Shape in2) {
	boolean result = false;
		if(((RectangularShape) in1).getMaxX()<=((RectangularShape) in2).getMinX() && ((RectangularShape) in1).getMinY() == ((RectangularShape) in2).getMinY() && !(in1.intersects((Rectangle2D)in2))) {
			result = true;
		}
	
	return result;
}

}
