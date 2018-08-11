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

@WebServlet(name = "Add_insert",urlPatterns = {"/p2/r2" , "/p3/r3"})
public class Add_insert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/pooja","root", "pooja");

            PreparedStatement pst = con.prepareStatement("insert into clg_sudent values(?,?,?,?)");
            pst.setString(1,request.getParameter("Name"));
            pst.setString(2,request.getParameter("Roll_no"));
            pst.setString(3,request.getParameter("Branch"));
            pst.setString(4,request.getParameter("Year"));

            int i = pst.executeUpdate();

            if(i!=0){
                out.println("<br>Record has been inserted");
            }
            else{
                out.println("failed to insert the data");
            }
            PreparedStatement pst2 = con.prepareStatement("select * from clg_sudent");
            ResultSet rs=pst2.executeQuery();
            String tableContent = "<html><body><table border=\"1\"><tr><th> Name</th><th>Roll_no</th><th>Branch</th><th>Year</th></tr>";
            while (rs.next()){
                tableContent = tableContent +"<td>"+rs.getString("Name")+"</td><td>"+rs.getString("Roll_no")+"</td><td>"+rs.getString("Branch")+"</td><td>"+rs.getString("year")+"</td></tr>";
            }
            tableContent = tableContent + "</table></body></html>";
            out.print(tableContent);
        }
        catch (Exception e){
            out.println(e);
        }
    }

}