package Model;
import java.sql.*;
import java.util.Date;
import java.time.LocalDate;


public class DataBase {

    private Connection con1;
    private Connection con2;
    private Connection con3;
    private Statement st1;
    private ResultSet rs1;

    public DataBase() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudokudb", "root", "");
            st1 = con1.createStatement();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public int RegisterUser(String username, String firstname, String lastname, String password, String email, String country) {
        try {
            PreparedStatement query = con1.prepareStatement("insert into users (username, firstname, lastname,  email, password, country) VALUES (?, ?, ?, ?, ?, ?)");
            query.setString(1, username);
            query.setString(2, firstname);
            query.setString(3, lastname);
            query.setString(4, email);
            query.setString(5, password);
            query.setString(6, country);

            query.executeUpdate();
            return 0;

        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) {
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        }
    }

    public boolean loginUser(String Username, String password) {


        try {
            PreparedStatement query = con1.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            query.setString(1, Username);
            query.setString(2, password);

            rs1 = query.executeQuery();

            return rs1.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void LoginSession(String session, String username) throws SQLException {
        try {
            PreparedStatement query = con1.prepareStatement("insert into sessionid (session, username) VALUES (?, ?)");
            query.setString(1, session);
            query.setString(2, username);

            query.executeUpdate();
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
            String b = "\'";
            username = b + username + b;
            session = b + session + b;
            String sql = "UPDATE sessionid SET username = " + username + " WHERE session = " + session;
            PreparedStatement query = con1.prepareStatement(sql);
            query.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }

    public String UsernameBySession(String session2) {

        try {
            //PreparedStatement query = con1.prepareStatement("SELECT username FROM sessionid WHERE session = ?");
            //query.setString(1,session);

            //rs2 = query.executeQuery(q);
            //String username = rs2.getString("username");
            //return username;
            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudokudb", "root", "");
            Statement stmt = con2.createStatement();
            String b = "\'";
            session2 = b + session2 + b;
            String sql = "SELECT username FROM sessionid WHERE session = " + session2;
            ResultSet rs2 = stmt.executeQuery(sql);
            String username = "";
            while (rs2.next()) {
                username = rs2.getString("username");
                System.out.println(username);
            }
            return username;
        } catch (SQLException e) {
            e.printStackTrace();
            return "false";
        }
    }
    public String[] LoadUser (String username){

        try {
            con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudokudb", "root", "");
            Statement stmt = con3.createStatement();
            String b = "\'";
            username = b + username + b;
            String sql = "SELECT * FROM users WHERE username = " + username;
            ResultSet rs3 = stmt.executeQuery(sql);
            String firstname = "";
            String lastname = "";
            String password = "";
            String email = "";
            String country = "";
            while (rs3.next()) {
                firstname = rs3.getString("firstname");
                lastname = rs3.getString("lastname");
                password = rs3.getString("password");
                email = rs3.getString("email");
                country = rs3.getString("country");
                System.out.println(username);
            }
            String[] returnedarr = new String[5];
            returnedarr[0] = firstname;
            returnedarr[1] = lastname;
            returnedarr[2] = password;
            returnedarr[3] = email;
            returnedarr[4] = country;
            return returnedarr;
        } catch (SQLException e) {
            e.printStackTrace();
            String[] faslearray = new String[1];
            faslearray[0] = "false";
            return faslearray;
        }
    }
}


