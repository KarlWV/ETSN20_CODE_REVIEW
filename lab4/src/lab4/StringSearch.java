package lab4;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class StringSearch {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Enter the string you want to search for and the path to the file as arguments");
			return;
		}
		findString(args[0], args[1]);

	}

	public static void findString(String s, String path) {
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] words = data.split(" ");
				for (String word : words) {
					if (word.equals(s)) {
						System.out.println(data);
						break;
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
