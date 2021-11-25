import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame f=new JFrame("Board");
		f.setSize(600,600);
		
		Board board=new Board();
		f.add(board,BorderLayout.CENTER);
		
		f.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				board.componentResized();
			}
		});
		f.setMinimumSize(new Dimension(600,600));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
