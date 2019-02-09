package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_LIMIT;

public class AbstractArrayStorageTest {
    private Storage storage;

    private static final String DUMMY = "uuid4";
    private static final Resume dummy = new Resume(DUMMY);//для проверок


    protected AbstractArrayStorageTest(Storage storage) {
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
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume r1 = new Resume("uuid3");
        storage.update(r1);
        Assert.assertEquals(storage.get(UUID_3), r1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResume() {
        storage.update(dummy);
    }

    @Test
    public void getAll() {
        Resume[] array = new Resume[3];
        Assert.assertEquals(array.length, storage.getAll().length);
        Assert.assertEquals(3, storage.getAll().length);
    }

    @Test
    public void save() {
        storage.save(dummy);
        storage.get("uuid4");
    }

    @Test(expected = StorageException.class)
    public void saveWithOverflow() {
        clear();
        for (int i = 0; i < STORAGE_LIMIT; i++) {
            storage.save(new Resume(i + "uuid"));
        }
        try {
            storage.save(new Resume("10_001uuid"));
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.fail("Storage Overflow");
        }
        Resume r1 = new Resume("uuid4");
        storage.save(r1);
    }

    @Test(expected = ExistStorageException.class)
    public void saveWithExistResume() {
        Resume r1 = new Resume("uuid3");
        storage.save(r1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete("uuid3");
        storage.get("uuid3");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistResume() {
        storage.delete("uuid4");
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Assert.assertEquals("uuid3", storage.get("uuid3").getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}