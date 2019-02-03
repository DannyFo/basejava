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
    public void save(Resume r) {
        int foundIndex = searchUuid(r.getUuid());
        if (counter == STORAGE_LIMIT) {
            System.out.println("storage is full");
        } else if (foundIndex > 0) {
            System.out.println("resume is already exist");
        } else {
            saveTargetResume(r, foundIndex);
            counter++;
        }
    }

    @Override
    public void delete(String uuid) {
        int foundIndex = searchUuid(uuid);
        if (foundIndex < 0) {
            System.out.println("no resume found");
        } else {
            deleteTargetResume(foundIndex);
            storage[counter - 1] = null;
            counter--;
        }
    }

    protected abstract void saveTargetResume(Resume r, int foundIndex);

    protected abstract void deleteTargetResume(int foundIndex);

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
