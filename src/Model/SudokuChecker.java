package Model;


public class SudokuChecker{
    private int N = 9; // Number of Rows and Columns
    private int SQN = 3; // The Square root of N
    private int[][] Matrix;

    public SudokuChecker()
    {
        Matrix = new int[N][N];
        for(int i = 0; i<N;i++)
        {
            for(int j=0; j<N; j++)
            {
                Matrix[i][j]=0;
            }
        }
    }
    public void SetFinalSudoku(int [][] FinalMatrix)
    {
        this.Matrix = FinalMatrix;
    }
    public boolean CheckIfGood()
    {
        int index = 0;
        for(int i = 0; i<N;i++)
        {
            for(int j=0; j<N; j++)
            {
                index++;
                boolean b = !ChecksIfSafe2(i,j,Matrix[i][j]);
                if(b)
                {
                    //System.out.println("NOT GOOD");
                    //System.out.println(i + " " + j);
                    //System.out.println(unUsedInRow2(i,j, Matrix[i][j]));
                    //System.out.println(unUsedInCol2(i,j, Matrix[i][j]));
                    //System.out.println(unUsedInBox2(i,j, Matrix[i][j]));
                    //System.out.println(ChecksIfSafe2(i,j,Matrix[i][j]));
                    return false;
                }
            }
        }
        //System.out.println("GOOD");
        return true;
    }

    private boolean ChecksIfSafe2(int row, int col , int num) {
        return (unUsedInRow2(row,col, num) &&
                unUsedInCol2(row, col, num) &&
                unUsedInBox2(row, col, num));
    }

    private boolean unUsedInCol2(int row, int col, int num) {
        for (int i = 0; i<N; i++)
        {
            if(i!=row)
            {
                if (Matrix[i][col] == num)
                    return false;
            }
        }
        return true;
    }

    private boolean unUsedInRow2(int row,int col, int num) {
        for (int j = 0; j<N; j++)
        {
            if(j!=col)
            {
                if (Matrix[row][j] == num)
                    return false;
            }
        }
        return true;
    }

    private boolean unUsedInBox2(int rowStart, int colStart, int num) {
        for (int i = 0; i < SQN; i++)
            for (int j = 0; j < SQN; j++)
                if(i!=rowStart%SQN&&j!=colStart%SQN)
                {
                    if (Matrix[rowStart-rowStart%SQN + i][colStart-colStart%SQN + j] == num)
                        return false;
                }
        return true;
    }


}