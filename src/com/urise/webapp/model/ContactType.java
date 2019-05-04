package com.urise.webapp.model;

public enum ContactType {
    PHONE("Тел."),//как сделать чтобы можно было не заполнять эту графу и не выдавалась бы ошибка?
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),//как сделать чтобы можно было не заполнять эту графу и не выдавалась бы ошибка?
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STATCKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
