package ensta;

import ensta.model.Board;

public class TestBoard {
	public static void main(String[] args) {
		Board board = new Board("testboard",10);
		board.print();
	}
}
