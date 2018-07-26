package com.read;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.SQLException;

public class Pliki {

	public static void pliki() throws IOException, SQLException, ClassNotFoundException {
		File dir = new File("C:\\\\Users\\\\Topij Ma³gorzata\\\\xlsx");
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".xlsx");
			}
		};

		String filename = "";
		String[] children = dir.list(filter);
		if (children == null) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < children.length; i++) {
				filename = children[i];
				String nazwa = "C:\\Users\\Topij Ma³gorzata\\xlsx\\" + filename;
				System.out.println(nazwa);
				ReadExcel.wali(nazwa, filename.toString());
				//return nazwa;
			}
		}
	}

}