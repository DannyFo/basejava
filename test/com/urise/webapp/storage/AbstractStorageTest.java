package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String DUMMY = "uuid4";//для проверок

    private static final Resume RESUME_1 = new Resume(UUID_1, "b");
    private static final Resume RESUME_2 = new Resume(UUID_2, "a");
    private static final Resume RESUME_3 = new Resume(UUID_3, "b");

    protected static final Resume NOT_SAVED_TEST_RESUME = new Resume(DUMMY, "z");//для проверок

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume r1 = new Resume(UUID_3, "b");
        storage.update(r1);
        Assert.assertSame(storage.get(UUID_3), r1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResume() {
        storage.update(NOT_SAVED_TEST_RESUME);
    }

    @Test
    public void getAllSorted() {
        Assert.assertEquals(Arrays.asList(RESUME_2,RESUME_1,RESUME_3), storage.getAllSorted());
        Assert.assertEquals(3, storage.getAllSorted().size());
    }

    @Test
    public void save() {
        storage.save(NOT_SAVED_TEST_RESUME);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(NOT_SAVED_TEST_RESUME, storage.get(DUMMY));
    }

    @Test(expected = ExistStorageException.class)
    public void saveWithExistResume() {
        storage.save(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistResume() {
        storage.delete(DUMMY);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME_3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}