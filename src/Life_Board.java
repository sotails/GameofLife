public class Life_Board {

	private Cell[][] board;
	

	public Life_Board(int x, int y) {
		
	      board = new Cell[x][y];
	}
	public Cell[][] getBoard() {
		return board;
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
