package controller;

import com.company.InputData;
import model.Board;

public class SudokuSolver {
    int[][] arr;
    private Board board;

    public void start(){

        if(!readData()){
            System.out.println("Wrong data source");
            return;
        }

        board = new Board(arr);
        reduceAvailableValues();

    }


    public boolean readData(){
       arr = new InputData().getData();
       return true;
    }

    private void reduceAvailableValues() {
        reduceAvailableValuesInRow();
        reduceAvailableValuesInColumn();
        reduceAvailableValuesInSquare();
    }

    private void reduceAvailableValuesInSquare() {
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j <9 ; j+=3) {
                for (int k = i; k <3 ; k++) {
                    for (int l = j; l <3 ; l++) {
                        if (board.getTiles()[k][l].getAvailable()!= null){

                            board.getTiles()[k][l].remove(board.getTiles()[k][l].getValue());
                            System.out.print(board.getTiles()[k][l].getValue()+" ");

                        }

                    }

                }


            }
            System.out.println();

        }
    }

    private void reduceAvailableValuesInColumn() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[j][i].getAvailable()!= null){
                    board.getTiles()[j][i].remove(board.getTiles()[j][i].getValue());

                }
            }
        }
    }

    private void reduceAvailableValuesInRow() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[i][j].getAvailable()!= null){

                        board.getTiles()[i][j].remove(board.getTiles()[i][j].getValue());

                }
            }
        }
    }




}
