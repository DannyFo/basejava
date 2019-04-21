package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.Map;

import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r1 = new Resume("Григорий Кислин");
        r1.createSection(PERSONAL,"Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры." );
        r1.createSection(ACHIEVEMENT, "С 2013 года: разработка проектов \"Разработка Web приложения\"," +
                "\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). " +
                "Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"" +
                ". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        r1.addToSection(ACHIEVEMENT, "Реализация двухфакторной аутентификации для онлайн " +
                "платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google " +
                "Authenticator, Jira, Zendesk.");
        r1.addToSection(ACHIEVEMENT,"Налаживание процесса разработки и непрерывной интеграции" +
                "ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения " +
                "управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации" +
                " и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        r1.createSection(QUALIFICATIONS, "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, " +
                "Tomcat, Jetty, WebLogic, WSO2");
        r1.addToSection(ACHIEVEMENT, "Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        r1.createSection(EXPERIENCE,"Java Online Projects", "Автор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        r1.addToSection(EXPERIENCE, "Wrike", "Старший разработчик (backend)\n" +
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API," +
                " Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, " +
                "авторизация по OAuth1, OAuth2, JWT SSO.");
        for (Map.Entry entry: r1.sectionMap.entrySet() ) {
            System.out.println(entry.getTitle()+" " + entry.getValue());
        }
    }
}
