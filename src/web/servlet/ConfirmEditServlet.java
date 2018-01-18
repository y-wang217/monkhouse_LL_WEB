package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ConfirmEditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Enumeration<String> params = req.getParameterNames();
    	while(params.hasMoreElements()){
    		System.out.println(params.nextElement());
    	}
    	

    	String json = new Gson().toJson("received");

    	resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.close();;
    	
    }
}
