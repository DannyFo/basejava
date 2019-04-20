package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.Map;

import static com.urise.webapp.model.ContactType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r1 = new Resume("Григорий Кислин");
        r1.contactHashMap.get(TELEPHONE).AddPosition(1,"+7(921) 855-0482)");
        r1.contactHashMap.get(SKYPE).AddPosition(1,"grigory.kislin");
        r1.contactHashMap.get(MAIL).AddPosition(1,"gkislin@yandex.ru");
        r1.contactHashMap.get(OTHER).AddPosition(1,"Профиль LinkedIn");
        r1.contactHashMap.get(OTHER).AddPosition(1,"Профиль GitHub");
        r1.contactHashMap.get(OTHER).AddPosition(1,"Профиль Stackoverflow");
        r1.contactHashMap.get(OTHER).AddPosition(1,"Профиль Домашняя страница");
        for (Map.Entry entry: r1.contactHashMap.entrySet() ) {
            System.out.println(entry.getKey()+" " + entry.getValue());
        }
    }
}
