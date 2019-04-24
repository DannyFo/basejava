package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SectionList extends AbstractSection {

    protected List<String> listText = new ArrayList<>();

    public SectionList() {
    }

    public List getListText() {
        return new ArrayList<>(listText);
    }

    public void addPosition(String text) {
        listText.add(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionList that = (SectionList) o;

        return Objects.equals(listText, that.listText);
    }

    @Override
    public int hashCode() {
        return listText != null ? listText.hashCode() : 0;
    }
}
