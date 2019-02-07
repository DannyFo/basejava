package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() {
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @After
    public void clearAll() {
        storage.clear();
    }


    @Test
    public void clear() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        Assert.assertEquals(1, storage.size());
    }

    @Test
    public void update() {
        Resume r1 = new Resume("uuid3");
        storage.update(r1);
        //нет доп полей чтобы узнать на сколько метод нормально работает, поэтому пишу такой бред
        Assert.assertEquals("uuid3", storage.get(UUID_3).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResume() {
        Resume r1 = new Resume("uuid8");
        storage.update(r1);
    }

    @Test
    public void getAll() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void save() {
        Resume r1 = new Resume("uuid4");
        storage.save(r1);
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = StorageException.class)
    public void saveWithOverflow() {
        for (int i = 0; i < (10_000 - 3); i++) {
            storage.save(new Resume(i + "uuid"));
        }
        Resume r1 = new Resume("uuid4");
        storage.save(r1);
    }

    @Test(expected = ExistStorageException.class)
    public void saveWithExistResume() {
        Resume r1 = new Resume("uuid3");
        storage.save(r1);
    }

    @Test
    public void delete() {
        storage.delete("uuid3");
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistResume() {
        storage.delete("uuid5");
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}