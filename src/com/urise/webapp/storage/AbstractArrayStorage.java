package com.urise.webapp.storage;

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

    protected abstract int searchUuid(String uuid);

    @Override
    protected boolean storageOverflow() {
        if (counter == STORAGE_LIMIT) {
            return true;
        }
        return false;
    }

    @Override
    protected void saveResume(Resume r, int foundIndex) {
        saveTargetResume(r, foundIndex);
        counter++;
    }

    @Override
    protected Resume returnResume(int foundIndex) {
        return storage[foundIndex];
    }

    @Override
    protected void deleteResume(int foundIndex) {
        deleteTargetResume(foundIndex);
        storage[counter - 1] = null;
        counter--;
    }

    protected Resume updateResume(int foundIndex, Resume r) {
        return storage[foundIndex] = r;
    }

    protected abstract void saveTargetResume(Resume r, int foundIndex);

    protected abstract void deleteTargetResume(int foundIndex);


}
