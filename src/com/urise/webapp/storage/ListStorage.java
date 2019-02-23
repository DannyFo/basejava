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
    protected int searchUuid(String uuid) {
        for (int counter = 0; counter < listStorage.size(); counter++) {
            if (listStorage.get(counter).getUuid().equals(uuid)) {
                return counter;
            }
        }
        return -1;
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
