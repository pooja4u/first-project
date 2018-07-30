import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "HelloForm", urlPatterns={"/a/b","/servlet/ajoop"})
public class HelloForm extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        String output=
        docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<form>\n"+
                "EVENT NAME <br>\n"+
         "<input type=\"text\" placeholder=\"Enter Event Name\" size =\"100\" >" +"<br><br><br>"+
                "COLLEGE NAME "+ "&emsp;&emsp;&emsp;&emsp;&emsp;"+"EVENT DATE\n<br>"+
         "<input type=\"text\" placeholder=\"Enter College Name \">"+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ "<input type=\"date\" placeholder=\"mm/dd/yy\">" +"<br/><br/></br>"+
                "LOCATION "+ "&emsp;&emsp;&emsp;&emsp;&emsp;"+"POINT OF CONTACT NAME\n<br>"+
                "<input type=\"text\" placeholder=\"Location Of Event \">"+"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+ "<input type=\"text\" placeholder=\"Enter Full Name\">" +"<br><br><br>"+
                "Organizer Email ID <br>\n"+
                "<input type=\"email\" placeholder=\"Enter Email id\">" + "size =\"600\"<br><br><br>"+
                "PHONE NUMBER "+ "&emsp;&emsp;&emsp;&emsp;&emsp;"+"EVENT CATEGORY\n<br>"+
                "<input type=\"text\" placeholder=\"Official Contact Number \">"+"&emsp;&emsp;&emsp;&emsp;&emsp;"+ "<select name = \"dropdown\">\n" +
                " <option value = \"Data Structures\" selected>Data Structures</option>\n" +
                " <option value = \"Data Mining\">Data Mining</option>\n" +
                "</select>\n" +"<br><br><br>"+
         /*"<input type=\"radio\" name=\"gender\" value=\"female\">"  + "Female <br>"+
         "<input type=\"radio\" name=\"gender\" value=\"other\"> Other" + "</br>"+
                "<input type=\"checkbox\" name=\"vehicle\" value=\"Bike\">" + "I have a bike <br>"+
         "<input type=\"checkbox\" name=\"vehicle\" value=\"Car\" checked>" + "I have a car<br>"+
         "<input type=\"submit\" value=\"Submit\">" +*/
         "</form>" +

               /* "<center><table border=2><tr><th>First Name</th><th>Last Name</th><th>Age</th><th>Email</th></tr><tr><th>"+request.getParameter("first_name")+"</th><th>"+request.getParameter("last_name")+"</th><th>"+request.getParameter("Age")+"</th><th>"+request.getParameter("Email")+"</th></tr>";
        String html2="";
        for(int i=2;i<10;i++){
            html2=html2+"<tr>";
            for(int j=1;j<5;j++){
                html2=html2+"<th>"+(j*i)+"</th>";
            }
            html2=html2+"</tr>";
        }
        html2=html2+"</table></center>" + */
                "</body>" +
                "</html>";
                out.print(output);
    }
}
