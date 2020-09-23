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

    }


    public boolean readData(){
       arr = new InputData().getData();
       return true;
    }
}
