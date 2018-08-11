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

@WebServlet(name = "Student_mngmnt",urlPatterns = {"/std/detail","/std1/detail1"})
public class Student_mngmnt extends HttpServlet {
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

            PreparedStatement pst2 = con.prepareStatement("select student_name.Student_name,student_name.branch_name,student_name.Roll_no,boys_hostel.Room_no from student_name inner join boys_hostel on student_name.Student_name =boys_hostel.Student_name where student_name.Student_name =?");
            pst2.setString(1, request.getParameter("Name"));
            ResultSet rs = pst2.executeQuery();
            String output ="<html><head><title>Result</title></head><body><table border=\"1\">";
            while (rs.next()){
                output = output +"<tr><td>"+rs.getString("Student_name")+"</td><td>"+rs.getString("branch_name")+"</td><td>"+rs.getString("Roll_no")+"</td><td>"+rs.getString("Room_no")+"</td></tr>";

            }
            output=output+"</table></body></html>";
            out.print(output);
        } catch (Exception e) {
            out.println(e);
        }
    }

}
