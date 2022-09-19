package gr.codelearn.code.showcase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

import gr.codelearn.code.showcase.io.domain.Directory;

public class ByteIO {

	public static void main(String[] args) {
		// fileOutput("Hello from Java. \nI am a Java program.", "test.txt");
		// fileInput("test.txt");
		// byteArrayOutput();
		//bufferedFileOutput();
		//printStreamFileOutput();
		copyFileToAnother("test.txt");
	}

	private static void fileOutput(String sentence, String fileName) {
		if (sentence != null) {
			try (OutputStream out = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + fileName, false)) {
				out.write(sentence.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void fileInput(String fileName) {
		try (InputStream in = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + fileName)) {
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
		for (byte integer : chars) {
			System.out.println(integer);
			sb.append((char) integer);
		}

		return sb.toString();
	}

	private static void byteArrayOutput() {
		try (OutputStream out = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "baos1.txt");
				OutputStream out2 = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "baos2.txt");
				ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

			baos.write("Hello".getBytes());

			baos.writeTo(out);
			baos.writeTo(out2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bufferedFileOutput() {
		try (OutputStream out = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "buffered.txt");
				OutputStream bout = new BufferedOutputStream(out)) {
			bout.write("hello from buffered output".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void bufferedFileInput() {
		try (InputStream in = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + "buffered.txt");
				InputStream bin = new BufferedInputStream(in)) {

			/*
			 * bin.readAllBytes(); continue the code...
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printStreamFileOutput() {
		try (OutputStream out = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "printOutput.txt");
				PrintStream ps = new PrintStream(out)) {
			byte[] chars = "I am Ioannis".getBytes();
			
			for (byte character : chars) {
				ps.println((char) character);
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void copyFileToAnother(String fileName) {
		try (InputStream in = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + fileName);
				OutputStream out = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "copied_file.txt")) {
			
			in.transferTo(out);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
