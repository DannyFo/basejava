package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void delete(String uuid) {
        int foundIndex = searchUuid(uuid);
        if (foundIndex == -1) {
            System.out.println("no resume found");
        } else {
            storage[foundIndex] = storage[counter - 1];
            storage[counter - 1] = null;
            counter--;
        }
    }

    @Override
    public void save(Resume r) {
        if (counter == STORAGE_LIMIT) {
            System.out.println("storage is full");
        } else if (searchUuid(r.getUuid()) == -1) {
            storage[counter] = r;
            counter++;
        } else {
            System.out.println("resume is already exist");
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */

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
