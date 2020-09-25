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


                        }

                    }

                }


            }


        }
    }

    private void reduceAvailableValuesInColumn() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[i][j].getAvailable() == null){
                    System.out.print(board.getTiles()[i][j].getValue() + " ");

                    for (int k = 0; k < 9; k++) {
                        if (board.getTiles()[k][j].getAvailable() != null){
                            board.getTiles()[k][j].remove(board.getTiles()[i][j].getValue());

                            System.out.print(  board.getTiles()[k][j].getAvailable() + " ");

                        }

                    }


                }
                System.out.println();

            }
            System.out.println();

        }

    }

    private void reduceAvailableValuesInRow() {

    }





}
