package backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password1 = req.getParameter("password");
        String password = password1;
        int l = password.length();
        if(l<9) {
        	req.setAttribute("error", "Password should contain atleast 9 characters");
            req.getRequestDispatcher("signup_page.jsp").forward(req, res);
            return;
            
        }
        else
        {
     	   char ch1 = password.charAt(0);
     	   if(!(ch1>='A' && ch1<='Z'))
     	   {
     		  req.setAttribute("error", "Invalid password. Please try again.");
              req.getRequestDispatcher("signup_page.jsp").forward(req, res);
              return;
     	   }
     	   else
     	   {
     		   int i;
     		   int sm = 0, cap=0, dig=0, sp=0;
     		   for(i=0;i<9;i++)
     		   {
     			   char ch = password.charAt(i);
     			   if(ch>='0' && ch<='9')
     				   dig++;
     			   else if(ch>='a' && ch<='z')
     				   sm++;
     			   else if(ch>='A' && ch<='Z')
     				   cap++;
     			   else  if(ch!=' ')
     				   sp++;
     			   else
     				   break;
     		   }
     		   if(dig !=0 && cap!=0 && sm!=0 && sp!=0 && i==9)
     		   {
     			  try (Connection con = Database.getconnection()) {
     		            String sql = "INSERT INTO user (username, email, password) VALUES (?, ?, ?)";
     		            PreparedStatement statement = con.prepareStatement(sql);
     		            statement.setString(1, username);
     		            statement.setString(2, email);
     		            statement.setString(3, password);

     		            int result = statement.executeUpdate();
     		            if (result > 0) {
     		            	
     		                res.sendRedirect("loginpage.jsp");
     		            } else {
     		                res.getWriter().println("Registration failed.");
     		            }
     		        } catch (SQLException e) {
     		        	String s = e.getMessage();
     		            res.getWriter().println("Error: " + e.getMessage() + "");
//     		           req.setAttribute("error", "s");
     		            
     		        }
     		   }
     	   }
        }
      

        
	}

}
