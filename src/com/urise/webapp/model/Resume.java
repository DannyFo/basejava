package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    private final String uuid;

    private final String fullName;

    public EnumMap<SectionType, Section> sectionMap = new EnumMap<>(SectionType.class);

    public EnumMap<ContactType, Section> contactMap = new EnumMap<>(ContactType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.fullName = fullName;
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        if (!fullName.equals(resume.fullName)) return false;
        if (sectionMap != null ? !sectionMap.equals(resume.sectionMap) : resume.sectionMap != null) return false;
        return contactMap != null ? contactMap.equals(resume.contactMap) : resume.contactMap == null;

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + (sectionMap != null ? sectionMap.hashCode() : 0);
        result = 31 * result + (contactMap != null ? contactMap.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }
}
