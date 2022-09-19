package gr.codelearn.code.showcase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteIO {

	private static String DIRECTORY = System.getProperty("user.home") + File.separator + "data_files" + File.separator;

	public static void main(String[] args) {
		fileOutput("Hello from Java. \nI am a Java program.", "test.txt");
		fileInput("test.txt");
	}

	private static void fileOutput(String sentence, String fileName) {
		if (sentence != null) {
			try (OutputStream out = new FileOutputStream(DIRECTORY + fileName, false)){
				out.write(sentence.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	private static void fileInput(String fileName) {
		try (InputStream in = new FileInputStream(DIRECTORY + fileName)){
			// just for demonstration purposes, should not be used when file is too large
			byte[] readAllBytes = in.readAllBytes();
			
			String sentenceToBeFormed = efficientlyBuildString(readAllBytes);			
			System.out.println(sentenceToBeFormed);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private static String efficientlyBuildString(byte[] chars) {
		
		StringBuilder sb = new StringBuilder();
		for(byte integer: chars) {
			System.out.println(integer);
			sb.append((char) integer);
		}
		
		return sb.toString();
	}

}
