import java.util.*;
import edu.duke.*;
/* Andrew Waldeck
 * Last Updated: 9/18/2016
 * 
 * This is an exercise in using ArrayLists
 * 
 * This is a program that determines the word that occurs most often in a text file. If more
 * than one word occurs as the most often, the first word is returned. Punctuation is not
 * considered, so "this" and "this," will be considered different words.
 * 
 */
public class WordFrequencies {
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	
	/*
	 * A constructor for the WordFrequencies class that initializes the private variables
	 * myWords and myFreqs.
	 */
	public WordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs =  new ArrayList<Integer>();
		
		tester();
	}
	
	/*
	 * This method clears both myWords and myFreqs, then selects a file and iterates over every
	 * word in the file, putting the unique words in myWords. For each word in the kth position
	 * of myWords, it puts the count of how many time that word occers from the selected file
	 * into the kth position in myFreqs.
	 */
	public void findUnique() {
		myWords.clear();
		myFreqs.clear();
		
		FileResource fr = new FileResource();
		
		for (String word : fr.words()) {
			word = word.toLowerCase();
			int index = myWords.indexOf(word);
			if (index == -1) {
				myWords.add(word);
				myFreqs.add(1);
			}
			else {
				int value = myFreqs.get(index);
				myFreqs.set(index, value + 1);
			}
		}
	}
	
	/*
	 * This method calls findUnique() and prints out the number of unique words and for each unique
	 * word it prints the frequency of that word as well as the word itself.
	 * 
	 * This method also calls findIndexOfMax to determine and print the word that occurs the most
	 * often in a selected file and how many times it occurs.
	 */
	public void tester() {
		findUnique();
		System.out.println("Number of unique words: " + myWords.size() +"\n");
		
		for(int i = 0; i < myWords.size(); i++) {
			System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
		}
		
		int indexOfMax = findIndexOfMax();
		System.out.println("\"" + myWords.get(indexOfMax) + "\" occurs the most, " + myFreqs.get(indexOfMax) + " times.");
	}
	
	/*
	 * This method returns an int that is the index location of the largest value in myFreqs.
	 * If there is a tie, the first such word is returned.
	 */
	public int findIndexOfMax() {
		int maxValue = -1;
		int maxIndex = -1;
		
		for (int i = 0; i < myFreqs.size(); i++) {
			if (myFreqs.get(i) > maxValue) {
				maxValue = myFreqs.get(i);
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public static void main(String[] args) {
		WordFrequencies wf = new WordFrequencies();
	}
}
