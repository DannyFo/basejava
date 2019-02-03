package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected int counter = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    @Override
    public void update(Resume r) {
        int foundIndex = searchUuid(r.getUuid());
        if (foundIndex < 0) {
            System.out.println("no resume found");
        } else {
            storage[foundIndex] = r;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public Resume get(String uuid) {
        int foundIndex = searchUuid(uuid);
        if (foundIndex < 0) {
            System.out.println("no resume found");
            return null;
        }
        return storage[foundIndex];
    }


    protected abstract int searchUuid(String uuid);
}
