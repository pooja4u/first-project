import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseAccess extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // JDBC driver name and database URL
         final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
         final String DB_URL="jdbc:mysql://localhost/pooja";

        //  Database credentials
         final String USER = "root";
         final String PASS = "pooja";


        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";

        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n");
        try {
            // Register JDBC driver
            out.println("1");
            Class.forName("com.mysql.jdbc.Driver");
            out.println("2");
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            out.println("3");
            // Execute SQL query
            Statement stmt = conn.createStatement();
            out.println("4");
            String sql;
            sql = "SELECT cname, email, mobile FROM table1";
            ResultSet rs = stmt.executeQuery(sql);
            out.println("5");
            // Extract data from result set
            while(rs.next()){
                out.println("6");
                //Retrieve by column name
                String name  = rs.getString("cname");

                String email = rs.getString("email");
                String mobile = rs.getString("mobile");

                //Display values
                out.println("Name: " + name + "<br>");
                out.println(", Email: " + email + "<br>");
                out.println(", Mobile: " + mobile + "<br>");
            }
            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}