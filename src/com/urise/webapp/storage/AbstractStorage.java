package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.List;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    @Override
    public abstract void clear();

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistedKey(r.getUuid());
        saveResume(r, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistedKey(uuid);
        return returnResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistedKey(uuid);
        deleteResume(searchKey);
    }

    @Override
    public void update(Resume r) {
        Object searchKey = getExistedKey(r.getUuid());
        updateResume(searchKey, r);
    }

    @Override
    public abstract List<Resume> getAllSorted();

    @Override
    public abstract int size();

//    @Override
//    public Resume getByFullName(String fullName){//НОВЫЙ МЕТОД но он мне видимо пока не нужен!
//        Object searchKey = searchFullName(fullName);
//        return returnResume(searchKey);
//    }

    private Object getExistedKey(String uuid) {
        Object searchKey = searchUuid(uuid);
        if (!validForExistResume(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedKey(String uuid) {
        Object searchKey = searchUuid(uuid);
        if (validForExistResume(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }


    protected abstract Object searchUuid(String uuid);

//    protected abstract Object searchFullName(String fullName);

    protected abstract boolean validForExistResume(Object searchKey);

    protected abstract void saveResume(Resume r, Object searchKey);

    protected abstract Resume returnResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract void updateResume(Object searchKey, Resume r);
}