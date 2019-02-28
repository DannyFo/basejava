package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteTargetResume(int searchKey) {
        int movePosition = counter - searchKey - 1;
        if (movePosition > 0) {
            System.arraycopy(storage, (searchKey + 1), storage, searchKey, movePosition);
        }
    }

    @Override
    protected void saveTargetResume(Resume r, int searchKey) {
        int saveIndex = -searchKey - 1;
        System.arraycopy(storage, saveIndex, storage, (saveIndex + 1), counter - saveIndex);
        storage[saveIndex] = r;
    }

    @Override
    protected Object searchUuid(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, counter, searchKey);
    }
}
