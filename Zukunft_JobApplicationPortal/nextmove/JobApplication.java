package nextmove;

import java.io.*;
import org.apache.poi.POITextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import  org.apache.poi.xwpf.usermodel.XWPFDocument;

public class JobApplication {
	
	InsertUser iu = new InsertUser();
	JobSearch js = new JobSearch();
	
	public void getJob(String fileName) throws Exception {
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			
			XWPFDocument document = new XWPFDocument(fis);
			
			POITextExtractor extractor = new XWPFWordExtractor(document);
			String text = extractor.getText();
			
			Tokenise turnFileToTokens = new Tokenise(text);
			ExtractKeywords keywords = new ExtractKeywords(turnFileToTokens);
			keywords.getSkillSet(turnFileToTokens);
					
			
			//iu.insertTable(keywords.Name,"pawarrohan98", "jobs","17/09/1998");
			double temp = Double.parseDouble(keywords.pointer);
			iu.insertResume(temp, keywords.Experience,keywords.Name);
			
			js.findJob();
			
			extractor.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
