package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10_000;

    protected int counter = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void save(Resume r) {
        if (counter == STORAGE_LIMIT) {
            System.out.println("storage is full");
        } else if (searchUuid(r.getUuid()) == - 1) {
            storage[counter] = r;
            counter++;
        } else {
            System.out.println("resume is already exist");
        }
    }

    public void update(Resume r) {
        int i = searchUuid(r.getUuid());
        if (i == -1) {
            System.out.println("no resume found");
        } else {
            storage[i] = r;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    public int size() {
        return counter;
    }

    public Resume get(String uuid) {
        int i = searchUuid(uuid);
        if (i == -1) {
            System.out.println("no resume found");
            return null;
        }
        return storage[i];
    }

    protected abstract int searchUuid(String uuid);
}
