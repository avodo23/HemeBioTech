package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class SaveFile {
	public void writeDataOnFile(ArrayList<String> dataToSaveOnFile,String fileNameToCreate) {
		File fileToBeCreate=new File(fileNameToCreate);
		
		
		Set<String> set=new LinkedHashSet<>(dataToSaveOnFile);
		ArrayList<String> listOfSymptomWithoutDuplicates=new ArrayList<>(set);
		ArrayList<String> listWithoutDuplicate=new ArrayList<String>();
		for(int i=0;i<listOfSymptomWithoutDuplicates.size();i++) {
			listWithoutDuplicate.add(listOfSymptomWithoutDuplicates.get(i));
		}
	
		try {
			FileWriter fileWriter=new FileWriter(fileToBeCreate);
			BufferedWriter fileTobeCreate=new BufferedWriter(fileWriter);
			
			for(int i=0; i<listWithoutDuplicate.size();i++) {
				fileTobeCreate.write(listWithoutDuplicate.get(i)+"\n");
				fileTobeCreate.flush();	
			}
			
			fileTobeCreate.close();
			
			System.out.println("File saved");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
