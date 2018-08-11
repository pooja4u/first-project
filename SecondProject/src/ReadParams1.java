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
import java.util.*;
@WebServlet(name = "ReadParams1", urlPatterns={"/a/d","/servlet/ajoop2/ReadParams1"})
public class ReadParams1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/pooja","root", "pooja");

            PreparedStatement pst = con.prepareStatement("insert into event_details values(?,?,?,?,?,?,?,?)");
            pst.setString(1,request.getParameter("e_name"));
            pst.setString(2,request.getParameter("clg_name"));
            pst.setString(3,request.getParameter("ev_date"));
            pst.setString(4,request.getParameter("location"));
            pst.setString(5,request.getParameter("pc_num"));
            pst.setString(6,request.getParameter("org_id"));
            pst.setString(7,request.getParameter("ph_num"));
            pst.setString(8,request.getParameter("ev_cat"));
            int i = pst.executeUpdate();

            if(i!=0){
                out.println("<br>Record has been inserted");
            }
            else{
                out.println("failed to insert the data");
            }
            PreparedStatement pst2 = con.prepareStatement("select * from event_details");
            ResultSet rs=pst2.executeQuery();
            String tableContent = "<html><body><table border=\"1\"><tr><th>Event Name</th><th>College Name</th><th>Event Date</th><th>Location</th><th>Point OF Contact</th><th>Org Email</th><th>Phone Number</th><th>Event Category</th></tr>";
            while (rs.next()){
                tableContent = tableContent +"<td>"+rs.getString("ev_name")+"</td><td>"+rs.getString("clg_name")+"</td><td>"+rs.getString("ev_date")+"</td><td>"+rs.getString("location")+"</td><td>"+rs.getString("p_contact")+"</td><td>"+rs.getString("org_id")+"</td><td>"+rs.getString("ph_num")+"</td><td>"+rs.getString("ev_cat")+"</td></tr>";
            }
            tableContent = tableContent + "</table></body></html>";
            out.print(tableContent);
        }
        catch (Exception e){
            out.println(e);
        }
        /*String title = "Reading All Form Parameters";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>Event Name</th>"+
                "<th>College Name</th>\n"+
                "<th>Event Date</th>\n"+
                "<th>Location</th>\n"+
                "<th>Point of Contact</th>\n"+
                "<th>Orgnizer Email ID</th>\n"+
                "<th>Phone Number </th>\n"+
                "<th>Event Category</th>\n"+
                "</tr>" +
                "<tr>\n" +
                "<th>"+request.getParameter("e_name")+"</th>"+
                "<th>"+request.getParameter("clg_name")+"</th>\n"+
                "<th>"+request.getParameter("ev_date")+"</th>\n"+
                "<th>"+request.getParameter("location")+"</th>\n"+
                "<th>"+request.getParameter("pc_num")+"</th>\n"+
                "<th>"+request.getParameter("org_id")+"</th>\n"+
                "<th>"+request.getParameter("ph_num")+"</th>\n"+
                "<th>"+request.getParameter("ev_cat")+"</th>\n"+
                "</tr>"
        );
        out.println("</tr>\n</table>\n</body></html>");*/
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
