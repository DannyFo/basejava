package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;


public class ListStorage extends AbstractStorage {


    ArrayList<Resume> listStorage = new ArrayList();

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
    protected int searchUuid(String uuid) {
        for (Resume r : listStorage)
            if (r.getUuid().equals(uuid))
                return listStorage.indexOf(r);
        return -1;
    }

    @Override
    protected boolean storageOverflow() {
        return false;
    }

    @Override
    protected void saveResume(Resume r, int foundIndex) {
        listStorage.add(r);
    }

    @Override
    protected Resume returnResume(int foundIndex) {
        return listStorage.get(foundIndex);
    }

    @Override
    protected void deleteResume(int foundIndex) {
        listStorage.remove(foundIndex);
    }

    @Override
    protected Resume updateResume(int foundIndex, Resume r) {
        return listStorage.set(foundIndex, r);
    }
}
