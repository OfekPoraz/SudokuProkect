<%--
  Created by IntelliJ IDEA.
  User: ofeko
  Date: 26/12/2018
  Time: 14:21
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
    String[] details = dbcon.LoadUser(username);%>


<html>
<head>
    <title>User</title>
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
            width: 200px;
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
<!-- User's information page -->
<h3> hello <%= username %> <br> Here Is Your Details :
    <br>First Name - <%= details[0] %> <br>Last Name - <%= details[1] %> <br>
    Password - <%= details[2] %> <br>Email - <%= details[3] %> <br>Country - <%= details[4] %> <br> </h3>


<form action="MainPage.jsp">
    <button class="button" type="submit"> Back to Menu </button>
</form>

</body>
</html>
