package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		//This section create all objects
		ReadSymptomFromFile symptomsFromFile=new ReadSymptomFromFile("symptoms.txt");
		ReadSymptomFromFile showCount=new ReadSymptomFromFile("symptoms.txt");
		ReadSymptomFromFile listCount=new ReadSymptomFromFile("symptoms.txt");
		SaveFile saveFile=new SaveFile();	
		
		try (Scanner inputKeyBoard = new Scanner(System.in)) {
			
			//This section create all variables
			ArrayList<String> dataFormFile=new ArrayList<String>();
			ArrayList<String> countList=new ArrayList<String>();
			int choice;
			String fileName;

			//This get the list of all symptoms from file symptoms.txt
			dataFormFile=symptomsFromFile.GetSymptom();
			
			//This get the list of all symptoms counted on file symptoms.txt with the duplicates elements
			countList=showCount.ShowSymptomCount(dataFormFile);
			
			//this get the list of symptom with his count without duplicates elements
			listCount.ShowResult(countList);
			
			//This save the list
			System.out.println("Do want to save datas? 1 to save and 0 to cancel save");
			choice=inputKeyBoard.nextInt();
			if(choice==1) {
				System.out.println("Put the name of your file");
				fileName=inputKeyBoard.next()+".txt";
				saveFile.writeDataOnFile(countList, fileName);
			}else {
				System.out.println("Save cancelled");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
