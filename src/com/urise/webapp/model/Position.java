package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Position {
    private final Link homePage;

    private final LocalDate startDate;
    private final LocalDate endDate;
    private ArrayList<LocalDate> localNextDates = new ArrayList<>();
    private final String title;
    private final String description;

    public Position(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public void AddNextDate(int startYYYY, int startMM, int endYYYY, int endMM) {
        localNextDates.add(LocalDate.of(startYYYY, startMM, 01));
        localNextDates.add(LocalDate.of(endYYYY, endMM, 01));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        if (!title.equals(that.title)) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "homePage=" + homePage + "\n" +
                ", startDate=" + startDate +
                ", endDate=" + endDate + "\n" +
                ", localNextDates=" + localNextDates + "\n"+
                ", title='" + title + '\'' + "\n" +
                ", description='" + description + '\'' +
                '}';
    }
}
