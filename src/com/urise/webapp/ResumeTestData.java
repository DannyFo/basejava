package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.ArrayList;
import java.util.List;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume r1 = new Resume("Григорий Кислин");

        List<ContactWithUrl> OtherContactsWithUrl = new ArrayList<>();

        ContactWithUrl contact1 = new ContactWithUrl("Профиль LinkedIn",
                "https://www.linkedin.com/in/gkislin");
        ContactWithUrl contact2 = new ContactWithUrl("Профиль GitHub",
                "https://github.com/gkislin");
        ContactWithUrl contact3 = new ContactWithUrl("Профиль Stackoverflow",
                "https://stackoverflow.com/users/548473/gkislin");
        ContactWithUrl contact4 = new ContactWithUrl("Домашняя страница",
                "http://gkislin.ru");

        OtherContactsWithUrl.add(contact1);
        OtherContactsWithUrl.add(contact2);
        OtherContactsWithUrl.add(contact3);
        OtherContactsWithUrl.add(contact4);

        SimpleTextContact telephone = new SimpleTextContact("+7(921) 855-0482");
        ContactWithUrl skype = new ContactWithUrl("grigory.kislin", "skype:grigory.kislin");
        ContactWithUrl mail = new ContactWithUrl("gkislin@yandex.ru", "gkislin@yandex.ru");
        ListOfContactsWithUrl other = new ListOfContactsWithUrl(OtherContactsWithUrl);

        SimpleTextSection personal = new SimpleTextSection("Аналитический склад " +
                "ума, сильная логика, креативность, инициативность. " +
                "Пурист кода и архитектуры.");
        SimpleTextSection objective = new SimpleTextSection("Ведущий стажировок и " +
                "корпоративного обучения по Java Web и Enterprise технологиям");

        List<String> achievement = new ArrayList<>();

        achievement.add("С 2013 года: разработка проектов " +
                "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный" +
                " maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP)." +
                " Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок" +
                " и ведение проектов. Более 1000 выпускников.");
        achievement.add("Реализация двухфакторной аутентификации для " +
                "онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
                "DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievement.add("Налаживание процесса разработки и непрерывной " +
                "интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция " +
                "CIFS/SMB java сервера.");

        ListOfTextSection achievementSection = new ListOfTextSection(achievement);

        List<String> qualifications = new ArrayList<>();

        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, " +
                "Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, " +
                "ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, " +
                "pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");

        ListOfTextSection qualificationSection = new ListOfTextSection(qualifications);

        ArrayList<Position> experience = new ArrayList<>();

        Position experience1 = new Position("Java Online Projects",
                "Автор проекта.\n" +
                        "Создание, организация и проведение Java онлайн проектов и стажировок.",
                "http://javaops.ru", 10, 2013, 04, 2019);
        Position experience2 = new Position("Wrike", "Старший " +
                "разработчик (backend)\n Проектирование и разработка онлайн платформы " +
                "управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                "https://www.wrike.com", 10, 2014, 01, 2016);
        Position experience3 = new Position("RIT Center",
                "Java архитектор\n" +
                        "Организация процесса разработки системы ERP для разных окружений: релизная " +
                        "политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация " +
                        "Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура " +
                        "БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                        "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                        "Интеграция Alfresco JLAN для online редактирование из браузера документов MS " +
                        "Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                        "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell " +
                        "remote scripting via ssh tunnels, PL/Python", null, 04, 2012,
                10, 2012);

        experience.add(experience1);
        experience.add(experience2);
        experience.add(experience3);

        PositionSection experienceSection = new PositionSection(experience);

        ArrayList<Position> education = new ArrayList<>();

        Position education1 = new Position("Coursera", "\t\"Functional " +
                "Programming Principles in Scala\" by Martin Odersky", "https://www.coursera.org",
                03, 2013, 05, 2013);
        Position education2 = new Position("Luxoft", "Курс \"Объектно-" +
                "ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                "https://www.luxoft-training.ru", 03, 2011, 04, 2011);
        Position education3 = new Position("Siemens AG", "3 месяца " +
                "обучения мобильным IN сетям (Берлин)", "https://new.siemens.com", 01, 2005,
                04, 2005);

        education.add(education1);
        education.add(education2);
        education.add(education3);

        PositionSection educationSection = new PositionSection(education);

        r1.contacts.put(TELEPHONE, telephone);
        r1.contacts.put(SKYPE, skype);
        r1.contacts.put(MAIL, mail);
        r1.contacts.put(OTHER, other);

        r1.sections.put(PERSONAL, personal);
        r1.sections.put(OBJECTIVE, objective);
        r1.sections.put(ACHIEVEMENT, achievementSection);
        r1.sections.put(QUALIFICATIONS, qualificationSection);
        r1.sections.put(EXPERIENCE, experienceSection);
        r1.sections.put(EDUCATION, educationSection);

        System.out.println(r1.getFullName());

        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle());
            System.out.println(r1.contacts.get(type).toString());
        }

        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
            System.out.println(r1.sections.get(type).toString());
        }
    }
}
