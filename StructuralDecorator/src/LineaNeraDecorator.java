
public class LineaNeraDecorator extends FigureDecorator{
	
	public LineaNeraDecorator(AbstractFigure a) {
		super(a);
		
	}
	
	@Override
	public String addImage() {
		return super.addImage()+"/lineaNera.png";
	}

}
