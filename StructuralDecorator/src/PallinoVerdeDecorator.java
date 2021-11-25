
public class PallinoVerdeDecorator extends FigureDecorator{
	
	public PallinoVerdeDecorator(AbstractFigure a) {
		super(a);
	}
	
	@Override
	public String addImage() {
		return super.addImage()+"/pallinoVerde.png";
	}

}
