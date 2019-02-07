package database;

import java.util.LinkedList;
import java.util.List;

import database.Tokenise;

public class ExtractKeywords {
	String Name, pointer;
	int Experience = 0;
	
	private List<String> skillSet = new LinkedList<String>();
	
	ExtractKeywords(Tokenise tokens){
		getName(tokens);
		getPointer(tokens);
	}
	
	public void getName(Tokenise tokens) {
		int flag = 0;
		
		for(String traverse : tokens.tokenList()) {
			if(traverse.compareToIgnoreCase("name:") == 0) {
				flag =1;
				continue;
			}
			if(flag == 1) {
				Name = traverse;
				Name.concat(" ");
				flag = 2;
				continue;
			}
			if(flag == 2) {
				Name.concat(traverse);
				break;
			}
		}
	}
	
	public void getPointer(Tokenise tokens) {
		int flag = 0;
		
		for(String traverse : tokens.tokenList()) {
			if(traverse.compareToIgnoreCase("pointer:") == 0) {
				flag =1;
				continue;
			}
			if(flag == 1 && checkPointerInput(traverse) == 1) {
				pointer = traverse;
				break;
			}
			if(flag == 1 && checkPointerInput(traverse) == 0) {
				pointer = "0";
				break;
			}
		}
	}
	
	public int checkPointerInput(String p) {
		if(p.matches("[0-9.]*")) 
			return 1;
		return 0;
	}
	
	public void getSkillSet(Tokenise tokens) {
		int flag = 0;
		
		for(String traverse : tokens.tokenList()) {
			if(traverse.compareToIgnoreCase("skill") == 0) {
				flag = 1;
				continue;
			}
			if(flag == 1 && traverse.compareToIgnoreCase("set:") == 0) {
				flag = 2;
				continue;
			}
			if(flag == 2) {
				skillSet.add(traverse);
				Experience++;
			}
			if(traverse.compareToIgnoreCase("experience:") == 0) 
				break;
		}
		
		String removeElement = ((LinkedList<String>) skillSet).removeLast();
	}

}
