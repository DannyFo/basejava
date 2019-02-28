package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;


public class ListStorage extends AbstractStorage {


    List<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    protected Object searchUuid(String uuid) {
        for (int counter = 0; counter < listStorage.size(); counter++) {
            if (listStorage.get(counter).getUuid().equals(uuid)) {
                return counter;
            }
        }
        return -1;
    }

    @Override
    protected boolean validForExistResume(Object searchKey) {
        if ((int) searchKey >= 0) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean validForNotExistResume(Object searchKey) {
        if ((int) searchKey < 0) {
            return true;
        }
        return false;
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        listStorage.add(r);
    }

    @Override
    protected Resume returnResume(Object searchKey) {
        return listStorage.get((int) searchKey);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        listStorage.remove((int) searchKey);
    }

    @Override
    protected Resume updateResume(Object searchKey, Resume r) {
        return listStorage.set((int) searchKey, r);
    }
}
