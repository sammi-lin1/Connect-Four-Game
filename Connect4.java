import java.util.*;
public class Connect4 {
	public static void main(String[] args) {
		System.out.println("Welcome to Connect Four");
		System.out.println();
		Board board = new Board();                                         //creates board object
		System.out.println(board);                                         //prints an empty board
		

		int move = 0;
		Scanner stdin = new Scanner(System.in);
		while(board.getIsWinner() == false) {
			if(board.getPlayer() == 'R') 
				System.out.print("Drop a red disk at column (0-6): ");
			if(board.getPlayer() == 'Y') 
				System.out.print("Drop a yellow disk at column (0-6): ");
				move = stdin.nextInt();
				while(!(move >= 0 && move <= 6)) {
					System.out.print("Please input an integer for 0 to 6: ");
					move = stdin.nextInt();
					System.out.println();
				}
				
				board.columnIsFull(board.setBoard(move, board.getPlayer()), move, board.getPlayer());	   //if user inputs a full column this will prompt user to try again
				board.Horizontal(board.getPlayer());
				board.Vertical(board.getPlayer());
				
				board.upDiagonal(board.getPlayer());
				board.downDiagonal(board.getPlayer());
				
				board.isTie();
				board.setPlayer(board.getPlayer());
		}
		stdin.close();
	}
}
	

	
	

