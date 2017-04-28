import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
	char c;
	HashMap<Character, Node> childMap = new HashMap<Character, Node>();
	String word;
	boolean eow;
	int size = 0;

	public Node(){}

	public Node(char c){
		this.c = c;
	}
}

public class ContactsTrie {

	private static Node root = new Node();

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-->0){
			String type = in.next();
			String word = in.next();
			if(type.equals("add")) add(word);
			else find(word);
		}*/

		add("abc");
		add("abcd");
		find("ab");
		find("k");

	}

	private static void add(String word){
		HashMap<Character, Node> childMap = root.childMap;
		Node t = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			t.size++;
			if(childMap.containsKey(c)){
				t = childMap.get(c);
			} else {
				t = new Node(c);
				childMap.put(c, t);
			}
			childMap = t.childMap;
			if(i==word.length()-1) t.eow = true;
		}

	}

	private static void find(String word){
		HashMap<Character, Node> childMap = root.childMap;
		Node t = root;
		int match = 0;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(childMap.get(c)!=null){
				t = childMap.get(c);
				match = t.size;
				childMap = t.childMap;

			} else {
				match = 0;
			}
		}

		System.out.println(match);
	}
}
