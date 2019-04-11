package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import entity.Board;
import resolver.QueenResolver;

public class QueenResolverTest {
	
	
	@Test
	public void encontrarTodasSolucoesOitoRainhasBacktracking() {
		List<Board> solutions = QueenResolver.findAllSolutionsEightQueensProblem();
		assertEquals(92, solutions.size());
		
		//Show all solutions
		System.out.println("#All board solutions 8 queen problem");
		solutions.forEach(board -> {
			System.out.println("\n\n###############");
			board.showBoard();
		});
	}
	
	@Test
	public void validBoardZeroQueens() {
		Assert.assertTrue(QueenResolver.isBoardValid(new Board()));	
	}
	
	@Test
	public void validBoardOneQueen() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		Assert.assertTrue(QueenResolver.isBoardValid(board));
	}
	
	@Test
	/**
	 * Two side by side queen in a invalid board configuration
	 */
	public void invalidBoardTwoQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(0, 1, 2);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));		
	}
	
	@Test
	/**
	 * Horizontal queen in a invalid board configuration
	 */
	public void invalidBoardHorizontalQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(3, 0 , 2);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));		
	}
	
	@Test
	/**
	 * Up left diagonal queen in a invalid board configuration
	 */
	public void invalidBoardUpleftDiagonalQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(2, 2 , 2);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));		
	}
	
	@Test
	/**
	 * Up right diagonal queen in a invalid board configuration
	 */
	public void invalidBoardUpRightDiagonalQueens() {
		Board board = new Board();
		board.setValue(1, 3, 1);
		board.setValue(2, 2 , 2);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));		
	}
	
	@Test
	/**
	 * bellow right diagonal queen in a invalid board configuration
	 */
	public void invalidBoardBellowRightDiagonalQueens() {
		Board board = new Board();
		board.setValue(2, 2, 1);
		board.setValue(4, 4 , 2);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));		
	}
	
	@Test
	/**
	 * bellow left diagonal queen in a invalid board configuration
	 */
	public void invalidBoardBellowLeftDiagonalQueens() {
		Board board = new Board();
		board.setValue(2, 2, 1);
		board.setValue(3, 1 , 2);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));		
	}
	
	@Test
	/**
	 * Four queens valid configuration, first and last queen
	 */
	public void invalidBoardFourQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(1, 2, 2);
		board.setValue(2, 7, 3);
		board.setValue(6, 6, 4);
		
		Assert.assertFalse(QueenResolver.isBoardValid(board));			
	}
	
	@Test
	/**
	 * Three queens valid configuration
	 */
	public void validBoardThreeQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(1, 2, 2);
		board.setValue(2, 7, 3);
		
		Assert.assertTrue(QueenResolver.isBoardValid(board));			
	}
	
	
	@Test
	/**
	 * Four queens valid configuration, first and last queen
	 */
	public void validBoardFourQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(1, 2, 2);
		board.setValue(2, 7, 3);
		board.setValue(6, 5, 4);
		
		Assert.assertTrue(QueenResolver.isBoardValid(board));			
	}
	
	@Test
	/**
	 * Five queens valid configuration, first and last queen
	 */
	public void validBoardFiveQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(1, 2, 2);
		board.setValue(2, 7, 3);
		board.setValue(6, 5, 4);
		board.setValue(7, 3, 5);
		
		board.showBoard();
		Assert.assertTrue(QueenResolver.isBoardValid(board));			
	}
	
	@Test
	/**
	 * Six queens valid configuration, first and last queen
	 */
	public void validBoardSixQueens() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(1, 2, 2);
		board.setValue(2, 7, 3);
		board.setValue(3, 1, 4);
		board.setValue(6, 5, 5);
		board.setValue(7, 3, 6);
		
		
		board.showBoard();
		Assert.assertTrue(QueenResolver.isBoardValid(board));			
	}
	
	
	
	
}
