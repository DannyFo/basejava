package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected int counter = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
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
    protected void saveResume(Resume r, Object searchKey) {
        if (counter == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        saveTargetResume(r, (int) searchKey);
        counter++;
    }

    @Override
    protected Resume returnResume(Object searchKey) {//ok
        return storage[(int) searchKey];
    }

    @Override
    protected void deleteResume(Object searchKey) {
        deleteTargetResume((int) searchKey);
        storage[counter - 1] = null;
        counter--;
    }

    protected Resume updateResume(Object searchKey, Resume r) {
        return storage[(int) searchKey] = r;
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        if ((int) searchKey >= 0) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean validForNotExistResume(Object searchKey) {
        if ((int) searchKey < 0) {
            return true;
        }
        return false;
    }

    protected abstract void saveTargetResume(Resume r, int searchKey);

    protected abstract void deleteTargetResume(int searchKey);

    protected abstract Object searchUuid(String uuid);
}
