package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import java.util.Comparator;
import java.util.List;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {

    private static final Comparator<Resume> RESUME_COMPARATOR_BY_FULLNAME = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        saveResume(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return returnResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        deleteResume(searchKey);
    }

    @Override
    public void update(Resume resume) {
        Object searchKey = getExistedSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public List<Resume> getAllSorted(){
        List<Resume> allSortedList = getList();
        allSortedList.sort(RESUME_COMPARATOR_BY_FULLNAME);
        return allSortedList;
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = searchUuid(uuid);
        if (!validForExistResume(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = searchUuid(uuid);
        if (validForExistResume(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }


    protected abstract Object searchUuid(String uuid);

    protected abstract boolean validForExistResume(Object searchKey);

    protected abstract void saveResume(Resume resume, Object searchKey);

    protected abstract Resume returnResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract List<Resume> getList();
}