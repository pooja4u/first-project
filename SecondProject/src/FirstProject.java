import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// Import required java libraries
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "FirstProject" , urlPatterns={"/project/data","/ser1/user1"})
public class FirstProject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/pooja", "root", "pooja");
            PreparedStatement pst = con.prepareStatement("insert into FirstProject values(?,?,?)");
            pst.setString(1, request.getParameter("u_name"));
            pst.setString(2, request.getParameter("u_id"));
            pst.setString(3, request.getParameter("u_pass"));
            int i = pst.executeUpdate();

            if (i != 0) {
                out.println("<br>Record has been inserted");
            } else {
                out.println("failed to insert the data");
            }
            PreparedStatement pst2 = con.prepareStatement("select * from FirstProject where u_pass=?");
            pst2.setString(1, request.getParameter("check_pass"));
            ResultSet rs = pst2.executeQuery();
            if (rs.next() == false) {
                out.print("your password is not mached");
            } else {
                out.print("password mached");
                do {

                } while (rs.next());
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
}



