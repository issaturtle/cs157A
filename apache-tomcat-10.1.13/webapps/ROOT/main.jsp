<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game Store</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body class="main">
    <%
        if (session.getAttribute("loggedIn") == null || !((boolean) session.getAttribute("loggedIn"))) {
            response.sendRedirect("login.jsp");
        }
    %>
    <div class="navbar">
        <ul>
            <li><a href="/homepage.jsp">Home</a></li>
            <li><a href="/main.jsp">Games</a></li>
        </ul>
        <ul>
            <li><a href="/logout.jsp"><%= session.getAttribute("username") %></a></li>
            <li><a href="/logout.jsp">Logout</a></li>
        </ul>

    </div>
    <div class="intro">
        <h1>Game Store</h1>
        <div class="search-bar">
            <form action="/search.jsp" method="get">
                <input type="text" name="search" placeholder="Search...">
                <button type="submit">Search</button>
            </form>
        </div>
    </div>


    <div class="game-grid">
        <%
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepickerdb?autoReconnect=true&useSSL=false", user, password);

            stmt = con.createStatement();
            String query = "SELECT game.*, genre.GenreName, genre.Description, min(currentprice.amount) " +
               "FROM game " +
               "JOIN genre ON game.GenreID = genre.GenreID " +
               "JOIN currentprice ON game.gameid = currentprice.gameid " +
               "GROUP BY game.gameid";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
        %>
        <div class="game-item">
            <img class="game-image" src="<%= rs.getString("Link") %>" alt="<%= rs.getString("GameName") %>">
            <br>
            <a href="searchedGame.jsp?gameName=<%= rs.getString("GameName") %>"><%= rs.getString("GameName") %></a>
            <br>
            Price: $<%= rs.getString("min(currentprice.amount)") %>
        </div>
        <%
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
            e.printStackTrace();
        }
        %>
    </div>
</body>
</html>