package com.company;

import controller.SudokuSolver;
import model.Board;
import view.View;

public class Main {

    public static void main(String[] args) {
	View view = new View();
	InputData inputData = new InputData();
	view.printBoard(inputData.getData());
		Board board = new Board(new InputData().getData());
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.readData();
        sudokuSolver.start();

    }
}
