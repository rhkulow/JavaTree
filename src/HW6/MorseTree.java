//Robert Kulow

package HW6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTree {
	TreeNode<Character> Tree = new TreeNode<Character>(null);
	
	public MorseTree() {
		this.Tree = new TreeNode<Character>('_');
	}
	
	public void add(String x, char data, TreeNode<Character> node) {
		if(node.getLeft() == null && x.charAt(0) == 'o') {
			node.insert(data);
		}
		else if(node.getLeft() != null && x.charAt(0) == 'o') {
			add(x.substring(2), data, node.getLeft());
		}
		else if(node.getRight() == null && x.charAt(0) == '-') {
			node.insert(data);
		}
		else if(node.getRight() != null && x.charAt(0) == '-'){
			add(x.substring(2), data, node.getRight());
		}
		
	}
	
	public String preorder(){
		String x = Tree.preorder();
		x = x.substring(1);
		return x;
	}
	
	public String postorder() {
		String x = Tree.postorder();
		x = x.replace('_', ' ');
		return x;
	}
	
	public String englishToMorse(char english) throws FileNotFoundException {
		String morse = "";
		Scanner temp = new Scanner(new File("morsecode.txt"));
		for(int i = 0; i < 26; i++) {
				String x = temp.nextLine();
			if (english == x.charAt(0)) {
				morse = morse + x.substring(2) + "|";
			}
		}
		temp.close();
		return "" + morse;
	}
	
	public String morseToEnglish(String morse) throws FileNotFoundException {
		String english = "";
		Scanner temp = new Scanner(new File("morsecode.txt"));
		for(int i = 0; i < 26; i++) {
				String x = temp.nextLine();
			if (morse.equals(x.substring(2))){
				english = english + x.charAt(0);
				temp.close();
				return "" + english;
				
			}
		}
		temp.close();
		return "" + english;
	}
}
