package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputData {


    public int[][] getData() {
        try {
            String data = null;
            File myObj = new File("C://Users//Boris//IdeaProjects//SudokuSolver//src//SudokuDemo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();


            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    assert data != null;
                    arr[i][j] = (data.charAt(9 * i + j) - '0');

                }

            }
            return arr;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;

    }

}
