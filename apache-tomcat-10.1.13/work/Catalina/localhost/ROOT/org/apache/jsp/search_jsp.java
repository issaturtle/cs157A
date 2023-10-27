/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.13
 * Generated at: 2023-10-27 09:12:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Game Store</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/main.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"main\">\r\n");
      out.write("    ");

        if (session.getAttribute("loggedIn") == null || !((boolean) session.getAttribute("loggedIn"))) {
            response.sendRedirect("login.jsp");
        }
    
      out.write("\r\n");
      out.write("    <p>Welcome, ");
      out.print( session.getAttribute("username") );
      out.write("!</p>\r\n");
      out.write("    <div class=\"navbar\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"/homepage.jsp\">Home</a></li>\r\n");
      out.write("            <li><a href=\"/main.jsp\">Games</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"/logout.jsp\">");
      out.print( session.getAttribute("username") );
      out.write("</a></li>\r\n");
      out.write("            <li><a href=\"/logout.jsp\">Logout</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"intro\">\r\n");
      out.write("        <h1>Game Store</h1>\r\n");
      out.write("        <div class=\"search-bar\">\r\n");
      out.write("            <form action=\"/search.jsp\" method=\"get\">\r\n");
      out.write("                <input type=\"text\" name=\"search\" placeholder=\"Search...\">\r\n");
      out.write("                <button type=\"submit\">Search</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"game-grid\">\r\n");
      out.write("        ");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String user = "root";
        String password = "Hunggo881224!";

        String gametitle = request.getParameter("search");
        if (gametitle == null) {
            gametitle = "";
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepickerdb?autoReconnect=true&useSSL=false", user, password);
            stmt = con.createStatement();
            String query = "SELECT game.*, genre.GenreName, genre.Description, MIN(currentprice.amount) " +
            "FROM game " +
            "JOIN genre ON game.GenreID = genre.GenreID " +
            "JOIN currentprice ON game.gameid = currentprice.gameid " +
            "WHERE (game.GameName LIKE ? OR genre.GenreName LIKE ?) " +
            "GROUP BY game.gameid";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "%" + gametitle + "%"); // Set the value of the parameter
            pstmt.setString(2, "%" + gametitle + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
        
      out.write("\r\n");
      out.write("        <div class=\"game-item\">\r\n");
      out.write("            <img class=\"game-image\" src=\"");
      out.print( rs.getString("Link") );
      out.write("\" alt=\"");
      out.print( rs.getString("GameName") );
      out.write("\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"searchedGame.jsp?gameName=");
      out.print( rs.getString("GameName") );
      out.write('"');
      out.write('>');
      out.print( rs.getString("GameName") );
      out.write("</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            Price: $");
      out.print( rs.getString("min(currentprice.amount)") );
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        ");

            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
            e.printStackTrace();
        }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
