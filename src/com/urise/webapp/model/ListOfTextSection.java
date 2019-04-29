package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOfTextSection extends AbstractSection {

    private List<String> listText;

    public ListOfTextSection(List<String> listText) {
        this.listText = listText;
    }

    public List getListText() {
        return new ArrayList<>(listText);
    }

    public void addPosition(String text) {
        listText.add(text);
    }

    @Override
    public void sectionOutput() {
        List<String> list = new ArrayList<>(listText);
        for (String string : list) {
            System.out.println("- " + string);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfTextSection that = (ListOfTextSection) o;

        return Objects.equals(listText, that.listText);
    }

    @Override
    public int hashCode() {
        return listText != null ? listText.hashCode() : 0;
    }
}
