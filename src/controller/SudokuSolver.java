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
    }

    private void reduceAvailableValuesInColumn() {
    }

    private void reduceAvailableValuesInRow() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {


            }

        }
    }




}
