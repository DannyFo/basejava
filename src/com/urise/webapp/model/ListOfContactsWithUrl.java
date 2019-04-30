package com.urise.webapp.model;

import java.util.List;

public class ListOfContactsWithUrl extends AbstractContact {
    private List<ContactWithUrl> listContact;

    public ListOfContactsWithUrl(List<ContactWithUrl> listContact) {
        this.listContact = listContact;
    }

    public List<ContactWithUrl> getListContact() {
        return listContact;
    }

    public void setListContact(List<ContactWithUrl> listContact) {
        this.listContact = listContact;
    }

    @Override
    public String toString() {
        return "ListOfContactsWithUrl{" +
                "listContact=" + listContact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfContactsWithUrl that = (ListOfContactsWithUrl) o;

        return listContact != null ? listContact.equals(that.listContact) : that.listContact == null;

    }

    @Override
    public int hashCode() {
        return listContact != null ? listContact.hashCode() : 0;
    }
}
