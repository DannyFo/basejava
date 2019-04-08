package com.urise.webapp.model;

import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume  {

    private final String uuid;

    private String fullName;

    public Resume(String fullName) {
        this.fullName = fullName;
        this.uuid = (UUID.randomUUID().toString());
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return resume.equals(resume);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode() + fullName.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

}
