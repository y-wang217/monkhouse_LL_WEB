package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.LLSectionFactory;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.StatementOfClaim.SOCDocument;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.SOCSectionFactory;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class EditContentServlet extends HttpServlet{

	static LLSectionFactory llsf = new LLSectionFactory();
	static SOCSectionFactory socsf = new SOCSectionFactory();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ArrayList<String> sectionContent = new ArrayList<>();
    	Enumeration<String> params = req.getParameterNames();
    	while(params.hasMoreElements()){
    		System.out.println(params.nextElement());
    	}
    	System.out.println(params);
    	String selectedDoc = req.getParameter("doc");
    	String selectedSection = req.getParameter("section");
    	
    	
    	if(selectedDoc.equals("ll")){
    		LLSectionCode code = LLSectionCode.valueOf(selectedSection);
    		LLSection sec = llsf.getSection(new LLDocument(), code);
    		
    		for(LLParagraph p : sec.getContents()){
        		sectionContent.add(p.getText());
    		}
    		
    	}if(selectedDoc.equals("soc")){
    		SOCSectionCode code = SOCSectionCode.valueOf(selectedSection);
    		SOCSection sec = socsf.getSection(new SOCDocument(), code);
    		
    		for(LLParagraph p : sec.getContents()){
        		sectionContent.add(p.getText());
    		}
    	}
    	
    	String json = new Gson().toJson(sectionContent);
    	
    	resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ArrayList<String> sectionContentInput = new ArrayList<String>();
    	
        super.doPost(req, resp);
    }
}
