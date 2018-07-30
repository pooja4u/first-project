import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// Import required java libraries
import java.io.*;
import java.util.*;
@WebServlet(name = "ReadParams1", urlPatterns={"/a/d","/servlet/ajoop2/ReadParams1"})
public class ReadParams1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading All Form Parameters";
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
        out.println("</tr>\n</table>\n</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
