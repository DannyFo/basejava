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
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String DUMMY = "uuid4";//для проверок
    private static final Resume NOT_SAVED_TEST_RESUME = new Resume(DUMMY);//для проверок

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

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
        Resume r1 = new Resume(UUID_3);
        storage.update(r1);
        Assert.assertSame(storage.get(UUID_3), r1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResume() {
        storage.update(NOT_SAVED_TEST_RESUME);
    }

    @Test
    public void getAll() {
        Resume[] array = new Resume[]{
                new Resume("uuid1"),
                new Resume("uuid2"),
                new Resume("uuid3")};
        System.out.println("\nGet All");
        for (Resume r : storage.getAll()) {
            System.out.println(r);
        }
        Assert.assertArrayEquals(array, storage.getAll());
        Assert.assertEquals(3, storage.getAll().length);
    }

    @Test
    public void save() {
        storage.save(NOT_SAVED_TEST_RESUME);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(new Resume(DUMMY), storage.get(DUMMY));
    }

    @Test(expected = StorageException.class)
    public void saveWithOverflow() {
        clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume(i + "uuid"));
            }
        } catch (StorageException e) {
            Assert.fail("Storage Overflow");
        }
        storage.save(NOT_SAVED_TEST_RESUME);
    }

    @Test(expected = ExistStorageException.class)
    public void saveWithExistResume() {
        Resume r1 = new Resume(UUID_3);
        storage.save(r1);
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
        Assert.assertEquals(new Resume(UUID_3), storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}