package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
        String password = req.getParameter("password");
       
        PrintWriter pw = res.getWriter(); 

        try (Connection connection = Database.getconnection()) {
            String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String name = resultSet.getString("username");
            	String mail = resultSet.getString("email");
            	String pwd = resultSet.getString("password");
            	
            	HttpSession session = req.getSession();
            	session.setAttribute("name",name);
            	session.setAttribute("mail",mail);
            	session.setAttribute("pwd",pwd);
                res.sendRedirect("Welcomepage.jsp");
            } else {
//            	res.setContentType("text/jsp");
                pw.println("<h4 style ='color:red'>Invalid email or password.</h4>");
                req.setAttribute("error", "Invalid email or password. Please try again.");
                req.getRequestDispatcher("loginpage.jsp").forward(req, res);
//                RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
//                rd.include(req, res);
//                res.sendRedirect("loginpage.jsp");
            }
        } catch (SQLException e) {
            res.getWriter().println("Error: " + e.getMessage() + "");
        }
	}

}
