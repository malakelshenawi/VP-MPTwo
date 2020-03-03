import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;

public class Draw extends Component{
	ArrayList<Shape> SS;
	public Draw(ArrayList<Shape> SS) {
		this.SS=SS;
	}
	public void paint (Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    for(int i =0;i<SS.size();i++) {
	    	g2.draw(SS.get(i));
	    	}
	  
	}
}
