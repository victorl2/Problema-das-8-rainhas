package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import entity.Board;

public class BoardTest {
	
	@Test
	public void boardCorretlyInicialized() {
		Board board = new Board();
		
		assertEquals(64, board.getState().size());
		assertTrue(board.getState().stream()
					.filter(value -> value != 0).count() == 0);
	}
	
	@Test
	public void setValueOnBoard() {
		int value = 1;
		int row = 5;
		int col = 2;
		
		Board board = new Board();
		board.setValue(row, col, value);
		
	
		assertEquals(value,board.getValue(row, col));
		assertTrue(board.getState().stream()
				.filter(currentValue -> currentValue == 1)
					.count() == 1);
		
		assertEquals(1, (int) board.getState().get(42));
		
		System.out.println("\n\nValue on row 5, column 2");
		board.showBoard();
	}
	
	@Test
	public void setValueStartBoard() {
		int value = 1;
		int row = 0;
		int col = 0;
		
		Board board = new Board();
		board.setValue(row, col, value);
		
		assertEquals(value,board.getValue(row, col));
		assertTrue(board.getState().stream()
				.filter(currentValue -> currentValue == 1)
					.count() == 1);
		
		assertEquals(1, (int) board.getState().get(0));
		
		System.out.println("\n\nValue on the first position");
		board.showBoard();
	}
	
	@Test
	public void setValueEndBoard() {
		int value = 1;
		int row = 7;
		int col = 7;
		
		Board board = new Board();
		board.setValue(row, col, value);
		
		assertEquals(value,board.getValue(row, col));
		assertTrue(board.getState().stream()
				.filter(currentValue -> currentValue == 1)
					.count() == 1);
		
		assertEquals(1, (int) board.getState().get(63));
		
		System.out.println("\n\nValue on the last position");
		board.showBoard();
	}
	
	@Test
	public void countValidElementsOnBoard() {
		Board board = new Board();
		board.setValue(0, 0, 1);
		board.setValue(1, 3, 1);
		
		assertEquals(2,board.countValidElements());
		board.showBoard();
		
	}
	 
}
