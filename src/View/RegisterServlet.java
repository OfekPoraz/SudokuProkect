package View;
import Model.DataBase;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {

            DataBase dbcon = new DataBase();

            response.setContentType("text/html;charset=UTF-8");
            String Fname = request.getParameter("Fname").toString();
            String Lname = request.getParameter("Lname").toString();
            String username = request.getParameter("username").toString();
            String Pw = request.getParameter("Pw").toString();
            String Rpw = request.getParameter("Rpw").toString();
            String email = request.getParameter("email").toString();
            String Country = request.getParameter("Country").toString();
            System.out.println("bla2");
            if (!(Pw.toString().equals(Rpw.toString()))) {
                System.out.println("bla1");
                System.out.println(Pw);
                System.out.println(Rpw);
                response.sendRedirect("RegisterFail.html");
            } else {
                int worked = dbcon.RegisterUser(username, Fname, Lname, Pw, email, Country);
                if (worked == 1)
                {
                    response.sendRedirect("RegisterFail.html");
                }
                else {
                    response.sendRedirect("FrontPage.html");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("FrontPage.html");
            return;
        } finally {
            out.close();
        }
    }
}