import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.Graphics;
public class Life {
	private Cell[][] board;
	private JFrame mainFrame;
	public static void main(String[] args) {
		
		Life bore = new Life();
		for (int i = 0; i < bore.getBoard().length; i++) {
			for (int j = 0; j < bore.getBoard()[i].length; j++) {
				bore.getBoard()[i][j] = new Cell();
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
	
	

	private Life() {
		
		mainFrame = new JFrame("Conways Game of Life");
	      mainFrame.setSize(600,600);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      mainFrame.setLocationRelativeTo(null);
	      mainFrame.setLayout(new GridLayout(10,10));
	      for(int x =0; x<100;x++){
	    	  mainFrame.add(new JCheckBox());
	      }
	      mainFrame.setVisible(true); 
	      
	      
	      board = new Cell[100][100];
	}
	private Cell[][] getBoard() {
		return board;
	}
	
	private JFrame getFrame() {
		return mainFrame;
	}

	private void setBoard(Cell[][] x) {
		board = x;
	}

	private int countSurrounding(Cell[][] xi, int a, int b) {
		int count = 0;
		int[][] surrounding = { { a - 1, b - 1 }, { a - 1, b }, { a - 1, b + 1 }, { a, b - 1 }, { a, b + 1 },
				{ a + 1, b - 1 }, { a + 1, b }, { a + 1, b + 1 } };
		for(int i[]: surrounding){
			try{
				if(xi[i[0]][i[1]].getLife()==true){
					count++;
				}
			} catch(ArrayIndexOutOfBoundsException e){}
		}
		return count;
	}
	
	
}


