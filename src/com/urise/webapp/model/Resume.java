package com.urise.webapp.model;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

/**
 * Initial resume class
 */
public class Resume {

    private final String uuid;

    private final String fullName;

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

    public HashMap<SectionType, Section> sectionHashMap = new HashMap<>();

    public void sectionHashMap() {
        sectionHashMap.put(PERSONAL, new SectionTypeString());
        sectionHashMap.put(OBJECTIVE, new SectionTypeString());
        sectionHashMap.put(ACHIEVEMENT, new SectionTypeListString());
        sectionHashMap.put(QUALIFICATIONS, new SectionTypeListString());
        sectionHashMap.put(EXPERIENCE, new SectionTypeMapString());
        sectionHashMap.put(EDUCATION, new SectionTypeMapString());

    }


    public HashMap<ContactType, Section> contactHashMap = new HashMap<>();

    public void contactHashMap() {
        contactHashMap.put(TELEPHONE, new SectionTypeString());
        contactHashMap.put(SKYPE, new SectionTypeString());
        contactHashMap.put(MAIL, new SectionTypeString());
        contactHashMap.put(OTHER, new SectionTypeListString());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }
}
