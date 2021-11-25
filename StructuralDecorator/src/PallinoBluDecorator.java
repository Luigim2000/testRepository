
public class PallinoBluDecorator extends FigureDecorator{
	
	public PallinoBluDecorator(AbstractFigure a) {
		super(a);
	}
	
	@Override
	public String addImage() {
	return super.addImage()+"/pallinoBlu.png";
	}

}
