import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.Transient;

import javax.swing.JPanel;

public class GUI extends JPanel {
	private Cell[][] board;

	public GUI() {

		board = new Cell[100][100];
	}

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] x) {
		board = x;
	}



    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color gc = g.getColor();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].getLife() == true) {
					g.setColor(Color.blue);
					g.fillRect(j*5, i*5, 5, 5);
				}
			}
		}

		g.setColor(gc);
	}
	


	public int countSurrounding(Cell[][] xi, int a, int b) {
		int z = 0;
		int y = 0;
		int count = 0;
		int[][] i = { 
				{ a - 1, b - 1 }, 
				{ a - 1, b }, 
				{ a - 1, b + 1 }, 
				{ a, b - 1 }, 
				{ a, b + 1 },
				{ a + 1, b - 1 },
				{ a + 1, b }, 
				{ a + 1, b + 1 } };
		for (int x =0; x<9;x++) {
		
			try {
				if (xi[i[z][y]][i[z][y+1]].getLife() == true) {
					count++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			z++;
		}
		return count;
	}
	  public Dimension getPreferredSize() {
	        return new Dimension(board.length * 5, board[0].length * 5);
	    }

	public void newUpdate(Cell[][] x) {
		Cell[][] n = new Cell[100][100];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				n[i][j] = new Cell();
			}
		}
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {

				if ((countSurrounding(x, i, j) == 3)) {
					n[i][j].setLife(true);
				} else if((countSurrounding(x,i,j)>3) || (countSurrounding(x,i,j)<2)) {
					n[i][j].setLife(false);
					
				} else if(x[i][j].getLife()==true && countSurrounding(x, i, j)==2) {
					n[i][j].setLife(true);
				}

			}
		}
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				this.getBoard()[i][j] = n[i][j];
			}
		}
		

	}

}
