package com.urise.webapp.model;

import java.util.Objects;

public class Contact {
    private String text;
    private String url;

    public Contact(String text, String url) {
        Objects.requireNonNull(text,"listText must not be null" );
        this.text = text;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!text.equals(contact.text)) return false;
        return url != null ? url.equals(contact.url) : contact.url == null;

    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
