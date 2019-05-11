package com.urise.webapp.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.urise.webapp.util.DateUtil.NOW;
import static com.urise.webapp.util.DateUtil.of;

public class Position {
    private final Link homePage;
    private List<SubPosition> subPositions = new ArrayList<>();

    public Position(String name, String url,SubPosition...subPositions) {
        this(new Link(name, url), Arrays.asList(subPositions));
    }

    public Position(Link homePage, List<SubPosition> subPositions) {
        this.homePage = homePage;
        this.subPositions = subPositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (homePage != null ? !homePage.equals(position.homePage) : position.homePage != null) return false;
        return subPositions != null ? subPositions.equals(position.subPositions) : position.subPositions == null;

    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + (subPositions != null ? subPositions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "homePage=" + homePage +
                ", subPositions=" + subPositions +
                '}';
    }

    public static class SubPosition {

        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public SubPosition(int startYear, Month startMonth, String title, String description){
            this(of(startYear, startMonth), NOW, title, description);
        }

        public SubPosition(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description){
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public SubPosition(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SubPosition that = (SubPosition) o;

            if (!startDate.equals(that.startDate)) return false;
            if (!endDate.equals(that.endDate)) return false;
            if (!title.equals(that.title)) return false;
            return description != null ? description.equals(that.description) : that.description == null;

        }

        @Override
        public int hashCode() {
            int result = startDate.hashCode();
            result = 31 * result + endDate.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "SubPosition{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
