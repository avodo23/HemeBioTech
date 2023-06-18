/**
 * 
 */
package com.hemebiotech.analytics;
import java.util.ArrayList;

/**
 * @author Bonaventure Avodo, Software developer
 * @date 17/06/2023
 * @version 1.0
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	
	/**
	 * 
	 * @return ArrayList containing all symptoms on the file
	 * The method extract all symptoms from the file symptoms.txt and return an ArrayList the list all 
	 * symptoms including duplication.
	 */
	public ArrayList<String> GetSymptom();
	
	
	/**
	 * 
	 * @param symptomList
	 * @return ArrayList containing all symptoms with their count including duplications
	 * The method take a list of symptoms issued from the method GetSymptom() and return a list of 
	 * all symptoms with their count and duplication
	 */
	public ArrayList<String> ShowSymptomCount(ArrayList<String> symptomList);
	
	
	/**
	 * 
	 * @param symptomListToClean
	 * Show the result on screen without the duplication. The method take the list issued from
	 * the method ShowSymptomCount(ArrayList<String>symptomList) and return a list of symptoms and their
	 * count without duplicates elements
	 */
	public void ShowResult(ArrayList<String> symptomListToClean);
	
	
	

}
