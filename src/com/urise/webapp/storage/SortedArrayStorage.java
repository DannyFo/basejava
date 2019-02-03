package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {


    protected void deleteTargetResume(int foundIndex) {
        int movePosition = counter - foundIndex - 1;
        if (movePosition > 0) {
            System.arraycopy(storage, (foundIndex + 1), storage, foundIndex, movePosition);
        }
    }

    protected void saveTargetResume(Resume r, int foundIndex) {
        int saveIndex = -foundIndex - 1;
        System.arraycopy(storage, saveIndex, storage, (saveIndex + 1), counter - saveIndex);
        storage[saveIndex] = r;
    }

    @Override
    protected int searchUuid(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, counter, searchKey);
    }
}
