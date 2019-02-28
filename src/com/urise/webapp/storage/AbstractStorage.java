package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    @Override
    public abstract void clear();

    @Override
    public void save(Resume r) {
        int foundIndex = searchUuid(r.getUuid());
        if (foundIndex >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r, foundIndex);
        }
    }

    @Override
    public Resume get(String uuid) {
        int foundIndex = searchUuid(uuid);
        if (foundIndex < 0) {
            throw new NotExistStorageException(uuid);
        }
        return returnResume(foundIndex, uuid);
    }

    @Override
    public void delete(String uuid) {
        int foundIndex = searchUuid(uuid);
        if (foundIndex < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(foundIndex, uuid);
        }
    }

    @Override
    public void update(Resume r) {
        int foundIndex = searchUuid(r.getUuid());
        if (foundIndex < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(foundIndex, r);
        }
    }

    @Override
    public abstract Resume[] getAll();

    @Override
    public abstract int size();


    protected abstract int searchUuid(String uuid);

    protected abstract void saveResume(Resume r, int foundIndex);

    protected abstract Resume returnResume(int foundIndex, String uuid);

    protected abstract void deleteResume(int foundIndex, String uuid);

    protected abstract Resume updateResume(int foundIndex, Resume r);
}