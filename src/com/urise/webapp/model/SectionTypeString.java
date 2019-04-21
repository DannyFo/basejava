package com.urise.webapp.model;

public class SectionTypeString extends Section {

    protected String stringSentence;

    public String getPosition() {
        return stringSentence;
    }

    public void AddPosition(String sentence) {
        this.stringSentence = sentence;
    }

    public void UpdatePosition(String sentence) {
        this.stringSentence = sentence;
    }

    public void RemovePosition() {
        stringSentence = null;
    }
}
