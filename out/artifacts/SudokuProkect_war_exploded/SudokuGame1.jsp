<%--
  Created by IntelliJ IDEA.
  User: ofeko
  Date: 2/15/2019
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.*" %>
<html>
<head>
    <title>SudokuGame1</title>
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
        #Sudoku{
            font-family: "Arial Black", Gadget, sans-serif;
            display: block;
            width: 450px;
            margin-left:auto;
            margin-right:auto;
        }
        table{
            text-align: center;
            position: sticky;
            border: 2px solid black;
            background: rgba(2017, 175, 20, 0.5);
        }
        table.center{
            margin-left:auto;
            margin-right:auto;
        }
        th, td {
            border: 2px solid black;
            width: 50px;
            height: 50px;
        }
        input{
            width: 50px;
            height: 50px;
            border: 2px solid black;
            background: rgba(2017, 175, 20, 0.5);
        }
        body{
            background-color: gray;
            background-repeat: no-repeat;
            background-size: cover;
            font-family: "Arial Black", Gadget, sans-serif;
            text-align: center;
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

<section id="Menu">
    <form action="SelectDifficultyServlet" method="post">
        <select class="button" name="Difficulty">
            <option value="Easy">EASY</option>
            <option value="Medium">MEDIUM</option>
            <option value="Hard">HARD</option>
        </select>
        <button type="submit" class="button">SELECT</button>
    </form>
</section>
<br>
    <% String K = (String) request.getAttribute("K");
    int val = Integer.parseInt(K);
    System.out.println(K);
    SudokuGenerator Sf = new SudokuGenerator(val);
    int[][] SF = Sf.GetSoduko();
    %>
<section id="Sudoku">
    <form action="CheckSudokuServlet" method="post">
    <table class="center">
        <% int n =9;
        for(int s = 0; s<n; s++){
        %>
        <tr>

        <% for(int f=0; f<n; f++)
        {
        %>
        <td><%  int z = SF[s][f];
        if(z==0) {%>
            <%String str = "z[" + String.valueOf(s) + "][" + String.valueOf(f) + "]";
            System.out.println(str);%>
            <input type="number" name = "<%=str%>" min="1" max="9">
            <% } else { %>
            <%=SF[s][f]%>
            <%String str = "z[" + String.valueOf(s) + "][" + String.valueOf(f) + "]";
                System.out.println(str);%>
            <input type="hidden" name = "<%=str%>" value="<%=SF[s][f]%>">
            <%}%>
        </td>
        <% } %>
        </tr>
        <% } %>
    </table>
        <button type="submit" class="button">Check Sudoku</button>
    </form>
</section>

</body>
</html>

