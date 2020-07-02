package com.jedi;

import java.io.*;

public class SaveFile {
	
	public static void saveFile(String adress, String nameFile, Object o) {
		try {
			FileWriter file = new FileWriter(adress + nameFile);
			file.write(""+o);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
