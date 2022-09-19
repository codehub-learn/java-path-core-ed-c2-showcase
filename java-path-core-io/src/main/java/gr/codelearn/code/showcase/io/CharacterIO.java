package gr.codelearn.code.showcase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import gr.codelearn.code.showcase.io.domain.Directory;

public class CharacterIO {
	
	public static void main(String[] args) {
		//fileOutput("Writing a whole string.", "writerFile.txt");
		fileInput("writerFile.txt");
	}
	
	private static void fileOutput(String sentence, String fileName) {
		if (sentence != null) {
			try (Writer writer = new FileWriter(Directory.FILE_DIRECTORY.getPath() + fileName)) {
				writer.write(sentence);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void fileInput(String fileName) {
		try (Reader reader = new FileReader(Directory.FILE_DIRECTORY.getPath() + fileName)) {
			
			int read;
			while((read = reader.read()) != -1) {
				//System.out.println((char) read);
				//continue the code
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
