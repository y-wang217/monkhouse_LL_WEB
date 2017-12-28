package document_generation.StatementOfClaim;

import java.util.ArrayList;

import web.DAO.UserDao;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLSection;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class SOCSection extends LLSection{

	private SOCSectionCode sectionCode;
	private ArrayList<LLParagraph> contents;
	public static UserDao dao = new UserDao();
	
	public SOCSectionCode getSectionCodeSOC() {

		return this.sectionCode;
	}
	public void setSectionCode(SOCSectionCode sectionCode) {

		this.sectionCode = sectionCode;
	}
	
	public ArrayList<LLParagraph> getContents(){
		return this.contents;
	}

	public void setContents(ArrayList contents) {
		this.contents = contents;
	}

	public void setSqlSOC(String sectionCode){
		setSelectSql("select section_text,paragraph_num from socsection where section_name = '" + sectionCode + "';");
	}
	
}
