package com.urise.webapp.storage;

import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
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
    protected void saveResume(Resume resume, Object searchKey) {
        if (counter == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveTargetResume(resume, (Integer) searchKey);
        counter++;
    }

    @Override
    protected Resume returnResume(Object searchKey) {//ok
        return storage[(Integer) searchKey];
    }

    @Override
    protected void deleteResume(Object searchKey) {
        deleteTargetResume((Integer) searchKey);
        storage[counter - 1] = null;
        counter--;
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        return (Integer) searchKey >= 0;
    }


    protected abstract void saveTargetResume(Resume resume, int searchKey);

    protected abstract void deleteTargetResume(int searchKey);

    protected abstract Integer searchUuid(String uuid);
}
