<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <form action="login.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required /><br /><br />
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br /><br />
        <input type="submit" value="Login" />
    </form>

    <%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String dbUser = "root";
    String dbPassword = "Hunggo881224!";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepickerdb?autoReconnect=true&useSSL=false", dbUser, dbPassword);

        String query = "SELECT * FROM users WHERE username = ?"; // Changed table name and SQL query
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, username); // Set the value of the parameter without wildcard
        rs = pstmt.executeQuery(); // Use pstmt for execution

        if (rs.next()) {
            String storedPassword = rs.getString("password");
            if (storedPassword.equals(password)) {
                out.println("<p>Login successful!</p>");
                // Redirect to the main.jsp page
                session.setAttribute("loggedIn", true);
                session.setAttribute("username", username);
                response.sendRedirect("main.jsp");
            } else {
                out.println("<p>Login failed. Please check your username and password.</p>");
            }
        } else {
            out.println("<p>Login failed. User not found.</p>");
        }
        rs.close();
        pstmt.close();
        con.close();
    } catch (SQLException e) {
        out.println("SQLException caught: " + e.getMessage());
        e.printStackTrace();
    } 
    %>
</body>
</html>