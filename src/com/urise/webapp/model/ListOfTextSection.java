package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfTextSection extends AbstractSection {

    private List<String> listText;

    public ListOfTextSection(List<String> listText) {
        this.listText = listText;
    }

    public List getListText() {
        return new ArrayList<>(listText);
    }

    @Override
    public String toString() {
        return "ListOfTextSection{" +
                "listText=" + listText +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfTextSection that = (ListOfTextSection) o;

        return listText != null ? listText.equals(that.listText) : that.listText == null;

    }

    @Override
    public int hashCode() {
        return listText != null ? listText.hashCode() : 0;
    }
}
