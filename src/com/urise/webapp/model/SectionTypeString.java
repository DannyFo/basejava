package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;

public class SectionTypeString extends Section<Integer> {
    public SectionTypeString() {
        super();
    }

    protected String stringSentence;

    @Override
    public List getPosition() {
        return Arrays.asList(stringSentence);
    }

    @Override
    public void AddPosition(Integer searchKey, String sentence) {
        this.stringSentence = sentence;
    }

    @Override
    public void UpdatePosition(Integer searchKey, String sentence) {
        this.stringSentence = sentence;
    }

    @Override
    public void RemovePosition(Integer searchKey) {
        stringSentence = null;
    }
}
