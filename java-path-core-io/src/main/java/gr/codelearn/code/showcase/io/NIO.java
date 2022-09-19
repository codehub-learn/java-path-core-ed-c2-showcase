package gr.codelearn.code.showcase.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import gr.codelearn.code.showcase.io.domain.Directory;

public class NIO {

	public static void main(String[] args) {
		//createDirectoryAndFile();
		//deleteDirectoryAndFile();
		//readFileInput();
		//writeFileOutput();
	}
	
	private static void readFileInput() {
		try(BufferedReader br = Files.newBufferedReader(Paths.get(Directory.FILE_DIRECTORY.getPath() + "copied_file.txt"))){
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeFileOutput() {
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(Directory.FILE_DIRECTORY.getPath() + "copied_file2.txt"))){
			bw.write("Hiiii");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void getPath() {
		Path file_directory = Paths.get(Directory.FILE_DIRECTORY.getPath());
	}
	
	private static void filesExample() {
		Path file_directory = Paths.get(Directory.FILE_DIRECTORY.getPath());
		Files.exists(file_directory);
		// etc...
	}
	
	private static void createDirectoryAndFile() {
		try {
			Path new_directory = Paths.get(Directory.FILE_DIRECTORY.getPath() + "test" + File.separator + "test2" + File.separator + "test3");
			Files.createDirectories(new_directory);
			Files.createFile(Paths.get(new_directory + File.separator + "file.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteDirectoryAndFile() {
		Path old_directory = Paths.get(Directory.FILE_DIRECTORY.getPath() + "test");
		try {
			 File[] listFiles = old_directory.toFile().listFiles();
			
			for (File file: listFiles) {
				Files.delete(Paths.get(file.getAbsolutePath()));
			}
			
			Files.delete(old_directory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
