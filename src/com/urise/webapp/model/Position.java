package com.urise.webapp.model;

public class Position {
    public Position(String title, String text) {
        this.title = title;
        this.text = text;
    }

    protected String title;
    protected String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
