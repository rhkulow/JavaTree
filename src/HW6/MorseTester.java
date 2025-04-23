//Robert Kulow

package HW6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTester {

	public static void main(String[] args) throws FileNotFoundException{
		MorseTree Tree = new MorseTree();
		Scanner temp = new Scanner(new File("morsecode.txt"));
		for(int i = 0; i < 26; i++) {
			String x = temp.nextLine();
			Tree.add(x.substring(2), x.charAt(0), Tree.Tree);
		}
		temp.close();
		System.out.println("Preorder tree contents:" + Tree.preorder());
		System.out.println("Postorder tree contents: " + Tree.postorder());
		Scanner input = new Scanner(System.in);
		System.out.print("Input: ");
		String output = input.nextLine().toLowerCase().replaceAll(" ", "");
		String morse = "";
		for (int i = 0; i < output.length(); i++) {
			morse =  morse + Tree.englishToMorse(output.charAt(i));
		}
		System.out.println("Output:" + morse);
		String english = "";
		String morseChar = "";
		for (int i = 0; i < morse.length(); i++) {
			if(morse.charAt(i) == '|') {
				english = english + Tree.morseToEnglish(morseChar);
				morseChar = "";
			}
			else {
				morseChar = morseChar + morse.charAt(i);
			}
		}
		System.out.println("Reverse:" + english);
		input.close();
		temp.close();
		
	}

}
