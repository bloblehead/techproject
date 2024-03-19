

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class notes
 */
@WebServlet("/Notes")
public class Notes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Note Maker</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<div style=\"float:right; width: 25%;border:thin;\">\r\n"
						+ "	<b><font size=6>Make Note</font></b><br>\r\n"
						+ "	<form action=\"/somethingfornow\">\r\n"
						+ "		<label for=\"title\">Title: <br/></label>\r\n"
						+ "		<input type=\"text\" id=\"title\" name=\"title\"/><br>\r\n"
						+ "		<label for=\"summary\">Summary: <br/></label>\r\n"
						+ "		<input type=\"text\" style=\"height: 100px\" id=\"text\" name=\"summary\"/><br>\r\n"
						+ "		<input type=\"submit\" value=\"Submit\">\r\n"
						+ "	</form>\r\n"
						+ "</div>\r\n"
						+ "<div style=\"float:left; width: 75%;border:thin;\">\r\n"
						+ "	<b><font size=6>Current Notes</font></b><br>\r\n"
						+ "	<button type=\"button\" onclick=\"loadDoc()\">Request data</button>\r\n"
						+ "\r\n"
						+ "	<p id=\"demo\"></p>\r\n"
						+ "	\r\n"
						+ "	\r\n"
						+ "	<script>\r\n"
						+ "	function loadDoc() {\r\n"
						+ "	  var xhttp = new XMLHttpRequest();\r\n"
						+ "	  xhttp.onreadystatechange = function() {\r\n"
						+ "	    if (this.readyState == 4 && this.status == 200) {\r\n"
						+ "	      document.getElementById(\"demo\").innerHTML = this.responseText;\r\n"
						+ "	    }\r\n"
						+ "	  };\r\n"
						+ "	  xhttp.open(\"GET\", \"NoteMaker.java\", true);\r\n"
						+ "	  xhttp.send();\r\n"
						+ "	}\r\n"
						+ "	</script>\r\n"
						+ "</div>\r\n"
						+ "</body>\r\n"
						+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
