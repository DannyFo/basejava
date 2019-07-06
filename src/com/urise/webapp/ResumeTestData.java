package com.urise.webapp;

import com.urise.webapp.model.Resume;

public class ResumeTestData {

    public static Resume fillResume(String uuid, String name) {
        Resume r1 = new Resume(uuid, name);

//        r1.addContact(PHONE, new Link("1234", null));
//        r1.addContact(MOBILE, new Link("+7(921) 855-0482", null));
//        r1.addContact(HOME_PHONE, new Link("12345", null));
//        r1.addContact(SKYPE, new Link("grigory.kislin",
//                "skype:grigory.kislin"));
//        r1.addContact(MAIL, new Link("gkislin@yandex.ru",
//                "gkislin@yandex.ru"));
//        r1.addContact(LINKEDIN, new Link("Профиль LinkedIn", "https://www.linkedin.com/in/gkislin"));
//        r1.addContact(GITHUB, new Link("Профиль GitHub", "https://github.com/gkislin"));
//        r1.addContact(STATCKOVERFLOW, new Link("Профиль Stackoverflow",
//                "https://stackoverflow.com/users/548473/gkislin"));
//        r1.addContact(HOME_PAGE, new Link("Домашняя страница", "http://gkislin.ru"));
//
//        r1.addSection(PERSONAL, new SimpleTextSection("Аналитический склад " +
//                "ума, сильная логика, креативность, инициативность. " +
//                "Пурист кода и архитектуры."));
//        r1.addSection(OBJECTIVE, new SimpleTextSection("Ведущий стажировок и " +
//                "корпоративного обучения по Java Web и Enterprise технологиям"));
//
//        r1.addSection(ACHIEVEMENT, new ListOfTextSection("С 2013 года: разработка проектов " +
//                "\"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный" +
//                " maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP)." +
//                " Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок" +
//                " и ведение проектов. Более 1000 выпускников.", "Реализация двухфакторной аутентификации для " +
//                "онлайн платформы управления проектами Wrike. Интеграция с Twilio, " +
//                "DuoSecurity, Google Authenticator, Jira, Zendesk.", "Налаживание процесса разработки и непрерывной " +
//                "интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
//                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
//                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция " +
//                "CIFS/SMB java сервера."));
//
//
//        r1.addSection(QUALIFICATIONS, new ListOfTextSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, " +
//                "Tomcat, Jetty, WebLogic, WSO2", "Version control: Subversion, Git, Mercury, " +
//                "ClearCase, Perforce", "DB: PostgreSQL(наследование, " +
//                "pgplsql, PL/Python), Redis (Jedis), H2, Oracle,"));
//
//        r1.addSection(EXPERIENCE, new OrganizationSection(
//                new Organization("Java Online Projects", "http://javaops.ru",
//                        new Organization.Position(2013, Month.OCTOBER, "Автор проекта.",
//                                "Создание, организация и проведение Java онлайн проектов и стажировок.")),
//                new Organization("Wrike", "https://www.wrike.com",
//                        new Organization.Position(2014, Month.OCTOBER, 2016, Month.JANUARY,
//                                "Старший разработчик (backend)", "Проектирование и " +
//                                "разработка онлайн платформы управления проектами Wrike " +
//                                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
//                                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")),
//                new Organization("RIT Center", null,
//                        new Organization.Position(2012, Month.APRIL, 2014, Month.OCTOBER,
//                                "Java архитектор", "Организация процесса разработки системы " +
//                                "ERP для разных окружений: релизная " +
//                                "политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация " +
//                                "Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура " +
//                                "БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
//                                "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
//                                "Интеграция Alfresco JLAN для online редактирование из браузера документов MS " +
//                                "Office. Maven + plugin development, Ant, Apache Commons, Spring security, " +
//                                "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell " +
//                                "remote scripting via ssh tunnels, PL/Python"))));
//
//
//        r1.addSection(EDUCATION, new OrganizationSection(
//                new Organization("Coursera", "https://www.coursera.org",
//                        new Organization.Position(2013, Month.MARCH, 2013, Month.MAY,
//                                "\t\"Functional Programming Principles in Scala\" by Martin Odersky", null),
//                        new Organization.Position(2015, Month.MARCH, 2017, Month.MAY,
//                                "TEsT", null)),
//                new Organization("Luxoft", "https://www.luxoft-training.ru",
//                        new Organization.Position(2011, Month.MARCH, 2011, Month.APRIL,
//                                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
//                                null)),
//                new Organization("Siemens AG", "https://new.siemens.com",
//                        new Organization.Position(2005, Month.JANUARY, 2005, Month.APRIL,
//                                "3 месяца обучения мобильным IN сетям (Берлин)", null))));
        return r1;
    }
}
