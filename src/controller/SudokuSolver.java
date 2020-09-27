package controller;

import com.company.InputData;
import model.Board;

import java.util.jar.JarOutputStream;

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
        System.out.println();
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j <9 ; j+=3) {
                for (int k = i; k <3 ; k++) {
                    for (int l = j; l <3 ; l++) {
                        if (board.getTiles()[k][l].getAvailable()!= null){

                            board.getTiles()[k][l].remove(board.getTiles()[i][j].getValue());


                        }

                    }

                }


            }


        }

        for (int i = 0; i <9 ; i+=3) {
            for (int j = 0; j < 9; j += 3) {

                    for (int k = 0; k < 3; k++) {

                        for (int l = 0; l < 3; l++) {

                                if(board.getTiles()[i+k][j+l].getAvailable() == null){
                                    for (int m = 0; m <3 ; m++) {
                                        for (int n = 0; n <3 ; n++) {
                                            if (board.getTiles()[i + m][j + n].getAvailable() != null) {
                                                board.getTiles()[i + m][j + n].remove(board.getTiles()[i+k][j+l].getValue());
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
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                System.out.print(board.getTiles()[i][j].getAvailable() + " ");

            }
            System.out.println();

        }


    }

    private void reduceAvailableValuesInColumn() {
        System.out.println();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board.getTiles()[i][j].getAvailable() == null){
                    for (int k=0; k<9; k++){
                        if (board.getTiles()[k][j].getAvailable() != null){
                            board.getTiles()[k][j].remove(board.getTiles()[i][j].getValue());
                        }
                    }
                }
            }
        }

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                System.out.print(  board.getTiles()[j][i].getAvailable() + " ");
            }
            System.out.println();
        }


    }

    private void reduceAvailableValuesInRow() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getTiles()[i][j].getAvailable() == null) {


                    for (int k = 0; k < 9; k++) {
                        if (board.getTiles()[i][k].getAvailable() != null) {
                            board.getTiles()[i][k].remove(board.getTiles()[i][j].getValue());


                        }

                    }

                }
            }
            System.out.println();
        }

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                System.out.print(  board.getTiles()[i][j].getAvailable() + " ");
            }
            System.out.println();
        }


    }
}
