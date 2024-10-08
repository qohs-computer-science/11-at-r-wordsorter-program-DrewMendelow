//Drew Mendelow, pd 7, 10/1/24
//Uses WordSorterManager class to carry out actions given by user
import java.io.File;
import java.util.Scanner;
import WordSorterManager.WordSorterManager;

public class WordSorter 
{
	public static void main(String[] args) 
	{
		WordSorterManager wordSorterManager = new WordSorterManager();
		
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}//end try
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}//end catch
		String word = "";
		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			wordSorterManager.addWord(word);
		}//end while
        wordSorterManager.getInputFromUser();
        in.close();
	}//end main
}//end WordSorter