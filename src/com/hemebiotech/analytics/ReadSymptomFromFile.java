package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Bonaventure Avodo, Software developer
 * @date 17/06/2023
 * @version 1.0
 * This implement all the method of ISymptomReader
 *
 */

public class ReadSymptomFromFile implements ISymptomReader{
	
	private String filepath;
	

	public ReadSymptomFromFile(String data) { //constructor of class ReadSymptomFromFile
		this.filepath=data;
	}
	
	/**
	 * 
	 * @param data
	 * implementation of GetSymptom method of ISymptomReader
	 */
	
	public ArrayList<String> GetSymptom(){
		ArrayList<String> listOfSymptoms=new ArrayList<String>();//This will receive all symptoms
		File file=new File(filepath);
		String line;
		
		try {
			FileReader fileReader=new FileReader(file);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			
			while((line=bufferedReader.readLine()) !=null) {
				listOfSymptoms.add(line);
				listOfSymptoms.sort(null);
			}
			
			bufferedReader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listOfSymptoms;
	}
	
	
	/**
	 * Implementation of ShowSymptomCount method of ISymptomReader
	 */
	
	
	public ArrayList<String> ShowSymptomCount(ArrayList<String> symptomList){
		
		ArrayList<String> listCounted=new ArrayList<String>();
		
		for(int i=0;i<symptomList.size();i++) {
			listCounted.add(symptomList.get(i)+"="+Collections.frequency(symptomList, symptomList.get(i)));
			
		}
		
		return listCounted;
	}
	
	
	/**
	 * Implementation of ShowResult method of ISymptomReader
	 */
	
	public void ShowResult(ArrayList<String> symptomListToClean) {
		Set<String> set=new LinkedHashSet<>(symptomListToClean);
		ArrayList<String> listOfSymptomWithoutDuplicates=new ArrayList<>(set);
		for(int i=0;i<listOfSymptomWithoutDuplicates.size();i++) {
			System.out.println(listOfSymptomWithoutDuplicates.get(i));
		}
	}
	
	

}

