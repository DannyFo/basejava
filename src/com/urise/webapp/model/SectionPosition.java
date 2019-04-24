package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SectionPosition extends AbstractSection {

    public SectionPosition() {
    }

    protected List<String> listPosition = new ArrayList<>();

    public List getPosition() {
        return new ArrayList<>(listPosition);
    }

    public void addPosition(Position position) {
        listPosition.add(position.getTitle());
        listPosition.add(position.getText());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionPosition that = (SectionPosition) o;

        return Objects.equals(listPosition, that.listPosition);

    }

    @Override
    public int hashCode() {
        return listPosition != null ? listPosition.hashCode() : 0;
    }
}
