import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "Result", urlPatterns={"/usr5/data5","/ser5/user5"})
public class Result extends HttpServlet {
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

            PreparedStatement pst2 = con.prepareStatement("select Name, students_table.Roll_no,E_mail,Course,Quize_1,Quize_2,Quize_3,Mid_term,Term_end from students_table inner join java_marks on students_table.Roll_no=java_marks.Roll_no  where students_table.Roll_no=?");
            pst2.setString(1, request.getParameter("roll_num"));
            ResultSet rs = pst2.executeQuery();
            String output ="<html><head><title>Result</title></head><body><table border=\"1\">";
            while (rs.next()){
                output = output +"<tr><td>"+rs.getString("Name")+"</td><td>"+rs.getString("Roll_no")+"</td><td>"+rs.getString("E_mail")+"</td><td>"+rs.getString("Course")+"</td><td>"+rs.getString("Quize_1")+"</td><td>"+rs.getString("Quize_2")+"</td><td>"+rs.getString("Quize_3")+"</td><td>"+rs.getString("Mid_term")+"</td><td>"+rs.getString("Term_end")+"</td></tr>";

            }
            output=output+"</table></body></html>";
            out.print(output);
        } catch (Exception e) {
            out.println(e);
        }
    }
}


