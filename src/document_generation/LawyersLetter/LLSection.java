package document_generation.LawyersLetter;

import document_generation.LawyersLetter.Codes.ParaCode;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.LawyersLetter.Paragraphs.ImageParagraph;

import java.util.ArrayList;
import java.util.HashMap;

import web.DAO.UserDao;

/**
 * Created by Yale Wang
 *
 * note: contents stores paragraphs in an Arraylist
 */
public class LLSection {

	public static UserDao dao = new UserDao();
	private String selectSql = "";

	public void setSql(String sectionCode) {
		setSelectSql("select section_text,paragraph_num from llsection where section_name = '"
				+ sectionCode + "';");
	}

	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

	public String getSelectSql() {
		return selectSql;
	}

	public void insertText(LLParagraphFactory llpf, LLDocument doc,
			ArrayList<LLParagraph> content, ParaCode type, String textInPara) {
		if (type == ParaCode.IMAGE) {
			content.add(new ImageParagraph(doc, textInPara));
			return;
		}
		LLParagraph llParagraph = llpf.getParagraph(doc, type);
		llParagraph.setText(textInPara);
		content.add(llParagraph);
		return;
		// return llParagraph;
	}

	public void insertText(LLParagraphFactory llpf, LLDocument doc,
			ArrayList<LLParagraph> content, ParaCode type, String textInPara,
			boolean italics) {

		if (type == ParaCode.IMAGE) {
			content.add(new ImageParagraph(doc, textInPara));
			return;
		}
		LLParagraph llParagraph = llpf.getParagraph(doc, type);
		llParagraph.setText(textInPara);
		content.add(llParagraph);
		return;
		// return llParagraph;
	}

	private ArrayList<LLParagraph> contents;
	private LLSectionCode sectionCode;
	private HashMap<String, String> headings;

	public HashMap<String, String> getHeadings() {

		return headings;
	}

	public HashMap<String, String> getHeadings(int sectionId) {

		String headingsSql = "select heading_id, heading_text from headings where section_id = '"
				+ sectionId + "';";
		HashMap<String, String> headings = UserDao.executeSelect(headingsSql);

		return headings;
	}

	public void setHeadings(HashMap<String, String> headings) {
		this.headings = headings;
	}

	public LLSectionCode getSectionCode() {

		return sectionCode;
	}

	public void setSectionCode(LLSectionCode sectionCode) {

		this.sectionCode = sectionCode;
	}

	public void setContents(ArrayList contents) {

		this.contents = contents;
	}

	public ArrayList<LLParagraph> getContents() {

		return contents;
	}

	public static void main(String[] argv) {
		LLSection test = new LLSection();
		HashMap<String, String> heads = test.getHeadings(1);
		for (String key : heads.keySet()) {
			System.out.println(key + " : " + heads.get(key));
		}
	}
}
