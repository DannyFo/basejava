package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.List;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    private static SimpleTextString telephone = new SimpleTextString();
    private static SimpleTextString skype = new SimpleTextString();
    private static SimpleTextString mail = new SimpleTextString();
    private static SectionList other = new SectionList();

    private static SimpleTextString personal = new SimpleTextString();
    private static SimpleTextString objective = new SimpleTextString();
    private static SectionList achievement = new SectionList();
    private static SectionList qualifications = new SectionList();
    private static SectionPosition experience = new SectionPosition();
    private static SectionPosition education = new SectionPosition();

    private static Position experience1 = new Position("Java Online Projects",
            "Автор проекта.\n" +
                    "Создание, организация и проведение Java онлайн проектов и стажировок.");
    private static Position experience2 = new Position("Wrike", "Старший " +
            "разработчик (backend)\n Проектирование и разработка онлайн платформы " +
            "управления проектами Wrike " +
            "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
            "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
    private static Position experience3 = new Position("RIT Center",
            "Java архитектор\n" +
             "Организация процесса разработки системы ERP для разных окружений: релизная " +
             "политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация " +
             "Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура " +
             "БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
             "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
             "Интеграция Alfresco JLAN для online редактирование из браузера документов MS " +
             "Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
             "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell " +
             "remote scripting via ssh tunnels, PL/Python");

    private static Position education1 = new Position("Coursera", "\t\"Functional " +
            "Programming Principles in Scala\" by Martin Odersky");
    private static Position education2 = new Position("Luxoft", "Курс \"Объектно-" +
            "ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
    private static Position education3 = new Position("Siemens AG", "3 месяца " +
            "обучения мобильным IN сетям (Берлин)");

    public static void contactOutput(ContactType type, Resume resume) {
        List<String> list;
        switch (type) {
            case TELEPHONE:
                System.out.println(((SimpleTextString) resume.contactMap.get(TELEPHONE)).getText());
                break;
            case SKYPE:
                System.out.println(((SimpleTextString) resume.contactMap.get(SKYPE)).getText());
                break;
            case MAIL:
                System.out.println(((SimpleTextString) resume.contactMap.get(MAIL)).getText());
                break;
            case OTHER:
                list = ((SectionList) resume.contactMap.get(OTHER)).getListText();
                for (String string : list) {
                    System.out.println("- " + string);
                }
                break;
        }
    }

    public static void sectionOutput(SectionType type, Resume resume) {
        List<String> list;
        switch (type) {
            case OBJECTIVE:
                System.out.println(((SimpleTextString) resume.sectionMap.get(OBJECTIVE)).getText());
                break;
            case PERSONAL:
                System.out.println(((SimpleTextString) resume.sectionMap.get(PERSONAL)).getText());
                break;
            case ACHIEVEMENT:
                list = ((SectionList) resume.sectionMap.get(ACHIEVEMENT)).getListText();
                for (String string : list) {
                    System.out.println("* " + string);
                }
                break;
            case QUALIFICATIONS:
                list = ((SectionList) resume.sectionMap.get(QUALIFICATIONS)).getListText();
                for (String string : list) {
                    System.out.println("* " + string);
                }
                break;
            case EXPERIENCE:
                list = ((SectionPosition) resume.sectionMap.get(EXPERIENCE)).getPosition();
                for (String string : list) {
                    System.out.println(string);
                }
                break;
            case EDUCATION:
                list = ((SectionPosition) resume.sectionMap.get(EDUCATION)).getPosition();
                for (String string : list) {
                    System.out.println(string);
                }
                break;
        }
    }

    public static void main(String[] args) {
        Resume r1 = new Resume("Григорий Кислин");

        telephone.setText("+7(921) 855-0482");
        skype.setText("grigory.kislin");
        mail.setText("gkislin@yandex.ru");
        other.addPosition("Профиль LinkedIn");
        other.addPosition("Профиль GitHub");
        other.addPosition("Профиль Stackoverflow");
        other.addPosition("Домашняя страница");

        objective.setText("Ведущий стажировок и корпоративного обучения по " +
                "Java Web и Enterprise технологиям");
        personal.setText("Аналитический склад " +
                "ума, сильная логика, креативность, инициативность. " +
                "Пурист кода и архитектуры.");
        achievement.addPosition("С 2013 года: разработка проектов " +
                "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный" +
                " maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP)." +
                " Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок" +
                " и ведение проектов. Более 1000 выпускников.");
        achievement.addPosition("Реализация двухфакторной аутентификации для " +
                "онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
                "DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievement.addPosition("Налаживание процесса разработки и непрерывной " +
                "интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция " +
                "CIFS/SMB java сервера.");
        qualifications.addPosition("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, " +
                "Tomcat, Jetty, WebLogic, WSO2");
        qualifications.addPosition("Version control: Subversion, Git, Mercury, " +
                "ClearCase, Perforce");
        qualifications.addPosition("DB: PostgreSQL(наследование, " +
                "pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        experience.addPosition(experience1);
        experience.addPosition(experience2);
        experience.addPosition(experience3);
        education.addPosition(education1);
        education.addPosition(education2);
        education.addPosition(education3);

        r1.contactMap.put(TELEPHONE, telephone);
        r1.contactMap.put(SKYPE, skype);
        r1.contactMap.put(MAIL, mail);
        r1.contactMap.put(OTHER, other);

        r1.sectionMap.put(PERSONAL, personal);
        r1.sectionMap.put(OBJECTIVE, objective);
        r1.sectionMap.put(ACHIEVEMENT, achievement);
        r1.sectionMap.put(QUALIFICATIONS, qualifications);
        r1.sectionMap.put(EXPERIENCE, experience);
        r1.sectionMap.put(EDUCATION, education);

        System.out.println(r1.getFullName());

        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle());
            contactOutput(type, r1);
        }

        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
            sectionOutput(type, r1);
        }
    }
}
