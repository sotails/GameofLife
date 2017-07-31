import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GUI  {
		private Cell[][] board;
		private JFrame mainFrame;
		
		public GUI() {
		mainFrame = new JFrame("Conways Game of Life");
	      mainFrame.setSize(600,600);
	      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      
	      
	      
	      board = new Cell[100][100];
	}
	public Cell[][] getBoard() {
		return board;
	}
	
	
	public JFrame getFrame() {
		return mainFrame;
	}

	public void setBoard(Cell[][] x) {
		board = x;
	}

	public int countSurrounding(Cell[][] xi, int a, int b) {
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
