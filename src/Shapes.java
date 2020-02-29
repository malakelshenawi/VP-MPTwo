
public class Shapes {
	String type;
	int Leftx;
	int Bottomy;
	int Rightx;
	int Topy;
	public Shapes(String type,int Leftx,int Bottomy,int Rightx,int Topy) {
		this.type = type;
		this.Leftx = Leftx;
		this.Bottomy = Bottomy;
		this.Rightx = Rightx;
		this.Topy = Topy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLeftx() {
		return Leftx;
	}
	public void setLeftx(int leftx) {
		Leftx = leftx;
	}
	public int getBottomy() {
		return Bottomy;
	}
	public void setBottomy(int bottomy) {
		Bottomy = bottomy;
	}
	public int getRightx() {
		return Rightx;
	}
	public void setRightx(int rightx) {
		Rightx = rightx;
	}
	public int getTopy() {
		return Topy;
	}
	public void setTopy(int topy) {
		Topy = topy;
	}
	
}
