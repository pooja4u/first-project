import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Ajp" , urlPatterns={"/a/e","/servlet/ajoop3/Ajp"})
public class Ajp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Hello ";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>"+
                "<head><title>"+title+"</head></title>"+
                "<body bgcolor=\"green\">"+
                "<table border=\"1\">"+
                "<tr><td>My Name</td>"+
                "<td>My Class</td></tr>"+ "<tr><td>"+request.getParameter("My_name")+"</td>"+
                "<td>"+request.getParameter("My_class")+"</td>"+
                "</tr></table></body></html>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       doGet(request,response);

    }
}
