package dictionaryuet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        DictionaryCommandLine dc = new DictionaryCommandLine();
        dc.dictionaryCustom();
    }

    public void ShowAllWords() {
        System.out.println("No\t" + "Endlish\t" + "Vietnamese");
        for (int i = 0; i < Dictionary.dict.size(); i++) {
            System.out.println(i + "\t" + Dictionary.dict.get(i).word_target + "\t" + Dictionary.dict.get(i).word_explain);
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        ShowAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        DictionaryManagement.insertFromFile();
        ShowAllWords();
        DictionaryManagement.dictionaryLookup();
    }
    public void dictionaryCustom() throws IOException {
        DictionaryManagement.insertFromFile();
        String key = sc.nextLine();
        DictionaryManagement.dictionarySearcher(key);

    }
}
