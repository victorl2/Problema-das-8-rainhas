package entity;

import java.util.ArrayList;
import java.util.List;

public class Board{
	/**
	 * The size of the board, the default cheast board is 8 x 8
	 */
	public static final Integer DIMENSION = 8;
	
	private List<Integer> board;
	
	public Board() {
		board = new ArrayList<>();
		for(int i = 0; i < Math.pow(DIMENSION,2); i++)
			board.add(0);
	}
	
	public Board(List<Integer> board) {
		this.board = new ArrayList<>(board);
	}
	
	public int getValue(int row, int column) {
		return board.get(position(row,column));
	}
	
	public void setValue(int row, int column,int value) {
		board.set(position(row,column), value);
	}
	
	public void setValueAbsolutePosition(int position, int value) {
		board.set(position, value);
	}
	
	public List<Integer> getState(){
		return board;
	}
	
	public void showBoard() {
		int lineCounter = 0;
		for(Integer value : board) {
			if(lineCounter == DIMENSION) {
				System.out.println();
				lineCounter = 0;
			}
			System.out.print(value + " ");
			lineCounter++;
		}
	}
	
	public int countValidElements() {
		return (int) board.stream().filter(value -> value !=0).count();
	}
	
	public Board cpy() {
		return new Board(board);
    }
	
	private int position(int row,int column) {
		if(row >= DIMENSION || column >= DIMENSION || row < 0 || column < 0)
			throw new ArrayIndexOutOfBoundsException(String.format("Verifique se a posição informada para linha e coluna são válidas, linha: %s, coluna:%s",row,column));
		return ((DIMENSION) * row ) + column;
	}
	
	
}
