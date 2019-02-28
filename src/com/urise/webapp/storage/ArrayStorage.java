
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteTargetResume(int searchKey) {
        storage[searchKey] = storage[counter - 1];
    }

    @Override
    protected void saveTargetResume(Resume r, int searchKey) {
        storage[counter] = r;
    }

    @Override
    protected Object searchUuid(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}