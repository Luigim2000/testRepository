import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener,MouseMotionListener{

	private static final long serialVersionUID = 5379358483855227909L;
	private List<AbstractFigure> figures=new ArrayList<AbstractFigure>();
	private int currentFigure;
	private Color currentColor=Color.BLACK;
	private Image background=null;
	
	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
	
	public Board() {
		addMouseListener(this);
		addMouseMotionListener(this);
		currentFigure=0;
		Image img;
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/albero.png"));
			img=img.getScaledInstance(600, 600,Image.SCALE_SMOOTH);
			background=img;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
		
		for(AbstractFigure f:figures) {
			String lista=f.addImage();
			String[] res=lista.split("/");
			for(int i=0;i<res.length;i++)
			{
				if(res[i]!="")
				{
					try {
						Image img = ImageIO.read(getClass().getResourceAsStream(res[i]));
						img=img.getScaledInstance(40, 40,Image.SCALE_SMOOTH);
						g.drawImage(img,f.getX()-20,f.getY()-20,null);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void componentResized() {
		background=background.getScaledInstance(getSize().width,getSize().height, Image.SCALE_SMOOTH);
		repaint();
	}
	
	public void clean() {
		figures.clear();
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Figure f=new Figure(e.getX(),e.getY());
		AbstractFigure af;
		switch(currentFigure) {
		case 0:
			figures.add(f);
			break;
		case 1:
			af=new PallinoBluDecorator(f);
			figures.add(af);
			break;
		case 2:
			af=new PallinoVerdeDecorator(f);
			figures.add(af);
			break;
		case 3:
			af=new LineaNeraDecorator(new PallinoBluDecorator(f));
			figures.add(af);
			break;
		case 4:
			af=new LineaNeraDecorator(new PallinoVerdeDecorator(f));
			figures.add(af);
			currentFigure=-1;
			break;
		}
		repaint();
		currentFigure++;
	}
	@Override
	public void mouseDragged(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) { clean();}
	public void mouseMoved(MouseEvent e) {}
}