package dictionaryuet;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public static Scanner sc = new Scanner(System.in);

    public static void insertFromCommandline() {
        System.out.println("Type the number of words to add:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Type the target word:");
            String word_target = sc.nextLine();
            System.out.print("Type the explanation:");
            String word_explain = sc.nextLine();
            Word wd = new Word(word_target, word_explain);
            Dictionary.dict.add(wd);
        }
    }

    public static void dictionaryLookup() {
        int num = Dictionary.dict.size();
        boolean ex = false;
        System.out.println("Insert the word:");
        String wordtg = sc.nextLine();
        wordtg = wordtg.trim().toLowerCase(Locale.ROOT);
        for (int i = 0; i < num; i++) {
            Word item = Dictionary.dict.get(i);
            if (wordtg.equalsIgnoreCase(item.getWord_target())) {
                System.out.println("Meaning: \n" + item.getWord_explain());
                ex = true;
            }
        }
        if (!ex) {
            System.out.println("Unable to find the word");
        }

    }

    public static void insertFromFile() throws IOException {
        Dictionary.dict.clear();
        File filepath = new File("D:/PROJECT/DICT/new.txt");
        Scanner sc = new Scanner(filepath);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split("\\t");
            if (split.length == 2) {
                Dictionary.map.put(split[0], split[1]);
                Word wd = new Word(split[0], split[1]);
                Dictionary.dict.add(wd);
                
                
            }
        }

    }

    public static void dictionaryExportToFile() throws IOException {
        FileWriter fw = new FileWriter("D:/PROJECT/DICT/new.txt");
        for (Word word : Dictionary.dict) {
            fw.write(String.format("%s\t%s\n", word.getWord_target(), word.getWord_explain()));
        }
        fw.close();
        //System.out.println(Dictionary.dict);
    }

    public static String dictionarybeta(String key) {
        String s = "";
        s=Dictionary.map.get(key);
        return s;
    }
    
    public static ArrayList<String> dictionarySearcher(String key) {
        ArrayList<String> ketqua = new ArrayList<>();
        for (int i = 0; i < Dictionary.dict.size(); i++) {
            if (Dictionary.dict.get(i).getWord_target().startsWith(key)) {
                ketqua.add(Dictionary.dict.get(i).getWord_target());
                Collections.sort(ketqua);
            }
        }

        return ketqua;

    }



    public static void add(String new_word,String new_meaning) throws IOException {       
        Word w = new Word(new_word, new_meaning);
        Dictionary.dict.add(w);
        Dictionary.map.put(new_word, new_meaning);
        dictionaryExportToFile();
        System.out.println("WORD ADDED");
    }

    public static void remove(String theword) throws IOException {        
        theword = theword.trim().toLowerCase(Locale.ROOT);
        int x = getIndex(theword);
        if (x == -1) {
            System.out.println("Unable to find word");
        } else {
            Dictionary.dict.remove(x);
            Dictionary.map.remove(x);
            System.out.println("WORD REMOVED");
        }
        dictionaryExportToFile();

    }

    public static int getIndex(String word) {
        int index = -1;
        int size = Dictionary.dict.size();
        for (int i = 0; i < size; i++) {
            if (word.equals(Dictionary.dict.get(i).getWord_target())) {
                index = i;
            }
        }
        return index;
    }

    public static void edit(String theword) throws IOException {       
        int index = getIndex(theword);
        if (index == -1) {
            System.out.println("Word not found");
        } else {
            System.out.println("Type the edited word:");
            String editedw = sc.nextLine();
            System.out.println("And its meaning:");
            String editedm = sc.nextLine();
            Dictionary.dict.get(index).setWord_target(editedw);
            Dictionary.dict.get(index).setWord_explain(editedm);
            System.out.println("WORD EDITED");
        }
        dictionaryExportToFile();

    }
}
