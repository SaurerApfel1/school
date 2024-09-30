package Privat.Game;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("<<TicTacToe>>");

        String[][] Feld = 	{
                {"0","0","0"},
                {"0","0","0"},
                {"0","0","0"}
        };



        for (String[] place : Feld) {
            System.out.println();
            for (String s : place) {
                System.out.print(s + " ");
            }
        }
    }
}
