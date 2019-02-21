package View;

import Model.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        DataBase dbcon = new DataBase();
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("Username").toString();
        String password = request.getParameter("Password").toString();
        boolean b = dbcon.loginUser(userName, password);
        if(b)
        {
            try {
                dbcon.LoginSession(session.toString(), userName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("MainPage.jsp");
        }
        else
        {
            response.sendRedirect("LoginFail.html");
        }




        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
