import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
public class Life extends JFrame{
	
	public static void main(String[] args) {
		
		GUI bore = new GUI();
		for (int i = 0; i < bore.getBoard().length; i++) {
			for (int j = 0; j < bore.getBoard()[i].length; j++) {
				bore.getBoard()[i][j] = new Cell();
			}
		}
		for (int i = 0; i < bore.getBoard().length; i++) {
			for (int j = 0; j < bore.getBoard()[i].length; j++) {
				double x = Math.random()*1;
				if(x>=.8) {
					bore.getBoard()[i][j].setLife(true);;
				}
			}
		}
		
//		do {

//		for (int i = 0; i < bore.getBoard().length; i++) {
//			for (int j = 0; j < bore.getBoard()[i].length; j++) {
//				if (bore.getBoard()[i][j].getLife() == false) {
//					System.out.print("x");
//				} else
//					System.out.print("V");
//			}
//			System.out.println("");
//
//			}
//			Cell[][] n = new Cell[100][100];
//			for (int i = 0; i < bore.getBoard().length; i++) {
//				for (int j = 0; j < bore.getBoard()[i].length; j++) {
//					n[i][j] = new Cell();
//				}
//			}
//			for (int i = 0; i < bore.getBoard().length; i++) {
//				for (int j = 0; j < bore.getBoard()[0].length; j++) {
//
//					if (bore.countSurrounding(bore.getBoard(), i, j) < 2
//							|| bore.countSurrounding(bore.getBoard(), i, j) > 3) {
//						n[i][j].setLife(false);
//					} else {
//						n[i][j].setLife(true);
//					}
//
//				}
//			}
//			bore.setBoard(n);
//		} while (x==1);
	}
}

	
	

