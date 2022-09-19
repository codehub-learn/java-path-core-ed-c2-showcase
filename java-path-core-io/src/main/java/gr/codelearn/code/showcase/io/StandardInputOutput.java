package gr.codelearn.code.showcase.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import gr.codelearn.code.showcase.io.domain.Directory;

public class StandardInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//readStandardInput();
		//readUserInputWithScanner();
		readFileWithScanner("copied_file.txt"); 
	}

	private static void readStandardInput() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while(true) {
				System.out.println("What do you want to share with us today?");
				String readLine = br.readLine();
				System.out.println(readLine);
				if(readLine.equals("quit")){
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void readUserInputWithScanner() {
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("Give me an input (scanner): ");
			String nextLine = scanner.nextLine();
			System.out.println(nextLine);
		}
	}
	
	// EXTRA METHOD WITH SCANNER
	
	private static void readFileWithScanner(String fileName) {
		try(Reader reader = new FileReader(Directory.FILE_DIRECTORY.getPath() + fileName);
				Scanner scanner = new Scanner(reader)){
			while(scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
