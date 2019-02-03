package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteTargetResume(int foundIndex) {
        storage[foundIndex] = storage[counter - 1];
    }

    @Override
    protected void saveTargetResume(Resume r, int foundIndex) {
        storage[counter] = r;
    }

    @Override
    protected int searchUuid(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
