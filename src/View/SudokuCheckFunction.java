package View;

import Model.SudokuChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SudokuCheckFunction {
    PrintWriter out;
    HttpServletRequest request;
    HttpServletResponse response;
    SudokuCheckFunction(HttpServletRequest request, HttpServletResponse response)
        {
        this.request = request;
        this.response = response;
    }
    public boolean IsGood() {
        int[][] sudokutable = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokutable[i][j] = Integer.parseInt(this.request.getParameter("z[" + i + "][" + j + "]"));
                System.out.println(sudokutable[i][j]);
            }
        }
        SudokuChecker checkme = new SudokuChecker();
        checkme.SetFinalSudoku(sudokutable);
        return checkme.CheckIfGood();
    }
    public void ChooseK(String K)
    {
        String Diff = request.getParameter("Difficulty").toString();
        if (Diff.toString().equals("Easy")){
            K = "20";
        }
        if (Diff.toString().equals("Medium")){
            K = "35";

        }
        if (Diff.toString().equals("Hard")) {
            K = "50";

        }
        request.setAttribute("K", K);
    }
}
