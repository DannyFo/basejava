package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void delete(String uuid) {
        int i = searchUuid(uuid);
        if (i == -1) {
            System.out.println("no resume found");
        } else {
            int startIndex = searchUuid(uuid);
            storage[startIndex] = null;
            for (int b = startIndex; b < counter; b++) {
                storage[b] = storage[b + 1];
            }
            counter--;
        }

    }

    public void save(Resume r) {
        int b = -searchUuid(r.getUuid());
        if (counter == STORAGE_LIMIT) {
            System.out.println("storage is full");
        } else if (b > 0) {
            if (b >= counter) {
                storage[counter] = r;
            } else if (b < counter) {
                Resume[] SecondHalfStorage = storage;
                System.arraycopy(storage, b, SecondHalfStorage, (b + 1), (counter - b));
                SecondHalfStorage[b] = r;
                storage = SecondHalfStorage;
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
