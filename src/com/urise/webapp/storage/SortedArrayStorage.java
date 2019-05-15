package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void deleteTargetResume(int searchKey) {
        int movePosition = counter - searchKey - 1;
        if (movePosition > 0) {
            System.arraycopy(storage, (searchKey + 1), storage, searchKey, movePosition);
        }
    }

    @Override
    protected void saveTargetResume(Resume resume, int searchKey) {
        int saveIndex = -searchKey - 1;
        System.arraycopy(storage, saveIndex, storage, (saveIndex + 1), counter - saveIndex);
        storage[saveIndex] = resume;
    }

    @Override
    protected Integer searchUuid(String uuid) {
        Resume searchKey = new Resume(uuid,"fullName");
        return Arrays.binarySearch(storage, 0, counter, searchKey, RESUME_COMPARATOR);
    }

}