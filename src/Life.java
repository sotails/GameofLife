import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		GUI gol = new GUI();
		new Timer(100, new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				gol.newUpdate(bore.getBoard());
				gol.repaint();
			}
		}).start();
	}

}
