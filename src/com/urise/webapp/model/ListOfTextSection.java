package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class ListOfTextSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private List<String> listText;

    public ListOfTextSection() {
    }

    public ListOfTextSection(List<String> listText) {
        Objects.requireNonNull(listText,"listText must not be null" );
        this.listText = listText;
    }

    public ListOfTextSection(String...listText) {
        this(Arrays.asList(listText));
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

        return listText.equals(that.listText);

    }

    @Override
    public int hashCode() {
        return listText.hashCode();
    }
}
