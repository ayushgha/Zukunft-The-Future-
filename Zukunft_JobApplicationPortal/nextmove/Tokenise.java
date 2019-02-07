package nextmove;

import java.util.*;

public class Tokenise {
	private List<String> token = new LinkedList<String>();
	
	Tokenise(String text){
		formTokens(text);
	}
	
	public void formTokens(String file) {
		StringTokenizer tokens = new StringTokenizer(file);
		
		while(tokens.hasMoreTokens()) {
			token.add(tokens.nextToken());
		}
	}
	
	public List<String> tokenList(){
		return token;
	}
	
	public void displayTokens() {
		for(String s: token) {
			System.out.println(s);
		}
	}
}