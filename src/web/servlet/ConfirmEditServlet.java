package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.DAO.UserDao;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConfirmEditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
    
    public static HashMap<Integer, String> textEditedMap = new HashMap<>();
    public static String updateSql = "";
    public static boolean isUpdateSuccess = false;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Enumeration<String> params = req.getParameterNames();
//    	while(params.hasMoreElements()){
//    		String param = params.nextElement();
//    		System.out.println(param + " : " + req.getParameter(param));
//    	}
    	

    	String selectedDoc = req.getParameter("doc");
    	String doc = selectedDoc.equals("ll")?"llsection":selectedDoc.equals("soc")?"socsection":null;
    	String selectedSection = req.getParameter("section");
    	int baseParagraphId = Integer.parseInt(UserDao.executeSelect("select min(paragraph_id) from "+doc+" where section_name = '" +selectedSection+ "';").get("result"));
    	String editedParagraphsJson = req.getParameter("changes");

    	JsonElement jelement = new JsonParser().parse(editedParagraphsJson);
        JsonObject  jobject = jelement.getAsJsonObject();
        for(Entry<String, JsonElement> item : jobject.entrySet()){
        	int relativeParagraphId = item.getValue().getAsInt();
        	String newText = item.getKey();
        	textEditedMap.put(relativeParagraphId,newText);
        	
        	int absoluteParagraphId = baseParagraphId+relativeParagraphId;
        	//updateSql = "update " + "paragraph_id #"+ absoluteParagraphId;
        	updateSql = "update llsection set section_text='" + newText + "' where paragraph_id ="+ absoluteParagraphId;
        	isUpdateSuccess = UserDao.execute(updateSql);
        	//System.out.println(item.getKey() + " - " + item.getValue().getAsString());
        }
        
        //TODO: atm using string concat with +=, change to StringBuilder eventually for speed
        
        //System.out.println(updateSql);
    	String json = new Gson().toJson("With changes: "+ textEditedMap +
    			"\nupdate:"+ isUpdateSuccess);

    	resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.close();
    	
    }
    public static void main(String[] args){
    	System.out.print(UserDao.executeSelect("select min(paragraph_id) from llsection where section_name = 'APPROPRIATE_NOTICE_PERIOD';").get("result"));
    }
}
