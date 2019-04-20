package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionTypeListString extends Section<Integer>{
    public SectionTypeListString() {
        super();
    }

    protected List<String> listSentence = new ArrayList<>();

    @Override
    public List getPosition() {
        return new ArrayList<>(listSentence);
    }

    @Override
    public void AddPosition(Integer searchKey, String sentence) {
        listSentence.add(sentence);
    }

    @Override
    public void UpdatePosition(Integer searchKey, String sentence) {
        listSentence.set(searchKey, sentence);
    }

    @Override
    public void RemovePosition(Integer searchKey) {
        listSentence.remove(searchKey);
    }
}
