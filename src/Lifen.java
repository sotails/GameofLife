import java.util.*;

public class Lifen {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the length and width of the game board.");
		int a = s.nextInt();
		int b = s.nextInt();
		Life_Board bore = new Life_Board(a, b);
		for (int i = 0; i < bore.getBoard().length; i++) {
			for (int j = 0; j < bore.getBoard()[i].length; j++) {
				bore.getBoard()[i][j] = new Cell();
			}
		}
		String xyz = "y";
		String zyx = "y";
		do {
			System.out.println("Enter the coordinates for the points you want to make alive.");
			System.out.println("Enter the X position.");
			int h = s.nextInt() - 1;
			System.out.println("Enter the Y position.");
			int g = bore.getBoard().length - s.nextInt();
			if (((g >= 0) && (g < bore.getBoard().length + 1)) && ((h >= 0) && (h < bore.getBoard()[0].length))) {
				bore.getBoard()[g][h].setLife(true);
				for (int i = 0; i < bore.getBoard().length; i++) {
					for (int j = 0; j < bore.getBoard()[i].length; j++) {
						if (bore.getBoard()[i][j].getLife() == false) {
							System.out.print("x");
						} else
							System.out.print("V");
					}
					System.out.println("");

				}
			} else {
				System.out.println("That is out of the bounds you set!");
			}

			System.out.println("Would you like to add more? Use y/n.");
			zyx = s.next();
		} while (zyx.equals("y"));

		do {

			for (int i = 0; i < bore.getBoard().length; i++) {
				for (int j = 0; j < bore.getBoard()[i].length; j++) {
					if (bore.getBoard()[i][j].getLife() == false) {
						System.out.print("x");
					} else
						System.out.print("O");
				}
				System.out.println("");

			}
			Cell[][] n = new Cell[a][b];
			for (int i = 0; i < bore.getBoard().length; i++) {
				for (int j = 0; j < bore.getBoard()[i].length; j++) {
					n[i][j] = new Cell();
				}
			}
			for (int i = 0; i < bore.getBoard().length; i++) {
				for (int j = 0; j < bore.getBoard()[0].length; j++) {

					if (bore.countSurrounding(bore.getBoard(), i, j) < 2
							|| bore.countSurrounding(bore.getBoard(), i, j) > 3) {
						n[i][j].setLife(false);
					} else {
						n[i][j].setLife(true);
					}

				}
			}
			bore.setBoard(n);
			System.out.println("Do you want to continue?y/n");
			xyz = s.next();
		} while (xyz.equalsIgnoreCase("y"));
	}
}
