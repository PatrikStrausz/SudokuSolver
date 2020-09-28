package controller;

import com.company.InputData;
import model.Board;


public class SudokuSolver {
    int[][] arr;
    private Board board;

    public void start() {

        if (!readData()) {
            System.out.println("Wrong data source");
            return;
        }

        board = new Board(arr);
        reduceAvailableValues();

    }

    public Board getBoard() {
        return board;
    }

    public boolean readData() {
        arr = new InputData().getData();
        return true;
    }

    public void reduceAvailableValues() {
        int count = 0;

        while (count < 50) {
            count++;
            reduceAvailableValuesInRow();
            reduceAvailableValuesInColumn();
            reduceAvailableValuesInSquare();
            assignValues();
        }
    }

    private void reduceAvailableValuesInSquare() {
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                for (int k = 0; k < 3; k++) {

                    for (int l = 0; l < 3; l++) {


                        if (board.getTiles()[i + k][j + l].getValue() == 0) {
                            for (int m = 0; m < 3; m++) {
                                for (int n = 0; n < 3; n++) {
                                    if (board.getTiles()[i + m][j + n].getValue() > 0) {
                                        board.getTiles()[i + k][j + l].remove(board.getTiles()[i + m][j + n].getValue());


                                    }
                                }

                            }
                            System.out.println();
                        }


                    }


                }
                System.out.println();

            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board.getTiles()[i][j].getAvailable() + " ");

            }
            System.out.println();


        }
    }

    private void reduceAvailableValuesInColumn() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[i][j].getValue() == 0) {
                    for (int k = 0; k < 9; k++) {
                        if (board.getTiles()[k][j].getValue() > 0) {
                            board.getTiles()[i][j].remove(board.getTiles()[k][j].getValue());


                        }
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board.getTiles()[j][i].getAvailable() + " ");
            }
            System.out.println();
        }

    }

    private void reduceAvailableValuesInRow() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[i][j].getValue() == 0) {


                    for (int k = 0; k < 9; k++) {
                        if (board.getTiles()[i][k].getValue() > 0) {
                            board.getTiles()[i][j].remove(board.getTiles()[i][k].getValue());


                        }

                    }

                }
            }
            System.out.println();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board.getTiles()[i][j].getAvailable() + " ");
            }
            System.out.println();
        }

    }

    public void assignValues() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[i][j].getAvailable() != null && board.getTiles()[i][j].getAvailable().size() == 1) {
                    board.getTiles()[i][j].setValue(board.getTiles()[i][j].getAvailable().iterator().next());
                    board.getTiles()[i][j].remove(board.getTiles()[i][j].getValue());
                }

            }

        }
    }
}

