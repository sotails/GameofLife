import java.awt.Color;

import java.awt.Graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JPanel{
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
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Color gColor = g.getColor();

	        
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	                if (board[i][j].getLife() == true) {
	                    g.setColor(Color.blue);
	                    g.fillRect(j, i, 1, 1);
	                }
	            }
	        }

	        g.setColor(gColor);
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
	public Cell[][] newUpdate(Cell[][] x){
		Cell[][] n = new Cell[100][100];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				n[i][j] = new Cell();
			}
		}
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {

				if (countSurrounding(x, i, j) < 2
						|| countSurrounding(x, i, j) > 3) {
					n[i][j].setLife(false);
				} else {
					n[i][j].setLife(true);
				}

			}
		}
		return x;
	}
	
	
}
