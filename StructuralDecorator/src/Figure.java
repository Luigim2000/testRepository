
public class Figure implements AbstractFigure{
	
	int x;
	int y;
	
	public Figure(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String addImage() {
		return "/rossa.png";
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
}
