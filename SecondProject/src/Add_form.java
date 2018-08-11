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

@WebServlet(name = "Add_form",urlPatterns = {"/p/r" , "/p1/r1"})
public class Add_form extends HttpServlet {
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

            PreparedStatement pst2 = con.prepareStatement("select clg_sudent.Name ,clg_sudent.Branch ,clg_sudent.year , web_marks.Qz_1 ,web_marks.Qz_2 ,web_marks.Mid_term ,web_marks.End_term ,network_marks.Qz_1 ,network_marks.Qz_2 ,network_marks.Mid_term ,network_marks.End_term ,crypto_marks.Qz_1 ,crypto_marks.Qz_2 ,crypto_marks.Mid_term ,crypto_marks.End_term from clg_sudent inner join web_marks on clg_sudent.Roll_no = web_marks.Roll_no inner join network_marks on clg_sudent.Roll_no = network_marks.Roll_no inner join crypto_marks on clg_sudent.Roll_no=crypto_marks.Roll_no where clg_sudent.Roll_no =?");
            pst2.setString(1, request.getParameter("Roll_no"));
            ResultSet rs = pst2.executeQuery();
            String output = "<html><head><title>Result</title></head><body><table border=\"1\">";
            while (rs.next()) {
                output = output + "<tr><td>" + rs.getString("Name") + "</td><td>" + rs.getString("Branch") + "</td><td>" + rs.getString("year") + "</td><td>" + rs.getString("Qz_1") + "</td><td>" + rs.getString("Qz_2") + "</td><td>" + rs.getString("Mid_term") +  "</td><td>" + rs.getString("End_term") +"</td></tr>";

            }
            output = output + "</table></body></html>";
            out.print(output);
        } catch (Exception e) {
            out.println(e);
        }
    }

}

