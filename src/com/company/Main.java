package com.company;

import model.Board;
import view.View;

public class Main {

    public static void main(String[] args) {
//	View view = new View();
//	InputData inputData = new InputData();
//	view.printBoard(inputData.getData());
		Board board = new Board(new InputData().getData());

    }
}
