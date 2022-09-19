package gr.codelearn.code.showcase.io.domain;

import java.io.File;

public enum Directory {
	
	FILE_DIRECTORY(System.getProperty("user.home") + File.separator + "data_files" + File.separator);
	
	private String path;

	private Directory(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
}
