

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoteMaker
 */
@WebServlet("/NoteMaker")
public class NoteMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("The MySQL JDBC Driver is missing :(");
	         e.printStackTrace();
	         return;
	      }
	      connection = null;
	      //this changes the connection from null to the sql database
	      try {
	          connection = DriverManager.getConnection(url, user, password);
	          connection.setCatalog("techDB"); 
	       } catch (SQLException e) {
	          System.out.println("Connection Failed! Check output console");
	          e.printStackTrace();
	          return;
	       }
	      //as long as the connection isn't null, you can now use it for sql queries
	      if (connection != null) {
	          //response.getWriter().println("Connected to database successfully.<br>");
	       }
	       else {
	          System.out.println("Failed to make connection!");
	       }
	      
	      try {
	    	  String sqlcommand = "Select * from notes";
	    	  PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	  ResultSet rs = prepState.executeQuery();
	    	  //System.out.println(rs);
	    	  while(rs.next()) {
		    	  StringBuilder returnString = new StringBuilder();
		    	  
		    	  returnString.append("<div style=\"border:thin; border-style: solid; border-color: black; \"name= \"" + rs.getString("id") + "\">");
		    	  returnString.append("<button style= \"float:right; margin: 5px;\" onclick=\"deleteNote(this)\">Delete Note</button>");
		    	  returnString.append("<b><font size=5>" + rs.getString("title")+"</font></b><br>");
	    		  returnString.append("<br>" + rs.getString("Summary") + "<br>");
	    		  returnString.append("<br>Time Made: " + rs.getString("made_time"));
		    	  returnString.append("</div><br>");
		    	  response.getWriter().append(returnString);
		    	  
	    	  }
	    	  
	    	  
	      } catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("The MySQL JDBC Driver is missing :(");
	         e.printStackTrace();
	         return;
	      }
	      connection = null;
	      //this changes the connection from null to the sql database
	      try {
	          connection = DriverManager.getConnection(url, user, password);
	          connection.setCatalog("techDB"); 
	       } catch (SQLException e) {
	          System.out.println("Connection Failed! Check output console");
	          e.printStackTrace();
	          return;
	       }
	      //as long as the connection isn't null, you can now use it for sql queries
	      if (connection != null) {
	          //response.getWriter().println("Connected to database successfully.<br>");
	       }
	       else {
	          System.out.println("Failed to make connection!");
	       }

		try {
			String title = request.getParameter("title").trim();
			String text = request.getParameter("summary").trim();

			String sqlcommand = "insert into notes (title, summary, made_time) values ('" + title + "', '" + text + "', now())";
	    	PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	int rs = prepState.executeUpdate();
	    	
	    	doGet(request,response);
			
		} catch(Exception e) {
			System.out.println("error in NoteMaker Post");
			e.printStackTrace();
		}
		
	}

}
