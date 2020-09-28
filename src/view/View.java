package view;

import model.Tile;

public class View {

    public void printBoard(Tile[][] arr){
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 ){
                System.out.println(" __________________________ ");
            }

            for (int j = 0; j <9 ; j++) {
                if (j % 3 == 0 ){
                    System.out.print(" | ");
                }


                System.out.print(arr[i][j].getValue() + " ");



            }

            System.out.println();


        }
        System.out.println(" __________________________ ");



    }
}
