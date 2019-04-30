package com.urise.webapp.model;

import java.time.LocalDate;

public class Position {
    private String title;
    private String text;
    private String url;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Position(String title, String text, String url, int smonth, int syear, int fmonth, int fyear) {
        this.title = title;
        this.text = text;
        this.url = url;
        startDate = LocalDate.of(syear, smonth, 1);
        finishDate = LocalDate.of(fyear, fmonth, 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (title != null ? !title.equals(position.title) : position.title != null) return false;
        if (text != null ? !text.equals(position.text) : position.text != null) return false;
        if (url != null ? !url.equals(position.url) : position.url != null) return false;
        if (startDate != null ? !startDate.equals(position.startDate) : position.startDate != null) return false;
        return finishDate != null ? finishDate.equals(position.finishDate) : position.finishDate == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        return result;
    }
}
