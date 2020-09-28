package com.company;

import controller.SudokuSolver;
import model.Board;
import view.View;

public class Main {

    public static void main(String[] args) {

		Board board = new Board(new InputData().getData());
        SudokuSolver sudokuSolver = new SudokuSolver();

        sudokuSolver.start();
        sudokuSolver.reduceAvailableValues();

        sudokuSolver.assignValues();


        sudokuSolver.print();








    }
}
