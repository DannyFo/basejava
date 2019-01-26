package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int counter = 0;

    public Resume[] storage = new Resume[10_000];

    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    public void save(Resume r) {
        if (counter == storage.length) {
            System.out.println("storage is full");
        } else if (searchUuid(r.getUuid()) == -1) {
            storage[counter] = r;
            counter++;
        } else {
            System.out.println("resume is already exist");
        }
    }

    public Resume get(String uuid) {
        int i = searchUuid(uuid);
        if (i == -1) {
            System.out.println("no resume found");
            return null;
        }
        return storage[i];
    }

    public void delete(String uuid) {
        if (searchUuid(uuid) == -1) {
            System.out.println("no resume found");
        } else {
            for (int b = 0; b < counter; b++) {
                if (uuid == storage[b].getUuid()) {
                    storage[b] = storage[counter - 1];
                    storage[counter - 1] = null;
                    counter--;
                }
            }
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

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, counter);
    }

    public int size() {
        return counter;
    }

    private int searchUuid(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}