/**
 * Homework 3
 * 10/03/14
 * CSC320
 * @author Adam Bavosa
 */

import java.io.*;
import java.util.*;

/**
 * Tokenizer
 */

public class Tokenizer
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("assignment3-input.txt")); 
		String line; //line from file
		String token; //each word in the file

		PrintWriter writer = new PrintWriter("token.txt", "UTF-8");

 		while ((line = in.readLine())!=null)
 		{
			Scanner sc = new Scanner(line);

			while(sc.hasNext())
			{
				token = sc.next();
 				token = token.replaceAll("\\W", "");
				token = token.toLowerCase();
				writer.println(token);
			}
 		}
 		writer.close();
		in.close();
		System.out.println("Next run: java StopwordRemover");
	}
}