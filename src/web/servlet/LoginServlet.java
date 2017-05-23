package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String username = (String) req.getParameter("username");
    	String password = (String) req.getParameter("password");
    	String output = "Java received username: " + username + " and password "+ password;
    	System.out.println(output);
    	
    	PrintWriter writer = resp.getWriter();
        writer.print(output);
      //check if username and password are not null
        if(username.equals("")){
            req.getSession().setAttribute("login_fail_msg", "username empty, please enter username.");
            resp.sendRedirect("/Monkhouse_Letter_Web/");

        } else if(password.equals("")){
            req.getSession().setAttribute("login_fail_msg", "password empty, please enter password.");
            resp.sendRedirect("/Monkhouse_Letter_Web/");

        }
        
        
        //make call to login(username,password)
        //if( login.Success )
        {
            req.getSession().setAttribute("UserName", username);
        	resp.sendRedirect("main.jsp");
        }
    }
}
