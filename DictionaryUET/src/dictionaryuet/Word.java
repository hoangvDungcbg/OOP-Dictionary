package dictionaryuet;

import java.util.Locale;

public class Word {
    String word_target;
    String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target.trim().toLowerCase(Locale.ROOT);
        this.word_explain = word_explain.trim().toLowerCase(Locale.ROOT);
    }

    public Word() {

    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    @Override
    public String toString() {
        return "Word{"
                + "word_target='" + word_target
                + '\''
                + ", word_explain='"
                + word_explain
                + '\''
                + '}';
    }
}
