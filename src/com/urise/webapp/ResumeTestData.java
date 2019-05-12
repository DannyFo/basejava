package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    public static Resume fillResume(String uuid, String name) {
        Resume r1 = new Resume(uuid, name);

        r1.addContact(PHONE,new Link("1234",null));
        r1.addContact(MOBILE,new Link("+7(921) 855-0482",null));
        r1.addContact(HOME_PHONE,new Link("12345",null));
        r1.addContact(SKYPE,new Link("grigory.kislin",
                "skype:grigory.kislin"));
        r1.addContact(MAIL,new Link("gkislin@yandex.ru",
                "gkislin@yandex.ru"));
        r1.addContact(LINKEDIN,new Link("Профиль LinkedIn","https://www.linkedin.com/in/gkislin"));
        r1.addContact(GITHUB,new Link("Профиль GitHub","https://github.com/gkislin"));
        r1.addContact(STATCKOVERFLOW,new Link("Профиль Stackoverflow",
                "https://stackoverflow.com/users/548473/gkislin"));
        r1.addContact(HOME_PAGE,new Link("Домашняя страница","http://gkislin.ru"));

        r1.addSection(PERSONAL,new SimpleTextSection("Аналитический склад " +
                "ума, сильная логика, креативность, инициативность. " +
                "Пурист кода и архитектуры."));
        r1.addSection(OBJECTIVE,new SimpleTextSection("Ведущий стажировок и " +
                "корпоративного обучения по Java Web и Enterprise технологиям"));

        r1.addSection(ACHIEVEMENT,new ListOfTextSection("С 2013 года: разработка проектов " +
                "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный" +
                " maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP)." +
                " Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок" +
                " и ведение проектов. Более 1000 выпускников.", "Реализация двухфакторной аутентификации для " +
                "онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
                "DuoSecurity, Google Authenticator, Jira, Zendesk.", "Налаживание процесса разработки и непрерывной " +
                "интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция " +
                "CIFS/SMB java сервера."));


        r1.addSection(QUALIFICATIONS,new ListOfTextSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, " +
        "Tomcat, Jetty, WebLogic, WSO2", "Version control: Subversion, Git, Mercury, " +
                "ClearCase, Perforce", "DB: PostgreSQL(наследование, " +
                "pgplsql, PL/Python), Redis (Jedis), H2, Oracle,"));

        r1.addSection(EXPERIENCE, new Organization("Java Online Projects","http://javaops.ru",
        new Organization.Position(2013, Month.OCTOBER,"Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.")));
        ArrayList<Organization> experience = new ArrayList<>();

        Organization experience1 = new Organization("Java Online Projects",
                "http://javaops.ru",
                LocalDate.of(2013, 10, 01), LocalDate.of(2019, 04, 01),
                "Автор проекта.\n", "Создание, организация и проведение Java онлайн проектов и стажировок.");
        Organization experience2 = new Organization("Wrike", "https://www.wrike.com",
                LocalDate.of(2014, 10, 01),
                LocalDate.of(2016, 01, 01),
                "Старший разработчик (backend)\n",
                "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                        "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        Organization experience3 = new Organization("RIT Center",
                null, LocalDate.of(2012, 04, 01),
                LocalDate.of(2014, 10, 01), "Java архитектор\n",
                "Организация процесса разработки системы ERP для разных окружений: релизная " +
                        "политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация " +
                        "Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура " +
                        "БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                        "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                        "Интеграция Alfresco JLAN для online редактирование из браузера документов MS " +
                        "Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                        "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell " +
                        "remote scripting via ssh tunnels, PL/Python");

        experience.add(experience1);
        experience.add(experience2);
        experience.add(experience3);

        PositionSection experienceSection = new PositionSection(experience);

        ArrayList<Position> education = new ArrayList<>();

        Organization education1 = new Organization("Coursera", "https://www.coursera.org",
                LocalDate.of(2013, 03, 01), LocalDate.of(2013, 05, 01),
                "\t\"Functional Programming Principles in Scala\" by Martin Odersky", null);
        education1.AddNextDate(2015, 12, 2016, 01);
        Organization education2 = new Organization("Luxoft", "https://www.luxoft-training.ru",
                LocalDate.of(2011, 03, 01), LocalDate.of(2011, 04, 01),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                null);
        Organization education3 = new Organization("Siemens AG", "https://new.siemens.com",
                LocalDate.of(2005, 01, 01), LocalDate.of(2005, 04, 01),
                "3 месяца обучения мобильным IN сетям (Берлин)", null);

        education.add(education1);
        education.add(education2);
        education.add(education3);

        PositionSection educationSection = new PositionSection(education);

        r1.contacts.put(PHONE, phone);
        r1.contacts.put(MOBILE, mobile);
        r1.contacts.put(HOME_PHONE, homePhone);
        r1.contacts.put(SKYPE, skype);
        r1.contacts.put(MAIL, mail);
        r1.contacts.put(GITHUB, gitHub);
        r1.contacts.put(LINKEDIN, linkedIn);
        r1.contacts.put(STATCKOVERFLOW, stackoverflow);
        r1.contacts.put(HOME_PAGE, homePage);

        r1.sections.put(PERSONAL, personal);
        r1.sections.put(OBJECTIVE, objective);
        r1.sections.put(ACHIEVEMENT, achievementSection);
        r1.sections.put(QUALIFICATIONS, qualificationSection);
        r1.sections.put(EXPERIENCE, experienceSection);
        r1.sections.put(EDUCATION, educationSection);
//
//        System.out.println(r1.getFullName());
//
//        for (ContactType type : ContactType.values()) {
//            System.out.println(type.getTitle());
//            System.out.println(r1.contacts.get(type).toString());
//        }
//
//        for (SectionType type : SectionType.values()) {
//            System.out.println(type.getTitle());
//            System.out.println(r1.sections.get(type).toString());
//        }
        return r1;
    }
}
