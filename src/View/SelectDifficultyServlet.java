package View;
import Model.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectDifficultyServlet",urlPatterns = "/SelectDifficultyServlet")
public class SelectDifficultyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            response.setContentType("text/html;charset=UTF-8");
            String Diff = request.getParameter("Difficulty").toString();
            String K = "";
            SudokuCheckFunction scf = new SudokuCheckFunction(request, response);
            scf.ChooseK(K);
            request.getRequestDispatcher("SudokuGame1.jsp").forward(request, response);
            response.sendRedirect("SudokuGame1.jsp");

        }
        catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("FrontPage.jsp");
            return;
        } finally {
            out.close();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
