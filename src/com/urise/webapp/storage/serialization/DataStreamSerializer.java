package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements IOStrategy {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(os)){
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, Link> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for(Map.Entry<ContactType, Link> entry: contacts.entrySet()){
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue().getName());
                dos.writeUTF(entry.getValue().getUrl());
            }
            Map<SectionType, AbstractSection> sections = resume.getSections();
            // ЗДЕСЬ СДЕЛАТЬ COUNTER для каждого из типов элементов!
            for(Map.Entry<SectionType, AbstractSection> entry: sections.entrySet()){
                switch (entry.getKey()){
                    case PERSONAL:
                    case OBJECTIVE:
                        simpleTextSectionAdd(entry,dos);
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        listOfTextSectionAdd(entry,dos);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        organizationSectionAdd(entry,dos);
                        break;
                    default: break;
                }
            }
        }
    }

    private void organizationSectionAdd(Map.Entry<SectionType, AbstractSection> entry, DataOutputStream dos) throws IOException {
        dos.writeUTF(entry.getKey().name());
        OrganizationSection organizationSection = (OrganizationSection)entry.getValue();
        List<Organization> organizations = organizationSection.getOrganizations();
        for (Organization organization: organizations){
            dos.writeUTF(organization.getHomePage().getName());
            dos.writeUTF(organization.getHomePage().getUrl());
            List<Organization.Position> positions = organization.getPositions();
            for(Organization.Position position: positions){
                dos.writeUTF(String.valueOf(position.getStartDate()));
                dos.writeUTF(String.valueOf(position.getEndDate()));
                dos.writeUTF(position.getTitle());
                dos.writeUTF(position.getDescription());
            }
        }
    }

    private void listOfTextSectionAdd(Map.Entry<SectionType, AbstractSection> entry, DataOutputStream dos) throws IOException {
        dos.writeUTF(entry.getKey().name());
        ListOfTextSection listOfTextSection = (ListOfTextSection)entry.getValue();
        List<String> listText = listOfTextSection.getListText();
        for (String text:listText) {
            dos.writeUTF(text);
        }
    }

    private void simpleTextSectionAdd(Map.Entry<SectionType, AbstractSection> entry, DataOutputStream dos) throws IOException {
        dos.writeUTF(entry.getKey().name());
        SimpleTextSection text = (SimpleTextSection)entry.getValue();
        dos.writeUTF(text.getText());
    }


    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(DataInputStream dis = new DataInputStream(is)){
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for(int i=0; i<size ; i++){
                ContactType contactType = ContactType.valueOf(dis.readUTF());
                String name = dis.readUTF();
                String url = dis.readUTF();
                resume.addContact(contactType,new Link(name,url));
            }
            //TODO implements sections
            return resume;
        }
    }
}
