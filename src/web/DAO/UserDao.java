package web.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import document_generation.LawyersLetter.LLDocument;
import document_generation.LawyersLetter.LLParagraph;
import document_generation.LawyersLetter.LLSection;
import document_generation.LawyersLetter.LLSectionFactory;
import document_generation.LawyersLetter.Codes.LLSectionCode;
import document_generation.StatementOfClaim.SOCDocument;
import document_generation.StatementOfClaim.SOCSection;
import document_generation.StatementOfClaim.SOCSectionFactory;
import document_generation.StatementOfClaim.Sections.Codes.SOCSectionCode;

public class UserDao {
	private static String MySQLHostname = "monkhouse-test.crzdgvf9qkzn.us-east-2.rds.amazonaws.com";
	private static String MySQLUsername = "monkhouse";
	private static String MySQLPassword = "december2";
	public static boolean execute(String sql) {

		// String sql2 =
		// "insert into llsection (section_name, section_text, paragraph_num) values ('"+
		// sectionName + "', '" + sectionText + "', '" + "');";

		Connection conn = null;

		// int custId = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://"+MySQLHostname+":3306/monkhouse?user="+MySQLUsername+"&password="+MySQLPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("               SQL query is: " + sql);
			boolean rs = ps.execute();
			if (!rs) {
				System.err.print("insert failed");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return true;
	}

	public HashMap<String, String> executeSelectParagraphText(String sql) {
		HashMap<String, String> resultMap = new HashMap<>();
		Connection conn = null;

		// int custId = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://"+MySQLHostname+":3306/monkhouse?user="+MySQLUsername+"&password="+MySQLPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("               SQL query is: " + sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultMap.put(rs.getString("paragraph_num"),
						rs.getString("section_text"));
			}
			rs.close();

			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return resultMap;
	}

	public static HashMap<String, String> executeSelect(String sql) {
		HashMap<String, String> resultMap = new HashMap<>();
		Connection conn = null;

		// int custId = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://"+MySQLHostname+":3306/monkhouse?user="+MySQLUsername+"&password="+MySQLPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("               SQL query is: " + sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int colCount = rs.getMetaData().getColumnCount();
				if (colCount == 1) {
					resultMap.put("result",rs.getString(1));
				}
				if (colCount == 2) {
					resultMap.put(rs.getString(1), rs.getString(2));
				}
			}
			rs.close();

			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return resultMap;
	}

	public void executeUpdate(String sql) {
		Connection conn = null;

		// int custId = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://"+MySQLHostname+":3306/monkhouse?user="+MySQLUsername+"&password="+MySQLPassword);
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("               SQL query is: " + sql);
			int resp = ps.executeUpdate();

			System.out.println(resp + " rows affected.");
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public static void main(String[] args) {
		UserDao test = new UserDao();

		LLSectionFactory llsf = new LLSectionFactory();
		LLDocument doc = new LLDocument();

		doc.getFieldsMap().put("setAllParagraphs", "true");
		doc.getFieldsMap().put("isUseDependentContractor", "on");
		for (LLSectionCode type : LLSectionCode.values()) {
			LLSection llsection = llsf.getSection(doc, type);

			System.out
					.println("Section Name: " + type + " .\\. Section Text: ");
			int paraNum = 1;
			for (LLParagraph line : llsection.getContents()) {
				System.out.println("    " + paraNum + ": " + line.getText());

				String sql = "insert into _ (section_name, section_text, paragraph_num) values (\""
						+ type
						+ "\", \""
						+ line.getText().replaceAll("\"", "\\\\\"")
						+ "\", \""
						+ paraNum + "\");";
				test.execute(sql);
				paraNum++;
			}
		}

		// SOCSectionFactory socsf = new SOCSectionFactory();
		// SOCDocument doc2 = new SOCDocument();
		//
		// for (SOCSectionCode type : SOCSectionCode.values()) {
		// SOCSection socSection = socsf.getSection(doc2, type);
		//
		// System.out
		// .println("Section Name: " + type + " .\\. Section Text: ");
		// int paraNum = 1;
		// for (LLParagraph line : socSection.getContents()) {
		// System.out.println("    " + paraNum + ": " + line.getText());
		//
		// String sql =
		// "insert into socsection (section_name, section_text, paragraph_num) values (\""
		// + type
		// + "\", \""
		// + line.getText().replace("\"", "\\\"")
		// + "\", \""
		// + paraNum + "\");";
		// test.execute(sql);
		// paraNum++;
		// }
		// }
	}
}
