package dictionaryuet;



import java.util.ArrayList;
import java.util.*;
public class Dictionary {
    public static ArrayList<Word> dict = new ArrayList<Word>();

    static Map<String, String> map = new LinkedHashMap<>();
    public Dictionary() {
    }

    public static ArrayList<Word> getDict() {
        return dict;
    }
}
