package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionTypeListString extends Section{

    protected List<String> listSentence = new ArrayList<>();

    public List getPosition() {
        return new ArrayList<>(listSentence);
    }

    public void AddPosition(String sentence) {
        listSentence.add(sentence);
    }

    public void UpdatePosition(String sentence) {
        listSentence.set(listSentence.indexOf(sentence), sentence);
    }

    public void RemovePosition(String sentence) {
        listSentence.remove(listSentence.indexOf(sentence));
    }


}
