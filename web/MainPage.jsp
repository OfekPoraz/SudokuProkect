<%--
  Created by IntelliJ IDEA.
  User: ofeko
  Date: 26/12/2018
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" language="java" %>
<%@ page import="Model.DataBase" language="java" %>
<% HttpSession session2 = request.getSession();%>
<%  String MySession = session2.toString();
    DataBase dbcon = new DataBase();
    System.out.println(MySession);
    String username = dbcon.UsernameBySession(MySession);
    if(username.equals(""))
        response.sendRedirect("FrontPage.jsp");
        ;%>


<html>
<head>
    <title>MainPage</title>
    <style>
        header {
            display: block;
            position: sticky;
            text-align: center;
            background-image: url("BannerBG3.jpg");
            background-repeat: no-repeat;
            background-size: cover;

        }
        #intro{
            background: rgba(80, 80, 80, 0.4);
            display: block;
            text-align: center;
            line-height: 30px;
        }
        #Menu{
            display: block;
            text-align: center;
        }
        body{
            background-color: gray;
            background-repeat: no-repeat;
            background-size: cover;
            font-family: "Arial Black", Gadget, sans-serif;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            position: sticky;
            top: 0;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111;
        }

        li a:active {
            background-color: #4CAF50;
        }
        li {
            text-align: center;
            border-bottom: 1px solid #555;
        }

        li:last-child {
            border-bottom: none;
        }
        .button {
            display: inline-block;
            border-radius: 4px;
            background: rgba(255, 30, 30, 0.85);
            border: none;
            color: #FFFFFF;
            text-align: center;
            font-size: 28px;
            padding: 20px;
            width: 350px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 5px;

        }

        .button span {
            cursor: pointer;
            display: inline-block;
            position: relative;
            transition: 0.5s;
        }

        .button span:after {
            content: '\00bb';
            position: absolute;
            opacity: 0;
            top: 0;
            right: -20px;
            transition: 0.5s;
        }

        .button:hover span {
            padding-right: 25px;
        }

        .button:hover span:after {
            opacity: 1;
            right: 0;
        }


    </style>
</head>
<body>
<header>
<br><br><br><br><br><br><br><br><br><br>

</header>
<nav>
    <ul>
        <li><a class="active" href="MainPage.jsp">Home</a></li>
        <li><a href="User.jsp">User</a></li>
        <li><a href="Contact.html">Contact</a></li>
    </ul>
</nav>
<section id="intro">
    <h3><b>Welcome to The Ultimate Sudoku, Here you can play Sudoku, Make Sudoku and rate other's Sudokus
    <br>Just select what YOU! want to do</b></h3>
</section>

<section id="Menu">
    <br>
    <br>
    <a href="SudokuGame.jsp" class="button"><span>Play Sudoku</span></a>
    <br>
    <br>
    <a href="CreateSudoku.jsp" class="button"><span>Make Sudoku</span></a>
    <br>
    <br>

    <a href="LoginPage.html" class="button"><span>How to play Sudoku</span></a>
</section>
</body>
</html>
