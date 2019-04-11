package resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Board;

public class QueenResolver {
	private static Logger LOGGER = Logger.getLogger(QueenResolver.class.getName());

	
	public static List<Board> findAllSolutionsEightQueensProblem() {
		List<Board> solutions = new ArrayList<>();
		findAllSolutionsNQueensProblem(solutions, new Board(), 0);
		return solutions;
	}
	
	private static void findAllSolutionsNQueensProblem(List<Board> solutions, Board board,int startPosition){
		if(board.countValidElements() == 8) {
			solutions.add(board.cpy());
			return;
		}
		
		int currentQueen = board.countValidElements() + 1;
		
		for(int position = startPosition; position < board.getState().size(); position++) {	
			board.setValueAbsolutePosition(position, currentQueen);
			
			if(isBoardValid(board)) {
				findAllSolutionsNQueensProblem(solutions, board,position + 1);
			}
			board.setValueAbsolutePosition(position, 0);
		}		
	}
	
	public static boolean isBoardValid(Board board) {
		for(int x = 0; x < board.getState().size(); x ++) {
			int row = x / board.DIMENSION;
			int column = x % board.DIMENSION;
			
			
			if(board.getValue(row, column) != 0 && queenCheckColision(board,row,column)) 
				return false;
			
		}
				
		return true;	
	}
	
	private static boolean queenCheckColision(Board board, int queenRow, int queenCol) {	
		for(int x = 0; x < Board.DIMENSION; x ++) {				
			//Horizontal check
			if(x != queenCol && board.getValue(queenRow, x) != 0) {
				return true;
			}
				
			
			if(x != queenRow) {
				//Vertical check
				if(board.getValue(x, queenCol) != 0) {
					return true;
				}
				
				int rowDistance = Math.abs(queenRow - x); 
				
				//Diagonal right
				if(queenCol + rowDistance < Board.DIMENSION && board.getValue(x, queenCol + rowDistance) != 0) {
					return true;
				}
				
				//Diagonal left
				if(queenCol - rowDistance >= 0 && board.getValue(x, queenCol - rowDistance) != 0) {
					return true;
				}
			}				
		}
		
		return false;
	}
	
}
