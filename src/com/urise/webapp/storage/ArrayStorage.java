package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int counter = 0;
    int i;


    Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void save(Resume r) {
        if (counter == 10000) {
            System.out.println("storage is full");
        } else if (searchUuid(r.getUuid()) == -1) {
            System.out.println("no resume found");
            storage[counter] = r;
            counter++;
        }
    }

    public Resume get(String uuid) {
        if (searchUuid(uuid) == -1) {
            System.out.println("no resume found");
            return null;
        }
        return storage[searchUuid(uuid)];
    }

    public void delete(String uuid) {
        if (searchUuid(uuid) == -1) {
            System.out.println("no resume found");
        } else {
            int startIndex = searchUuid(uuid);
            storage[startIndex] = null;
            for (int b = startIndex; b < counter; b++) {
                storage[b] = storage[b + 1];
            }
        }
        counter--;
    }

    public void update(Resume r) {
        if (searchUuid(r.getUuid()) == -1) {
            System.out.println("no resume found");
        } else {
            Resume resumeToUpdate = new Resume();
            r = resumeToUpdate;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    public int size() {
        return counter;
    }

    int searchUuid(String uuid) {
        for (i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
