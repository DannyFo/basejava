package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionSection extends AbstractSection {

    private List<Position> listPosition;

    public PositionSection(ArrayList<Position> listPosition) {
        this.listPosition = listPosition;
    }

    public List getPosition() {
        return new ArrayList<>(listPosition);
    }

    public void addPosition(Position position) {
        listPosition.add(position);
    }

    @Override
    public void sectionOutput() {
        List<Position> list = new ArrayList<>(listPosition);
        for (Position position : list) {
            System.out.println(position.getTitle());
            System.out.println(position.getUrl());
            System.out.println(position.getStartDate().getMonthValue() + "/" + position.getStartDate().getYear() +
                    " - " + position.getFinishDate().getMonthValue() + "/" + position.getFinishDate().getYear());
            System.out.println(position.getText());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionSection that = (PositionSection) o;

        return Objects.equals(listPosition, that.listPosition);

    }

    @Override
    public int hashCode() {
        return listPosition != null ? listPosition.hashCode() : 0;
    }
}
