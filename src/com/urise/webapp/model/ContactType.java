package com.urise.webapp.model;

public enum ContactType {
    TELEPHONE("Тел.:"),
    SKYPE("Skype:"),
    MAIL("Почта:"),
    OTHER("Иные контакты");

    private String title;

    ContactType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
