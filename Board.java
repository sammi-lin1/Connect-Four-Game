import java.util.*;
public class Board {
	private char[][] board = new char[6][7];
	private boolean isWinner;
	private boolean isFull;
	char player;
	
	public Board() {                                          //Constructor
		isWinner = false;                                    //sets red and yellow to false
		isFull = false;
		player = 'R';
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {      //sets up an empty String[][] board array
				board[i][j]= ' ';
			}
		}
	}
	
	public String toString() {                                       //Sets up the 2D array into a connect4 board
		String boardString = "";
		for(int i = 0; i < board.length; i++) {
			boardString += "|";
			for(int j = 0; j < board[i].length; j++) {
				boardString += board[i][j] + "|";
			}
			boardString += "\n";
		}
		boardString += "...............";
		return boardString;
	}
	
	public boolean setBoard(int col, char player) {                  //This method will setBoard and return true if column is full, false otherwise
		boolean isError = false;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(j == col && board[5-i][col] == ' ') {
					board[5-i][col] = player;
					return isError;
				}
				else if(i==0 && board[0][col] != ' ')
					isError = true;
			}
		}
		return isError;
	}
	
	public void columnIsFull(boolean isError, int move, char player) {
		Scanner stdin = new Scanner(System.in);
		if(isError == true) {
			while(setBoard(move, player) == true) {                      //if setBoard returns true, column is full. This method
				System.out.println();                                    //prompts the user again and again until they pick not full column
				System.out.println("This column is full");
				if(player == 'R') {
					System.out.print("Drop a red disk at column (0-6): ");
					move = stdin.nextInt();
				}
				else {
					System.out.print("Drop a yellow disk at column (0-6): ");
					move = stdin.nextInt();
				}
				System.out.println();
			}
		}
		System.out.println(toString());
	}
	
	public void Horizontal(char player) {                      
		for(int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length - 3; j++){
				if (board[i][j] == player   && 
					board[i][j+1] == player &&
					board[i][j+2] == player &&
					board[i][j+3] == player){
					if(player == 'Y') {
						System.out.println("Yellow wins!");
						isWinner = true;
						break;
					}
					else {
						System.out.println("Red wins!");
						isWinner = true;
						break;
					}
				}
			}			
		}
	}
	
	public void Vertical(char player) {		
		for(int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length - 4; j++){             //swap j and i and subtract 4 from the number of rows
				if (board[j][i] == player   &&                         //checks to make sure that there are 4 consecutive
					board[j+1][i] == player &&                         //rows that equal either 'Y' or 'R' (depending on the player value)
					board[j+2][i] == player &&
					board[j+3][i] == player){
					if(player == 'Y') {
						System.out.println("Yellow wins!");
						isWinner = true;
						break;
					}
					else {
						System.out.println("Red wins!");
						isWinner = true;
						break;
					}
				}
			}			
		}
	}
	
	public void upDiagonal(char player) {
		for(int i = 3; i < board.length; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if (board[i][j] == player   && 
					board[i-1][j+1] == player &&
					board[i-2][j+2] == player &&
					board[i-3][j+3] == player){
					if(player == 'Y') {
						System.out.println("Yellow wins!");
						isWinner = true;
						break;
					}
					else {
						System.out.println("Red wins!");
						isWinner = true;
						break;
					}
				}
			}
		}
	}
	
	public void downDiagonal(char player) {
		for(int i = 0; i < board.length - 3; i++){
			for(int j = 0; j < board[0].length - 3; j++){
				if (board[i][j] == player   && 
					board[i+1][j+1] == player &&
					board[i+2][j+2] == player &&
					board[i+3][j+3] == player){
					if(player == 'Y') {
						System.out.println("Yellow wins!");
						isWinner = true;
						break;
					}
					else {
						System.out.println("Red wins!");
						isWinner = true;
						break;
					}
				}
			}
		}
	}
	
	public void isTie() {
		int count = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == ' ') {
					count++;
				}
			}
		}
		if(count == 0) {
			System.out.println("Tie!");
			isWinner = true;                    //stops the while loop
		}
	}
	
	public char getPlayer() {
		return player;
	}
	
	public void setPlayer(char prev) {
		if(prev == 'R')
			player =  'Y';
		else
			player = 'R';
	}
	
	public boolean getIsWinner() {
		return isWinner;
	}
	
	public boolean getIsFull() {
		return isFull;
	}
}
