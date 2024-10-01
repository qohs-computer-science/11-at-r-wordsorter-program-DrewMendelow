//Drew Mendelow, pd 7, 10/1/24
//PROGRAM DESCRIPTION
import java.io.File;
import java.util.Scanner;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		WordSorterManager test = new WordSorterManager;
		
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}	
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
			System.out.println(word);
			
			
		}
	}
}

public class WordSorterManager{
    public ArrayList<String>[] list;
    public String letters;

    public WordSorterManager(){
        list = new ArrayList<String>[26];
        letters = "abcdefghijklmnopqrstuvwxyz";
    }

    public void addWord(String word){
        list[letters.indexOf(word.toLowerCase().charAt(0))].add(word.toLowerCase());
    }

    public void getInputFromUser(Scanner input){
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:\n1. Print out all words starting with a specific letter\n2. Print out all words\n3. Print out the total number of unique words\n4. Search and determine if a word is in the article\n5. Remove a word from the data structure\n6. Exit");
            int option = input.nextInt();
            if (option == 1){
                char letter;
                while (letter != "") {
                    System.out.println("Enter a letter:");
                    letter = input.nextLine().charAt(0);
                }
                for (String word : list[letters.indexOf(letter)]) {
                    System.out.println(word);
                }
            }
            else if (option == 2){
                for (ArrayList<String> arrayList : list) {
                    for (String word : arrayList) {
                        System.out.println(word);
                    }
                }
            }
            else if (option == 3){
                int count = 0;
                for (ArrayList<String> arrayList : list) {
                    count += arrayList.size();
                }
                System.out.println(count);
            }
            else if (option == 4){
                System.out.println("Enter a word:");
                String word = input.nextLine();
                boolean found = false;
                for (String curWord : list[letters.indexOf(word.toLowerCase().charAt(0))]) {
                    if (word.equals(curWord)){
                        found = true;
                        break;
                    }
                }
                if (found){
                    System.out.println("Word found in the article");
                } 
                else {
                    System.out.println("Word NOT found in the article.");
                }
            }
            else if (option == 5){
                System.out.println("Enter a word:");
                String word = input.nextLine();
                boolean found = false;
                int index = 0;
                ArrayList<String> curList = list[letters.indexOf(word.toLowerCase().charAt(0))];
                for (int i = 0; i < curList.size(); i++) {
                    if (word.equals(curList.get(i))){
                        found = true;
                        index = i;
                        break;
                    }
                }
                if (found){
                    list[letters.indexOf(word.toLowerCase().charAt(0))].remove(index);
                    System.out.println("Word successfully removed from the list");
                } 
                else {
                    System.out.println("Word NOT found in the article.");
                }
            }
            else if (option == 6){
                exit = true;
            } 
            //if the number is not an option the question will repeat
        }
    }
}