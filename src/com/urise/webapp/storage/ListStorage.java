package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;


public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    protected List<Resume> getList() {
        return new ArrayList<>(listStorage);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    protected Integer searchUuid(String uuid) {
        for (int counter = 0; counter < listStorage.size(); counter++) {
            if (listStorage.get(counter).getUuid().equals(uuid)) {
                return counter;
            }
        }
        return -1;
    }

    @Override
    protected boolean validForExistResume(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    protected void saveResume(Resume resume, Integer searchKey) {
        listStorage.add(resume);
    }

    @Override
    protected Resume returnResume(Integer searchKey) {
        return listStorage.get(searchKey);
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        listStorage.remove((searchKey).intValue());
    }

    @Override
    protected void updateResume(Integer searchKey, Resume resume) {
        listStorage.set(searchKey, resume);
    }
}
