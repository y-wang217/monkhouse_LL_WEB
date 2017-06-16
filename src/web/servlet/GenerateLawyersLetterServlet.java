package web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import document_generation.util.message.ActionMessage;
import document_generation.util.message.MessageType;
import web.action.DocumentAction;

public class GenerateLawyersLetterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	StringBuffer sb = new StringBuffer();
    	Map<String,String[]> params = req.getParameterMap();
    	
    	LinkedHashMap<String, String> paramMap = new LinkedHashMap<>();
    	for(String key: params.keySet()){
    		sb.append("(" + key + ", " + params.get(key)[0] + ")\n");
    		paramMap.put(key, params.get(key)[0]);
    	}
    	
    	for(String key: paramMap.keySet()){
    		System.out.println("(" + key + ", " + paramMap.get(key) + ")");
    	}
    	
    	PrintWriter writer = resp.getWriter();
        writer.print(sb.toString());

        String filePath = "/Users/monkhousemacbook6/Documents/EclipseCreatedFiles/WebCreatedFiles/WebTestDoc.docx";
        ActionMessage docMsg = DocumentAction.createDocument(paramMap,filePath);
        
        if(docMsg.read().toLowerCase().contains("error")){
            req.getSession().setAttribute("document_creation_fail_msg", docMsg.read());
        }

        String uploadURL = "http://localhost:8080/Monkhouse_Letter_Web/UploadDownloadFileServlet";
        File uploadFile1 = new File(filePath);
        String charset = "UTF-8";
        
        try {
            MultipartUtility multipart = new MultipartUtility(uploadURL, charset);
             
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Automatically Generated Document");
             
            multipart.addFilePart("fileUpload", uploadFile1);
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
            
            req.getSession().setAttribute("respPage", response);
            resp.sendRedirect("FileDownload.jsp");
            
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }
    
    public static void main(String[] args){

        String filePath = "/Users/monkhousemacbook6/Documents/EclipseCreatedFiles/WebCreatedFiles/WebTestDoc.docx";
        File uploadFile1 = new File(filePath);
        
        String uploadURL = "http://localhost:8080/Monkhouse_Letter_Web/UploadDownloadFileServlet";
        String charset = "UTF-8";
        
        try {
            MultipartUtility multipart = new MultipartUtility(uploadURL, charset);
             
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Cool Pictures");
            multipart.addFormField("keywords", "Java,upload,Spring");
             
            multipart.addFilePart("fileUpload", uploadFile1);
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
