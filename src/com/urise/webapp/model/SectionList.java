package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionList extends Section {

    protected List<String> listSentence = new ArrayList<>();

    public List getPosition() {
        return new ArrayList<>(listSentence);
    }

    public void addPosition(String sentence) {
        listSentence.add(sentence);
    }

    public void updatePosition(String sentence) {
        listSentence.set(listSentence.indexOf(sentence), sentence);
    }

    public void removePosition(String sentence) {
        listSentence.remove(listSentence.indexOf(sentence));
    }


}
