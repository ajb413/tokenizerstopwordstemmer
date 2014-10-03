/**
 * Homework 3
 * 10/03/14
 * CSC320
 * @author Adam Bavosa
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Stopword remover. Removes stopwords from tokenizer input (token.txt)
 */

public class StopwordRemover
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader tokenFile = new BufferedReader(new FileReader("token.txt"));
		BufferedReader stopFile = new BufferedReader(new FileReader("inquery"));
		ArrayList<String> stopWords = new ArrayList<String>();
		String nonStopWord;

		PrintWriter writer = new PrintWriter("toStemmer.txt", "UTF-8");

		int stopWordCount = 0;
		String stopWord;
		while ((stopWord = stopFile.readLine())!=null)
		{
			stopWords.add(stopWord);
			stopWordCount++;
		}

		while ((nonStopWord=tokenFile.readLine())!=null)
		{
			for(int i=0; i<stopWordCount; i++)
			{
				if(stopWords.get(i).equals(nonStopWord))
					break;
				if(i==(stopWordCount-1))
					writer.println(nonStopWord);
			}
		}

 		writer.close();
		tokenFile.close();
		stopFile.close();
		System.out.println("Next run: java Stemmer toStemmer.txt");
	}
}