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
import web.action.LLDocumentAction;
import web.action.SOCDocumentAction;

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

        String filePath = "/Users/monkhousemacbook6/Documents/EclipseCreatedFiles/WebCreatedFiles/WebTestLL.docx";
        ActionMessage docMsg = LLDocumentAction.createDocument(paramMap,filePath);
        String filePath2 = "/Users/monkhousemacbook6/Documents/EclipseCreatedFiles/WebCreatedFiles/WebTestSOC.docx";
        ActionMessage docMsg2 = SOCDocumentAction.createDocument(paramMap,filePath2);
        
        if(docMsg.read().toLowerCase().contains("error")){
            req.getSession().setAttribute("document_creation_fail_msg", docMsg.read());
        }
        if(docMsg2.read().toLowerCase().contains("error")){
            req.getSession().setAttribute("document_creation_fail_msg", docMsg2.read());
        }

        String uploadURL = "http://localhost:8080/Monkhouse_Letter_Web/UploadDownloadFileServlet";
        File uploadFile1 = new File(filePath);
        File uploadFile2 = new File(filePath2);
        
        String charset = "UTF-8";
        
        try {
            MultipartUtility multipart = new MultipartUtility(uploadURL, charset);
             
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Automatically Generated Document");
             
            multipart.addFilePart("fileUpload", uploadFile1);
            multipart.addFilePart("fileUpload", uploadFile2);
 
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
