import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Life {

	public static void main(String[] args) {

		GUI bore = new GUI();
		for (int i = 0; i < bore.getBoard().length; i++) {
			for (int j = 0; j < bore.getBoard()[i].length; j++) {
				bore.getBoard()[i][j] = new Cell();
			}
		}
		for (int i = 0; i < bore.getBoard().length; i++) {
			for (int j = 0; j < bore.getBoard()[i].length; j++) {
				double x = Math.random() * 1;
				if (x >= .8) {
					bore.getBoard()[i][j].setLife(true);
					;
				}
			}
		}
		
		JFrame mainFrame = new JFrame();
		mainFrame.getContentPane().add(bore);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
		new Timer(100, new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				bore.newUpdate(bore.getBoard());
				bore.repaint();
			}
		}).start();
	}

}
