package BSTwithWords;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Word {
    private String vocab;
    private int occurence;

    public Word(String vocab, int occurence) {
        this.vocab = vocab;
        this.occurence = occurence;
    }

    public Word(String vocab) {
        this.vocab = vocab;
        this.occurence = 1;

    }

    public String getVocab() {
        return vocab;
    }

    public void setVocab(String vocab) {
        this.vocab = vocab;
    }

    public Integer getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }
}
