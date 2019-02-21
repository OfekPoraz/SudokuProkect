package View;

import Model.DataBase;
import org.omg.CORBA.SystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Model.SudokuChecker;

@WebServlet(name = "CheckSudokuServlet",urlPatterns = "/CheckSudokuServlet")
public class CheckSudokuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            SudokuCheckFunction scf = new SudokuCheckFunction(request,response);
            System.out.println(scf.IsGood());
            response.setContentType("text/html;charset=UTF-8");

        }
        catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("FrontPage.html");
            return;
        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
