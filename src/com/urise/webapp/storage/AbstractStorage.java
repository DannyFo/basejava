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
        Object searchKey = searchUuid(r.getUuid());
        if (validForExistResume(searchKey)) {//>= 0
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r, searchKey);
        }
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = searchUuid(uuid);
        if (validForNotExistResume(searchKey)) {//< 0
            throw new NotExistStorageException(uuid);
        }
        return returnResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = searchUuid(uuid);
        if (validForNotExistResume(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(searchKey);
        }
    }

    @Override
    public void update(Resume r) {
        Object searchKey = searchUuid(r.getUuid());
        if (validForNotExistResume(searchKey)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(searchKey, r);
        }
    }

    @Override
    public abstract Resume[] getAll();

    @Override
    public abstract int size();


    protected abstract Object searchUuid(String uuid);

    protected abstract boolean validForExistResume(Object searchKey);

    protected abstract boolean validForNotExistResume(Object searchKey);

    protected abstract void saveResume(Resume r, Object searchKey);

    protected abstract Resume returnResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract Resume updateResume(Object searchKey, Resume r);
}