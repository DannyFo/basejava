package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.time.Month.of;

public class DataStreamSerializer implements IOStrategy {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, Link> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, Link> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue().getName());
                dos.writeUTF(entry.getValue().getUrl());
            }
            Map<SectionType, AbstractSection> sections = resume.getSections();
            dos.writeInt(resume.sections.size());//кол-во секций
            for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                switch (entry.getKey()) {
                    case PERSONAL:
                    case OBJECTIVE:
                        simpleTextSectionAdd(entry, dos);
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        listOfTextSectionAdd(entry, dos);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        organizationSectionAdd(entry, dos);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void organizationSectionAdd(Map.Entry<SectionType, AbstractSection> entry, DataOutputStream dos) throws IOException {
        OrganizationSection organizationSection = (OrganizationSection) entry.getValue();
        List<Organization> organizations = organizationSection.getOrganizations();
        dos.writeInt(organizations.size());
        for (Organization organization : organizations) {
            dos.writeUTF(organization.getHomePage().getName());
            dos.writeUTF(organization.getHomePage().getUrl());
            List<Organization.Position> positions = organization.getPositions();
            dos.writeInt(positions.size());
            for (Organization.Position position : positions) {
                dos.writeInt(position.getStartDate().getYear());
                dos.writeInt(position.getStartDate().getMonthValue());
                dos.writeInt(position.getEndDate().getYear());
                dos.writeInt(position.getEndDate().getMonthValue());
                dos.writeUTF(position.getTitle());
                dos.writeUTF(position.getDescription());
            }
        }
    }

    private void listOfTextSectionAdd(Map.Entry<SectionType, AbstractSection> entry, DataOutputStream dos) throws IOException {
        ListOfTextSection listOfTextSection = (ListOfTextSection) entry.getValue();
        List<String> listText = listOfTextSection.getListText();
        dos.writeInt(listText.size());
        for (String text : listText) {
            dos.writeUTF(text);
        }
    }

    private void simpleTextSectionAdd(Map.Entry<SectionType, AbstractSection> entry, DataOutputStream dos) throws IOException {
        SimpleTextSection text = (SimpleTextSection) entry.getValue();
        dos.writeUTF(text.getText());
    }


    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                ContactType contactType = ContactType.valueOf(dis.readUTF());
                String name = dis.readUTF();
                String url = dis.readUTF();
                resume.addContact(contactType, new Link(name, url));
            }
            int sectionSize = dis.readInt();
            for (int i = 0; i < sectionSize; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                resume.addSection(sectionType, returnSection(sectionType, dis));
            }

            return resume;
        }
    }

    private AbstractSection returnSection(SectionType sectionType, DataInputStream dis) throws IOException {
        switch (sectionType) {
            case PERSONAL:
            case OBJECTIVE:
                return simpleTextSectionRead(dis);
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return listOfTextSectionRead(dis);
            case EXPERIENCE:
            case EDUCATION:
                return organizationSectionRead(dis);
        }
        return null;
    }

    private AbstractSection organizationSectionRead(DataInputStream dis) throws IOException {
        int osSize = dis.readInt();
        List<Organization> organizations = new ArrayList<Organization>();
        for (int i = 0; i < osSize; i++) {
            String homePage = dis.readUTF();
            String url = dis.readUTF();
            List<Organization.Position> positions = new ArrayList<>();
            int oSize = dis.readInt();
            for (int x = 0; x < oSize; x++) {
                int yStartDate = dis.readInt();
                Month mStartDate = of(dis.readInt());
                int yEndDate = dis.readInt();
                Month mEndDate = of(dis.readInt());
                String title = dis.readUTF();
                String description = dis.readUTF();
                Organization.Position position = new Organization.Position(yStartDate, mStartDate,
                        yEndDate, mEndDate, title, description);
                positions.add(position);
            }
            Organization organization = new Organization(new Link(homePage, url), positions);
            organizations.add(organization);
        }
        return new OrganizationSection(organizations);
    }

    private AbstractSection listOfTextSectionRead(DataInputStream dis) throws IOException {
        List<String> listText = new ArrayList<>();
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            listText.add(dis.readUTF());
        }
        return new ListOfTextSection(listText);
    }

    private AbstractSection simpleTextSectionRead(DataInputStream dis) throws IOException {
        String text = dis.readUTF();
        return new SimpleTextSection(text);
    }


}
