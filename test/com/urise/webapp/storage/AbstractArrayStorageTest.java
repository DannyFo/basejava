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
    private static final Resume NOT_SAVED_TEST_RESUME = new Resume(DUMMY,"z");//для проверок

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {// надо делать с этим конструктором: public Resume(String uuid, String fullName)
        storage.save(new Resume(UUID_1, "b"));
        storage.save(new Resume(UUID_2, "a"));
        storage.save(new Resume(UUID_3, "b"));
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
        Resume r1 = new Resume(UUID_3,"b");
        storage.update(r1);
        Assert.assertSame(storage.get(UUID_3), r1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResume() {
        storage.update(NOT_SAVED_TEST_RESUME);
    }

    @Test
    public void getAllSorted() { // надо делать с этим конструктором: public Resume(String uuid, String fullName)
        Resume[] array = new Resume[]{
            new Resume(UUID_2, "a"),
            new Resume(UUID_1, "b"),
            new Resume(UUID_3, "b")};
        Assert.assertArrayEquals(array, storage.getAllSorted().toArray());
        Assert.assertEquals(3, storage.getAllSorted().size());
    }

    @Test
    public void save() {
        storage.save(NOT_SAVED_TEST_RESUME);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(new Resume(DUMMY,"z"), storage.get(DUMMY));
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
        Resume r1 = new Resume(UUID_3, "b");
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
        Assert.assertEquals(new Resume(UUID_3, "b"), storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }
}