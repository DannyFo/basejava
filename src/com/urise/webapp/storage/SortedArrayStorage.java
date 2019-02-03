package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void delete(String uuid) {
        int foundIndex = searchUuid(uuid);
        if (foundIndex < 0) {
            System.out.println("no resume found");
        } else {
            for (int b = foundIndex; b < counter + 1; b++) {
                storage[b] = storage[b + 1];
            }
            counter--;
        }

    }

    @Override
    public void save(Resume r) {
        int foundIndex = -searchUuid(r.getUuid()) - 1;
        if (counter == STORAGE_LIMIT) {
            System.out.println("storage is full");
        } else if (foundIndex >= 0) {
            if (foundIndex >= counter) {
                storage[counter] = r;
            } else {
                System.arraycopy(storage, foundIndex, storage, (foundIndex + 1), counter - foundIndex);
                storage[foundIndex] = r;
            }
        } else {
            System.out.println("resume is already exist");
        }
        counter++;
    }

    @Override
    protected int searchUuid(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, counter, searchKey);
    }
}
