// Drew Mendelow, 10/4/24, pd 7
// Manager class with methods to add words to the list and 
// carry out actions given by the user
package WordSorterManager;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSorterManager{
    public ArrayList<String>[] list;
    public String letters;

    @SuppressWarnings("unchecked")
    public WordSorterManager(){
        list = new ArrayList[26];
        for (int i = 0; i < list.length; i++){
            list[i] = new ArrayList<String>();
        }//end for
        letters = "abcdefghijklmnopqrstuvwxyz";
    }//end WordSorterManager

    public void addWord(String word){
        list[letters.indexOf(word.toLowerCase().charAt(0))].add(word.toLowerCase());
    }//end addWord

    public void getInputFromUser(){
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:\n1. Print out all words starting with a specific letter\n2. Print out all words\n3. Print out the total number of unique words\n4. Search and determine if a word is in the article\n5. Remove a word from the data structure\n6. Exit\n");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1){
                char letter = ' ';
                System.out.println("Enter a letter:");
                letter = input.nextLine().toLowerCase().charAt(0);
                while (letter == ' ') {
                    System.out.println("Enter a letter:");
                    letter = input.nextLine().charAt(0);
                }//end while
                System.out.println("Words starting with '" + letter + "':");
                for (String word : list[letters.indexOf(letter)]) {
                    System.out.println(word);
                }//end for
            }//end if
            else if (option == 2){
                int count = 0;
                System.out.println("All words:");
                for (int i = 0; i < list.length; i++) {
                    count += list[i].size();
                    if (list[i].size() > 0){
                        System.out.println("List for '" + letters.charAt(i) + "':");
                        for (String word : list[i]) {
                            System.out.println(word);
                        }//end for
                    }//end if
                }//end for
                if (count == 0){
                    System.out.println("Empty List");
                }//end if
            }//end if
            else if (option == 3){
                int count = 0;
                for (ArrayList<String> arrayList : list) {
                    count += arrayList.size();
                }//end for
                System.out.println("Amount of unique words:\n" + count);
            }//end if
            else if (option == 4){
                System.out.println("Enter a word:");
                String word = input.nextLine();
                boolean found = false;
                for (String curWord : list[letters.indexOf(word.toLowerCase().charAt(0))]) {
                    if (word.toLowerCase().equals(curWord)){
                        found = true;
                        break;
                    }//end if
                }//end for
                if (found){
                    System.out.println("Word found in the article");
                }//end if
                else {
                    System.out.println("Word NOT found in the article.");
                }//end else
            }//end if
            else if (option == 5){
                System.out.println("Enter a word to remove:");
                String word = input.nextLine();
                boolean found = false;
                ArrayList<String> curList = list[letters.indexOf(word.toLowerCase().charAt(0))];
                for (int i = 0; i < curList.size(); i++) {
                    if (word.toLowerCase().equals(curList.get(i))){
                        curList.remove(i);
                        i--;
                        found = true;
                    }//end if
                }//end for
                if (found){
                    System.out.println("Word successfully removed from the list");
                }//end if
                else {
                    System.out.println("Word NOT found in the article.");
                }//end else
            }//end if
            else if (option == 6){
                exit = true;
            }//end if
            System.out.println();
            //if the number is not an option the question will repeat
        }//end while
        input.close();
    }//end getInputFromUser
}//end WordSortManager