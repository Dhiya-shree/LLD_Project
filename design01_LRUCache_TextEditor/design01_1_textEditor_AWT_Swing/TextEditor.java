package src.design01_LRUCache_TextEditor.design01_1_textEditor_AWT_Swing;

import java.util.Stack;

/**
 * 
 * 
 * Suggested :
 * Maintain left and right array 
 * new char in left 
 * cursor in middle 
 * Cursor to left --> remaining char push to right 
 * Cursor to right --> push char to left 
 * 
 * 
 * @author shree
 *
 */
public class TextEditor {

	public static void main(String[] args) {
		
		// basic editor
		BasicEditor be=new BasicEditor();
		be.add("Hello This is Basic editor");
		be.goLeft(6);
		/*be.add(" BSET Classic ");
		be.goRight(4);
		be.add("-ing direct");
		be.goLeft(6);
		be.goRight(8);
		be.delete(8);
		be.add(" helper");*/
			
	}
	
}


class BasicEditor{
	
	private Stack<Character> left=new Stack<Character>();
	private Stack<Character> right=new Stack<Character>();
	
	boolean add(String str) {
		System.out.println("After add... ");
		int n=str.length();
		for(int i=0;i<n;i++) {
			left.add(str.charAt(i));
		}
		System.out.println(this.toString());
		return true;
	}
	
	String delete(int k) {
		System.out.println("After delete... ");
		StringBuilder sb=new StringBuilder();
		
		while(k>0 && !left.isEmpty()) {
			sb.append(Character.toString(left.pop()));
			k--;
		}
		System.out.println(this.toString());
		return sb.toString();
	}
	
	String goLeft(int k) {
		System.out.println("After left... "+k);
		StringBuilder sb=new StringBuilder();
		char c='0';
		while(k>0 && !left.isEmpty()) {
			c=left.pop();
			sb.append(Character.toString(c));
			k--;
		}
		
		String str=sb.toString();
		System.out.println(str);
		int n=str.length();
		for(int i=n-1;i>=0;i--) {
			right.add(str.charAt(i));
			System.out.println(Character.toString(str.charAt(i)));
		}
		
		System.out.println(this.toString());
		return str;
	}
	
    String goRight(int k) {
    	System.out.println("After right... ");
		StringBuilder sb=new StringBuilder();
		char c='0';
		while(k>0 && !right.isEmpty()) {
			c=right.pop();
			sb.append(Character.toString(c));
			k--;
		}
		String str=sb.toString();
		
		int n=str.length();
		for(int i=n-1;i>=0;i--) {
			left.add(str.charAt(i));
			
		}
		System.out.println(this.toString());
		return str;
	}
    
    @Override
	public String toString() {
    	StringBuilder sb=new StringBuilder();
    	left.forEach(n->{
    		sb.append(n);	
    	});
    	System.out.print(sb.toString()+" >||< ");
    	StringBuilder sb2=new StringBuilder();
    	right.forEach(n->{
    		sb2.append(n);	
    	});
    	System.out.println(sb2.toString());
    	
		return sb.append(sb2).toString();
    	
    }
}
