package Model;


import java.util.Scanner;

public class Game {
    int Level;
    Game(int l)
    {
        this.Level = l;
    }
    public void Play()
    {
        SudokuGenerator Sudoku = new SudokuGenerator(Level);
        Sudoku.printSudoku();

        System.out.println("Insert row");
        Scanner s = new Scanner(System.in);

        int row = s.nextInt();
        System.out.println("Insert col");
        int col = s.nextInt();
        System.out.println("Insert num");
        int num = s.nextInt();

        Sudoku.SF[row][col] = num;
        Sudoku.printSudoku();
        SudokuChecker SC = new SudokuChecker();
        SC.SetFinalSudoku(Sudoku.SF);
        SC.CheckIfGood();

    }
}
