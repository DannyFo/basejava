package com.urise.webapp.model;

import java.util.EnumMap;
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

    public EnumMap<SectionType, Section> sectionMap = new EnumMap<SectionType, Section>(SectionType.class);

    private HashMap<ContactType, Section> contactMap = new HashMap<>();// переделать в енум мапу

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

    public void createSection (SectionType type, String firstSentence) {
        switch (type){
            case PERSONAL:
                sectionMap.put(PERSONAL,new SectionTypeString());
                ((SectionTypeString)sectionMap.get(PERSONAL)).AddPosition(firstSentence);
                break;
            case OBJECTIVE:
                sectionMap.put(OBJECTIVE,new SectionTypeString());
                ((SectionTypeString)sectionMap.get(OBJECTIVE)).AddPosition(firstSentence);
                break;
            case ACHIEVEMENT:
                sectionMap.put(ACHIEVEMENT, new SectionTypeListString());
                ((SectionTypeListString)sectionMap.get(ACHIEVEMENT)).AddPosition(firstSentence);
                break;
            case QUALIFICATIONS:
                sectionMap.put(QUALIFICATIONS, new SectionTypeListString());
                ((SectionTypeListString)sectionMap.get(QUALIFICATIONS)).AddPosition(firstSentence);
                break;
        }
    }
    public void addToSection(SectionType type, String sentence) {
        switch (type){
            case ACHIEVEMENT:
                ((SectionTypeListString)sectionMap.get(ACHIEVEMENT)).AddPosition(sentence);
                break;
            case QUALIFICATIONS:
                ((SectionTypeListString)sectionMap.get(QUALIFICATIONS)).AddPosition(sentence);
                break;
        }
    }

    public void createSection (SectionType type, String firstTitle, String sentence){
        switch (type){
            case EXPERIENCE:
                sectionMap.put(EXPERIENCE, new SectionTypeMapString());
                ((SectionTypeMapString)sectionMap.get(EXPERIENCE)).AddPosition(firstTitle, sentence);
                break;
            case EDUCATION:
                sectionMap.put(EDUCATION, new SectionTypeMapString());
                ((SectionTypeMapString)sectionMap.get(EDUCATION)).AddPosition(firstTitle, sentence);
                break;
        }
    }

    public void addToSection(SectionType type, String title, String sentence) {
        switch (type){
            case EXPERIENCE:
                ((SectionTypeMapString)sectionMap.get(EXPERIENCE)).AddPosition(title, sentence);
                break;
            case EDUCATION:
                ((SectionTypeMapString)sectionMap.get(EDUCATION)).AddPosition(title, sentence);
                break;
        }
    }

    public void contactHashMap() {
        contactMap.put(TELEPHONE, new SectionTypeString());
        contactMap.put(SKYPE, new SectionTypeString());
        contactMap.put(MAIL, new SectionTypeString());
        contactMap.put(OTHER, new SectionTypeListString());
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
