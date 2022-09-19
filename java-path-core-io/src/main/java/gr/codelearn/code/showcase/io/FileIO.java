package gr.codelearn.code.showcase.io;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

import gr.codelearn.code.showcase.io.domain.Directory;

public class FileIO {

	public static void main(String[] args) {
		//fileDetails(Directory.FILE_DIRECTORY.getPath());
		showTextFilesOfDirectory(Directory.FILE_DIRECTORY.getPath());
	}

	private static void fileDetails(String fileName) {
		File file = new File(fileName);

		if (file.exists()) {
			System.out.println(file.canExecute());
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getParent());
			System.out.println(file.isDirectory());
			System.out.println(file.isFile());
			System.out.println(new Date(file.lastModified()));
			
			String[] list = file.list();
			for(String childFile: list) {
				System.out.println(childFile);
			}
		}
	}
	
	private static void showNonDirectoriesOfDirectory(String fileName) {
		File file = new File(fileName);
		
		if(file.exists()) {
			File[] listFiles = file.listFiles();
			
			for(File childFile: listFiles) {
				if(childFile.isFile()) {
					System.out.println(childFile);
				}	
			}
		}
	}
	
	private static void showTextFilesOfDirectory(String fileName) {
		File file = new File(fileName);
		
		if(file.exists() && file.isDirectory()) {
			File[] listFiles = file.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File pathname) {
					if(pathname.toString().endsWith(".txt")) {
						return true;
					}
					return false;					
				}
			});
			
			System.out.println("Files accepted:");
			
			for(File childFile: listFiles) {
				if(childFile.isFile()) {
					System.out.println(childFile);
				}	
			}
		}
	}
}
