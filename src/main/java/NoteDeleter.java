

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoteDeleter
 */
@WebServlet("/NoteDeleter")
public class NoteDeleter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteDeleter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("delete get reached");
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("The MySQL JDBC Driver is missing :(");
	         e.printStackTrace();
	         return;
	      }
	      connection = null;
	      try {
	          connection = DriverManager.getConnection(url, user, password);
	          connection.setCatalog("techDB"); 
	       } catch (SQLException e) {
	          System.out.println("Connection Failed! Check output console");
	          e.printStackTrace();
	          return;
	       }
	      if (connection != null) {
	          //response.getWriter().println("Connected to database successfully.<br>");
	       }
	       else {
	          System.out.println("Failed to make connection!");
	       }
	      try {
	    	  String id = request.getParameter("id");
	    	  //System.out.println("id: "+id);
	    	  String sqlcommand = "delete from notes where id = "+ id;
	    	  PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	  int rs = prepState.executeUpdate();
	    	  
	    	  
	    	  
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
		doGet(request, response);
	}

}
