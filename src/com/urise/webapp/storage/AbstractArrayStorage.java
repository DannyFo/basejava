package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10_000;

    protected int counter = 0;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, counter, null);
        counter = 0;
    }

    @Override
    protected List<Resume> getList() {
        return Arrays.asList(Arrays.copyOf(storage, counter));
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    protected void saveResume(Resume resume, Integer searchKey) {
        if (counter == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveTargetResume(resume, searchKey);
        counter++;
    }

    @Override
    protected Resume returnResume(Integer searchKey) {//ok
        return storage[searchKey];
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        deleteTargetResume(searchKey);
        storage[counter - 1] = null;
        counter--;
    }

    @Override
    protected void updateResume(Integer searchKey, Resume resume) {
        storage[searchKey] = resume;
    }

    @Override
    protected boolean validForExistResume(Integer searchKey) {
        return searchKey >= 0;
    }


    protected abstract void saveTargetResume(Resume resume, int searchKey);

    protected abstract void deleteTargetResume(int searchKey);

    protected abstract Integer searchUuid(String uuid);
}
