package Model;


import java.lang.*;

public class SudokuGenerator {
    private int N = 9; // Number of Rows and Columns
    private int SQN = 3; // The Square root of N
    private static int DtR;
    protected int[][] SF; // The Sudoku itself

    public SudokuGenerator(int K)// Constructor
    {
        DtR = K;
        SF = new int[N][N];
        FillSudoku();
    }
    public static void SetDtR(int K){
        DtR=K;
    }
    private int [][] GetFinalSudoku()
    {
        return SF;
    }
    private void SetFinalSudoku(int [][] FinalMatrix)
    {
        this.SF = FinalMatrix;
    }


    private void FillSudoku() // Sudoku generator, filling the values
    {
        FillDiagonal();
        FillTheRest(0, SQN);
        RemoveDigits();
    }

    private void FillDiagonal() {
        for (int i = 0; i < N; i += SQN) {
            FillBox(i, i);
        }
    }

    private void FillBox(int rowStart, int colStart) {
        int num;
        for (int i = 0; i < SQN; i++) {
            for (int j = 0; j < SQN; j++) {
                do {
                    num = randomGenerator(N);
                } while (!unUsedInBox(rowStart, colStart, num));

                SF[rowStart + i][colStart + j] = num;
            }
        }
    }

    private boolean ChecksIfSafe(int row, int col , int num) {
        return (unUsedInRow(row, num) &&
                unUsedInCol(col, num) &&
                unUsedInBox(row-row%SQN, col-col%SQN, num));
    }


    private boolean unUsedInCol(int col, int num) {
        for (int i = 0; i<N; i++)
        {
            if (SF[i][col] == num)
                return false;
        }
        return true;
    }

    private boolean unUsedInRow(int row, int num) {
        for (int j = 0; j<N; j++)
        {
            if (SF[row][j] == num)
                return false;
        }
        return true;
    }

    private boolean unUsedInBox(int rowStart, int colStart, int num) {
        for (int i = 0; i < SQN; i++)
            for (int j = 0; j < SQN; j++)
                if (SF[rowStart + i][colStart + j] == num)
                    return false;
        return true;
    }

    private int randomGenerator(int num) {
        return (int) Math.floor((Math.random() * num + 1));
    }

    private boolean FillTheRest(int i, int j) {
        //  System.out.println(i+" "+j);
        if (j>=N && i<N-1)
        {
            i = i + 1;
            j = 0;
        }
        if (i>=N && j>=N)
            return true;

        if (i < SQN)
        {
            if (j < SQN)
                j = SQN;
        }
        else if (i < N-SQN)
        {
            if (j==(int)(i/SQN)*SQN)
                j =  j + SQN;
        }
        else
        {
            if (j == N-SQN)
            {
                i = i + 1;
                j = 0;
                if (i>=N)
                    return true;
            }
        }

        for (int num = 1; num<=N; num++)
        {
            if (ChecksIfSafe(i, j, num))
            {
                SF[i][j] = num;
                if (FillTheRest(i, j+1))
                    return true;

                SF[i][j] = 0;
            }
        }
        return false;
    }
    public void printSudoku()
    {
        for (int i = 0; i<N; i++)
        {
            for (int j = 0; j<N; j++)
                System.out.print(SF[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private void RemoveDigits() {
        int[][] RememberArray = new int[2][DtR];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<DtR;j++)
            {
                RememberArray[i][j]=10;
            }
        }
        for(int i =0; i<DtR;i++)
        {
            int a = randomGenerator(9);
            int b = randomGenerator(9);
            if(a-1!=RememberArray[0][i]&&b-1!=RememberArray[1][i])
            {
                RememberArray[0][i] = a-1;
                RememberArray[1][i] = b-1;
                SF[a-1][b-1] = 0;
            }
        }
    }

    public int[][] GetSoduko() {
        return SF;
    }
}