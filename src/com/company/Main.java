package com.company;

import controller.SudokuSolver;
import model.Board;
import view.View;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(new InputData().getData());
        View view = new View();

        SudokuSolver sudokuSolver = new SudokuSolver();

        sudokuSolver.start();

        sudokuSolver.assignValues();

        view.printBoard(sudokuSolver.getBoard().getTiles());


    }
}
