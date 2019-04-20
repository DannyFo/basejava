package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage<SK> implements Storage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public void save(Resume resume) {
        LOG.info("Save "+resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        saveResume(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get "+uuid);
        SK searchKey = getExistedSearchKey(uuid);
        return returnResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete "+uuid);
        SK searchKey = getExistedSearchKey(uuid);
        deleteResume(searchKey);
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update "+resume);
        SK searchKey = getExistedSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted ");
        List<Resume> allSortedList = getList();
        allSortedList.sort(RESUME_COMPARATOR);
        return allSortedList;
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = searchUuid(uuid);
        if (!validForExistResume(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = searchUuid(uuid);
        if (validForExistResume(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }


    protected abstract SK searchUuid(String uuid);

    protected abstract boolean validForExistResume(SK searchKey);

    protected abstract void saveResume(Resume resume, SK searchKey);

    protected abstract Resume returnResume(SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract void updateResume(SK searchKey, Resume resume);

    protected abstract List<Resume> getList();
}