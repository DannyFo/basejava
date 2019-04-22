package com.urise.webapp.model;

public class SectionString extends Section {

    protected String stringSentence;

    public String getPosition() {
        return stringSentence;
    }

    public void addPosition(String sentence) {
        this.stringSentence = sentence;
    }

    public void updatePosition(String sentence) {
        this.stringSentence = sentence;
    }

    public void removePosition() {
        stringSentence = null;
    }
}
