package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.List;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    private static SectionString telephone = new SectionString();
    private static SectionString skype = new SectionString();
    private static SectionString mail = new SectionString();
    private static SectionList other = new SectionList();

    private static SectionString personal = new SectionString();
    private static SectionString objective = new SectionString();
    private static SectionList achievement = new SectionList();
    private static SectionList qualifications = new SectionList();
    private static SectionMap experience = new SectionMap();
    private static SectionMap education = new SectionMap();

    public static void contactOutput(ContactType type, Resume resume) {
        List<String> list;
        switch (type) {
            case TELEPHONE:
                System.out.println(((SectionString) resume.contactMap.get(TELEPHONE)).getPosition());
                break;
            case SKYPE:
                System.out.println(((SectionString) resume.contactMap.get(SKYPE)).getPosition());
                break;
            case MAIL:
                System.out.println(((SectionString) resume.contactMap.get(MAIL)).getPosition());
                break;
            case OTHER:
                list = ((SectionList) resume.contactMap.get(OTHER)).getPosition();
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
                System.out.println(((SectionString) resume.sectionMap.get(OBJECTIVE)).getPosition());
                break;
            case PERSONAL:
                System.out.println(((SectionString) resume.sectionMap.get(PERSONAL)).getPosition());
                break;
            case ACHIEVEMENT:
                list = ((SectionList) resume.sectionMap.get(ACHIEVEMENT)).getPosition();
                for (String string : list) {
                    System.out.println("* " + string);
                }
                break;
            case QUALIFICATIONS:
                list = ((SectionList) resume.sectionMap.get(QUALIFICATIONS)).getPosition();
                for (String string : list) {
                    System.out.println("* " + string);
                }
                break;
            case EXPERIENCE:
                list = ((SectionMap) resume.sectionMap.get(EXPERIENCE)).getPosition();
                for (String string : list) {
                    System.out.println(string);
                }
                break;
            case EDUCATION:
                list = ((SectionMap) resume.sectionMap.get(EDUCATION)).getPosition();
                for (String string : list) {
                    System.out.println(string);
                }
                break;
        }
    }

    public static void main(String[] args) {
        Resume r1 = new Resume("Григорий Кислин");

        telephone.addPosition("+7(921) 855-0482");
        skype.addPosition("grigory.kislin");
        mail.addPosition("gkislin@yandex.ru");
        other.addPosition("Профиль LinkedIn");
        other.addPosition("Профиль GitHub");
        other.addPosition("Профиль Stackoverflow");
        other.addPosition("Домашняя страница");

        objective.addPosition("Ведущий стажировок и корпоративного обучения по " +
                "Java Web и Enterprise технологиям");
        personal.addPosition("Аналитический склад " +
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
        experience.addPosition("Java Online Projects", "Автор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        experience.addPosition("Wrike", "Старший разработчик (backend)\n" +
                "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        experience.addPosition("RIT Center", "Java архитектор\n" +
                "Организация процесса разработки системы ERP для разных окружений: релизная " +
                "политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация " +
                "Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура " +
                "БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                "Интеграция Alfresco JLAN для online редактирование из браузера документов MS " +
                "Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
                "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell " +
                "remote scripting via ssh tunnels, PL/Python");
        education.addPosition("Coursera", "\t\"Functional Programming Principles in Scala\"" +
                " by Martin Odersky");
        education.addPosition("Luxoft", "Курс \"Объектно-ориентированный анализ ИС. " +
                "Концептуальное моделирование на UML.\"");
        education.addPosition("Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)");

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
