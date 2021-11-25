
public class FigureDecorator implements AbstractFigure{
	
	private AbstractFigure daDecorare=null;
	
	public FigureDecorator(AbstractFigure a) {
		super();
		daDecorare=a;
	}
	
	@Override
	public String addImage() {
		return daDecorare.addImage();
	}

	@Override
	public int getX() {
		return daDecorare.getX();
	}

	@Override
	public int getY() {
		return daDecorare.getY();
	}
	
	
	
}
